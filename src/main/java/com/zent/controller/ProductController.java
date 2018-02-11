package com.zent.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.Category;
import com.zent.entity.Product;
import com.zent.service.CategoryDAO;
import com.zent.service.ProductDAO;

import com.zent.util.Constants;
import com.zent.util.DBConnection;
import com.zent.util.FileUtil;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/product-manager")
@MultipartConfig
public class ProductController extends HttpServlet {
	public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	private static final long serialVersionUID = 1L;
	private static String UPLOAD_FOLDER_PATH;
	private static String INSER_OR_EDIT = "/dashboard-page/product_cu.jsp";
	private static String SEARCH = "/dashboard-page/product.jsp";
	private ProductDAO dao;
	private CategoryDAO categoryDAO;

	/**
	 * @throws IOException
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() throws IOException {
		super();
		dao = new ProductDAO();
		InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		UPLOAD_FOLDER_PATH = properties.getProperty("path");
		categoryDAO = new CategoryDAO();
		HttpSession session;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ss = request.getSession();
		if (ss.getAttribute("username") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			// list category
			request.setAttribute("categoryP", categoryDAO.getAll());
			// list product
			request.setAttribute("listproduct", dao.getAll());
			String forward = "";
			String action = request.getParameter("action");
			if (action.equalsIgnoreCase("delete")) {
				Long productId = Long.parseLong(request.getParameter("id"));
				Product c = new Product();
				c.setProductId(productId);
				dao.delete(c);
				response.sendRedirect(request.getContextPath() + "/product-manager?action=search&page=1");
				return;
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSER_OR_EDIT;
				Long productId = Long.parseLong(request.getParameter("id"));
				Product c = dao.getById(productId);
				request.setAttribute("product", c);
			} else if (action.equalsIgnoreCase("search")) {
				forward = SEARCH;
				Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page"))
						: 1;
				Product c = new Product();

				setSearchList(request, page, c);
			} else {
				forward = INSER_OR_EDIT;
			}

			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		Product p = new Product();

		String categoryId = request.getParameter("categoryId");
		CategoryDAO categoryDAO = new CategoryDAO();

		List<Category> listCategory = categoryDAO.getAll();
		for (Category category : listCategory) {
			if (category.getName().equalsIgnoreCase(categoryId)) {
				p.setCategoryId(category.getCategoryId());
			}
		}

		p.setName(request.getParameter("name"));
		p.setCode(request.getParameter("code"));
		if (request.getParameter("quantity") != null && request.getParameter("quantity").trim() != "") {
			p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		}
		if (request.getParameter("price") != null && request.getParameter("price").trim() != "") {
			p.setPrice(Long.parseLong(request.getParameter("price")));
		}

		p.setDescription(request.getParameter("description"));

		/* upload file */
		FileUtil fileUtil = new FileUtil();
		String fullPath = fileUtil.uploadFile(request, UPLOAD_FOLDER_PATH, "image");

		/* p.setImage(request.getParameter("image")); */
		//

		p.setSize(request.getParameter("size"));

		if (action.equalsIgnoreCase("save")) {
			String productId = request.getParameter("id");
			/* upload file */
			String image = "";
			if (!fullPath.isEmpty()) {
				image = "images/" + new File(fullPath).getName();
			}
			p.setImage(image);
			//

			if (productId == null || productId.isEmpty()) {
				dao.insert(p);
			} else {
				p.setProductId(Long.parseLong(productId));
				dao.update(p);
			}
			response.sendRedirect(request.getContextPath() + "/product-manager?action=search&page=1");
		} else if (action.equalsIgnoreCase("search")) {
			HttpSession session = request.getSession();
			String foward = SEARCH;

			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			session.setAttribute("pageIndex", page);

			setSearchList(request, page, p);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, Integer page, Product c) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("products", dao.search(c, page, pageSize));

		Long count = dao.getCount(c);

		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / pageSize));
		request.setAttribute("count", count);

	}

}

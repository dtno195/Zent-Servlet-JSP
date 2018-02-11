package com.zent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.entity.Bill;
import com.zent.entity.Product;
import com.zent.service.CategoryDAO;
import com.zent.service.ProductDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class EcommerceController
 */
@WebServlet("/ecommerce")
public class EcommerceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
	private CategoryDAO categoryDao;
	private final String SEARCH = "/ecommerce/e-page/clothes-ecomerce.jsp";
	List<Product> listProduct = new ArrayList<Product>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EcommerceController() {
		super();
		dao = new ProductDAO();
		categoryDao = new CategoryDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		request.setAttribute("listproduct", dao.getAll());
		request.setAttribute("categoryDao", categoryDao.getAll());
		if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			Product pro = new Product();
			setSearchList(request, page, pro);
			request.getRequestDispatcher(foward).forward(request, response);
		} else if (action.equalsIgnoreCase("searchCategory")) {
			String foward = SEARCH;
			String categoryId = request.getParameter("categoryId");
			CategoryDAO categoryDAO = new CategoryDAO();
			Product p = new Product();
			p.setCategoryId(Long.parseLong(categoryId));
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, p);
			request.getRequestDispatcher(foward).forward(request, response);
		} else {
			request.getRequestDispatcher("ecommerce/e-page/clothes-ecomerce.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Product pro = new Product();
		pro.setName(request.getParameter("name"));
		pro.setCode(request.getParameter("code"));
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, pro);
			request.getRequestDispatcher(foward).forward(request, response);
		}

	}

	private void setSearchList(HttpServletRequest request, Integer page, Product c) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("proEco", dao.search(c, page, pageSize));

		Long count = dao.getCount(c);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);

	}

}

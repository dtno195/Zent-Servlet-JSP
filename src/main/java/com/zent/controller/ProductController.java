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

import com.zent.entity.Product;
import com.zent.service.ProductDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/product-manager")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/pages/product_cu.jsp";
	private static String SEARCH = "/pages/product.jsp";
	private ProductDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		dao = new ProductDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
//		List<Role> list = dao.getAll();
//		request.setAttribute("listRole", list);
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
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			Product c = new Product();
			setSearchList(request, page, c);
		} else {
			forward = INSER_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		Product c = new Product();
		c.setName(request.getParameter("name"));
		c.setDescription(request.getParameter("description"));
		if(action.equalsIgnoreCase("save")) {
			String productId = request.getParameter("id");
			if(productId == null || productId.isEmpty()) {
				dao.insert(c);
			}else {
				c.setProductId(Long.parseLong(productId));
				dao.update(c);
			}
			response.sendRedirect(request.getContextPath()+"/product-manager?action=search&page=1");
		}
		else if(action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer
					.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, c);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, Integer page,Product c) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("products", dao.search(c, page, pageSize));
		
		Long count = dao.getCount(c);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString())/Constants.PAGE_SIZE));
		request.setAttribute("count", count);
		
	}

}

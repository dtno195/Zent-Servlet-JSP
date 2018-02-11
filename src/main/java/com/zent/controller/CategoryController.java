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

import com.zent.entity.Category;
import com.zent.service.CategoryDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/category-manager")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/dashboard-page/category_cu.jsp";
	private static String SEARCH = "/dashboard-page/category.jsp";
	private CategoryDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
		super();
		dao = new CategoryDAO();
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
			String forward = "";
			String action = request.getParameter("action");
			// List<Role> list = dao.getAll();
			// request.setAttribute("listRole", list);
			if (action.equalsIgnoreCase("delete")) {
				Long categoryId = Long.parseLong(request.getParameter("id"));
				Category c = new Category();
				c.setCategoryId(categoryId);
				dao.delete(c);
				response.sendRedirect(request.getContextPath() + "/category-manager?action=search&page=1");
				return;
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSER_OR_EDIT;
				Long categoryId = Long.parseLong(request.getParameter("id"));
				Category c = dao.getById(categoryId);
				request.setAttribute("category", c);
			} else if (action.equalsIgnoreCase("search")) {
				forward = SEARCH;
				Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page"))
						: 1;
				Category c = new Category();
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
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		Category c = new Category();
		c.setName(request.getParameter("name"));
		c.setDescription(request.getParameter("description"));
		if (action.equalsIgnoreCase("save")) {
			String categoryId = request.getParameter("id");
			if (categoryId == null || categoryId.isEmpty()) {
				dao.insert(c);
			} else {
				c.setCategoryId(Long.parseLong(categoryId));
				dao.update(c);
			}
			response.sendRedirect(request.getContextPath() + "/category-manager?action=search&page=1");
		} else if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, c);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, Integer page, Category c) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("categorys", dao.search(c, page, pageSize));

		Long count = dao.getCount(c);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);

	}

}

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

import com.zent.entity.User;
import com.zent.service.UserDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user-manager")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/pages/user_cu.jsp";
	private static String SEARCH = "/pages/user.jsp";
	private UserDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		dao = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			Long userId = Long.parseLong(request.getParameter("id"));
			User user = new User();
			user.setUserId(userId);
			dao.delete(user);
			response.sendRedirect(request.getContextPath() + "user-manager?action=search&page=1");
			return;

		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSER_OR_EDIT;
			Long userId = Long.parseLong(request.getParameter("id"));
			User user = dao.getById(userId);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("search")) {
			forward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			User user = new User();
			setSearchList(request, user, page);
		}else {
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
		doGet(request, response);
	}
	private void setSearchList(HttpServletRequest request,User user,Integer page) {
		String keyword = request.getParameter("search");
		request.setAttribute("users", dao.search(keyword, page));
		Long count = dao.getCount(keyword);
		request.setAttribute("page",Math.ceil(Double.parseDouble(count.toString())/Constants.PAGE_SIZE));
	}

}

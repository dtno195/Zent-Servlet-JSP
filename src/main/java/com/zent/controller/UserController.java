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

import com.zent.entity.Role;
import com.zent.entity.User;
import com.zent.service.RoleDAO;
import com.zent.service.UserDAO;
import com.zent.util.Constants;
import com.zent.util.SecurityUtil;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user-manager")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/dashboard-page/user_cu.jsp";
	private static String SEARCH = "/dashboard-page/user.jsp";
	private UserDAO dao;
	private RoleDAO roleDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		dao = new UserDAO();
		roleDAO = new RoleDAO();
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
			request.setAttribute("listRole", roleDAO.getAll());
			String forward = "";
			String action = request.getParameter("action");
			// List<User> list = dao.getAll();
			// request.setAttribute("listUser", list);
			if (action.equalsIgnoreCase("delete")) {
				Long userId = Long.parseLong(request.getParameter("id"));
				User user = new User();
				user.setUserId(userId);
				dao.delete(user);
				response.sendRedirect(request.getContextPath() + "/user-manager?action=search&page=1");
				return;
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSER_OR_EDIT;
				Long userId = Long.parseLong(request.getParameter("id"));
				User user = dao.getById(userId);
				request.setAttribute("user", user);
			} else if (action.equalsIgnoreCase("search")) {
				forward = SEARCH;
				Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page"))
						: 1;
				request.setAttribute("pageNumber", page);
				User user = new User();
				setSearchList(request, user, page);
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
		String action = request.getParameter("action");
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setFullName(request.getParameter("fullName"));
		String roleName = request.getParameter("roleId");
		List<Role> listRole = roleDAO.getAll();
		for (Role role : listRole) {
			if (role.getName().equalsIgnoreCase(roleName)) {
				user.setRoleId(role.getId());
			}
		}
		// user.setRoleId(Long.parseLong());
		if (action.equalsIgnoreCase("save")) {
			String userId = request.getParameter("id");
			user.setPassword(SecurityUtil.md5(request.getParameter("password")));
			if (userId == null || userId.isEmpty()) {
				dao.insert(user);
			} else {
				user.setUserId(Long.parseLong(userId));
				dao.update(user);
			}
			response.sendRedirect(request.getContextPath() + "/user-manager?action=search&page=1");
		} else if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, user, page);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, User user, Integer pageNumber) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("listUser", dao.search(user, pageNumber, pageSize));
		Long count = dao.getCount(user);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);
	}

}

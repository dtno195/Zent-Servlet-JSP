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
import com.zent.service.RoleDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/role-manager")
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/dashboard-page/role_cu.jsp";
	private static String SEARCH = "/dashboard-page/role.jsp";
	private RoleDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleController() {
		super();
		dao = new RoleDAO();
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
				Long roleId = Long.parseLong(request.getParameter("id"));
				Role role = new Role();
				role.setId(roleId);
				dao.delete(role);
				response.sendRedirect(request.getContextPath() + "/role-manager?action=search&page=1");
				return;
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSER_OR_EDIT;
				Long roleId = Long.parseLong(request.getParameter("id"));
				Role role = dao.getById(roleId);
				request.setAttribute("role", role);
			} else if (action.equalsIgnoreCase("search")) {
				forward = SEARCH;
				Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page"))
						: 1;
				Role role = new Role();
				setSearchList(request, page, role);
			} else {
				forward = INSER_OR_EDIT;
			}

			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		Role role = new Role();
		role.setName(request.getParameter("name"));
		role.setDescription(request.getParameter("description"));
		String roleId = request.getParameter("id");
		if (action.equalsIgnoreCase("save")) {
			if (roleId == null || roleId.isEmpty()) {
				dao.insert(role);
			} else {
				role.setId(Long.parseLong(roleId));
				dao.update(role);
			}
			response.sendRedirect(request.getContextPath() + "/role-manager?action=search&page=1");
		} else if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, role);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, Integer page, Role role) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("roles", dao.search(role, page, pageSize));

		Long count = dao.getCount(role);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);

	}

}

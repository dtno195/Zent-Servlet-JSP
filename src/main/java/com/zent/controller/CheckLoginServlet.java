package com.zent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.entity.User;
import com.zent.service.UserDAO;
import com.zent.util.SecurityUtil;

import ch.qos.logback.core.joran.action.Action;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/login")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("dashboard-page/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("login")) {
			String username = request.getParameter("username");
			String password = SecurityUtil.md5(request.getParameter("password"));
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			UserDAO dao = new UserDAO();
			HttpSession httpSession = request.getSession();
			if (dao.checkLogin(user) == true) {
				httpSession.setAttribute("username", user);
				httpSession.setAttribute("roleId", dao.getRoleId(username));
				request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println(dao.getRoleId(username));
			} else {
				String message = "User account or password incorrect";
				request.setAttribute("msg", message);
			}
		}
		if (action.equalsIgnoreCase("logout")) {
			
			HttpSession ss = request.getSession();
			ss.removeAttribute("username");
			request.getRequestDispatcher("dashboard-page/login.jsp").forward(request, response);
		}

	}

}

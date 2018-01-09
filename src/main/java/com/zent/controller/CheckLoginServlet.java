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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		UserDAO dao = new UserDAO();
		if(dao.checkLogin(user)==true) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username", username);
			request.getRequestDispatcher("index.jsp").forward(request, response);;
		}
		else {
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}
	}

}

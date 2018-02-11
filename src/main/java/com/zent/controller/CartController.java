package com.zent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.zent.bean.Cart;
import com.zent.entity.Product;
import com.zent.entity.Role;
import com.zent.util.Constants;
import com.zent.util.SendMail;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart-controller")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/ecommerce/e-page/cart.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			String id = request.getParameter("id");
			List<Cart> listPro = (List<Cart>) session.getAttribute("cart");
			for (int i = 0; i < listPro.size(); i++) {
				if (listPro.get(i).getPro().getProductId() == Long.parseLong(id)) {
					listPro.remove(i);
				}
			}
			session.removeAttribute("cart");
			session.setAttribute("cart", listPro);
			response.sendRedirect(request.getContextPath() + "/cart-controller?action=search");
			return;
		} else if (action.equalsIgnoreCase("search")) {
			long sum = 0;
			List<Cart> listPro = (List<Cart>) session.getAttribute("cart");
			if (listPro != null) {
				for (int i = 0; i < listPro.size(); i++) {
					long price = listPro.get(i).getPro().getPrice();
					int quantityBuy = listPro.get(i).getQuantityBuy();
					sum += (price * quantityBuy);

				}
				long size = 1;
				session.setAttribute("size", size);
			}else {
				long size = 0;
				session.setAttribute("size", size);
			}
			session.setAttribute("sum", sum);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

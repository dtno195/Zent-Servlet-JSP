package com.zent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.bean.Cart;
import com.zent.entity.Product;
import com.zent.service.ProductDAO;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/product-detail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
	private List<Cart> listPro;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetail() {
		super();
		dao = new ProductDAO();
		listPro = new ArrayList<Cart>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Product pro = dao.getById(Long.parseLong(id));
		request.setAttribute("productId", pro);
		request.getRequestDispatcher("ecommerce/e-page/product-detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("addToCart")) {

			HttpSession session = request.getSession();
			String id = request.getParameter("id");
			Product pr = dao.getById(Long.parseLong(id));

			for (int i = 0; i < listPro.size(); i++) {
				if (listPro.get(i).getPro().getProductId() == Long.parseLong(id)) {
					int quantityBuy = listPro.get(i).getQuantityBuy();
					listPro.get(i).setQuantityBuy(quantityBuy + 1);
					session.setAttribute("cart", listPro);
					response.sendRedirect(request.getContextPath() + "/ecommerce?action=search&page=1");
					return;
				}
			}
			Cart cart = new Cart();
			cart.setPro(pr);
			int quantityBuy = cart.getQuantityBuy();
			cart.setQuantityBuy(quantityBuy + 1);
			listPro.add(cart);
			session.setAttribute("cart", listPro);
			response.sendRedirect(request.getContextPath() + "/ecommerce?action=search&page=1");
		}
		

	}

}

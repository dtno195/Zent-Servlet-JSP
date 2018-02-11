package com.zent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zent.entity.Product;
import com.zent.service.ProductDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class EcommercePageController
 */
@WebServlet("/EcommercePageController")
public class EcommercePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SEARCH = "/ecommerce/e-page/clothes-ecomerce-by-id.jsp";
	private ProductDAO dao;
	List<Product> listProduct = new ArrayList<Product>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EcommercePageController() {
        super();
        dao = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		Product pro = new Product();
		pro.setName(request.getParameter("name"));
		pro.setCode(request.getParameter("code"));
		if (action.equalsIgnoreCase("search")) {
			String foward =SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, pro);
			request.getRequestDispatcher(foward).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void setSearchList(HttpServletRequest request, Integer page, Product c) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("productId", dao.search(c, page, pageSize));

		Long count = dao.getCount(c);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);

	}

}

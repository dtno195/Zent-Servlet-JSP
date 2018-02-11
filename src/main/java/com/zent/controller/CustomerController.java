package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.entity.Customer;
import com.zent.service.CustomerDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/customer-manager")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/dashboard-page/customer_cu.jsp";
	private static String SEARCH = "/dashboard-page/customer.jsp";
	private CustomerDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		dao = new CustomerDAO();
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
			if (action.equalsIgnoreCase("delete")) {
				Long customerId = Long.parseLong(request.getParameter("id"));
				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				dao.delete(customer);
				response.sendRedirect(request.getContextPath() + "/customer-manager?action=search&page=1");
				return;
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSER_OR_EDIT;
				Long customerId = Long.parseLong(request.getParameter("id"));
				Customer customer = dao.getById(customerId);
				request.setAttribute("customer", customer);
			} else if (action.equalsIgnoreCase("search")) {
				forward = SEARCH;
				Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page"))
						: 1;
				Customer c = new Customer();
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
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));

		try {
			if (request.getParameter("date") != null) {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
				customer.setDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (action.equalsIgnoreCase("save")) {
			String customerId = request.getParameter("id");
			if (customerId == null || customerId.isEmpty()) {
				dao.insert(customer);
			} else {
				customer.setCustomerId(Long.parseLong(customerId));
				dao.update(customer);
			}
			response.sendRedirect(request.getContextPath() + "/customer-manager?action=search&page=1");
		} else if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, customer);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, Integer page, Customer customer) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("customers", dao.search(customer, page, pageSize));

		Long count = dao.getCount(customer);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);

	}

}

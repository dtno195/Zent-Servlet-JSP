package com.zent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zent.entity.Bill;
import com.zent.service.BillDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/bill-manager")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/pages/bill_cu.jsp";
	private static String SEARCH = "/pages/bill.jsp";
	private BillDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillController() {
		super();
		dao = new BillDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		// List<Role> list = dao.getAll();
		// request.setAttribute("listRole", list);
		if (action.equalsIgnoreCase("delete")) {
			Long billId = Long.parseLong(request.getParameter("id"));
			Bill b = new Bill();
			b.setBillId(billId);
			dao.delete(b);
			response.sendRedirect(request.getContextPath() + "/bill-manager?action=search&page=1");
			return;
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSER_OR_EDIT;
			Long billId = Long.parseLong(request.getParameter("id"));
			Bill b = dao.getById(billId);
			request.setAttribute("bill", b);
		} else if (action.equalsIgnoreCase("search")) {
			forward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			Bill c = new Bill();
			setSearchList(request, page, c);
		} else {
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
		String action = request.getParameter("action");
		Bill b = new Bill();
		if (request.getParameter("customerId") != null && request.getParameter("customerId").trim()!="") {
			Long customerId = Long.parseLong(request.getParameter("customerId"));
			b.setCustomerId(customerId);
		}

		if (request.getParameter("bill_date") != null && request.getParameter("bill_date").trim() !="") {

			try {
				Date billDate;
				billDate = new SimpleDateFormat("mm/dd/yyyy").parse(request.getParameter("bill_date"));
				b.setBillDate(billDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (request.getParameter("sum") != null && request.getParameter("sum").trim()!=null) {
			Long sum = Long.parseLong(request.getParameter("sum"));
			b.setSum(sum);
		}
		if (action.equalsIgnoreCase("save")) {
			String billId = request.getParameter("id");
			if (billId == null || billId.isEmpty()) {
				dao.insert(b);
			} else {
				b.setBillId(Long.parseLong(billId));
				dao.update(b);
			}
			response.sendRedirect(request.getContextPath() + "/bill-manager?action=search&page=1");
		} else if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, b);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, Integer page, Bill c) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("bills", dao.search(c, page, pageSize));

		Long count = dao.getCount(c);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);

	}

}

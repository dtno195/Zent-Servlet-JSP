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
import javax.servlet.http.HttpSession;

import com.zent.entity.BillDetail;
import com.zent.service.BillDetailDAO;
import com.zent.util.Constants;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/bill-detail-manager")
public class BillDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSER_OR_EDIT = "/pages/bill_detail_cu.jsp";
	private static String SEARCH = "/pages/bill_detail.jsp";
	private BillDetailDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillDetailController() {
		super();
		dao = new BillDetailDAO();
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
				Long billId = Long.parseLong(request.getParameter("id"));
				BillDetail b = new BillDetail();
				b.setBillId(billId);
				dao.delete(b);
				response.sendRedirect(request.getContextPath() + "/bill-detail-manager?action=search&page=1");
				return;
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSER_OR_EDIT;
				Long billId = Long.parseLong(request.getParameter("id"));
				BillDetail b = dao.getById(billId);
				request.setAttribute("billDetail", b);
			} else if (action.equalsIgnoreCase("search")) {
				forward = SEARCH;
				Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page"))
						: 1;
				BillDetail c = new BillDetail();
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
		BillDetail b = new BillDetail();
		if (request.getParameter("billId") != null && request.getParameter("billId").trim() != "") {
			Long billId = Long.parseLong(request.getParameter("billId"));
			b.setBillId(billId);
		}

		if (request.getParameter("productId") != null && request.getParameter("productId").trim() != "") {
			Long productId = Long.parseLong(request.getParameter("productId"));
			b.setProductId(productId);
		}
		if (request.getParameter("quantity") != null && request.getParameter("quantity").trim() != "") {
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			b.setQuantity(quantity);
		}
		if (action.equalsIgnoreCase("save")) {
			String billdetatilId = request.getParameter("id");
			if (billdetatilId == null || billdetatilId.isEmpty()) {
				dao.insert(b);
			} else {
				b.setBillId(Long.parseLong(billdetatilId));
				dao.update(b);
			}
			response.sendRedirect(request.getContextPath() + "/bill-detail-manager?action=search&page=1");
		} else if (action.equalsIgnoreCase("search")) {
			String foward = SEARCH;
			Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
			setSearchList(request, page, b);
			RequestDispatcher dispatcher = request.getRequestDispatcher(foward);
			dispatcher.forward(request, response);
		}
	}

	private void setSearchList(HttpServletRequest request, Integer page, BillDetail c) {
		Integer pageSize = Constants.PAGE_SIZE;
		request.setAttribute("billDetails", dao.search(c, page, pageSize));

		Long count = dao.getCount(c);
		if (count % pageSize != 0)
			count = (long) (Math.ceil(Double.parseDouble(count.toString()) / Constants.PAGE_SIZE));
		request.setAttribute("count", count);

	}

}

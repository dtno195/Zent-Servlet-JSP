package com.zent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.bean.Cart;
import com.zent.entity.Customer;
import com.zent.service.CustomerDAO;
import com.zent.util.ConvertUtil;
import com.zent.util.SendMail;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form-manager")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
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
		request.getRequestDispatcher("/ecommerce/e-page/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("mail");

		Customer c = new Customer();
		c.setName(name);
		c.setAddress(address);
		c.setPhone(phone);
		c.setEmail(email);
		Date date = new Date();
		c.setDate(date);
		
		if (action.equalsIgnoreCase("save")) {
			HttpSession ss = request.getSession();
			List<Cart> list = (List<Cart>) ss.getAttribute("cart");
			List<String> contend = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				String l = "" ;
				l+="<br>";
				Integer index = i+1;
				l+=index.toString();
				l+=",Product Name :";
				l+= list.get(i).getPro().getName();
				l+="&nbsp; Code : ";
				l+= list.get(i).getPro().getCode();
				l+="&nbsp; Price : ";
				l+= list.get(i).getPro().getPrice();
				l+=" $/1 product";
				l+="&nbsp; Quantity : ";
				l+=list.get(i).getQuantityBuy();
				l+="&nbsp;";
				l+="<br>";
				contend.add(l);
			}
			long sum = (long) ss.getAttribute("sum");
			
			CustomerDAO dao = new CustomerDAO();
			dao.insert(c);
			SendMail.sendMail(email, name, address, contend, phone,sum);
			out.println("Mail send successfully");
			response.sendRedirect(request.getContextPath() + "/ecommerce?action=search&page=1");
		}

	}

}

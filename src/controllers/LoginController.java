package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.accountDao;
import models.account;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	accountDao accDao = new accountDao();
	public LoginController() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String loginID = request.getParameter("loginID");
		String pass = request.getParameter("password");
		request.setAttribute("error", " ");
		request.setAttribute("loginID", loginID);
		request.setAttribute("pass", pass);
		
		account acc = accDao.findAccount(loginID, pass);
		
		if(acc != null) {
			System.out.println(acc);
		}else {System.out.println("0");}
		
		if(acc != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfor", acc);
			response.sendRedirect(request.getContextPath()+"/home");
		}
		else {
			request.setAttribute("error", "Thông tin đăng nhập không đúng!");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
	}
}

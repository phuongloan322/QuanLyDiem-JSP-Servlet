package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.accountDao;
import models.account;

public class SignupController extends HttpServlet{
	private static final long serialVersionID = 1L;
	public SignupController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		RequestDispatcher rd =  request.getRequestDispatcher("/views/signup.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		accountDao accDao = new accountDao();
		
		String loginID = request.getParameter("loginID");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int permission = 1;
		
		account findacc = accDao.findAccount(loginID);
		if(findacc == null) {
			account acc = new account(loginID, password, permission, name, password);
			int add = accDao.addAccount(acc);
			
			 if(add > 0) 
			 { 
				 response.sendRedirect(request.getContextPath()+"/login");
				 }
			 else { 
				 response.sendRedirect(request.getContextPath()+"/signup");
			 }
		}
		else {
			request.setAttribute("trungma", "Mã sinh viên đã tồn tại!");
			request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/signup");
			return;
		}
		
		 
	}
}

package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.namhocDao;
import models.NamHoc;

public class NamHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		namhocDao nkDao = new namhocDao();
		List<NamHoc> ds = nkDao.getAll();
		session.setAttribute("namhocList", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/namhoc.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maNH = request.getParameter("maNH");
		String tenNH = request.getParameter("tenNH");
		NamHoc namHoc = new NamHoc(maNH, tenNH);
		
		namhocDao nhDao = new namhocDao();
		int res = nhDao.addNK(namHoc);
		
		if(res > 0) {
			response.sendRedirect(request.getContextPath()+"/namhoc?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/namhoc?msg=ERROR");
			return;
		}
	}

}

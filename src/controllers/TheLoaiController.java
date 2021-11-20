package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.theloaiDao;
import models.TheLoai;

public class TheLoaiController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		theloaiDao tlDao = new theloaiDao();
		List<TheLoai> ds = tlDao.getAll();
		session.setAttribute("theloaiList", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/theloai.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maTL = request.getParameter("maTL");
		String tenTL = request.getParameter("tenTL");
		TheLoai theLoai = new TheLoai(maTL, tenTL);
		
		theloaiDao tlDao = new theloaiDao();
		int res = tlDao.addTL(theLoai);
		
		if(res > 0) {
			response.sendRedirect(request.getContextPath()+"/theloai?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/theloai?msg=ERROR");
			return;
		}
	}
}

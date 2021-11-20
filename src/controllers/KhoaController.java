package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.khoaDao;
import models.Khoa;

public class KhoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		khoaDao k = new khoaDao();
		List<Khoa> ds = k.getAll();
		session.setAttribute("khoaList", ds);

		RequestDispatcher rd = request.getRequestDispatcher("/views/khoa.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maKhoa = request.getParameter("maKhoa");
		String tenKhoa = request.getParameter("tenKhoa");
		String lienheKhoa = request.getParameter("lienheKhoa");
		Khoa k = new Khoa(maKhoa, tenKhoa, lienheKhoa);
		
		khoaDao kDao = new khoaDao();
		int res = kDao.addKhoa(k);
		if(res > 0) {
			response.sendRedirect(request.getContextPath()+"/khoa?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/khoa?msg=ERROR");
			return;
		}
	}
}

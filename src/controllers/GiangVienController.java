package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.giangvienDao;
import models.GiangVien;

public class GiangVienController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		giangvienDao gvDao = new giangvienDao();
		List<GiangVien> ds = gvDao.getAll();
		session.setAttribute("giangvienList", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/giangvien.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maGV = request.getParameter("maGV");
		String tenGV = request.getParameter("tenGV");
		String diachi = request.getParameter("diachi");
		int sdt = Integer.parseInt(request.getParameter("sdt"));
		
		String email = request.getParameter("email");
		
		GiangVien gv = new GiangVien(maGV, tenGV, diachi, sdt, email);
		
		giangvienDao gvDao = new giangvienDao();
		int res = gvDao.addGV(gv);
		
		if(res > 0) {
			response.sendRedirect(request.getContextPath()+"/giangvien?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/giangvien?msg=ERROR");
			return;
		}
	}
}

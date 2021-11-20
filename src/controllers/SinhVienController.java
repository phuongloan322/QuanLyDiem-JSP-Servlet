package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import daos.lopDao;
import daos.sinhvienDao;
import models.Khoa;
import models.Lop;
import models.SinhVien;

public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		sinhvienDao svDao = new sinhvienDao();
		List<SinhVien> ds = svDao.getAll();
		session.setAttribute("sinhvienList", ds);
		
		lopDao lop = new lopDao();
		List<Lop> dslop = lop.getAll();
		session.setAttribute("lopList", dslop);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/sinhvien.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String kt = request.getParameter("kt");
		
		sinhvienDao svDao = new sinhvienDao();
		lopDao lDao = new lopDao();
		
		if(kt.equals("add")) {
			String maSV = request.getParameter("maSV");
			String tenSV = request.getParameter("tenSV");
			String diachi = request.getParameter("diachi");
			
			int sdt = 0;
			try {
				sdt = Integer.parseInt(request.getParameter("sdt"));
			} catch (NumberFormatException e) {
				System.out.println("Lỗi..!");
			}
			
			String email = request.getParameter("email");
			
			int maLop = Integer.parseInt(request.getParameter("malop"));
			
			SinhVien sv = new SinhVien(maSV, tenSV, diachi, sdt, email
					, new Lop(maLop, null, new Khoa(null,null,null)));
			
			int res = svDao.addSV(sv);
			if(res > 0) {
				response.sendRedirect(request.getContextPath()+"/sinhvien?msg=OK");
				return;
			}
			else {
				response.sendRedirect(request.getContextPath()+"/sinhvien?msg=ERROR");
				return;
			}
		}
		if(kt.equals("edit")) {
			String i = request.getParameter("id");
			String imaSV = request.getParameter("msv");
			String itenSV = request.getParameter(i+"a");
			String idiachi = request.getParameter(i+"b");
			int isdt = 0;
			try {
				 isdt = Integer.parseInt(request.getParameter(i+"c"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			String iemail = request.getParameter(i+"d");
			
			
			String tenLop = request.getParameter("mLop");
			int ilop = lDao.getLop(tenLop).getMaLop();
			
			SinhVien isv = new SinhVien(imaSV, itenSV, idiachi, isdt, iemail, new Lop(ilop, null, new Khoa(null,null,null)));
			int res = svDao.editSV(isv);
			
			if(res == 0 || isdt == 0 ){
				response.sendRedirect(request.getContextPath()+"/sinhvien?msg=ERROR");
				return;
			}
			else {
				response.sendRedirect(request.getContextPath()+"/sinhvien?msg=OK");
				return;
			}
		}
		
		if(kt.equals("delete")) {
			String msv = request.getParameter("msv");
			int rs = svDao.deleteSV(msv);
			if(rs > 0) {
				response.sendRedirect(request.getContextPath()+"/sinhvien?msg=OK");
				return;
			}
			else {
				response.sendRedirect(request.getContextPath()+"/sinhvien?msg=ERROR");
				return;
			}
		}
	}
}

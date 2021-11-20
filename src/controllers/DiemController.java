package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.diemDao;
import daos.giangvienDao;
import daos.sinhvienDao;
import models.Diem;
import models.GiangVien;
import models.SinhVien;

public class DiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/logins");
			return;
		}
		sinhvienDao svDao = new sinhvienDao();
		List<SinhVien> ds = svDao.getAll();
		session.setAttribute("sinhvienList", ds);
		
		giangvienDao gvDao = new giangvienDao();
		List<GiangVien> dsgv = gvDao.getAll();
		session.setAttribute("giangvienList", dsgv);
		
		diemDao dDao = new diemDao();
		List<Diem> dsDiem = dDao.getAll();
		session.setAttribute("diemList", dsDiem);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/diem_index.jsp");
		rd.forward(request, response);
	}
	
}

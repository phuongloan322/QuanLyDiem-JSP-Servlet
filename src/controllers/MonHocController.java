package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.monhocDao;
import models.MonHoc;
import models.TheLoai;
import models.TinChi;

public class MonHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null ) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		monhocDao mhDao = new monhocDao();
		List<MonHoc> ds = mhDao.getAll();
		session.setAttribute("monhocList", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/monhoc.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maMH = request.getParameter("maMH");
		String tenMH = request.getParameter("tenMH");
		String maTC = request.getParameter("maTC");
		String maTL = request.getParameter("maTL");
		
		MonHoc monHoc = new MonHoc(maMH, tenMH, new TinChi(maTC, 0), new TheLoai(maTL, null));
		
		monhocDao mhDao = new monhocDao();
		int res = mhDao.addMH(monHoc);
		if(res > 0) {
			response.sendRedirect(request.getContextPath()+"/monhoc?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/monhoc?msg=ERROR");
			return;
		}
	}

}

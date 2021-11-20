package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.tinchiDao;
import models.TinChi;

public class TinChiController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		tinchiDao tcDao = new tinchiDao();
		List<TinChi> ds = tcDao.getAll();
		session.setAttribute("tinchiList", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/tinchi.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maTC = request.getParameter("maTC");
		int soTC = Integer.parseInt(request.getParameter("soTC"));
		TinChi tinChi = new TinChi(maTC, soTC);
		
		tinchiDao tcDao = new tinchiDao();
		int res = tcDao.addTC(tinChi);
		
		if(res > 0) {
			response.sendRedirect(request.getContextPath()+"/tinchi?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/tinchi?msg=ERROR");
			return;
		}
	}
}

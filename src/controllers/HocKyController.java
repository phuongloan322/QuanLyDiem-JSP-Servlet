package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.hockyDao;
import models.hocky;

public class HocKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HocKyController() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		hockyDao hkDao = new hockyDao();
		List<hocky> ds = hkDao.getAll();
		session.setAttribute("hockyList", ds);
		
		RequestDispatcher rq = request.getRequestDispatcher("/views/hocky.jsp");
		rq.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maHK = request.getParameter("mahk");
		String tenHK = request.getParameter("tenhk");
		hocky hk = new hocky(maHK, tenHK);
		
		hockyDao hkDao = new hockyDao();
		int result = hkDao.add(hk);
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/hocky?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/hocky?msg=ERROR");
			return;
		}
	}
}

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
import daos.lopDao;
import models.Khoa;
import models.Lop;

public class LopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		lopDao lopDAO = new lopDao();
		List<Lop> lopList = lopDAO.getAll();
		request.setAttribute("lopList", lopList);
		
		khoaDao khoaDAO = new khoaDao();
		List<Khoa> khoaList = khoaDAO.getAll();
		request.setAttribute("khoaList", khoaList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/lop.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		lopDao lDao = new lopDao();
		
		String lop = request.getParameter("lop");
		
		String khoa = request.getParameter("khoa");
		
		Lop objL = new Lop(0, lop, new Khoa(khoa, null, null));
		int add = lDao.addLop(objL);
		
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/lop?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/lop?msg=ERROR");
			return;
		}
	}
}

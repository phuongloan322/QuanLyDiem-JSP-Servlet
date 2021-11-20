package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.nienkhoaDao;
import models.NienKhoa;

public class NienKhoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		nienkhoaDao nkDao = new nienkhoaDao();
		List<NienKhoa> ds = nkDao.getAll();
		session.setAttribute("nienkhoaList", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/nienkhoa.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String maNK = request.getParameter("maNK");
		String tenNK = request.getParameter("tenNK");
		NienKhoa nienKhoa = new NienKhoa(maNK, tenNK);
		
		nienkhoaDao nkDao = new nienkhoaDao();
		int res = nkDao.addNK(nienKhoa);
		
		if(res > 0) {
			response.sendRedirect(request.getContextPath()+"/nienkhoa?msg=OK");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/nienkhoa?msg=ERROR");
			return;
		}
	}

}

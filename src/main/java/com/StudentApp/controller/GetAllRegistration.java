package com.StudentApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentApp.model.DAOService;
import com.StudentApp.model.DAOServiceimpl;
@WebServlet("/listall")
public class GetAllRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetAllRegistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email")!=null) {
		DAOService service = new DAOServiceimpl ();
		service.ConnectionDB();	
		ResultSet result = service.listRegistration();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_all.jsp");
		rd.forward(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
		rd.forward(request, response);
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

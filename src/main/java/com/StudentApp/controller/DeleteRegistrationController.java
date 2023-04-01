package com.StudentApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentApp.model.DAOService;
import com.StudentApp.model.DAOServiceimpl;
@WebServlet("/Delete")
public class DeleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteRegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		DAOService service = new  DAOServiceimpl();
		service.ConnectionDB();
		service.deleteByEmail(email);
		
		ResultSet result = service.listRegistration();
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_all.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

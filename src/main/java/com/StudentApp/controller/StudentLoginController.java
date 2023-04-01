package com.StudentApp.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentApp.model.DAOService;
import com.StudentApp.model.DAOServiceimpl;
@WebServlet("/VerifyLoin")
public class StudentLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentLoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService service = new DAOServiceimpl();
		service.ConnectionDB();
		boolean status = service.verifyCredentials(email, password);
		if (status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}

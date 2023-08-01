package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import dao.LoginDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	public void init() throws ServletException {
		System.out.println("LoginController 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDAO dao = new LoginDAO();
		
		System.out.println("id: "+id + " / pw: " + pw);

		Integer loginRes = dao.login(id,pw);
		
		if (loginRes == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
            session.setMaxInactiveInterval(30 * 60);
            
    		response.sendRedirect("/");
		} else {						
			RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp?error="+loginRes);
			dispatch.forward(request, response);
			}

	}

	public void destroy()

	{
		System.out.println("destroy O");
	}

}

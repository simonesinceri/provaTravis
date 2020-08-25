package web_2.logic.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.LoginBeanWeb;
import web_2.logic.controller.LoginControllerWeb;
import web_2.logic.model.UserWeb;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LoginBeanWeb bean = new LoginBeanWeb();
		LoginControllerWeb  controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		bean.setUsername(username);
		bean.setPassword(password);
		
		RequestDispatcher viewReg = request.getRequestDispatcher("registerView.jsp");
		
		if((request.getParameter("registerUser") == null) && (request.getParameter("registerOwner") == null)) {
			request.setAttribute("radio", "not");
			
			viewReg.forward(request, response);
		}
		
		RequestDispatcher viewLog = request.getRequestDispatcher("loginView.jsp");
		
		if(request.getParameter("registerUser") != null) {
			if(controller.registerUser(bean)) {
				request.setAttribute("reg1", "ok");
				viewLog.forward(request, response);
			}else {
				request.setAttribute("reg", "fail");
				viewReg.forward(request, response);
			}
		}
		if(request.getParameter("registerOwner") != null) {
			if(controller.registerOwner(bean)) {
				request.setAttribute("reg1", "ok");
				viewLog.forward(request, response);
			}else {
				request.setAttribute("reg", "fail");
				viewReg.forward(request, response);
			}
		}

	}

}

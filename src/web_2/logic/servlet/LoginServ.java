package web_2.logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.LoginBeanWeb;
import web_2.logic.controller.LoginControllerWeb;
import web_2.logic.model.OwnerWeb;
import web_2.logic.model.UserWeb;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
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
		
		controller.login(bean);
		//session.setAttribute("userLog", userLog);
		
		if(bean.getResult()) {
			if(bean.getUserWebLog() != null) {  // potrebbe dare problema sonar null pointer exception
				UserWeb log =  bean.getUserWebLog();
				session.setAttribute("userLog", log);
				controller.changeExperiences(0,0,bean);
				session.setAttribute("beanLog",bean);
			
				RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
				view.forward(request, response);
			}
			if(bean.getOwnerWebLog() != null) {
				OwnerWeb ownLog = bean.getOwnerWebLog();
				session.setAttribute("ownerLog", ownLog);
				controller.changeExperiences(0,1,bean);
				session.setAttribute("beanLog",bean);
			
				RequestDispatcher view1 = request.getRequestDispatcher("ownerPage.jsp");
				view1.forward(request, response);
			}
			
		}else {
			request.setAttribute("loginFail", "fail");
			RequestDispatcher view1 = request.getRequestDispatcher("loginView.jsp");
			view1.forward(request, response);
		}
		
		
	}

}

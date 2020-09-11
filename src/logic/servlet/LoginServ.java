package logic.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.bean.LoginBeanWeb;
import logic.controller.LoginControllerWeb;
import logic.model.OwnerWeb;
import logic.model.UserWeb;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServ() {
        super(); 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginBeanWeb beanLogin = new LoginBeanWeb();
		LoginControllerWeb  controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		
		String usernameLogin = request.getParameter("username");
		String passwordLogin = request.getParameter("password");
		
		beanLogin.setUsername(usernameLogin);
		beanLogin.setPassword(passwordLogin);
		
		controller.login(beanLogin);
		
		if(beanLogin.getResult()) {
			if(beanLogin.getUserWebLog() != null) {  // potrebbe dare problema sonar null pointer exception
				UserWeb log =  beanLogin.getUserWebLog();
				session.setAttribute("userLog", log);
				controller.changeExperiences(0,beanLogin);
				session.setAttribute("beanLog",beanLogin);
			
				RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
				view.forward(request, response);
			}
			if(beanLogin.getOwnerWebLog() != null) {
				OwnerWeb ownLog = beanLogin.getOwnerWebLog();
				session.setAttribute("ownerLog", ownLog);
				controller.changeStructures(0,beanLogin);
				session.setAttribute("beanLog",beanLogin);
			
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

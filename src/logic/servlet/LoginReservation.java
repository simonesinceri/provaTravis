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


/**
 * Servlet implementation class LoginReservation
 */
@WebServlet("/LoginReservation")
public class LoginReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginReservation() {
        super();  
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginBeanWeb beanLog = new LoginBeanWeb();
		LoginControllerWeb  controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		
		String usernameLog = request.getParameter("username");
		String passwordLog = request.getParameter("password");
		
		// la bean per dio, tramite bena passo i parametri al controlller
		beanLog.setUsername(usernameLog);
		beanLog.setPassword(passwordLog);
		
		controller.login(beanLog);
		session.setAttribute("userLog", beanLog.getUserWebLog());
		
		if(beanLog.getResult() && (beanLog.getUserWebLog() != null)) {  // nel metodo login viene chiamato login.checkuser che ritorna l'user e lo setta come attr del contr
			controller.changeExperiences(0,beanLog);
			session.setAttribute("beanLog",beanLog);
			session.setAttribute("ownerLog", null);
			RequestDispatcher view = request.getRequestDispatcher("hotelsConfirm.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("loginFailR", "fail");
			RequestDispatcher view1 = request.getRequestDispatcher("loginReservation.jsp");
			view1.forward(request, response);
		}
		
	}

}

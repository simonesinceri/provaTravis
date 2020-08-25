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
import web_2.logic.model.UserWeb;

/**
 * Servlet implementation class LoginReservation
 */
@WebServlet("/LoginReservation")
public class LoginReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginReservation() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		;
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
		
		// la bean per dio, tramite bena passo i parametri al controlller
		bean.setUsername(username);
		bean.setPassword(password);
		
		controller.login(bean);
		session.setAttribute("userLog", bean.getUserWebLog());
		
		if(bean.getResult() && (bean.getUserWebLog() != null)) {  // nel metodo login viene chiamato login.checkuser che ritorna l'user e lo setta come attr del contr
			controller.changeExperiences(0,0,bean);
			session.setAttribute("beanLog",bean);
			RequestDispatcher view = request.getRequestDispatcher("hotelsConfirm.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("loginFailR", "fail");
			RequestDispatcher view1 = request.getRequestDispatcher("loginReservation.jsp");
			view1.forward(request, response);
		}
		
	}

}

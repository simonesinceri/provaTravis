package web_2.logic.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.LoginBeanWeb;
import web_2.logic.controller.LoginControllerWeb;
import web_2.logic.model.Experience;
import web_2.logic.model.OwnerWeb;
import web_2.logic.model.UserWeb;

/**
 * Servlet implementation class NextExperience
 */
@WebServlet("/NextExperience")
public class NextExperience extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextExperience() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LoginControllerWeb  controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		
		UserWeb user = (UserWeb)session.getAttribute("userLog");
		OwnerWeb owner = (OwnerWeb)session.getAttribute("ownerLog");
	
		int indice = controller.getIndice();
		
		if(user != null) {
			if((indice%6) == 0) {
				bean.getExpList().clear();  
				controller.changeExperiences(indice,0,bean);
			}
			
			RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
			view.forward(request, response);
		
		}else if(owner != null) {
			if((indice%6) == 0) {
				bean.getStructList().clear();  
				controller.changeExperiences(indice,1,bean);
			}
			
			RequestDispatcher view1 = request.getRequestDispatcher("ownerPage.jsp");
			view1.forward(request, response);
		}
		
		
		//RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
		//view.forward(request, response);
	}

}

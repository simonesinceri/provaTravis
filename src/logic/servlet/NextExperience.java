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
 * Servlet implementation class NextExperience
 */
@WebServlet("/NextExperience")
public class NextExperience extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NextExperience() {
        super();
    }

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
				controller.changeExperiences(indice,bean);
			}
			
			RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
			view.forward(request, response);
		
		}else if(owner != null) {
			if((indice%6) == 0) {
				bean.getStructList().clear();  
				controller.changeStructures(indice,bean);
			}
			
			RequestDispatcher view1 = request.getRequestDispatcher("ownerPage.jsp");
			view1.forward(request, response);
		}

	}

}

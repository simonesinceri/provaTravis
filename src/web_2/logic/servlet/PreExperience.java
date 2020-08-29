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
 * Servlet implementation class PreExperience
 */
@WebServlet("/PreExperience")
public class PreExperience extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreExperience() {
        super();
        // TODO Auto-generated constructor stub
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
		
		if(indice == 6) {
			if(user != null) {
				controller.changeExperiences(0,0,bean);
			
				RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
				view.forward(request, response);
				
			}else if(owner != null) {
				controller.changeExperiences(0,1,bean);
				
				RequestDispatcher view1 = request.getRequestDispatcher("ownerPage.jsp");
				view1.forward(request, response);
				}
		}
		
		
		
		
		if (indice > 6  ){
			
			if(user != null) {
				
				bean.getExpList().clear();
					if ((indice%6) == 0) {
						indice = indice - 12;
						controller.changeExperiences(indice,0,bean);
					} else if ((indice%6) == 1) {
						indice = indice - 7;
						controller.changeExperiences(indice,0,bean);
					} else if ((indice%6) == 2){
						indice = indice - 8;
						controller.changeExperiences(indice,0,bean);
					} else if ((indice%6) == 3){
						indice = indice - 9;
						controller.changeExperiences(indice,0,bean);
					} else if ((indice%6) == 4){
						indice = indice - 10;
						controller.changeExperiences(indice,0,bean);
					} else {
						indice = indice - 11;
						controller.changeExperiences(indice,0,bean);
					}
			
					RequestDispatcher view2 = request.getRequestDispatcher("profilePage2.jsp");
					view2.forward(request, response);
			
			}else if(owner != null) {
				
				if ((indice%6) == 0) {
					indice = indice - 12;
					controller.changeExperiences(indice,1,bean);
				} else if ((indice%6) == 1) {
					indice = indice - 7;
					controller.changeExperiences(indice,1,bean);
				} else if ((indice%6) == 2){
					indice = indice - 8;
					controller.changeExperiences(indice,1,bean);
				} else if ((indice%6) == 3){
					indice = indice - 9;
					controller.changeExperiences(indice,1,bean);
				} else if ((indice%6) == 4){
					indice = indice - 10;
					controller.changeExperiences(indice,1,bean);
				} else {
					indice = indice - 11;
					controller.changeExperiences(indice,1,bean);
				}
				
				RequestDispatcher view1 = request.getRequestDispatcher("ownerPage.jsp");
				view1.forward(request, response);
			}
		}
		
		if(user != null && indice < 6) {
			RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
			view.forward(request, response);
		}else if(owner != null && indice < 6) {
			RequestDispatcher view1 = request.getRequestDispatcher("ownerPage.jsp");
			view1.forward(request, response);
		}
	}


}

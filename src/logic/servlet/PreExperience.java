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
 * Servlet implementation class PreExperience
 */
@WebServlet("/PreExperience")
public class PreExperience extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PreExperience() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginControllerWeb  controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		
		UserWeb user = (UserWeb)session.getAttribute("userLog");
		OwnerWeb owner = (OwnerWeb)session.getAttribute("ownerLog");
		String profilePage = "profilePage2.jsp";
		String ownerPage = "ownerPage.jsp";
		
		int indice = controller.getIndice();
		
		if(indice == 6) {
			if(user != null) {
				controller.changeExperiences(0,bean);
			
				RequestDispatcher view = request.getRequestDispatcher(profilePage);
				view.forward(request, response);
				
			}else if(owner != null) {
				controller.changeStructures(0,bean);
				
				RequestDispatcher view1 = request.getRequestDispatcher(ownerPage);
				view1.forward(request, response);
				}
		}
		

		if (indice > 6  ){
			
			if(user != null) {
				
				bean.getExpList().clear();
				pre(indice,controller,bean);
			
				RequestDispatcher view2 = request.getRequestDispatcher(profilePage);
				view2.forward(request, response);
			
			}else if(owner != null) {
				
				bean.getStructList().clear();
				pre1(indice,controller,bean);
				
				RequestDispatcher view1 = request.getRequestDispatcher(ownerPage);
				view1.forward(request, response);
			}
		}
		
		if(user != null && indice < 6) {
			RequestDispatcher view = request.getRequestDispatcher(profilePage);
			view.forward(request, response);
		}else if(owner != null && indice < 6) {
			RequestDispatcher view1 = request.getRequestDispatcher(ownerPage);
			view1.forward(request, response);
		}
	}
	
	private void pre(int indiceUser, LoginControllerWeb controller, LoginBeanWeb bean) {
		
		int modIndiceUser = indiceUser%6;
		
		if (modIndiceUser == 0) {
			indiceUser = indiceUser - 12;
		} else if (modIndiceUser== 1) {
			indiceUser = indiceUser - 7;
		} else if (modIndiceUser == 2){
			indiceUser = indiceUser - 8;
		} else if (modIndiceUser == 3){
			indiceUser = indiceUser - 9;
		} else if (modIndiceUser == 4){
			indiceUser = indiceUser - 10;
		} else {
			indiceUser = indiceUser - 11;
		}
		controller.changeExperiences(indiceUser,bean);
	}


	private void pre1(int indiceOwner, LoginControllerWeb controller, LoginBeanWeb bean) {

		int modIndiceOwner = indiceOwner%6;
		
		if (modIndiceOwner == 0) {
			indiceOwner = indiceOwner - 12;
		} else if (modIndiceOwner== 1) {
			indiceOwner = indiceOwner - 7;
		} else if (modIndiceOwner == 2){
			indiceOwner = indiceOwner - 8;
		} else if (modIndiceOwner == 3){
			indiceOwner = indiceOwner - 9;
		} else if (modIndiceOwner == 4){
			indiceOwner = indiceOwner - 10;
		} else {
			indiceOwner = indiceOwner - 11;
		}
		controller.changeStructures(indiceOwner,bean);
	}
	
}

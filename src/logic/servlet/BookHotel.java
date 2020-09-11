package logic.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.bean.HotelBeanWeb;
import logic.bean.LoginBeanWeb;
import logic.controller.HotelControllerWeb;
import logic.controller.LoginControllerWeb;
import logic.model.UserWeb;

/**
 * Servlet implementation class BookHotel
 */
@WebServlet("/BookHotel")
public class BookHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookHotel() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		LoginControllerWeb controllerLog = LoginControllerWeb.getIstance();
		LoginBeanWeb beanLog = (LoginBeanWeb)session.getAttribute("beanLog");
	
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		UserWeb userLog = (UserWeb)session.getAttribute("userLog");
		
		if(controller.setReservation(bean.getBookHotel(), bean.getBookRoom(),bean, userLog)) {
		
			request.setAttribute("bookCheck", "ok");
			beanLog.getExpList().clear();
			controllerLog.changeExperiences(0,beanLog);
			RequestDispatcher view = request.getRequestDispatcher("hotelsConfirm.jsp");
			view.forward(request, response);
	
		}else {
			request.setAttribute("bookCheck", "no");
		}
	}

}

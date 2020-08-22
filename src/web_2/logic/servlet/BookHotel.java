package web_2.logic.servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.HotelBeanWeb;
import web_2.logic.controller.HotelControllerWeb;
import web_2.logic.model.UserWeb;

/**
 * Servlet implementation class BookHotel
 */
@WebServlet("/BookHotel")
public class BookHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookHotel() {
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
		
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		HttpSession session = request.getSession();
		
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		UserWeb userLog = (UserWeb)session.getAttribute("userLog");
		
		//potrei cambire il metodo e passare solo la bean
		if(controller.setReservation(bean.getBookHotel(), bean.getBookRoom(),bean, userLog)) {
		
			request.setAttribute("bookCheck", "ok");
			RequestDispatcher view = request.getRequestDispatcher("hotelsConfirm.jsp");
			view.forward(request, response);
		
			

		}else {
			request.setAttribute("bookCheck", "no");
		}
	}

}

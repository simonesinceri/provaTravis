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
import logic.controller.HotelControllerWeb;

/**
 * Servlet implementation class firstHotelPage
 */
@WebServlet("/FirstHotelPage")
public class FirstHotelPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstHotelPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		controller.setHotelSelected(1);
		controller.setStep(3);
		
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		
		bean.setBookHotel(controller.getHotel1());
		bean.setBookRoom(controller.getRoom1());
		
		session.setAttribute("step", "2");
		
		RequestDispatcher view = request.getRequestDispatcher("hotelsView3.jsp");
		view.forward(request, response);
	}

}

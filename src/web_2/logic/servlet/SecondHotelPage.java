package web_2.logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.HotelBeanWeb;
import web_2.logic.controller.HotelControllerWeb;

/**
 * Servlet implementation class SecondHotelPage
 */
@WebServlet("/SecondHotelPage")
public class SecondHotelPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondHotelPage() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		controller.setHotelSelected(2);
		controller.setStep(3);
		//vediamo dopo come gestire varianìbile step
		
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		
		//bisogna controllare che non sia nullo l'hotel
		bean.setBookHotel(controller.getHotel2());
		bean.setBookRoom(controller.getRoom2());
		
		RequestDispatcher view = request.getRequestDispatcher("hotelsView3.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

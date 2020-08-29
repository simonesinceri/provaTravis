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
 * Servlet implementation class firstHotelPage
 */
@WebServlet("/FirstHotelPage")
public class FirstHotelPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstHotelPage() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession session = request.getSession();
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		controller.setHotelSelected(1);
		controller.setStep(3);
		//vediamo dopo come gestire varianìbile step
		
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		
		bean.setBookHotel(controller.getHotel1());
		bean.setBookRoom(controller.getRoom1());
		
		session.setAttribute("step", "2");
		
		RequestDispatcher view = request.getRequestDispatcher("hotelsView3.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

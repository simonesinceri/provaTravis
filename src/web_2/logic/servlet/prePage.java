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
 * Servlet implementation class prePage
 */
@WebServlet("/prePage")
public class prePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prePage() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		int indice = controller.getIndice();
		
		if (indice > 3) {
				if ((indice%3) == 0) {
					indice = indice - 6;
					controller.changeScene2(indice, bean);
				} else if ((indice%3) == 1) {
	 				indice = indice - 4;
	 				controller.changeScene2(indice, bean);
				} else {
					indice = indice - 5;
	 				controller.changeScene2(indice, bean);
				}
			}
		
		bean.setHotel1(controller.getHotel1());
		bean.setHotel2(controller.getHotel2());
		bean.setHotel3(controller.getHotel3());
		
		bean.setRoom1(controller.getRoom1());
		bean.setRoom2(controller.getRoom2());
		bean.setRoom3(controller.getRoom3());
		
		RequestDispatcher view = request.getRequestDispatcher("hotelsView2.jsp");
		view.forward(request, response);
		
	}

}

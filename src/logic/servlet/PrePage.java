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
import logic.exceptions.ExceptionSearchHotels;

/**
 * Servlet implementation class prePage
 */
@WebServlet("/PrePage")
public class PrePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrePage() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		int indice = controller.getIndice();
		
		if (indice > 3) {
			controller.setPage(controller.getPage()-1);
				if ((indice%3) == 0) {
					indice = indice - 6;
				} else if ((indice%3) == 1) {
	 				indice = indice - 4;
				} else {
					indice = indice - 5;
				}
		} else {
			indice = 0;
		}
		
		try {
			controller.changeScene2(indice, bean);
		} catch (ExceptionSearchHotels ePre) {
			ePre.printStackTrace();
		}

		bean.setRoom1(controller.getRoom1());
		bean.setRoom2(controller.getRoom2());
		bean.setRoom3(controller.getRoom3());
		
		bean.setHotel1(controller.getHotel1());
		bean.setHotel2(controller.getHotel2());
		bean.setHotel3(controller.getHotel3());
		
		RequestDispatcher view = request.getRequestDispatcher("hotelsView2.jsp");
		view.forward(request, response);
		
	}

}

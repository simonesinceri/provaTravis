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
 * Servlet implementation class nextPage
 */
@WebServlet("/NextPage")
public class NextPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public NextPage() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		int index = controller.getIndice();
		
		if ((index%3) != 0) {
			if ((index%3) == 1) {
				index = index - 1;
			} else {
				index = index - 2;
			}
		} else {
			controller.setPage(controller.getPage()+1);
		}
		
		try {
			controller.changeScene2(index, bean);
		} catch (ExceptionSearchHotels eNext) {
			eNext.printStackTrace();
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

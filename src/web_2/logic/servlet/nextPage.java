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
 * Servlet implementation class nextPage
 */
@WebServlet("/nextPage")
public class nextPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	public nextPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HotelBeanWeb bean = (HotelBeanWeb)session.getAttribute("bean");
		
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		int index = controller.getIndice();
		
		controller.changeScene2(index, bean);
		
		bean.setHotel1(controller.getHotel1());
		bean.setHotel2(controller.getHotel2());
		bean.setHotel3(controller.getHotel3());
		
		bean.setRoom1(controller.getRoom1());
		bean.setRoom2(controller.getRoom2());
		bean.setRoom3(controller.getRoom3());
		
		//System.out.println(((HotelBean)session.getAttribute("bean")).getCity());
		
		RequestDispatcher view = request.getRequestDispatcher("hotelsView2.jsp");
		view.forward(request, response);
	}

}

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
import web_2.logic.bean.ReviewBean;
import web_2.logic.controller.HotelControllerWeb;

/**
 * Servlet implementation class ViewReviewServ
 */
@WebServlet("/ViewReviewServ")
public class ViewReviewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReviewServ() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HotelBeanWeb hotelBean = new HotelBeanWeb();
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		ReviewBean reviewBean = new ReviewBean();
		HttpSession session = request.getSession();
		
		hotelBean = (HotelBeanWeb)session.getAttribute("bean");

		controller.viewReviews(true, hotelBean.getBookHotel().getReviews(), 0, reviewBean);
		session.setAttribute("reviewBean", reviewBean);
	// o session??  poi devo svuotarla nel back
 		
		RequestDispatcher view = request.getRequestDispatcher("viewReview.jsp");
		view.forward(request, response);
	}



}

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
import logic.bean.ReviewBean;
import logic.controller.HotelControllerWeb;

/**
 * Servlet implementation class ViewReviewServ
 */
@WebServlet("/ViewReviewServ")
public class ViewReviewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ViewReviewServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		ReviewBean reviewBean = new ReviewBean();
		HttpSession session = request.getSession();
		
		HotelBeanWeb hotelBean = (HotelBeanWeb)session.getAttribute("bean");

		controller.viewReviews(hotelBean.getBookHotel().getHotelReviews(), 0, reviewBean);
		session.setAttribute("reviewBean", reviewBean);
		
		session.setAttribute("type", "1");
 		
		RequestDispatcher view = request.getRequestDispatcher("viewReview.jsp");
		view.forward(request, response);
	}



}

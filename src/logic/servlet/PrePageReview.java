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
import logic.model.Hotel;

/**
 * Servlet implementation class PrePageReview
 */
@WebServlet("/PrePageReview")
public class PrePageReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PrePageReview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewBeanStr = "reviewBean";
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
	
		HttpSession session = request.getSession();
		
		HotelBeanWeb hotelBean = (HotelBeanWeb)session.getAttribute("bean");
		ReviewBean reviewBean = (ReviewBean)session.getAttribute(reviewBeanStr);
		
		if(session.getAttribute("type") == "1") {
			
			controller.viewReviews(hotelBean.getBookHotel().getHotelReviews(), (reviewBean.getIndex() - 6), reviewBean);
			session.setAttribute(reviewBeanStr, reviewBean);
		
		}else if(session.getAttribute("type") == "2") {
			
			Hotel str = (Hotel)session.getAttribute("struct");
			controller.viewReviews(str.getHotelReviews(), (reviewBean.getIndex() - 6), reviewBean);
			session.setAttribute(reviewBeanStr, reviewBean); 
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("viewReview.jsp");
		view.forward(request, response);
	
	}


}

package logic.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.bean.ReviewBean;
import logic.controller.HotelControllerWeb;
import logic.model.Hotel;

/**
 * Servlet implementation class StructReview
 */
@WebServlet("/StructReview")
public class StructReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StructReview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		ReviewBean reviewBean = new ReviewBean();
		HttpSession session = request.getSession();
		Hotel str = (Hotel)session.getAttribute("struct");
		
		controller.viewReviews(str.getHotelReviews(), reviewBean.getIndex(), reviewBean);
		
		session.setAttribute("reviewBean", reviewBean);
		session.setAttribute("type", "2");
		
		RequestDispatcher view = request.getRequestDispatcher("viewReview.jsp");
		view.forward(request, response);
	}


}

package logic.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.bean.LoginBeanWeb;
import logic.controller.LoginControllerWeb;
import logic.model.Experience;
import logic.model.Review;
import logic.model.UserWeb;

/**
 * Servlet implementation class WriteReview
 */
@WebServlet("/WriteReview")
public class WriteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public WriteReview() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginControllerWeb  controller = LoginControllerWeb.getIstance();
		
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		UserWeb user =(UserWeb)session.getAttribute("userLog");
		
		Experience experience = (Experience)session.getAttribute("exp");
		Review review = new Review();
		
		String reviewText = request.getParameter("stringReview");
		int voto = Integer.parseInt(request.getParameter("vote"));
			
		review.setReviewText(reviewText);
		review.setReviewVote(voto);
	
		controller.addReview(review, experience.getName(), experience.getDayIn(), experience.getDayOut(), user);
		bean.getExpList().clear();
		controller.changeExperiences(0,bean);
		
		RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
		view.forward(request, response);

	}

}

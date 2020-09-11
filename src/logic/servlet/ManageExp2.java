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
import logic.model.Experience;
import logic.model.Review;
import logic.model.UserWeb;

/**
 * Servlet implementation class ManageExp2
 */
@WebServlet("/ManageExp2")
public class ManageExp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ManageExp2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		UserWeb user =(UserWeb)session.getAttribute("userLog");
		
		Experience experience2 = bean.getExpList().get(1);
		
		Review review = new Review();
		review.setReviewUser(user.getUsername());
		review.setReviewText(experience2.getReview());
		review.setReviewVote(experience2.getRating());
		
		request.setAttribute("reviewExp", review);
		session.setAttribute("exp", experience2);
		
		
		if (experience2.getReview().equals("")) {
			RequestDispatcher view = request.getRequestDispatcher("writeReviewPage.jsp");
			view.forward(request, response);
		}else{
			RequestDispatcher view1 = request.getRequestDispatcher("viewMyReview.jsp");
			view1.forward(request, response);
		}
	}

}

package web_2.logic.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.LoginBeanWeb;
import web_2.logic.controller.LoginControllerWeb;
import web_2.logic.model.Experience;
import web_2.logic.model.Review;
import web_2.logic.model.UserWeb;

/**
 * Servlet implementation class WriteReview
 */
@WebServlet("/WriteReview")
public class WriteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginControllerWeb  controller = LoginControllerWeb.getIstance();
		
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		UserWeb user =(UserWeb)session.getAttribute("userLog");
		
		Experience experience = (Experience)session.getAttribute("exp");
		Review review = new Review();
		
		String reviewText = request.getParameter("stringReview");
		int voto = Integer.valueOf(request.getParameter("vote"));
		
		
		review.setReview(reviewText);
		review.setVote(voto);
		
	
		
		controller.addReview(review, experience.getName(), experience.getDayIn(), experience.getDayOut(), user);
		bean.getExpList().clear();
		controller.changeExperiences(0,0,bean);
		
		RequestDispatcher view = request.getRequestDispatcher("profilePage2.jsp");
		view.forward(request, response);
	
		
	}

}

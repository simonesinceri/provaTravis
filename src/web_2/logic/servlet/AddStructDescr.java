package web_2.logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.LoginBeanWeb;
import web_2.logic.controller.LoginControllerWeb;
import web_2.logic.model.Hotel;
import web_2.logic.model.Structure;

/**
 * Servlet implementation class AddStructDescr
 */
@WebServlet("/AddStructDescr")
public class AddStructDescr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStructDescr() {
        super();
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
		
		LoginControllerWeb controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		//LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		
		String description = request.getParameter("description");
		Hotel str =(Hotel)session.getAttribute("struct");
		
		
		controller.addDescription(description, str.getName());
		request.setAttribute("descr", "ok");
		
		RequestDispatcher view = request.getRequestDispatcher("addStrDescr.jsp");
		view.forward(request, response);
		
		
	}

}

package logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.controller.LoginControllerWeb;
import logic.model.Hotel;


/**
 * Servlet implementation class AddStructDescr
 */
@WebServlet("/AddStructDescr")
public class AddStructDescr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStructDescr() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginControllerWeb controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		
		String description = request.getParameter("description");
		Hotel str =(Hotel)session.getAttribute("struct");
		
		
		controller.addDescription(description, str.getHotelName());
		request.setAttribute("descr", "ok");
		
		RequestDispatcher view = request.getRequestDispatcher("addStrDescr.jsp");
		view.forward(request, response);

	}

}

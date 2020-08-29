package web_2.logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.controller.LoginControllerWeb;
import web_2.logic.model.Hotel;

/**
 * Servlet implementation class AddRoom
 */
@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginControllerWeb controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel)session.getAttribute("struct");
		
		int id = Integer.valueOf(request.getParameter("id"));
		int price = Integer.valueOf(request.getParameter("price"));
		int beds = Integer.valueOf(request.getParameter("beds"));
		
		
		if(controller.addRoom(hotel.getRooms(), id, beds, price)) {
			request.setAttribute("addRoom", "ok");
		}
		
	
		
		RequestDispatcher view = request.getRequestDispatcher("addRoomPage.jsp");
		view.forward(request, response);
	}

}

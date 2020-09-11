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
import logic.dao.RoomDao;
import logic.model.Hotel;

/**
 * Servlet implementation class AddRoom
 */
@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddRoom() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginControllerWeb controller = LoginControllerWeb.getIstance();
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel)session.getAttribute("struct");
		int roomsNumb = 0;
		
		int id = Integer.parseInt(request.getParameter("id"));
		int price = Integer.parseInt(request.getParameter("price"));
		int beds = Integer.parseInt(request.getParameter("beds"));
		
		
		if(controller.addRoom(hotel.getHotelRooms(), id, beds, price)) {
			request.setAttribute("addRoom", "ok");
			
			try {
				roomsNumb = RoomDao.getRoomsNumber(hotel.getHotelRooms());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			session.setAttribute("roomsNumb", roomsNumb);
	
		}

		RequestDispatcher view = request.getRequestDispatcher("addRoomPage.jsp");
		view.forward(request, response);
	}

}

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
import logic.dao.HotelDao;
import logic.dao.RoomDao;
import logic.model.Hotel;
import logic.model.Structure;

/**
 * Servlet implementation class ManageStruct3
 */
@WebServlet("/ManageStruct3")
public class ManageStruct3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManageStruct3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		Hotel hotel3 = new Hotel();
		int roomsNumb3 = 0;
		Structure struct3 = bean.getStructList().get(2);
		
		try {
			hotel3 = HotelDao.getHotel(struct3.getName());
			roomsNumb3 = RoomDao.getRoomsNumber(hotel3.getHotelRooms());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("roomsNumb", roomsNumb3);
		session.setAttribute("struct", hotel3);
		
		RequestDispatcher view = request.getRequestDispatcher("structPage.jsp");
		view.forward(request, response);
	}

}

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
 * Servlet implementation class ManageStruct2
 */
@WebServlet("/ManageStruct2")
public class ManageStruct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManageStruct2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		Hotel hotel2 = new Hotel();
		int roomsNumb2 = 0;
		Structure struct2 = bean.getStructList().get(1);
		
		try {
			hotel2 = HotelDao.getHotel(struct2.getName());
			roomsNumb2 = RoomDao.getRoomsNumber(hotel2.getHotelRooms());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("roomsNumb", roomsNumb2);
		session.setAttribute("struct", hotel2);
		
		RequestDispatcher view = request.getRequestDispatcher("structPage.jsp");
		view.forward(request, response);
	}

}

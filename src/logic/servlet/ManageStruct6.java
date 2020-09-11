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
 * Servlet implementation class ManageStruct6
 */
@WebServlet("/ManageStruct6")
public class ManageStruct6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ManageStruct6() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		Hotel hotel6 = new Hotel();
		int roomsNumb6 = 0;
		Structure struct6 = bean.getStructList().get(5);
		
		try {
			hotel6 = HotelDao.getHotel(struct6.getName());
			roomsNumb6 = RoomDao.getRoomsNumber(hotel6.getHotelRooms());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("roomsNumb", roomsNumb6);
		session.setAttribute("struct", hotel6);
		
		RequestDispatcher view = request.getRequestDispatcher("structPage.jsp");
		view.forward(request, response);
	}

}

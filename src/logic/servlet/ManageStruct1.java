package logic.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.dao.RoomDao;
import logic.dao.HotelDao;
import logic.model.Hotel;
import logic.bean.LoginBeanWeb;
import logic.model.Structure;

/**
 * Servlet implementation class ManageStruct1
 */
@WebServlet("/ManageStruct1")
public class ManageStruct1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ManageStruct1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		Hotel hotel1 = new Hotel();
		int roomsNumb1 = 0;
		Structure struct1 = bean.getStructList().get(0);
		
		try {
			hotel1 = HotelDao.getHotel(struct1.getName());
			roomsNumb1 = RoomDao.getRoomsNumber(hotel1.getHotelRooms());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("roomsNumb", roomsNumb1);
		session.setAttribute("struct", hotel1);
		
		RequestDispatcher view = request.getRequestDispatcher("structPage.jsp");
		view.forward(request, response);
	}

}

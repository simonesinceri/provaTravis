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
 * Servlet implementation class ManageStruct4
 */
@WebServlet("/ManageStruct4")
public class ManageStruct4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ManageStruct4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute("beanLog");
		Hotel hotel4 = new Hotel();
		int roomsNumb4 = 0;
		Structure struct4 = bean.getStructList().get(3);
		
		try {
			hotel4 = HotelDao.getHotel(struct4.getName());
			roomsNumb4 = RoomDao.getRoomsNumber(hotel4.getHotelRooms());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("roomsNumb", roomsNumb4);
		session.setAttribute("struct", hotel4);
		
		RequestDispatcher view = request.getRequestDispatcher("structPage.jsp");
		view.forward(request, response);
	}

}

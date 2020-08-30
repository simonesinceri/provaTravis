package web_2.logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_2.logic.bean.HotelBean;
import web_2.logic.bean.LoginBeanWeb;
import web_2.logic.controller.LoginControllerWeb;
import web_2.logic.model.OwnerWeb;

/**
 * Servlet implementation class AddStructure
 */
@WebServlet("/AddStructure")
public class AddStructure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStructure() {
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
		LoginBeanWeb beanLog = (LoginBeanWeb)session.getAttribute("beanLog");
		HotelBean bean = new HotelBean();
		
		String ownerName =((OwnerWeb)session.getAttribute("ownerLog")).getUsername() ;
		
		bean.setName(request.getParameter("structureName"));
		bean.setCity(request.getParameter("structureCity"));
		bean.setAddress(request.getParameter("structureAddress"));
		
		bean.setApartment(request.getParameter("cApartments") != null);
		bean.setHotel(request.getParameter("cHotels") != null);
		bean.setBeb(request.getParameter("cBeB") != null);
		bean.setHostel(request.getParameter("cHostels") != null);
		
		bean.setParking(request.getParameter("cParking") != null);
		bean.setRestaurant(request.getParameter("cRestaurant") != null);
		bean.setRoomService(request.getParameter("cRoomService") != null);
		bean.setGym(request.getParameter("cGym") != null);
		
		bean.setType();
		
		controller.registerStructure(ownerName, bean);
		request.setAttribute("regStr", "ok");
	
		beanLog.getStructList().clear();
		controller.changeExperiences(0,1,beanLog);
		session.setAttribute("beanLog",beanLog);

		RequestDispatcher view1 = request.getRequestDispatcher("addStructurePage.jsp");
		view1.forward(request, response);
	}

}

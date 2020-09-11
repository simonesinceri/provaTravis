package logic.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.bean.HotelBeanWeb;
import logic.controller.HotelControllerWeb;
import logic.exceptions.ExceptionSearchHotels;

/**
 * Servlet implementation class SearchHotel
 */
@WebServlet("/SearchHotel")
public class SearchHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SearchHotel() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HotelBeanWeb beanSearchHotel = new HotelBeanWeb();
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today	= LocalDate.now().format(dtf); 
		LocalDate oggi = LocalDate.parse(today, dtf);

		beanSearchHotel.setCity(request.getParameter("city"));
		beanSearchHotel.setNumPeople(Integer.valueOf(request.getParameter("numPeople"))); 
		
		
		LocalDate dateIn = LocalDate.parse(request.getParameter("datein"),dtf); 
		beanSearchHotel.setLocalDateIn(dateIn);
		
		LocalDate dateOut = LocalDate.parse(request.getParameter("dateout"),dtf);
		beanSearchHotel.setLocalDateOut(dateOut);
		
		RequestDispatcher view = request.getRequestDispatcher("hotelsView.jsp");
		
		if((dateIn.getYear() <= oggi.getYear()) && (dateIn.getMonthValue() <= oggi.getMonthValue()) &&(dateIn.getDayOfMonth() <= oggi.getDayOfMonth())) {

			request.setAttribute("dateNotValid", "invalid");
			view.forward(request, response);
		}
		
		
		if((dateOut.getYear() <= dateIn.getYear()) && (dateOut.getMonthValue() <= dateIn.getMonthValue()) && (dateOut.getDayOfMonth() <= dateIn.getDayOfMonth())) {
			
			request.setAttribute("dateNotValid", "invalid");
			view.forward(request, response);	
		}
		
		
		beanSearchHotel.setDays((int) ChronoUnit.DAYS.between(dateIn, dateOut));
		
		beanSearchHotel.setBudget1(request.getParameter("check50_100") != null);
		beanSearchHotel.setBudget2(request.getParameter("check100_150") != null);
		beanSearchHotel.setBudget3(request.getParameter("check150_200") != null);
		beanSearchHotel.setBudget4(request.getParameter("check200") != null);
	
		beanSearchHotel.setApartment(request.getParameter("checkApartments") != null);
		beanSearchHotel.setHotel(request.getParameter("checkHotels") != null);
		beanSearchHotel.setBeb(request.getParameter("checkBeB") != null);
		beanSearchHotel.setHostel(request.getParameter("checkHostels") != null);
		
		beanSearchHotel.setParking(request.getParameter("checkParking") != null);
		beanSearchHotel.setRestaurant(request.getParameter("checkRestaurant") != null);
		beanSearchHotel.setRoomService(request.getParameter("checkRoomService") != null);
		beanSearchHotel.setGym(request.getParameter("checkFitnessCenter") != null);
		
		beanSearchHotel.setStar1(request.getParameter("check1star") != null);
		beanSearchHotel.setStar2(request.getParameter("check2star") != null);
		beanSearchHotel.setStar3(request.getParameter("check3star") != null);
		beanSearchHotel.setStar4(request.getParameter("check4star") != null);
		beanSearchHotel.setStar5(request.getParameter("check5star") != null);
		
		beanSearchHotel.setType();

		HotelControllerWeb controller = HotelControllerWeb.getIstance();
		HttpSession session = request.getSession();
		
		controller.setPage(1);
		
		try {
			controller.changeScene2(0, beanSearchHotel);
		} catch (ExceptionSearchHotels e) {
			session.setAttribute("step", "2");
			
			RequestDispatcher viewExc = request.getRequestDispatcher("hotelsView3.jsp");
			viewExc.forward(request, response);
		}
		
		beanSearchHotel.setHotel1(controller.getHotel1());
		beanSearchHotel.setHotel2(controller.getHotel2());
		beanSearchHotel.setHotel3(controller.getHotel3());
		
		beanSearchHotel.setRoom1(controller.getRoom1());
		beanSearchHotel.setRoom2(controller.getRoom2());
		beanSearchHotel.setRoom3(controller.getRoom3());
		
		session.setAttribute("bean",beanSearchHotel);
		session.setAttribute("step", "1");
		
		RequestDispatcher view1 = request.getRequestDispatcher("hotelsView2.jsp");
		view1.forward(request, response);
		
	}

}

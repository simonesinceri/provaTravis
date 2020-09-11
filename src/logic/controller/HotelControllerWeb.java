package logic.controller;

import java.time.LocalDate;

import logic.dao.ReviewDao;
import logic.model.Review;
import logic.bean.HotelBeanWeb;
import logic.bean.ReviewBean;
import logic.model.Hotel;
import logic.dao.ExperienceDao;
import logic.dao.HotelDao;
import logic.model.Reservation;
import logic.dao.ReservationDao;
import logic.model.Room;
import logic.model.UserWeb;
import logic.dao.RoomDao;
import logic.exceptions.ExceptionSearchHotels;


public class HotelControllerWeb {
	
	private Hotel hotel1Web;
	private Room room1Web;
	private Hotel hotel2Web;
	private Room room2Web;
	private Hotel hotel3Web;
	private Room room3Web;

	
	private int step = 1;
	private int page = 0;
	private int hotelSelected;
	
	private int indiceWeb;
	
	private static HotelControllerWeb istance = null;
	
	
	public static HotelControllerWeb getIstance() {
		if (istance == null) {
			istance = new HotelControllerWeb();
		}
		return istance;
	}


	 private HotelControllerWeb() {
	
		this.hotel1Web = new Hotel();
		this.room1Web = new Room();
		this.hotel2Web = new Hotel();
		this.room2Web = new Room();
		this.hotel3Web = new Hotel();
		this.room3Web = new Room();
	 }
	
	public void changeScene2(int indexWeb, HotelBeanWeb beanWeb) throws ExceptionSearchHotels{
		
		int budgetWeb = 1000;
		
		if (beanWeb.isBudget1()){
			budgetWeb = 100;
		}
		if (beanWeb.isBudget2()){
			budgetWeb = 150;
		}
		if (beanWeb.isBudget3()){
			budgetWeb = 200;
		}
		if (beanWeb.isBudget4()){
			budgetWeb = 1000;
		}
	
		int starsWeb = 0;
	
		if (beanWeb.getStar5()){
			starsWeb = 5;
		}
		if (beanWeb.getStar4()){
			starsWeb = 4;
		}
		if (beanWeb.getStar3()){
			starsWeb = 3;
		}
		if (beanWeb.getStar2()){
			starsWeb = 2;
		}
		if (beanWeb.getStar1()){
			starsWeb = 1;
		}
	
		boolean change = false;
		
		try {
			
			change = getHotelWeb1(budgetWeb, starsWeb, indexWeb, beanWeb);
			
			beanWeb.setPage(getPage());
			
			indexWeb = getIndice();
			
			getHotelWeb2(budgetWeb, starsWeb, indexWeb, beanWeb);
			
			indexWeb = getIndice();
			
			getHotelWeb3(budgetWeb, starsWeb, indexWeb, beanWeb);
			
		} catch (ExceptionSearchHotels e) {
			e.printStackTrace();
			throw e;
		}
		
		if (!change && getPage() != 1) {
			page = getPage()-1;
			beanWeb.setPage(page);
			indexWeb = getIndice()-3;
			changeScene2(indexWeb, beanWeb);
		}
	}
	
	private boolean getHotelWeb1(int budgetWeb, int starsWeb, int indexWeb, HotelBeanWeb beanWeb) throws ExceptionSearchHotels {
		
		boolean exit1 = true;
		
		while (exit1) {
			
			indexWeb++;
			
			try {
				hotel1Web = HotelDao.searchHotel(beanWeb, starsWeb, indexWeb);
			} catch (ExceptionSearchHotels e) {
				e.printStackTrace();
				throw e;
			}

			if (hotel1Web.getHotelName() != null) {
				
				boolean validWeb1 = getRoomWeb1(budgetWeb, indexWeb, beanWeb);
				
				if (validWeb1) {
					exit1 = !validWeb1;
				}
				
			} else {
				return false;
			}
		}
		return true;
	}
	
	private boolean getRoomWeb1(int budgetWeb, int indexWeb, HotelBeanWeb beanWeb) {
		
		int roomIndexWeb1 = 1;
		
		boolean validRoom1Web = true;
		
		while (validRoom1Web) {
			validRoom1Web = false;
			room1Web = RoomDao.searchRoom(hotel1Web.getHotelRooms(), beanWeb.getNumPeople(), budgetWeb, roomIndexWeb1);
			if (room1Web.getRoomId() == 0) {
				break;
			}
			
			LocalDate dayWeb = beanWeb.getLocalDateIn();
			dayWeb = dayWeb.plusDays(-1);
			
			int dayIndexWeb = 0;
			
			while (dayIndexWeb<=beanWeb.getDays()) {
				
				dayWeb = dayWeb.plusDays(1);
				
				int dateWeb = (dayWeb.getYear()*10000) + (dayWeb.getMonth().getValue()*100) + (dayWeb.getDayOfMonth());
				
				Reservation reservation1Web = ReservationDao.searchReservation(hotel1Web.getHotelAgenda(), room1Web.getRoomId(), dateWeb);
				if (room1Web.getRoomId() == reservation1Web.getReservationId()) {
					validRoom1Web = false;
					break;
				
				} else {
					dayIndexWeb++;
					validRoom1Web = true;
				}
			}
			
			if (!validRoom1Web) {
				roomIndexWeb1++;
			} else {
				
				setIndice(indexWeb);
				return true;
			}
		}
		return false;
	}
	
	private void getHotelWeb2(int budgetWeb, int starsWeb, int indexWeb, HotelBeanWeb beanWeb) throws ExceptionSearchHotels {
		
		boolean exit2 = true;
		
		while (exit2) {
			
			indexWeb++;
			
			try {
				hotel2Web = HotelDao.searchHotel(beanWeb, starsWeb, indexWeb);
			} catch (ExceptionSearchHotels e) {
				e.printStackTrace();
				throw e;
			}
			
			if (hotel2Web.getHotelName() != null) {
				
				boolean validWeb2 = getRoomWeb2(budgetWeb, indexWeb, beanWeb);
				
				if (validWeb2) {
					exit2 = !validWeb2;
				}
				
			} else {
				exit2 = false;				
			}	
		}
	}
	
	private boolean getRoomWeb2(int budgetWeb, int indexWeb, HotelBeanWeb beanWeb) {
		
		int roomIndexWeb2 = 1;
		
		boolean validRoom2Web = true;
		
		while (validRoom2Web) {
			validRoom2Web = false;
			room2Web = RoomDao.searchRoom(hotel2Web.getHotelRooms(), beanWeb.getNumPeople(), budgetWeb, roomIndexWeb2);
			if (room2Web.getRoomId() == 0) {
				break;
			}
			
			LocalDate dayWeb = beanWeb.getLocalDateIn();
			dayWeb = dayWeb.plusDays(-1);
			
			int dayIndexWeb = 0;
			
			while (dayIndexWeb<=beanWeb.getDays()) {
				
				dayWeb = dayWeb.plusDays(1);
				
				int date = (dayWeb.getYear()*10000) + (dayWeb.getMonth().getValue()*100) + (dayWeb.getDayOfMonth());
				
				Reservation reservation2Web = ReservationDao.searchReservation(hotel2Web.getHotelAgenda(), room2Web.getRoomId(), date);
				if (room2Web.getRoomId() == reservation2Web.getReservationId()) {
					validRoom2Web = false;
					break;
				
				} else {
					dayIndexWeb++;
					validRoom2Web = true;
				}
			}
			
			if (!validRoom2Web) {
				roomIndexWeb2++;
			} else {
				setIndice(indexWeb);
				return true;					
			}
		}
		return false;
	}
	
	private void getHotelWeb3(int budgetWeb, int starsWeb, int indexWeb, HotelBeanWeb beanWeb) throws ExceptionSearchHotels {
		
		boolean exit3 = true;
		
		while (exit3) {
			
			indexWeb++;
			
			try {
				hotel3Web = HotelDao.searchHotel(beanWeb, starsWeb, indexWeb);
			} catch (ExceptionSearchHotels e) {
				e.printStackTrace();
				throw e;
			}
			
			if (hotel3Web.getHotelName() != null) {
				
				boolean validWeb3 = getRoomWeb3(budgetWeb, indexWeb, beanWeb);

				if (validWeb3) {
					exit3 = !validWeb3;
				}
				
			} else {
				exit3 = false;				
			}	
		}
	}
	
	private boolean getRoomWeb3(int budgetWeb, int indexWeb, HotelBeanWeb beanWeb) {
		
		int roomIndexWeb3 = 1;
		
		boolean validRoom3Web = true;
		
		while (validRoom3Web) {
			validRoom3Web = false;
			room3Web = RoomDao.searchRoom(hotel3Web.getHotelRooms(), beanWeb.getNumPeople(), budgetWeb, roomIndexWeb3);
			if (room3Web.getRoomId() == 0) {
				break;
			}
			
			LocalDate dayWeb = beanWeb.getLocalDateIn();
			dayWeb = dayWeb.plusDays(-1);
			
			int dayIndexWeb = 0;
			
			while (dayIndexWeb<=beanWeb.getDays()) {
				
				dayWeb = dayWeb.plusDays(1);
				
				int date = (dayWeb.getYear()*10000) + (dayWeb.getMonth().getValue()*100) + (dayWeb.getDayOfMonth());
				
				Reservation reservation3Web = ReservationDao.searchReservation(hotel3Web.getHotelAgenda(), room3Web.getRoomId(), date);
				if (room3Web.getRoomId() == reservation3Web.getReservationId()) {
					validRoom3Web = false;
					break;
				
				} else {
					dayIndexWeb++;
					validRoom3Web = true;
				}
			}
			
			if (!validRoom3Web) {
				roomIndexWeb3++;
			} else {
				setIndice(indexWeb);
				return true;					
			}
		}
		return false;
	}
	
	public int getIndice() {
		return indiceWeb;
	}

	public void setIndice(int indice) {
		this.indiceWeb = indice;
	}
	
	
	public void viewReviews(String reviewTable, int indice, ReviewBean reviewBeanWeb) {
		
		Review r1Web = null;
		Review r2Web = null;
		Review r3Web = null;
		
		
		try {
			indice++;
			r1Web = ReviewDao.getReview(reviewTable, indice);
			reviewBeanWeb.getReviewList().add(0,r1Web);
			indice++;
			r2Web = ReviewDao.getReview(reviewTable, indice);
			reviewBeanWeb.getReviewList().add(1,r2Web);
			indice++;
			r3Web = ReviewDao.getReview(reviewTable, indice);
			reviewBeanWeb.getReviewList().add(2, r3Web);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		reviewBeanWeb.setIndex(indice);
	}
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getHotelSelected() {
		return hotelSelected;
	}

	public void setHotelSelected(int hotelSelected) {
		this.hotelSelected = hotelSelected;
	}

	
	public boolean setReservation(Hotel hotel, Room room, HotelBeanWeb bean, UserWeb user) {	
		
			LocalDate day = bean.getLocalDateIn();
			day = day.plusDays(-1);
			
			int dayIndex = 0; 
			
			try {

				while (dayIndex<=bean.getDays()) {
					
					day = day.plusDays(1);
					
					int date = (day.getYear()*10000) + (day.getMonth().getValue()*100) + (day.getDayOfMonth());
					
					ReservationDao.setReservation(hotel.getHotelAgenda(), room.getRoomId(), date, user.getUsername());
					
					dayIndex++;
					
				}

				LocalDate dayIn = bean.getLocalDateIn();
				int dateIn = (dayIn.getYear()*10000) + (dayIn.getMonth().getValue()*100) + (dayIn.getDayOfMonth());
				LocalDate dayOut = bean.getLocalDateOut();
				int dateOut = (dayOut.getYear()*10000) + (dayOut.getMonth().getValue()*100) + (dayOut.getDayOfMonth());
				
				ExperienceDao.setExperienceRow(user.getReviewsTable(), hotel.getHotelName(), dateIn, dateOut);
				
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return false;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Hotel getHotel1() {
		return hotel1Web;
	}

	public void setHotel1(Hotel hotel1) {
		this.hotel1Web = hotel1;
	}
	
	public Hotel getHotel2() {
		return hotel2Web;
	}

	public void setHotel2(Hotel hotel2) {
		this.hotel2Web = hotel2;
	}
	
	public Hotel getHotel3() {
		return hotel3Web;
	}

	public void setHotel3(Hotel hotel3) {
		this.hotel3Web = hotel3;
	}

	public Room getRoom1() {
		return room1Web;
	}

	public void setRoom1(Room room1) {
		this.room1Web = room1;
	}

	public Room getRoom2() {
		return room2Web;
	}

	public void setRoom2(Room room2) {
		this.room2Web = room2;
	}

	public Room getRoom3() {
		return room3Web;
	}

	public void setRoom3(Room room3) {
		this.room3Web = room3;
	}
	

}

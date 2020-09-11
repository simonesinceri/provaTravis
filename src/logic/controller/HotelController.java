package logic.controller;

import java.time.LocalDate;

import javafx.scene.layout.AnchorPane;
import logic.bean.HotelBean;
import logic.bean.ReviewBean;
import logic.model.Hotel;
import logic.model.Owner;
import logic.dao.ExperienceDao;
import logic.dao.HotelDao;
import logic.model.Reservation;
import logic.model.Review;
import logic.dao.ReservationDao;
import logic.dao.ReviewDao;
import logic.model.Room;
import logic.model.User;
import logic.dao.RoomDao;
import logic.exceptions.ExceptionSearchHotels;
import logic.exceptions.ExceptionSearchReview;
import logic.view.Hotel2Scene;
import logic.view.Hotel3Scene;
import logic.view.HotelConfirmScene;
import logic.view.HotelScene;
import logic.view.ViewReviewScene;


public class HotelController {
	
	private Hotel2Scene hotel2Scene;
	private Hotel3Scene hotel3Scene;
	private HotelBean bean;
	private Hotel hotel1;
	private Room room1;
	private Hotel hotel2;
	private Room room2;
	private Hotel hotel3;
	private Room room3;
	private AnchorPane pane;
	
	private int step = 1;
	private int page = 0;
	private int hotelSelected;
	
	private int indice;
	
	private static HotelController istance = null;
	
	public static HotelController getIstance(AnchorPane pane) {
		if (istance == null) {
			istance = new HotelController(pane);
		}
		return istance;
	}

	private HotelController(AnchorPane pane) {
	
		this.bean = new HotelBean();
		this.hotel1 = new Hotel();
		this.room1 = new Room();
		this.hotel2 = new Hotel();
		this.room2 = new Room();
		this.hotel3 = new Hotel();
		this.room3 = new Room();
		this.pane = pane;
	}
	
	public void changeScene(){
		
		if (step == 1) {
			
			HotelScene hotelScene = new HotelScene(this,bean);
			
			pane.getChildren().clear();
			pane.getChildren().add(hotelScene);
			
		} else if (step == 2) {
			
			setPage(page-1);

			if ((indice%3) == 0) {
					indice = indice - 3;
				} else if ((indice%3) == 1) {
	 				indice = indice - 1;
				} else {
					indice = indice - 2;
				}
			try {
				changeScene2(indice);
			} catch (ExceptionSearchHotels e) {
				e.printStackTrace();
			}
		} else if (step == 3) {
			viewHotel(hotelSelected);
		}
	}
	
	public void changeScene2(int index) throws ExceptionSearchHotels{
		
		int budget = 1000;
		
		if (bean.isBudget1()){
			budget = 100;
		}
		if (bean.isBudget2()){
			budget = 150;
		}
		if (bean.isBudget3()){
			budget = 200;
		}
		if (bean.isBudget4()){
			budget = 1000;
		}
		
		int stars = 0;
		
		if (bean.getStar5()){
			stars = 5;
		}
		if (bean.getStar4()){
			stars = 4;
		}
		if (bean.getStar3()){
			stars = 3;
		}
		if (bean.getStar2()){
			stars = 2;
		}
		if (bean.getStar1()){
			stars = 1;
		}

		boolean change = false;
		
		try {
			change = getHotel1(budget, stars, index);
			
			index = getIndice();
			
			getHotel2(budget, stars, index);
			
			index = getIndice();
				
			getHotel3(budget, stars, index);
			
		} catch (ExceptionSearchHotels e) {
			e.printStackTrace();
			throw e;
		}
		
		if (change || indice == 0) {
			hotel2Scene = new Hotel2Scene(this,hotel1,room1,hotel2,room2,hotel3,room3);
			
			pane.getChildren().clear();
			pane.getChildren().add(hotel2Scene);
		}
	}
	
	private boolean getHotel1(int budget, int stars, int index) throws ExceptionSearchHotels {
		
		boolean valid1 = true;
		
		boolean good = false;
		
		while (valid1) {
			
			index++;
			
			try {
				hotel1 = HotelDao.searchHotel(bean, stars, index);
			} catch (ExceptionSearchHotels e) {
			e.printStackTrace();
			throw e;
			}
		
			if (hotel1.getHotelName() != null) {
				
				good = getRoom1(budget, index);
					
			} else {
				
				if (index != 1) {
					return false;
				}
				valid1 = false;
			}
			
			if (good) {
				valid1 = false;
			}
		}
		
		return good;
	}
	
	private boolean getRoom1(int budget, int index) {
		
		int roomIndex1 = 1;

		boolean validRoom1 = false;
		
		boolean good = false;
		
		while (!validRoom1) {
			room1 = RoomDao.searchRoom(hotel1.getHotelRooms(), bean.getNumPeople(), budget, roomIndex1);
			if (room1.getRoomId() == 0) {
				break;
			}
			
			LocalDate day = bean.getLocalDateIn();
			day = day.plusDays(-1);
			
			int dayIndex = 0;
			
			while (dayIndex<=bean.getDays()) {
				
				day = day.plusDays(1);
				
				int date = (day.getYear()*10000) + (day.getMonth().getValue()*100) + (day.getDayOfMonth());
				
				Reservation reservation1 = ReservationDao.searchReservation(hotel1.getHotelAgenda(), room1.getRoomId(), date);
				if (room1.getRoomId() == reservation1.getReservationId()) {
					validRoom1 = false;
					break;
				
				} else {
					dayIndex++;
					validRoom1 = true;
				}
			}
			
			if (!validRoom1) {
				roomIndex1++;
			} else {
				good = true;
				
				page(indice, index);
				
				setIndice(index);							
			}
		}
		
		return good;
	}
	
	private void page(int indice, int index) {
		
		if (indice < index) {
			setPage(page+1);
		} else {
			setPage(page-1);
		}
	}
	
	private void getHotel2(int budget, int stars, int index) throws ExceptionSearchHotels {
		
		boolean valid2 = true;
		
		while (valid2) {
			
			index++;
			
			try {
				hotel2 = HotelDao.searchHotel(bean, stars, index);
			} catch (ExceptionSearchHotels e) {
			e.printStackTrace();
			throw e;
			}
			
			if (hotel2.getHotelName() != null) {
				
				valid2 = getRoom2(budget, index);
				
			} else {
				break;				
			}	
		}
	}
	
	private boolean getRoom2(int budget, int index) {
		
		int roomIndex2 = 1;
		
		boolean validRoom2 = true;
		
		while (validRoom2) {
			room2 = RoomDao.searchRoom(hotel2.getHotelRooms(), bean.getNumPeople(), budget, roomIndex2);
			if (room2.getRoomId() == 0) {
				break;
			}
			
			LocalDate day = bean.getLocalDateIn();
			day = day.plusDays(-1);
			
			int dayIndex = 0;
			
			while (dayIndex<=bean.getDays()) {
				
				day = day.plusDays(1);
				
				int date = (day.getYear()*10000) + (day.getMonth().getValue()*100) + (day.getDayOfMonth());
				
				Reservation reservation2 = ReservationDao.searchReservation(hotel2.getHotelAgenda(), room2.getRoomId(), date);
				if (room2.getRoomId() == reservation2.getReservationId()) {
					validRoom2 = false;
					break;
				
				} else {
					dayIndex++;
					validRoom2 = true;
				}
			}
			
			if (!validRoom2) {
				roomIndex2++;
			} else {
				setIndice(index);
				return false;
			}
		}
		return true;
	}
	
	private void getHotel3(int budget, int stars, int index) throws ExceptionSearchHotels {
		
		boolean valid3 = true;
		
		while (valid3) {
			
			index++;
			
			try {
				hotel3 = HotelDao.searchHotel(bean, stars, index);
			} catch (ExceptionSearchHotels e) {
			e.printStackTrace();
			throw e;
			}
			
			if (hotel3.getHotelName() != null) {
				
				valid3 = getRoom3(budget, index);
				
			} else {
				break;				
			}	
		}
	}
	
	private boolean getRoom3(int budget, int index) {
		
		int roomIndex3 = 1;
		
		boolean validRoom3 = true;

		while (validRoom3) {
			room3 = RoomDao.searchRoom(hotel3.getHotelRooms(), bean.getNumPeople(), budget, roomIndex3);
			if (room3.getRoomId() == 0) {
				break;
			}
			
			LocalDate day = bean.getLocalDateIn();
			day = day.plusDays(-1);
			
			int dayIndex = 0;
			
			while (dayIndex<=bean.getDays()) {
				
				day = day.plusDays(1);
				
				int date = (day.getYear()*10000) + (day.getMonth().getValue()*100) + (day.getDayOfMonth());
				
				Reservation reservation3 = ReservationDao.searchReservation(hotel3.getHotelAgenda(), room3.getRoomId(), date);
				if (room3.getRoomId() == reservation3.getReservationId()) {
					validRoom3 = false;
					break;
				
				} else {
					dayIndex++;
					validRoom3 = true;
				}
			}
			
			if (!validRoom3) {
				roomIndex3++;
			} else {
				setIndice(index);
				return false;
			}
		}
		return true;
	}
	
	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public void viewHotel(int i) {
		
		if (i == 1) {
			
			if (hotel1.getHotelName() == null) {
				return;
			}
			
			hotel3Scene = new Hotel3Scene(this, hotel1, room1);
			pane.getChildren().clear();
			pane.getChildren().add(hotel3Scene);
			
		} else if (i == 2) {
			
			if (hotel2.getHotelName() == null) {
				return;
			}
			
			hotel3Scene = new Hotel3Scene(this, hotel2, room2);
			pane.getChildren().clear();
			pane.getChildren().add(hotel3Scene);
			
		} else {
			
			if (hotel3.getHotelName() == null) {
				return;
			}
			
			hotel3Scene = new Hotel3Scene(this, hotel3, room3);
			pane.getChildren().clear();
			pane.getChildren().add(hotel3Scene);
		}
	}
	
	public void returnBackList() {
		
		pane.getChildren().clear();
		pane.getChildren().add(hotel2Scene);
	
	}
	
	public void goToBook(Hotel hotel, Room room) {
		
		HotelConfirmScene hotelConfirmScene = new HotelConfirmScene(this, bean, hotel, room);
		
		pane.getChildren().clear();
		pane.getChildren().add(hotelConfirmScene);
	}
	
	public void returnBackHotelPage() {
		
		pane.getChildren().clear();
		pane.getChildren().add(hotel3Scene);
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

	public boolean setReservation(Hotel hotel, Room room) {

		User user = User.getIstance();
		Owner owner = Owner.getIstance();
		ProfileController loginController = ProfileController.getIstance(pane);
		
		if (owner.getOwnerLogged()) {
			return false;
		}
		
		if (!user.getUserLogged()){
			
			loginController.setBooking(true);
			
			loginController.openLogWindow(false);
			
		}
		
		if (user.getUserLogged()) {

			LocalDate day = bean.getLocalDateIn();
			day = day.plusDays(-1);
			
			int dayIndex = 0;
			
			try {

				while (dayIndex<=bean.getDays()) {
					
					day = day.plusDays(1);
					
					int date = (day.getYear()*10000) + (day.getMonth().getValue()*100) + (day.getDayOfMonth());
					
					ReservationDao.setReservation(hotel.getHotelAgenda(), room.getRoomId(), date, user.getUserName());
					
					dayIndex++;
					
				}

				LocalDate dayIn = bean.getLocalDateIn();
				int dateIn = (dayIn.getYear()*10000) + (dayIn.getMonth().getValue()*100) + (dayIn.getDayOfMonth());
				LocalDate dayOut = bean.getLocalDateOut();
				int dateOut = (dayOut.getYear()*10000) + (dayOut.getMonth().getValue()*100) + (dayOut.getDayOfMonth());
				
				ExperienceDao.setExperienceRow(user.getUserReviewsTable(), hotel.getHotelName(), dateIn, dateOut);
				
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public void viewReviews(boolean isHotel, String reviewTable, int indice) throws ExceptionSearchReview {
	
		ProfileController profileController = ProfileController.getIstance(pane);
		ReviewBean reviewBean = new ReviewBean();
		
		Review r1 = null;
		Review r2 = null;
		Review r3 = null;
		
		try {
			indice++;
			r1 = ReviewDao.getReview(reviewTable, indice);
			reviewBean.getReviewList().add(0, r1);
			indice++;
			r2 = ReviewDao.getReview(reviewTable, indice);
			reviewBean.getReviewList().add(1, r2);
			indice++;
			r3 = ReviewDao.getReview(reviewTable, indice);
			reviewBean.getReviewList().add(2, r3);
		} catch (ExceptionSearchReview e) {
			e.printStackTrace();
			throw e;
		}
		
		if (r1 != null) {

			ViewReviewScene viewReviewScene = new ViewReviewScene(isHotel,this,reviewBean,reviewTable,indice,profileController);

			pane.getChildren().clear();
			pane.getChildren().add(viewReviewScene);
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}

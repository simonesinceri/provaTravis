package web_2.logic.controller;


import javafx.stage.Stage;
import web_2.logic.dao.ReviewDao;
import web_2.logic.model.Review;
import web_2.logic.bean.HotelBean;
//import logic.view.ViewReviewWindow;
//import logic.view.WriteReviewWindow;
//import logic.view.User2Scene;
import web_2.logic.bean.HotelBeanWeb;
import web_2.logic.bean.LoginBeanWeb;
import web_2.logic.dao.ExperienceDao;
//import logic.dao.ExperienceDao;
import web_2.logic.dao.HotelDao;
import web_2.logic.dao.OwnerDao;
import web_2.logic.dao.RoomDao;
import web_2.logic.dao.StructureDao;
import web_2.logic.model.Experience;
//import logic.dao.StructureDao;
//import logic.model.Experience;
import web_2.logic.model.Hotel;
import web_2.logic.model.Login;
import web_2.logic.model.Owner;
import web_2.logic.model.OwnerWeb;
import web_2.logic.model.Structure;
//import logic.model.Structure;
import web_2.logic.model.UserWeb;
//import logic.view.AddRoomScene;
//import logic.view.HotelRegistrationScene;
//import logic.view.LogWindow;
//import logic.view.ProfileScene;
//import logic.view.StructureScene;
//import logic.view.User2Scene;


public class LoginControllerWeb {

	//private ProfileScene profileScene;
	//private User2Scene userScene;
	//private LogWindow window;
	//private AnchorPane pane;
	private Login login;
	//private LoginBean bean;
	private UserWeb user;
	private OwnerWeb owner;

	private int page = 0;
	private int indice;
	
	private boolean booking = false;
	
	public void setBooking(boolean booking) {
		this.booking = booking;
	}

	private static LoginControllerWeb istance = null;
	
	//public static LoginController getIstance(AnchorPane pane) {
	public static LoginControllerWeb getIstance() {
		if (istance == null) {
			//istance = new LoginController(pane);
			istance = new LoginControllerWeb();
		}
		return istance;
	}

	//private LoginController(AnchorPane pane) {
	private LoginControllerWeb() {
		this.login = new Login();
		//this.bean = new LoginBean();
		this.user = new UserWeb();
		this.owner = new OwnerWeb();
		//this.pane = pane;
	}
	
	//public void login(LoginBean bean) {
	public void login(LoginBeanWeb bean) {
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		//this.user = login.checkUserWeb(username, password);
		 UserWeb user = login.checkUserWeb(username, password);
		
		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
			bean.setResult(true);
			bean.setUserWebLog(user);
		} else {
			 OwnerWeb owner = login.checkOwnerWeb(username, password);
			if (owner.getUsername().equals(username) && owner.getPassword().equals(password)) {
				bean.setResult(true);
				bean.setOwnerWebLog(owner);
			} else {			
				bean.setResult(false);
			}
		}
		//problema owner
		//dobrei settare i ritorni nella bean e mettere che ritorna void
		//return user;
	}
	
	public boolean registerUser(LoginBeanWeb bean) {
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		boolean result = false;
		
		if (login.registerUserString(username, password)) {
			result = true;
		}		
		
		return result;
	}
	
	public boolean registerOwner(LoginBeanWeb bean) {
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		boolean result = false;
		
		if (login.registerOwnerString(username, password)) {
			result = true;
		}		
		
		return result;
	}
	
	/*
	public void changeScene() {
		if (!user.getLogged()) {
			if (!owner.getLogged()) {
				
				profileScene = new ProfileScene(this);
				
				pane.getChildren().clear();
				pane.getChildren().add(profileScene);
			} else {
				this.loggedScene();
			}
		} else {
			this.loggedScene();
		}
	}
	
	public void openLogWindow() {
		window = new LogWindow();
		window.Log(this,bean);
	}
	
	public boolean openRegisterWindow() {
		window = new LogWindow();
		return window.Register(this,bean);
	}
	
	public void loggedScene() {
		
		if (booking) {
			
			setBooking(false);
			
		} else {
			
			setIndice(0);
			setPage(0);

			if (user.getLogged()) {
				
				changeExperiences(0,0);
				
			} else {

				changeExperiences(0,1);
			}
			
			pane.getChildren().clear();
			pane.getChildren().add(userScene);
		}
	}
	*/
	public void changeExperiences(int index, int tipo, LoginBeanWeb bean) {
		
        try {
	        	boolean newPage = false;
	        	
	        	if (index == 0) {
	        		newPage = true;
	        	}
	        
	        	String table;
	        
	        	if (tipo == 0) {
	        		
	        		table = bean.getUserWebLog().getReviewsTable();
	        		
	        	
	        		index++;
					
					Experience experience1 = ExperienceDao.getExperience(table, index);
					
					if (experience1.getName() != null) {
						// arraylist va istanziata
						bean.getExpList().add(0, experience1);
						if (indice < index) {
							setPage(page+1);
						} else {
							setPage(page-1);
						}
						
						setIndice(index);
						
						newPage = true;
					}
					
					if (newPage) {
						
						index++;
						Experience experience2 = ExperienceDao.getExperience(table, index);
						if (experience2.getName() != null) {
							setIndice(index);
							bean.getExpList().add(1, experience2);
						}
						index++;
						Experience experience3 = ExperienceDao.getExperience(table, index);
						if (experience3.getName() != null) {
							setIndice(index);
							bean.getExpList().add(2, experience3);
						}
						index++;
						Experience experience4 = ExperienceDao.getExperience(table, index);
						if (experience4.getName() != null) {
							setIndice(index);
							bean.getExpList().add(3, experience4);
						}
						index++;
						Experience experience5 = ExperienceDao.getExperience(table, index);
						if (experience5.getName() != null) {
							setIndice(index);
							bean.getExpList().add(4, experience5);
						}
						index++;
						Experience experience6 = ExperienceDao.getExperience(table, index);
						if (experience6.getName() != null) {
							setIndice(index);
							bean.getExpList().add(5, experience6);
						}
						
						// numeri pre page profilo
						int booked = ExperienceDao.getBooked(table);
						int review = ExperienceDao.getReviewsNumber(table);
						
						bean.setBooked(booked);
						bean.setReview(review);
						
						//dovrei mettere questo nella bean per la parte web
						
						/*
						userScene = new User2Scene(this,user,experience1,experience2,experience3,experience4,experience5,experience6,booked,review);

						pane.getChildren().clear();
						pane.getChildren().add(userScene);
						*/
					}
	        	
	        	} else {
	        		
	        		table = bean.getOwnerWebLog().getStructures();
	        		
	        		index++;
					
					Structure structure1 = StructureDao.getStructure(table, index);
					
					if (structure1.getName() != null) {
						bean.getStructList().add(0, structure1);
						
						if (indice < index) {
							setPage(page+1);
						} else {
							setPage(page-1);
						}
						
						setIndice(index);
						
						newPage = true;
					}
					
					if (newPage) {
						
						index++;
						Structure structure2 = StructureDao.getStructure(table, index);
						if (structure2.getName() != null) {
							setIndice(index);
							bean.getStructList().add(1, structure2);
						}
						index++;
						Structure structure3 = StructureDao.getStructure(table, index);
						if (structure3.getName() != null) {
							bean.getStructList().add(2, structure3);
							setIndice(index);
						}
						index++;
						Structure structure4 = StructureDao.getStructure(table, index);
						if (structure4.getName() != null) {
							bean.getStructList().add(3, structure4);
							setIndice(index);
						}
						index++;
						Structure structure5 = StructureDao.getStructure(table, index);
						if (structure5.getName() != null) {
							bean.getStructList().add(4, structure5);
							setIndice(index);
						}
						index++;
						Structure structure6 = StructureDao.getStructure(table, index);
						if (structure6.getName() != null) {
							bean.getStructList().add(5, structure6);
							setIndice(index);
						}
						
						int structures = StructureDao.getStructures(table);
						bean.setStructures(structures);
						
						// questa roba nella bean
						/*
						userScene = new User2Scene(this,owner,structure1,structure2,structure3,structure4,structure5,structure6,structures);

						pane.getChildren().clear();
						pane.getChildren().add(userScene);
						*/
					}
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
	
	/*
	public void setStructure(String name) {
		
		HotelBean bean = new HotelBean();
		
		HotelRegistrationScene registerScene = new HotelRegistrationScene(this,name,bean);

		pane.getChildren().clear();
		pane.getChildren().add(registerScene);
		
	}
	*/
	public void registerStructure(String ownerName, HotelBean bean) {
		
		try {
			HotelDao.setHotel(bean.getName(), ownerName, bean.getType(), bean.getCity(), bean.getAddress(), 0, bean.getParking(), bean.getRestaurant(), bean.getRoomService(), bean.getGym());
			OwnerDao.setStructure(ownerName, bean.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addDescription(String description, String structure) {
		
		try {
			HotelDao.setDescription(description,structure);
			System.out.println(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addRoom(String roomsTable, int id, int beds, int price) {
		
		Boolean setted = null;
		try {
			setted = RoomDao.setRoom(roomsTable, id, beds, price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (setted) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	public void openStructureWindow(String structure) {
		
		try {
			
			Hotel hotel = HotelDao.getHotel(structure);
			new StructureScene(this,hotel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addRoomScene(Stage window, String roomsTable, String structure) {
		
		new AddRoomScene(window,this,roomsTable,structure);
		
	}
	
	public boolean addRoom(String roomsTable, int id, int beds, int price) {
		
		Boolean setted = null;
		try {
			setted = RoomDao.setRoom(roomsTable, id, beds, price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (setted) {
			return true;
		} else {
			return false;
		}
	}

	
	public void review(Experience experience) {
		
		Review review = new Review();
		review.setUser(user.getUsername());
		review.setReview(experience.getReview());
		review.setVote(experience.getRating());
		
		if (bool) {
			new WriteReviewWindow(this,review,experience.getName(),experience.getDayIn(),experience.getDayOut());
		} else {
			new ViewReviewWindow(this,review,experience.getName());
		}
	}
	*/
	public void addReview(Review review, String structure, int dayIn, int dayOut, UserWeb user) {
		
		try {
			Hotel hotel1 = HotelDao.getHotel(structure);
			ExperienceDao.addReview(review, structure, dayIn, dayOut, user.getReviewsTable());
		
			int avg = ReviewDao.setReview(review.getReview(), review.getVote(), user.getUsername(), hotel1.getReviews());
			
			HotelDao.setRating(avg, structure);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
}
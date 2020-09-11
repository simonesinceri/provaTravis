package logic.controller;


import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.bean.HotelBean;
import logic.bean.LoginBean;
import logic.dao.ExperienceDao;
import logic.dao.HotelDao;
import logic.dao.OwnerDao;
import logic.dao.ReviewDao;
import logic.dao.RoomDao;
import logic.dao.StructureDao;
import logic.exceptions.ExistingOwnerException;
import logic.exceptions.ExistingUsernameException;
import logic.exceptions.LengthReviewException;
import logic.exceptions.UsernameException;
import logic.model.Experience;
import logic.model.Hotel;
import logic.model.Login;
import logic.model.Owner;
import logic.model.Review;
import logic.model.Structure;
import logic.model.User;
import logic.view.AddRoomScene;
import logic.view.AddDescriptionScene;
import logic.view.HotelRegistrationScene;
import logic.view.LogWindow;
import logic.view.ProfileScene;
import logic.view.StructureScene;
import logic.view.User2Scene;
import logic.view.User2SceneOwner;
import logic.view.ViewReviewWindow;
import logic.view.WriteReviewWindow;


public class ProfileController {

	private User2Scene userScene;
	private User2SceneOwner userSceneOwner;
	private LogWindow window;
	private AnchorPane pane;
	private Login login;
	private LoginBean bean;
	private User user;
	private Owner owner;

	private int page = 0;
	private int indice;
	
	private boolean booking = false;
	
	public void setBooking(boolean booking) {
		this.booking = booking;
	}

	private static ProfileController istance = null;
	
	public static ProfileController getIstance(AnchorPane pane) {
		if (istance == null) {
			istance = new ProfileController(pane);
		}
		return istance;
	}

	private ProfileController(AnchorPane pane) {
		this.login = new Login();
		this.bean = new LoginBean();
		this.user = User.getIstance();
		this.owner = Owner.getIstance();
		this.pane = pane;
	}
	
	public void login(){
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		this.user = login.checkUser(username);
		
		if (user.getUserName().equals(username) && user.getUserPassword().equals(password)) {
			bean.setResult(true);
		} else {
			this.owner = login.checkOwner(username);
			boolean ownerLogged = false;
			if (owner.getOwnerUsername().equals(username) && owner.getOwnerPassword().equals(password)) {
				ownerLogged = true;
			}
			bean.setResult(ownerLogged);
		}
	}
	
	public boolean registerUser() throws ExistingUsernameException, UsernameException {
		
		String username = bean.getUsername();
		
		if(username.length() > 20) {
			throw new UsernameException();
		}
		
		String password = bean.getPassword();
		
		boolean result = false;
		
		try {
			result = login.registerUserString(username, password);
		}catch(ExistingUsernameException e) {
			e.printStackTrace();
			throw e;
		}
		
		
		return result;
	}
	
	public boolean registerOwner() throws ExistingOwnerException, UsernameException{
		
		String username = bean.getUsername();
		
		if(username.length() > 20) {
			throw new UsernameException();
		}
		
		String password = bean.getPassword();
		
		boolean result = false;
		
		try {
			result = login.registerOwnerString(username, password);
		}catch(ExistingOwnerException e) {
			e.printStackTrace();
			throw e;
		}
	
		return result;
	}
	
	public void changeScene() {
		if (!user.getUserLogged()) {
			if (!owner.getOwnerLogged()) {
				
				ProfileScene profileScene = new ProfileScene(this);
				
				pane.getChildren().clear();
				pane.getChildren().add(profileScene);
			} else {
				this.loggedScene();
			}
		} else {
			this.loggedScene();
		}
	}
	
	public void openLogWindow(boolean newUser) {
		window = new LogWindow();
		window.log(this,bean, newUser);
	}
	
	public boolean openRegisterWindow() {
		window = new LogWindow();
		return window.register(this,bean);
	}
	
	public void loggedScene() {
		
		if (booking) {
			
			setBooking(false);
			
		} else {
			
			setIndice(0);
			setPage(0);

			if (user.getUserLogged()) {
				
				changeExperiences(0);
				pane.getChildren().clear();
				pane.getChildren().add(userScene);
				
			} else {

				changeStructures(0);
				pane.getChildren().clear();
				pane.getChildren().add(userSceneOwner);
			}
			
		}
	}
	
	public void changeStructures(int index) {
	
		
		try {
			
			boolean newPage = false;
        	
        	if (index == 0) {
        		newPage = true;
        	}
			
			String table;
			table = owner.getOwnerStructures();
    		List<Structure> listStruct = new ArrayList<>(6);
    		
    		index++;
			
			Structure structure1 = StructureDao.getStructure(table, index);
			
			if (structure1.getName() != null) {
				
				setNumPage(index);
				
				setIndice(index);
				
				newPage = true;
			}
			
			if (newPage) {
				
				index++;
				Structure structure2 = StructureDao.getStructure(table, index);
				if (structure2.getName() != null) {
					setIndice(index);
				}
				index++;
				Structure structure3 = StructureDao.getStructure(table, index);
				if (structure3.getName() != null) {
					setIndice(index);
				}
				index++;
				Structure structure4 = StructureDao.getStructure(table, index);
				if (structure4.getName() != null) {
					setIndice(index);
				}
				index++;
				Structure structure5 = StructureDao.getStructure(table, index);
				if (structure5.getName() != null) {
					setIndice(index);
				}
				index++;
				Structure structure6 = StructureDao.getStructure(table, index);
				if (structure6.getName() != null) {
					setIndice(index);
				}
				
				int structures = StructureDao.getStructures(table);
				
				listStruct.add(0, structure1);
				listStruct.add(1, structure2);
				listStruct.add(2, structure3);
				listStruct.add(3, structure4);
				listStruct.add(4, structure5);
				listStruct.add(5, structure6);
				
				userSceneOwner = new User2SceneOwner(this,owner,listStruct,structures);

				pane.getChildren().clear();
				pane.getChildren().add(userSceneOwner);
			}
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void changeExperiences(int index) {
		
        try {
	        	boolean newPage = false;
	        	
	        	if (index == 0) {
	        		newPage = true;
	        	}
	        
	        	String table;
	        
	        
	        		
	        	List<Experience> listExp = new ArrayList<>(6);
	        		
	        	table = user.getUserReviewsTable();
	        	
	        	index++;
					
				Experience experience1 = ExperienceDao.getExperience(table, index);
					
				if (experience1.getName() != null) {
						
					setNumPage(index);
					
					setIndice(index);
						
					newPage = true;
				}
					
					
				if (newPage) {
						
					index++;
					Experience experience2 = ExperienceDao.getExperience(table, index);
					if (experience2.getName() != null) {
						setIndice(index);
						
					}
					index++;
					Experience experience3 = ExperienceDao.getExperience(table, index);
					if (experience3.getName() != null) {
						setIndice(index);
							
					}
					index++;
					Experience experience4 = ExperienceDao.getExperience(table, index);
					if (experience4.getName() != null) {
						setIndice(index);
							
					}
					index++;
					Experience experience5 = ExperienceDao.getExperience(table, index);
					if (experience5.getName() != null) {
						setIndice(index);
							
					}
					index++;
					Experience experience6 = ExperienceDao.getExperience(table, index);
					if (experience6.getName() != null) {
						setIndice(index);
							
					}
						
					int booked = ExperienceDao.getBooked(table);
					int review = ExperienceDao.getReviewsNumber(table);
						
					listExp.add(0, experience1);
					listExp.add(1, experience2);
					listExp.add(2, experience3);
					listExp.add(3, experience4);
					listExp.add(4, experience5);
					listExp.add(5, experience6);
						
					userScene = new User2Scene(this,user,listExp,booked,review);

					pane.getChildren().clear();
					pane.getChildren().add(userScene);
				}
	        	
	        
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
	
	public void setStructure(String name) {
		
		HotelBean hotelBean = new HotelBean();
		
		HotelRegistrationScene registerScene = new HotelRegistrationScene(this,name,hotelBean);

		pane.getChildren().clear();
		pane.getChildren().add(registerScene);
		
	}
	
	public boolean registerStructure(String ownerName, HotelBean bean) {
		boolean added = false;
		try {
			added = HotelDao.setHotel(bean, ownerName, 0);
			OwnerDao.setStructure(ownerName, bean.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return added;
	}
	
	public void openStructureWindow(String structure) {
		
		HotelController hotelController = HotelController.getIstance(pane);
		
		try {
			Hotel hotel = HotelDao.getHotel(structure);
			int roomsNumber = RoomDao.getRoomsNumber(hotel.getHotelRooms());
			new StructureScene(this,hotel,hotelController,roomsNumber);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addRoomScene(Stage window, String roomsTable, String structure) {
		
		new AddRoomScene(window,this,roomsTable,structure);
		
	}
	
	public boolean addRoom(String roomsTable, int id, int beds, int price) {
		
		Boolean setted = false;
		
		try {
			setted = RoomDao.setRoom(roomsTable, id, beds, price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return setted;
	}
	
	public void addDescriptionScene(Stage window, String structure) {
		
		new AddDescriptionScene(window,this,structure);
		
	}
	
	public void addDescription(String description, String structure) {
		
		try {
			HotelDao.setDescription(description,structure);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void review(boolean bool,Experience experience) {
		
		Review review = new Review();
		review.setReviewUser(user.getUserName());
		review.setReviewText(experience.getReview());
		review.setReviewVote(experience.getRating());
		
		if (bool) {
			new WriteReviewWindow(this,review,experience.getName(),experience.getDayIn(),experience.getDayOut());
		} else {
			new ViewReviewWindow(review,experience.getName());
		}
	}
	
	public void addReview(Review review, String structure, int dayIn, int dayOut) throws LengthReviewException {

 		if(review.getReviewText().length() > 50) {
 			throw new LengthReviewException();
 		}
		
		try {
			Hotel hotel = HotelDao.getHotel(structure);
			ExperienceDao.addReview(review, structure, dayIn, dayOut, user.getUserReviewsTable());
			int avg = ReviewDao.setReview(review.getReviewText(), review.getReviewVote(), user.getUserName(),hotel.getHotelReviews());
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
	
	private void setNumPage(int index) {
		if (indice < index) {
			setPage(page+1);
		} else {
			setPage(page-1);
		}
	}
}
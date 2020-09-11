package logic.controller;


import logic.dao.ReviewDao;
import logic.model.Review;
import logic.bean.HotelBean;
import logic.bean.LoginBeanWeb;
import logic.dao.ExperienceDao;
import logic.dao.HotelDao;
import logic.dao.OwnerDao;
import logic.dao.RoomDao;
import logic.dao.StructureDao;
import logic.exceptions.ExistingOwnerException;
import logic.exceptions.ExistingUsernameException;
import logic.model.Experience;
import logic.model.Hotel;
import logic.model.Login;
import logic.model.OwnerWeb;
import logic.model.Structure;
import logic.model.UserWeb;


public class LoginControllerWeb {

	private Login login;
	private int pageWeb = 0;
	private int indiceWeb;
	
	private static LoginControllerWeb istance = null;
	
	public static LoginControllerWeb getIstance() {
		if (istance == null) {
			istance = new LoginControllerWeb();
		}
		return istance;
	}
	
	
	private LoginControllerWeb() {
		this.login = new Login();
	
	}
	

	public void login(LoginBeanWeb bean) {
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
	
		UserWeb user = login.checkUserWeb(username);
		
		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
			bean.setResult(true);
			bean.setUserWebLog(user);
		} else {
			 OwnerWeb owner = login.checkOwnerWeb(username);
			if (owner.getUsername().equals(username) && owner.getPassword().equals(password)) {
				bean.setResult(true);
				bean.setOwnerWebLog(owner);
			} else {			
				bean.setResult(false);
			}
		}
	}
	
	public boolean registerUser(LoginBeanWeb bean) throws ExistingUsernameException {
		
		String username = bean.getUsername();
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
	
	public boolean registerOwner(LoginBeanWeb bean)  throws ExistingOwnerException {
		
		String username = bean.getUsername();
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
	
	public void changeStructures(int index, LoginBeanWeb bean) {
		
		try {
			
			boolean newPageStr = false;
        	
        	if (index == 0) {
        		newPageStr = true;
        	}
        
        	String tableStr;
        	
        	tableStr = bean.getOwnerWebLog().getStructures();
    		
    		index++;
			
			Structure structure1 = StructureDao.getStructure(tableStr, index);
			
			if (structure1.getName() != null) {
				
				bean.getStructList().add(0, structure1);
				
				setIndice(index);
				
				newPageStr = true;
			}
			
			if (newPageStr) {
				
				index++;
				Structure structure2 = StructureDao.getStructure(tableStr, index);
				if (structure2.getName() != null) {
					setIndice(index);
					bean.getStructList().add(1, structure2);
				}
				index++;
				Structure structure3 = StructureDao.getStructure(tableStr, index);
				if (structure3.getName() != null) {
					bean.getStructList().add(2, structure3);
					setIndice(index);
				}
				index++;
				Structure structure4 = StructureDao.getStructure(tableStr, index);
				if (structure4.getName() != null) {
					bean.getStructList().add(3, structure4);
					setIndice(index);
				}
				index++;
				Structure structure5 = StructureDao.getStructure(tableStr, index);
				if (structure5.getName() != null) {
					bean.getStructList().add(4, structure5);
					setIndice(index);
				}
				index++;
				Structure structure6 = StructureDao.getStructure(tableStr, index);
				if (structure6.getName() != null) {
					bean.getStructList().add(5, structure6);
					setIndice(index);
				}
				
				int structures = StructureDao.getStructures(tableStr);
				bean.setStructures(structures);
		
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	public void changeExperiences(int index,LoginBeanWeb bean) {
		
        try {
	        	boolean newPage = false;
	        	
	        	if (index == 0) {
	        		newPage = true;
	        	}
	        
	        	String table;
	        
	
	        	table = bean.getUserWebLog().getReviewsTable();
	        		
	        	
	        	index++;
			
				Experience experience1 = ExperienceDao.getExperience(table, index);
					
				if (experience1.getName() != null) {
						
					bean.getExpList().add(0, experience1);

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
						
					
					}
	        	
	
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}

	public void registerStructure(String ownerName, HotelBean bean) {
		
		try {
			HotelDao.setHotel(bean, ownerName, 0);
			OwnerDao.setStructure(ownerName, bean.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addDescription(String description, String structure) {
		
		try {
			HotelDao.setDescription(description,structure);
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
		
		return setted;
		
	}

	public void addReview(Review review, String structure, int dayIn, int dayOut, UserWeb user) {
		
		try {
			Hotel hotel1 = HotelDao.getHotel(structure);
			ExperienceDao.addReview(review, structure, dayIn, dayOut, user.getReviewsTable());
		
			int avg = ReviewDao.setReview(review.getReviewText(), review.getReviewVote(), user.getUsername(), hotel1.getHotelReviews());
			
			HotelDao.setRating(avg, structure);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getPage() {
		return pageWeb;
	}

	public void setPage(int page) {
		this.pageWeb = page;
	}

	public int getIndice() {
		return indiceWeb;
	}

	public void setIndice(int indice) {
		this.indiceWeb = indice;
	}
}
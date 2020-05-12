package logic.controller;

import javafx.scene.layout.AnchorPane;
import logic.bean.HotelBean;
import logic.model.Hotel;
import logic.view.HotelScene;

public class HotelController {
	
	private HotelScene hotelScene;
	private HotelBean bean;
	private Hotel hotel1;
	private Hotel hotel2;
	private Hotel hotel3;
	private AnchorPane pane;
	
	public HotelController(AnchorPane pane) {
	
		this.bean = new HotelBean();
		//this.hotel1 = new Hotel();
		//this.hotel2 = new Hotel();  // per adesso le commento perchè non le sto usando e devo ancora definire bene la classe hotel
		//this.hotel3 = new Hotel();
		this.pane = pane;
	}
	
	public void changeScene(){
		
		hotelScene = new HotelScene(this,bean);
		
		pane.getChildren().clear();
		pane.getChildren().add(hotelScene);
	}
	
	public void changeScene2(){
		
		//hotelScene2 = new HotelScene2(this,bean,hotel1,hotel2,hotel3);
		
		pane.getChildren().clear();
		//pane.getChildren().add(hotelScene2);
	}

}

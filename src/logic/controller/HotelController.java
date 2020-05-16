package logic.controller;

import javafx.scene.layout.AnchorPane;
import logic.bean.HotelBean;
import logic.view.Hotel2Scene;
import logic.view.HotelScene;

public class HotelController {
	
	private HotelScene hotelScene;
	private Hotel2Scene hotel2Scene;
	private HotelBean bean;
	//private Hotel hotel1;
	//private Hotel hotel2;
	//private Hotel hotel3;
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
		
		hotel2Scene = new Hotel2Scene(this,bean);
		
		/* farei un'altra funzione qua
		 * da chiamare nella view che mi ritorna 
		 * i dati per popolare le righe di hotel
		 */		
		
		pane.getChildren().clear();
		pane.getChildren().add(hotel2Scene);
	}

}

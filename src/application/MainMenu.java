package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
//import logic.controller.EventsController;
//import logic.controller.HomeController;
//import logic.controller.HotelController;
//import logic.controller.LoginController;
//import logic.controller.MapController;
//import logic.controller.RestaurantsController;

public class MainMenu extends HBox{
	
	protected Button buttonFindit;
    protected HBox baseScene;;
    protected HBox baseHBox;
    protected Button buttonHotel;
    protected Button buttonRestaurants;
    protected Button buttonEvents;
    protected Button buttonMap;
    protected Button buttonProfile;
    
   /* protected HomeScene homeScene;
    protected HotelScene hotelScene;
    protected RestaurantsScene restaurantsScene;
    protected EventsScene eventsScene;
   protected ProfileScene profileScene;
     */
    public MainMenu(AnchorPane scenePane//,
			//HomeController homeController,
			//HotelController hotelController,
			//RestaurantsController restaurantsController,
			//EventsController eventsController,
			//MapController mapController,
			//LoginController profileController
    		){
		
		buttonFindit = new Button();
        baseHBox = new HBox();
        buttonHotel = new Button();
        buttonRestaurants = new Button();
        buttonEvents = new Button();
        buttonMap = new Button();
        buttonProfile = new Button();
    	
    	buttonFindit.setLayoutX(0.0);
    	buttonFindit.setLayoutY(0.0);
    	buttonFindit.setMnemonicParsing(false);
    	buttonFindit.setPrefHeight(82.0);
    	buttonFindit.setPrefWidth(215.0);
    	buttonFindit.setMinWidth(215.0);
    	buttonFindit.setText("FindIT");
    	buttonFindit.setUnderline(true);
    	buttonFindit.setFont(new Font(72.0));
        buttonFindit.setPadding(new Insets(0.0, 0.0, 0.0, 0.0));
        HBox.setMargin(buttonFindit, new Insets(25.0, 0.0, 20.0, 0.0));
        
        setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);
        setLayoutX(0.0);
        setLayoutY(0.0);
        setPrefHeight(145.0);
        setPrefWidth(1015.0);
        
        baseHBox.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);
        baseHBox.setLayoutX(0.0);
        baseHBox.setLayoutY(0.0);
        baseHBox.setPrefHeight(145.0);
        baseHBox.setPrefWidth(764.0);
        
        buttonHotel.setMnemonicParsing(false);
        buttonHotel.setText("Hotels");
        buttonHotel.setTextFill(javafx.scene.paint.Color.WHITE);
        buttonHotel.setUnderline(true);
        buttonHotel.setFont(new Font(24.0));
        
        buttonRestaurants.setMnemonicParsing(false);
        buttonRestaurants.setText("Restaurants");
        buttonRestaurants.setTextFill(javafx.scene.paint.Color.WHITE);
        buttonRestaurants.setUnderline(true);
        buttonRestaurants.setFont(new Font(24.0));

        buttonEvents.setMnemonicParsing(false);
        buttonEvents.setText("Events");
        buttonEvents.setTextFill(javafx.scene.paint.Color.WHITE);
        buttonEvents.setUnderline(true);
        buttonEvents.setFont(new Font(24.0));

        buttonMap.setMnemonicParsing(false);
        buttonMap.setText("Map");
        buttonMap.setTextFill(javafx.scene.paint.Color.WHITE);
        buttonMap.setUnderline(true);
        buttonMap.setFont(new Font(24.0));

        buttonProfile.setMnemonicParsing(false);
        buttonProfile.setText("Profile");
        buttonProfile.setTextFill(javafx.scene.paint.Color.WHITE);
        buttonProfile.setUnderline(true);
        buttonProfile.setFont(new Font(24.0));
        
        buttonFindit.setId("b_selected");
        buttonHotel.setId("b_menu");
        buttonRestaurants.setId("b_menu");
        buttonEvents.setId("b_menu");
        buttonMap.setId("b_menu");
        buttonProfile.setId("b_menu");
        /*
        buttonFindit.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				buttonFindit.setId("b_selected");
		        buttonHotel.setId("b_menu");
		        buttonRestaurants.setId("b_menu");
		        buttonEvents.setId("b_menu");
		        buttonMap.setId("b_menu");
		        buttonProfile.setId("b_menu");
		        
				homeController.changeScene(scenePane);
			}
		});
        
        buttonHotel.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				buttonFindit.setId("b_menu");
		        buttonHotel.setId("b_selected");
		        buttonRestaurants.setId("b_menu");
		        buttonEvents.setId("b_menu");
		        buttonMap.setId("b_menu");
		        buttonProfile.setId("b_menu");
		        
				hotelController.changeScene();
			}
		});
        
        buttonRestaurants.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				buttonFindit.setId("b_menu");
		        buttonHotel.setId("b_menu");
		        buttonRestaurants.setId("b_selected");
		        buttonEvents.setId("b_menu");
		        buttonMap.setId("b_menu");
		        buttonProfile.setId("b_menu");
		        
				restaurantsController.changeScene();
			}
		});
        
        buttonEvents.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				buttonFindit.setId("b_menu");
		        buttonHotel.setId("b_menu");
		        buttonRestaurants.setId("b_menu");
		        buttonEvents.setId("b_selected");
		        buttonMap.setId("b_menu");
		        buttonProfile.setId("b_menu");
		        
				eventsController.changeScene();
			}
		});
        
        buttonMap.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				buttonFindit.setId("b_menu");
		        buttonHotel.setId("b_menu");
		        buttonRestaurants.setId("b_menu");
		        buttonEvents.setId("b_menu");
		        buttonMap.setId("b_selected");
		        buttonProfile.setId("b_menu");
		        
				mapController.changeScene(scenePane);
			}
		});
        
        buttonProfile.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				buttonFindit.setId("b_menu");
		        buttonHotel.setId("b_menu");
		        buttonRestaurants.setId("b_menu");
		        buttonEvents.setId("b_menu");
		        buttonMap.setId("b_menu");
		        buttonProfile.setId("b_selected");
		        
				profileController.changeScene();
			}
		});
        */
        getChildren().add(buttonFindit);
        getChildren().add(baseHBox);
        baseHBox.getChildren().add(buttonHotel);
        baseHBox.getChildren().add(buttonRestaurants);
        baseHBox.getChildren().add(buttonEvents);
        baseHBox.getChildren().add(buttonMap);
        baseHBox.getChildren().add(buttonProfile);
        scenePane.getChildren().add(this);
	}
    /*
    public void mapScene(AnchorPane scenePane) {
		
        scenePane.getChildren().clear();
        
		webView.setLayoutY(155.0);
		webView.setPrefHeight(525.0);
		webView.setPrefWidth(1050.0);
		scenePane.getChildren().add(webView);
		//getChildren().add(mapScene);
    }
    */
}

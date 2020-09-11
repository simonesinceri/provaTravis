package logic.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.controller.HotelController;
import logic.controller.ProfileController;
import logic.exceptions.ExceptionSearchReview;
import logic.model.Hotel;

public class StructureScene {

    protected HBox hBox;
    protected VBox vBox1;
    protected VBox vBox2;
    protected Stage window;
    protected Label label1;
    protected Button btnAddRoom;
    protected Button btnViewReviews;
    protected Button btnOpenAgenda;
    
    protected Button btnAddDescription;

    public StructureScene(ProfileController profileController, Hotel hotel, HotelController hotelController, int roomsNumber) {

		hBox = new HBox();
		vBox1 = new VBox();
		vBox2 = new VBox();
        window = new Stage();
        label1 = new Label();
        btnAddRoom = new Button();
        btnViewReviews = new Button();
        btnOpenAgenda = new Button();
        btnAddDescription = new Button();
        
        String btnColor = "-fx-background-color: #1B59D7;";

        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        window.setTitle(hotel.getHotelName());

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefWidth(500.0);
        hBox.setPrefHeight(274.0);
        hBox.setSpacing(25.0);

        vBox1.setAlignment(javafx.geometry.Pos.CENTER);
        vBox1.setPrefWidth(250.0);
        vBox1.setPrefHeight(274.0);
        vBox1.setSpacing(25.0);

        vBox2.setAlignment(javafx.geometry.Pos.CENTER);
        vBox2.setPrefWidth(250.0);
        vBox2.setPrefHeight(274.0);
        vBox2.setSpacing(25.0);

        label1.setText("Rooms number: " + roomsNumber);
        label1.setFont(new Font(24.0));
        
        btnViewReviews.setMnemonicParsing(false);
        btnViewReviews.setText("View Reviews");
        btnViewReviews.setFont(new Font(24.0));
        btnViewReviews.setStyle(btnColor);
        btnViewReviews.setTextFill(javafx.scene.paint.Color.WHITE);

        btnViewReviews.setOnMouseEntered(evt -> btnViewReviews.setUnderline(true));
        btnViewReviews.setOnMouseExited(evt -> btnViewReviews.setUnderline(false));
        
        btnAddRoom.setMnemonicParsing(false);
        btnAddRoom.setText("Add Room");
        btnAddRoom.setFont(new Font(24.0));
        btnAddRoom.setStyle(btnColor);
        btnAddRoom.setTextFill(javafx.scene.paint.Color.WHITE);

        btnAddRoom.setOnMouseEntered(evt -> btnAddRoom.setUnderline(true));
        btnAddRoom.setOnMouseExited(evt -> btnAddRoom.setUnderline(false));
        
        btnOpenAgenda.setMnemonicParsing(false);
        btnOpenAgenda.setText("Open Agenda");
        btnOpenAgenda.setFont(new Font(24.0));
        btnOpenAgenda.setStyle(btnColor);
        btnOpenAgenda.setTextFill(javafx.scene.paint.Color.WHITE);

        btnOpenAgenda.setOnMouseEntered(evt -> btnOpenAgenda.setUnderline(true));
        btnOpenAgenda.setOnMouseExited(evt -> btnOpenAgenda.setUnderline(false));
        
        btnAddDescription.setMnemonicParsing(false);
        btnAddDescription.setText("Add Description");
        btnAddDescription.setFont(new Font(24.0));
        btnAddDescription.setStyle(btnColor);
        btnAddDescription.setTextFill(javafx.scene.paint.Color.WHITE);

        btnAddDescription.setOnMouseEntered(evt -> btnAddDescription.setUnderline(true));
        btnAddDescription.setOnMouseExited(evt -> btnAddDescription.setUnderline(false));

        vBox1.getChildren().add(label1);
        vBox1.getChildren().add(btnAddRoom);
        vBox2.getChildren().add(btnViewReviews);
        vBox2.getChildren().add(btnOpenAgenda);
        vBox2.getChildren().add(btnAddDescription);
        hBox.getChildren().add(vBox1);
        hBox.getChildren().add(vBox2);

        Scene scene = new Scene(hBox,500,274);
        window.setScene(scene);
        window.setResizable(false);
        
        btnAddRoom.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				profileController.addRoomScene(window,hotel.getHotelRooms(),hotel.getHotelName());
 				
 			}
 		});
        
        btnViewReviews.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				try {
					hotelController.viewReviews(false,hotel.getHotelReviews(), 0);
				} catch (ExceptionSearchReview e) {
					btnViewReviews.setDisable(true);
					btnViewReviews.setText("Can't load Reviews");
				}
 				
 				window.close();
 			}
 		});
        
        btnAddDescription.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				profileController.addDescriptionScene(window,hotel.getHotelName());
 				
 			}
 		});
        
        window.show();
    }
}

package logic.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.controller.ProfileController;

public class AddRoomScene {
	
    protected  VBox vBox;
    protected HBox hBox1;
    protected Label label1;
    protected TextField tf1;
    protected HBox hBox2;
    protected Label label2;
    protected TextField tf2;
    protected HBox hBox3;
    protected Label label3;
    protected TextField tf3;
    protected Button button;

	public AddRoomScene(Stage window, ProfileController controller, String roomsTable, String structure) {
		
		vBox = new VBox();
        hBox1 = new HBox();
        label1 = new Label();
        tf1 = new TextField();
        hBox2 = new HBox();
        label2 = new Label();
        tf2 = new TextField();
        hBox3 = new HBox();
        label3 = new Label();
        tf3 = new TextField();
        button = new Button();
        String black = "-fx-text-fill: black";
        String red = "-fx-text-fill: red";
        String styleTf = "-fx-background-color: #e2e8ff; -fx-background-radius: 20;";

        
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefWidth(500.0);
        vBox.setPrefHeight(274.0);
        vBox.setSpacing(15.0);
        
        hBox1.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox1.setSpacing(15.0);
        hBox1.setPadding(new Insets(20.0,60.0,0.0,0.0));

        label1.setText("Room ID: ");
        label1.setFont(new Font(24.0));
	    label1.setStyle(black);
        HBox.setMargin(label1, new Insets(0.0));

        tf1.setAlignment(javafx.geometry.Pos.CENTER);
        tf1.setMinWidth(25.0);
        tf1.setPromptText("Es. 1");
        tf1.setStyle(styleTf);
        tf1.setFont(new Font(24.0));
        
        hBox2.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox2.setSpacing(15.0);
        hBox2.setPadding(new Insets(0.0,60.0,0.0,0.0));

        label2.setText("Price: ");
        label2.setFont(new Font(24.0));
        HBox.setMargin(label2, new Insets(0.0));

        tf2.setAlignment(javafx.geometry.Pos.CENTER);
        tf2.setMinWidth(25.0);
        tf2.setPromptText("Es. 50");
        tf2.setStyle(styleTf);
        tf2.setFont(new Font(24.0));
        
        hBox3.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox3.setSpacing(15.0);
        hBox3.setPadding(new Insets(0.0,60.0,10.0,0.0));

        label3.setText("Beds: ");
        label3.setFont(new Font(24.0));
        HBox.setMargin(label3, new Insets(0.0));

        tf3.setAlignment(javafx.geometry.Pos.CENTER);
        tf3.setMinWidth(25.0);
        tf3.setPromptText("Es. 4");
        tf3.setStyle(styleTf);
        tf3.setFont(new Font(24.0));

        button.setMnemonicParsing(false);
        button.setText("Add Room");
        button.setFont(new Font(24.0));
        button.setStyle("-fx-background-color: #1B59D7;");
        button.setTextFill(javafx.scene.paint.Color.WHITE);

        button.setOnMouseEntered(evt -> button.setUnderline(true));
        button.setOnMouseExited(evt -> button.setUnderline(false));
        
        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(tf1);
        vBox.getChildren().add(hBox1);
        hBox2.getChildren().add(label2);
        hBox2.getChildren().add(tf2);
        vBox.getChildren().add(hBox2);
        hBox3.getChildren().add(label3);
        hBox3.getChildren().add(tf3);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(button);
        
        button.setOnAction(new EventHandler<ActionEvent>(){
 			@Override
        	public void handle(ActionEvent event) {
 				
 				boolean idOk = false;
 				boolean bedsOk = false;
 				boolean priceOk = false;
 				
 				boolean ok = false;
 				
 				ok = setBool(idOk, bedsOk, priceOk); 
 				
 				if (ok) {
 					
 					boolean result = controller.addRoom(roomsTable, Integer.valueOf(tf1.getText()), Integer.valueOf(tf3.getText()), Integer.valueOf(tf2.getText()));
 	 				
 	 				if (!result) {
 	 			        label1.setText("Change ID: ");
 	 			        label1.setStyle(red);
 	 				} else {
 	 					window.close();
 	 					controller.openStructureWindow(structure);
 	 				}
 				}
 			}
 		});
        
        Scene scene = new Scene(vBox,500,274);
        window.setScene(scene);
	}
	
	private boolean setBool(boolean idOk , boolean bedsOk, boolean priceOk ) {
		
		String red = "-fx-text-fill: red";
		String black = "-fx-text-fill: black";
		
		
		if (!tf1.getText().equals("")) {
			label1.setStyle(black);
			idOk = true;
        } else {
        	label1.setStyle(red);
        }
			if (!tf2.getText().equals("")) {
			label2.setStyle(black);
			bedsOk = true;
        } else {
        	label2.setStyle(red);
        }
		if (!tf3.getText().equals("")) {
			label3.setStyle(black);
			priceOk = true;
        } else {
        	label3.setStyle(red);
        }
		
		return (idOk && bedsOk && priceOk);
	
	}
}

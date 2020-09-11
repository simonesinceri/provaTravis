/*
 * Author: Simone Sinceri
 * 
 * */

package logic.exceptions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LengthReviewException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4226068940787209524L;
	
	public LengthReviewException() {
		super("Exception on length Review");
	}
	
	public LengthReviewException(String message ) {
		super("LengthReviewException :" + message);
	}
	
	public void showError() {
	
		Stage window = new Stage();
		VBox  errScene = new VBox();
	    Text errorTxt = new Text();
	    Button btnClose = new Button();
		
	    window.initModality(Modality.APPLICATION_MODAL);
	    window.setTitle("Error Lenght review");
	    window.setMinWidth(250);
	    
	    errScene.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        errScene.setPrefHeight(274.0);
        errScene.setPrefWidth(500.0);
        errScene.setSpacing(10.0);

       
        errorTxt.setText("The review is too long, respect the 50 characters max");
        errorTxt.setFont(new Font(18.0));
        errorTxt.setStyle("-fx-text-fill: black");
        
        btnClose.setMnemonicParsing(false);
        btnClose.setStyle("-fx-background-color: #1B59D7;");
        btnClose.setText("Close");
        btnClose.setTextFill(javafx.scene.paint.Color.WHITE);
        btnClose.setFont(new Font(24.0));
        
	    Scene scene = new Scene(errScene,500,100);
	    
	    errScene.getChildren().add(errorTxt);
	    errScene.getChildren().add(btnClose);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
        
        btnClose.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
				
				window.close();
			}
		});
        
	}
}
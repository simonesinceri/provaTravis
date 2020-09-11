package logic.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.controller.ProfileController;

public class AddDescriptionScene {

	protected VBox descriptionScene;
	protected Label label;
    protected TextArea textArea;
    protected HBox hBox;
    protected Button btnSubmit;
    protected Stage window;

    public AddDescriptionScene(Stage window, ProfileController controller, String structure) {

    	descriptionScene = new VBox();
        label = new Label();
        textArea = new TextArea();
        hBox = new HBox();
        btnSubmit = new Button();

        descriptionScene.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        descriptionScene.setPrefHeight(274.0);
        descriptionScene.setPrefWidth(500.0);
        descriptionScene.setSpacing(10.0);

        label.setPrefHeight(35.0);
        label.setPrefWidth(193.0);
        label.setText("Write Description");
        label.setFont(new Font(24.0));

        textArea.setPrefHeight(119.0);
        textArea.setPrefWidth(450.0);
        textArea.setFont(new Font(18.0));
        textArea.setWrapText(true);
        textArea.setMaxWidth(452.0);
        
        hBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox.setPrefHeight(86.0);
        hBox.setPrefWidth(500.0);
        
        btnSubmit.setMnemonicParsing(false);
        btnSubmit.setStyle("-fx-background-color: #1B59D7;");
        btnSubmit.setText("Submit");
        btnSubmit.setTextFill(javafx.scene.paint.Color.WHITE);
        btnSubmit.setFont(new Font(24.0));
        
        btnSubmit.setOnMouseEntered(evt -> btnSubmit.setUnderline(true));
        btnSubmit.setOnMouseExited(evt -> btnSubmit.setUnderline(false));
        
        hBox.setPadding(new Insets(0.0, 25.0, 0.0, 0.0));
        descriptionScene.setOpaqueInsets(new Insets(0.0));
        descriptionScene.setPadding(new Insets(5.0, 0.0, 0.0, 0.0));

        descriptionScene.getChildren().add(label);
        descriptionScene.getChildren().add(textArea);
        hBox.getChildren().add(btnSubmit);
        descriptionScene.getChildren().add(hBox);
        
       
        btnSubmit.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.addDescription(textArea.getText(), structure);
 				
 	 			window.close();
 	 			
 	 			controller.openStructureWindow(structure);
 			}
 		});
        
        Scene scene = new Scene(descriptionScene,500,274);
        window.setScene(scene);
    }
}

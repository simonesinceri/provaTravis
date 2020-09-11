package logic.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.model.Review;

public class ViewReviewWindow {
	
	protected VBox reviewScene;
	protected Label label;
	protected Label text;
	protected ScrollPane scrollPane;
    protected Stage window;

    public ViewReviewWindow(Review review, String structure) {

    	reviewScene = new VBox();
        label = new Label();
        text = new Label();
        scrollPane = new ScrollPane();
        
        window = new Stage();
        
        String white = "-fx-background-color: white;";

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Your review of " + structure);
        window.setMinWidth(250);

        reviewScene.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        reviewScene.setPrefHeight(274.0);
        reviewScene.setPrefWidth(500.0);
        reviewScene.setSpacing(10.0);
        reviewScene.setStyle(white);
        
        label.setText("You voted: " + review.getReviewVote() + " star/s");
        label.setFont(new Font(24.0));

        text.setText(review.getReviewText());
        text.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        text.setWrapText(true);
        text.setFont(new Font(24.0));
        text.setMaxWidth(450.0);
        text.setMinHeight(200.0);
        text.setStyle(white);
        
        scrollPane.setContent(text);
        scrollPane.setMaxWidth(450.0);
        scrollPane.setPrefHeight(203.0);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle(white);
        scrollPane.setStyle("-fx-color: lightGray;");
        
        reviewScene.setOpaqueInsets(new Insets(0.0));
        reviewScene.setPadding(new Insets(5.0, 0.0, 0.0, 0.0));

        reviewScene.getChildren().add(label);
        reviewScene.getChildren().add(scrollPane);
        
        Scene scene = new Scene(reviewScene,500,274);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}

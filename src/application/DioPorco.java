package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


public class DioPorco extends Application{
	
	Label label1;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		primaryStage.setTitle("Porco Dio le bestemmie che ho tirato");
		label1 = new Label("first label senza madonne");
		VBox root = new VBox();
		DatePicker data = new DatePicker();
		
		
		root.getChildren().add(label1);
		root.getChildren().add(data);
		Scene scene = new Scene(root, 300, 300);
		scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}

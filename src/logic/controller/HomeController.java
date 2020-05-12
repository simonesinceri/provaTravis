package logic.controller;

import javafx.scene.layout.AnchorPane;
import logic.view.HomeScene;

public class HomeController {

	private HomeScene homeScene;
	
	public void changeScene(AnchorPane pane) {
		
		homeScene = new HomeScene();
		
		pane.getChildren().clear();
		pane.getChildren().add(homeScene);
		
	}
	
	
}

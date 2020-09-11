package logic.controller;

import javafx.scene.layout.AnchorPane;
import logic.view.HomeScene;

public class HomeController {
	
	private static HomeController istance = null;
	
	public static HomeController getIstance() {
		if (istance == null) {
			istance = new HomeController();
		}
		return istance;
	}

	private HomeController() {
		
	}
	
	public void changeScene(AnchorPane pane) {
		
		HomeScene homeScene = new HomeScene();
		
		pane.getChildren().clear();
		pane.getChildren().add(homeScene);
		
	}
}

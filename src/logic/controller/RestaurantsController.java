package logic.controller;

import javafx.scene.layout.AnchorPane;
import logic.bean.RestaurantsBean;
import logic.view.RestaurantsScene;

public class RestaurantsController{

	private AnchorPane pane;
	private RestaurantsBean bean;
	
	private static RestaurantsController istance = null;
	
	public static RestaurantsController getIstance(AnchorPane pane) {
		if (istance == null) {
			istance = new RestaurantsController(pane);
		}
		return istance;
	}

	private RestaurantsController(AnchorPane pane) {
		
		this.pane = pane;
		this.bean = new RestaurantsBean();
		
	}
	
	public void changeScene() {
		
		RestaurantsScene restaurantsScene = new RestaurantsScene(this,bean);
		
		pane.getChildren().clear();
		pane.getChildren().add(restaurantsScene);
	}
	
	public void changeScene2(){
		pane.getChildren().clear();
	}
}

package logic.controller;

import javafx.scene.layout.AnchorPane;
import logic.bean.EventBean;
import logic.view.EventsScene;

public class EventsController {

	private EventBean bean;
	private AnchorPane pane;
	
	private static EventsController istance = null;
	
	public static EventsController getIstance(AnchorPane pane) {
		if (istance == null) {
			istance = new EventsController(pane);
		}
		return istance;
	}

	private EventsController(AnchorPane pane) {
		
		this.bean = new EventBean();
		this.pane = pane;
	}
	
	public void changeScene() {
		
		EventsScene eventsScene = new EventsScene(this, bean);
		
		pane.getChildren().clear();
		pane.getChildren().add(eventsScene);
	}
	
	public void changeScene2(){
		pane.getChildren().clear();
	}
}

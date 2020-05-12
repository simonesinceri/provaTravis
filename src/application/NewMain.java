package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import logic.controller.EventsController;
//import logic.controller.HomeController;
//import logic.controller.HotelController;
//import logic.controller.LoginController;
//import logic.controller.MapController;
//import logic.controller.RestaurantsController;

public class NewMain extends Application{
	
    protected AnchorPane pane;
    protected AnchorPane scenePane;
    protected MainMenu baseScene;
    
	public static void main(String[] args) {
        launch(args);
    }
	
	public void start(Stage stage) throws Exception {
		
    	pane = new AnchorPane();
    	scenePane = new AnchorPane();
    	Hotel2Scene parte2 = new Hotel2Scene();
    	//scenePane.getChildren().add(parte2);
		
    	baseScene = new MainMenu(scenePane);

    	scenePane.setLayoutX(0.0);
    	scenePane.setLayoutY(155.0);
    	scenePane.setPrefWidth(1050.0);
    	scenePane.prefHeight(525.0);
    	
        pane.getChildren().add(baseScene);
        pane.getChildren().add(scenePane);
        

        
        pane.setId("pane");
        
		Scene scene = new Scene(pane,1050,680);
	    
	    stage.setResizable(false);
	    
	    scene.getStylesheets().addAll(this.getClass().getResource("home_style.css").toExternalForm());
	    
	    stage.setTitle("FindIT");
	    stage.setScene(scene);
	    stage.show();	
	}
}

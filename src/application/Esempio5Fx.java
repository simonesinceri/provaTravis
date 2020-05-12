package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;




public class Esempio5Fx extends Application{

	Label label1;
	Button btn1;
	int i = 1;
	String o;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("First Stage Title");
		label1 = new Label("First Label");
		BorderPane rPrincip = new BorderPane();
		VBox root = new VBox();
		HBox due = new HBox();
		
		Scene scene = new Scene(rPrincip, 400, 600);
		primaryStage.setScene(scene);
		
		Text txt = new Text();
		//txt.setFont( font(45));
		txt.setX(250);
		txt.setY(400);
		txt.setText("che sballo");
		// o = txt.getText();
		
		Button btn3 = new Button("seconda Vbox");
		Button btn4 = new Button(" Vbox 2");
		
		
		
		
		btn1 = new Button("First Button");
		Button btn2 = new Button("Second button");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.err.println("hello world!");
				//System.err.println(o);
				label1.setText("Try" + i);
				i++;
				
			}
	});
		
		due.getChildren().addAll(btn3, btn4);
		root.getChildren().addAll(label1,btn1,btn2,txt);
		
		rPrincip.setTop(due);
		rPrincip.setCenter(root);
	
		primaryStage.show();
	}

}

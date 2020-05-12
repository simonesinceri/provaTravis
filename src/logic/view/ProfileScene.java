package logic.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import logic.controller.LoginController;
import logic.model.User;

public class ProfileScene extends VBox{
	
	protected HBox profileHBox;
    protected VBox profileVBox0;
    protected Label profileLabel;
    protected Label profileLabel0;
    protected Label profileLabel1;
    protected Label profileLabel2;
    protected Label profileLabel3;
    protected Button profileLoginButton;
    protected Line profileLine;
    protected VBox profileVBox1;
    protected Label profileLabel4;
    protected Label profileLabel5;
    protected Label profileLabel6;
    protected Label profileLabel7;
    protected Label profileLabel8;
    protected Button profileRegisterButton;

    protected UserPage userScene;
    
    protected static User user;
    protected boolean isLogged = false;
    
    // manca il bottone come argomento per il cambio nome
    public ProfileScene(LoginController controller) {

    	profileHBox = new HBox();
        profileVBox0 = new VBox();
        profileLabel = new Label();
        profileLabel0 = new Label();
        profileLabel1 = new Label();
        profileLabel2 = new Label();
        profileLabel3 = new Label();
        profileLoginButton = new Button();
        profileLine = new Line();
        profileVBox1 = new VBox();
        profileLabel4 = new Label();
        profileLabel5 = new Label();
        profileLabel6 = new Label();
        profileLabel7 = new Label();
        profileLabel8 = new Label();
        profileRegisterButton = new Button();
        
        user = new User();
        
        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);

        profileHBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        profileHBox.setPrefHeight(100.0);
        profileHBox.setPrefWidth(200.0);
        profileHBox.setSpacing(65.0);
        VBox.setMargin(profileHBox, new Insets(50.0, 0.0, 0.0, 0.0));

        profileVBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        profileVBox0.setMaxHeight(300.0);
        profileVBox0.setPrefWidth(402.0);
        profileVBox0.setSpacing(10.0);
        HBox.setMargin(profileVBox0, new Insets(20.0, 0.0, 0.0, 0.0));

        profileLabel.setText("Do you already have ");
        profileLabel.setFont(new Font(36.0));

        profileLabel0.setText("a profile? Log in to ");
        profileLabel0.setFont(new Font(36.0));

        profileLabel1.setText("organize your programs");
        profileLabel1.setFont(new Font(36.0));

        profileLabel2.setText("and book the facilities");
        profileLabel2.setFont(new Font(36.0));

        profileLabel3.setText("you prefer!");
        profileLabel3.setFont(new Font(36.0));

        profileLoginButton.setMnemonicParsing(false);
        profileLoginButton.setPrefWidth(115.0);
        profileLoginButton.setStyle("-fx-background-color: #1B59D7;");
        profileLoginButton.setText("Login");
        profileLoginButton.setTextFill(javafx.scene.paint.Color.WHITE);
        profileLoginButton.setFont(new Font(24.0));
        VBox.setMargin(profileLoginButton, new Insets(30.0, 0.0, 0.0, 0.0));

        profileLine.setEndY(180.0);
        profileLine.setStartY(-180.0);

        profileVBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        profileVBox1.setMaxHeight(300.0);
        profileVBox1.setPrefWidth(402.0);
        profileVBox1.setSpacing(10.0);

        profileLabel4.setText("Are you new in our ");
        profileLabel4.setFont(new Font(36.0));

        profileLabel5.setText("system? You can create");
        profileLabel5.setFont(new Font(36.0));

        profileLabel6.setText("your own profile or your");
        profileLabel6.setFont(new Font(36.0));

        profileLabel7.setText("business profile to reserve ");
        profileLabel7.setFont(new Font(36.0));

        profileLabel8.setText("or get reserved!");
        profileLabel8.setFont(new Font(36.0));

        profileRegisterButton.setMnemonicParsing(false);
        profileRegisterButton.setPrefWidth(115.0);
        profileRegisterButton.setStyle("-fx-background-color: #1B59D7;");
        profileRegisterButton.setText("Register");
        profileRegisterButton.setTextFill(javafx.scene.paint.Color.WHITE);
        profileRegisterButton.setFont(new Font(24.0));
        VBox.setMargin(profileRegisterButton, new Insets(30.0, 0.0, 0.0, 0.0));
        HBox.setMargin(profileVBox1, new Insets(20.0, 0.0, 0.0, 0.0));

        profileVBox0.getChildren().add(profileLabel);
        profileVBox0.getChildren().add(profileLabel0);
        profileVBox0.getChildren().add(profileLabel1);
        profileVBox0.getChildren().add(profileLabel2);
        profileVBox0.getChildren().add(profileLabel3);
        profileVBox0.getChildren().add(profileLoginButton);
        profileHBox.getChildren().add(profileVBox0);
        profileHBox.getChildren().add(profileLine);
        profileVBox1.getChildren().add(profileLabel4);
        profileVBox1.getChildren().add(profileLabel5);
        profileVBox1.getChildren().add(profileLabel6);
        profileVBox1.getChildren().add(profileLabel7);
        profileVBox1.getChildren().add(profileLabel8);
        profileVBox1.getChildren().add(profileRegisterButton);
        profileHBox.getChildren().add(profileVBox1);
        getChildren().add(profileHBox);
        
        profileLoginButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {

				controller.openLogWindow();

				if (user.getUsername() == null) {
					isLogged = false;
				} else if (!(user.getUsername().equals(""))) {
					isLogged = true;
				}
		        if (isLogged == true) {
		        	//b_profile.setText(user.getUsername());
		        	getChildren().clear();
		            userScene = new UserPage(user.getUsername());
		        	getChildren().add(userScene);
		        }
			}
		});
        
        profileRegisterButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				if (controller.openRegisterWindow()) {
					controller.openLogWindow();

					if (user.getUsername() == null) {
						isLogged = false;
					} else if (!(user.getUsername().equals(""))) {
						isLogged = true;
					}
			        if (isLogged == true) {
			        	//b_profile.setText(user.getUsername());
			        	getChildren().clear();
			            userScene = new UserPage(user.getUsername());
			        	getChildren().add(userScene);
			        }
				}
			}
		});
    }
}

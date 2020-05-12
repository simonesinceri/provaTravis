package logic.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.bean.LoginBean;
import logic.controller.LoginController;

public class LogWindow {
    
    protected static VBox loginScene;
    protected static HBox loginHBox;
    protected static Label label;
    protected static Label usernameLabel;
    protected static TextField usernameTextField;
    protected static String username;
    protected static HBox loginHBox0;
    protected static Label passwordLabel;
    protected static PasswordField passwordTextField;
    protected static String password;
    protected static Button loginButton;
    protected static Button registerButton;
    protected static Stage window;
    protected static HBox registerHBox;
    protected static VBox registerVBox;
    protected static RadioButton registerAsUser;
    protected static RadioButton registerAsOwner;
    
    static boolean alreadyRegistred = false;
    static boolean isRegistred = false;

	public void Log(LoginController controller, LoginBean bean) {
		
		loginScene = new VBox();
        loginHBox = new HBox();
        label = new Label();
        usernameLabel = new Label();
        usernameTextField = new TextField();
        loginHBox0 = new HBox();
        passwordLabel = new Label();
        passwordTextField = new PasswordField();
        loginButton = new Button();
        
		window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login");
        window.setMinWidth(250);

        loginScene.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        loginScene.setPrefWidth(500.0);
        loginScene.setPrefHeight(274.0);
        loginScene.setSpacing(30.0);

        loginHBox.setAlignment(javafx.geometry.Pos.CENTER);
        loginHBox.setSpacing(30.0);

        usernameLabel.setText("Username:");
        usernameLabel.setFont(new Font(24.0));

        usernameTextField.setAlignment(javafx.geometry.Pos.CENTER);
        usernameTextField.setPromptText("Username");
        usernameTextField.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
        usernameTextField.setFont(new Font(24.0));
        VBox.setMargin(loginHBox, new Insets(-10.0, 0.0, 0.0, 0.0));
        
        loginHBox0.setAlignment(javafx.geometry.Pos.CENTER);
        loginHBox0.setSpacing(30.0);
        
        if (alreadyRegistred == true) {
            label.setText("Registration completed, proceed with Login!");
        } else {
            label.setText("Insert Username and Password");
        }
        label.setFont(new Font(24.0));
        VBox.setMargin(label, new Insets(15.0, 0.0, 0.0, 0.0));

        passwordLabel.setText("Password:");
        passwordLabel.setFont(new Font(24.0));

        passwordTextField.setAlignment(javafx.geometry.Pos.CENTER);
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
        passwordTextField.setFont(new Font(24.0));

        loginButton.setMnemonicParsing(false);
        loginButton.setPrefWidth(115.0);
        loginButton.setStyle("-fx-background-color: #1B59D7;");
        loginButton.setText("Login");
        loginButton.setTextFill(javafx.scene.paint.Color.WHITE);
        loginButton.setFont(new Font(24.0));
        VBox.setMargin(loginButton, new Insets(0.0, 0.0, 15.0, 0.0));

        loginScene.getChildren().add(label);
        loginScene.getChildren().add(loginHBox);
        loginScene.getChildren().add(loginHBox0);
        loginHBox.getChildren().add(usernameLabel);
        loginHBox.getChildren().add(usernameTextField);
        loginHBox0.getChildren().add(passwordLabel);
        loginHBox0.getChildren().add(passwordTextField);
        loginScene.getChildren().add(loginButton);

        Scene scene = new Scene(loginScene,500,274);
        window.setScene(scene);
        window.setResizable(false);
        
        loginButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
		        username = usernameTextField.getText();
		        password = passwordTextField.getText();
		        
		        if (username.equals("")) {
					label.setText("Insert Username!");
			        label.setStyle("-fx-text-fill: #ff0000;");  
		        } else if (password.equals("")){
					label.setText("Insert Password!");
			        label.setStyle("-fx-text-fill: #ff0000;");
		        } else {
		        	
		        	bean.setUsername(usernameTextField.getText());
		        	bean.setPassword(passwordTextField.getText());
			        
			        controller.login();
		        	
			        if (bean.getResult()) {
						window.close();
						controller.loggedScene(username);
					} else {
						label.setText("Error, try again or Register your profile!");
				        label.setStyle("-fx-text-fill: #ff0000;");
					}
		        }
			}
		});
        
        window.showAndWait();
	}
	
	public boolean Register(LoginController controller, LoginBean bean) {
		
		loginScene = new VBox();
        loginHBox = new HBox();
        label = new Label();
        usernameLabel = new Label();
        usernameTextField = new TextField();
        loginHBox0 = new HBox();
        passwordLabel = new Label();
        passwordTextField = new PasswordField();
        registerButton = new Button();
        registerHBox = new HBox();
        registerVBox = new VBox();
        registerAsUser = new RadioButton();
        registerAsOwner = new RadioButton();
        
		window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Registration");
        window.setMinWidth(250);

        loginScene.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        loginScene.setPrefWidth(500.0);
        loginScene.setPrefHeight(275.0);
        loginScene.setSpacing(30.0);

        loginHBox.setAlignment(javafx.geometry.Pos.CENTER);
        loginHBox.setSpacing(30.0);

        usernameLabel.setText("Username:");
        usernameLabel.setFont(new Font(24.0));

        usernameTextField.setAlignment(javafx.geometry.Pos.CENTER);
        usernameTextField.setPromptText("Username");
        usernameTextField.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
        usernameTextField.setFont(new Font(24.0));
        VBox.setMargin(loginHBox, new Insets(15.0, 0.0, 0.0, 0.0));

        loginHBox0.setAlignment(javafx.geometry.Pos.CENTER);
        loginHBox0.setSpacing(30.0);
        
        label.setText("Insert Username and Password");
        label.setFont(new Font(24.0));
        VBox.setMargin(label, new Insets(15.0, 0.0, -20.0, 0.0));

        passwordLabel.setText("Password:");
        passwordLabel.setFont(new Font(24.0));

        passwordTextField.setAlignment(javafx.geometry.Pos.CENTER);
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
        passwordTextField.setFont(new Font(24.0));

        registerButton.setMnemonicParsing(false);
        registerButton.setPrefWidth(115.0);
        registerButton.setStyle("-fx-background-color: #1B59D7 #1B59D7;");
        registerButton.setText("Register");
        registerButton.setTextFill(javafx.scene.paint.Color.WHITE);
        registerButton.setFont(new Font(24.0));
        VBox.setMargin(registerButton, new Insets(0.0, 0.0, 15.0, 0.0));
        
        registerHBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        registerHBox.setPrefHeight(100.0);
        registerHBox.setPrefWidth(200.0);
        registerHBox.setSpacing(40.0);
        VBox.setMargin(registerHBox, new Insets(0.0, 0.0, 0.0, 30.0));

        registerVBox.setSpacing(10.0);

        registerAsUser.setMnemonicParsing(false);
        registerAsUser.setText("Register as a User");
        registerAsUser.setFont(new Font(18.0));

        registerAsOwner.setMnemonicParsing(false);
        registerAsOwner.setText("Register as an Owner");
        registerAsOwner.setFont(new Font(18.0));

        loginScene.getChildren().add(label);
        loginScene.getChildren().add(loginHBox);
        loginScene.getChildren().add(loginHBox0);
        loginHBox.getChildren().add(usernameLabel);
        loginHBox.getChildren().add(usernameTextField);
        loginHBox0.getChildren().add(passwordLabel);
        loginHBox0.getChildren().add(passwordTextField);
        registerVBox.getChildren().add(registerAsUser);
        registerVBox.getChildren().add(registerAsOwner);
        registerHBox.getChildren().add(registerVBox);
        registerHBox.getChildren().add(registerButton);
        loginScene.getChildren().add(registerHBox);

        Scene scene = new Scene(loginScene,500,300);
        window.setScene(scene);
        window.setResizable(false);
        
        registerButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
		        username = usernameTextField.getText();
		        password = passwordTextField.getText();
		        
		        if (username.equals("")) {
					label.setText("Insert Username!");
			        label.setStyle("-fx-text-fill: #ff0000;");
		        } else if (password.equals("")){
					label.setText("Insert Password!");
			        label.setStyle("-fx-text-fill: #ff0000;");
		        } else {
			        
		        	bean.setUsername(usernameTextField.getText());
		        	bean.setPassword(passwordTextField.getText());
		        	
		        	if (controller.register()) {
						window.close();
						isRegistred = true;
		        	} else {
						label.setText("This Username is already been used!");
				        label.setStyle("-fx-text-fill: #ff0000;");
					}
		        }
			}
		});
        window.showAndWait();
        return isRegistred;
	}
}

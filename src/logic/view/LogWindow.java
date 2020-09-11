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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.bean.LoginBean;
import logic.controller.ProfileController;
import logic.exceptions.ExistingOwnerException;
import logic.exceptions.ExistingUsernameException;
import logic.exceptions.UsernameException;

public class LogWindow {
    
    protected VBox loginScene;
    protected HBox loginHBox;
    protected Label label;
    protected Label usernameLabel;
    protected TextField usernameTextField;
    protected String username;
    protected HBox loginHBox0;
    protected Label passwordLabel;
    protected PasswordField passwordTextField;
    protected String password;
    protected Button loginButton;
    protected Button registerButton;
    protected Stage window;
    protected HBox registerHBox;
    protected VBox registerVBox;
    protected RadioButton registerAsUser;
    protected RadioButton registerAsOwner;
    protected String usernameReg;
    protected String passwordReg;
    
    boolean isRegistred = false;
    
	String labelStyle = "-fx-text-fill: #ff0000;";
	String styleInput = "-fx-background-color: #e2e8ff; -fx-background-radius: 20;";
	
	public void log(ProfileController controller, LoginBean bean, boolean newUser) {
		
		loginScene = new VBox();
        loginHBox = new HBox();
        label = new Label();
        usernameLabel = new Label();
        usernameTextField = new TextField();
        loginHBox0 = new HBox();
        passwordLabel = new Label();
        passwordTextField = new PasswordField();
        loginButton = new Button();
        
       
        
        inizialize();
        
        VBox.setMargin(loginHBox, new Insets(-10.0, 0.0, 0.0, 0.0));
        
        loginHBox0.setAlignment(javafx.geometry.Pos.CENTER);
        loginHBox0.setSpacing(30.0);
        
        if (newUser) {
            label.setText("Registration completed, proceed with Login!");
            label.setStyle("-fx-text-fill: green;");
        } else {
            label.setText("Insert Username and Password");
            label.setStyle("-fx-text-fill: black;");
        }
        label.setFont(new Font(24.0));
        VBox.setMargin(label, new Insets(15.0, 0.0, 0.0, 0.0));

        passwordLabel.setText("Password:");
        passwordLabel.setFont(new Font(24.0));

        passwordTextField.setAlignment(javafx.geometry.Pos.CENTER);
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle(styleInput);
        passwordTextField.setFont(new Font(24.0));

        loginButton.setMnemonicParsing(false);
        loginButton.setMinWidth(120.0);
        loginButton.setStyle("-fx-background-color: #1B59D7;");
        loginButton.setText("Login");
        loginButton.setTextFill(javafx.scene.paint.Color.WHITE);
        loginButton.setFont(new Font(24.0));
        VBox.setMargin(loginButton, new Insets(0.0, 0.0, 15.0, 0.0));

        loginButton.setOnMouseEntered(evt -> loginButton.setUnderline(true));
        loginButton.setOnMouseExited(evt -> loginButton.setUnderline(false));

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
        
       loginBtn(controller, bean);
        
        window.showAndWait();
	}
	
	
	private void loginBtn(ProfileController controller, LoginBean bean) {
		
		 loginButton.setOnAction(new EventHandler<ActionEvent>(){
	        	@Override
	        	public void handle(ActionEvent event) {
					
			        username = usernameTextField.getText();
			        password = passwordTextField.getText();
			        
			        if (username.equals("")) {
						label.setText("Insert Username!");
				        label.setStyle(labelStyle);  
			        } else if (password.equals("")){
						label.setText("Insert Password!");
				        label.setStyle(labelStyle);
			        } else {
			        	
			        	bean.setUsername(usernameTextField.getText());
			        	bean.setPassword(passwordTextField.getText());
				        
				        controller.login();
			        	
				        if (bean.getResult()) {
							window.close();
							controller.loggedScene();
						} else {
							label.setText("Error, try again or Register your profile!");
					        label.setStyle(labelStyle);
						}
			        }
				}
			});
	}
	
	
	public boolean register(ProfileController controller, LoginBean bean) {
		
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
        final ToggleGroup group = new ToggleGroup();
        
		window = new Stage();
		
		inizialize();
		
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
        passwordTextField.setStyle(styleInput);
        passwordTextField.setFont(new Font(24.0));

        registerButton.setMnemonicParsing(false);
        registerButton.setMinWidth(120.0);
        registerButton.setStyle("-fx-background-color: #1B59D7 #1B59D7;");
        registerButton.setText("Register");
        registerButton.setTextFill(javafx.scene.paint.Color.WHITE);
        registerButton.setFont(new Font(24.0));
        VBox.setMargin(registerButton, new Insets(0.0, 0.0, 15.0, 0.0));

        registerButton.setOnMouseEntered(evt -> registerButton.setUnderline(true));
        registerButton.setOnMouseExited(evt -> registerButton.setUnderline(false));
        
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
        
        registerAsUser.setToggleGroup(group);
        registerAsOwner.setToggleGroup(group);
        
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
        	@Override
        	public void handle(ActionEvent event) {
				
		        usernameReg = usernameTextField.getText();
		        passwordReg = passwordTextField.getText();
		        
		        if (usernameReg.equals("")) {
					label.setText("Insert Username!");
			        label.setStyle(labelStyle);
		        } else if (passwordReg.equals("")){
					label.setText("Insert Password!");
			        label.setStyle(labelStyle);
		        } else if (!registerAsUser.isSelected() && !registerAsOwner.isSelected()) {
					label.setText("Select User or Owner!");
			        label.setStyle(labelStyle);
		        } else {
			        
		        	 isRegistred = reg(bean, controller);	
		        }
			}
		});
        window.showAndWait();
        return isRegistred;
	}
	
	
	private boolean reg(LoginBean bean, ProfileController controller) {
		
		bean.setUsername(usernameTextField.getText());
    	bean.setPassword(passwordTextField.getText());
    	
    	if (registerAsUser.isSelected()) {
    		
    		return regUser(controller);
    		
    	} else {
    		
    		return regOwner(controller);
    	}		      
	}
	
	private boolean regUser(ProfileController controller) {
		
		try {
			if(controller.registerUser()){
				window.close();
				return true;
			}
		} catch (ExistingUsernameException e) {
			
			label.setText("This Username is already been used!");
	        label.setStyle(labelStyle);
	        
		} catch (UsernameException e) {

			label.setText("Try a shorter Username!");
	        label.setStyle(labelStyle);
		}
		return false;
	}

	private boolean regOwner(ProfileController controller) {
		
		try {
			if (controller.registerOwner()) {
				window.close();
				return true;
			}
		} catch (ExistingOwnerException e) {
			
			label.setText("This Username is already been used!");
	        label.setStyle(labelStyle);
	        
		} catch (UsernameException e) {

			label.setText("Try a shorter Username!");
	        label.setStyle(labelStyle);
		}
		return false;
	}
	
	private void inizialize() {
		window = new Stage();

      
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
        usernameTextField.setStyle(styleInput);
        usernameTextField.setFont(new Font(24.0));
	}
}

package logic.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.controller.ProfileController;
import logic.dao.UserDao;
import logic.model.Experience;
import logic.model.User;

public class User2Scene extends HBox{

    protected VBox vBox;
    protected Label nameLabel;
    protected ImageView userImage;
    protected Button btnChangeImage;
    protected HBox hBox0;
    protected Label bookedLabel;
    protected Label numBookedLabel;
    protected HBox hBox1;
    protected Label reviewsLabel;
    protected Label numReviewsLabel;
    protected Button btnLogout;
    
    protected VBox vBox0;
    protected Label experienceLable;
    protected HBox hBox2;
    protected ImageView imageView1;
    protected Button expName1;
    protected ImageView imageView2;
    protected Button expName2;
    protected ImageView imageView3;
    protected Button expName3;
    protected HBox hBox3;
    protected ImageView imageView4;
    protected Button expName4;
    protected ImageView imageView5;
    protected Button expName5;
    protected ImageView imageView6;
    protected Button expName6;
    protected HBox hBoxBtn;
    protected Button btnPrecedent;
    protected Button btnNext;
    protected Label txtNumberPage;

    protected VBox vBox1;
    protected VBox vBox2;
    protected VBox vBox3;
    protected VBox vBox4;
    protected VBox vBox5;
    protected VBox vBox6;

    protected Stage window;
    
    public User2Scene(ProfileController controller, User user, List<Experience> listExp, int booked, int review) {
    	
    	vBox = new VBox();
        nameLabel = new Label();
        userImage = new ImageView();
        btnChangeImage = new Button();
        hBox0 = new HBox();
        bookedLabel = new Label();
        numBookedLabel = new Label();
        hBox1 = new HBox();
        reviewsLabel = new Label();
        numReviewsLabel = new Label();
        btnLogout = new Button();

        vBox0 = new VBox();
        experienceLable = new Label();
        hBox2 = new HBox();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        hBox3 = new HBox();
        imageView4 = new ImageView();
        imageView5 = new ImageView();
        imageView6 = new ImageView();
        hBoxBtn = new HBox();
        btnPrecedent = new Button();
        btnNext = new Button();
        txtNumberPage = new Label();

        expName1 = new Button();
        expName2 = new Button();
        expName3 = new Button();
        expName4 = new Button();
        expName5 = new Button();
        expName6 = new Button();

        vBox1 = new VBox();
        vBox2 = new VBox();
        vBox3 = new VBox();
        vBox4 = new VBox();
        vBox5 = new VBox();
        vBox6 = new VBox();
        
        window = new Stage();
        
        String transparent = "-fx-background-color: transparent;";
        String struct = "strucutre.jpg";
        String vuota = "----------";
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        
        setAlignment(javafx.geometry.Pos.TOP_LEFT);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(525.0);
        vBox.setPrefWidth(350.0);
        vBox.setSpacing(10.0);

        nameLabel.setText(user.getUserName());
        nameLabel.setFont(new Font(48.0));
        VBox.setMargin(nameLabel, new Insets(30.0, 0.0, 0.0, 0.0));

        userImage.setFitHeight(200.0);
        userImage.setFitWidth(200.0);
        userImage.setPickOnBounds(true);
        userImage.setPreserveRatio(true);
        
        Image photo = user.getUserImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource("account.jpg").toExternalForm());
        }
        userImage.setImage(photo);
        
        VBox.setMargin(userImage, new Insets(0.0));

        btnChangeImage.setMnemonicParsing(false);
        btnChangeImage.setStyle(transparent);
        btnChangeImage.setText("Change your profile image");

        btnChangeImage.setOnMouseEntered(evt -> btnChangeImage.setUnderline(true));
        btnChangeImage.setOnMouseExited(evt -> btnChangeImage.setUnderline(false));
        
        btnChangeImage.setFont(new Font(18.0));
        btnChangeImage.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(btnChangeImage, new Insets(-10.0, 0.0, 0.0, 0.0));

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox0.setPrefWidth(200.0);
        hBox0.setSpacing(30.0);

        bookedLabel.setText("Booked:");
        bookedLabel.setFont(new Font(36.0));

        numBookedLabel.setText(String.valueOf(booked));
        numBookedLabel.setFont(new Font(36.0));
        numBookedLabel.setAlignment(javafx.geometry.Pos.CENTER);
        numBookedLabel.setMinWidth(66.0);
        HBox.setMargin(numBookedLabel, new Insets(0.0, 55.0, 0.0, 0.0));
        VBox.setMargin(hBox0, new Insets(20.0, 0.0, 0.0, 0.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox1.setPrefWidth(200.0);
        hBox1.setSpacing(30.0);

        reviewsLabel.setText("Reviews:");
        reviewsLabel.setFont(new Font(36.0));

        numReviewsLabel.setText(String.valueOf(review));
        numReviewsLabel.setFont(new Font(36.0));
        numReviewsLabel.setAlignment(javafx.geometry.Pos.CENTER);
        numReviewsLabel.setMinWidth(66.0);
        HBox.setMargin(numReviewsLabel, new Insets(0.0, 55.0, 0.0, 0.0));
        VBox.setMargin(hBox1, new Insets(10.0, 0.0, 0.0, 0.0));

        btnLogout.setMnemonicParsing(false);
        btnLogout.setStyle(transparent);
        btnLogout.setText("Logout");
        
        btnLogout.setOnMouseEntered(evt -> btnLogout.setUnderline(true));
        btnLogout.setOnMouseExited(evt -> btnLogout.setUnderline(false));
        
        btnLogout.setFont(new Font(18.0));
        btnLogout.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(btnLogout, new Insets(10.0, 0.0, 0.0, 0.0));
        setOpaqueInsets(new Insets(0.0));

        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(700.0);
        vBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        
        experienceLable.setText("Here are your experiences!");
        experienceLable.setFont(new Font(36.0));
        VBox.setMargin(experienceLable, new Insets(20.0, 0.0, 0.0, 0.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(200.0);
        hBox2.setMinWidth(690.0);
        hBox2.setMaxWidth(690.0);
        hBox2.setSpacing(50.0);
        
        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(150.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        
        photo = ((Experience)listExp.get(0)).getImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource(struct).toExternalForm());
        }
    	imageView1.setImage(photo);

        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(150.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        
        photo = ((Experience)listExp.get(1)).getImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource(struct).toExternalForm());
        }
    	imageView2.setImage(photo);

        imageView3.setFitHeight(150.0);
        imageView3.setFitWidth(150.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        
        photo = ((Experience)listExp.get(2)).getImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource(struct).toExternalForm());
        }
    	imageView3.setImage(photo);
        
        hBox3.setAlignment(javafx.geometry.Pos.CENTER);
        hBox3.setPrefHeight(200.0);
        hBox3.setMaxWidth(690.0);
        hBox3.setMinWidth(690.0);
        hBox3.setSpacing(50.0);

        imageView4.setFitHeight(150.0);
        imageView4.setFitWidth(150.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        
        photo = ((Experience)listExp.get(3)).getImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource(struct).toExternalForm());
        }
    	imageView4.setImage(photo);

        imageView5.setFitHeight(150.0);
        imageView5.setFitWidth(150.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        
        photo = ((Experience)listExp.get(4)).getImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource(struct).toExternalForm());
        }
    	imageView5.setImage(photo);

        imageView6.setFitHeight(150.0);
        imageView6.setFitWidth(150.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        
        photo = ((Experience)listExp.get(5)).getImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource(struct).toExternalForm());
        }
    	imageView6.setImage(photo);

        hBoxBtn.setAlignment(javafx.geometry.Pos.CENTER);
        hBoxBtn.setPrefHeight(63.0);
        hBoxBtn.setPrefWidth(841.0);
        hBoxBtn.setSpacing(10.0);
        
        btnPrecedent.setMnemonicParsing(false);
        btnPrecedent.setText("<");
        btnPrecedent.setFont(new Font(24.0));
        btnPrecedent.setStyle("-fx-background-color: #1B59D7;");
        btnPrecedent.setTextFill(javafx.scene.paint.Color.WHITE);

        btnPrecedent.setOnMouseEntered(evt -> btnPrecedent.setUnderline(true));
        btnPrecedent.setOnMouseExited(evt -> btnPrecedent.setUnderline(false));

        btnNext.setMnemonicParsing(false);
        btnNext.setText(">");
        btnNext.setFont(new Font(24.0));
        btnNext.setStyle("-fx-background-color: #1B59D7;");
        btnNext.setTextFill(javafx.scene.paint.Color.WHITE);

        btnNext.setOnMouseEntered(evt -> btnNext.setUnderline(true));
        btnNext.setOnMouseExited(evt -> btnNext.setUnderline(false));

        txtNumberPage.setFont(new Font(18.0));
        txtNumberPage.setAlignment(javafx.geometry.Pos.CENTER);
        txtNumberPage.setMinWidth(15.0);
        
        int page = controller.getPage();

        txtNumberPage.setText(String.valueOf(page));
        
        expName1.setFont(new Font(24.0));
        expName1.setPrefHeight(50.0);
        String name = ((Experience)listExp.get(0)).getName();
    	expName1.setText(vuota);
    	expName1.setDisable(true);
        if (name != null) {
        	expName1.setText(name);
        	expName1.setDisable(false);
            expName1.setOnMouseEntered(evt -> expName1.setUnderline(true));
            expName1.setOnMouseExited(evt -> expName1.setUnderline(false));
        }
        
        expName2.setFont(new Font(24.0));
        expName2.setPrefHeight(50.0);
        name = ((Experience)listExp.get(1)).getName();
    	expName2.setText(vuota);
    	expName2.setDisable(true);
        if (name != null) {
        	expName2.setText(name);
        	expName2.setDisable(false);
            expName2.setOnMouseEntered(evt -> expName2.setUnderline(true));
            expName2.setOnMouseExited(evt -> expName2.setUnderline(false));
        }
        
        expName3.setFont(new Font(24.0));
        expName3.setPrefHeight(50.0);
        name = ((Experience)listExp.get(2)).getName();
    	expName3.setText(vuota);
    	expName3.setDisable(true);
        if (name != null) {
        	expName3.setText(name);
        	expName3.setDisable(false);
            expName3.setOnMouseEntered(evt -> expName3.setUnderline(true));
            expName3.setOnMouseExited(evt -> expName3.setUnderline(false));
        }
        
        expName4.setFont(new Font(24.0));
        expName4.setPrefHeight(50.0);
        name = ((Experience)listExp.get(3)).getName();
    	expName4.setText(vuota);
    	expName4.setDisable(true);
        if (name != null) {
        	expName4.setText(name);
        	expName4.setDisable(false);
            expName4.setOnMouseEntered(evt -> expName4.setUnderline(true));
            expName4.setOnMouseExited(evt -> expName4.setUnderline(false));
        }
        
        expName5.setFont(new Font(24.0));
        expName5.setPrefHeight(50.0);
        name = ((Experience)listExp.get(4)).getName();
    	expName5.setText(vuota);
    	expName5.setDisable(true);
        if (name != null) {
        	expName5.setText(name);
        	expName5.setDisable(false);
            expName5.setOnMouseEntered(evt -> expName5.setUnderline(true));
            expName5.setOnMouseExited(evt -> expName5.setUnderline(false));
        }
        
        expName6.setFont(new Font(24.0));
        expName6.setPrefHeight(50.0);
        name = ((Experience)listExp.get(5)).getName();
    	expName6.setText(vuota);
    	expName6.setDisable(true);
        if (name != null) {
        	expName6.setText(name);
        	expName6.setDisable(false);
            expName6.setOnMouseEntered(evt -> expName6.setUnderline(true));
            expName6.setOnMouseExited(evt -> expName6.setUnderline(false));
        }

        expName1.setStyle(transparent);
        expName2.setStyle(transparent);
        expName3.setStyle(transparent);
        expName4.setStyle(transparent);
        expName5.setStyle(transparent);
        expName6.setStyle(transparent);

        vBox1.setAlignment(javafx.geometry.Pos.CENTER);
        vBox1.setSpacing(5.0);
        vBox1.setPrefWidth(230.0);
        vBox2.setAlignment(javafx.geometry.Pos.CENTER);
        vBox2.setSpacing(5.0);
        vBox2.setPrefWidth(230.0);
        vBox3.setAlignment(javafx.geometry.Pos.CENTER);
        vBox3.setSpacing(5.0);
        vBox3.setPrefWidth(230.0);
        vBox4.setAlignment(javafx.geometry.Pos.CENTER);
        vBox4.setSpacing(5.0);
        vBox4.setPrefWidth(230.0);
        vBox5.setAlignment(javafx.geometry.Pos.CENTER);
        vBox5.setSpacing(5.0);
        vBox5.setPrefWidth(230.0);
        vBox6.setAlignment(javafx.geometry.Pos.CENTER);
        vBox6.setSpacing(5.0);
        vBox6.setPrefWidth(230.0);
        
        vBox.getChildren().add(nameLabel);
        vBox.getChildren().add(userImage);
        vBox.getChildren().add(btnChangeImage);
        hBox0.getChildren().add(bookedLabel);
        hBox0.getChildren().add(numBookedLabel);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(reviewsLabel);
        hBox1.getChildren().add(numReviewsLabel);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(btnLogout);
        getChildren().add(vBox);

        vBox0.getChildren().add(experienceLable);
        vBox1.getChildren().add(imageView1);
        vBox1.getChildren().add(expName1);
        hBox2.getChildren().add(vBox1);
        vBox2.getChildren().add(imageView2);
        vBox2.getChildren().add(expName2);
        hBox2.getChildren().add(vBox2);
        vBox3.getChildren().add(imageView3);
        vBox3.getChildren().add(expName3);
        hBox2.getChildren().add(vBox3);
        vBox0.getChildren().add(hBox2);
        vBox4.getChildren().add(imageView4);
        vBox4.getChildren().add(expName4);
        hBox3.getChildren().add(vBox4);
        vBox5.getChildren().add(imageView5);
        vBox5.getChildren().add(expName5);
        hBox3.getChildren().add(vBox5);
        vBox6.getChildren().add(imageView6);
        vBox6.getChildren().add(expName6);
        hBox3.getChildren().add(vBox6);
        vBox0.getChildren().add(hBox3);

        hBoxBtn.getChildren().add(btnPrecedent);
        hBoxBtn.getChildren().add(txtNumberPage);
        hBoxBtn.getChildren().add(btnNext);
        vBox0.getChildren().add(hBoxBtn);
        getChildren().add(vBox0);
        
        precedent(controller);
        changeImage(user);
        
        btnNext.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				int indice = controller.getIndice();
				controller.changeExperiences(indice);
 				
 			}
 		});
        
        btnLogout.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				user.setUserLogged(false);
 				
 				controller.setIndice(0);
 				controller.setPage(0);
 				
 				controller.changeScene();
 			}
 		});
        
        expName1.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.review((((Experience)listExp.get(0)).getReview().equals("")),((Experience)listExp.get(0)));
 			
 			}
 		});
        
        expName2.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.review((((Experience)listExp.get(1)).getReview().equals("")), ((Experience)listExp.get(1)));
 				
 			}
 		});
        
        expName3.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.review((((Experience)listExp.get(2)).getReview().equals("")),((Experience)listExp.get(2)));
 			
 			}
 		});
        
        expName4.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.review((((Experience)listExp.get(3)).getReview().equals("")), ((Experience)listExp.get(3)));
 			
 			}
 		});
        
        expName5.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.review((((Experience)listExp.get(4)).getReview().equals("")), ((Experience)listExp.get(4)));
 				
 			}
 		});
        
        expName6.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.review(( ((Experience)listExp.get(5)).getReview().equals("")), ((Experience)listExp.get(5)));
 				
 			}
 		});
    }
    
    private void precedent(ProfileController controller) {
        
        btnPrecedent.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				int indice = controller.getIndice();
 				
 				if (indice > 6) {
 					
 					int modIndice = indice%6;
 					
 					if (modIndice == 0) {
 	 					indice = indice - 12;
 					} else if (modIndice == 1) {
 	 	 				indice = indice - 7;
 	 				} else if (modIndice == 2){
 	 					indice = indice - 8;
 	 				} else if (modIndice == 3){
 	 					indice = indice - 9;
 	 				} else if (modIndice == 4){
 	 					indice = indice - 10;
 	 				} else {
 	 					indice = indice - 11;
 	 				}
	 				controller.changeExperiences(indice);
 				}
 			}
 		});
    }
    
    private void changeImage(User user) {
        
        btnChangeImage.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {

        		FileChooser fileChooser = new FileChooser();
 				
 				window.setTitle("Select Image");
 				
 				final File file = fileChooser.showOpenDialog(window);
 				
 	            if (file != null) {

 	                Image image = new Image(file.toURI().toString());
 	                
 	                user.setUserImage(image);
 	                
 	               try (FileInputStream inputStream = new FileInputStream(file)){
						UserDao.setImage(user.getUserName(), inputStream);
					} catch (Exception e) {
						e.printStackTrace();
					}
 	                
 	                userImage.setImage(image);
 	            }
 			}
 		});
    }
}

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
import logic.dao.OwnerDao;
import logic.model.Owner;
import logic.model.Structure;

public class User2SceneOwner extends HBox{
	
	 	protected VBox vBoxOwner;
	    protected Label nameLabelOwner;
	    protected ImageView userImageOwner;
	    protected Button btnChangeImageOwner;
	    protected HBox hBox0Owner;
	    protected Label bookedLabelOwner;
	    protected Label numBookedLabelOwner;
	    protected HBox hBox1Owner;
	    protected Label reviewsLabelOwner;
	    protected Label numReviewsLabelOwner;
	    protected Button btnLogoutStr;
	    
	    protected VBox vBox0;
	    protected Label structureLable;
	    protected HBox hBox2;
	    protected ImageView imageView1Str;
	    protected Button strName1;
	    protected ImageView imageView2Str;
	    protected Button strName2;
	    protected ImageView imageView3Str;
	    protected Button strName3;
	    protected HBox hBox3;
	    protected ImageView imageView4Str;
	    protected Button strName4;
	    protected ImageView imageView5Str;
	    protected Button strName5;
	    protected ImageView imageView6Str;
	    protected Button strName6;
	    protected HBox hBoxBtnStr;
	    protected Button btnPrecedentStr;
	    protected Button btnNextStr;
	    protected Label txtNumberPage;

	    protected VBox vBox1Str;
	    protected VBox vBox2Str;
	    protected VBox vBox3Str;
	    protected VBox vBox4Str;
	    protected VBox vBox5Str;
	    protected VBox vBox6Str;
	    
	    protected Button buttonAddStructure;

	    protected Stage windowOwner;
	
	
	    public User2SceneOwner(ProfileController controller, Owner owner, List<Structure> listStruct, int structures) {
    	
    	vBoxOwner = new VBox();
        nameLabelOwner = new Label();
        userImageOwner = new ImageView();
        btnChangeImageOwner = new Button();
        hBox0Owner = new HBox();
        bookedLabelOwner = new Label();
        numBookedLabelOwner = new Label();
        btnLogoutStr = new Button();

        vBox0 = new VBox();
        structureLable = new Label();
        hBox2 = new HBox();
        imageView1Str = new ImageView();
        imageView2Str = new ImageView();
        imageView3Str = new ImageView();
        hBox3 = new HBox();
        imageView4Str = new ImageView();
        imageView5Str = new ImageView();
        imageView6Str = new ImageView();
        hBoxBtnStr = new HBox();
        btnPrecedentStr = new Button();
        btnNextStr = new Button();
        txtNumberPage = new Label();

        strName1 = new Button();
        strName2 = new Button();
        strName3 = new Button();
        strName4 = new Button();
        strName5 = new Button();
        strName6 = new Button();
        
        buttonAddStructure = new Button();
        hBox1Owner = new HBox();

        vBox1Str = new VBox();
        vBox2Str = new VBox();
        vBox3Str = new VBox();
        vBox4Str = new VBox();
        vBox5Str = new VBox();
        vBox6Str = new VBox();
        
        windowOwner = new Stage();
        
        String struct = "strucutre.jpg";
        String transparent = "-fx-background-color: transparent;";
        String colorBtn = "-fx-background-color: #1B59D7;";
        String vuotaOwn = "----------";

        windowOwner.initModality(Modality.APPLICATION_MODAL);
        windowOwner.setMinWidth(250);
        
        setAlignment(javafx.geometry.Pos.TOP_LEFT);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);

        vBoxOwner.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBoxOwner.setPrefHeight(525.0);
        vBoxOwner.setPrefWidth(350.0);
        vBoxOwner.setSpacing(10.0);

        nameLabelOwner.setText(owner.getOwnerUsername());
        nameLabelOwner.setFont(new Font(48.0));
        VBox.setMargin(nameLabelOwner, new Insets(30.0, 0.0, 0.0, 0.0));

        userImageOwner.setFitHeight(200.0);
        userImageOwner.setFitWidth(200.0);
        userImageOwner.setPickOnBounds(true);
        userImageOwner.setPreserveRatio(true);
        
        Image photo = owner.getOwnerImage();
        
        if (photo == null) {
        	photo = new Image(getClass().getResource("account.jpg").toExternalForm());
        }
        userImageOwner.setImage(photo);
        
        VBox.setMargin(userImageOwner, new Insets(0.0));

        btnChangeImageOwner.setMnemonicParsing(false);
        btnChangeImageOwner.setStyle(transparent);
        btnChangeImageOwner.setText("Change your profile image");

        btnChangeImageOwner.setOnMouseEntered(evt -> btnChangeImageOwner.setUnderline(true));
        btnChangeImageOwner.setOnMouseExited(evt -> btnChangeImageOwner.setUnderline(false));
        
        btnChangeImageOwner.setFont(new Font(18.0));
        btnChangeImageOwner.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(btnChangeImageOwner, new Insets(-10.0, 0.0, 0.0, 0.0));

        hBox0Owner.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox0Owner.setPrefWidth(200.0);
        hBox0Owner.setSpacing(30.0);
        
        bookedLabelOwner.setText("Structures:");
        bookedLabelOwner.setFont(new Font(36.0));

        numBookedLabelOwner.setText(String.valueOf(structures));
        numBookedLabelOwner.setFont(new Font(36.0));
        numBookedLabelOwner.setAlignment(javafx.geometry.Pos.CENTER);
        numBookedLabelOwner.setMinWidth(66.0);
        HBox.setMargin(numBookedLabelOwner, new Insets(0.0, 55.0, 0.0, 0.0));
        VBox.setMargin(hBox0Owner, new Insets(20.0, 0.0, 0.0, 0.0));

        btnLogoutStr.setMnemonicParsing(false);
        btnLogoutStr.setStyle(transparent);
        btnLogoutStr.setText("Logout");
        
        btnLogoutStr.setOnMouseEntered(evt -> btnLogoutStr.setUnderline(true));
        btnLogoutStr.setOnMouseExited(evt -> btnLogoutStr.setUnderline(false));
        
        btnLogoutStr.setFont(new Font(18.0));
        btnLogoutStr.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(btnLogoutStr, new Insets(10.0, 0.0, 0.0, 0.0));
        setOpaqueInsets(new Insets(0.0));

        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(700.0);
        vBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        
        structureLable.setText("Here are your structures!");
        structureLable.setFont(new Font(36.0));
        VBox.setMargin(structureLable, new Insets(20.0, 0.0, 0.0, 0.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(200.0);
        hBox2.setMinWidth(690.0);
        hBox2.setMaxWidth(690.0);
        hBox2.setSpacing(50.0);
        
        imageView1Str.setFitHeight(150.0);
        imageView1Str.setFitWidth(150.0);
        imageView1Str.setPickOnBounds(true);
        imageView1Str.setPreserveRatio(true);
        
        photo = new Image(getClass().getResource(struct).toExternalForm());
        
        imageView1Str.setImage(photo);

        imageView2Str.setFitHeight(150.0);
        imageView2Str.setFitWidth(150.0);
        imageView2Str.setPickOnBounds(true);
        imageView2Str.setPreserveRatio(true);
        
        imageView2Str.setImage(photo);

        imageView3Str.setFitHeight(150.0);
        imageView3Str.setFitWidth(150.0);
        imageView3Str.setPickOnBounds(true);
        imageView3Str.setPreserveRatio(true);
        
        imageView3Str.setImage(photo);
        
        hBox3.setAlignment(javafx.geometry.Pos.CENTER);
        hBox3.setPrefHeight(200.0);
        hBox3.setMaxWidth(690.0);
        hBox3.setMinWidth(690.0);
        hBox3.setSpacing(50.0);

        imageView4Str.setFitHeight(150.0);
        imageView4Str.setFitWidth(150.0);
        imageView4Str.setPickOnBounds(true);
        imageView4Str.setPreserveRatio(true);
        
        imageView4Str.setImage(photo);

        imageView5Str.setFitHeight(150.0);
        imageView5Str.setFitWidth(150.0);
        imageView5Str.setPickOnBounds(true);
        imageView5Str.setPreserveRatio(true);
        
        imageView5Str.setImage(photo);

        imageView6Str.setFitHeight(150.0);
        imageView6Str.setFitWidth(150.0);
        imageView6Str.setPickOnBounds(true);
        imageView6Str.setPreserveRatio(true);
        
        imageView6Str.setImage(photo);

        hBoxBtnStr.setAlignment(javafx.geometry.Pos.CENTER);
        hBoxBtnStr.setPrefHeight(63.0);
        hBoxBtnStr.setPrefWidth(841.0);
        hBoxBtnStr.setSpacing(10.0);
        
        btnPrecedentStr.setMnemonicParsing(false);
        btnPrecedentStr.setText("<");
        btnPrecedentStr.setFont(new Font(24.0));
        btnPrecedentStr.setStyle(colorBtn);
        btnPrecedentStr.setTextFill(javafx.scene.paint.Color.WHITE);

        btnPrecedentStr.setOnMouseEntered(evt -> btnPrecedentStr.setUnderline(true));
        btnPrecedentStr.setOnMouseExited(evt -> btnPrecedentStr.setUnderline(false));

        btnNextStr.setMnemonicParsing(false);
        btnNextStr.setText(">");
        btnNextStr.setFont(new Font(24.0));
        btnNextStr.setStyle(colorBtn);
        btnNextStr.setTextFill(javafx.scene.paint.Color.WHITE);

        btnNextStr.setOnMouseEntered(evt -> btnNextStr.setUnderline(true));
        btnNextStr.setOnMouseExited(evt -> btnNextStr.setUnderline(false));

        txtNumberPage.setFont(new Font(18.0));
        txtNumberPage.setAlignment(javafx.geometry.Pos.CENTER);
        txtNumberPage.setMinWidth(15.0);
        
        int page = controller.getPage();

        txtNumberPage.setText(String.valueOf(page));
        
        strName1.setFont(new Font(24.0));
        strName1.setPrefHeight(50.0);
        String name = ((Structure)listStruct.get(0)).getName();
    	strName1.setText(vuotaOwn);
    	strName1.setDisable(true);
        if (name != null) {
        	strName1.setText(name);
        	strName1.setDisable(false);
            strName1.setOnMouseEntered(evt -> strName1.setUnderline(true));
            strName1.setOnMouseExited(evt -> strName1.setUnderline(false));
        }
        
        strName2.setFont(new Font(24.0));
        strName2.setPrefHeight(50.0);
        name = ((Structure)listStruct.get(1)).getName();
    	strName2.setText(vuotaOwn);
    	strName2.setDisable(true);
        if (name != null) {
        	strName2.setText(name);
        	strName2.setDisable(false);
            strName2.setOnMouseEntered(evt -> strName2.setUnderline(true));
            strName2.setOnMouseExited(evt -> strName2.setUnderline(false));
        }
        
        strName3.setFont(new Font(24.0));
        strName3.setPrefHeight(50.0);
        name = ((Structure)listStruct.get(2)).getName();
    	strName3.setText(vuotaOwn);
    	strName3.setDisable(true);
        if (name != null) {
        	strName3.setText(name);
        	strName3.setDisable(false);
            strName3.setOnMouseEntered(evt -> strName3.setUnderline(true));
            strName3.setOnMouseExited(evt -> strName3.setUnderline(false));
        }
        
        strName4.setFont(new Font(24.0));
        strName4.setPrefHeight(50.0);
        name = ((Structure)listStruct.get(3)).getName();
    	strName4.setText(vuotaOwn);
    	strName4.setDisable(true);
        if (name != null) {
        	strName4.setText(name);
        	strName4.setDisable(false);
            strName4.setOnMouseEntered(evt -> strName4.setUnderline(true));
            strName4.setOnMouseExited(evt -> strName4.setUnderline(false));
        }
        
        strName5.setFont(new Font(24.0));
        strName5.setPrefHeight(50.0);
        name = ((Structure)listStruct.get(4)).getName();
    	strName5.setText(vuotaOwn);
    	strName5.setDisable(true);
        if (name != null) {
        	strName5.setText(name);
        	strName5.setDisable(false);
            strName5.setOnMouseEntered(evt -> strName5.setUnderline(true));
            strName5.setOnMouseExited(evt -> strName5.setUnderline(false));
        }
        
        strName6.setFont(new Font(24.0));
        strName6.setPrefHeight(50.0);
        name = ((Structure)listStruct.get(5)).getName();
    	strName6.setText(vuotaOwn);
    	strName6.setDisable(true);
        if (name != null) {
        	strName6.setText(name);
        	strName6.setDisable(false);
            strName6.setOnMouseEntered(evt -> strName6.setUnderline(true));
            strName6.setOnMouseExited(evt -> strName6.setUnderline(false));
        }
       
		buttonAddStructure.setMnemonicParsing(false);
        buttonAddStructure.setText("Add structure");
        buttonAddStructure.setFont(new Font(24.0));
        buttonAddStructure.setStyle(colorBtn);
        buttonAddStructure.setTextFill(javafx.scene.paint.Color.WHITE);

        buttonAddStructure.setOnMouseEntered(evt -> buttonAddStructure.setUnderline(true));
        buttonAddStructure.setOnMouseExited(evt -> buttonAddStructure.setUnderline(false));

        hBox1Owner.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1Owner.setPrefWidth(200.0);
        hBox1Owner.setSpacing(30.0);

        strName1.setStyle(transparent);
        strName2.setStyle(transparent);
        strName3.setStyle(transparent);
        strName4.setStyle(transparent);
        strName5.setStyle(transparent);
        strName6.setStyle(transparent);

        vBox1Str.setAlignment(javafx.geometry.Pos.CENTER);
        vBox1Str.setSpacing(5.0);
        vBox1Str.setPrefWidth(230.0);
        vBox2Str.setAlignment(javafx.geometry.Pos.CENTER);
        vBox2Str.setSpacing(5.0);
        vBox2Str.setPrefWidth(230.0);
        vBox3Str.setAlignment(javafx.geometry.Pos.CENTER);
        vBox3Str.setSpacing(5.0);
        vBox3Str.setPrefWidth(230.0);
        vBox4Str.setAlignment(javafx.geometry.Pos.CENTER);
        vBox4Str.setSpacing(5.0);
        vBox4Str.setPrefWidth(230.0);
        vBox5Str.setAlignment(javafx.geometry.Pos.CENTER);
        vBox5Str.setSpacing(5.0);
        vBox5Str.setPrefWidth(230.0);
        vBox6Str.setAlignment(javafx.geometry.Pos.CENTER);
        vBox6Str.setSpacing(5.0);
        vBox6Str.setPrefWidth(230.0);
        
        vBoxOwner.getChildren().add(nameLabelOwner);
        vBoxOwner.getChildren().add(userImageOwner);
        vBoxOwner.getChildren().add(btnChangeImageOwner);
        hBox0Owner.getChildren().add(bookedLabelOwner);
        hBox0Owner.getChildren().add(numBookedLabelOwner);
        vBoxOwner.getChildren().add(hBox0Owner);
        hBox1Owner.getChildren().add(buttonAddStructure);
        vBoxOwner.getChildren().add(hBox1Owner);
        vBoxOwner.getChildren().add(btnLogoutStr);
        getChildren().add(vBoxOwner);

        vBox0.getChildren().add(structureLable);
        vBox1Str.getChildren().add(imageView1Str);
        vBox1Str.getChildren().add(strName1);
        hBox2.getChildren().add(vBox1Str);
        vBox2Str.getChildren().add(imageView2Str);
        vBox2Str.getChildren().add(strName2);
        hBox2.getChildren().add(vBox2Str);
        vBox3Str.getChildren().add(imageView3Str);
        vBox3Str.getChildren().add(strName3);
        hBox2.getChildren().add(vBox3Str);
        vBox0.getChildren().add(hBox2);
        vBox4Str.getChildren().add(imageView4Str);
        vBox4Str.getChildren().add(strName4);
        hBox3.getChildren().add(vBox4Str);
        vBox5Str.getChildren().add(imageView5Str);
        vBox5Str.getChildren().add(strName5);
        hBox3.getChildren().add(vBox5Str);
        vBox6Str.getChildren().add(imageView6Str);
        vBox6Str.getChildren().add(strName6);
        hBox3.getChildren().add(vBox6Str);
        vBox0.getChildren().add(hBox3);

        hBoxBtnStr.getChildren().add(btnPrecedentStr);
        hBoxBtnStr.getChildren().add(txtNumberPage);
        hBoxBtnStr.getChildren().add(btnNextStr);
        vBox0.getChildren().add(hBoxBtnStr);
        getChildren().add(vBox0);
        
        precedent(controller);
        changeImage(owner);
        
        buttonAddStructure.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				controller.setStructure(owner.getOwnerUsername());
 			}
 		});
        
        btnNextStr.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				int indice = controller.getIndice();
				controller.changeStructures(indice);
 				
 			}
 		});
        
        btnLogoutStr.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				owner.setOwnerLogged(false);
 				
 				controller.setIndice(0);
 				controller.setPage(0);
 				
 				controller.changeScene();
 			}
 		});
        
        strName1.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				controller.openStructureWindow(((Structure)listStruct.get(0)).getName());
 				
 			}
 		});
        
        strName2.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {

 				controller.openStructureWindow(((Structure)listStruct.get(1)).getName());
 			}
 		});
        
        strName3.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {

 				controller.openStructureWindow(((Structure)listStruct.get(2)).getName());
 			}
 		});
        
        strName4.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {

 				controller.openStructureWindow(((Structure)listStruct.get(3)).getName());
 			}
 		});
        
        strName5.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {

 				controller.openStructureWindow(((Structure)listStruct.get(4)).getName());
 			}
 		});
        
        strName6.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {

 				controller.openStructureWindow(((Structure)listStruct.get(5)).getName());
 			}
 		});
    }
	    
	    private void precedent(ProfileController controller) {
	        
	    	btnPrecedentStr.setOnAction(new EventHandler<ActionEvent>(){
	        	@Override
	        	public void handle(ActionEvent event) {
	 				
	 				int indiceOwn = controller.getIndice();
	 				
	 				if (indiceOwn > 6) {
	 					
	 					int modOwnIndice = indiceOwn%6;
	 					
	 					if (modOwnIndice == 0) {
	 	 					indiceOwn = indiceOwn - 12;
	 					} else if (modOwnIndice == 1) {
	 	 	 				indiceOwn = indiceOwn - 7;
	 	 				} else if (modOwnIndice == 2){
	 	 					indiceOwn = indiceOwn - 8;
	 	 				} else if (modOwnIndice == 3){
	 	 					indiceOwn = indiceOwn - 9;
	 	 				} else if (modOwnIndice == 4){
	 	 					indiceOwn = indiceOwn - 10;
	 	 				} else {
	 	 					indiceOwn = indiceOwn - 11;
	 	 				}
		 				controller.changeStructures(indiceOwn);
	 				}
	 			}
	 		});
	    }
	    
	    private void changeImage(Owner owner) {
	        
	        btnChangeImageOwner.setOnAction(new EventHandler<ActionEvent>(){
	        	@Override
	        	public void handle(ActionEvent event) {
	 				
	 				FileChooser fileChooser = new FileChooser();
	 				
	 				windowOwner.setTitle("Select Image");
	 				
	 				final File file = fileChooser.showOpenDialog(windowOwner);
	 				
	 	            if (file != null) {
	 	            	
	 	                Image image = new Image(file.toURI().toString());
	 	                
	 	                owner.setOwnerImage(image);
	 	                
	 	               try (FileInputStream inputStream = new FileInputStream(file)){
							OwnerDao.setImage(owner.getOwnerUsername(), inputStream);
						} catch (Exception e) {
							e.printStackTrace();
						}
		                
		                userImageOwner.setImage(image);
	 	            }
	 			}
	 		});
	    }
}
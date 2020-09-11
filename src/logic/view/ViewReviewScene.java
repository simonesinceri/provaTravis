package logic.view;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.bean.ReviewBean;
import logic.controller.HotelController;
import logic.controller.ProfileController;
import logic.exceptions.ExceptionSearchReview;
import logic.model.Review;


public class ViewReviewScene extends VBox {

    protected VBox vBox;
    
    protected HBox hBoxReview1;
    protected VBox vBox1;
    protected Label btnNameUser1;
    protected Label labelNumberStar1;
    protected ScrollPane scrollPane1;
    protected Label txtReview1;
    
    protected HBox hBoxReview2;
    protected VBox vBox2;
    protected Label btnNameUser2;
    protected Label labelNumberStar2;
    protected ScrollPane scrollPane2;
    protected Label txtReview2;
    
    protected HBox hBoxReview3;
    protected VBox vBox3;
    protected Label btnNameUser3;
    protected Label labelNumberStar3;
    protected ScrollPane scrollPane3;
    protected Label txtReview3;
    
    protected HBox hBoxBtn;
    protected Button btnBack;
    protected Separator separator;
    protected Separator separator1;
    protected Button btnPreview;
    protected Button btnNext;
    
    protected Separator separatorUser1;
    protected Separator separatorUser2;
    protected Separator separatorUser3;
    

    public ViewReviewScene(boolean isHotel, HotelController controller, ReviewBean beanReview, String reviewTable, int indice, ProfileController profileController) {

        vBox = new VBox();
        hBoxReview1 = new HBox();
        vBox1 = new VBox();
        btnNameUser1 = new Label();
        labelNumberStar1 = new Label();
        txtReview1 = new Label();
        hBoxReview2 = new HBox();
        vBox2 = new VBox();
        btnNameUser2 = new Label();
        labelNumberStar2 = new Label();
        txtReview2 = new Label();
        hBoxReview3 = new HBox();
        vBox3 = new VBox();
        btnNameUser3 = new Label();
        labelNumberStar3 = new Label();
        txtReview3 = new Label();
        hBoxBtn = new HBox();
        btnBack = new Button();
        separator = new Separator();
        separator1 = new Separator();
        btnPreview = new Button();
        btnNext = new Button();
        scrollPane1 = new ScrollPane();
        scrollPane2 = new ScrollPane();
        scrollPane3 = new ScrollPane();
        
        separatorUser1 = new Separator();
        separatorUser2 = new Separator();
        separatorUser3 = new Separator();
        
        List<Review> listReview = beanReview.getReviewList();
        
        String transparent = "-fx-background-color: transparent;";
        String white = "-fx-background-color: white;";
        String stars = " Star/s";
        String noReview = "No review ---";
        String btncolor = "-fx-background-color: #1B59D7;";
        
        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);
        
        vBox.setLayoutX(126.0);
        vBox.setLayoutY(2.0);
        vBox.setPrefHeight(525.0);
        vBox.setPrefWidth(850.0);

        hBoxReview1.setPrefHeight(144.0);
        hBoxReview1.setPrefWidth(200.0);
        hBoxReview1.setSpacing(10.0);
        
        separatorUser1.setOpacity(0.0);
        separatorUser1.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separatorUser1.setPrefHeight(57.0);
        separatorUser1.setPrefWidth(50.0);

        vBox1.setPrefHeight(136.0);
        vBox1.setPrefWidth(240.0);
        vBox1.setSpacing(15.0);
        vBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        btnNameUser1.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        btnNameUser1.setMnemonicParsing(false);
        btnNameUser1.setPrefWidth(240.0);
        btnNameUser1.setStyle(transparent);
        btnNameUser1.setText(((Review)listReview.get(0)).getReviewUser());
        
        btnNameUser1.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        btnNameUser1.setFont(new Font(24.0));

        labelNumberStar1.setPrefWidth(230.0);
        labelNumberStar1.setFont(new Font(18.0));
        labelNumberStar1.setText(String.valueOf(((Review)listReview.get(0)).getReviewVote()) + stars);
        
        scrollPane1.setContent(txtReview1);
        scrollPane1.setMaxWidth(650.0);
        scrollPane1.setMaxHeight(135.0);
        scrollPane1.setFitToWidth(true);
        scrollPane1.setStyle(white);

        txtReview1.setFont(new Font(18.0));
        hBoxReview1.setPadding(new Insets(5.0));
        txtReview1.setText(((Review)listReview.get(0)).getReviewText());
        txtReview1.setPrefWidth(650.0);
        txtReview1.setMinHeight(132.0);
        txtReview1.setWrapText(true);
        txtReview1.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        txtReview1.setStyle(white);
        
        if (((Review)listReview.get(0)).getReviewUser() == null) {
        	btnNameUser1.setText(noReview);
        	labelNumberStar1.setText("");
        	txtReview1.setText("");
        }

        hBoxReview2.setPrefHeight(144.0);
        hBoxReview2.setPrefWidth(200.0);
        hBoxReview2.setSpacing(10.0);
        
        separatorUser2.setOpacity(0.0);
        separatorUser2.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separatorUser2.setPrefHeight(57.0);
        separatorUser2.setPrefWidth(50.0);

        vBox2.setPrefHeight(136.0);
        vBox2.setPrefWidth(240.0);
        vBox2.setSpacing(15.0);
        vBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        btnNameUser2.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        btnNameUser2.setMnemonicParsing(false);
        btnNameUser2.setPrefWidth(240.0);
        btnNameUser2.setStyle(transparent);
        btnNameUser2.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        btnNameUser2.setFont(new Font(24.0));
        btnNameUser2.setText(((Review)listReview.get(0)).getReviewUser());

        labelNumberStar2.setPrefWidth(230.0);
        labelNumberStar2.setFont(new Font(18.0));
        labelNumberStar2.setText(String.valueOf(((Review)listReview.get(1)).getReviewVote()) + stars);
        
        scrollPane2.setContent(txtReview2);
        scrollPane2.setMaxWidth(650.0);
        scrollPane2.setMaxHeight(135.0);
        scrollPane2.setFitToWidth(true);
        scrollPane2.setStyle(white);

        txtReview2.setFont(new Font(18.0));
        hBoxReview2.setPadding(new Insets(5.0));
        txtReview2.setText(((Review)listReview.get(1)).getReviewText());
        txtReview2.setPrefWidth(650.0);
        txtReview2.setMinHeight(132.0);
        txtReview2.setWrapText(true);
        txtReview2.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        txtReview2.setStyle(white);
        
        if (((Review)listReview.get(1)).getReviewUser() == null) {
        	btnNameUser2.setText(noReview);
        	labelNumberStar2.setText("");
        	txtReview2.setText("");
        }

        hBoxReview3.setPrefHeight(144.0);
        hBoxReview3.setPrefWidth(200.0);
        hBoxReview3.setSpacing(10.0);
        
        separatorUser3.setOpacity(0.0);
        separatorUser3.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separatorUser3.setPrefHeight(57.0);
        separatorUser3.setPrefWidth(50.0);

        vBox3.setPrefHeight(136.0);
        vBox3.setPrefWidth(240.0);
        vBox3.setSpacing(15.0);
        vBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        btnNameUser3.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        btnNameUser3.setMnemonicParsing(false);
        btnNameUser3.setPrefHeight(36.0);
        btnNameUser3.setPrefWidth(240.0);
        btnNameUser3.setStyle(transparent);
        btnNameUser3.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        btnNameUser3.setFont(new Font(24.0));
        btnNameUser3.setText(((Review)listReview.get(2)).getReviewUser());

        labelNumberStar3.setPrefHeight(27.0);
        labelNumberStar3.setPrefWidth(230.0);
        labelNumberStar3.setFont(new Font(18.0));
        labelNumberStar3.setText(String.valueOf(((Review)listReview.get(2)).getReviewVote()) + stars);
        
        scrollPane3.setContent(txtReview3);
        scrollPane3.setMaxWidth(650.0);
        scrollPane3.setMaxHeight(135.0);
        scrollPane3.setFitToWidth(true);
        scrollPane3.setStyle(white);

        txtReview3.setFont(new Font(18.0));
        hBoxReview3.setPadding(new Insets(5.0));
        txtReview3.setText(((Review)listReview.get(2)).getReviewText());
        txtReview3.setPrefWidth(650.0);
        txtReview3.setMinHeight(132.0);
        txtReview3.setWrapText(true);
        txtReview3.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        txtReview3.setStyle(white);
        
        if (((Review)listReview.get(2)).getReviewUser() == null) {
        	btnNameUser3.setText(noReview);
        	labelNumberStar3.setText("");
        	txtReview3.setText("");
        }

        hBoxBtn.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBoxBtn.setPrefHeight(57.0);
        hBoxBtn.setPrefWidth(850.0);
        hBoxBtn.setSpacing(10.0);
        
        separator1.setOpacity(0.0);
        separator1.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator1.setPrefHeight(57.0);
        separator1.setPrefWidth(50.0);

        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(39.0);
        btnBack.setPrefWidth(118.0);
        btnBack.setStyle(btncolor);
        btnBack.setText("<< back");
        btnBack.setTextFill(javafx.scene.paint.Color.WHITE);
        btnBack.setFont(new Font(24.0));
        
        btnBack.setOnMouseEntered(evt -> btnBack.setUnderline(true));
    	btnBack.setOnMouseExited(evt -> btnBack.setUnderline(false));

        separator.setOpacity(0.0);
        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator.setPrefHeight(57.0);
        separator.setPrefWidth(270.0);

        btnPreview.setMnemonicParsing(false);
        btnPreview.setPrefHeight(51.0);
        btnPreview.setPrefWidth(51.0);
        btnPreview.setStyle(btncolor);
        btnPreview.setText("<");
        btnPreview.setTextFill(javafx.scene.paint.Color.WHITE);
        btnPreview.setFont(new Font(24.0));
        
        if (indice < 4) {
        	btnPreview.setDisable(true);
        }
        
        btnPreview.setOnMouseEntered(evt -> btnPreview.setUnderline(true));
        btnPreview.setOnMouseExited(evt -> btnPreview.setUnderline(false));

        btnNext.setMnemonicParsing(false);
        btnNext.setPrefHeight(51.0);
        btnNext.setPrefWidth(51.0);
        btnNext.setStyle(btncolor);
        btnNext.setText(">");
        btnNext.setTextFill(javafx.scene.paint.Color.WHITE);
        btnNext.setFont(new Font(24.0));
        
        if (((Review)listReview.get(2)).getReviewUser() == null) {
        	btnNext.setDisable(true);
        }
        
        btnNext.setOnMouseEntered(evt -> btnNext.setUnderline(true));
        btnNext.setOnMouseExited(evt -> btnNext.setUnderline(false));

        vBox1.getChildren().add(btnNameUser1);
        vBox1.getChildren().add(labelNumberStar1);
        hBoxReview1.getChildren().add(separatorUser1);
        hBoxReview1.getChildren().add(vBox1);
        hBoxReview1.getChildren().add(scrollPane1);
        vBox.getChildren().add(hBoxReview1);
        vBox2.getChildren().add(btnNameUser2);
        vBox2.getChildren().add(labelNumberStar2);
        hBoxReview2.getChildren().add(separatorUser2);
        hBoxReview2.getChildren().add(vBox2);
        hBoxReview2.getChildren().add(scrollPane2);
        vBox.getChildren().add(hBoxReview2);
        vBox3.getChildren().add(btnNameUser3);
        vBox3.getChildren().add(labelNumberStar3);
        hBoxReview3.getChildren().add(separatorUser3);
        hBoxReview3.getChildren().add(vBox3);
        hBoxReview3.getChildren().add(scrollPane3);
        vBox.getChildren().add(hBoxReview3);
        hBoxBtn.getChildren().add(separator1);
        hBoxBtn.getChildren().add(btnBack);
        hBoxBtn.getChildren().add(separator);
        hBoxBtn.getChildren().add(btnPreview);
        hBoxBtn.getChildren().add(btnNext);
        vBox.getChildren().add(hBoxBtn);
        getChildren().add(vBox);

        
        btnBack.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {

 				if (isHotel) {
 	 				controller.changeScene();
 				} else {
 					profileController.loggedScene();
 				}
 			}
 		});
        
        btnPreview.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 	 				try {
						controller.viewReviews(isHotel,reviewTable,indice-6);
					} catch (ExceptionSearchReview e) {
						e.printStackTrace();
					}
 			}
 		});
        
        btnNext.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				
 				try {
					controller.viewReviews(isHotel,reviewTable, indice);
				} catch (ExceptionSearchReview e) {
					e.printStackTrace();
				}
 			}
 		});
        
        
    }
}

package logic.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class UserPage extends HBox{
	
    protected VBox vBox;
    protected Label username;
    protected ImageView userImage;
    protected Button changeImageButton;
    protected HBox hBox0;
    protected Label bookedLabel;
    protected Label bookedNumber;
    protected HBox hBox1;
    protected Label reviewsLabel;
    protected Label reviewsNumber;
    protected Button logoutButton;
    protected VBox vBox0;
    protected ScrollPane scrollPane;
    protected VBox vBox1;
    protected Label paneLabel;
    protected HBox hBox2;
    protected ImageView imageView1;
    protected ImageView imageView2;
    protected ImageView imageView3;
    protected HBox hBox3;
    protected ImageView imageView4;
    protected ImageView imageView5;
    protected ImageView imageView6;
    protected HBox hBox4;
    protected ImageView imageView7;
    protected ImageView imageView8;
    protected ImageView imageView9;

    public UserPage(String name){
    	setUp(name);
    }
    
    public void setUp(String name) {

    	vBox = new VBox();
        username = new Label();
        userImage = new ImageView();
        changeImageButton = new Button();
        hBox0 = new HBox();
        bookedLabel = new Label();
        bookedNumber = new Label();
        hBox1 = new HBox();
        reviewsLabel = new Label();
        reviewsNumber = new Label();
        logoutButton = new Button();
        vBox0 = new VBox();
        scrollPane = new ScrollPane();
        vBox1 = new VBox();
        paneLabel = new Label();
        hBox2 = new HBox();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        hBox3 = new HBox();
        imageView4 = new ImageView();
        imageView5 = new ImageView();
        imageView6 = new ImageView();
        hBox4 = new HBox();
        imageView7 = new ImageView();
        imageView8 = new ImageView();
        imageView9 = new ImageView();

        setAlignment(javafx.geometry.Pos.TOP_LEFT);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(525.0);
        vBox.setPrefWidth(350.0);
        vBox.setSpacing(10.0);

        username.setText(name);
        username.setFont(new Font(48.0));
        VBox.setMargin(username, new Insets(30.0, 0.0, 0.0, 0.0));

        userImage.setFitHeight(200.0);
        userImage.setFitWidth(200.0);
        userImage.setPickOnBounds(true);
        userImage.setPreserveRatio(true);
        userImage.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));
        VBox.setMargin(userImage, new Insets(0.0));

        changeImageButton.setMnemonicParsing(false);
        changeImageButton.setStyle("-fx-background-color: transparent;");
        changeImageButton.setText("Change your profile image");
        changeImageButton.setUnderline(true);
        changeImageButton.setFont(new Font(18.0));
        changeImageButton.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(changeImageButton, new Insets(-10.0, 0.0, 0.0, 0.0));

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox0.setPrefWidth(200.0);
        hBox0.setSpacing(30.0);

        bookedLabel.setText("Booked:");
        bookedLabel.setFont(new Font(36.0));

        bookedNumber.setText("000");
        bookedNumber.setFont(new Font(36.0));
        HBox.setMargin(bookedNumber, new Insets(0.0, 55.0, 0.0, 0.0));
        VBox.setMargin(hBox0, new Insets(20.0, 0.0, 0.0, 0.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox1.setPrefWidth(200.0);
        hBox1.setSpacing(30.0);

        reviewsLabel.setText("Reviews:");
        reviewsLabel.setFont(new Font(36.0));

        reviewsNumber.setText("000");
        reviewsNumber.setFont(new Font(36.0));
        HBox.setMargin(reviewsNumber, new Insets(0.0, 55.0, 0.0, 0.0));
        VBox.setMargin(hBox1, new Insets(10.0, 0.0, 0.0, 0.0));

        logoutButton.setMnemonicParsing(false);
        logoutButton.setStyle("-fx-background-color: transparent;");
        logoutButton.setText("Logout");
        logoutButton.setUnderline(true);
        logoutButton.setFont(new Font(18.0));
        logoutButton.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(logoutButton, new Insets(10.0, 0.0, 0.0, 0.0));
        setOpaqueInsets(new Insets(0.0));

        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(700.0);

        scrollPane.setPrefHeight(700.0);
        scrollPane.setPrefWidth(200.0);

        vBox1.setAlignment(javafx.geometry.Pos.CENTER);
        vBox1.setPrefWidth(682.0);

        paneLabel.setText("Here are your experiences!");
        paneLabel.setFont(new Font(36.0));
        VBox.setMargin(paneLabel, new Insets(20.0, 0.0, 0.0, 0.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(200.0);
        hBox2.setPrefWidth(682.0);
        hBox2.setSpacing(20.0);
        VBox.setMargin(hBox2, new Insets(0.0));

        imageView1.setFitHeight(180.0);
        imageView1.setFitWidth(180.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        imageView2.setFitHeight(180.0);
        imageView2.setFitWidth(180.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        imageView3.setFitHeight(180.0);
        imageView3.setFitWidth(180.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER);
        hBox3.setPrefHeight(200.0);
        hBox3.setPrefWidth(682.0);
        hBox3.setSpacing(20.0);

        imageView4.setFitHeight(180.0);
        imageView4.setFitWidth(180.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        imageView5.setFitHeight(180.0);
        imageView5.setFitWidth(180.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        imageView6.setFitHeight(180.0);
        imageView6.setFitWidth(180.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        hBox4.setAlignment(javafx.geometry.Pos.CENTER);
        hBox4.setPrefHeight(200.0);
        hBox4.setPrefWidth(682.0);
        hBox4.setSpacing(20.0);

        imageView7.setFitHeight(180.0);
        imageView7.setFitWidth(180.0);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        imageView7.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        imageView8.setFitHeight(180.0);
        imageView8.setFitWidth(180.0);
        imageView8.setPickOnBounds(true);
        imageView8.setPreserveRatio(true);
        imageView8.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));

        imageView9.setFitHeight(180.0);
        imageView9.setFitWidth(180.0);
        imageView9.setPickOnBounds(true);
        imageView9.setPreserveRatio(true);
        imageView9.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));
        scrollPane.setContent(vBox1);

        vBox.getChildren().add(username);
        vBox.getChildren().add(userImage);
        vBox.getChildren().add(changeImageButton);
        hBox0.getChildren().add(bookedLabel);
        hBox0.getChildren().add(bookedNumber);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(reviewsLabel);
        hBox1.getChildren().add(reviewsNumber);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(logoutButton);
        getChildren().add(vBox);
        vBox1.getChildren().add(paneLabel);
        hBox2.getChildren().add(imageView1);
        hBox2.getChildren().add(imageView2);
        hBox2.getChildren().add(imageView3);
        vBox1.getChildren().add(hBox2);
        hBox3.getChildren().add(imageView4);
        hBox3.getChildren().add(imageView5);
        hBox3.getChildren().add(imageView6);
        vBox1.getChildren().add(hBox3);
        hBox4.getChildren().add(imageView7);
        hBox4.getChildren().add(imageView8);
        hBox4.getChildren().add(imageView9);
        vBox1.getChildren().add(hBox4);
        vBox0.getChildren().add(scrollPane);
        getChildren().add(vBox0);
    }
}

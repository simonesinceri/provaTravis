package logic.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class UserScene_2 extends HBox{

    protected HBox hBox;
    protected VBox vBox;
    protected Label label;
    protected ImageView imageView0;
    protected Button button;
    protected HBox hBox0;
    protected Label label0;
    protected Label label1;
    protected HBox hBox1;
    protected Label label2;
    protected Label label3;
    protected Button button0;
    
    public UserScene_2(String username) {
    	setUp(username);
    }
    
    public void setUp(String username) {
    	
    	vBox = new VBox();
        label = new Label();
        imageView0 = new ImageView();
        button = new Button();
        hBox0 = new HBox();
        label0 = new Label();
        label1 = new Label();
        hBox1 = new HBox();
        label2 = new Label();
        label3 = new Label();
        button0 = new Button();
        
        setAlignment(javafx.geometry.Pos.TOP_LEFT);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(525.0);
        vBox.setPrefWidth(350.0);
        vBox.setSpacing(10.0);

        label.setText(username);
        label.setFont(new Font(48.0));
        VBox.setMargin(label, new Insets(30.0, 0.0, 0.0, 0.0));

        imageView0.setFitHeight(200.0);
        imageView0.setFitWidth(200.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("account.jpg").toExternalForm()));
        VBox.setMargin(imageView0, new Insets(0.0));

        button.setMnemonicParsing(false);
        button.setStyle("-fx-background-color: transparent;");
        button.setText("Change your profile image");
        button.setUnderline(true);
        button.setFont(new Font(18.0));
        button.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(button, new Insets(-10.0, 0.0, 0.0, 0.0));

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox0.setPrefWidth(200.0);
        hBox0.setSpacing(30.0);

        label0.setText("Booked:");
        label0.setFont(new Font(36.0));

        label1.setText("000");
        label1.setFont(new Font(36.0));
        HBox.setMargin(label1, new Insets(0.0, 55.0, 0.0, 0.0));
        VBox.setMargin(hBox0, new Insets(20.0, 0.0, 0.0, 0.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox1.setPrefWidth(200.0);
        hBox1.setSpacing(30.0);

        label2.setText("Reviews:");
        label2.setFont(new Font(36.0));

        label3.setText("000");
        label3.setFont(new Font(36.0));
        HBox.setMargin(label3, new Insets(0.0, 55.0, 0.0, 0.0));
        VBox.setMargin(hBox1, new Insets(10.0, 0.0, 0.0, 0.0));

        button0.setMnemonicParsing(false);
        button0.setStyle("-fx-background-color: transparent;");
        button0.setText("Logout");
        button0.setUnderline(true);
        button0.setFont(new Font(18.0));
        button0.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        VBox.setMargin(button0, new Insets(10.0, 0.0, 0.0, 0.0));
        setOpaqueInsets(new Insets(0.0));

        vBox.getChildren().add(label);
        vBox.getChildren().add(imageView0);
        vBox.getChildren().add(button);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(label1);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(label2);
        hBox1.getChildren().add(label3);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(button0);
        getChildren().add(vBox);
    }
}

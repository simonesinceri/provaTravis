package logic.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomeScene extends HBox{
	
    protected VBox homeVbox1;
    protected Text homeText;
    protected Text homeText0;
    protected Text homeText1;
    protected Text homeText2;
    protected Text homeText3;
    protected Text homeText4;
    protected Text homeText5;
    protected VBox homeVbox2;
    protected Text homeText6;
    protected Text homeText7;
    protected Text homeText8;
    protected ImageView punti;
    
    public HomeScene() {
    	setUp();
    }
    
    public void setUp() {
    	
        homeVbox1 = new VBox();
        homeText = new Text();
        homeText0 = new Text();
        homeText1 = new Text();
        homeText2 = new Text();
        homeText3 = new Text();
        homeText4 = new Text();
        homeText5 = new Text();
        homeVbox2 = new VBox();
        homeText6 = new Text();
        homeText7 = new Text();
        homeText8 = new Text();
        punti = new ImageView();
        
        setAlignment(javafx.geometry.Pos.CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);

        VBox.setVgrow(homeText, javafx.scene.layout.Priority.ALWAYS);
        homeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText.setStrokeWidth(0.0);
        homeText.setText("Welcome in Findit!");
        homeText.setWrappingWidth(465.0);
        homeText.setFont(new Font(60.0));

        VBox.setVgrow(homeText0, javafx.scene.layout.Priority.ALWAYS);
        homeText0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText0.setStrokeWidth(0.0);
        homeText0.setText("Are you looking for an hotel,");
        homeText0.setWrappingWidth(405.11102294921875);
        homeText0.setFont(new Font(35.0));
        VBox.setMargin(homeText0, new Insets(35.0, 0.0, 0.0, 0.0));

        VBox.setVgrow(homeText1, javafx.scene.layout.Priority.ALWAYS);
        homeText1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText1.setStrokeWidth(0.0);
        homeText1.setText("a restaurant, or an event?");
        homeText1.setFont(new Font(35.0));
        VBox.setMargin(homeText1, new Insets(0.0));

        homeText2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText2.setStrokeWidth(0.0);
        homeText2.setText("Or are your an owner?");
        homeText2.setFont(new Font(35.0));
        VBox.setMargin(homeText2, new Insets(0.0));

        VBox.setVgrow(homeText3, javafx.scene.layout.Priority.ALWAYS);
        homeText3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText3.setStrokeWidth(0.0);
        homeText3.setText("That’s the right place!");
        homeText3.setFont(new Font(35.0));
        VBox.setMargin(homeText3, new Insets(20.0, 0.0, 0.0, 0.0));

        homeText4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText4.setStrokeWidth(0.0);
        homeText4.setText("Find what you are looking for ");
        homeText4.setFont(new Font(35.0));
        VBox.setMargin(homeText4, new Insets(0.0));

        homeText5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText5.setStrokeWidth(0.0);
        homeText5.setText("or register your business!");
        homeText5.setFont(new Font(35.0));
        VBox.setMargin(homeText5, new Insets(0.0));
        HBox.setMargin(homeVbox1, new Insets(50.0, 200.0, 0.0, 0.0));

        homeVbox2.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        homeVbox2.setPrefHeight(317.0);
        homeVbox2.setPrefWidth(137.0);

        homeText6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText6.setStrokeWidth(0.0);
        homeText6.setText("Search");
        homeText6.setFont(new Font(45.0));

        homeText7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText7.setStrokeWidth(0.0);
        homeText7.setText("Book");
        homeText7.setFont(new Font(45.0));
        VBox.setMargin(homeText7, new Insets(115.0, 0.0, 120.0, 0.0));

        homeText8.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        homeText8.setStrokeWidth(0.0);
        homeText8.setText("Review");
        homeText8.setWrappingWidth(136.16455078125);
        homeText8.setFont(new Font(45.0));
        HBox.setMargin(homeVbox2, new Insets(0.0, 10.0, 0.0, 0.0));

        punti.setFitHeight(405.0);
        punti.setFitWidth(49.0);
        punti.setPickOnBounds(true);
        punti.setPreserveRatio(true);
        punti.setImage(new Image(getClass().getResource("Punti.jpg").toExternalForm()));
        
        homeVbox1.getChildren().add(homeText);
        homeVbox1.getChildren().add(homeText0);
        homeVbox1.getChildren().add(homeText1);
        homeVbox1.getChildren().add(homeText2);
        homeVbox1.getChildren().add(homeText3);
        homeVbox1.getChildren().add(homeText4);
        homeVbox1.getChildren().add(homeText5);
        getChildren().add(homeVbox1);
        homeVbox2.getChildren().add(homeText6);
        homeVbox2.getChildren().add(homeText7);
        homeVbox2.getChildren().add(homeText8);
        getChildren().add(homeVbox2);
        getChildren().add(punti);
    }
}

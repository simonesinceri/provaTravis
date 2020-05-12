package application;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Hotel2Scene extends VBox{

	
    protected final VBox vBox;
    protected final HBox hBox0;
    protected final ImageView imageView0;
    protected final VBox vBox0;
    protected final Button button5;
    protected final Label label;
    protected final HBox hBox1;
    protected final ImageView imageView1;
    protected final VBox vBox1;
    protected final Button button6;
    protected final Label label0;
    protected final HBox hBox2;
    protected final ImageView imageView2;
    protected final VBox vBox2;
    protected final Button button7;
    protected final Label label1;
    protected final HBox hBox3;
    protected final Button button8;
    protected final Button button9;

    public Hotel2Scene() {


        vBox = new VBox();
        hBox0 = new HBox();
        imageView0 = new ImageView();
        vBox0 = new VBox();
        button5 = new Button();
        label = new Label();
        hBox1 = new HBox();
        imageView1 = new ImageView();
        vBox1 = new VBox();
        button6 = new Button();
        label0 = new Label();
        hBox2 = new HBox();
        imageView2 = new ImageView();
        vBox2 = new VBox();
        button7 = new Button();
        label1 = new Label();
        hBox3 = new HBox();
        button8 = new Button();
        button9 = new Button();

     
     /* setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);  //queste sono da modificare!!!
        setMinWidth(USE_PREF_SIZE);
    */    
        
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);

        vBox.setLayoutX(104.5);
        vBox.setLayoutY(24.0);
        vBox.setPrefHeight(477.0);
        vBox.setPrefWidth(841.0);

        hBox0.setPrefHeight(136.0);
        hBox0.setPrefWidth(200.0);
        hBox0.setSpacing(10.0);

        imageView0.setFitHeight(136.0);
        imageView0.setFitWidth(171.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        vBox0.setPrefHeight(136.0);
        vBox0.setPrefWidth(427.0);

        button5.setMnemonicParsing(false);
        button5.setStyle("-fx-background-color: transparent;");
        button5.setText("Hotel1");
        button5.setUnderline(true);
        button5.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        button5.setFont(new Font(24.0));

        label.setText("Indirizzo");
        label.setFont(new Font(18.0));
        hBox0.setPadding(new Insets(5.0));

        hBox1.setPrefHeight(136.0);
        hBox1.setPrefWidth(200.0);
        hBox1.setSpacing(10.0);

        imageView1.setFitHeight(136.0);
        imageView1.setFitWidth(171.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);

        vBox1.setPrefHeight(200.0);
        vBox1.setPrefWidth(427.0);

        button6.setMnemonicParsing(false);
        button6.setStyle("-fx-background-color: transparent;");
        button6.setText("Hotel2");
        button6.setUnderline(true);
        button6.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        button6.setFont(new Font(24.0));

        label0.setText("Indirizzo");
        label0.setFont(new Font(18.0));
        hBox1.setPadding(new Insets(5.0));

        hBox2.setPrefHeight(136.0);
        hBox2.setPrefWidth(200.0);
        hBox2.setSpacing(10.0);

        imageView2.setFitHeight(136.0);
        imageView2.setFitWidth(171.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);

        vBox2.setPrefHeight(200.0);
        vBox2.setPrefWidth(427.0);

        button7.setMnemonicParsing(false);
        button7.setStyle("-fx-background-color: transparent;");
        button7.setText("Hotel3");
        button7.setUnderline(true);
        button7.setPadding(new Insets(1.0, 0.0, 0.0, 0.0));
        button7.setFont(new Font(24.0));

        label1.setText("Indirizzo");
        label1.setFont(new Font(18.0));
        hBox2.setPadding(new Insets(5.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER);
        hBox3.setPrefHeight(63.0);
        hBox3.setPrefWidth(841.0);
        hBox3.setSpacing(10.0);

        button8.setMnemonicParsing(false);
        button8.setText("<");
        button8.setFont(new Font(18.0));

        button9.setMnemonicParsing(false);
        button9.setText(">");
        button9.setFont(new Font(18.0));
        setOpaqueInsets(new Insets(0.0));

        
        hBox0.getChildren().add(imageView0);
        vBox0.getChildren().add(button5);
        vBox0.getChildren().add(label);
        hBox0.getChildren().add(vBox0);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(imageView1);
        vBox1.getChildren().add(button6);
        vBox1.getChildren().add(label0);
        hBox1.getChildren().add(vBox1);
        vBox.getChildren().add(hBox1);
        hBox2.getChildren().add(imageView2);
        vBox2.getChildren().add(button7);
        vBox2.getChildren().add(label1);
        hBox2.getChildren().add(vBox2);
        vBox.getChildren().add(hBox2);
        hBox3.getChildren().add(button8);
        hBox3.getChildren().add(button9);
        vBox.getChildren().add(hBox3);
        
        getChildren().add(vBox);
        

    }
}


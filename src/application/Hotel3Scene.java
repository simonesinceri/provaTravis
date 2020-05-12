package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Hotel3Scene extends VBox{
	
	protected final VBox vBox;
    protected final HBox hBox0;
    protected final ImageView imageView0;
    protected final VBox vBox0;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final VBox vBox1;
    protected final Button button5;
    protected final VBox vBox2;
    protected final Text text2;
    protected final HBox hBox1;
    protected final Button button6;
    protected final Button button7;

    public Hotel3Scene() {

        
        vBox = new VBox();
        hBox0 = new HBox();
        imageView0 = new ImageView();
        vBox0 = new VBox();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        vBox1 = new VBox();
        button5 = new Button();
        vBox2 = new VBox();
        text2 = new Text();
        hBox1 = new HBox();
        button6 = new Button();
        button7 = new Button();

     /* setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        */
        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);

     
        vBox.setLayoutX(104.5);
        vBox.setLayoutY(24.0);
        vBox.setPrefHeight(477.0);
        vBox.setPrefWidth(841.0);

        hBox0.setPrefHeight(138.0);
        hBox0.setPrefWidth(841.0);
        hBox0.setSpacing(30.0);

        imageView0.setFitHeight(162.0);
        imageView0.setFitWidth(200.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(150.0);
        vBox0.setPrefWidth(342.0);
        vBox0.setSpacing(10.0);

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Nome Hotel");
        text.setWrappingWidth(140.705078125);
        text.setFont(new Font(24.0));

        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("indirizzo");
        text0.setWrappingWidth(140.705078125);
        text0.setFont(new Font(24.0));

        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Numero stars");
        text1.setFont(new Font(24.0));

        vBox1.setAlignment(javafx.geometry.Pos.CENTER);
        vBox1.setPrefHeight(162.0);
        vBox1.setPrefWidth(239.0);

        button5.setMnemonicParsing(false);
        button5.setStyle("-fx-background-color: transparent;");
        button5.setText("View Reviews");
        button5.setUnderline(true);
        button5.setFont(new Font(24.0));

        vBox2.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox2.setPrefHeight(250.0);
        vBox2.setPrefWidth(841.0);

        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Breve descrizione dell'hotel");
        text2.setFont(new Font(24.0));
        vBox2.setPadding(new Insets(30.0, 0.0, 0.0, 0.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(75.0);
        hBox1.setPrefWidth(841.0);
        hBox1.setSpacing(30.0);

        button6.setMnemonicParsing(false);
        button6.setText("Undo");
        button6.setFont(new Font(24.0));

        button7.setMnemonicParsing(false);
        button7.setStyle("-fx-background-color: #1B59D7;");
        button7.setText("Book");
        button7.setTextFill(javafx.scene.paint.Color.WHITE);
        button7.setFont(new Font(24.0));
        setOpaqueInsets(new Insets(0.0));

     
        hBox0.getChildren().add(imageView0);
        vBox0.getChildren().add(text);
        vBox0.getChildren().add(text0);
        vBox0.getChildren().add(text1);
        hBox0.getChildren().add(vBox0);
        vBox1.getChildren().add(button5);
        hBox0.getChildren().add(vBox1);
        vBox.getChildren().add(hBox0);
        vBox2.getChildren().add(text2);
        vBox.getChildren().add(vBox2);
        hBox1.getChildren().add(button6);
        hBox1.getChildren().add(button7);
        vBox.getChildren().add(hBox1);
        getChildren().add(vBox);
        

    }
}


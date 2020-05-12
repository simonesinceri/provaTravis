package application;





import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class prova1 extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final HBox hBox;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final VBox vBox;
    protected final Label label;
    protected final TextField textField;
    protected final HBox hBox0;
    protected final Label label0;
    protected final Label label1;
    protected final HBox hBox1;
    protected final DatePicker datePicker;
    protected final DatePicker datePicker0;
    protected final Label label2;
    protected final TextField textField0;
    protected final Separator separator;
    protected final Button button5;
    protected final VBox vBox0;
    protected final Label label3;
    protected final CheckBox checkBox;
    protected final CheckBox checkBox0;
    protected final CheckBox checkBox1;
    protected final CheckBox checkBox2;
    protected final Label label4;
    protected final VBox vBox1;
    protected final Label label5;

    public prova1() {

        imageView = new ImageView();
        button = new Button();
        hBox = new HBox();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        vBox = new VBox();
        label = new Label();
        textField = new TextField();
        hBox0 = new HBox();
        label0 = new Label();
        label1 = new Label();
        hBox1 = new HBox();
        datePicker = new DatePicker();
        datePicker0 = new DatePicker();
        label2 = new Label();
        textField0 = new TextField();
        separator = new Separator();
        button5 = new Button();
        vBox0 = new VBox();
        label3 = new Label();
        checkBox = new CheckBox();
        checkBox0 = new CheckBox();
        checkBox1 = new CheckBox();
        checkBox2 = new CheckBox();
        label4 = new Label();
        vBox1 = new VBox();
        label5 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(680.0);
        setPrefWidth(1050.0);

        AnchorPane.setBottomAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 0.0);
        AnchorPane.setTopAnchor(imageView, 0.0);
        imageView.setFitHeight(680.0);
        imageView.setFitWidth(1050.0);
        imageView.setLayoutX(-4.0);
        imageView.setLayoutY(-5.0);
        imageView.setImage(new Image(getClass().getResource("Desktop%20-%201-2.jpg").toExternalForm()));

        button.setLayoutX(39.0);
        button.setLayoutY(30.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(82.0);
        button.setPrefWidth(215.0);
        button.setStyle("-fx-background-color: trasparent;");
        button.setText("FindIT");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        button.setUnderline(true);
        button.setFont(new Font(72.0));
        button.setPadding(new Insets(5.0, 20.0, 0.0, 0.0));

        hBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox.setLayoutX(455.0);
        hBox.setLayoutY(100.0);
        hBox.setPrefHeight(45.0);
        hBox.setPrefWidth(560.0);

        button0.setMnemonicParsing(false);
        button0.setStyle("-fx-background-color: trasparent;");
        button0.setText("Hotels");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#f29100"));
        button0.setUnderline(true);
        button0.setFont(new Font(24.0));

        button1.setMnemonicParsing(false);
        button1.setStyle("-fx-background-color: trasparent;");
        button1.setText("Restaurants");
        button1.setTextFill(javafx.scene.paint.Color.WHITE);
        button1.setUnderline(true);
        button1.setFont(new Font(24.0));

        button2.setMnemonicParsing(false);
        button2.setStyle("-fx-background-color: trasparent;");
        button2.setText("Events");
        button2.setTextFill(javafx.scene.paint.Color.WHITE);
        button2.setUnderline(true);
        button2.setFont(new Font(24.0));

        button3.setMnemonicParsing(false);
        button3.setStyle("-fx-background-color: trasparent;");
        button3.setText("Map");
        button3.setTextFill(javafx.scene.paint.Color.WHITE);
        button3.setUnderline(true);
        button3.setFont(new Font(24.0));

        button4.setMnemonicParsing(false);
        button4.setStyle("-fx-background-color: trasparent;");
        button4.setText("Profile");
        button4.setTextFill(javafx.scene.paint.Color.WHITE);
        button4.setUnderline(true);
        button4.setFont(new Font(24.0));

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setLayoutX(38.0);
        vBox.setLayoutY(218.0);
        vBox.setPrefHeight(409.0);
        vBox.setPrefWidth(497.0);
        vBox.setSpacing(10.0);

        label.setText("Where you would like to go?");
        label.setFont(new Font(24.0));

        textField.setPromptText("Es. London");
        textField.setFont(new Font(18.0));

        hBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBox0.setPrefHeight(35.0);
        hBox0.setPrefWidth(497.0);
        hBox0.setSpacing(105.0);

        label0.setText("Check-in");
        label0.setFont(new Font(24.0));

        label1.setText("Check-out");
        label1.setFont(new Font(24.0));

        hBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBox1.setPrefHeight(51.0);
        hBox1.setPrefWidth(497.0);
        hBox1.setSpacing(30.0);

        datePicker.setCache(true);
        datePicker.setEditable(false);
        datePicker.setPrefHeight(51.0);
        datePicker.setPrefWidth(176.0);

        datePicker0.setEditable(false);
        datePicker0.setPrefHeight(51.0);
        datePicker0.setPrefWidth(176.0);

        label2.setText("Number of peolple");
        label2.setFont(new Font(24.0));

        textField0.setMaxWidth(USE_PREF_SIZE);
        textField0.setPrefHeight(51.0);
        textField0.setPrefWidth(210.0);
        textField0.setPromptText("Es. 4");
        textField0.setFont(new Font(18.0));

        separator.setPrefHeight(17.0);
        separator.setPrefWidth(497.0);
        separator.setVisible(false);

        button5.setMnemonicParsing(false);
        button5.setStyle("-fx-background-color: #1B59D7;");
        button5.setText("Search");
        button5.setTextFill(javafx.scene.paint.Color.WHITE);
        button5.setFont(new Font(24.0));

        vBox0.setLayoutX(573.0);
        vBox0.setLayoutY(252.0);
        vBox0.setPrefHeight(396.0);
        vBox0.setPrefWidth(221.0);
        vBox0.setSpacing(2.0);

        label3.setText("Budget");
        label3.setFont(new Font(24.0));
        VBox.setMargin(label3, new Insets(0.0));

        checkBox.setMnemonicParsing(false);
        checkBox.setText("€50-€100 for night");
        checkBox.setFont(new Font(18.0));

        checkBox0.setMnemonicParsing(false);
        checkBox0.setText("€100-€150 for night");
        checkBox0.setFont(new Font(18.0));

        checkBox1.setMnemonicParsing(false);
        checkBox1.setText("€150-€200 for night");
        checkBox1.setFont(new Font(18.0));

        checkBox2.setMnemonicParsing(false);
        checkBox2.setText("€200 + for night");
        checkBox2.setFont(new Font(18.0));

        label4.setText("Property type");
        label4.setFont(new Font(24.0));
        VBox.setMargin(label4, new Insets(8.0, 0.0, 0.0, 0.0));

        vBox1.setLayoutX(828.0);
        vBox1.setLayoutY(252.0);
        vBox1.setPrefHeight(396.0);
        vBox1.setPrefWidth(185.0);

        label5.setLayoutX(763.0);
        label5.setLayoutY(210.0);
        label5.setText("Filter by:");
        label5.setFont(new Font(24.0));
        setOpaqueInsets(new Insets(0.0));

        getChildren().add(imageView);
        getChildren().add(button);
        hBox.getChildren().add(button0);
        hBox.getChildren().add(button1);
        hBox.getChildren().add(button2);
        hBox.getChildren().add(button3);
        hBox.getChildren().add(button4);
        getChildren().add(hBox);
        vBox.getChildren().add(label);
        vBox.getChildren().add(textField);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(label1);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(datePicker);
        hBox1.getChildren().add(datePicker0);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(textField0);
        vBox.getChildren().add(separator);
        vBox.getChildren().add(button5);
        getChildren().add(vBox);
        vBox0.getChildren().add(label3);
        vBox0.getChildren().add(checkBox);
        vBox0.getChildren().add(checkBox0);
        vBox0.getChildren().add(checkBox1);
        vBox0.getChildren().add(checkBox2);
        vBox0.getChildren().add(label4);
        getChildren().add(vBox0);
        getChildren().add(vBox1);
        getChildren().add(label5);

    }
}



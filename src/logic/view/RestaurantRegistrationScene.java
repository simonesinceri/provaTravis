package logic.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RestaurantRegistrationScene extends VBox {

    protected VBox vBoxPrincipale;
    protected HBox hBoxTitle;
    protected Text textTitle;
    protected HBox hBoxCorpoCentrale;
    protected VBox vBoxSx;
    protected HBox hBox2;
    protected Text textName;
    protected Text textStar;
    protected HBox hBox3;
    protected TextField textFieldName;
    protected TextField textFieldStar;
    protected HBox hBox4;
    protected Text textCity;
    protected Text textAddress;
    protected HBox hBox5;
    protected TextField textFieldCity;
    protected TextField textFieldAddress;
    protected HBox hBox6;
    protected Text textType;
    protected HBox hBoxCheck;
    protected VBox vBox1;
    protected CheckBox checkBoxPizza;
    protected CheckBox checkBoxSushi;
    protected CheckBox checkBoxHamburger;
    protected CheckBox checkBoxPasta;
    protected VBox vBox2;
    protected CheckBox checkBoxMeat;
    protected CheckBox checkBoxFish;
    protected CheckBox checkBoxVegan;
    protected CheckBox checkBoxGourmet;
    protected VBox vBoxDx;
    protected HBox hBox8;
    protected Text text5;
    protected TextField tfTables2Seats;
    protected HBox hBox9;
    protected Text text6;
    protected TextField tfTables4Seats;
    protected HBox hBox10;
    protected Text text7;
    protected TextField tfTables6Seats;
    protected HBox hBox11;
    protected Text text8;
    protected TextField tfTables8Seats;
    protected Separator separator;
    protected HBox hBoxBudget;
    protected VBox vBox4;
    protected Text text9;
    protected VBox vBox5;
    protected CheckBox check50To100;
    protected CheckBox check100To150;
    protected CheckBox check150To200;
    protected CheckBox checkBox200;
    protected HBox hBoxBtn;
    protected Button btnUndo;
    protected Button btnRegister;

    public RestaurantRegistrationScene() {  // bean e controller

        vBoxPrincipale = new VBox();
        hBoxTitle = new HBox();
        textTitle = new Text();
        hBoxCorpoCentrale = new HBox();
        vBoxSx = new VBox();
        hBox2 = new HBox();
        textName = new Text();
        textStar = new Text();
        hBox3 = new HBox();
        textFieldName = new TextField();
        textFieldStar = new TextField();
        hBox4 = new HBox();
        textCity = new Text();
        textAddress = new Text();
        hBox5 = new HBox();
        textFieldCity = new TextField();
        textFieldAddress = new TextField();
        hBox6 = new HBox();
        textType = new Text();
        hBoxCheck = new HBox();
        vBox1 = new VBox();
        checkBoxPizza = new CheckBox();
        checkBoxSushi = new CheckBox();
        checkBoxHamburger = new CheckBox();
        checkBoxPasta = new CheckBox();
        vBox2 = new VBox();
        checkBoxMeat = new CheckBox();
        checkBoxFish = new CheckBox();
        checkBoxVegan = new CheckBox();
        checkBoxGourmet = new CheckBox();
        vBoxDx = new VBox();
        hBox8 = new HBox();
        text5 = new Text();
        tfTables2Seats = new TextField();
        hBox9 = new HBox();
        text6 = new Text();
        tfTables4Seats = new TextField();
        hBox10 = new HBox();
        text7 = new Text();
        tfTables6Seats = new TextField();
        hBox11 = new HBox();
        text8 = new Text();
        tfTables8Seats = new TextField();
        separator = new Separator();
        hBoxBudget = new HBox();
        vBox4 = new VBox();
        text9 = new Text();
        vBox5 = new VBox();
        check50To100 = new CheckBox();
        check100To150 = new CheckBox();
        check150To200 = new CheckBox();
        checkBox200 = new CheckBox();
        hBoxBtn = new HBox();
        btnUndo = new Button();
        btnRegister = new Button();
        
        String style = "-fx-background-color: #e2e8ff#e2e8ff; -fx-background-radius: 20;";

        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);

        vBoxPrincipale.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBoxPrincipale.setLayoutX(15.0);
        vBoxPrincipale.setLayoutY(24.0);
        vBoxPrincipale.setPrefHeight(485.0);
        vBoxPrincipale.setPrefWidth(1020.0);

        hBoxTitle.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBoxTitle.setPrefHeight(100.0);
        hBoxTitle.setPrefWidth(200.0);

        textTitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textTitle.setStrokeWidth(0.0);
        textTitle.setText("Restaurant Registration");
        textTitle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textTitle.setWrappingWidth(320.64129638671875);
        textTitle.setFont(new Font(24.0));

        hBoxCorpoCentrale.setPrefHeight(452.0);
        hBoxCorpoCentrale.setPrefWidth(1017.0);

        vBoxSx.setPrefHeight(433.0);
        vBoxSx.setPrefWidth(510.0);

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(37.0);
        hBox2.setPrefWidth(510.0);
        hBox2.setSpacing(200.0);

        textName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textName.setStrokeWidth(0.0);
        textName.setText("Name");
        textName.setFont(new Font(24.0));

        textStar.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textStar.setStrokeWidth(0.0);
        textStar.setText("Star");
        textStar.setFont(new Font(24.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER);
        hBox3.setPrefHeight(60.0);
        hBox3.setPrefWidth(500.0);
        hBox3.setSpacing(30.0);

        textFieldName.setAlignment(javafx.geometry.Pos.CENTER);
        textFieldName.setPromptText("Name Restaurant");
        textFieldName.setStyle(style );
        textFieldName.setFont(new Font(24.0));
        HBox.setMargin(textFieldName, new Insets(0.0, 0.0, 0.0, 10.0));

        textFieldStar.setAlignment(javafx.geometry.Pos.CENTER);
        textFieldStar.setPromptText("1 to 5 star");
        textFieldStar.setStyle(style);
        textFieldStar.setFont(new Font(24.0));
        HBox.setMargin(textFieldStar, new Insets(0.0, 10.0, 0.0, 0.0));
        VBox.setMargin(hBox3, new Insets(0.0, 0.0, 0.0, 10.0));

        hBox4.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBox4.setPrefHeight(27.0);
        hBox4.setPrefWidth(510.0);
        hBox4.setSpacing(200.0);

        textCity.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textCity.setStrokeWidth(0.0);
        textCity.setText("City");
        textCity.setFont(new Font(24.0));

        textAddress.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textAddress.setStrokeWidth(0.0);
        textAddress.setText("Address");
        textAddress.setFont(new Font(24.0));
        hBox4.setPadding(new Insets(0.0, 0.0, 0.0, 30.0));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER);
        hBox5.setPrefHeight(61.0);
        hBox5.setPrefWidth(500.0);
        hBox5.setSpacing(30.0);

        textFieldCity.setAlignment(javafx.geometry.Pos.CENTER);
        textFieldCity.setPromptText("City Restaurant");
        textFieldCity.setStyle(style);
        textFieldCity.setFont(new Font(24.0));
        HBox.setMargin(textFieldCity, new Insets(0.0, 0.0, 0.0, 10.0));

        textFieldAddress.setAlignment(javafx.geometry.Pos.CENTER);
        textFieldAddress.setPromptText("Address Rest");
        textFieldAddress.setStyle(style);
        textFieldAddress.setFont(new Font(24.0));
        HBox.setMargin(textFieldAddress, new Insets(0.0, 10.0, 0.0, 0.0));
        VBox.setMargin(hBox5, new Insets(0.0, 0.0, 0.0, 10.0));

        hBox6.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBox6.setPrefHeight(51.0);
        hBox6.setPrefWidth(510.0);

        textType.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textType.setStrokeWidth(0.0);
        textType.setText("Type");
        textType.setFont(new Font(24.0));

        hBoxCheck.setPrefHeight(100.0);
        hBoxCheck.setPrefWidth(200.0);

        vBox1.setPrefHeight(180.0);
        vBox1.setPrefWidth(285.0);

        checkBoxPizza.setMnemonicParsing(false);
        checkBoxPizza.setText("Pizza");
        checkBoxPizza.setFont(new Font(18.0));

        checkBoxSushi.setMnemonicParsing(false);
        checkBoxSushi.setText("Sushi");
        checkBoxSushi.setFont(new Font(18.0));

        checkBoxHamburger.setMnemonicParsing(false);
        checkBoxHamburger.setText("Hamburger");
        checkBoxHamburger.setFont(new Font(18.0));

        checkBoxPasta.setMnemonicParsing(false);
        checkBoxPasta.setText("Pasta");
        checkBoxPasta.setFont(new Font(18.0));

        vBox2.setPrefHeight(396.0);
        vBox2.setPrefWidth(231.0);
        vBox2.setSpacing(2.0);

        checkBoxMeat.setMnemonicParsing(false);
        checkBoxMeat.setText("Meat");
        checkBoxMeat.setFont(new Font(18.0));

        checkBoxFish.setMnemonicParsing(false);
        checkBoxFish.setText("Fish");
        checkBoxFish.setFont(new Font(18.0));

        checkBoxVegan.setMnemonicParsing(false);
        checkBoxVegan.setText("Vegan");
        checkBoxVegan.setFont(new Font(18.0));

        checkBoxGourmet.setMnemonicParsing(false);
        checkBoxGourmet.setText("Gourmet");
        checkBoxGourmet.setFont(new Font(18.0));
        hBoxCheck.setPadding(new Insets(0.0, 0.0, 0.0, 25.0));

        vBoxDx.setPrefHeight(418.0);
        vBoxDx.setPrefWidth(510.0);
        vBoxDx.setSpacing(5.0);

        hBox8.setAlignment(javafx.geometry.Pos.CENTER);
        hBox8.setPrefHeight(50.0);
        hBox8.setPrefWidth(510.0);
        hBox8.setSpacing(40.0);

        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("Tables with 2 seats");
        text5.setWrappingWidth(272.57293701171875);
        text5.setFont(new Font(24.0));

        tfTables2Seats.setAlignment(javafx.geometry.Pos.CENTER);
        tfTables2Seats.setPrefHeight(45.0);
        tfTables2Seats.setPrefWidth(80.0);
        tfTables2Seats.setPromptText("Es. 3");
        tfTables2Seats.setStyle(style);
        tfTables2Seats.setFont(new Font(24.0));

        hBox9.setAlignment(javafx.geometry.Pos.CENTER);
        hBox9.setPrefHeight(50.0);
        hBox9.setPrefWidth(510.0);
        hBox9.setSpacing(40.0);

        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("Tables with 4 seats");
        text6.setWrappingWidth(272.57293701171875);
        text6.setFont(new Font(24.0));

        tfTables4Seats.setAlignment(javafx.geometry.Pos.CENTER);
        tfTables4Seats.setPrefHeight(45.0);
        tfTables4Seats.setPrefWidth(80.0);
        tfTables4Seats.setPromptText("Es. 5");
        tfTables4Seats.setStyle(style);
        tfTables4Seats.setFont(new Font(24.0));

        hBox10.setAlignment(javafx.geometry.Pos.CENTER);
        hBox10.setPrefHeight(50.0);
        hBox10.setPrefWidth(200.0);
        hBox10.setSpacing(40.0);

        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("Tables with 6 seats");
        text7.setWrappingWidth(272.57293701171875);
        text7.setFont(new Font(24.0));

        tfTables6Seats.setAlignment(javafx.geometry.Pos.CENTER);
        tfTables6Seats.setPrefHeight(45.0);
        tfTables6Seats.setPrefWidth(80.0);
        tfTables6Seats.setPromptText("Es. 2");
        tfTables6Seats.setStyle(style);
        tfTables6Seats.setFont(new Font(24.0));

        hBox11.setAlignment(javafx.geometry.Pos.CENTER);
        hBox11.setPrefHeight(50.0);
        hBox11.setPrefWidth(200.0);
        hBox11.setSpacing(3.0);

        text8.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text8.setStrokeWidth(0.0);
        text8.setText("Tables with 8 seats");
        text8.setWrappingWidth(313.90625);
        text8.setFont(new Font(24.0));

        tfTables8Seats.setAlignment(javafx.geometry.Pos.CENTER);
        tfTables8Seats.setPrefHeight(45.0);
        tfTables8Seats.setPrefWidth(80.0);
        tfTables8Seats.setPromptText("Es. 3");
        tfTables8Seats.setStyle(style);
        tfTables8Seats.setFont(new Font(24.0));

        separator.setOpacity(0.0);
        separator.setPrefHeight(32.0);
        separator.setPrefWidth(510.0);

        hBoxBudget.setAlignment(javafx.geometry.Pos.CENTER);
        hBoxBudget.setPrefHeight(118.0);
        hBoxBudget.setPrefWidth(510.0);
        hBoxBudget.setSpacing(80.0);

        vBox4.setAlignment(javafx.geometry.Pos.CENTER);
        vBox4.setPrefHeight(114.0);
        vBox4.setPrefWidth(192.0);

        text9.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text9.setStrokeWidth(0.0);
        text9.setText("Budget");
        text9.setFont(new Font(24.0));

        vBox5.setPrefHeight(122.0);
        vBox5.setPrefWidth(138.0);
        vBox5.setSpacing(2.0);

        check50To100.setMnemonicParsing(false);
        check50To100.setText("€ - €€");
        check50To100.setFont(new Font(18.0));

        check100To150.setMnemonicParsing(false);
        check100To150.setText("€€ - €€€");
        check100To150.setFont(new Font(18.0));

        check150To200.setMnemonicParsing(false);
        check150To200.setText("€€€ - €€€€");
        check150To200.setFont(new Font(18.0));

        checkBox200.setMnemonicParsing(false);
        checkBox200.setText("more €€€€");
        checkBox200.setFont(new Font(18.0));

        hBoxBtn.setAlignment(javafx.geometry.Pos.CENTER);
        hBoxBtn.setPrefHeight(63.0);
        hBoxBtn.setPrefWidth(841.0);
        hBoxBtn.setSpacing(30.0);

        btnUndo.setMnemonicParsing(false);
        btnUndo.setPrefHeight(51.0);
        btnUndo.setPrefWidth(119.0);
        btnUndo.setText("Undo");
        btnUndo.setFont(new Font(24.0));
        
        btnUndo.setOnMouseEntered(evt -> btnUndo.setUnderline(true));
        btnUndo.setOnMouseExited(evt -> btnUndo.setUnderline(false));

        btnRegister.setMnemonicParsing(false);
        btnRegister.setStyle("-fx-background-color: #1B59D7;");
        btnRegister.setText("Register");
        btnRegister.setTextFill(javafx.scene.paint.Color.WHITE);
        btnRegister.setFont(new Font(24.0));
        
        btnRegister.setOnMouseEntered(evt -> btnRegister.setUnderline(true));
        btnRegister.setOnMouseExited(evt -> btnRegister.setUnderline(false));

        
        setOpaqueInsets(new Insets(0.0));

       
        hBoxTitle.getChildren().add(textTitle);
        vBoxPrincipale.getChildren().add(hBoxTitle);
        hBox2.getChildren().add(textName);
        hBox2.getChildren().add(textStar);
        vBoxSx.getChildren().add(hBox2);
        hBox3.getChildren().add(textFieldName);
        hBox3.getChildren().add(textFieldStar);
        vBoxSx.getChildren().add(hBox3);
        hBox4.getChildren().add(textCity);
        hBox4.getChildren().add(textAddress);
        vBoxSx.getChildren().add(hBox4);
        hBox5.getChildren().add(textFieldCity);
        hBox5.getChildren().add(textFieldAddress);
        vBoxSx.getChildren().add(hBox5);
        hBox6.getChildren().add(textType);
        vBoxSx.getChildren().add(hBox6);
        vBox1.getChildren().add(checkBoxPizza);
        vBox1.getChildren().add(checkBoxSushi);
        vBox1.getChildren().add(checkBoxHamburger);
        vBox1.getChildren().add(checkBoxPasta);
        hBoxCheck.getChildren().add(vBox1);
        vBox2.getChildren().add(checkBoxMeat);
        vBox2.getChildren().add(checkBoxFish);
        vBox2.getChildren().add(checkBoxVegan);
        vBox2.getChildren().add(checkBoxGourmet);
        hBoxCheck.getChildren().add(vBox2);
        vBoxSx.getChildren().add(hBoxCheck);
        hBoxCorpoCentrale.getChildren().add(vBoxSx);
        hBox8.getChildren().add(text5);
        hBox8.getChildren().add(tfTables2Seats);
        vBoxDx.getChildren().add(hBox8);
        hBox9.getChildren().add(text6);
        hBox9.getChildren().add(tfTables4Seats);
        vBoxDx.getChildren().add(hBox9);
        hBox10.getChildren().add(text7);
        hBox10.getChildren().add(tfTables6Seats);
        vBoxDx.getChildren().add(hBox10);
        hBox11.getChildren().add(text8);
        hBox11.getChildren().add(tfTables8Seats);
        vBoxDx.getChildren().add(hBox11);
        vBoxDx.getChildren().add(separator);
        vBox4.getChildren().add(text9);
        hBoxBudget.getChildren().add(vBox4);
        vBox5.getChildren().add(check50To100);
        vBox5.getChildren().add(check100To150);
        vBox5.getChildren().add(check150To200);
        vBox5.getChildren().add(checkBox200);
        hBoxBudget.getChildren().add(vBox5);
        vBoxDx.getChildren().add(hBoxBudget);
        hBoxCorpoCentrale.getChildren().add(vBoxDx);
        vBoxPrincipale.getChildren().add(hBoxCorpoCentrale);
        hBoxBtn.getChildren().add(btnUndo);
        hBoxBtn.getChildren().add(btnRegister);
        vBoxPrincipale.getChildren().add(hBoxBtn);
        getChildren().add(vBoxPrincipale);
        

	
    }
}

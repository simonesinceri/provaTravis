package logic.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import logic.bean.RestaurantsBean;
import logic.controller.RestaurantsController;

public class RestaurantsScene extends VBox{

    protected HBox restHBox0;
    protected VBox restaurantsBox0;
    protected Label restLabel;
    protected TextField restText;
    protected Label restLabel0;
    protected TextField restText0;
    protected HBox restHBox1;
    protected Label restLabel1;
    protected TextField restText1;
    protected Line restLine;
    protected VBox restaurantsBox1;
    
    protected HBox hBox;
    protected VBox vBox;
    protected Label label;
    
    protected CheckBox €;
    protected CheckBox €€;
    protected CheckBox €€€;
    protected CheckBox €€€€;
    
    protected VBox vBox0;
    protected Label label0;
    
    protected CheckBox star1;
    protected CheckBox star2;
    protected CheckBox star3;
    protected CheckBox star4;
    protected CheckBox star5;
    
    protected Label restLabel4;
    protected HBox restHBox4;
    protected VBox restaurantsBox2;
    
    protected CheckBox pizzaCheck;
    protected CheckBox sushiCheck;
    protected CheckBox hamburgerCheck;
    protected CheckBox pastaCheck;
    
    protected VBox restaurantsBox3;
    
    protected CheckBox meatCheck;
    protected CheckBox fishCheck;
    protected CheckBox veganCheck;
    protected CheckBox gourmetCheck;
    
    protected Button restSearchButton;
    
    private boolean Ok = false, peopleOk = false;
    
    private String name;
    
    private String city;
    
    private int people;
    
    public RestaurantsScene(RestaurantsController controller, RestaurantsBean bean){
    	
    	restHBox0 = new HBox();
        restaurantsBox0 = new VBox();
        restLabel = new Label();
        restText = new TextField();
        restLabel0 = new Label();
        restText0 = new TextField();
        restHBox1 = new HBox();
        restLabel1 = new Label();
        restText1 = new TextField();
        restLine = new Line();
        restaurantsBox1 = new VBox();

        hBox = new HBox();
        vBox = new VBox();
        label = new Label();
        € = new CheckBox();
        €€ = new CheckBox();
        €€€ = new CheckBox();
        €€€€ = new CheckBox();
        vBox0 = new VBox();
        label0 = new Label();
        star1 = new CheckBox();
        star2 = new CheckBox();
        star3 = new CheckBox();
        star4 = new CheckBox();
        star5 = new CheckBox();
        
        restLabel4 = new Label();
        restHBox4 = new HBox();
        restaurantsBox2 = new VBox();
        pizzaCheck = new CheckBox();
        sushiCheck = new CheckBox();
        hamburgerCheck = new CheckBox();
        pastaCheck = new CheckBox();
        restaurantsBox3 = new VBox();
        meatCheck = new CheckBox();
        fishCheck = new CheckBox();
        veganCheck = new CheckBox();
        gourmetCheck = new CheckBox();
        restSearchButton = new Button();
        
        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);

        restHBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        restHBox0.setPrefHeight(100.0);
        restHBox0.setPrefWidth(200.0);
        restHBox0.setSpacing(65.0);

        restaurantsBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        restaurantsBox0.setMaxHeight(300.0);

        restLabel.setText("Which restaurant are you looking for?");
        restLabel.setFont(new Font(24.0));

        restText.setAlignment(javafx.geometry.Pos.CENTER);
        restText.setPromptText("Type restaurant name");
        restText.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
        restText.setFont(new Font(24.0));
        VBox.setMargin(restText, new Insets(15.0, 0.0, 0.0, 0.0));

        restLabel0.setText("Where do you wanna go?");
        restLabel0.setFont(new Font(24.0));
        VBox.setMargin(restLabel0, new Insets(35.0, 0.0, 0.0, 0.0));

        restText0.setAlignment(javafx.geometry.Pos.CENTER);
        restText0.setPromptText("Es.  Rome");
        restText0.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
        restText0.setFont(new Font(24.0));
        VBox.setMargin(restText0, new Insets(15.0, 0.0, 0.0, 0.0));

        restHBox1.setAlignment(javafx.geometry.Pos.CENTER);
        restHBox1.setPrefHeight(34.0);
        restHBox1.setPrefWidth(402.0);
        restHBox1.setSpacing(15.0);

        restLabel1.setText("How many people?");
        restLabel1.setFont(new Font(24.0));

        restText1.setAlignment(javafx.geometry.Pos.CENTER);
        restText1.setPrefHeight(45.0);
        restText1.setPrefWidth(80.0);
        restText1.setPromptText("Es. 4");
        restText1.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
        restText1.setFont(new Font(24.0));
        VBox.setMargin(restHBox1, new Insets(35.0, 0.0, 0.0, 0.0));
        HBox.setMargin(restaurantsBox0, new Insets(20.0, 0.0, 0.0, 0.0));

        restLine.setEndY(180.0);
        restLine.setStartY(-180.0);

        restaurantsBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        restaurantsBox1.setSpacing(27.45);

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(159.0);
        hBox.setPrefWidth(290.0);
        hBox.setSpacing(30.0);

        vBox.setPrefHeight(396.0);
        vBox.setSpacing(5.0);

        label.setText("Budget");
        label.setFont(new Font(24.0));
        VBox.setMargin(label, new Insets(0.0));

        €.setMnemonicParsing(false);
        €.setText("€ - €€");
        €.setFont(new Font(18.0));

        €€.setMnemonicParsing(false);
        €€.setText("€€ - €€€");
        €€.setFont(new Font(18.0));

        €€€.setMnemonicParsing(false);
        €€€.setText("€€€ - €€€€");
        €€€.setFont(new Font(18.0));

        €€€€.setMnemonicParsing(false);
        €€€€.setText("€€€€");
        €€€€.setFont(new Font(18.0));

        vBox0.setPrefHeight(396.0);
        vBox0.setSpacing(2.0);

        label0.setText("Rating");
        label0.setFont(new Font(24.0));

        star1.setMnemonicParsing(false);
        star1.setText("1 star");
        star1.setFont(new Font(18.0));

        star2.setMnemonicParsing(false);
        star2.setText("2 stars");
        star2.setFont(new Font(18.0));

        star3.setMnemonicParsing(false);
        star3.setText("3 stars");
        star3.setFont(new Font(18.0));

        star4.setMnemonicParsing(false);
        star4.setText("4 stars");
        star4.setFont(new Font(18.0));

        star5.setMnemonicParsing(false);
        star5.setText("5 stars");
        star5.setFont(new Font(18.0));

        restLabel4.setText("Check your preferences");
        restLabel4.setFont(new Font(24.0));

        restHBox4.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        restHBox4.setSpacing(30.0);

        restaurantsBox2.setSpacing(5.0);
        HBox.setMargin(restaurantsBox2, new Insets(0.0));

        pizzaCheck.setMnemonicParsing(false);
        pizzaCheck.setText("Pizza");
        pizzaCheck.setFont(new Font(18.0));

        sushiCheck.setMnemonicParsing(false);
        sushiCheck.setText("Sushi");
        sushiCheck.setFont(new Font(18.0));

        hamburgerCheck.setMnemonicParsing(false);
        hamburgerCheck.setText("Hamburger");
        hamburgerCheck.setFont(new Font(18.0));

        pastaCheck.setMnemonicParsing(false);
        pastaCheck.setText("Pasta");
        pastaCheck.setFont(new Font(18.0));

        restaurantsBox3.setSpacing(5.0);

        meatCheck.setMnemonicParsing(false);
        meatCheck.setText("Meat");
        meatCheck.setFont(new Font(18.0));

        fishCheck.setMnemonicParsing(false);
        fishCheck.setText("Fish");
        fishCheck.setFont(new Font(18.0));

        veganCheck.setMnemonicParsing(false);
        veganCheck.setText("Vegan");
        veganCheck.setFont(new Font(18.0));

        gourmetCheck.setMnemonicParsing(false);
        gourmetCheck.setText("Gourmet");
        gourmetCheck.setFont(new Font(18.0));
        VBox.setMargin(restHBox4, new Insets(-20.0, 0.0, 0.0, 0.0));
        HBox.setMargin(restaurantsBox1, new Insets(20.0, 54.0, 0.0, 54.0));

        restSearchButton.setMnemonicParsing(false);
        restSearchButton.setStyle("-fx-background-color: #1B59D7;");
        restSearchButton.setText("Search");
        restSearchButton.setTextFill(javafx.scene.paint.Color.WHITE);
        restSearchButton.setFont(new Font(24.0));
        setPadding(new Insets(50.0, 0.0, 0.0, 0.0));

        restaurantsBox0.getChildren().add(restLabel);
        restaurantsBox0.getChildren().add(restText);
        restaurantsBox0.getChildren().add(restLabel0);
        restaurantsBox0.getChildren().add(restText0);
        restHBox1.getChildren().add(restLabel1);
        restHBox1.getChildren().add(restText1);
        restaurantsBox0.getChildren().add(restHBox1);
        restHBox0.getChildren().add(restaurantsBox0);
        restHBox0.getChildren().add(restLine);
        vBox.getChildren().add(label);
        vBox.getChildren().add(€);
        vBox.getChildren().add(€€);
        vBox.getChildren().add(€€€);
        vBox.getChildren().add(€€€€);
        hBox.getChildren().add(vBox);
        vBox0.getChildren().add(label0);
        vBox0.getChildren().add(star1);
        vBox0.getChildren().add(star2);
        vBox0.getChildren().add(star3);
        vBox0.getChildren().add(star4);
        vBox0.getChildren().add(star5);
        hBox.getChildren().add(vBox0);
        restaurantsBox1.getChildren().add(hBox);
        restaurantsBox1.getChildren().add(restLabel4);
        restaurantsBox2.getChildren().add(pizzaCheck);
        restaurantsBox2.getChildren().add(sushiCheck);
        restaurantsBox2.getChildren().add(hamburgerCheck);
        restaurantsBox2.getChildren().add(pastaCheck);
        restHBox4.getChildren().add(restaurantsBox2);
        restaurantsBox3.getChildren().add(meatCheck);
        restaurantsBox3.getChildren().add(fishCheck);
        restaurantsBox3.getChildren().add(veganCheck);
        restaurantsBox3.getChildren().add(gourmetCheck);
        restHBox4.getChildren().add(restaurantsBox3);
        restaurantsBox1.getChildren().add(restHBox4);
        restHBox0.getChildren().add(restaurantsBox1);
        getChildren().add(restHBox0);
        getChildren().add(restSearchButton);
        
        restSearchButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				name = restText.getText();
				city = restText0.getText();
				
				if (name.equals("") && city.equals("")) {
					Ok = false;
				}
		        
				if (!name.equals("")) {
					restLabel.setStyle("-fx-text-fill: black");
		        	bean.setCity(city);
		        	Ok = true;
		        } else if (Ok != true){
		        	restLabel.setStyle("-fx-text-fill: red");
		        } else {
		        	restLabel.setStyle("-fx-text-fill: black");
		        }
					        
				if (!city.equals("")) {
					restLabel0.setStyle("-fx-text-fill: black");
		        	restLabel.setStyle("-fx-text-fill: black");
		        	bean.setCity(city);
		        	Ok = true;
		        } else if (Ok != true){
		        	restLabel0.setStyle("-fx-text-fill: red");
		        } else {
		        	restLabel0.setStyle("-fx-text-fill: black");
		        }
				
				if (!restText1.getText().equals("")) {
					try {
						people = Integer.valueOf(restText1.getText());
					} catch (NumberFormatException e) {
						restLabel1.setStyle("-fx-text-fill: red");
					}
					if (people > 0) {
						restLabel1.setStyle("-fx-text-fill: black");
			        	bean.setNumPeople(people);
			        	peopleOk = true;
					} else {
						restLabel1.setStyle("-fx-text-fill: red");
			        }
		        } else {
		        	restLabel1.setStyle("-fx-text-fill: red");
		        }
				
				if (Ok == true&& peopleOk == true) {
					
					if (€.isSelected()) {
						bean.setBudget1(true);
					}
					if (€€.isSelected()) {
						bean.setBudget2(true);
					}
					if (€€€.isSelected()) {
						bean.setBudget3(true);
					}
					if (€€€€.isSelected()) {
						bean.setBudget4(true);
					}
					
					if (star1.isSelected()) {
						bean.setStar1(true);
					}
					if (star2.isSelected()) {
						bean.setStar2(true);
					}
					if (star3.isSelected()) {
						bean.setStar3(true);
					}
					if (star4.isSelected()) {
						bean.setStar4(true);
					}
					if (star5.isSelected()) {
						bean.setStar5(true);
					}
					
					if (pizzaCheck.isSelected()) {
						bean.setPizza(true);
					}
					if (sushiCheck.isSelected()) {
						bean.setSushi(true);
					}
					if (hamburgerCheck.isSelected()) {
						bean.setHamburger(true);
					}
					if (pastaCheck.isSelected()) {
						bean.setPasta(true);
					}
					if (meatCheck.isSelected()) {
						bean.setMeat(true);
					}
					if (fishCheck.isSelected()) {
						bean.setFish(true);
					}
					if (veganCheck.isSelected()) {
						bean.setVegan(true);
					}
					if (gourmetCheck.isSelected()) {
						bean.setGourmet(true);
					}
					
					controller.changeScene2();
				}
			}
		});
    }
}

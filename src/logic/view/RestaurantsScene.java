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
    
    protected CheckBox cB50To100;
    protected CheckBox cB100To150;
    protected CheckBox cB150To200;
    protected CheckBox cB200;
    
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
    
    private boolean okField = false;
    private boolean  peopleOk = false;
    
    private int people;
   
    String black = "-fx-text-fill: black";
    String red = "-fx-text-fill: red";
    
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
        cB50To100 = new CheckBox();
        cB100To150 = new CheckBox();
        cB150To200 = new CheckBox();
        cB200 = new CheckBox();
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
        
        String style = "-fx-background-color: #e2e8ff; -fx-background-radius: 20;";
       
 
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
        restText.setStyle(style);
        restText.setFont(new Font(24.0));
        VBox.setMargin(restText, new Insets(15.0, 0.0, 0.0, 0.0));

        restLabel0.setText("Where do you wanna go?");
        restLabel0.setFont(new Font(24.0));
        VBox.setMargin(restLabel0, new Insets(35.0, 0.0, 0.0, 0.0));

        restText0.setAlignment(javafx.geometry.Pos.CENTER);
        restText0.setPromptText("Es.  Rome");
        restText0.setStyle(style);
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
        restText1.setStyle(style);
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

        cB50To100.setMnemonicParsing(false);
        cB50To100.setText("€ - €€");
        cB50To100.setFont(new Font(18.0));

        cB100To150.setMnemonicParsing(false);
        cB100To150.setText("€€ - €€€");
        cB100To150.setFont(new Font(18.0));

        cB150To200.setMnemonicParsing(false);
        cB150To200.setText("€€€ - €€€€");
        cB150To200.setFont(new Font(18.0));

        cB200.setMnemonicParsing(false);
        cB200.setText("€€€€");
        cB200.setFont(new Font(18.0));

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

        restSearchButton.setOnMouseEntered(evt -> restSearchButton.setUnderline(true));
        restSearchButton.setOnMouseExited(evt -> restSearchButton.setUnderline(false));

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
        vBox.getChildren().add(cB50To100);
        vBox.getChildren().add(cB100To150);
        vBox.getChildren().add(cB150To200);
        vBox.getChildren().add(cB200);
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
        	@Override
        	public void handle(ActionEvent event) {
				
				
        		getInfo(bean);
				
				if (!restText1.getText().equals("")) {
					try {
						people = Integer.valueOf(restText1.getText());
					} catch (NumberFormatException e) {
						restLabel1.setStyle(red);
					}
					if (people > 0) {
						restLabel1.setStyle(black);
			        	bean.setNumPeople(people);
			        	peopleOk = true;
					} else {
						restLabel1.setStyle(red);
			        }
		        } else {
		        	restLabel1.setStyle(red);
		        }
				
				if (okField && peopleOk) {
								
					bean.setBudget1(cB50To100.isSelected());
					bean.setBudget2(cB100To150.isSelected());		
					bean.setBudget3(cB150To200.isSelected());
					bean.setBudget4(cB200.isSelected());		
					
					bean.setStar1(star1.isSelected());	
					bean.setStar2(star2.isSelected());		
					bean.setStar3(star3.isSelected());
					bean.setStar4(star4.isSelected());		
					bean.setStar5(star5.isSelected());
	
					bean.setPizza(pizzaCheck.isSelected());		
					bean.setSushi(sushiCheck.isSelected());
					bean.setHamburger(hamburgerCheck.isSelected());
					bean.setPasta(pastaCheck.isSelected());
					bean.setMeat(meatCheck.isSelected());			
					bean.setFish(fishCheck.isSelected());	
					bean.setVegan(veganCheck.isSelected());
					bean.setGourmet(gourmetCheck.isSelected());
					
					}
					
					controller.changeScene2();
				
			}
		});
    }
    
    private void getInfo(RestaurantsBean bean) {
    	
    	String name = restText.getText();
    	String city = restText0.getText();
		
		if (name.equals("") && city.equals("")) {
			okField = false;
		}
        
		if (!name.equals("")) {
			restLabel.setStyle(black);
        	bean.setCity(city);
        	okField = true;
        } else if (!okField){
        	restLabel.setStyle(red);
        } else {
        	restLabel.setStyle(black);
        }
			        
		if (!city.equals("")) {
			restLabel0.setStyle(black);
        	restLabel.setStyle(black);
        	bean.setCity(city);
        	okField = true;
        } else if (!okField){
        	restLabel0.setStyle(red);
        } else {
        	restLabel0.setStyle(black);
        }
    }
}

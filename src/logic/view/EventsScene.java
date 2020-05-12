package logic.view;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import logic.bean.EventBean;
import logic.controller.EventsController;

public class EventsScene extends VBox{
	
	protected HBox eventsHBox;
	protected VBox eventsVBox0;
	protected Label eventsLabel;
	protected TextField eventsText;
	protected Label eventsLabel0;
	protected TextField eventsText0;
	protected HBox eventsHBox0;
	protected Label eventsLabel1;
	protected TextField eventsText1;
	protected Line eventsLine;
	protected VBox eventsVBox1;
	protected Label eventsLabel2;
	protected HBox eventsHBox1;
	protected DatePicker eventsDatePicker;
	protected TextField eventsText2;
	protected Label eventsLabel3;
	protected HBox eventsHBox2;
	protected VBox eventsVBox2;
	protected CheckBox concertCheck;
	protected CheckBox theatreCheck;
	protected VBox eventsVBox3;
	protected CheckBox cinemaCheck;
	protected CheckBox museumCheck;
	protected Button eventsSearchButton;
    
    private boolean Ok = false, peopleOk = false, timeOk = true;
    
    private String name;
    
    private String city;
    
    private int people;
    
    private int year, month, day;
    
    private int hour = 25;
    
	public EventsScene(EventsController controller, EventBean bean){
	
		eventsHBox = new HBox();
		eventsVBox0 = new VBox();
		eventsLabel = new Label();
		eventsText = new TextField();
		eventsLabel0 = new Label();
		eventsText0 = new TextField();
		eventsHBox0 = new HBox();
		eventsLabel1 = new Label();
		eventsText1 = new TextField();
		eventsLine = new Line();
		eventsVBox1 = new VBox();
		eventsLabel2 = new Label();
		eventsHBox1 = new HBox();
		eventsDatePicker = new DatePicker();
		eventsText2 = new TextField();
		eventsLabel3 = new Label();
		eventsHBox2 = new HBox();
		eventsVBox2 = new VBox();
		concertCheck = new CheckBox();
		theatreCheck = new CheckBox();
		eventsVBox3 = new VBox();
		cinemaCheck = new CheckBox();
		museumCheck = new CheckBox();
		eventsSearchButton = new Button();
		
		setAlignment(javafx.geometry.Pos.TOP_CENTER);
		setPrefHeight(525.0);
		setPrefWidth(1050.0);
		setSpacing(30.0);

		eventsHBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
		eventsHBox.setPrefHeight(100.0);
		eventsHBox.setPrefWidth(200.0);
		eventsHBox.setSpacing(65.0);

		eventsVBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
		eventsVBox0.setMaxHeight(300.0);

		eventsLabel.setText("Which event are you looking for?");
		eventsLabel.setFont(new Font(24.0));

		eventsText.setAlignment(javafx.geometry.Pos.CENTER);
		eventsText.setPromptText("Es. Muse or Joker or Festival name");
		eventsText.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
		eventsText.setFont(new Font(24.0));
		VBox.setMargin(eventsText, new Insets(15.0, 0.0, 0.0, 0.0));

		eventsLabel0.setText("Where is located the event?");
		eventsLabel0.setFont(new Font(24.0));
		VBox.setMargin(eventsLabel0, new Insets(35.0, 0.0, 0.0, 0.0));

		eventsText0.setAlignment(javafx.geometry.Pos.CENTER);
		eventsText0.setPromptText("Es.  Rome");
		eventsText0.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
		eventsText0.setFont(new Font(24.0));
		VBox.setMargin(eventsText0, new Insets(15.0, 0.0, 0.0, 0.0));

		eventsHBox0.setAlignment(javafx.geometry.Pos.CENTER);
		eventsHBox0.setPrefHeight(34.0);
		eventsHBox0.setPrefWidth(402.0);
		eventsHBox0.setSpacing(15.0);

		eventsLabel1.setText("How many people?");
		eventsLabel1.setFont(new Font(24.0));

		eventsText1.setAlignment(javafx.geometry.Pos.CENTER);
		eventsText1.setPrefHeight(45.0);
		eventsText1.setPrefWidth(80.0);
		eventsText1.setPromptText("Es. 4");
		eventsText1.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
		eventsText1.setFont(new Font(24.0));
		VBox.setMargin(eventsHBox0, new Insets(35.0, 0.0, 0.0, 0.0));
		HBox.setMargin(eventsVBox0, new Insets(20.0, 0.0, 0.0, 0.0));

		eventsLine.setEndY(180.0);
		eventsLine.setStartY(-180.0);

		eventsVBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
		eventsVBox1.setMinWidth(294.5);
		eventsVBox1.setSpacing(35.0);

		eventsLabel2.setText("When?");
		eventsLabel2.setFont(new Font(24.0));
		VBox.setMargin(eventsLabel2, new Insets(30.0, 0.0, 0.0, 0.0));

		eventsHBox1.setAlignment(javafx.geometry.Pos.CENTER);
		eventsHBox1.setPrefWidth(294.5);
		eventsHBox1.setSpacing(15.0);

		eventsDatePicker.setPrefHeight(45.0);
		
		eventsDatePicker.setDayCellFactory(picker -> new DateCell() {
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				LocalDate today = LocalDate.now();
				
				setDisable(empty || date.compareTo(today) < 0);
			}
		});

		eventsText2.setAlignment(javafx.geometry.Pos.CENTER);
		eventsText2.setPrefHeight(45.0);
		eventsText2.setPrefWidth(95.0);
		eventsText2.setPromptText("0-24");
		eventsText2.setStyle("-fx-background-color: #e2e8ff; -fx-background-radius: 20;");
		eventsText2.setFont(new Font(24.0));
		VBox.setMargin(eventsHBox1, new Insets(-20.0, 0.0, 0.0, 0.0));

		eventsLabel3.setText("Check your preferences:");
		eventsLabel3.setFont(new Font(24.0));
		VBox.setMargin(eventsLabel3, new Insets(20.0, 0.0, 0.0, 0.0));

		eventsHBox2.setAlignment(javafx.geometry.Pos.TOP_CENTER);
		eventsHBox2.setSpacing(30.0);

		eventsVBox2.setSpacing(5.0);
		HBox.setMargin(eventsVBox2, new Insets(0.0));

		concertCheck.setMnemonicParsing(false);
		concertCheck.setText("Concert");
		concertCheck.setFont(new Font(18.0));

		theatreCheck.setMnemonicParsing(false);
		theatreCheck.setText("Theatre");
		theatreCheck.setFont(new Font(18.0));

		eventsVBox3.setSpacing(5.0);

		cinemaCheck.setMnemonicParsing(false);
		cinemaCheck.setText("Cinema");
		cinemaCheck.setFont(new Font(18.0));

		museumCheck.setMnemonicParsing(false);
		museumCheck.setText("Museum");
		museumCheck.setFont(new Font(18.0));
		VBox.setMargin(eventsHBox2, new Insets(-20.0, 0.0, 0.0, 0.0));
		HBox.setMargin(eventsVBox1, new Insets(20.0, 54.0, 0.0, 54.0));

		eventsSearchButton.setMnemonicParsing(false);
		eventsSearchButton.setStyle("-fx-background-color: #1B59D7;");
		eventsSearchButton.setText("Search");
		eventsSearchButton.setTextFill(javafx.scene.paint.Color.WHITE);
		eventsSearchButton.setFont(new Font(24.0));
		setPadding(new Insets(50.0, 0.0, 0.0, 0.0));

		eventsVBox0.getChildren().add(eventsLabel);
		eventsVBox0.getChildren().add(eventsText);
		eventsVBox0.getChildren().add(eventsLabel0);
		eventsVBox0.getChildren().add(eventsText0);
		eventsHBox0.getChildren().add(eventsLabel1);
		eventsHBox0.getChildren().add(eventsText1);
		eventsVBox0.getChildren().add(eventsHBox0);
		eventsHBox.getChildren().add(eventsVBox0);
		eventsHBox.getChildren().add(eventsLine);
		eventsVBox1.getChildren().add(eventsLabel2);
		eventsHBox1.getChildren().add(eventsDatePicker);
		eventsHBox1.getChildren().add(eventsText2);
		eventsVBox1.getChildren().add(eventsHBox1);
		eventsVBox1.getChildren().add(eventsLabel3);
		eventsVBox2.getChildren().add(concertCheck);
		eventsVBox2.getChildren().add(theatreCheck);
		eventsHBox2.getChildren().add(eventsVBox2);
		eventsVBox3.getChildren().add(cinemaCheck);
		eventsVBox3.getChildren().add(museumCheck);
		eventsHBox2.getChildren().add(eventsVBox3);
		eventsVBox1.getChildren().add(eventsHBox2);
		eventsHBox.getChildren().add(eventsVBox1);
		getChildren().add(eventsHBox);
		getChildren().add(eventsSearchButton);
		
		eventsSearchButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				name = eventsText.getText();
				city = eventsText0.getText();
				
				if (name.equals("") && city.equals("")) {
					Ok = false;
				}
		        
				if (!name.equals("")) {
					eventsLabel.setStyle("-fx-text-fill: black");
		        	bean.setCity(name);
		        	Ok = true;
		        } else if (Ok != true){
		        	eventsLabel.setStyle("-fx-text-fill: red");
		        } else {
					eventsLabel.setStyle("-fx-text-fill: black");
		        }
		        
				if (!city.equals("")) {
					eventsLabel0.setStyle("-fx-text-fill: black");
					eventsLabel.setStyle("-fx-text-fill: black");
		        	bean.setCity(city);
		        	Ok = true;
		        } else if (Ok != true){
		        	eventsLabel0.setStyle("-fx-text-fill: red");
		        } else {
					eventsLabel0.setStyle("-fx-text-fill: black");
		        }
				
				if (!eventsText1.getText().equals("")) {
					try {
						people = Integer.valueOf(eventsText1.getText());
						
						if (people > 0) {
							eventsLabel1.setStyle("-fx-text-fill: black");
				        	bean.setPeople(people);
				        	peopleOk = true;
						} else {
							eventsLabel1.setStyle("-fx-text-fill: red");
				        }						
					} catch (NumberFormatException e) {
						eventsLabel1.setStyle("-fx-text-fill: red");
					}					
		        } else {
		        	eventsLabel1.setStyle("-fx-text-fill: red");
		        }
				
				if (Ok == true && peopleOk == true) {
					
					if (!eventsText2.getText().equals("")) {
						try {
							hour = Integer.valueOf(eventsText2.getText());
							if (hour > 0 && hour < 24) {
								eventsLabel2.setStyle("-fx-text-fill: black");
								eventsLabel2.setText("When?");
					        	bean.setHour(hour);
					        	timeOk = true;
							} else {
								eventsLabel2.setStyle("-fx-text-fill: red");
								eventsLabel2.setText("Type only Hours!");
					        	timeOk = false;
					        }							
						} catch (NumberFormatException e) {
							eventsLabel2.setText("Type only Hours!");
							eventsLabel2.setStyle("-fx-text-fill: red");
				        	timeOk = false;
						}
			        }
					
					if (timeOk == true) {
						
						if (cinemaCheck.isSelected()) {
							bean.setCinema(true);
						}
						if (theatreCheck.isSelected()) {
							bean.setTheatre(true);
						}
						if (museumCheck.isSelected()) {
							bean.setMuseum(true);
						}
						if (concertCheck.isSelected()) {
							bean.setConcert(true);
						}
						
						controller.changeScene2();
					}
					
				}
			}
		});
		
		eventsDatePicker.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				LocalDate ld = eventsDatePicker.getValue();
				
				year = ld.getYear();
				month = ld.getMonth().getValue();
				day = ld.getDayOfMonth();
				
				bean.setYear(year);
				bean.setMonth(month);
				bean.setDay(day);
			}
		});
	}
}

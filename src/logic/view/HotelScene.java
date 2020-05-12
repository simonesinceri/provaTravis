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
import logic.bean.HotelBean;
import logic.controller.HotelController;

public class HotelScene extends VBox{
	
    protected HBox hotelHBox;
    protected VBox hotelVBox0;
    protected Label hotelLabel;
    protected TextField hotelTextField;
    protected HBox hotelHBox0;
    protected Label hotelLabel0;
    protected Label hotelLabel1;
    protected HBox hotelHBox1;
    protected DatePicker hotelCheckIn;
    protected DatePicker hotelCheckOut;
    protected HBox hotelHBox2;
    protected Label hotelLabel2;
    protected TextField hotelTextField0;
    protected Line line;
    protected VBox hotelVBox1;
    protected HBox hotelHBox3;
    protected VBox hotelVBox2;
    protected Label hotelLabel3;
    protected CheckBox check50_100;
    protected CheckBox check100_150;
    protected CheckBox check150_200;
    protected CheckBox check200;
    protected VBox hotelVBox3;
    protected Label hotelLabel4;
    protected CheckBox checkApartaments;
    protected CheckBox checkHotels;
    protected CheckBox checkBeB;
    protected CheckBox checkHostels;
    protected HBox hotelHBox4;
    protected VBox hotelVBox4;
    protected Label hotelLabel5;
    protected CheckBox checkParking;
    protected CheckBox checkRestaurant;
    protected CheckBox checkRoomService;
    protected CheckBox checkFitnessCenter;
    protected VBox hotelVBox5;
    protected Label hotelLabel6;
    protected CheckBox check1Star;
    protected CheckBox check2Star;
    protected CheckBox check3Star;
    protected CheckBox check4Star;
    protected CheckBox check5Star;
    protected Button hotelSearchButton;
    
    private boolean cityOk = false, dateOk = false, peopleOk = false;
    
    private String city;
    
    private int people;
    
    private int yearOut, yearIn, monthOut, monthIn, dayOut, dayIn;
	
    public HotelScene(HotelController controller, HotelBean bean) {
    
    	hotelHBox = new HBox();
        hotelVBox0 = new VBox();
        hotelLabel = new Label();
        hotelTextField = new TextField();
        hotelHBox0 = new HBox();
        hotelLabel0 = new Label();
        hotelLabel1 = new Label();
        hotelHBox1 = new HBox();
        hotelCheckIn = new DatePicker();
        hotelCheckOut = new DatePicker();
        hotelHBox2 = new HBox();
        hotelLabel2 = new Label();
        hotelTextField0 = new TextField();
        line = new Line();
        hotelVBox1 = new VBox();
        hotelHBox3 = new HBox();
        hotelVBox2 = new VBox();
        hotelLabel3 = new Label();
        check50_100 = new CheckBox();
        check100_150 = new CheckBox();
        check150_200 = new CheckBox();
        check200 = new CheckBox();
        hotelVBox3 = new VBox();
        hotelLabel4 = new Label();
        checkApartaments = new CheckBox();
        checkHotels = new CheckBox();
        checkBeB = new CheckBox();
        checkHostels = new CheckBox();
        hotelHBox4 = new HBox();
        hotelVBox4 = new VBox();
        hotelLabel5 = new Label();
        checkParking = new CheckBox();
        checkRestaurant = new CheckBox();
        checkRoomService = new CheckBox();
        checkFitnessCenter = new CheckBox();
        hotelVBox5 = new VBox();
        hotelLabel6 = new Label();
        check1Star = new CheckBox();
        check2Star = new CheckBox();
        check3Star = new CheckBox();
        check4Star = new CheckBox();
        check5Star = new CheckBox();
        hotelSearchButton = new Button();
        
        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);

        hotelHBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hotelHBox.setMaxHeight(361.0);
        hotelHBox.setPrefHeight(100.0);
        hotelHBox.setPrefWidth(200.0);
        hotelHBox.setSpacing(65.0);

        hotelVBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hotelVBox0.setMaxHeight(300.0);
        HBox.setMargin(hotelVBox0, new Insets(20.0, 0.0, 0.0, 0.0));

        hotelLabel.setText("Where would you like to go?");
        hotelLabel.setFont(new Font(24.0));

        hotelTextField.setAlignment(javafx.geometry.Pos.CENTER);
        hotelTextField.setPrefWidth(402.0);
        hotelTextField.setPromptText("Es.  Rome");
        hotelTextField.setStyle("-fx-background-color: #e2e8ff#e2e8ff; -fx-background-radius: 20;");
        hotelTextField.setFont(new Font(24.0));
        VBox.setMargin(hotelTextField, new Insets(15.0, 0.0, 0.0, 0.0));
        
        hotelHBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hotelHBox0.setPrefHeight(35.0);
        hotelHBox0.setPrefWidth(402.0);
        hotelHBox0.setSpacing(105.0);

        hotelLabel0.setText("Check-in");
        hotelLabel0.setFont(new Font(24.0));

        hotelLabel1.setText("Check-out");
        hotelLabel1.setFont(new Font(24.0));
        VBox.setMargin(hotelHBox0, new Insets(35.0, 0.0, 0.0, 0.0));

        hotelHBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hotelHBox1.setMinHeight(45.0);
        hotelHBox1.setPrefHeight(45.0);
        hotelHBox1.setSpacing(30.0);

        hotelCheckIn.setCache(true);
        hotelCheckIn.setEditable(false);
        hotelCheckIn.setPrefHeight(51.0);
        hotelCheckIn.setPrefWidth(176.0);
		
		hotelCheckIn.setDayCellFactory(picker -> new DateCell() {
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				LocalDate today = LocalDate.now();
				
				setDisable(empty || date.compareTo(today) < 0);
			}
		});

        hotelCheckOut.setEditable(false);
        hotelCheckOut.setPrefHeight(51.0);
        hotelCheckOut.setPrefWidth(176.0);
        VBox.setMargin(hotelHBox1, new Insets(15.0, 0.0, 0.0, 0.0));
        hotelCheckOut.setDisable(true);

        hotelHBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hotelHBox2.setPrefHeight(34.0);
        hotelHBox2.setPrefWidth(402.0);
        hotelHBox2.setSpacing(15.0);

        hotelLabel2.setText("How many people?");
        hotelLabel2.setFont(new Font(24.0));
        HBox.setMargin(hotelLabel2, new Insets(0.0));

        hotelTextField0.setAlignment(javafx.geometry.Pos.CENTER);
        hotelTextField0.setPrefHeight(45.0);
        hotelTextField0.setPrefWidth(80.0);
        hotelTextField0.setPromptText("Es. 4");
        hotelTextField0.setStyle("-fx-background-color: #e2e8ff#e2e8ff; -fx-background-radius: 20;");
        hotelTextField0.setFont(new Font(24.0));
        hotelHBox2.setPadding(new Insets(35.0, 0.0, 0.0, 0.0));
        
        line.setEndY(180.0);
        line.setStartY(-180.0);

        hotelVBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hotelVBox1.setPrefHeight(341.0);
        hotelVBox1.setPrefWidth(400.0);
        hotelVBox1.setSpacing(30.0);
        HBox.setMargin(hotelVBox1, new Insets(20.0, 0.0, 0.0, 0.0));

        hotelHBox3.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hotelHBox3.setPrefHeight(100.0);
        hotelHBox3.setPrefWidth(200.0);
        hotelHBox3.setSpacing(30.0);

        hotelVBox2.setPrefHeight(396.0);
        hotelVBox2.setSpacing(5.0);

        hotelLabel3.setText("Budget");
        hotelLabel3.setFont(new Font(24.0));
        VBox.setMargin(hotelLabel3, new Insets(0.0));

        check50_100.setMnemonicParsing(false);
        check50_100.setText("€50 - €100 for night");
        check50_100.setFont(new Font(18.0));

        check100_150.setMnemonicParsing(false);
        check100_150.setText("€100 - €150 for night");
        check100_150.setFont(new Font(18.0));

        check150_200.setMnemonicParsing(false);
        check150_200.setText("€150 - €200 for night");
        check150_200.setFont(new Font(18.0));

        check200.setMnemonicParsing(false);
        check200.setText("€200 + for night");
        check200.setFont(new Font(18.0));

        hotelVBox3.setPrefHeight(133.0);
        hotelVBox3.setSpacing(5.0);

        hotelLabel4.setPrefHeight(38.0);
        hotelLabel4.setPrefWidth(144.0);
        hotelLabel4.setText("Property type");
        hotelLabel4.setFont(new Font(24.0));
        VBox.setMargin(hotelLabel4, new Insets(0.0));

        checkApartaments.setMnemonicParsing(false);
        checkApartaments.setText("Apartamnets");
        checkApartaments.setFont(new Font(18.0));

        checkHotels.setMnemonicParsing(false);
        checkHotels.setText("Hotels");
        checkHotels.setFont(new Font(18.0));

        checkBeB.setMnemonicParsing(false);
        checkBeB.setText("B&B");
        checkBeB.setFont(new Font(18.0));

        checkHostels.setMnemonicParsing(false);
        checkHostels.setText("Hostels");
        checkHostels.setFont(new Font(18.0));

        hotelHBox4.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hotelHBox4.setPrefHeight(100.0);
        hotelHBox4.setPrefWidth(200.0);
        hotelHBox4.setSpacing(95.0);

        hotelVBox4.setPrefHeight(396.0);
        hotelVBox4.setSpacing(5.0);

        hotelLabel5.setText("Facilities");
        hotelLabel5.setFont(new Font(24.0));

        checkParking.setMnemonicParsing(false);
        checkParking.setText("Parking");
        checkParking.setFont(new Font(18.0));

        checkRestaurant.setMnemonicParsing(false);
        checkRestaurant.setText("Restaurant");
        checkRestaurant.setFont(new Font(18.0));

        checkRoomService.setMnemonicParsing(false);
        checkRoomService.setText("Room service");
        checkRoomService.setFont(new Font(18.0));

        checkFitnessCenter.setMnemonicParsing(false);
        checkFitnessCenter.setText("Fitness centre");
        checkFitnessCenter.setFont(new Font(18.0));
        HBox.setMargin(hotelVBox4, new Insets(0.0, 0.0, 0.0, -95.0));

        hotelVBox5.setPrefHeight(396.0);
        hotelVBox5.setSpacing(2.0);

        hotelLabel6.setText("Rating");
        hotelLabel6.setFont(new Font(24.0));

        check1Star.setMnemonicParsing(false);
        check1Star.setText("1 star");
        check1Star.setFont(new Font(18.0));

        check2Star.setMnemonicParsing(false);
        check2Star.setText("2 star");
        check2Star.setFont(new Font(18.0));

        check3Star.setMnemonicParsing(false);
        check3Star.setText("3 star");
        check3Star.setFont(new Font(18.0));

        check4Star.setMnemonicParsing(false);
        check4Star.setText("4 star");
        check4Star.setFont(new Font(18.0));

        check5Star.setMnemonicParsing(false);
        check5Star.setText("5 star");
        check5Star.setFont(new Font(18.0));
        HBox.setMargin(hotelVBox5, new Insets(0.0, -25.0, 0.0, 0.0));

        hotelSearchButton.setMnemonicParsing(false);
        hotelSearchButton.setStyle("-fx-background-color: #1B59D7 #1B59D7;");
        hotelSearchButton.setText("Search");
        hotelSearchButton.setTextFill(javafx.scene.paint.Color.WHITE);
        hotelSearchButton.setFont(new Font(24.0));
        setPadding(new Insets(50.0, 0.0, 0.0, 0.0));

        hotelVBox0.getChildren().add(hotelLabel);
        hotelVBox0.getChildren().add(hotelTextField);
        hotelHBox0.getChildren().add(hotelLabel0);
        hotelHBox0.getChildren().add(hotelLabel1);
        hotelVBox0.getChildren().add(hotelHBox0);
        hotelHBox1.getChildren().add(hotelCheckIn);
        hotelHBox1.getChildren().add(hotelCheckOut);
        hotelVBox0.getChildren().add(hotelHBox1);
        hotelHBox2.getChildren().add(hotelLabel2);
        hotelHBox2.getChildren().add(hotelTextField0);
        hotelVBox0.getChildren().add(hotelHBox2);
        hotelHBox.getChildren().add(hotelVBox0);
        hotelHBox.getChildren().add(line);
        hotelVBox2.getChildren().add(hotelLabel3);
        hotelVBox2.getChildren().add(check50_100);
        hotelVBox2.getChildren().add(check100_150);
        hotelVBox2.getChildren().add(check150_200);
        hotelVBox2.getChildren().add(check200);
        hotelHBox3.getChildren().add(hotelVBox2);
        hotelVBox3.getChildren().add(hotelLabel4);
        hotelVBox3.getChildren().add(checkApartaments);
        hotelVBox3.getChildren().add(checkHotels);
        hotelVBox3.getChildren().add(checkBeB);
        hotelVBox3.getChildren().add(checkHostels);
        hotelHBox3.getChildren().add(hotelVBox3);
        hotelVBox1.getChildren().add(hotelHBox3);
        hotelVBox4.getChildren().add(hotelLabel5);
        hotelVBox4.getChildren().add(checkParking);
        hotelVBox4.getChildren().add(checkRestaurant);
        hotelVBox4.getChildren().add(checkRoomService);
        hotelVBox4.getChildren().add(checkFitnessCenter);
        hotelHBox4.getChildren().add(hotelVBox4);
        hotelVBox5.getChildren().add(hotelLabel6);
        hotelVBox5.getChildren().add(check1Star);
        hotelVBox5.getChildren().add(check2Star);
        hotelVBox5.getChildren().add(check3Star);
        hotelVBox5.getChildren().add(check4Star);
        hotelVBox5.getChildren().add(check5Star);
        hotelHBox4.getChildren().add(hotelVBox5);
        hotelVBox1.getChildren().add(hotelHBox4);
        hotelHBox.getChildren().add(hotelVBox1);
        getChildren().add(hotelHBox);
        getChildren().add(hotelSearchButton);
        
        hotelSearchButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
		        city = hotelTextField.getText();
		        
				if (!city.equals("")) {
					hotelLabel.setStyle("-fx-text-fill: black");
		        	bean.setCity(city);
		        	cityOk = true;
		        } else {
		        	hotelLabel.setStyle("-fx-text-fill: red");
		        }
				
				if (!hotelTextField0.getText().equals("")) {
					try {
						people = Integer.valueOf(hotelTextField0.getText());
					} catch (NumberFormatException e) {
						hotelLabel2.setStyle("-fx-text-fill: red");
					}
					if (people > 0) {
						hotelLabel2.setStyle("-fx-text-fill: black");
			        	bean.setNumPeople(people);
			        	peopleOk = true;
					} else {
						hotelLabel2.setStyle("-fx-text-fill: red");
			        }
		        } else {
		        	hotelLabel2.setStyle("-fx-text-fill: red");
		        }
				
				if (dateOk != true) {
					hotelLabel0.setStyle("-fx-text-fill: red");
					hotelLabel1.setStyle("-fx-text-fill: red");
				}
				
				if (cityOk == true && dateOk == true && peopleOk == true) {
					
					if (check50_100.isSelected()) {
						bean.setBudget1(true);
					}
					if (check100_150.isSelected()) {
						bean.setBudget2(true);
					}
					if (check150_200.isSelected()) {
						bean.setBudget3(true);
					}
					if (check200.isSelected()) {
						bean.setBudget4(true);
					}

					if (checkApartaments.isSelected()) {
						bean.setApartment(true);
					}
					if (checkHotels.isSelected()) {
						bean.setHotel(true);
					}
					if (checkBeB.isSelected()) {
						bean.setBeb(true);
					}
					if (checkHostels.isSelected()) {
						bean.setHostel(true);
					}
					

					if (checkParking.isSelected()) {
						bean.setParking(true);
					}
					if (checkRestaurant.isSelected()) {
						bean.setRestaurant(true);
					}
					if (checkRoomService.isSelected()) {
						bean.setRoomService(true);
					}
					if (checkFitnessCenter.isSelected()) {
						bean.setGym(true);
					}
					
					if (check1Star.isSelected()) {
						bean.setStar1(true);
					}
					if (check2Star.isSelected()) {
						bean.setStar2(true);
					}
					if (check3Star.isSelected()) {
						bean.setStar3(true);
					}
					if (check4Star.isSelected()) {
						bean.setStar4(true);
					}
					if (check5Star.isSelected()) {
						bean.setStar5(true);
					}
					
					controller.changeScene2();
				}
			}
		});
        
        hotelCheckIn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				LocalDate ld = hotelCheckIn.getValue();
				
				yearIn = ld.getYear();
				monthIn = ld.getMonth().getValue();
				dayIn = ld.getDayOfMonth();
				
				bean.setCheckInYear(yearIn);
				bean.setCheckInMonth(monthIn);
				bean.setCheckInDay(dayIn);
				
				hotelCheckOut.setDisable(false);
				hotelCheckOut.getEditor().clear();
		        
		        hotelCheckOut.setDayCellFactory(picker -> new DateCell() {
					public void updateItem(LocalDate date, boolean empty) {
						super.updateItem(date, empty);
						
						setDisable(empty || date.compareTo(ld) < 1);
					}
				});
			}
		});
        
        hotelCheckOut.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				LocalDate ld = hotelCheckOut.getValue();
				
				yearOut = ld.getYear();
				monthOut = ld.getMonth().getValue();
				dayOut = ld.getDayOfMonth();
				
				bean.setCheckOutYear(yearOut);
				bean.setCheckOutMonth(monthOut);
				bean.setCheckOutDay(dayOut);

				dateOk = true;
			}
		});
    }
}


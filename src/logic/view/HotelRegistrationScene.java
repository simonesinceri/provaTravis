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
import logic.bean.HotelBean;
import logic.controller.ProfileController;

public class HotelRegistrationScene extends VBox {

	protected HBox hBox1;
	protected VBox vBox;
	protected Label hotelLabel;
	protected TextField hotelTextField;
    protected Label hotelLabel0;
    protected TextField hotelTextField1;
    protected Label hotelLabel1;
    protected TextField hotelTextField2;
    
    protected Line line;
    
    protected HBox hBox2;
    protected VBox vBoxFacilities;
    protected Label label;
    protected CheckBox checkBoxParking;
    protected CheckBox checkBoxRestaurant;
    protected CheckBox checkBoxRoomService;
    protected CheckBox checkBoxFitnessCenter;
    protected VBox vBoxType;
    protected Label label0;
    protected CheckBox checkBoxapartaments;
    protected CheckBox checkBoxHotels;
    protected CheckBox checkBoxBeB;
    protected CheckBox checkBoxHostels;

    protected HBox hBoxBtn;
    protected Button btnUndo;
    protected Button btnRegister;
	
	
    public HotelRegistrationScene(ProfileController controller, String ownerName, HotelBean bean) {
    	
    	hBox1 = new HBox();
    	vBox = new VBox();
    	hotelLabel = new Label();
    	hotelTextField = new TextField();
        hotelLabel0 = new Label();
        hotelTextField1 = new TextField();
        hotelLabel1 = new Label();
        hotelTextField2 = new TextField();
        
        line = new Line();
        hBox2 = new HBox();
        vBoxFacilities = new VBox();
        label = new Label();
        checkBoxParking = new CheckBox();
        checkBoxRestaurant = new CheckBox();
        checkBoxRoomService = new CheckBox();
        checkBoxFitnessCenter = new CheckBox();
        vBoxType = new VBox();
        label0 = new Label();
        checkBoxapartaments = new CheckBox();
        checkBoxHotels = new CheckBox();
        checkBoxBeB = new CheckBox();
        checkBoxHostels = new CheckBox();

        hBoxBtn = new HBox();
        btnUndo = new Button();
        btnRegister = new Button();
        
        String style = "-fx-background-color: #e2e8ff; -fx-background-radius: 20;";
       
        
        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setMaxHeight(361.0);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);
        hBox1.setSpacing(65.0);
        hBox1.setPadding(new Insets(50.0,0.0,0.0,0.0));

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setMaxHeight(300.0);
        HBox.setMargin(vBox, new Insets(20.0, 0.0, 0.0, 0.0));

        hotelLabel.setText("Name");
        hotelLabel.setFont(new Font(24.0));

        hotelTextField.setAlignment(javafx.geometry.Pos.CENTER);
        hotelTextField.setPrefWidth(402.0);
        hotelTextField.setPromptText("Structure name");
        hotelTextField.setStyle(style);
        hotelTextField.setFont(new Font(24.0));
        VBox.setMargin(hotelTextField, new Insets(15.0, 0.0, 0.0, 0.0));

        hotelLabel0.setText("City");
        hotelLabel0.setFont(new Font(24.0));
        VBox.setMargin(hotelLabel0, new Insets(35.0, 0.0, 0.0, 0.0));

        hotelTextField1.setAlignment(javafx.geometry.Pos.CENTER);
        hotelTextField1.setPromptText("Structure city");
        hotelTextField1.setStyle(style);
        hotelTextField1.setFont(new Font(24.0));
        VBox.setMargin(hotelTextField1, new Insets(15.0, 0.0, 0.0, 0.0));
        
        hotelLabel1.setText("Address");
        hotelLabel1.setFont(new Font(24.0));
        VBox.setMargin(hotelLabel1, new Insets(35.0, 0.0, 0.0, 0.0));

        hotelTextField2.setAlignment(javafx.geometry.Pos.CENTER);
        hotelTextField2.setPromptText("Structure address");
        hotelTextField2.setStyle(style);
        hotelTextField2.setFont(new Font(24.0));
        VBox.setMargin(hotelTextField2, new Insets(15.0, 0.0, 0.0, 0.0));

        line.setEndY(180.0);
        line.setStartY(-180.0);

        hBox2.setPrefHeight(100.0);
        hBox2.setPrefWidth(200.0);
        hBox2.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBox2.setPadding(new Insets(100.0, 0.0, 0.0, 25.0));

        vBoxFacilities.setPrefHeight(180.0);
        vBoxFacilities.setMinWidth(189.0);
        vBoxFacilities.setSpacing(5.0);

        label.setText("Facilities");
        label.setFont(new Font(24.0));
        label.setPrefHeight(35.0);
        label.setPrefWidth(203.0);

        checkBoxParking.setMnemonicParsing(false);
        checkBoxParking.setText("Parking");
        checkBoxParking.setFont(new Font(18.0));

        checkBoxRestaurant.setMnemonicParsing(false);
        checkBoxRestaurant.setText("Restaurant");
        checkBoxRestaurant.setFont(new Font(18.0));

        checkBoxRoomService.setMnemonicParsing(false);
        checkBoxRoomService.setText("Room service");
        checkBoxRoomService.setFont(new Font(18.0));

        checkBoxFitnessCenter.setMnemonicParsing(false);
        checkBoxFitnessCenter.setText("Fitness centre");
        checkBoxFitnessCenter.setFont(new Font(18.0));

        vBoxType.setPrefHeight(396.0);
        vBoxType.setMinWidth(188.0);
        vBoxType.setSpacing(5.0);

        label0.setPrefHeight(35.0);
        label0.setPrefWidth(203.0);
        label0.setText("Property type");
        label0.setFont(new Font(24.0));

        checkBoxapartaments.setMnemonicParsing(false);
        checkBoxapartaments.setText("Apartamnets");
        checkBoxapartaments.setFont(new Font(18.0));

        checkBoxHotels.setMnemonicParsing(false);
        checkBoxHotels.setText("Hotels");
        checkBoxHotels.setFont(new Font(18.0));

        checkBoxBeB.setMnemonicParsing(false);
        checkBoxBeB.setText("B&B");
        checkBoxBeB.setFont(new Font(18.0));

        checkBoxHostels.setMnemonicParsing(false);
        checkBoxHostels.setText("Hostels");
        checkBoxHostels.setFont(new Font(18.0));

        hBoxBtn.setAlignment(javafx.geometry.Pos.CENTER);
        hBoxBtn.setPrefHeight(63.0);
        hBoxBtn.setPrefWidth(841.0);
        hBoxBtn.setSpacing(30.0);

        btnUndo.setMnemonicParsing(false);
        btnUndo.setText("Undo");
        btnUndo.setFont(new Font(24.0));
        btnUndo.setMinWidth(120.0);
        btnUndo.setStyle("-fx-background-color: #1B59D7;");
        btnUndo.setTextFill(javafx.scene.paint.Color.WHITE);
        
        btnUndo.setOnMouseEntered(evt -> btnUndo.setUnderline(true));
        btnUndo.setOnMouseExited(evt -> btnUndo.setUnderline(false));

        btnRegister.setMnemonicParsing(false);
        btnRegister.setMinWidth(120.0);
        btnRegister.setStyle("-fx-background-color: #1B59D7;");
        btnRegister.setText("Register");
        btnRegister.setTextFill(javafx.scene.paint.Color.WHITE);
        btnRegister.setFont(new Font(24.0));
        
        btnRegister.setOnMouseEntered(evt -> btnRegister.setUnderline(true));
        btnRegister.setOnMouseExited(evt -> btnRegister.setUnderline(false));
        
        vBox.getChildren().add(hotelLabel);
        vBox.getChildren().add(hotelTextField);
        vBox.getChildren().add(hotelLabel0);
        vBox.getChildren().add(hotelTextField1);
        vBox.getChildren().add(hotelLabel1);
        vBox.getChildren().add(hotelTextField2);
        hBox1.getChildren().add(vBox);
        
        hBox1.getChildren().add(line);
        
        vBoxFacilities.getChildren().add(label);
        vBoxFacilities.getChildren().add(checkBoxParking);
        vBoxFacilities.getChildren().add(checkBoxRestaurant);
        vBoxFacilities.getChildren().add(checkBoxRoomService);
        vBoxFacilities.getChildren().add(checkBoxFitnessCenter);
        hBox2.getChildren().add(vBoxFacilities);
        vBoxType.getChildren().add(label0);
        vBoxType.getChildren().add(checkBoxapartaments);
        vBoxType.getChildren().add(checkBoxHotels);
        vBoxType.getChildren().add(checkBoxBeB);
        vBoxType.getChildren().add(checkBoxHostels);
        hBox2.getChildren().add(vBoxType);
        hBox1.getChildren().add(hBox2);
        
        hBoxBtn.getChildren().add(btnUndo);
        hBoxBtn.getChildren().add(btnRegister);
        
        getChildren().add(hBox1);
        getChildren().add(hBoxBtn);

        checkBoxType();
		
		btnRegister.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				boolean nameOk = false;
				boolean cityOk = false;
				boolean addressOk = false;
				boolean typeOk = false;
				
				boolean ok = false;
				
				ok = getParamReg(nameOk, cityOk, addressOk, typeOk, bean);
			
				
				if (ok) {
					
					bean.setGym(checkBoxFitnessCenter.isSelected());				
					bean.setParking(checkBoxParking.isSelected());					
					bean.setRestaurant(checkBoxRestaurant.isSelected());				
					bean.setRoomService(checkBoxRoomService.isSelected());
				
					bean.setApartment(checkBoxapartaments.isSelected());				
					bean.setBeb(checkBoxBeB.isSelected());				
					bean.setHostel(checkBoxHostels.isSelected());	
					bean.setHotel(checkBoxHotels.isSelected());
					
					boolean added =  controller.registerStructure(ownerName,bean);
					
					if (added) {
						btnRegister.setText("Structure registered");
						btnRegister.setDisable(true);
						btnUndo.setText("Back to Profile");
					} else {
						hotelLabel.setText("Already exist: change name");
						hotelLabel.setStyle("-fx-text-fill: red");
					}
					
				}
			}
		});
        
		btnUndo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				controller.loggedScene();
	        }
		});
    }
    
    private boolean getParamReg(boolean nameOk, boolean cityOk, boolean addressOk, boolean typeOk, HotelBean bean) {
    	
    	String black = "-fx-text-fill: black";
        String red = "-fx-text-fill: red";
    	String name = hotelTextField.getText();
        
		if (!name.equals("")) {
			hotelLabel.setStyle(black);
        	bean.setName(name);
        	nameOk = true;
        } else {
        	hotelLabel.setStyle(red);
        }
		
		String city = hotelTextField1.getText();
		
		if (!city.equals("")) {
			hotelLabel0.setStyle(black);
        	bean.setCity(city);
        	cityOk = true;
        } else {
        	hotelLabel0.setStyle(red);
        }
		
		String address = hotelTextField2.getText();
		
		if (!address.equals("")) {
			hotelLabel1.setStyle(black);
        	bean.setAddress(address);
        	addressOk = true;
        } else {
        	hotelLabel1.setStyle(red);
        }
		
		if (checkBoxapartaments.isSelected() ||
				checkBoxBeB.isSelected() ||
				checkBoxHostels.isSelected() ||
				checkBoxHotels.isSelected()) {
        	label0.setStyle(black);
			typeOk = true;
		} else {
        	label0.setStyle(red);
		}
		
		return (nameOk && cityOk && addressOk && typeOk);
	
    }
    
    private void checkBoxType() {
    	
        checkBoxapartaments.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
				if (!checkBoxapartaments.isSelected()) {
					checkBoxapartaments.setSelected(false);
				}
				checkBoxBeB.setSelected(false);
				checkBoxHostels.setSelected(false);
				checkBoxHotels.setSelected(false);		
	        }
		});
        
        checkBoxBeB.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
				if (!checkBoxBeB.isSelected()) {
					checkBoxBeB.setSelected(false);
				}
				checkBoxapartaments.setSelected(false);
				checkBoxHostels.setSelected(false);
				checkBoxHotels.setSelected(false);		
	        }
		});

        checkBoxHotels.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
				if (!checkBoxHotels.isSelected()) {
					checkBoxHotels.setSelected(false);
				}
				checkBoxHostels.setSelected(false);
				checkBoxapartaments.setSelected(false);
				checkBoxBeB.setSelected(false);	
	        }
		});
        
        checkBoxHostels.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
				if (!checkBoxHostels.isSelected()) {
					checkBoxHostels.setSelected(false);
				}
				checkBoxBeB.setSelected(false);
				checkBoxapartaments.setSelected(false);
				checkBoxHotels.setSelected(false);		
	        }
		});
        

    }
}
package logic.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.controller.HotelController;
import logic.exceptions.ExceptionSearchReview;
import logic.model.Hotel;
import logic.model.Room;


public class Hotel3Scene extends VBox{
	
	protected VBox vBox;
    protected HBox hBoxHotelName;
    protected ImageView imageViewHotel;
    protected VBox vBoxHotelInfo;
    protected Text textName;
    protected Text textAddress;
    protected Text textNStars;
    protected VBox vBoxReview;
    protected Button btnReview;
    protected VBox vBoxDescription;
    protected Label textDescription;
    protected ScrollPane scrollPane;
    protected HBox hBoxBtn;
    protected Button btnBack;
    protected Button btnBook;
    protected Separator separatorBtnBack;
    protected Separator separatorBtnFrecce;

    public Hotel3Scene(HotelController controller, Hotel hotel, Room room) {

        
        vBox = new VBox();
        hBoxHotelName = new HBox();
        imageViewHotel = new ImageView();
        vBoxHotelInfo = new VBox();
        textName = new Text();
        textAddress = new Text();
        textNStars = new Text();
        vBoxReview = new VBox();
        btnReview = new Button();
        vBoxDescription = new VBox();
        textDescription = new Label();
        scrollPane = new ScrollPane();
        hBoxBtn = new HBox();
        btnBack = new Button();
        btnBook = new Button();
        
        String colorBtn = "-fx-background-color: #1B59D7;";
        
        separatorBtnBack = new Separator();
        separatorBtnFrecce = new Separator();

        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(525.0);
        setPrefWidth(1050.0);
        setSpacing(30.0);
     
        vBox.setLayoutX(104.5);
        vBox.setLayoutY(24.0);
        vBox.setPrefHeight(477.0);
        vBox.setPrefWidth(841.0);

        hBoxHotelName.setPrefHeight(138.0);
        hBoxHotelName.setPrefWidth(841.0);
        hBoxHotelName.setSpacing(30.0);
        hBoxHotelName.setPadding(new Insets(0.0, 0.0, 0.0, 100.0));

        imageViewHotel.setFitHeight(162.0);
        imageViewHotel.setFitWidth(200.0);
        imageViewHotel.setPickOnBounds(true);
        imageViewHotel.setPreserveRatio(true);
        
        Image photo = hotel.getHotelImage();
        
        if (photo == null) {
        	imageViewHotel.setImage(new Image(getClass().getResource("strucutre.jpg").toExternalForm()));
        } else {
        	imageViewHotel.setImage(photo);
        }

        vBoxHotelInfo.setAlignment(javafx.geometry.Pos.CENTER);
        vBoxHotelInfo.setPrefHeight(150.0);
        vBoxHotelInfo.setPrefWidth(342.0);
        vBoxHotelInfo.setSpacing(10.0);

        textName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textName.setStrokeWidth(0.0);
        textName.setText(hotel.getHotelName());
        textName.setWrappingWidth(342);
        textName.setFont(new Font(24.0));

        textAddress.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textAddress.setStrokeWidth(0.0);
        textAddress.setText(hotel.getHotelAddress());
        textAddress.setWrappingWidth(342);
        textAddress.setFont(new Font(24.0));

        textNStars.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textNStars.setStrokeWidth(0.0);
        
        if (hotel.getHotelRating() == 0) {
        	textNStars.setText("Still 0 reviews");
        	btnReview.setDisable(true);
        } else {
        	textNStars.setText(String.valueOf(hotel.getHotelRating()) + " stars");
        }
        
        textNStars.setFont(new Font(24.0));
        textNStars.setWrappingWidth(342);

        vBoxReview.setAlignment(javafx.geometry.Pos.CENTER);
        vBoxReview.setPrefHeight(162.0);
        vBoxReview.setPrefWidth(239.0);

        btnReview.setMnemonicParsing(false);
        btnReview.setStyle(colorBtn);
        btnReview.setText("View Reviews");
        btnReview.setTextFill(javafx.scene.paint.Color.WHITE);
        btnReview.setFont(new Font(24.0));
        btnReview.setMinWidth(86.0);
        
        btnReview.setOnMouseEntered(evt -> btnReview.setUnderline(true));
        btnReview.setOnMouseExited(evt -> btnReview.setUnderline(false));

        vBoxDescription.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBoxDescription.setMinHeight(276.0);
        vBoxDescription.setPrefWidth(841.0);
        vBoxDescription.setPadding(new Insets(15.0, 0.0, 15.0, 0.0));

        textDescription.setText(hotel.getHotelDescription());
        textDescription.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        textDescription.setWrapText(true);
        textDescription.setFont(new Font(24.0));
        textDescription.setMaxWidth(700.0);
        textDescription.setMinHeight(244.0);
        textDescription.setStyle("-fx-background-color: white;");

        if (hotel.getHotelDescription().equals("")) {
        	textDescription.setText("No description available");
        }
        
        scrollPane.setContent(textDescription);
        scrollPane.setMaxWidth(700.0);
        scrollPane.setPrefHeight(275.0);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: white;");

        hBoxBtn.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBoxBtn.setPrefHeight(75.0);
        hBoxBtn.setPrefWidth(841.0);
        hBoxBtn.setSpacing(30.0);
        
        separatorBtnBack.setOpacity(0.0);
        separatorBtnBack.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separatorBtnBack.setPrefHeight(57.0);
        separatorBtnBack.setPrefWidth(30.0);
        
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(39.0);
        btnBack.setMinWidth(118.0);
        btnBack.setStyle(colorBtn);
        btnBack.setText("<< back");
        btnBack.setTextFill(javafx.scene.paint.Color.WHITE);
        btnBack.setFont(new Font(24.0));
        
        btnBack.setOnMouseEntered(evt -> btnBack.setUnderline(true));
    	btnBack.setOnMouseExited(evt -> btnBack.setUnderline(false));
        
        separatorBtnFrecce.setOpacity(0.0);
        separatorBtnFrecce.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separatorBtnFrecce.setPrefHeight(57.0);
        separatorBtnFrecce.setPrefWidth(250.0);

        btnBook.setMnemonicParsing(false);
        btnBook.setStyle(colorBtn);
        btnBook.setPrefHeight(39.0);
        btnBook.setText("Book");
        btnBook.setTextFill(javafx.scene.paint.Color.WHITE);
        btnBook.setFont(new Font(24.0));

        btnBook.setOnMouseEntered(evt -> btnBook.setUnderline(true));
        btnBook.setOnMouseExited(evt -> btnBook.setUnderline(false));
        setOpaqueInsets(new Insets(0.0));

     
        hBoxHotelName.getChildren().add(imageViewHotel);
        vBoxHotelInfo.getChildren().add(textName);
        vBoxHotelInfo.getChildren().add(textAddress);
        vBoxHotelInfo.getChildren().add(textNStars);
        hBoxHotelName.getChildren().add(vBoxHotelInfo);
        vBoxReview.getChildren().add(btnReview);
        hBoxHotelName.getChildren().add(vBoxReview);
        vBox.getChildren().add(hBoxHotelName);
        vBoxDescription.getChildren().add(scrollPane);
        vBox.getChildren().add(vBoxDescription);
        hBoxBtn.getChildren().add(separatorBtnBack);
        hBoxBtn.getChildren().add(btnBack);
        hBoxBtn.getChildren().add(separatorBtnFrecce);
        hBoxBtn.getChildren().add(btnBook);
        vBox.getChildren().add(hBoxBtn);
        getChildren().add(vBox);
        
        
        btnReview.setOnAction(new EventHandler<ActionEvent>(){
 			@Override
        	public void handle(ActionEvent event) {
 				
 				try {
					controller.viewReviews(true,hotel.getHotelReviews(),0);
				} catch (ExceptionSearchReview e) {
					btnReview.setDisable(true);
					btnReview.setText("Can't load Reviews");
				}
 			}
 		});
        
        btnBack.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				controller.setStep(2);
 				controller.returnBackList();
 			}
 		});
        
        btnBook.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
 				controller.goToBook(hotel, room);
 			}
 		});
        

    }
}


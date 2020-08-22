<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

  

<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>FindIt</title>
		<link href="htmlCss.css" rel="stylesheet" type="text/css">
	</head>
	
	<!-- questo è un commento -->
	<body>
		<div id="container">
		
			<div id="header">
			
				<div id="title">
					<p><a href="index.jsp" title="Hotels">FindIt</a></p>
				</div>
				
				<ul class="menu">
					<li><a href="hotelsView.jsp" style="color: orange;" title="Hotels">Hotels</a></li>
					<li><a href="restaurantsView.jsp" title="Restaurants">Restaurants</a></li>
					<li><a href="eventsView.jsp" title="Events">Events</a></li>
					<li><a href="mapView..jsp" title="Map">Map</a></li>
					<%if(session.getAttribute("userLog") == null){ %>
						<li><a href="profileView.jsp"  title="Profile">Profile</a></li>
					<%}else{ %>
						<li><a href="profilePage2.jsp"  title="Profile">Profile</a></li>
					<% } %>
				</ul>
				
			</div>
			
		<!--  	<form method="POST" action="prova.jsp"> -->
			<form method="POST" action="SearchHotel">
			<div id="content" class="form-group" align="center">
			
				<div id="box1" class="form-group" align="center" style="border-right-style: solid; border-right-width: thin;">
					
					
  						<label style="margin-top: 15px;">Where do you like to go?</label><br>
  						
  						<input type="text" required name= "city" placeholder="Es: Rome"><br>
  						
  						<label style="margin-right: 25px;">Check-in</label>
  						<label style="margin-left: 25px;">Check-out</label><br>
  						<input type="date" required name="datein" size="10" placeholder="gg-mm-yyyy" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" style="margin-right: 40px;">
  						<input type="date" required name="dateout" size="10"  placeholder="gg-mm-yyyy" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}"><br>
   						<%if(request.getAttribute("dateNotValid") == "invalid" ) {%>
   								<label style="color: #F80000;margin-top: 0px;set-font: 20px">Invalid date range!</label><br>
   						<% } %>
   						<label>How many people? </label>
   						<input type="number" required name="numPeople" size="5" placeholder="Es: 4" pattern="[0-9]">
 					
 				</div>
 				
 				<div id="box2" class="form-group" align="left">
					
  						<label style="margin-top: 15px; margin-left: 30px; font-size: 25px;">Budget</label><br>
  						<input type="checkbox" name="check50_100" value="50-100" class="chk"/>
  						<label style="font-size: 20px;"> 50€ - 100€ for night</label><br>
  						<input type="checkbox" name="check100_150" value="100-150"  class="chk"/>
  						<label style="font-size: 20px;"> 100€ - 150€ for night</label><br>
  						<input type="checkbox" name="check150_200" value="150-200"  class="chk"/>
  						<label style="font-size: 20px;"> 150€ - 200€ for night</label><br>
  						<input type="checkbox"  name="check200" value="+200"  class="chk"/>
  						<label style="font-size: 20px;"> 200€ + for night</label><br>
 					
 				</div>
 				
 				<div id="box2" class="form-group" align="left">
					
  						<label style="margin-top: 15px; margin-left: 30px; font-size: 25px;">Property type</label><br>
  						<input type="checkbox" name="checkApartments" value="apartments"  class="chk"/>
  						<label style="font-size: 20px;"> Apartaments</label><br>
  						<input type="checkbox" name="checkHotels" value="hotels" class="chk"/>
  						<label style="font-size: 20px;"> Hotels</label><br>
  						<input type="checkbox" name="checkBeB" value="BeB"  class="chk"/>
  						<label style="font-size: 20px;"> BeB</label><br>
  						<input type="checkbox" name="checkHostels" value="hostels" class="chk"/>
  						<label style="font-size: 20px;"> Hostels</label><br>					
 					
 				</div>
 				
 				<div id="box2" class="form-group" align="left" style="margin-top: 0px;">
					
  						<label style="margin-top: 15px; margin-left: 30px; font-size: 25px;">Facilities</label><br>
  						<input type="checkbox" name="checkParking" value="parking" class="chk"/>
  						<label style="font-size: 20px;"> Parking</label><br>
  						<input type="checkbox" name="checkRestaurant" value="restaurant" class="chk"/>
  						<label style="font-size: 20px;"> Restaurant</label><br>
  						<input type="checkbox" name="checkRoomService" value="roomService" class="chk"/>
  						<label style="font-size: 20px;"> Room service</label><br>
  						<input type="checkbox" name="checkFitnessCenter" value="fitnessCenter" class="chk"/>
  						<label style="font-size: 20px;"> Fitness center</label><br>					
 					
 				</div>
 				
 				<div id="box2" class="form-group" align="left" style="margin-top: 0px;">
					
  						<label style="margin-top: 15px; margin-left: 30px; font-size: 25px;">Rating</label><br>
  						<input type="checkbox" name="check1star" value="1 star" class="chk"/>
  						<label style="font-size: 20px;"> 1 star</label><br>
  						<input type="checkbox" name="check2star" value="2 star" class="chk"/>
  						<label style="font-size: 20px;"> 2 star</label><br>
  						<input type="checkbox" name="check3star" value="3 star" class="chk"/>
  						<label style="font-size: 20px;"> 3 star</label><br>
  						<input type="checkbox" name="check4star" value="4 star" class="chk"/>
  						<label style="font-size: 20px;"> 4 star</label><br>
  						<input type="checkbox" name="check5star" value="5 star" class="chk"/>
  						<label style="font-size: 20px;"> 5 star</label><br>				
 					
 				</div>
 				
  			<!--  	<button class="searchButton">Search</button> -->
  					<input style="background-color: #1B59D7; color: #ffffff;font-size: 25px; border: none;border-radius: 0px;" type="submit" value="Search">
 				
			</div>
			
			</form>
		
		</div>
	</body>
</html>
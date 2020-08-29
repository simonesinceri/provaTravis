<%@page import="web_2.logic.bean.LoginBeanWeb"%>
<%@page import="web_2.logic.model.OwnerWeb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%OwnerWeb loggato = (OwnerWeb)session.getAttribute("ownerLog"); 
    LoginBeanWeb beanLog = (LoginBeanWeb)session.getAttribute("beanLog"); %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>FindIt</title>
		<link href="htmlCss.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
		<div id="container">
		
			<div id="header">
			
				<div id="title">
					<p><a href="index.jsp" title="Hotels">FindIt</a></p>
				</div>
				
				<ul class="menu">
					<%if(session.getAttribute("step") == "1"){ %>
						<li><a href="hotelsView2.jsp"  title="Hotels">Hotels</a></li>
					<%}else if(session.getAttribute("step") == "2"){  %>
						<li><a href="hotelsView3.jsp"  title="Hotels">Hotels</a></li>
					<%}else{ %>
					<li><a href="hotelsView.jsp"  title="Hotels">Hotels</a></li>
					<%} %>
					<li><a href="restaurantsView.jsp" title="Restaurants">Restaurants</a></li>
					<li><a href="eventsView.jsp" title="Events">Events</a></li>
					<li><a href="mapView.jsp" title="Map">Map</a></li>
					<%if(session.getAttribute("userLog") != null ){ %>
						<li><a href="profilePage2.jsp"  style="color: orange" title="Profile">Profile</a></li>
					<%}else if(session.getAttribute("ownerLog") != null){ %>
						<li><a href="ownerPage.jsp" style="color: orange" title="Profile">Profile</a></li>
					<%}else{ %>		
						<li><a href="profileView.jsp"  style="color: orange" title="Profile">Profile</a></li>
					<% } %>
				</ul>
				
			</div>
			
			<div id="content" align="center">				
			
				

				<div id="box1" style="border-right-style: solid; border-right-width: thin;width: 280px;margin-top: 5px;" align="center">
					
					<label style="margin-top: 5px;line-height: 45px; font-size: 35px;"> <% out.print(loggato.getUsername()); %> </label><br>
 					<img src="account.jpg" style="height: 100px;margin-top: 0px;width: 180px;" align="middle"> <br>
 					<label style="font-size: 18px;text-decoration: underline;">Change your profile image</label><br>
 					<label style="margin-top: 10px; line-height: 45px; font-size: 30px;"> Structures:  <% out.print(beanLog.getStructures()); %></label><br>
 					
 					<form method="get" action="Logout">
 						<input type="submit" value="Logout" style="background-color: #1B59D7; color: #ffffff;font-size: 22px; border: none;border-radius: 0px;width: 120px;height: 51px; margin-top: 78px;">
 					</form>


 				</div>

 				<form method="post" action="AddStructure">	
 				
 				<div id="box1"  class="form-group" align="center" style="width: 280px;height: 280px;margin-top: 20px;margin-left: 10px;">
					
					
 							
 							<label style="margin-top: 20px;margin-right: 10px;font-size: 25px">Name</label><br>
 							<input style="margin-right: 10px" type="text" required name="structureName" placeholder="Strucuture Name"><br>
 							<label style="margin-top: 10px;margin-right: 10px;font-size: 25px">City</label><br>

 							<input style="margin-right: 10px" type="text" required name="structureCity" placeholder="Strucuture City"><br>
 							<label style="margin-top: 10px;margin-right: 10px;font-size: 25px">Address</label><br>
 							<input style="margin-right: 10px" type="text" required name="structureAddress" placeholder="strucutureAddress"><br>
 					
 				
 				</div>

 				<div id="box1" class="form-group"  align="center" style="width: 310px;height: 280px;margin-top: 10px;margin-left: 20px;">
 					
 					

 					<div id="box2" class="form-group" align="left" style="height: 80px;width:150px">
					
  						<label style="margin-top: 15px; margin-left: 20px; font-size: 25px;">Facilities</label><br>
  						<input type="checkbox" name="cParking" value="apartments"  class="chk"/>
  						<label style="font-size: 20px;"> Parking</label><br>
  						<input type="checkbox" name="cRestaurant" value="hotels" class="chk"/>
  						<label style="font-size: 20px;"> Restaurant</label><br>
  						<input type="checkbox" name="cRoomService" value="BeB"  class="chk"/>
  						<label style="font-size: 20px;"> Room Serv</label><br>
  						<input type="checkbox" name="cGym" value="hostels" class="chk"/>
  						<label style="font-size: 20px;"> Gym</label><br>					
 					
 				</div>
 				<div id="box2" class="form-group" align="left" style="height: 80px;width:160px">
					
  						<label style="margin-top: 15px; margin-left: 20px; font-size: 25px;">Property type</label><br>
  						<input type="radio" name="cApartments" value="apartments"  class="chk"/>
  						<label style="font-size: 20px;"> Apartaments</label><br>
  						<input type="radio" name="cHotels" value="hotels" class="chk"/>
  						<label style="font-size: 20px;"> Hotels</label><br>
  						<input type="radio" name="cBeB" value="BeB"  class="chk"/>
  						<label style="font-size: 20px;"> BeB</label><br>
  						<input type="radio" name="cHostels" value="hostels" class="chk"/>
  						<label style="font-size: 20px;"> Hostels</label><br>					
 					
 				</div>

 				</div>

 				<div id="box1" class="form-group"  align="center" style="width: 660px;height: 50px;margin-top: 40px;">
 					
						<%if(request.getAttribute("regStr") != "ok"){ %>
 							<button class="searchButton" style="font-size: 22px; margin-top: 0px;margin-left: 0px;height: 51px;width: 100px;"
 									onclick="location.href='ownerPage.jsp'"> Back </button>

 							<input type="Submit" style="background-color: #1B59D7; color: #ffffff;font-size: 22px; border: none;border-radius: 0px; margin-top: 0px;margin-left: 30px;height: 51px;width: 100px"
 								value="Register"> 
 						<%}else{ %>
 							<label style="color: #24E711;margin-top: 0px;margin-right: 20px">Structure registration completed!</label>
 							<button class="searchButton" style="font-size: 22px; margin-top: 0px;margin-left: 0px;height: 51px;width: 100px;"
 								onclick="location.href='ownerPage.jsp'"> Back </button>
 							<% } %>
 							<!--  bisogan ruchiamare il chage experience -->
 				</div>
				
			</form>

			</div>
			
		
		</div>
	</body>
</html>
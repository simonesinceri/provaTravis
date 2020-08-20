<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
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
					<li><a href="hotelsView.jsp" title="Hotels">Hotels</a></li>
					<li><a href="restaurantsView.jspl" title="Restaurants">Restaurants</a></li>
					<li><a href="eventsView.jsp" title="Events">Events</a></li>
					<li><a href="mapView.jsp" title="Map">Map</a></li>
					<li><a href="profileView.jsp" style="color: orange;" title="Profile">Profile</a></li>
				</ul>
				
			</div>
			
			<div id="content" align="center">				
			
				<div id="box1" align="center" style="border-right-style: solid; border-right-width: thin;">
					<label style="margin-top: 50px;">Inser Username and Password</label>
					
					<label>Username: </label>
   					<input type="text" size="20" placeholder="Username"><br>
					<label style="margin-left: 7px;">Password: </label>
   					<input type="password" size="20" placeholder="Password"><br>
   					<form action="">
   						<input type="radio" name="registerType" class="radioB">
   						<label style="font-size: 25px;">Register as an User</label><br>
   						<input type="radio" name="registerType" class="radioB" style="margin-left: 20px;">
   						<label style="font-size: 25px;">Register as an Owner</label><br>
   					</form>
 				</div>

 				<div id="box1" align="center">
					<label style="margin-top: 15px; line-height: 45px; font-size: 35px;">
													Are you new in our<br>
													system? You can create<br>
													your own profile or your<br>
													business profile to reserve<br>
													or get reserved!</label><br>
 					<button class="searchButton" style="width: 130px; margin-top: 20px;">Register</button>
 				</div>
				
			</div>
			
		</div>
	</body>
</html>
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
					<li><a href="restaurantsView.jsp" title="Restaurants">Restaurants</a></li>
					<li><a href="eventsView.jsp" title="Events">Events</a></li>
					<li><a href="mapView.jsp" title="Map">Map</a></li>
					<li><a href="profileView.jsp" style="color: orange;" title="Profile">Profile</a></li>
				</ul>
				
			</div>
			
			<div id="content" align="center">				
			
				<div id="box1" align="center" style="border-right-style: solid; border-right-width: thin;">
					<label style="margin-top: 15px; line-height: 45px; font-size: 35px;">
													Do you already have<br>
													a profile? Log in to<br>
													organize your programs<br>
													and book the facilities<br>
													you prefer!</label><br>
 				<!-- 	<button class="searchButton" style="width: 130px; margin-top: 20px;">Login</button>  -->
 				</div>

 				<div id="box1" align="center">
 					<label style="margin-top: 50px;">Inser Username and Password</label>
					
					<form method="post" action="Login">	
						<label>Username: </label>
   						<input type="text" required name="username" size="20" placeholder="Username"><br>
						<label style="margin-left: 7px;">Password: </label>
  						<input type="password" required name="password" size="20" placeholder="Password"><br>
 						<input style="background-color: #1B59D7; color: #ffffff;font-size: 25px; border: none;border-radius: 0px;width: 130px;height: 51px; margin-top: 40px;" type="submit" value="Login">
 					</form>

 				</div>
				
			</div>
			
		</div>
	</body>
</html>
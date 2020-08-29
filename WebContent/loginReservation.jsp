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
						<%if(session.getAttribute("step") == "1"){ %>
							<li><a href="hotelsView2.jsp"  title="Hotels">Hotels</a></li>
						<%}else if(session.getAttribute("step") == "2"){  %>
							<li><a href="hotelsView3.jsp"  title="Hotels">Hotels</a></li>
						<%}else{ %>
							<li><a href="hotelsView.jsp"  title="Hotels">Hotels</a></li>
						<%} %>
						<li><a href="restaurantsView.jsp" title="Restaurants">Restaurants</a></li>
						<li><a href="eventsView.jsp" title="Events">Events</a></li>
						<li><a href="mapView..jsp" title="Map">Map</a></li>
						<%if(session.getAttribute("userLog") != null ){ %>
							<li><a href="profilePage2.jsp"  title="Profile">Profile</a></li>
						<%}else if(session.getAttribute("ownerLog") != null){ %>
							<li><a href="ownerPage.jsp"  title="Profile">Profile</a></li>
						<%}else{ %>		
							<li><a href="profileView.jsp"  title="Profile">Profile</a></li>
						<% } %>
					</ul>
				
				</div>

			<div id="content" align="center">
				<!-- box info hotel  -->
				
				<form method="post" action="LoginReservation">
					<div id="box3"   class="form-group" align="center" style="margin-left: 101px;margin-top: 20px; height: 260px">
				  	
				 				<label style=";margin-right: 80px;margin-top: 20px;font-size: 30px"> Login </label><br>
			 					
			 					<%if((request.getAttribute("loginFailR")) == "fail") {%>
										<label style="margin-top: 10px;margin-right: 60px; font-size: 25px; color: #F80000">Try again, username or password is wrong</label><br>
								<% } %>
			 			
				 				<label style=";margin-right: 20px;margin-left: -60px;margin-top: 40px"> Username </label>
				 				<input type="text" required name="username" placeholder="Username"><br>
				 				<label style=";margin-right: 20px;margin-left: -60px;margin-top: 40px"> Password </label>
				 				<input type="password" required name="password" placeholder="Password">
				 		
				 	</div>

			
				<!-- button -->
			
					<div id="box3"  class="form-group"   align="center" style="margin-left: 55px;margin-top: 5px; height: 55px;">
					
					
							<input type="submit" style="width: 86px; height: 51px;font-size: 20px;margin-left: 15px;background-color: #1B59D7; color: #ffffff;border: none;border-radius: 0px;" value="Login">
					
				
					</div>
				</form>
			
			</div>

			
		</div>
	</body>
</html>
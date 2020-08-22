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
					<%if(session.getAttribute("userLog") == null){ %>
							<li><a href="profileView.jsp"  title="Profile">Profile</a></li>
						<%}else{ %>
							<li><a href="profilePage2.jsp"  title="Profile">Profile</a></li>
					<% } %>
				</ul>
				
			</div>
			
			<div id="content" align="center">				
				<form method="post" action="Register">
				<div id="box1"  class="form-group" align="center" style="border-right-style: solid; border-right-width: thin;">
					<label style="margin-top: 50px;">Inser Username and Password</label>
					
						<label>Username: </label>
   						<input type="text" name ="username" required size="20" placeholder="Username"><br>
						<label style="margin-left: 7px;">Password: </label>
   						<input type="password" name ="password" required size="20" placeholder="Password"><br>
   						<input type="radio"  name="registerUser" value="user" class="radioB">
   						<label style="font-size: 25px;">Register as an User</label><br>
   						<input type="radio"  name="registerOwner" value="owners" class="radioB" style="margin-left: 20px;">
   						<label style="font-size: 25px;">Register as an Owner</label><br>
   						<%if(request.getAttribute("radio") == "not"){ %>
   							<label style="color: #F80000;margin-top: 0px;margin-left: 20px;font-size: 25px">One option must be selected!</label>
 						<% } %>
 						<%if(request.getAttribute("reg") == "fail"){ %>
 						<label style="color: #F80000;margin-top: 0px;margin-left: 20px;font-size: 25px">Registration failed, try again!</label>
 						<% } %>
 				</div>

 				<div id="box1"  class="form-group" align="center">
					<label style="margin-top: 15px; line-height: 45px; font-size: 35px;">
													Are you new in our<br>
													system? You can create<br>
													your own profile or your<br>
													business profile to reserve<br>
													or get reserved!</label><br>
 					<input style="background-color: #1B59D7; color: #ffffff;font-size: 25px; border: none;border-radius: 0px;width: 130px;height: 51px; margin-top: 40px;" type="submit" value="Register">
 				</div>
				</form>
			</div>
			
		</div>
	</body>
</html>
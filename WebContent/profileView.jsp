<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			
				<div id="box1" align="center" style="border-right-style: solid; border-right-width: thin;">
					<label style="margin-top: 15px; line-height: 45px; font-size: 35px;">
													Do you already have<br>
													a profile? Log in to<br>
													organize your programs<br>
													and book the facilities<br>
													you prefer!</label><br>
 					<button class="searchButton" style="width: 130px; margin-top: 20px;"
 							onclick="location.href = 'loginView.jsp';">Login</button>
 				</div>

 				<div id="box1" align="center">
					<label style="margin-top: 15px; line-height: 45px; font-size: 35px;">
													Are you new in our<br>
													system? You can create<br>
													your own profile or your<br>
													business profile to reserve<br>
													or get reserved!</label><br>
 					<button class="searchButton" style="width: 130px; margin-top: 20px;"
 							onclick="location.href = 'registerView.jsp';">Register</button>
 				</div>
				
			</div>
			
		</div>
	</body>
</html>
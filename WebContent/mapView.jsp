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
					<li><a href="mapView.jsp" style="color: orange;" title="Map">Map</a></li>
					<%if(session.getAttribute("userLog") == null){ %>
							<li><a href="profileView.jsp"  title="Profile">Profile</a></li>
					<%}else{ %>
							<li><a href="profilePage2.jsp"  title="Profile">Profile</a></li>
					<% } %>
				</ul>
				
			</div>
			
			<div id="content">
				
			</div>
			
		</div>
	</body>
</html>
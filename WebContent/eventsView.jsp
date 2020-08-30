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
					<%if(session.getAttribute("step") == "1"){ %>
						<li><a href="hotelsView2.jsp" title="Hotels">Hotels</a></li>
					<%}else if(session.getAttribute("step") == "2"){  %>
						<li><a href="hotelsView3.jsp"  title="Hotels">Hotels</a></li>
					<%}else{ %>
					<li><a href="hotelsView.jsp"  title="Hotels">Hotels</a></li>
					<%} %>
					<li><a href="restaurantsView.jsp" title="Restaurants">Restaurants</a></li>
					<li><a href="eventsView.jsp" style="color: orange;" title="Events">Events</a></li>
					<li><a href="mapView.jsp" title="Map">Map</a></li>
					
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
				
			<form>
				
				<div id="box1"  class="form-group" align="center" style="border-right-style: solid; border-right-width: thin;">
					
  						<label style="margin-top: 15px;">Which event are you looking for?</label><br>
  						<input type="text" placeholder="Muse or Joker or estival name" style="width: 400px;"><br>
  						<label style="margin-top: 30px;">Where is located the event?</label><br>
  						<input type="text" placeholder="Es: Rome"><br>
   						<label>How many people? </label>
   						<input type="text" size="5" placeholder="Es: 4" pattern="[0-9]{2}">
 					
 				</div>

 				<div id="box1" class="form-group" align="center">
					
						<label style="margin-right: 0px;">When?</label><br>
  						<input type="date" size="10" placeholder="12-34-5678" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" style="margin-right: 35px;">
  						<input type="text" size="10" placeholder="0-24h" pattern="[0-9]{2}"><br>
				

					
  						<label style="margin-top: 30px; margin-left: 10px; font-size: 25px;">Check your preference</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;">Concert</label>
  						<input type="checkbox" class="chk" style="margin-left: 50px;"/>
  						<label style="font-size: 20px ">Cinema</label><br>
  						<input type="checkbox" class="chk" style="margin-left: 37px;"/>
  						<label style="font-size: 20px;">Theatre</label>
  						<input type="checkbox" class="chk" style="margin-left: 55px;"/>
  						<label style="font-size: 20px;">Museum</label><br>
  
 				</div>
 					
 					<button class="searchButton">Search</button>
				</form>	
			
			</div>
			
		</div>
	</body>
</html>
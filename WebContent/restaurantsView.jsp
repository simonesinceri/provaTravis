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
						<li><a href="hotelsView2.jsp"  title="Hotels">Hotels</a></li>
					<%}else if(session.getAttribute("step") == "2"){  %>
						<li><a href="hotelsView3.jsp" title="Hotels">Hotels</a></li>
					<%}else{ %>
					<li><a href="hotelsView.jsp"  title="Hotels">Hotels</a></li>
					<%} %>
					<li><a href="restaurantsView.jsp" style="color: orange;" title="Restaurants">Restaurants</a></li>
					<li><a href="eventsView.jsp" title="Events">Events</a></li>
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
				<div id="box1" class="form-group" align="center" style="border-right-style: solid; border-right-width: thin;">
					
  						<label style="margin-top: 15px;">Which restaurant are you looking for?</label><br>
  						<input type="text" placeholder="Type restaurant name"><br>
  						<label style="margin-top: 30px;">Where do you wanna go?</label><br>
  						<input type="text" placeholder="Es: Rome"><br>
   						<label>How many people? </label>
   						<input type="text" size="5" placeholder="Es: 4" pattern="[0-9]{2}">
 					
 				</div>
 				
 				<div id="box2"class="form-group" align="left">
					
  						<label style="margin-top: 15px; margin-left: 130px; font-size: 25px;">Budget</label><br>
  						<input type="checkbox" class="chk" style="margin-left: 130px;" />
  						<label style="font-size: 20px; "> € - €€</label><br>
  						<input type="checkbox" class="chk" style="margin-left: 130px;"/>
  						<label style="font-size: 20px;"> €€ - €€€</label><br>
  						<input type="checkbox" class="chk" style="margin-left: 130px;"/>
  						<label style="font-size: 20px;"> €€€ - €€€€</label><br>
  						<input type="checkbox" class="chk" style="margin-left: 130px;"/>
  						<label style="font-size: 20px;"> more €€€€</label><br>
 					
 				</div>

 				<div id="box2" class="form-group" align="left">
					
  						<label style="margin-top: 15px; margin-left: 30px; font-size: 25px;">Rating</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;"> 1 star</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;"> 2 star</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;"> 3 star</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;"> 4 star</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;"> 5 star</label><br>				
 					
 				</div>

 				<div id="box2" class="form-group" align="left" style="margin-left: 120px;">
					
  						<label style="margin-top: 15px; margin-left: 0px; font-size: 25px;">Check your preference</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;">Pizza</label>
  						<input type="checkbox" class="chk" style="margin-left: 40px;"/>
  						<label style="font-size: 20px ">Sushi</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;">Fish</label>
  						<input type="checkbox" class="chk" style="margin-left: 49px;"/>
  						<label style="font-size: 20px;">Pasta</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;">Meat</label>
  						<input type="checkbox" class="chk" style="margin-left: 42px;"/>
  						<label style="font-size: 20px;">Hambrger</label><br>
  						<input type="checkbox" class="chk"/>
  						<label style="font-size: 20px;">Vegan</label>
  						<input type="checkbox" class="chk" style="margin-left: 33px;"/>
  						<label style="font-size: 20px;">Gourmet</label><br>
  						

 					
 				
 				
 				</div class="form-group">
					<button class="searchButton" style="margin-top: -10px;">Search</button>
 				</div>
 			</form>		
		</div>	
	</body>
</html>
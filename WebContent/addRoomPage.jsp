<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<li><a href="hotelsView2.jsp" title="Hotels">Hotels</a></li>
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
					
					<label style="margin-top: 5px; line-height: 45px; font-size: 35px;"> Name User</label><br>
 					<img src="account.jpg" style="height: 100px;margin-top: 0px;width: 180px;" align="middle"> <br>
 					<label style="font-size: 18px;text-decoration: underline;">Change your profile image</label><br>
 					<label style="margin-top: 10px; line-height: 45px; font-size: 30px;"> Structures:  0</label><br>
 				

 					<button class="searchButton" onclick="location.href='addStructurePage.jsp'" style="font-size: 22px; border: none;border-radius: 0px;width: 190px;height: 51px; margin-top: 10px;">Add Strucuture</button>
 					
 					<form action="Logout">
 						<input type="submit" value="Logout" style="background-color: #1B59D7; color: #ffffff;font-size: 22px; border: none;border-radius: 0px;width: 120px;height: 51px; margin-top: 15px;">
 					</form>


 				</div>

 				<div id="box1" style="width: 660px;height: 300px;margin-top: 0px;" align="center">
					
				
 					
 					<div id="box1" style="width: 660px;height: 250px;margin-top: 30px;" align="center">
 						
 						<label style="margin-top: -10px;font-size: 30px">Add Room</label><br>
 						<%if(request.getAttribute("addRoom") != "ok"){ %>
 							<form method="post" action="AddRoom" style="display: inline" >
 							
 								<label style="margin-top: 30px;margin-left: 0px;font-size: 25px">- ID-
 								</label>
 								<input name="id"style="margin-right: 10px" type="text" required name= "roomId" placeholder="Room Id"><br>
 								<label style="margin-top: 10px;margin-left: 0px;margin-right: 0px;font-size: 25px">Price</label>
 								<input name="price"style="margin-right: 10px" type="text" required name= "Price" placeholder="Es. 50(€)"><br>
 								<label style="margin-top: 10px;margin-left: 0px;font-size: 25px">Beds</label>
 								<input name="beds" style="margin-right: 10px" type="text" required name= "Beds" placeholder="Es. 4"><br>
								<input type="submit" value="Add Room" style="background-color: #1B59D7; color: #ffffff;font-size: 22px; border: none;border-radius: 0px;width: 120px;height: 51px; margin-top: 60px;margin-left: 10px;margin-right: 20px">
 							</form>
 					
 							<button class="searchButton" onclick="location.href='structPage.jsp'" style="margin-right: 10px;margin-left: 15px;width: 120px; height: 51px;font-size: 22px"> Back </button>
 						<% }else{ %>
							<form method="post" action="AddRoom" style="display: inline" >
 							
 							<label style="margin-top: 30px;margin-left: 0px;font-size: 25px">- ID-
 							</label>
 							<input name="id"style="margin-right: 10px" type="text"  name= "roomId" placeholder="Room Id"><br>
 							<label style="margin-top: 10px;margin-left: 0px;margin-right: 0px;font-size: 25px">Price</label>
 							<input name="price"style="margin-right: 10px" type="text"  name= "Price" placeholder="Es. 50(€)"><br>
 							<label style="margin-top: 10px;margin-left: 0px;font-size: 25px">Beds</label>
 							<input name="beds" style="margin-right: 10px" type="text"  name= "Beds" placeholder="Es. 4"><br>
							
 						</form>
 					
 							<button class="searchButton" onclick="location.href='structPage.jsp'" style="margin-right: 10px;margin-left: 15px;width: 120px; height: 51px;font-size: 22px"> Back </button>
 						
							<label style="margin-top: 20px;color: #24E711"> Room added </label>
						<% } %>
 				</div>
 			</div>
				
			</div>
		</div>
	</body>

</html>
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
			
				

				<div id="box1" align="center" style="border-right-style: solid; border-right-width: thin;width: 280px;margin-top: 5px;">
					
					<label style="margin-top: 5px; line-height: 45px; font-size: 35px;"> Name User</label><br>
 					<img   src="structure.jpg"  style="height: 96px;margin-top: 5px;width: 210px;"> <br>
 					<label style="font-size: 18px;text-decoration: underline;">Change your profile image</label><br>
 					<label style="margin-top: 20px; line-height: 45px; font-size: 30px;"> Booked:  0</label>
 					<label></label><br>
 					<label style="margin-top: 5px; line-height: 45px; font-size: 30px;"> Reviews: 0</label>
 					<label></label><br>
 					<label></label>
 					<button class="searchButton" style="width: 120px;height: 51px;text-align: center; margin-top: 10px;font-size: 20px"
 							onclick="location.href = 'loginView.html';">Logout</button>
 				</div>

 				<div id="box1" align="center" style="width: 660px;height: 200px;margin-top: 5px;">
					<label style="margin-top: 5px; line-height: 45px; font-size: 35px;"> Here are your experiences!</label><br>
					<img   src="structure.jpg" style="height: 95px;margin-top: 10px;margin-right: 40px;width: 120px;">
					<img   src="structure.jpg" style="height: 95px;margin-top: 5px;width: 120px;">
					<img   src="structure.jpg" style="height: 95px;margin-top: 5px;margin-left: 40px;width: 120px;"><br>
					<label style="font-size: 25px;margin-top: 5px;margin-right: 60px;text-decoration: underline;">----------1</label>
					<label style="font-size: 25px;margin-top: 5px;text-decoration: underline;margin-top: 5px;">----------2</label>
					<label style="font-size: 25px;margin-top: 5px;margin-left: 60px;text-decoration: underline;">----------3</label>
					<br>
					<img   src="structure.jpg" style="height: 95px;margin-top: 0px;margin-right: 40px;width: 120px;">
					<img   src="structure.jpg" style="height: 95px;margin-top: 0px;width: 120px;">
					<img   src="structure.jpg" style="height: 95px;margin-top: 0spx;margin-left: 40px;width: 120px;"><br>
					<label style="font-size: 25px;margin-top: 5px;margin-right: 60px;text-decoration: underline;">----------4</label>
					<label style="font-size: 25px;margin-top: 5px;text-decoration: underline;">----------5</label>
					<label style="font-size: 25px;margin-top: 5px;margin-left: 60px;text-decoration: underline;">----------6</label>
					<br>
 					
 					<button class="searchButton" style="font-size: 20px;height: 51px;;width: 51px; margin-top: 10px;"
 							onclick=""> < </button>
 					<label style="font-size: 20px;margin-top: 0px;margin-left: 5px;margin-right: 5px;"> 1 </label>
 					<button class="searchButton" style="font-size: 20px;width: 51px; margin-top: 10px;height: 51px;"
 							onclick=""> > </button>
 				</div>
				
			

			</div>
			
		
		</div>
	</body>
</html>
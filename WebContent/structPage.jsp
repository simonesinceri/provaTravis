<%@page import="web_2.logic.model.Hotel"%>
<%@page import="web_2.logic.bean.LoginBeanWeb"%>
<%@page import="web_2.logic.model.OwnerWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%	Hotel struct = (Hotel)session.getAttribute("struct");
	OwnerWeb loggato = (OwnerWeb)session.getAttribute("ownerLog");
	LoginBeanWeb beanLog = (LoginBeanWeb)session.getAttribute("beanLog");%>

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
						<li><a href="hotelsView2.jsp"  title="Hotels">Hotels</a></li>
					<%}else if(session.getAttribute("step") == "2"){  %>
						<li><a href="hotelsView3.jsp"  title="Hotels">Hotels</a></li>
					<%}else{ %>
					<li><a href="hotelsView.jsp" title="Hotels">Hotels</a></li>
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
					
					<label style="margin-top: 5px; line-height: 45px; font-size: 35px;"> <% out.print(loggato.getUsername()); %> </label><br>
 					<img src="account.jpg" style="height: 100px;margin-top: 0px;width: 180px;" align="middle"> <br>
 					<label style="font-size: 18px;text-decoration: underline;">Change your profile image</label><br>
 					<label style="margin-top: 10px; line-height: 45px; font-size: 30px;"> Structures: <% out.print(beanLog.getStructures()); %></label><br>
 				

 					<button class="searchButton" onclick="location.href='addStructurePage.jsp'" style="font-size: 22px; border: none;border-radius: 0px;width: 190px;height: 51px; margin-top: 10px;">Add Strucuture</button>
 					
 					<form action="Logout">
 						<input type="submit" value="Logout" style="background-color: #1B59D7; color: #ffffff;font-size: 22px; border: none;border-radius: 0px;width: 120px;height: 51px; margin-top: 15px;">
 					</form>


 				</div>

 				<div id="box1" style="width: 660px;height: 300px;margin-top: 0px;" align="center">
					
				
 					
 					<div id="box1" style="width: 600px;height: 150px;margin-top: 30px;" align="center">
 						<img src="structure.jpg" style="float: left;height: 120px;margin-top: 5px;margin-left: 55px;width: 150px;">
 						<label style="margin-top: -10px;font-size: 30px"><% out.print(struct.getName()); %></label><br>
 						<label style="margin-top: 40px;margin-left: 5px;font-size: 25px">Rooms number:  <% out.print(session.getAttribute("roomsNumb")); %></label>
 						<button onclick="location.href='addRoomPage.jsp'" style="background-color: #1B59D7; color: #ffffff;font-size: 21px; border: none;border-radius: 0px;width: 165px;height: 51px; margin-top: 10px;margin-left: 0px"> Add Room </button>
 					</div>

 					<div id="box1" style="width: 600px;height: 150px;margin-top: 0px;" align="center">
 						
 						<button onclick="location.href='addStrDescr.jsp'" style="background-color: #1B59D7; color: #ffffff;font-size: 21px; border: none;border-radius: 0px;width: 165px;height: 51px; margin-top: 5px;margin-left: 15px"> Add Description </button>
 						<form  method="get" action="StructReview" style="display: inline">
 						<input type="submit"  style="background-color: #1B59D7; color: #ffffff;font-size: 21px; border: none;border-radius: 0px;width: 165px;height: 51px; margin-top: 5px;margin-left: 20px" value="View Reviews">
 						</form>
 						<button style="background-color: #1B59D7; color: #ffffff;font-size: 21px; border: none;border-radius: 0px;width: 165px;height: 51px; margin-top: 5px;margin-left: 20px"> Open Agenda </button>
 						<p style="font-size: 21px"></p>
						<button class="searchButton" onclick="location.href='ownerPage.jsp'" style="margin-left: 15px;margin-top: 81px;width: 120px; height: 51px;font-size: 22px"> Back </button>

 					</div>

 				</div>
			</div>
		</div>
	</body>
</html>
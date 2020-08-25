<%@page import="web_2.logic.model.Experience"%>
<%@page import="web_2.logic.bean.LoginBeanWeb"%>
<%@page import="web_2.logic.model.UserWeb"%>
<%@page import="web_2.logic.model.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% Review review = (Review)request.getAttribute("reviewExp"); 
 UserWeb loggato = (UserWeb)session.getAttribute("userLog"); 
LoginBeanWeb beanLog = (LoginBeanWeb)session.getAttribute("beanLog");%>

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
					<%if(session.getAttribute("userLog") == null){ %>
						<li><a href="profileView.jsp"  title="Profile">Profile</a></li>
					<%}else{ %>
						<li><a href="profilePage2.jsp"  title="Profile">Profile</a></li>
					<% } %>
					
				</ul>
				
			</div>
			
			<div id="content" align="center">				
			
				

				<div id="box1" align="center" style="border-right-style: solid; border-right-width: thin;width: 280px;margin-top: 5px;">
					
					<label style="margin-top: 5px; line-height: 45px; font-size: 35px;"> <% out.print(loggato.getUsername()); %> </label><br>
 					<img   src="ping.jpg" style="height: 96px;margin-top: 5px;width: 210px;"> <br>
 					<label style="font-size: 18px;text-decoration: underline;">Change your profile image</label><br>
 					<label style="margin-top: 20px; line-height: 45px; font-size: 30px;"> Booked:   <% out.print(beanLog.getBooked()); %></label>
 					<label></label><br>
 					<label style="margin-top: 5px; line-height: 45px; font-size: 30px;"> Reviews: <% out.print(beanLog.getReview()); %></label>
 					<label></label><br>
 					
 					<form action="Logout">
 						<input type="submit" value="Logout" style="background-color: #1B59D7; color: #ffffff;font-size: 25px; border: none;border-radius: 0px;width: 130px;height: 51px; margin-top: 10px;" >
 					</form>
 				</div>

 				<div id="box1" align="center" style="width: 660px;height: 200px;margin-top: 5px;">               <!-- problemm!! -->
					<label style="margin-top: 15px; line-height: 45px; font-size: 35px;"> View your review of "<%out.print(((Experience)session.getAttribute("exp")).getName());%>" </label><br>
					<label style="margin-top: 10px; line-height: 45px; font-size: 30px;"> Vote: <%out.print(((Experience)session.getAttribute("exp")).getRating());%> star/s </label><br>
					
						<textarea style="resize: none;resize: none;width: 500px;height: 150px;font-size: 25px;margin-top: 10px"> <%out.print(review.getReview());%> </textarea><br>
					
 					
					<button class="searchButton" style="font-size: 20px; margin-top: 50px;margin-left: 0px;height: 51px;width: 100px;"
 							onclick="location.href='profilePage2.jsp'"> Back </button>
 				
 				</div>
				
			

			</div>
			
		
		</div>
	</body>
</html>
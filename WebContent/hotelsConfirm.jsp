<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% web_2.logic.bean.HotelBeanWeb bean =(web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean"); %>

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
						<li><a href="hotelsView.jsp" style="color: orange;" title="Hotels">Hotels</a></li>
						<li><a href="restaurantsView.jsp" title="Restaurants">Restaurants</a></li>
						<li><a href="eventsView.jsp" title="Events">Events</a></li>
						<li><a href="mapView..jsp" title="Map">Map</a></li>
						<li><a href="profileView.jsp" title="Profile">Profile</a></li>
					</ul>
				
				</div>

			<div id="content" align="center">
				<!-- box info hotel  -->
				<div id="box3"  align="center" style="margin-left: 101px;margin-top: 20px; height: 300px">
				  	
				 		<label style=";margin-right: 20px;margin-top: 10px"> Confirm the booking at:  </label>
				 		<label style=";margin-right: 90px;margin-top: 10px"> "<%
				 			out.print(bean.getBookHotel().getName());%>" </label><br>
				 		<label style= "margin-right: 90px;margin-top: 25px"> Check In </label>
				 		<label style="margin-top: 25px;margin-right: 80px"> Check Out </label><br>
				 		<label style= "margin-right: 70px;margin-top: 25px"> <%out.print(bean.getLocalDateIn());%> </label>
				 		<label style="margin-top: 25px;margin-right: 90px"> <%out.print(bean.getLocalDateOut());%> </label><br>
				 		<label style= "margin-top: 25px;margin-right: 10px"> Number of Guests: </label>
				 		<label style="margin-right: 90px;margin-top: 25px"> <%out.print(bean.getNumPeople());%> </label><br>
				 		<label style= "margin-top: 25px;margin-right: 10px"> Total Price: </label>
				 		<label style= "margin-top: 25px;margin-right: 90px"> <%out.print((bean.getBookRoom().getPrice())*(bean.getDays()));%>€ </label><br>
				 		
				 		<%if((session.getAttribute("bookCheck")) == "ok"){ %>
				 			<label style= "margin-top: 15px;margin-right: 90px;color:#24E711 ">Excellent, your booking has been accepted! </label>
						<% } %>
						<%if((session.getAttribute("bookCheck")) == "no"){ %>
				 			<label style= "margin-top: 15px;margin-right: 90px;color: #F80000 ">Try again, your booking was unsuccessful! </label>
						<% } %>
				</div>

			
				<!-- button -->
			
				<div id="box3"  align="center" style="margin-left: 55px;margin-top: 5px; height: 55px;">
					<form method="post" action="BookHotel">
						<%if((session.getAttribute("bookCheck")) != "ok"){ %>
							<button class="searchButton"  onclick="location.href='hotelsView3.jsp'" style="width: 120px; height: 51px;font-size: 20px;margin-right: 15px"> Undo </button>
						<% }else{%>
					
							<button class="searchButton"  onclick="location.href='hotelsView.jsp'" style="width: 120px; height: 51px;font-size: 20px;margin-right: 15px"> Undo </button>
						<% } %>
					
						<%if((session.getAttribute("bookCheck")) != "ok"){ %>
						
								<input style="width: 120px;text-aling: center; height: 51px;background-color: #1B59D7; color: #ffffff;font-size: 20px; border: none;border-radius: 0px;margin-left: -0px;" type="submit" value="Confirm">
						
						<%	} %>
					</form>
				</div>
			</div>

			
		</div>
	</body>
</html>
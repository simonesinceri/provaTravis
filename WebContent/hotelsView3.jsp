<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% web_2.logic.bean.HotelBeanWeb bean =(web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean"); %>  
    
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>FindIt</title>
		<link href="htmlCss.css" rel="stylesheet" type="text/css">
	</head>
	
	<!--  si potrebbe dichiara qui sopra la bean e fare pulizia nel codice
	      eliminadno le righe di codice molto lunghe-->
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
				<div id="box3"  align="left" style="margin-left: 80px;margin-top: 20px; height: 160px">
				  	<img  id= "imgHotel" src="structure.jpg" style="width: 200px; height: 162px"> 
				 		<label style="margin-left: 10px;"> <%
 	out.print(bean.getBookHotel().getName());
 %> </label><br>
				 		<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getBookHotel().getAddress());
 %> </label>
				 		<label style="margin-left: 10px;margin-left: 320px;font-size: 20px;text-decoration: underline"> View reviews </label><br>
				 		<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getBookHotel().getRating());
 %> stars </label><br>
				 		<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getBookRoom().getPrice());
 %>€ for night</label>
				</div>

				<!-- box  hotel description    devo mettere text area per la descrizione dato che non so lunghezza-->
				<div id="box3"  align="center" style="margin-left: 50px;height: 130px">
					<label style=" font-size: 20px"> breve descrizione hotel </label>
				</div>
			
				<!-- button -->
			
				<div id="box3"  align="center" style="margin-left: 55px;margin-top: 5px; height: 55px;">
					
					
						<button class="searchButton" onclick="location.href='hotelsView2.jsp'" style="float: left;width: 86px; height: 51px;font-size: 20px;margin-left: 310px"> Undo </button>
					
					<% if((session.getAttribute("userLog")) != null) {%>
						<form action="hotelsConfirm.jsp">
							<input style="width: 86px;text-aling: center; height: 51px;background-color: #1B59D7; color: #ffffff;font-size: 20px; border: none;border-radius: 0px;margin-left: -280px;" type="submit" value="Book">
						</form>
						
					<%}else{ %>
							<form action="loginReservation.jsp">
								<input style="width: 86px;text-aling: center; height: 51px;background-color: #1B59D7; color: #ffffff;font-size: 20px; border: none;border-radius: 0px;margin-left: -280px;" type="submit" value="Book">
							</form>
					<%} %>
				</div>
			</div>

			
		</div>
	</body>
</html>
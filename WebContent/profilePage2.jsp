<%@page import="web_2.logic.model.Experience"%>
<%@page import="web_2.logic.bean.LoginBeanWeb"%>
<%@page import="web_2.logic.model.UserWeb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- se owmer devo veificare quale dei due è nullo e usare l'altro

		o faccio 2 pagine separate utente/owner -->
<% UserWeb loggato = (UserWeb)session.getAttribute("userLog"); 
LoginBeanWeb beanLog = (LoginBeanWeb)session.getAttribute("beanLog");
 java.util.ArrayList<Experience> listExp = beanLog.getExpList();
 //giochiamo con la lunghezzza della list
 int len = listExp.size();%>

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
					<%if(session.getAttribute("userLog") != null){ %>
							
							<li><a href="profilePage2.jsp"  title="Profile">Profile</a></li>
					<%}else{ %>
							<li><a href="profileView.jsp"  title="Profile">Profile</a></li>
					<% } %>
				</ul>
				
			</div>
			
			<div id="content" align="center">				
			
				<!-- metodo change experience per prendere dati per popopolare questa view -->

				<div id="box1" align="center" style="border-right-style: solid; border-right-width: thin;width: 280px;margin-top: 5px;">
					
					<label style="margin-top: 5px; line-height: 45px; font-size: 35px;"> <% out.print(loggato.getUsername()); %> </label><br>
 					
 						<img   src="ping.jpg"  style="height: 96px;margin-top: 5px;width: 210px;"> <br>
 					
 					<form >
 						<input type="submit" style="border-radius: 15px;
	background-color: #ffffff;color: #000000;
	border-style: none;
	margin-top: 0px;font-size: 18px;text-decoration: underline;"value="Change your profile image"><br>
 					</form>
 					<label style="margin-top: 20px; line-height: 45px; font-size: 30px;"> Booked:  <% out.print(beanLog.getBooked()); %></label>
 					<label></label><br>
 					<label style="margin-top: 5px; line-height: 45px; font-size: 30px;"> Reviews: <% out.print(beanLog.getReview()); %></label>
 					<label></label><br>
 					<form action="Logout">
 						<input type="submit" value="Logout" style="background-color: #1B59D7; color: #ffffff;font-size: 25px; border: none;border-radius: 0px;width: 130px;height: 51px; margin-top: 25px;" >
 					</form>
 				</div>												
						
 				<!--  box con experience -->
 				<div id="box1" align="center" style="width: 660px;height: 300px;margin-top: 5px;">
					<%if(len < 1){ %>	
						<label style="float: left;margin-left: 185px; font-size:30px"> No experiences to view</label>
					<% } %>
						<div id="box1" align="center" style="width: 220px;height: 300px;">
 							
 							<%if(len >= 1){ %>
 								<img   src="structure.jpg"  style="float: left;height: 95px;margin-top: 5px;margin-left: 55px;width: 120px;"><br>
								<form action="ManageExp1"  >
									<input  type="submit"  style="border-radius: 15px;
	background-color: #ffffff;color: #000000;
	border-style: none;
	margin-top: 5px;font-size: 20px;margin-left: 0px;text-decoration: underline;"value="<% out.print(listExp.get(0).getName()); %>">
								</form>
							<% } %>
							
							<%if(len >= 4){ %>
								<img   src="structure.jpg"  style="float: left;height: 95px;margin-top: 5px;margin-left: 55px;width: 120px;"><br>
								<form action="ManageExp4">
									<input type="submit"  style="border-radius: 15px;
	background-color: #ffffff;color: #000000;
	border-style: none;
	margin-top: 5px;font-size: 20px;margin-left: 0px;text-decoration: underline;"value="<% out.print(listExp.get(3).getName()); %>">
								</form>
							<%} %>
						</div>

 					<div id="box1" align="center" style="width: 220px;height: 300px;">
 						<%if(len >= 2){ %>	
 							<img   src="structure.jpg"  style="float: left;height: 95px;margin-top: 5px;margin-left: 55px;width: 120px;"><br>
							<form action="ManageExp2">
								<input type="submit"  style="border-radius: 15px;
	background-color: #ffffff;color: #000000;
	border-style: none;
	margin-top: 5px;font-size: 20px;margin-left: 0px;text-decoration: underline;"value="<% out.print(listExp.get(1).getName()); %>">
							</form>
						<% } %>
						<%if(len >= 5){ %>	
							<img   src="structure.jpg"  style="float: left;height: 95px;margin-top: 5px;margin-left: 55px;width: 120px;"><br>
							<form action="ManageExp5"  >
								<input type="submit"  style="border-radius: 15px;
	background-color: #ffffff;color: #000000;
	border-style: none;
	margin-top: 5px;font-size: 20px;margin-left: 0px;text-decoration: underline;"value="<% out.print(listExp.get(4).getName()); %>">
							</form>	
						<% } %>
 					</div>

 					<div id="box1" align="center" style="width: 220px;height: 300px;">
 						<%if(len >= 3){ %>
 							<img   src="structure.jpg"  style="float: left;height: 95px;margin-top: 5px;margin-left: 55px;width: 120px;"><br>
							<form action="ManageExp3">
								<input type="submit"  style="border-radius: 15px;
	background-color: #ffffff;color: #000000;
	border-style: none;
	margin-top: 5px;font-size: 20px;margin-left: 0px;text-decoration: underline;"value="<% out.print(listExp.get(2).getName()); %>">
							</form>
						<% } %>
						<%if(len >= 6){ %>
							<img   src="structure.jpg"  style="float: left;height: 95px;margin-top: 5px;margin-left: 55px;width: 120px;"><br>
							<form action="ManageExp6">
								<input type="submit"  style="border-radius: 15px;
	background-color: #ffffff;color: #000000;
	border-style: none;
	margin-top: 5px;font-size: 20px;margin-left: 0px;text-decoration: underline;"value="<% out.print(listExp.get(5).getName()); %>">
							</form>
						<%} %>
 					</div>
			
					<br>
					
 					<%if(len > 0){%>
 						
 						<form method="get" action="PreExperience">
							<input style="background-color: #1B59D7;margin-left : 238px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value="<">
						</form>
 						
 						<form method="get" action="NextExperience">
							<input style="background-color: #1B59D7;margin-left : 20px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value=">">
						</form>	
 					<%}else{%>
 						<form method="get" action="PreExperience">
							<input style="background-color: #1B59D7;margin-top: -50px;margin-left : 238px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value="<">
						</form>
 						
 						<form method="get" action="NextExperience">
							<input style="background-color: #1B59D7;margin-top: -50px;margin-left : 20px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value=">">
						</form>	
 					<% }%>
 						
 				</div>
				
			

			</div>
			
		
		</div>
	</body>
</html>
<%@page import="web_2.logic.model.Review"%>
<%@page import="web_2.logic.bean.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% ReviewBean reviewBean = (ReviewBean)session.getAttribute("reviewBean");
	java.util.ArrayList<Review> listReview = reviewBean.getReviewList();%>

<!DOCTYPE html>
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
				<!-- box hotel 1 -->
				<div id="box3"  align="left" style="margin-left: 101px;width: 280px;">
				  		<%if(listReview.get(0).getUser() != null){ %>
				 			<label style="margin-left: 10px;text-decoration: underline;"> <% out.print(listReview.get(0).getUser()); %> </label><br>
				 			<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <% out.print(listReview.get(0).getVote()); %> stars  </label>
						<%}else{ %>
							<label style="margin-left: 10px;text-decoration: underline;"> Reviews not found! </label><br>
						<%} %>
				</div>

				<div id="box3"  align="left" style="width: 500px;margin-left: 0px">
					<%if(listReview.get(0).getUser() != null){ %>
						<p style="font-size: 20px; margin-top: 0px;margin-left: 0px "> <% out.print(listReview.get(0).getReview()); %></p>
					<%} %>
				</div>

			<!-- box hotel 2 -->
				<div id="box3"  align="left" style="margin-left: 101px;width: 280px;">
				  		<%if(listReview.get(1).getUser() != null){ %>
				 			<label style="margin-left: 10px;text-decoration: underline;"> <% out.print(listReview.get(1).getUser()); %> </label><br>
				 			<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <% out.print(listReview.get(1).getVote()); %> stars </label>
				 			<%} %>
				</div>

				<div id="box3"  align="left" style="width: 500px;margin-left: 0px">
					<%if(listReview.get(1).getUser() != null){ %>
						<p style="font-size: 20px; margin-top: 0px;margin-left: 0px "> <% out.print(listReview.get(1).getReview()); %> </p>
					<%} %>	
				</div>

			<!-- box hotel 3 -->
				<div id="box3"  align="left" style="margin-left: 101px;width: 280px;">
				 		<%if(listReview.get(2).getUser() != null){ %>
				 			<label style="margin-left: 10px;text-decoration: underline;"> <% out.print(listReview.get(2).getUser()); %> </label><br>
				 			<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <% out.print(listReview.get(2).getVote()); %> stars </label>
						<%} %>
				</div>

				<div id="box3"  align="left" style="width: 500px;margin-left: 0px">
					<%if(listReview.get(2).getUser() != null){ %>
						<p style="font-size: 20px; margin-top: 0px;margin-left: 0px "> <% out.print(listReview.get(2).getReview()); %></p>
					<%} %>
				</div>

				<!-- button -->
			
				<div id="box3"  align="left" style="margin-left: 101px;margin-top: 5px;height: 55px">
					<button class="searchButton" onclick="location.href='hotelsView3.jsp'" style="float: left;width: 118px; height: 51px;font-size: 20px"> << back </button>
					<%if(reviewBean.getIndex() > 4){ %>
						<form method="GET" action="PrePageReview">
							<input style="background-color: #1B59D7;margin-left : 238px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value="<">
						</form>
					<%} else{ %>
						<input style="background-color: #1B59D7;margin-left : 238px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value="<">
					<% } %>
					
					<%if(listReview.get(2).getUser() != null){ %>
						<form method="GET" action="NextPageReview">
							<input style="background-color: #1B59D7;margin-left : 20px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value=">">
						</form>	
					<%} else{ %>
						<input style="background-color: #1B59D7;margin-left : 20px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value=">">
					<% } %>
				
					
					
					
				</div>
			</div>

			
		</div>
	</body>
</html>
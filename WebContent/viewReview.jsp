<%@page import="logic.model.Review"%>
<%@page import="logic.bean.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% ReviewBean reviewBean = (ReviewBean)session.getAttribute("reviewBean");
	java.util.List<Review> listReview = reviewBean.getReviewList();%>

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
						<%if(session.getAttribute("step") == "1"){ %>
							<li><a href="hotelsView2.jsp" style="color: orange;" title="Hotels">Hotels</a></li>
						<%}else if(session.getAttribute("step") == "2"){  %>
							<li><a href="hotelsView3.jsp" style="color: orange;" title="Hotels">Hotels</a></li>
						<%}else{ %>
							<li><a href="hotelsView.jsp" style="color: orange;" title="Hotels">Hotels</a></li>
						<%} %>
						<li><a href="restaurantsView.jsp" title="Restaurants">Restaurants</a></li>
						<li><a href="eventsView.jsp" title="Events">Events</a></li>
						<li><a href="mapView..jsp" title="Map">Map</a></li>
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
				<!-- box hotel 1 -->
				<div id="box3"  align="left" style="margin-left: 101px;width: 280px;">
				  		<%if(listReview.get(0).getReviewUser() != null){ %>
				 			<label style="margin-left: 10px;text-decoration: underline;"> <% out.print(listReview.get(0).getReviewUser()); %> </label><br>
				 			<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <% out.print(listReview.get(0).getReviewVote()); %> stars  </label>
						<%}else{ %>
							<label style="margin-left: 10px;text-decoration: underline;"> Reviews not found! </label><br>
						<%} %>
				</div>

				<div id="box3"  align="left" style="width: 500px;margin-left: 0px">
					<%if(listReview.get(0).getReviewUser() != null){ %>
						<p style="font-size: 20px; margin-top: 0px;margin-left: 0px "> <% out.print(listReview.get(0).getReviewText()); %></p>
					<%} %>
				</div>

			<!-- box hotel 2 -->
				<div id="box3"  align="left" style="margin-left: 101px;width: 280px;">
				  		<%if(listReview.get(1).getReviewUser() != null){ %>
				 			<label style="margin-left: 10px;text-decoration: underline;"> <% out.print(listReview.get(1).getReviewUser()); %> </label><br>
				 			<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <% out.print(listReview.get(1).getReviewVote()); %> stars </label>
				 			<%} %>
				</div>

				<div id="box3"  align="left" style="width: 500px;margin-left: 0px">
					<%if(listReview.get(1).getReviewUser() != null){ %>
						<p style="font-size: 20px; margin-top: 0px;margin-left: 0px "> <% out.print(listReview.get(1).getReviewText()); %> </p>
					<%} %>	
				</div>

			<!-- box hotel 3 -->
				<div id="box3"  align="left" style="margin-left: 101px;width: 280px;">
				 		<%if(listReview.get(2).getReviewUser() != null){ %>
				 			<label style="margin-left: 10px;text-decoration: underline;"> <% out.print(listReview.get(2).getReviewUser()); %> </label><br>
				 			<label style="margin-top : 10px; margin-left: 10px; font-size: 20px"> <% out.print(listReview.get(2).getReviewVote()); %> stars </label>
						<%} %>
				</div>

				<div id="box3"  align="left" style="width: 500px;margin-left: 0px">
					<%if(listReview.get(2).getReviewUser() != null){ %>
						<p style="font-size: 20px; margin-top: 0px;margin-left: 0px "> <% out.print(listReview.get(2).getReviewText()); %></p>
					<%} %>
				</div>

				<!-- button -->
			
				<div id="box3"  align="left" style="margin-left: 101px;margin-top: 5px;height: 55px">
					<%if(session.getAttribute("type") == "1"){ %>
						<button class="searchButton" onclick="location.href='hotelsView3.jsp'" style="float: left;width: 118px; height: 51px;font-size: 20px"> << back </button>
					<%}else if(session.getAttribute("type") == "2"){ %>
						<button class="searchButton" onclick="location.href='structPage.jsp'" style="float: left;width: 118px; height: 51px;font-size: 20px"> << back </button>
					<% } %>
					
					<%if(reviewBean.getIndex() > 4){ %>
						<form method="GET" action="PrePageReview">
							<input style="background-color: #1B59D7;margin-left : 238px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value="<">
						</form>
					<%} else{ %>
						<input style="background-color: #1B59D7;margin-left : 238px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value="<">
					<% } %>
					
					<%if(listReview.get(2).getReviewUser() != null){ %>
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
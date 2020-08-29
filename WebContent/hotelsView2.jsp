<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id = "beanSearchHotel" scope="session" class = "web_2.logic.bean.HotelBeanWeb" /> 

<jsp:setProperty name="beanSearchHotel" property="*"/>
<% web_2.logic.bean.HotelBeanWeb bean =(web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean"); %>
       
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
				<!-- box hotel 1  <label style="margin-left: 10px;"out.print(((web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean")).getHotel1().getName());());%> </label>  -->
				<div id="box3"  align="left" style="margin-left: 101px;">
				  	<img  id= "imgHotel" src="structure.jpg" style="width : 171px; height: 96px"> 
				 <!--  <a href="hotelsView3.jsp" style="text-decoration: none;color: #000000;font-size: 25px;margin-left: 10px;" title="hotel1out.print(((web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean")).getHotel1().getName());());%></a> -->		
				 	<form method="get" action="FirstHotelPage">	
				 		
				 		<%
					 						 			if(bean.getHotel1().getName() != null ) {
					 						 		%>
				 				<input type="submit" style="width: 300px; height: 30px;margin-top: 0px;text-align: left;font-size: 25px;border-radius: 0px;background-color: #ffffff;color: #000000;text-decoration: underline" value ="<%out.print(bean.getHotel1().getName());%>">	
			 					<label style="margin-left: 420px;font-size: 20px">  <%
  	out.print(bean.getRoom1().getPrice());
  %> € for night </label><label style="margin-left: 40px;font-size: 20px"><%out.print(bean.getRoom1().getBeds()); %> beds </label><br>
				 				<label style="margin-top : -30px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getHotel1().getAddress());
 %> </label><br>
				 				<label style="margin-top : 5px; margin-left: 10px; font-size: 20px">  <%
  	out.print(bean.getHotel1().getRating());
  %> stars </label>
			 			<%
			 				} else {
			 			%>
			 					<label style="margin-left: 10px;margin-top: 5px;font-size: 25px"> Hotel not found!</label><br>
			 					
			 				<%
			 								 					}
			 								 				%>
				 		
			 		</form>
				 		
				</div>

			<!-- box hotel 2 -->
				<div id="box3"  align="left" style="margin-left: 101px;">
				  	<img  id= "imgHotel" src="structure.jpg" style="width : 171px; height: 96px"> 
				 	<!--	<a href="" style="margin-left: 10px;font-size: 25px;"out.print(((web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean")).getHotel2().getName());());%>  </a> -->
				 	
				 	<form method="get" action="SecondHotelPage">	
				 		
				 		<%
					 						 			if(bean.getHotel2().getName() != null) {
					 						 		%>
				 				<input type="submit" style="width: 300px; height: 30px;margin-top: 0px;text-align: left;font-size: 25px;border-radius: 0px;background-color: #ffffff;color: #000000;text-decoration: underline" value ="<%out.print(bean.getHotel2().getName());%>">	
			 					<label style="margin-left: 420px;font-size: 20px"> <%
 	out.print(bean.getRoom2().getPrice());
 %> € for night</label><label style="margin-left: 40px;font-size: 20px"><%out.print(bean.getRoom2().getBeds()); %> beds </label><br>
				 				<label style="margin-top : -30px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getHotel2().getAddress());
 %>  </label><br>
				 				<label style="margin-top : 5px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getHotel2().getRating());
 %> stars  </label>
			 			<%
			 				} else {
			 			%>
			 						<label style="margin-left: 10px;margin-top: 5px;font-size: 25px"> Hotel not found!</label><br>
			 				<%
			 					}
			 				%>
				 		
			 		</form>
			 			
				 		
				</div>

			<!-- box hotel 3 -->
				<div id="box3"  align="left" style="margin-left: 101px;">
				  	<img  id= "imgHotel" src="structure.jpg" style="width : 171px; height: 96px"> 
				 	<!--	<a href="" style="margin-left: 10px;font-size: 25px;"out.print(((web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean")).getHotel3().getName());());%> </a> -->
				 		
				 		<form method="get" action="ThirdHotelPage">	
				 			
				 			<%
					 							 				if(bean.getHotel3().getName() != null) {
					 							 			%>
				 					<input type="submit" style="width: 300px; height: 30px;margin-top: 0px;text-align: left;font-size: 25px;border-radius: 0px;background-color: #ffffff;color: #000000;text-decoration: underline" value ="<%out.print(bean.getHotel3().getName());%>">	
			 						<label style="margin-left: 420px;font-size: 20px"> <%
 	out.print(bean.getRoom3().getPrice());
 %> € for night</label><label style="margin-left: 40px;font-size: 20px"><%out.print(bean.getRoom3().getBeds()); %> beds </label><br>
				 					<label style="margin-top : -30px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getHotel3().getAddress());
 %> </label><br>
				 					<label style="margin-top : 5px; margin-left: 10px; font-size: 20px"> <%
 	out.print(bean.getHotel3().getRating());
 %> stars  </label>
			 				<%} else { %>
			 						<label style="margin-left: 10px;margin-top: 5px;font-size: 25px"> Hotel not found!</label><br>
		 						
		 						<% } %>
			 			</form>
				 		
				 		
				</div>

				<!-- button -->
			
				<div id="box3"  align="left" style="margin-left: 101px;margin-top: 5px;height: 55px">
						
					<button class="searchButton" onclick="location.href='hotelsView.jsp'" style="float: left;width: 118px; height: 51px;font-size: 20px"> back </button>
					<form method="GET" action="prePage">
						<input style="background-color: #1B59D7;margin-left : 238px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value="<">
					</form>
					<form method="GET" action="nextPage">
						<input style="background-color: #1B59D7;margin-left : 20px; color: #ffffff;font-size: 20px; height: 51px;width: 50px; border: none;border-radius: 0px;float: left;" type="submit" value=">">
					</form>	
						<br><br>
						<label style="margin-top : 0px; margin-left: 412px; font-size: 15px"> 1 </label>
					
				</div>
			</div>

			
		</div>
	</body>
</html>
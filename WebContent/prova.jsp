<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
 <!-- dichiarazione e settagio della bean  -->  
<jsp:useBean id = "beanSearchHotel" scope="session" class = "web_2.logic.bean.HotelBeanWeb" /> 
<jsp:setProperty name="beanSearchHotel" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>prova jsp</title>
</head>
<body>
	<h1>Prova  : <%
		out.print(beanSearchHotel.getCity());
	%> </h1>
	
	
	
	<h1>Prova bean  : <%
					out.print(((web_2.logic.bean.HotelBeanWeb)session.getAttribute("bean")).getHotel1().getName());
				%></h1>


<!--  	<h1> prova check box:  <%boolean park = request.getParameter("checkParking") != null; if(park){out.print("parking");} %></h1> -->
</body>
</html>
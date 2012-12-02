<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="mrs.database.Actors"%>
    <%@ page import="mrs.database.Movies"%>
    <%@ page import="mrs.database.Language"%> 
    <%@ page import="org.hibernate.mapping.Map"%>

<%@ page import="com.mongodb.BasicDBList"%>
<%@ page import="com.mongodb.BasicDBObject"%>
<%@ page import="com.mongodb.DB"%>
<%@ page import="com.mongodb.DBCollection"%>
<%@ page import="com.mongodb.DBCursor"%>
<%@ page import="com.mongodb.DBObject"%>
<%@ page import="com.mongodb.Mongo"%>   
    <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/displaytag.css" type="text/css"/>  
<link rel="icon" href="css/a.png" type="image/png" />
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>

<%
request.setAttribute( "Movies", session.getAttribute("moviesList") ); 
request.setAttribute( "mid", session.getAttribute("mid") );
%> 

<table width="100%">
<tr>
<td width="60%">
<c:forEach var="item" items="${Movies}">	
	<c:if test="${item.mid == mid}" > 	
		<display:table name="${item.actors}" class='dataTable' style="width:60%" pagesize="30"> 	 	
 	 	<display:column property="fullname" sortable="true"  paramId="actor" href="Search" paramProperty="fullname"/> 	 	 	
 	</display:table>
 	
 	<display:table name="${item.languages}" class='dataTable' style="width:60%" pagesize="30"> 	 	
 	 	<display:column property="language" sortable="true"  paramId="language" href="Search" paramProperty="language"/> 	 	 	
 	</display:table>
 	
 	<display:table name="${item.genres}" class='dataTable' style="width:60%" pagesize="30"> 	 	
 	 	<display:column property="genre" sortable="true" /> 	 	 	
 	</display:table>
 	</c:if>
 </c:forEach>
 
</td>

<td width="40%">

<% if(request.getSession().getAttribute("user") != null) {%>
<jsp:include page="reviewRating.jsp"></jsp:include>
<%} %>
</td>
</tr>
</table>

 
 
 


 
  




	
	



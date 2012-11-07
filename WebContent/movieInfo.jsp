<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="mrs.database.Actors"%>
    <%@ page import="mrs.database.Movies"%>
    <%@ page import="mrs.database.Language"%>    
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

<% request.setAttribute( "Movies", session.getAttribute("moviesList") ); %> 
<% request.setAttribute( "mid", request.getParameter("mid") ); %> 


<c:forEach var="item" items="${Movies}">	
	<c:if test="${item.mid == mid}" > 	
	<table style="width:40%" class="dataTable">
	<thead>
		<tr>			
			<th class="sortable">Full Name</th>
		</tr>		
	</thead>
	<tbody>
	
<c:forEach var="actors" items="${item.actors}"> 
 	 	<tr class="odd">
 	 	<td><a href="Search?actor=${actors.fullname}">"${actors.fullname}"</a></td>
 	 	</tr>
	</c:forEach>
	
	</tbody>
	</table>
	<table style="width:40%" class="dataTable">
	<thead>
		<tr>
			
			<th class="sortable">Language</th>
			
		</tr>		
	</thead>
	<tbody>
	<c:forEach var="languages" items="${item.languages}"> 
 	 	<tr class="odd">
 	 	<td><a href="Search?language=${languages.language}">"${languages.language}"</a></td>
 	 	</tr>
	</c:forEach>
	
	</tbody>
	</table>
	<table style="width:40%" class="dataTable">
	<thead>
		<tr>
			
			<th class="sortable">Genre</th>
			
		</tr>		
	</thead>
	<tbody>
	<c:forEach var="genres" items="${item.genres}"> 
 	 	<tr class="odd">
 	 	<td><a href="Search?genre=${genres.genre}">"${genres.genre}"</a></td>
 	 	</tr>
	</c:forEach>
	
	</tbody>
	</table>
	
		
 	</c:if>
 </c:forEach>
 


 
  




	
	



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    
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

<% request.setAttribute( "languages", session.getAttribute("languagesList") ); %> 
<% request.setAttribute( "lid", request.getParameter("lid") ); %> 


<c:forEach var="item" items="${languages}">	
	<c:if test="${item.lid == lid}" > 	
	<table style="width:40%" class="dataTable">
	<thead>
		<tr>			
			<th class="sortable">Title</th>
		</tr>		
	</thead>
	<tbody>
	
<c:forEach var="movies" items="${item.movies}"> 
 	 	<tr class="odd">
 	 	<td><a href="Search?movie=${movies.title}">"${movies.title}"</a></td>
 	 	</tr>
	</c:forEach>
	
	</tbody>
	</table>
	
 	</c:if>
 </c:forEach>
 
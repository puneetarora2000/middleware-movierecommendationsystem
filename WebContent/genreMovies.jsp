<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    
    <%@ page import="mrs.database.Movies"%>
    <%@ page import="mrs.database.Genres"%>    
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

<% request.setAttribute( "genres", session.getAttribute("genresList") ); %> 
<% request.setAttribute( "gid", request.getParameter("gid") ); %> 


<c:forEach var="item" items="${genres}">	
	<c:if test="${item.gid == gid}" > 	
	
	<display:table name="${item.movies}" class='dataTable' style="width:60%" pagesize="30"> 
	<display:setProperty name="basic.msg.empty_list" value="" />
	<display:setProperty name="paging.banner.all_items_found" value=""/>	
  		<display:column property="title" sortable="true" paramId="movie" href="Search" paramProperty="mid"/>  		  		
	</display:table>
 	</c:if>
 </c:forEach>
 
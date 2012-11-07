<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="mrs.database.Actors"%>
    <%@ page import="mrs.database.Movies"%>    
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
<% request.setAttribute( "Actors", session.getAttribute("actorsList") ); %> 
<% request.setAttribute( "Movies", session.getAttribute("moviesList") ); %>
<% request.setAttribute( "Languages", session.getAttribute("languagesList") ); %> 
<% request.setAttribute( "Genres", session.getAttribute("genresList") ); %> 

<c:if test="${Movies.size() > 0}" >

<display:table name="Movies" class='dataTable' style="width:60%" pagesize="30">
 	 	<display:column property="mid" title="ID" sortable="true" />
 	 	<display:column property="title" sortable="true" paramId="mid" href="movieInfo.jsp" paramProperty="mid"/>
 	 	<display:column property="year" sortable="true" />
 	 	<display:column property="rating"  sortable="true" />
 	 	<display:column property="num_votes" sortable="true" />
 	 	<display:column property="distribution" sortable="true" /> 	 	
 	</display:table>

</c:if>

<c:if test="${Actors.size() > 0}" >  
	<display:table name="Actors" class='dataTable' style="width:60%" pagesize="30">
 	 	<display:column property="aid" title="ID" sortable="true" />
  		<display:column property="fname" sortable="true"/>
  		<display:column property="lname" sortable="true"/>
  		<display:column property="fullname" sortable="true" paramId="aid" href="actorsMovies.jsp" paramProperty="aid"/>
  		<display:column property="gender" sortable="true"/>
  		
	</display:table>

</c:if>

<c:if test="${Languages.size() > 0}" >  
	<display:table name="Languages" class='dataTable' style="width:60%" pagesize="30">
 	 	<display:column property="lid" title="ID" sortable="true" />  		
  		<display:column property="language" sortable="true" paramId="lid" href="languageMovies.jsp" paramProperty="lid" />  		
	</display:table>

</c:if>

<c:if test="${Genres.size() > 0}" >  
	<display:table name="Genres" class='dataTable' style="width:60%" pagesize="30">
 	 	<display:column property="gid" title="ID" sortable="true" />  		
  		<display:column property="genre" sortable="true" paramId="gid" href="genreMovies.jsp" paramProperty="gid" />  		
	</display:table>

</c:if>

</body>
</html>
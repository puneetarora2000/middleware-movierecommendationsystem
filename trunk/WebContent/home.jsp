<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/displaytag.css" type="text/css"/> 
<link rel="icon" href="css/a.png" type="image/png" />
<script src="js/clientValidation.js">
</script>

<title>Movie Recommendation System</title>
</head>
<body>
					<% if(request.getAttribute("mesg") != null) {%>
					<%= request.getAttribute("mesg") %>
					<%} %>
					
					<% if(request.getAttribute("obj") != null) {%>
					<%= request.getAttribute("obj") %>
					<%} %>
				
	<h1 align="center">Movie Recommendation System</h1>
	<div id="level1">
	<div id="level1_left">
		<table class='simple'>
			<tr>
				<td>
					<form action="Search" onSubmit="return validateForm(this)" name="actor">
						Search by Actor Name : <input type="text" name="actor" size="20px">
						<input type="submit" value="submit" class="button">
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="Search" onSubmit="return validateForm(this)" name="movie">
						Search by Movie Name : <input type="text" name="movie" size="20px">
						<input type="submit" value="submit" class="button">
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="Search" onSubmit="return validateForm(this)" name="language">
						Search by Language Name : <input type="text" name="language" size="20px">
						<input type="submit" value="submit" class="button">
					</form>
				</td>
			</tr>
			
		</table>
	   </div>
	  
        <div id="level1_right" style="padding-top:0px">
        	<% if(request.getSession().getAttribute("user") != null) {%>
					<%= "Welcome " + request.getSession().getAttribute("user") %>
					<br/><a href="Logout" style="textalign:right"> Logout </a>
			<%} else { %>
			<form action="Login" method="post">
			<table border="0" align="right" >	
			<tr>
        	    <td>User ID :</td>
        	    <td> <input type="text" name="userId" align="right"></td>				
			</tr>
			<tr>
				<td>Password :</td>
				<td> <input type="password" name="passwd" align="right"></td>
			<tr>
				<td><input type="submit" class="button" value="Login" align="right"></td>
				<td><a href="<%=request.getContextPath()%>/SignUp">Sign up</a></td>
			</tr>
				</table>
				</form>
			<% } %>
           <br/><br/>
        </div>
    </div>
    <a href="<%=request.getContextPath()%>/topMoviesServlet" style="margin-left:280px;"> Get Top 20 Movies</a></br></br>
    <a href="<%=request.getContextPath()%>/upComingMoviesServlet" style="margin-left:280px;"> Upcoming Movies</a></br></br>
    
</body>
</html>
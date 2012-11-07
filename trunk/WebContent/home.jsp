<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/displaytag.css" type="text/css" />
<link rel="icon" href="css/a.png" type="image/png" />


<title>Movie Recommendation System</title>
<script src="js/clientValidation.js">
</script>
</head>
<body>
	<div class="center">
		<table class='simple' style="width: 100%">
			<tr>
				<td colspan="2">
					<h1 align="center">Movie Recommendation System</h1>
					<% if(request.getAttribute("mesg") != null) {%>
					<%= request.getAttribute("mesg") %>
					<%} %>
					
					<% if(request.getAttribute("obj") != null) {%>
					<%= request.getAttribute("obj") %>
					<%} %>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<form action="Search" onSubmit="return validateForm(this)" name="actor">
						Search for Actor  : <input type="text" name="actor" size="20px">
						<input type="submit" value="submit" class="button">
					</form>
				</td>
				<td rowspan="3"><a
					href="<%=request.getContextPath()%>/topMoviesServlet"> Get Top
						20 Movies</a></td>
				<td>
					<form action="Login"  >
					    User ID : <input type="text" name="userId">
					    Password : <input type="password" name="passwd">
					    <input type="submit"  value="Submit" class="button">
					</form>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<form action="Search" onSubmit="return validateForm(this)" name="movie">
						Search by Movie Name : <input type="text" name="movie" size="20px">
						<input type="submit" value="submit" class="button">
					</form>
				</td>
				<td align="right">
				<form action="SignUp">
					    <input type="submit" class="button" value="Sign Up">
					</form>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<form action="Search" onSubmit="return validateForm(this)" name="language"  >
						Search for Language  : <input type="text" name="language" size="20px">
						<input type="submit" value="submit" class="button">
					</form>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<form action="Search" onSubmit="return validateForm(this)" name="genre"  >
						Search for Genre : <input type="text" name="genre" size="20px">
						<input type="submit" value="submit" class="button">
					</form>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>
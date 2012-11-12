<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/displaytag.css" type="text/css"/> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register for Movie Recommendation System</title>
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
<br/>
<div id="level1_right">
	<form action="Register" method="post">
					    User ID : <input type="text" name="userId"><br/><br/>
					    Email : <input type="text" name="email"><br/><br/>
					    Password : <input type="password" name="passwd"><br/><br/>
					    First Name : <input type="text" name="firstName"><br/><br/>
					    Last Name : <input type="text" name="lastName"><br/><br/>
					    Age : <input type="text" name="age"><br/><br/>
					    Gender: <input type="radio" name="gender" value="male">Male<br>
						<input type="radio" name="gender" value="female">Female<br/>
						Language : <input type="text" value="lang"><br/><br/>
						Location : <input type="text" value="loc"><br/><br/>
					    <input type="submit" class="button" value="Register">
	</form>
</div>
</body>
</html>
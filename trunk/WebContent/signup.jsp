<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register for Movie Recommendation System</title>
</head>
<jsp:include page="home.jsp"></jsp:include>
<body>
	<form action="Register">
					    User ID : <input type="text" name="userId"><br/>
					    Email : <input type="text" name="email"><br/>
					    Password : <input type="password" name="passwd"><br/>
					    First Name : <input type="text" name="firstName"><br/>
					    Last Name : <input type="text" name="lastName"><br/>
					    Age : <input type="text" name="age"><br/>
					    <input type="radio" name="gender" value="male">Male<br>
						<input type="radio" name="gender" value="female">Female<br/>
						Language : <input type="text" value="lang"><br/>
						Location : <input type="text" value="loc"><br/>
					    <input type="submit" class="button" value="Register">
	</form>
</body>
</html>
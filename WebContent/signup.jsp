<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/displaytag.css" type="text/css"/> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/clientValidation.js">
</script>

<title>Register for Movie Recommendation System</title>
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
<br/>
<div id="level1_right">
	<form action="Register" method="post" name="register">
					    User ID : <input type="text" name="userId"><br/><br/>
					    Email : <input type="text" name="email"><br/><br/>
					    Password : <input type="password" name="passwd"><br/><br/>
					    First Name : <input type="text" name="firstName"><br/><br/>
					    Last Name : <input type="text" name="lastName"><br/><br/>
					    Age : <input type="text" name="age"><br/><br/>
					    Gender: <input type="radio" name="gender" value="male" checked="checked">Male
						<input type="radio" name="gender" value="female">Female<br/>
						Language : 
							<select name="lang">
                                <option value="English" selected="selected">English</option>
                                <option value="French">French</option>
                                <option value="Hindi">Hindi</option>
                                <option value="German">German</option>
                                <option value="Mandarin">Mandarin</option>
                            </select>
						
						<br/><br/>
						Location :
						<select name="loc">
                                <option value="US" selected="selected">USA</option>
                                <option value="Europe">Europe</option>
                                <option value="Africa">Africa</option>
                                <option value="Asia">Asia</option>
                                <option value="France">France</option>
                            </select>
						
						<br/><br/>
						Genre : <select name="genre">
                                <option value="Action" selected="selected">Action</option>
                                <option value="Mystery">Mystery</option>
                                <option value="Romance">Romance</option>
                                <option value="Drama">Drama</option>
                                <option value="Documentary">Documentary</option>
                                <option value="Animation">Animation</option>
                            </select>
					    <input type="submit" class="button" value="Register" onsubmit="return checkSignup(this);">
	</form>
</div>
</body>
</html>
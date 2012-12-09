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
				
	<table width="100%">
	<tr>
	<td colspan="2">
	<h1 align="center">Movie Recommendation System</h1>
	</td>
	<td>
	<% if(request.getSession().getAttribute("user") != null) {%>
				<%= "Welcome " + request.getSession().getAttribute("user") %>
					<br/><a href="Logout" style="textalign:right"> Logout </a>
			<%} else { %>
			<form action="Login" method="post" onSubmit="return validateForm(this)" name="login">
			<table border="0" align="right" >	
			<tr>
        	    <td>User ID :</td>	<td> <input type="text" name="userId" align="right"></td>				
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
	
	</td>
	</tr>
	<tr>
	<td>	
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
	   </td>
	   <td>
	   <% if(request.getSession().getAttribute("user") != null) {%>	
	  <table class="simple">
      <tr><td>
      <form action="SetInterest" method="get">
                        Mood : <select name="mood">
                                <option value="FeelGood" selected="selected">Feel Good</option>
                                <option value="Witty">Witty</option>
                                <option value="Rough">Rough</option>
                                <option value="ThoughtProvoking">Thought Provoking</option>
                                <option value="Exciting">Exciting</option>
                                <option value="MindBending">Mind Bending</option>
                            </select>
                        <input type="submit" class="button" value="Submit">
    </form>
      </td></tr>
      
      <tr><td>
      <form action="SetInterest">
                        Movie Duration : <select name="duration">
                                <option value="1" selected="selected">1 Hr</option>
                                <option value="130">1 Hr 30 Min</option>
                                <option value="2">2 Hr</option>
                                <option value="230">2 Hr 30 Min</option>
                                <option value="330">3 Hr</option>
                            </select>
                        <input type="submit" class="button" value="Submit">
    </form>
      </td></tr>
      
      <tr><td>
      <form action="SetInterest" >
                        Time/Period Duration : <select name="period">
                                <option value="90s" selected="selected">Latest</option>
                                <option value="20s">20s</option>
                                <option value="30s">30s</option>
                                <option value="Ancient">Ancient History</option>
                                <option value="Middle">Middle Ages</option>
                            </select>
                        <input type="submit" class="button" value="Submit">
    </form>
      </td></tr>
      
      </table>
	   
	   <%}%>
	   
	   </td>
	   <td>
	   <table align="center">
	   <tr>
	   <td><a href="<%=request.getContextPath()%>/topMoviesServlet" > Get Top 20 Movies</a></td>
	   <tr><td><a href="UpcomingMovies" style="textalign:right">UpcomingMovies</a></td></tr>
	   <tr><td><a href="NowPlayingMovies" style="textalign:right">NowPlayingMovies</a></td></tr>
	   <% if(request.getSession().getAttribute("user") != null) {%>				
					<tr><td><a href="ShowRecomendation" style="textalign:right">Your Recommendations</a></td></tr>
			<%}%>
	   </table>
	   </td>
	   </tr>
	   </table>
	  
        
        	
           
   
</body>
</html>
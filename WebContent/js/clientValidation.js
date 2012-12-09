

function validateForm(thisform)
{
	
	//alert(thisform.name);
	
	switch(thisform.name)
	
	{
	case "actor" :	
		
		
		if((thisform.actor.value ==  null )|| (thisform.actor.value.length ==  0 ))
		{
			
			alert("Actor Name Cannot be null");
			return false;
		}
		break;
	case "movie" :
		
		if((thisform.movie.value ==  null )|| (thisform.movie.value.length ==  0 ))
		{
			
			alert("Movie Name Cannot be null");
			return false;
		}
		break;
	case "language" :
	
		if((thisform.language.value ==  null )|| (thisform.language.value.length ==  0 ))
		{
		
			alert("language Name Cannot be null");
			return false;
		}
		break;
		
	case "login" :
		
		if((thisform.userId.value ==  null )|| (thisform.userId.value.length ==  0 ))
		{
		
			alert("userId cannot be null");
			return false;
		}
		
		if((thisform.passwd.value ==  null )|| (thisform.passwd.value.length ==  0 ))
		{
		
			alert("passwd cannot be null");
			return false;
		}
		
		break;
	
	}
	
	
	return true;
}

function checkSignup(thisform)
{
	
	alert(thisform.name);

		
		if((thisform.userId.value ==  null )|| (thisform.userId.value.length ==  0 ))
		{
			
			alert("User Id Cannot be null");
			return false;
		}
		if((thisform.email.value ==  null )|| (thisform.email.value.length ==  0 ))
		{
			
			alert("Email cannot be null");
			return false;
		}
		if((thisform.passwd.value ==  null )|| (thisform.passwd.value.length ==  0 ))
		{
		
			alert("Password Cannot be null");
			return false;
		}
		if((thisform.firstName.value ==  null )|| (thisform.firstName.value.length ==  0 ))
		{
		
			alert("First Name Cannot be null");
			return false;
		}
		if((thisform.lastName.value ==  null )|| (thisform.lastName.value.length ==  0 ))
		{
		
			alert("Password Cannot be null");
			return false;
		}
		if((thisform.age.value ==  null )|| (thisform.age.value.length ==  0 ) || (thisform.age.value == NaN))
		{
		
			alert("Age entered is invalid");
			return false;
		}
	
	
	return true;
}


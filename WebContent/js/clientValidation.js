

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
	
		if((thisform.language ==  null )|| (thisform.language.value.length ==  0 ))
		{
		
			alert("language Name Cannot be null");
			return false;
		}
		break;
	
	}
	
	
	return true;
}
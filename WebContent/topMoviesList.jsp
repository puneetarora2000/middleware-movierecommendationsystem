
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>


    <meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Top 20 Movies</title>

<style type="text/css">
body {
	margin:100 px;
	padding:100 px;
}
</style>

<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/fonts/fonts-min.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/element/element-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datasource/datasource-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/event-delegate/event-delegate-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>


<!--begin custom header content for this example-->
<style type="text/css">
/* custom styles for this example */
.yui-skin-sam .yui-dt-liner { white-space:nowrap; } 
</style>

<!--end custom header content for this example-->

</head>

<body class="yui-skin-sam">
<jsp:include page="home.jsp"></jsp:include>
<div class="exampleIntro">
</div>
<div id="basic" align="center" style="padding-left : 50 px;"></div>
<script type="text/javascript">

var json = "";
executeNow();

function executeNow() {
		
	YAHOO.example.Basic = function() {
        var myColumnDefs = [
            {key:"id", sortable:true,resizeable:true},
            {key:"title", sortable:true, resizeable:true},
            {key:"original_title", sortable:true, resizeable:true},
            {key:"release_Date",  sortable:true, resizeable:true},
            {key:"vote_average", sortable:true, resizeable:true},
            {key:"vote_count", sortable:true, resizeable:true}
          	//{key:"poster_path", resizeable:true}
            //{key:"backdrop_path", sortable:true, resizeable:true}
        ];

		YAHOO.example.Data = <%= session.getAttribute("topMoviesList") %>;	
		//{"page":1,"results":[{"backdrop_path":"/6xKCYgH16UuwEGAyroLU6p8HLIn.jpg","id":238,"original_title":"The Godfather","release_date":"1972-03-15","poster_path":"/d4KNaTrltq6bpkFS01pYtyXa09m.jpg","title":"The Godfather","vote_average":9.2,"vote_count":133},{"backdrop_path":"/d2shJdJlReSI6hMn52XKYwM8X4s.jpg","id":4808,"original_title":"Charade","release_date":"1963-12-05","poster_path":"/7Iq8LbAYtJSZgDrXofVh7YLyIF5.jpg","title":"Charade","vote_average":9.2,"vote_count":10},{"backdrop_path":"/7u3pxc0K1wx32IleAkLv78MKgrw.jpg","id":603,"original_title":"The Matrix","release_date":"1999-03-31","poster_path":"/gynBNzwyaHKtXqlEKKLioNkjKgN.jpg","title":"The Matrix","vote_average":9.1,"vote_count":258},{"backdrop_path":"/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg","id":550,"original_title":"Fight Club","release_date":"1999-10-15","poster_path":"/2lECpi35Hnbpa4y46JX0aY3AWTy.jpg","title":"Fight Club","vote_average":9.1,"vote_count":182},{"backdrop_path":"/xGC2fY5KFmtuXnsuQwYQKFOLZFy.jpg","id":429,"original_title":"Il buono, il brutto, il cattivo","release_date":"1967-12-20","poster_path":"/4Mfp4ouiGPmYGVw8J9pa3q7de5b.jpg","title":"The Good, the Bad and the Ugly","vote_average":9.1,"vote_count":99},{"backdrop_path":"/jWDegvAE8XO2XDUHP9eQYlepJv1.jpg","id":240,"original_title":"The Godfather: Part II","release_date":"1974-12-20","poster_path":"/tHbMIIF51rguMNSastqoQwR0sBs.jpg","title":"The Godfather: Part II","vote_average":9.1,"vote_count":63},{"backdrop_path":"/3R6vDW1yBBzejsma8SzzWuxj2AE.jpg","id":311,"original_title":"Once Upon a Time in America","release_date":"1984-02-17","poster_path":"/fqP3Q7DWMFqW7mh11hWXbNwN9rz.jpg","title":"Once Upon a Time in America","vote_average":9.1,"vote_count":36},{"backdrop_path":"/xBKGJQsAIeweesB79KC89FpBrVr.jpg","id":278,"original_title":"The Shawshank Redemption","release_date":"1994-09-14","poster_path":"/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg","title":"The Shawshank Redemption","vote_average":9.0,"vote_count":178},{"backdrop_path":"/r0v9dayXd1IH5WPWFBWv52tGHkB.jpg","id":11,"original_title":"Star Wars: Episode IV - A New Hope","release_date":"1977-05-25","poster_path":"/tvSlBzAdRE29bZe5yYWrJ2ds137.jpg","title":"Star Wars: Episode IV - A New Hope","vote_average":9.0,"vote_count":155},{"backdrop_path":"/tv8J6uCTKsTlASa8luJqrFiJlBX.jpg","id":78,"original_title":"Blade Runner","release_date":"1982-06-25","poster_path":"/ewq1lwhOT8GqBcQH1w8D1BagwTh.jpg","title":"Blade Runner","vote_average":9.0,"vote_count":153},{"backdrop_path":"/AkE7LQs2hPMG5tpWYcum847Knre.jpg","id":1891,"original_title":"Star Wars: Episode V - The Empire Strikes Back","release_date":"1980-05-21","poster_path":"/dKz98Lyda4m1QaUUUsUpXFpYCXN.jpg","title":"Star Wars: Episode V - The Empire Strikes Back","vote_average":9.0,"vote_count":148},{"backdrop_path":"/8BPZO0Bf8TeAy8znF43z8soK3ys.jpg","id":122,"original_title":"The Lord of the Rings: The Return of the King","release_date":"2003-12-17","poster_path":"/j6NCjU6Zh7SkfIeN5zDaoTmBn4m.jpg","title":"The Lord of the Rings: The Return of the King","vote_average":9.0,"vote_count":138},{"backdrop_path":"/d9AqtruwS8nljKjL5aYzM42hQJr.jpg","id":280,"original_title":"Terminator 2: Judgment Day","release_date":"1991-07-01","poster_path":"/2y4dmgWYRMYXdD1UyJVcn2HSd1D.jpg","title":"Terminator 2: Judgment Day","vote_average":9.0,"vote_count":110},{"backdrop_path":"/mGN0lH2phYfesyEVqP2xvGUaxAQ.jpg","id":101,"original_title":"LÃ©on","release_date":"1994-09-14","poster_path":"/alGc7hDKHLQ2m7Ic41LSp5hbIpI.jpg","title":"Leon: The Professional","vote_average":9.0,"vote_count":93},{"backdrop_path":"/g05ZFUUrJM8KsmpsGj8NnF5IyHv.jpg","id":129,"original_title":"Sen to Chihiro no kamikakushi","release_date":"2001-07-20","poster_path":"/avFyz5Bl6F5qRdmyZA2p6Znjede.jpg","title":"Spirited Away","vote_average":9.0,"vote_count":54},{"backdrop_path":"/aB9aig2gKNwUlEmWsbtRbx01WzR.jpg","id":670,"original_title":"ì˜¬ë“œë³´ì?´","release_date":"2003-11-21","poster_path":"/fct7n9V10E8t8a7wOR90Ccw0i48.jpg","title":"Oldboy","vote_average":9.0,"vote_count":50},{"backdrop_path":"/AplR1QRswlXiM65GoifX8sDadME.jpg","id":213,"original_title":"North by Northwest","release_date":"1959-07-17","poster_path":"/rEHP8ylmL3pcsDUEA6Z5qhajYui.jpg","title":"North by Northwest","vote_average":9.0,"vote_count":29},{"backdrop_path":"/xATZyEpnZ0Z0iO9z5K8RZsraGKI.jpg","id":840,"original_title":"Close Encounters of the Third Kind","release_date":"1977-11-16","poster_path":"/mABOVIUl5lB0WF4HG28rfamgxG1.jpg","title":"Close Encounters of the Third Kind","vote_average":9.0,"vote_count":20},{"backdrop_path":"/xa2rJIU0Bs56b9ek9ZuAcRe2S2k.jpg","id":914,"original_title":"The Great Dictator","release_date":"1940-10-15","poster_path":"/i9rN9JPbTHplRa9OLEwcymUAKvb.jpg","title":"The Great Dictator","vote_average":9.0,"vote_count":18},{"backdrop_path":"/nnMC0BM6XbjIIrT4miYmMtPGcQV.jpg","id":155,"original_title":"The Dark Knight","release_date":"2008-07-18","poster_path":"/1hRoyzDtpgMU7Dz4JF22RANzQO7.jpg","title":"The Dark Knight","vote_average":8.9,"vote_count":280}],"total_pages":63,"total_results":1258};

		var myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.results);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_ARRAY;
        myDataSource.responseSchema = {
            fields: ["id","title","original_title","release_date","poster_path","vote_average","vote_count","backdrop_path"]
        };

        var myDataTable = new YAHOO.widget.DataTable("basic",
                myColumnDefs, myDataSource, {caption:"Top Rated Movies"});
                
        return {
            oDS: myDataSource,
            oDT: myDataTable
        };
    }();
}
</script>
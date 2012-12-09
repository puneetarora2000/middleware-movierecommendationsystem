
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Recommendation List</title>

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
<br/><br/>
<div id="basic" align="center" style="padding-left : 50 px;"></div>
<script type="text/javascript">
var json = "";
executeNow();

function executeNow() {
	
	YAHOO.example.Basic = function() {
        var myColumnDefs = [
            {key:"name", label:"Movie Name", sortable:true,resizeable:true},
            
        ];

		YAHOO.example.Data = <%= request.getAttribute("recommendationList") %>;	
		var myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["name"]
        };

        var myDataTable = new YAHOO.widget.DataTable("basic",
                myColumnDefs, myDataSource, {caption:"Recommendation List"});
                
        return {
            oDS: myDataSource,
            oDT: myDataTable
        };
    }();
}
</script>
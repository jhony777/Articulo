<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<script src="<c:url value="/resources/core/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/core/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">

</head>
<body>
	<h2>Spring MVC + jQuery + Autocomplete example</h2>

	<div>
		<input type="text"  id="w-input-search" value="">
		<span>
			<button id="btnBuscar" type="button">Search</button>
		</span>
	</div>
	
	<script>
	$(document).ready(function() {

		$("#btnBuscar").click(function(){
			
			 
				var codTramite="1444";
				var descTramite="descrip";

				
				var search = {}
				search["codTramite"] = codTramite;
				search["descTramite"] = descTramite;

				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : '${pageContext.request.contextPath}/expedi',
					data : JSON.stringify(search),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);

					},
					error : function(e) {
						console.log("ERROR: ", e);

					},
					done : function(e) {
						console.log("DONE");
					}
				});
				
				 alert("The paragraph was clicked.");
		});	
		

		
	});
	</script>
	
</body>
</html>
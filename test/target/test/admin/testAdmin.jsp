<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		getData();
		$(document).on("click",".deleteData",function(){
			if(confirm('Are you sure you want to delete?')){
				var id=$(this).val();
				$.ajax({
				url : '../Delete',
				data : {
					delete: id
				},
				success : function(responseText) {
					getData();
				},
				error : function(responseText) {
					
					console.log("error");
				}
			});	
			}else
				return false;
		});
		function getData(){
			$("#example").find("tr:gt(0)").remove();
			$.ajax({
				url : '../AjaxServlet',
				success : function(responseText) {
					if(responseText!=null){
						
						var table=$("#example");
						$.each(responseText,function(key,value){
							
							var row=$("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
							row.children().eq(0).text(value['registerId']);
							row.children().eq(1).text(value['firstName']);
							row.children().eq(2).text(value['lastName']);
							row.children().eq(3).text(value['email']);
							row.children().eq(4).text(value['password']);
							row.children().eq(5).text(value['gender']);
							row.children().eq(6).text(value['languageKnown']);
							row.children().eq(7).text(value['phoneNo']);
							row.children().eq(8).text(value['dob']);
							row.children().eq(9).append('<img src="data:image/jpg;base64,'+ value['base64Image'] +'" alt="no Image" width="75" height="75" class="mb-1"/>');
							row.children().eq(10).append('<button id="delete" class="deleteData" name="delete" value="' + value['registerId'] + '">Delete</button>');
							row.children().eq(11).text(value['registerId']);
							row.appendTo(table);
						});
					}
				},
				error : function(responseText) {
					
					console.log("error");
				}
			});	
		};
	});
</script>
</head>
<body>
<div id="tableDiv">
	<table id="example">
		<tr>
			<td scope="col">id</td>
			<td scope="col">Name</td>
			<td scope="col">lname</td>
			<td scope="col">email</td>
			<td scope="col">password</td>
			<td scope="col">image</td>
			<td scope="col">languageKnown</td>
			<td scope="col">gender</td>
			<td scope="col">Phoneno</td>
			<td scope="col"></td>
			<td scope="col"></td>
		</tr>
	</table>
</div>
</body>

</html>
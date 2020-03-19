<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.role != 'admin'}">
	<c:redirect url="login.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Inexture</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">	
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" >
		<link href="../css/dataTable/dataTable.bootstrap.min.css" rel="stylesheet">
		<link href="../css/dataTable/responsive.bootstrap.min.css" rel="stylesheet">
		<link href="../css/style.css" rel="stylesheet">
	<style type="text/css">
		button{
			border: none;
			color : lightblue;
			background: transparent;
		} 
	
	}
	</style>
	</head>
	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		<%-- <jsp:include page="/AdminHome"></jsp:include> --%>
		<div class="container mt-1">
			
			<table id="example" class="table table-striped table-bordered dt-responsive nowrap text-center">
			       <thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>LastName</th>
						<th>Email</th>
						<th>Gender</th>
						<th>LanguageKnown</th>
						<th>Phone No</th>
						<th>DOB</th>
						<th>Image</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					
				 </tbody>
			</table>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
	<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
	
	<script src="../js/DataTable/jquery.datatable.min.js"></script>
	<script src="../js/DataTable/dataTables.bootstrap4.min.js"></script>
	<script src="../js/DataTable/dataTables.responsive.min.js"></script>
	<script src="../js/DataTable/responsive.bootstrap4.min.js"></script>
	<script src="../admin/js/ajaxCall.js"></script>
	<!-- <script src="../js/DataTable/general.js"></script> -->
</html>
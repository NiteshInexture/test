<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.role == null }">
	<c:redirect url="../login.jsp"/>
</c:if>
	
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Inexture</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<link rel="stylesheet" href="./fonts/font-awesome-4.7.0/css/font-awesome.min.css">
		<link href="./css/style.css" rel="stylesheet">
		<link href="./css/style3.css" rel="stylesheet">
	</head>
	<!-- <SCRIPT type="text/javascript">
	    window.history.forward();
	    function noBack() { window.history.forward(); }
	</SCRIPT> -->
	 <BODY >
		<jsp:include page="../header.jsp" />
			<c:if test="${sessionScope.role == 'user' }">
				<jsp:include page="../register.jsp"/>
			</c:if>
		<jsp:include page="../footer.jsp"/>
	</body>
	<script src="./vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="./js/validate.min.js"></script>
	<script src="./js/RegisterAddress.js"></script>
	<script src="./js/validate.js"></script>
	<script src="./js/validateRegister.js"></script>
	<script src="./js/ajax/userAjaxCall.js"></script>
	<script type="text/javascript" src="./js/general.js"></script>
</html>
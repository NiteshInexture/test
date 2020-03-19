<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
		<c:if test="${ pageContext.request.servletPath == '/admin' }">
			<c:redirect url="../login.jsp"></c:redirect>
		</c:if>

<!DOCTYPE html>
	<c:choose>
		<c:when test="${role == 'admin' }">
			<c:redirect url="admin/home.jsp"></c:redirect>
		</c:when>
		<c:when test="${role == 'user' }">
			<c:redirect url="UserForm.jsp"></c:redirect>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
<html lang="en">
<head>
	<title>Inexture</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<c:choose>
		<c:when test="${ pageContext.request.servletPath == '/admin' }">
			<!--===============================================================================================-->	
			<link rel="icon" type="image/png" href="../images/icons/favicon.ico"/>
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
			<!--===============================================================================================-->	
			<link rel="stylesheet" type="text/css" href="../vendor/css-hamburgers/hamburgers.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="../css/util.css">
			<link rel="stylesheet" type="text/css" href="../css/main.css">
			<!--===============================================================================================-->
		</c:when>
		<c:otherwise>
			<!--===============================================================================================-->	
			<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
			<!--===============================================================================================-->	
			<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css" href="css/util.css">
			<link rel="stylesheet" type="text/css" href="css/main.css">
			<!--===============================================================================================-->
		</c:otherwise>
	</c:choose>
</head>

 <BODY>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<c:choose>
						<c:when test="${ pageContext.request.servletPath == '/admin' }">
							<img src="../images/img-01.png" alt="IMG">	
						</c:when>
						<c:otherwise>
							<img src="images/img-01.png" alt="IMG">	
						</c:otherwise>
					</c:choose>
				</div>

				<form class="login100-form validate-form">
					<span class="login100-form-title">
						Login Here
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" maxlength="50" name="email" placeholder="Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="password" maxlength="13" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					<div>
						<c:if test="${message != null}">
							<p class="text-danger"><c:out value="${message}"/></p>
						</c:if>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" formaction="Login" formmethod="post">
							Login
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
						<a class="txt2" href="forget_password.jsp">
							Password?
						</a>
					</div>

					<div class="text-center p-t-80">
						<a class="txt2" href="UserForm.jsp">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${ pageContext.request.servletPath == '/admin' }">
			<!--===============================================================================================-->	
			<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
		<!--===============================================================================================-->
			<script src="../vendor/bootstrap/js/popper.js"></script>
			<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
		<!--===============================================================================================-->
			<script src="../vendor/select2/select2.min.js"></script>
		<!--===============================================================================================-->
			<script src="../vendor/tilt/tilt.jquery.min.js"></script>
			<script type="text/javascript">
				$('.js-tilt').tilt({
					scale: 1.1
				})
			</script>
		<!--===============================================================================================-->
			<script src="../js/main.js"></script>
		</c:when>
		<c:otherwise>
			<!--===============================================================================================-->	
			<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
		<!--===============================================================================================-->
			<script src="vendor/bootstrap/js/popper.js"></script>
			<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<!--===============================================================================================-->
			<script src="vendor/select2/select2.min.js"></script>
		<!--===============================================================================================-->
			<script src="vendor/tilt/tilt.jquery.min.js"></script>
			<script type="text/javascript">
				$('.js-tilt').tilt({
					scale: 1.1
				})
			</script>
		<!--===============================================================================================-->
			<script src="js/main.js"></script>
		</c:otherwise>
	</c:choose>
			

</body>
</html>




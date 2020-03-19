<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style type="text/css">
	button[name='logout']{
			border: none;
			color : white;
			background: transparent;
		}	
</style>
</head>
<body>
	<nav class="navbar">
        <span class="navbar-toggle" id="js-navbar-toggle">
            <i class="fa fa-bars"></i>
        </span>
      <a href="#" class="logo"><img alt="" src="./images/inexture.png"></a>	 
        <ul class="main-nav" id="js-menu">
            <li>
            	<form>
	            	<c:choose>
	            		 <c:when test="${pageContext.request.servletPath == '/UserForm.jsp'}">
	            		 	<a href="admin/home.jsp" class="nav-links">Home</a>
	            			<button name="logout" formaction="Logout" value="logout" formmethod="post">Logout</button>	 
	            		 </c:when>            		
	            		 <c:when test="${sessionScope.role == 'admin'}">
	            		 	<a href="home.jsp" class="nav-links">Home</a>
	            			<!-- <a href="../login.jsp" class="nav-links">Logout</a>	  -->
	            			<button name="logout" formaction="../Logout" value="logout" formmethod="post">Logout</button>
	            		 </c:when>
	            		 <c:otherwise>
	            		 	<button name="logout" formaction="Logout" value="logout" formmethod="post">Logout</button>
	            		 </c:otherwise>
	            	</c:choose>
            	</form>
            </li>
        </ul>
    </nav>
</body>
</html>

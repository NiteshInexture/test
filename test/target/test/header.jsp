<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	
</head>
<body>
	<nav class="navbar">
        <span class="navbar-toggle" id="js-navbar-toggle">
            <i class="fa fa-bars"></i>
        </span>
      <a href="#" class="logo"><img alt="" src="./images/inexture.png"></a>	 
        <ul class="main-nav" id="js-menu">
            <li>
                <a href="#" class="nav-links">Home</a>
            </li>
            
            <li>
            	<c:choose>
            		 <c:when test="${sessionScope.role == 'admin'}">
            			<a href="../login.jsp" class="nav-links">Logout</a>	 
            		 </c:when>
            		 <c:otherwise>
            		 	<a href="login.jsp" class="nav-links">Logout</a>
            		 </c:otherwise>
            	</c:choose>
            	
            </li>
        </ul>
    </nav>
</body>
</html>

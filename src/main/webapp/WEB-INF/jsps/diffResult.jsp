<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Result!</h1>
<h3>Polynomial: ${originalPol.expression}.</h3>
<hr/>
Derivative: ${diffPol.expression}.
<c:choose>
<c:when test="${gradient != null}">
<hr/>
Gradient at the point x = ${diffPol.pointA}: &nbsp;&nbsp; ${gradient}.
</c:when>
</c:choose>
<div>
<img src="https://www.highermathematics.co.uk/wp-content/uploads/2018/02/image/png/png/GOT-3.png"/>
</div>
<h3><a href="isFun">Is differentiation fun?</a></h3>
</body>
</html>
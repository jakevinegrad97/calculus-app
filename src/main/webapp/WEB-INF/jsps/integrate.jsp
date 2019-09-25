<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Integrate a polynomial!</title>
</head>
<body>
<%@ include file="header.jsp" %>
<form:form action="integrate" modelAttribute="polyInt">
	<table>
		<tr>
			<td>Polynomial</td>
			<td><form:input path="expression"/></td>
		</tr>
		<tr>
			<td>Starting Point</td>
			<td><form:input path="pointA"/></td>
		</tr>
		<tr>
			<td>End Point</td>
			<td><form:input path="pointB"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Integrate" /></td>
		</tr>
	</table>
	</form:form>
</body>
</html>
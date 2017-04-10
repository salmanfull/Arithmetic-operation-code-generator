<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<c:set var="responseData" value="${code}" scope="request" />

<pre> <c:forEach var="function" items="${responseData}">
<c:out value="${function}"></c:out>
</c:forEach> </pre>
<br>

<c:set var="input" value="${inputs}" scope="request" />
Inputs : [
 <c:forEach var="function" items="${input}">
  <tr><td><c:out value="${function}, "></c:out></td>
</tr>
</c:forEach>
]
<br>
<p>Result is <c:out value="${result}" /></p>
</body>
</html>
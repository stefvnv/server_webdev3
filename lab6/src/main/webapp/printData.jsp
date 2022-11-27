<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<p>Hello <c:out value = "${name}"/></p>
<p>Your address is <c:out value = "${address}"/></p> <br>

<p>Your credit card number is <c:out value = "${creditCardNumber}"/></p>
<p>and has an expiry date of <c:out value = "${expiryDate}"/></p> <br>

<p>Address: <c:out value = "${addressLine1},"/></p>
<c:out value = "${addressLine2}"/>


</body>
</html>
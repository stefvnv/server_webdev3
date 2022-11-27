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

<p>Hello ${param.name}</p>
<p>Your address is ${param.address}</p> <br>

<p>Your credit card number is ${param.creditCardNumber}</p>
<p>and has an expiry date of ${param.expiryDate}</p> <br>

<p>Address: ${param.addressLine1}, ${param.addressLine2}</p>
${param.addressLine2}

</body>
</html>
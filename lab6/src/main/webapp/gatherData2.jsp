<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gather Data 2</title>
</head>
<body>


<form method="post" action="Servlet3">

    <input type="hidden" name="name" value="${sessionScope.name}"/> <br>
    <input type="hidden" name="address" value="${sessionScope.address}"/> <br>
    <input type="hidden" name="creditCardNumber" value="${sessionScope.creditCardNumber}"><br>
    <input type="hidden" name="expiryDate" value="${sessionScope.expiryDate}"><br>

    Address (Line 1): <input type="text" name="addressLine1"><br>
    Address (Line 2): <input type="text" name="addressLine2"><br>
    <input type="submit" value="Next">
</form>


</body>
</html>
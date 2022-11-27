<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gather Data 1</title>
</head>
<body>

<p>Welcome ${sessionScope.name}, please fill in your details.</p>

<form method="post" action="Servlet2">
    <input type="hidden" name="name" value="${sessionScope.name}"/> <br>
    <input type="hidden" name="address" value="${sessionScope.address}"/> <br>
    Credit Card Number: <input type="text" name="creditCardNumber"><br>
    Expiry Date: <input type="text" name="expiryDate"><br>
    <input type="submit" value="Next">
</form>

</body>
</html>
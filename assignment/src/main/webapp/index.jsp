<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>JSP - Hello</title>
</head>
<body>

<!--USER-->
<form method="post" action="CreateUserServlet">
    Enter name: <input type="text" name="name"><br>

    Enter address: <input type="text" name="address"><br>
    <input type="submit" value="Submit user form">
</form>

<!--BOOK-->
<form method="post" action="CreateBookServlet">
    Enter favorite book title: <input type="text" name="title"><br>

    Enter author: <input type="text" name="author"><br>
    <input type="submit" value="Submit book form">
</form>


</body>
</html>
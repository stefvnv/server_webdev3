<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h2>Book</h2>
    <form method="post" action="BookServlet">
        Enter book title: <input type="text" name="title"><br>
        Enter book author: <input type="text" name="author">
        <input type="submit" value="Proceed">
    </form>
</body>
</html>
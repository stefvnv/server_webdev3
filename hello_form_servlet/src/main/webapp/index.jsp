<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Welcome</h2>
<form method="post" action="HelloFormsServlet">
    Enter name: <label>
    <input type="text" name="name">
</label>
    <input type="submit" value="Say Hello">
</form>
</body>
</html>
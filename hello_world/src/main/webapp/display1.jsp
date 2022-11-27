<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
just a page to test that this works.....

${sessionScope.user}
<form method="post" action="Controller2">
    <input type="submit" value="click here"/>
</form>
</body>
</html>
<%-- PART A--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form method="post" action="CreateHouseServlet">
    Enter owner name: <input type="text" name="owner"><br>

    Enter address: <input type="text" name="address"><br>

    Enter number of bedrooms: <input type="text" name="noBedrooms"><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
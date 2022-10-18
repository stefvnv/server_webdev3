<%--
  Created by IntelliJ IDEA.
  User: Stefana
  Date: 18/10/2022
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Title</title>
</head>
<body>
Name: <c:out value="${user.name}"/><br>
Address: <c:out value="${user.address}"/><br>
</body>
</html>

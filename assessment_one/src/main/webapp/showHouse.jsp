<%-- --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Title</title>
</head>
<body>
Owner name: <c:out value="${house.owner}" default="name unknown"/><br>
Address: <c:out value="${house.address}" default="address unknown"/><br>
Number of bedrooms: <c:out value="${house.noBedrooms}" default="0"/><br>
</body>
</html>

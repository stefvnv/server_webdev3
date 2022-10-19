<%--Part A--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Houses | Form Output</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<header>
    <div class="w3-bar w3-border w3-pale-red w3-padding-small" style="width: 100%;">
        <h2>Houses - showHouse.jsp</h2>
    </div>
</header>

<body style=background-color:lavenderblush">

<div style="padding: 4%; width: 60%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-pink w3-round-xlarge">
            <h3>Form Output</h3>
        </div>
        <div class="w3-margin">
            <p>Owner name: <c:out value="${house.owner}" default="name unknown"/></p>
            <p>Address: <c:out value="${house.address}" default="address unknown"/></p>
            <p>Number of bedrooms: <c:out value="${house.noBedrooms}" default="0"/></p>
        </div>
    </div>
</div>
</body>
</html>
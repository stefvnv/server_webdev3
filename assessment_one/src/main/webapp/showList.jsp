<%-- Part 2--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Houses | showList.jsp</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<header>
    <div class="w3-bar w3-border w3-pale-red w3-padding-small" style="width: 100%;">
        <h2>Houses - showHouse.jsp</h2>
    </div>
</header>

<body>
<div style="padding: 10%; width: 50%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-blue-grey w3-round-xlarge">
            <h5>List of Houses</h5>
        </div>
        <div class="w3-margin">
            <c:forEach items="${houseList}" var="house">
                <c:out value="${house.owner}"/>
                <c:out value="${house.address}"/>
                <c:out value="${house.noBedrooms}"/>
                <br>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>



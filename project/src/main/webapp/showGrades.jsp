<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
View - Add Grade
Stefana Chiritescu
A00282343
--%>

<!--head-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grade Manager | Add Grade</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<header>
    <div class="w3-bar w3-border w3-pale-red w3-padding-small" style="width: 100%;">
        <h2>Grade Manager - Add Grade</h2>
    </div>
</header>

<!--body-->
<body style="background-color:lavenderblush">

<div>
    <h4>Welcome, ${sessionScope.user.name}</h4>
</div>

<div style="padding: 4%; width: 60%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-pink w3-round-xlarge w3-center">
            <h3>Your Grades</h3>
        </div>

        <div class="w3-container">
            <!--table of results-->
            <table>
                <tr>
                    <th>Year</th>
                    <th>Module</th>
                    <th>Grade</th>
                </tr>

                <c:forEach items="${gradesList}" var="grade" varStatus="status">
                    <tr>
                        <td>${grade.year}</td>
                        <td>${grade.module}</td>
                        <td>${grade.grade}</td>
                    </tr>
                </c:forEach>
            </table>

<%--            <div class="w3-margin">--%>
<%--                <input class="w3-input w3-pale-red w3-round-xlarge" style="width: 40%; margin:auto" type="submit"--%>
<%--                       value="Add Grade">--%>
<%--            </div>--%>
        </div>
    </div>
</div>

</body>
</html>
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
    <title>Grade Manager | Your Grades</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<header>
    <div class="w3-bar w3-border w3-pale-red w3-padding-small" style="width: 100%;">
        <h2>Grade Manager - Your Grades</h2>
    </div>
</header>

<!--body-->
<body style="background-color:lavenderblush">

<div class="w3-container">
    <h4>Welcome, ${sessionScope.user.name}</h4>
</div>

<div style="padding: 4%; width: 60%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-pink w3-round-xlarge w3-center">
            <h3>Your Grades</h3>
        </div>

        <div class="w3-container">
            <!--table of results-->
            <table id="tabbb">
                <tr>
                    <th>Year</th>
                    <th>Module</th>
                    <th>Grade</th>
                </tr>


                <c:set var="count" value="0" scope="page" />
                <c:forEach items="${gradesList}" var="grade" varStatus="status">
                    <tr id = "row_${count}">
                        <td contenteditable>${grade.year}</td>
                        <td contenteditable>${grade.module}</td>
                        <td contenteditable>${grade.grade}</td>

                        <td>
                            <form method="post" action="GradeController">
                                <input class="w3-input" type="hidden" name="arrayObject" value="sessionScope.gradesList">
                                <input class="w3-input" type="hidden" name="current_row_index" value="${count}">
                                <input class="w3-input w3-pale-red w3-round-xlarge" style="width: 40%" type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page"/>
                </c:forEach>
            </table>

            <form method="post" action="addGrade.jsp">
                <input class="w3-input w3-pale-red w3-round-xlarge" style="width: 40%" type="submit" value="Add Grade">
            </form>




        </div>
    </div>
</div>

</body>
</html>
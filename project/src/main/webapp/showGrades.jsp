<%--
View - showGrades
Stefana Chiritescu
A00282343
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--head-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grade Manager | Your Grades</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<header class="w3-bar w3-pale-red w3-padding-small" style="width: 100%">
    <div style="float: left; width: 85%; font-weight: bold">
        <h2 style="font-weight: bold">Grade Manager - Your Grades</h2>
    </div>

    <div style="float: right; width: 15%">
        <form method="post" action="LogoutServlet">
            <input class="w3-input w3-dark-gray w3-round-xlarge" style="" type="submit" value="Login">
        </form>
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
            <table class="w3-table">
                <tr>
                    <th>Year</th>
                    <th>Module</th>
                    <th>Grade</th>
                </tr>
                <tr id="row_${count}">
                    <c:set var="count" value="0" scope="page"/>
                    <c:forEach items="${gradesList}" var="grade" varStatus="status">
                    <form method="post" action="GradeController">
                        <td>${grade.year}</td>
                        <td>${grade.module}</td>
                        <td><input class="w3-input" type="text" name="grade_row" value=${grade.grade}></td>
                        <td><input class="w3-input w3-pale-red w3-round-xlarge" type="submit" name="update"
                                   value="Update" onclick="updatedFun()"></td>
                        <td><input class="w3-input w3-pale-red w3-round-xlarge" type="submit" name="delete"
                                   value="Delete"></td>
                        <input class="w3-input" type="hidden" name="current_row_index" value="${count}">
                        <input class="w3-input" type="hidden" name="current_row_year" value="${grade.year}">
                        <input class="w3-input" type="hidden" name="current_row_module" value="${grade.module}">
                        <input class="w3-input" type="hidden" name="current_row_index" value="${count}">
                    </form>
                </tr>

                <c:set var="count" value="${count + 1}" scope="page"/>
                </c:forEach>
                <c:set var="count" value="0" scope="page"/>
            </table>

            <form method="post" action="addGrade.jsp">
                <input class="w3-input w3-pale-red w3-round-xlarge" style="width: 40%" type="submit" value="Add Grade">
            </form>

            <script>
                function updatedFun() {
                    alert("field updated")
                }
            </script>
        </div>
    </div>
</div>
</body>
</html>
<%--
View - addGrade
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


<header class="w3-bar w3-pale-red w3-padding-small" style="width: 100%">
    <div style="float: left; width: 70%; font-weight: bold">
        <h2 style="font-weight: bold">Grade Manager - Add Grade</h2>
    </div>

    <div style="float: right; width: 15%">
        <form method="post" action="UserController">
            <input class="w3-input w3-red w3-round-xlarge" style="" type="submit" name="delete" value="Delete User">
        </form>
    </div>

    <div style="float: right; width: 15%">
        <form method="post" action="LogoutServlet">
            <input class="w3-input w3-dark-gray w3-round-xlarge" style="" type="submit" value="Logout">
        </form>
    </div>
</header>

<!--body-->
<body style="background-color:lavenderblush">
<form method="post" action="AddGradeServlet" style="padding: 4%; width: 60%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-pink w3-round-xlarge">
            <h3 class="w3-center">ADD NEW GRADE</h3>
        </div>

        <div class="w3-container">
            <label>Year</label>
            <label>
                <input class="w3-input" type="text" name="year">
            </label>

            <label>Module</label>
            <label>
                <input class="w3-input" type="text" name="module">
            </label>

            <label>Grade</label>
            <label>
                <input class="w3-input" type="text" name="grade">
            </label>

            <label>
                <input class="w3-input" type="hidden" name="email" value="${sessionScope.user.email}">
            </label>
            <div class="w3-margin">
                <input class="w3-input w3-pale-red w3-round-xlarge" style="width: 40%; margin:auto" type="submit"
                       value="Add Grade">
            </div>
        </div>
    </div>
</form>

</body>
</html>
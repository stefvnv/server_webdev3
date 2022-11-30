<%--
View - index (login)
Stefana Chiritescu
A00282343
--%>

<!--head-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grade Manager | Login</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<header class="w3-bar w3-pale-red w3-padding-small" style="width: 100%;">
    <div style="float: left; width: 85%">
        <h2 style="font-weight: bold">Grade Manager - Login</h2>
    </div>

    <div style="float: right; width: 15%">
        <form method="post" action="signUp.jsp">
            <input class="w3-input w3-dark-gray w3-round-xlarge" style="" type="submit" value="Sign Up">
        </form>
    </div>
</header>


<!--body-->
<body style="background-color:lavenderblush">
<form method="post" action="UserController" style="padding: 4%; width: 60%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-pink w3-round-xlarge">
            <h3 class="w3-center">LOGIN</h3>
        </div>

        <div class="w3-container">
            <label>Email</label>
            <label>
                <input class="w3-input" type="email" name="email">
            </label>

            <label>Password</label>
            <label>
                <input class="w3-input" type="password" name="password">
            </label>
            <div class="w3-margin">
                <input class="w3-input w3-pale-red w3-round-xlarge" style="width: 40%; margin:auto" type="submit"
                       value="Login">
            </div>
        </div>
    </div>
</form>
</body>
</html>
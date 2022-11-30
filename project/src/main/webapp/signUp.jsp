<%--
View - signUp
Stefana Chiritescu
A00282343
--%>

<!--head-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grade Manager | Sign Up</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<header>
    <div class="w3-bar w3-border w3-pale-red w3-padding-small" style="width: 100%;">
        <h2 style="font-weight: bold">Grade Manager - Sign Up</h2>
    </div>
</header>



<!--body-->
<body onload="duplicateFun()" style="background-color:lavenderblush">
<form method="post" action="SignUpServlet" style="padding: 4%; width: 60%; margin: auto;">

    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-pink w3-round-xlarge w3-center">
            <h3>SIGN UP</h3>
        </div>

        <div class="w3-container">
            <label>Name</label>
            <label>
                <input class="w3-input" type="text" name="name">
            </label>

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
                       value="Sign Up">
            </div>
        </div>
    </div>
</form>

<script>
    function duplicateFun(){
        if ( true == (${sessionScope.DUPLICATE_EMAIL})){
            alert("email must be shiniqua uniqua");
        }
    }
</script>



</body>
</html>
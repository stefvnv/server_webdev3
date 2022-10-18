<%-- PART A--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Houses | Index Page</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<header>
    <div class="w3-bar w3-border w3-pale-red w3-padding-small" style="width: 100%;">
        <h2>Houses - Index</h2>
    </div>
</header>

<body style=background-color:lavenderblush">


<!--Part A - index-->
<form method="post" action="CreateHouseServlet" style="padding: 4%; width: 60%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-pink w3-round-xlarge">
            <h3>House Details Form</h3>
        </div>

        <form class="w3-container">
            <label>Owner Name</label>
            <label>
                <input class="w3-input" type="text" name="owner">
            </label>

            <label>House Address</label>
            <label>
                <input class="w3-input" type="text" name="address">
            </label>

            <label>Number of Bedrooms</label>
            <label>
                <input class="w3-input" type="number" name="noBedrooms">
            </label>

            <div class="w3-margin">
                <input class="w3-input w3-pale-red w3-round-xlarge" style="width: 40%; margin:auto" type="submit"
                       value="Submit">
            </div>
        </form>
    </div>
</form>

<!--Part B - index-->
<form method="post" action="HouseControllerServlet" style="padding: 10%; width: 50%; margin: auto;">
    <div class="w3-card-4 w3-padding-small w3-round-xlarge">
        <div class="w3-container w3-blue-grey w3-round-xlarge">
            <h5>List of Houses</h5>
        </div>
        <div class="w3-margin">
            <input class="w3-input w3-light-blue w3-round-xlarge" style="width: 40%; margin:auto;" type="submit"
                   value="View">
        </div>
    </div>
</form>

</body>
</html>
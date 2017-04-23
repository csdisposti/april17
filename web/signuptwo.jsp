<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>New Member Sign Up - Ascend</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="http://ascend.2ndmm.com/css/style.css">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="header.jsp" />
    <!--begin main text-->
    <div class="row gray">
        <h3 class="text-center">Enter Your Info</h3>
        <hr>
        <div class="col-sm-2">
        </div>
        <form action="Welcome" method="POST">
            <input type="hidden"  name="action" value="login">
        <div class="col-sm-3">
                <input type="hidden" id="email" name="email" title="email" value="${email}">
                <input type="hidden" id="password" name="password" title="password" value="${password}">
            <label for="fname">First Name:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="fname" name="fname" title="First Name - Letters/Numbers/Apostrophes Only" required/> <br />
            <label for="lname">Last Name:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="lname" name="lname" title="Last Name - Letters/Numbers/Apostrophes Only" required/> <br />
            <label for="phone1">Phone 1:</label><br />
            <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="phone1" name="phone1" title="Phone 1 - Please enter in the following format: 555-555-5555" required/>
            <span> Example: 555-555-5555</span><br>
            <label for="phone2">Phone 2:</label><br />
            <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="phone2" name="phone2" title="Phone 2 - Please enter in the following format: 555-555-5555" />
            <span> Example: 555-555-5555</span><br>
        <hr>
        </div>
            <div class="col-sm-3">
            <label for="street">Street Address:</label><br />
            <input type="text" pattern="^[a-zA-Z0-9-#-.-'\s]{1,24}$" id="street" name="street" title="Street - Letters/Numbers/Apostrophes/Hashtags Only" required/><br />
            <label for="city">City:</label><br />
            <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="city" name="city" title="City - Letters/Numbers/Apostrophes Only" required/> <br />
            <label for="state">State:</label><br />
            <select id="state" name="state" title="State">
                <option value="NC">North Carolina</option>
                <option value="SC">South Carolina</option>
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="DC">District Of Columbia</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KS">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MS">Mississippi</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
            </select><br>
            <label for="zip">Zip Code:</label><br />
            <input type="text" pattern="[0-9]{5}" id="zip" name="zip" title="Zip Code - 5 digits only" required/> <br />
                <span> Example: 12345</span><br>
            <hr>
            </div>
        <div class="col-sm-3">
            <label for="emerconname">Emergency Contact Name:</label><br />
            <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="emerconname" name="emerconname" title="Emergency Contact Name - Letters/Numbers/Apostrophes Only" /> <br />
            <label for="emerconphone">Emergency Contact Phone:</label><br />
            <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="emerconphone" name="emerconphone" title="Emergency Contact Phone - Please enter in the following format: 555-555-5555" />
            <span> Example: 555-555-5555</span><br>
            <label>Account Type:</label><br />
            <input type="radio" name="accttype" title="Account Type" value="I"> I - Individual
            <input type="radio" name="accttype" title="Account Type" value="F"> F = Family
            <input type="radio" name="accttype" title="Account Type" value="D"> D = Donor
            <input type="radio" name="accttype" title="Account Type" value="T" checked="checked"> T = Trial<br>
            <hr>
            <input type="submit"  class="btn btn-default btn-sp" value="Complete Sign Up" />
        <hr>
        </div>
        </form>
        <div class="col-sm-1">
        </div>


        <img src="http://ascend.2ndmm.com/images/plane1.jpg" class="img-responsive center-block">
        <hr>
    <footer class="text-center">
        <h4>Ascend, Inc. - <em>Soaring to New Heights</em></h4>
        <address>
			<span>
				<a href="mailto:csdisposti@my.waketech.edu?subject=Ascend,Inc." class="email_break">
				<span>info@ascend.2ndmm.com</span></a>
			</span><br>
            <span>919-866-5000</span><br>
            <span>9101 Fayetteville Road
				<br>Raleigh</span>,
            <span>NC</span>
            <span>27603 </span>
        </address>
        <p>Copyright 2017 Ascend, Inc.<br>All rights reserved</p>
    </footer>
    <hr>
    </div>
</div>
<!--end main text-->
</body>
</html>




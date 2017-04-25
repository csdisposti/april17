<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Airport Add - Ascend</title>
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
    <jsp:include page="adminnav.jsp" />
    <div class="row gray">
        <h3 class="text-center">Add New Airport</h3>
        <hr>
<div class="col-sm-2"></div>
        <form action="AirportAddSubmit" method="POST">
            <input type="hidden" id="username" name="username" value="${username}"/>
            <input type="hidden" id="password" name="password" value="${password}"/>
            <div class="col-sm-3">
                <input type="hidden"  name="action" value="login">
                <label for="faa">FAA Code:</label><br />
                <input type="text" pattern="^N?([a-zA-Z0-9-.-'\s]{1,6})$" id="faa" name="faa" title="FAA Code" value="" required><br/>
                <span> No more than six characters</span><br>
                <label for="airportName">Airport Name:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="airportName" name="airportName" title="Airport Name" value="" required/><br />
                <label for="airportType">Airport Type:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="airportType" name="airportType" title="Airport Title" value="" required/><br />
                <label for="streetAddress">Street Address:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="streetAddress" name="streetAddress" title="Airport Street" value="" required/><br />
                <label for="city">City:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-#-.-'\s]{1,24}$" id="city" name="city" title="Airport City" value="" required/><br />
            </div>
            <div class="col-sm-3">
                <label for="latitude">Latitude:</label><br />
                <input type="text" pattern="{-?\d{1,3}\.\d+}" id="latitude" name="latitude" title="Latitude" value="" required/><br />
                <label for="longitude">Longitude:</label><br />
                <input type="text" pattern="{-?\d{1,3}\.\d+}" id="longitude" name="longitude" title="Logitude" value="" required/><br />
                <label for="ctaf">CTAF_UNICOM:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="ctaf" name="ctaf" title="CTAF_UNICOM" value="" required/><br />
                <label for="runwayType">Runway Type:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="runwayType" name="runwayType" title="Runway Type" value="" required/><br />
                <label for="towerFreq">Tower Frequency:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="towerFreq" name="towerFreq" title="Tower Frequency" value="" required/><br />
                <label for="fuel">Fuel:</label><br />
                <input type="number" pattern="[0-9]{1,10}" id="fuel" name="fuel" title="Fuel" value="" required/><br />
                <label for="storage">Storage:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="storage" name="storage" title="Storage" value="" required/><br />
                <p>&nbsp;</p>
            </div>
            <div class="col-sm-3">
                <label for="contactName">Contact Name:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="contactName" name="contactName" title="Contact Name" value="" required/><br />
                <label for="contactPhone">Contact Phone:</label><br />
                <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="contactPhone" name="contactPhone" title="Contact Phone" value="" required/><br />
                <span> Example: 555-555-5555</span><br>
                <hr>
                <input type="submit"  class="btn btn-default btn-sp" value="Add Airport" />
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
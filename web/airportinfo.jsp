<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Airport Info - Ascend</title>
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
    <header class="text-center">
        <img alt="ascend logo" class="img-responsive center-block" src="http://ascend.2ndmm.com/images/logo.png"/>
        <hr>
    </header>
    <!--begin main text-->
    <div class="row gray">
        <h3 class="text-center">Update Existing Airport</h3>
        <hr>
<div class="col-sm-2"></div>
        <form action="AirportManagementSubmit" method="POST">
            <div class="col-sm-4">
                <input type="hidden"  name="action" value="login">
                <label for="FAA">FAA Code:</label><br />
                <input type="text" id="FAA" name="FAA" title="FAA Code" value=""><br/>
                <label for="airportname">Airport Name:</label><br />
                <input type="text" id="airportname" name="airportname" title="Airport Name" value=""/><br />
                <label for="airporttype">Airport Type:</label><br />
                <input type="text" id="airporttype" name="airporttype" title="Airport Title" value=""/><br />
                <label for="airportstreet">Street Address:</label><br />
                <input type="text" id="airportstreet" name="airportstreet" title="Airport Street" value=""/><br />
                <label for="airportcity">City:</label><br />
                <input type="text" id="airportcity" name="airportcity" title="Airport City" value=""/><br />
                <label for="latitude">Latitude:</label><br />
                <input type="number" pattern="{-?\d{1,3}\.\d+}" id="latitude" name="latitude" title="Latitude" value=""/><br />
                <label for="logitude">Longitude:</label><br />
                <input type="number" pattern="{-?\d{1,3}\.\d+}" id="logitude" name="logitude" title="Logitude" value=""/><br />
                <label for="apcontactn">Contact Name:</label><br />
                <input type="text" id="apcontactn" name="apcontactn" title="Contact Name" value=""/><br />
                <label for="apcontactp">Contact Phone:</label><br />
                <input type="text" id="apcontactp" name="apcontactp" title="Contact Phone" value=""/><br />
            </div>
            <div class="col-sm-4">
                <label for="ctaf">CTAF_UNICOM:</label><br />
                <input type="text" id="ctaf" name="cfat" title="CTAF_UNICOM" value=""/><br />
                <label for="runway">Runway Type:</label><br />
                <input type="text" id="runway" name="runway" title="Runway Type" value=""/><br />
                <label for="towerfreq">Tower Frequency:</label><br />
                <input type="text" id="towerfreq" name="towerfreq" title="Tower Frequency" value=""/><br />
                <label for="fuel">Fuel:</label><br />
                <input type="text" id="fuel" name="fuel" title="Fuel" value=""/><br />
                <label for="storage">Storage:</label><br />
                <input type="text" id="storage" name="storage" title="Storage" value=""/><br />
                <label for="airportcomms">Airport Comments:</label><br />
                <textarea rows="10" cols="30" id="airportcomms" name="airportcomms" value="" title="Airport Comments"></textarea> <br />
                <input type="submit"  class="btn btn-default btn-sp" value="Update Existing Airport" />
            </div>
        </form>
    <div class="col-sm-2">
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
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
        <h3 class="text-center">Update Existing Maintenance</h3>
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
                <input type="text" id="latitude" name="latitude" title="Latitude" value=""/><br />
                <label for="logitude">Longitude:</label><br />
                <input type="text" id="logitude" name="logitude" title="Logitude" value=""/><br />
                //resume here
                <label for="conend">Contact Name:</label><br />
                <input type="text" id="conend" name="conend" title="conend" value="John Fadok"/><br />
                <label for="paymeth">Contact Phone:</label><br />
                <input type="text" id="paymeth" name="paymeth" title="paymeth" value="828-693-1897"/><br />
            </div>
            <div class="col-sm-4">
            <label for="contot">CTAF_UNICOM:</label><br />
                <input type="text" id="contot" name="contot" title="contot" value="123"/><br />
                <label for="constart">Runway Type:</label><br />
                <input type="text" id="constart" name="constart" title="constart" value="asphalt"/><br />
                <label for="conend">Tower Frequency:</label><br />
                <input type="text" id="conend" name="conend" title="conend" value="No Tower"/><br />
                <label for="paymeth">Fuel:</label><br />
                <input type="text" id="paymeth" name="paymeth" title="paymeth" value="0"/><br />
                <label for="contot">Storage:</label><br />
                <input type="text" id="contot" name="contot" title="contot" value="hangers"/><br />
                <label for="concomms">Airport Comments:</label><br />
                <textarea rows="10" cols="30" id="concomms" name="concomms" value="Great airport" title="concomms"></textarea> <br />
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
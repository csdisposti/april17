<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Aircraft Add - Ascend</title>
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
        <h3 class="text-center">Add New Aircraft</h3>
        <hr>
<div class="col-sm-2"></div>
        <form action="AircraftManagementSubmit" method="POST">
            <div class="col-sm-4">
                <input type="hidden"  name="action" value="login">
                <label for="registrationID">Registration ID:</label><br />
                <input type="text" id="registrationID" name="registrationID" title="registrationID" value=""><br/>
                <input type="hidden" id="email" name="email" title="email" value="">
                <label for="ownerID">Owner ID:</label><br />
                <input type="text" id="ownerID" name="ownerID" title="ownerID" value=""/><br />
                <label for="makeModel">Make &amp; Model:</label><br />
                <input type="text" id="makeModel" name="makeModel" title="makeModel" value=""/><br />
                <label for="aircraftType">Aircraft Type:</label><br />
                <input type="text" id="aircraftType" name="aircraftType" title="aircraftType" value=""/><br />
                <label for="rentalFee">Rental Fee:</label><br />
                <input type="text" id="rentalFee" name="rentalFee" title="rentalFee" value=""/><br />
                <label for="aircraftAge">Aircraft Age:</label><br />
                <input type="text" id="aircraftAge" name="aircraftAge" title="aircraftAge" value=""/><br />
            </div>
            <div class="col-sm-4">
                <label for="flightHours">Flight Hours:</label><br />
                <input type="text" id="flightHours" name="flightHours" title="flightHours" value=""/><br />
                <label for="flightDistance">Flight Distance:</label><br />
                <input type="text" id="flightDistance" name="flightDistance" title="flightDistance" value=""/><br />
                <label for="lastMaintType">Last Maintenance Type:</label><br />
                <input type="text" id="lastMaintType" name="lastMaintType" title="lastMaintType" value=""/><br />
                <label for="lastMaintDate">Last Maintenance Date:</label><br />
                <input type="text" id="lastMaintDate" name="lastMaintDate" title="paymeth" value=""/><br />
                <label for="aircraftComms">Aicraft Comments:</label><br />
                <textarea rows="10" cols="30" id="aircraftComms" name="aircraftComms" title="aircraftComms"></textarea> <br />
                <input type="submit"  class="btn btn-default btn-sp" value="Add New Aircraft" />
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
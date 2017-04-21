<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>

<head>

    <title>Reservation Info - Ascend</title>

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
        <h3 class="text-center">Pending Reservations</h3>
        <hr>
<div class="col-sm-2"></div>
        <form action="ReservationsManagementPendingSubmit" method="POST">
        <div class="col-sm-4">


                <input type="hidden"  name="action" value="login">
                <label for="resid">Reservation ID:</label><br />
                <input type="text" id="resid" name="resid" title="resid" value="17"><br/>
                <input type="hidden" id="email" name="email" title="email" value="${em}">
                <label for="resby">Reserved By:</label><br />
                <input type="text" id="resby" name="resby" title="resby" value="672"/><br />
                <label for="restype">Reservation Type:</label><br />
                <input type="text" id="restype" name="restype" title="restype" value="F"/><br />
                <label for="resres">Resources Reserved:</label><br />
                <input type="text" id="resres" name="resres" title="resres" value="AS"/><br />
                 <label for="resdate">Reservation Date:</label><br />
                 <input type="text" id="resdate" name="resdate" title="resdate" value="2016-05-27"/><br />
            <label for="outtime">Out Time:</label><br />
            <input type="text" id="outtime" name="outtime" title="outtime" value="11:10:00"/><br />
            <label for="intime">In Time:</label><br />
            <input type="text" id="intime" name="intime" title="intime" value="16:25:00"/><br />
        </div>

            <div class="col-sm-4">


                <label for="dest">Destination:</label><br />
                <input type="text" id="dest" name="dest" title="dest" value="EYF"/> <br />
                <label for="instr">Instructor Number:</label><br />
                <input type="text" id="instr" name="instr" title="instr" value="11"/><br />
                <!--<label for="resap">Reservation Approved By:</label><br />
                <input type="text" id="resap" name="resap" title="resap" value=" "/> <br />-->

                <label for="rescomms">Reservation Comments:</label><br />
                <textarea rows="10" cols="30" id="rescomms" name="rescomms" value="Intro level" title="rescomms"></textarea> <br />
                <hr>
                <input type="radio" name="approve" value="approve" > Approve<br>
                <input type="radio" name="reject" value="reject" > Reject<br>

            <input type="submit"  class="btn btn-default btn-sp" value="Submit Reservation" />
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




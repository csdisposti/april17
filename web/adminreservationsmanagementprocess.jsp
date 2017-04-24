<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Manage Reservations - Ascend</title>
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
        <h3 class="text-center">Edit Reservation info</h3>
        <hr>
        <div class="col-sm-2">
        </div>

        <form action="AdminManagementMemberSubmit" method="POST">
            <input type="hidden"  name="action" value="login">
            <input type="hidden" id="username" name="username" value="${username}"/>
            <input type="hidden" id="password" name="password" value="${password}"/>
        <div class="col-sm-3">


            <label for="fname">Reserved by:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="fname" name="fname" title="First Name - Letters/Numbers/Apostrophes Only" value="${resBy}" required/> <br />
            <label for="lname">Reservation Type:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="lname" name="lname" title="Last Name - Letters/Numbers/Apostrophes Only" value="${resType}" required/> <br />
            <label for="phone1">Aircraft Reserved:</label><br />
            <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="phone1" name="phone1" title="Phone 1 - Please enter in the following format: 555-555-5555" value="${resourcesRes}" required/><br>
            <label for="resdate">Reservation Date: </label><br>
            <input type="date" id="resdate" name="resdate" title="Reservation Date" required/> <br>
            <span class="firefoxonly"> enter as YYYY-MM-DD</span><br>
        </div>
            <div class="col-sm-3">
                <label for="outTime">Start Time: </label><br>
                <input type="text" pattern="([01]?[0-9]|2[0-3]):[0,1,3,4][0,5]"  id="outTime" name="outTime" title="Start Time"  value="${outTime}" required/><br>
                <span> enter using 24 hour clock ex: 13:30</span><br>
                <span> reservations are available at :00, :15, :30, and :45</span><br>
                <label for="inTime">End Time: </label><br>
                <input type="text" pattern="([01]?[0-9]|2[0-3]):[0,1,3,4][0,5]"  id="inTime" name="inTime" title="End Time"  value="${inTime}" required/><br>
                <span> enter using 24 hour clock ex: 13:30</span><br>
                <span> reservations are available at :00, :15, :30, and :45</span><br>
            </div>
            <div class="col-sm-3">
                <label for="dest">Destination: </label><br>
                <input type="text" pattern="([01]?[0-9]|2[0-3]):[0,1,3,4][0,5]"  id="dest" name="dest" title="Destination"  value="${dest}" required/><br>
                <label for="instNo">Instructor Number:</label><br />
                <input type="text" pattern="[0-9]{5}" id="instNo" name="instNo" title="Instructor Number" value="${instNo}" required/> <br />
                <label>Reservation Status:</label><br />
                <input type="radio" name="resStatus" title="Account Type" value="PENDING" ${PENDING}> PENDING
                <input type="radio" name="resStatus" title="Account Type" value="APPROVED" ${APPROVED}> APPROVED
                <input type="radio" name="resStatus" title="Account Type" value="REJECTED" ${REJECTED}> REJECTED<BR>

                <label for="emerconphone">Approved By:</label><br />
                <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="emerconphone" name="emerconphone" title="Emergency Contact Phone - Please enter in the following format: 555-555-5555" value="${adid}" disabled/>
                <hr>
                <input type="submit"  class="btn btn-default btn-sp" value="Update Reservation" />
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




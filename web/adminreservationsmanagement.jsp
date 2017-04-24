<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

    <title>Admin Reservation Management - Ascend</title>

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
    <div class="row gray text-center">

            <h3 class="text-center">Manage Reservations</h3>
            <div class="col-sm-1">
            </div>

            <div class="col-sm-10">
                <h4>Enter Reservation ID</h4>
                <form action="AdminManagementReservationsProcess" method="post">
                    <label for="resid">Reservation ID:</label><br />
                    <input type="text" id="resid" name="resid" title="Reservation ID" required/><br />
                    <input type="submit" class="btn btn-default btn-sp" value="Edit Reservation"/>
                </form>
                <h4>All Reservations</h4>
                <table class="table table-responsive table-striped table-condensed">
                    <thead>
                    <tr><td>Reservation ID</td><td>Reserved by</td><td>Reservation Type</td><td>Aircraft Reserved</td><td>Reservation Date</td><td>Start Time</td><td>End Time</td><td>Instructor Number
                    </td><td>Reservation Status</td><td>Approved By</td></tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allreservations}" var="allres">
                        <tr>${allres}</tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
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




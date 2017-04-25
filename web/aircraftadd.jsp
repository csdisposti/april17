<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="col-sm-3"></div>
        <form action="AircraftAddSubmit" method="POST">
            <input type="hidden" id="username" name="username" value="${username}"/>
            <input type="hidden" id="password" name="password" value="${password}"/>
            <div class="col-sm-3">
                <input type="hidden"  name="action" value="login">
                <input type="hidden" id="oldreg" name="oldreg" title="Registration ID" required/><br/>
                <label for="registrationID">Registration ID:</label><br />
                <input type="text" pattern="^N?([a-zA-Z0-9-.-'\s]{3,6})$" id="registrationID" name="registrationID" title="Registration ID"  required/><br/>
                <span> No more than five characters<br>must start with "N" Example: N1234</span><br>
                <label for="ownerID">Owner ID:</label><br />
                <input type="text" id="ownerID" name="ownerID" title="Owner ID" required/><br />
                <label for="makeModel">Make &amp; Model:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="makeModel" name="makeModel" title="Make and Model" required/><br />
                <span> Example: Cirrus SR20</span><br>
                <label for="aircraftType">Aircraft Type:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="aircraftType" name="aircraftType" title="Aircraft Type" required/><br />
                <span> Example: Piston</span><br>
                <label for="airportHome">Airport Home:</label><br />
                <select name="airportHome" id="airportHome" title="Airport" required>
                    <c:forEach items="${airporttype}"  var="airportHome">
                        <option value="${airportHome}">${airportHome}</option>
                    </c:forEach>
                </select><br/>
                <label for="airportCurrent">Airport Current:</label><br />
                <select name="airportCurrent" id="airportCurrent" title="Airport" required>
                    <c:forEach items="${airporttype}"  var="airportCurrent">
                        <option value="${airportCurrent}">${airportCurrent}</option>
                    </c:forEach>
                </select><br/>

                <label for="rentalFee">Rental Fee:</label><br />
                <input type="number" id="rentalFee" pattern="{\d+(\.\d{2})?}" name="rentalFee" title="Rental Fee" required/><br />
                <span> Numbers only, Example: 450</span><br>

            </div>
            <div class="col-sm-3">
                <br>
                <label for="aircraftAge">Aircraft Age:</label><br />
                <input type="number" pattern="[0-9]{,3}" id="aircraftAge" name="aircraftAge" title="Aircraft Age" required/><br />
                <span> Whole numbers only, Example: 5</span><br>
                <label for="flightHours">Flight Hours:</label><br />
                <input type="number" id="flightHours" name="flightHours" title="Flight Hours" required/><br />
                <span> Whole numbers only, Example: 1250</span><br/>
                <label for="flightDistance">Flight Distance:</label><br />
                <input type="number" id="flightDistance" name="flightDistance" title="Flight Distance" required/><br />
                <span> Whole numbers only, Example: 5250</span><br/>
                <label for="lastMaintType">Last Maintenance Type:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="lastMaintType" name="lastMaintType" title="Last Maintenance Type" required/><br />
                <span> Example: A Check</span><br/>
                <label for="lastMaintDate">Last Maintenance Date:</label><br />
                <input type="date" id="lastMaintDate" name="lastMaintDate" title="Last Maintenance Date" required/><br />
                <span class="firefoxonly"> Enter as YYYY-MM-DD </span>
               <hr>
                <input type="submit"  class="btn btn-default btn-sp" value="Add Aircraft" />
                <hr>
            </div>
        </form>
    <div class="col-sm-3">
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
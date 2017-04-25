<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Airport Management - Ascend</title>
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
        <h3 class="text-center">Airport Management</h3>
        <hr>
        <div class="col-sm-3">
        </div>
        <div class="col-sm-3 text-center">
            <h4>Add New Airport</h4>
            <form action="AirportAdd" method="post">
                <input type="hidden" id="username" name="username" value="${username}"/>
                <input type="hidden" id="password" name="password" value="${password}"/>
                <input type="submit" class="btn btn-default btn-sp" value="Add New Airport"/>
            </form>
            <hr>
        </div>
        <div class="col-sm-3 text-center">
            <form action="AirportUpdate" method="post">
                <input type="hidden" id="usernameau" name="username" value="${username}"/>
                <input type="hidden" id="passwordau" name="password" value="${password}"/>
                <h4>Choose Airport to edit</h4>
                <input id="airport" type="hidden" value="${airporttype}"/>
                <select name="airporttype" id="airporttype" title="Airport" required>
                    <c:forEach items="${airporttype}"  var="airp">
                        <option value="${airp}">${airp}</option>
                    </c:forEach>
                </select><br/>
                <input type="submit" class="btn btn-default btn-sp" value="Update Existing Airport"/>
            </form>
            <hr>
        </div>
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
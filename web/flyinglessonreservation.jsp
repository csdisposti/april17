<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flying Lesson Reservation - Ascend</title>
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
    <jsp:include page="membernav.jsp" />
    <div class="row gray">
        <h3 class="text-center">Flying Lesson Reservation</h3>
         <hr>
            <div class="col-sm-2">
            </div>
        <form action="FlyingLessonReservationSubmit" method="post">
            <input type="hidden" id="usernameflr" name="username" value="${username}"/>
            <input type="hidden" id="passwordflr" name="password" value="${password}"/>
            <input type="hidden" id="memberfid" name="memberid" value="${memid}"/>
            <div class="col-sm-4">
                <h4>Date you would like to schedule your reservation:</h4>
                <label for="resdate">Reservation Date: </label>
                <input type="date" id="resdate" name="resdate" title="Reservation Date" required/> <br>
                <span> enter as MM-DD-YYYY </span>
                <br>
                <h4>Time you would like to schedule your reservation:</h4>
                <label for="restime">Reservation Time: </label>
                <input type="text" pattern="([01]?[0-9]|2[0-3]):[0,1,3,4][0,5]"  id="restime" name="restime" title="Reservation Time"  required/><br>
                <span> enter using 24 hour clock ex: 13:30</span><br>
                <span> reservations are available at :00, :15, :30, and :45</span><br>
                <h4>Length of time you would like for your Flying Lesson:</h4>
                <label for="lengthoftime">Length of Flying Lesson:</label>
                <select id="lengthoftime" name="lengthoftime" title="lengthoftime">
                    <option value="1">1 Hour</option>
                    <option value="2">2 Hour</option>
                    <option value="3">3 Hour</option>
                </select><br>
                <p>&nbsp;</p>
            </div>
            <div class="col-sm-4">
                <h4>What type of aircraft would you like to reserve?</h4>
                <input id="aircrafttype" type="hidden" value="${aircrafttype}"/>
                <select name="act" title="Aircraft Type" required>
                <c:forEach items="${aircrafttype}" var="at">
                <option value="${at}">${at}</option>
                </c:forEach>
            </select>
                <span> (choose an Aircraft)</span><br>
                <hr>
                <h4>Instructor you would you like to schedule for your reservation:</h4>
                <input id="instructors" type="hidden" value="${instructortype}"/>
                <select name="ins" title="Instructor" required>
                    <c:forEach items="${instructortype}" var="it">
                        <option value="${it}">${it}</option>
                    </c:forEach>
                </select> <span> (choose an Instructor)</span><br>
                <p>&nbsp;</p>
                <input type="submit" class="btn btn-default btn-sp" value="Submit Reservation Request"/>
                <p>&nbsp;</p>
            </div>
        </form>
            <div class="col-sm-2">
            </div>
        <hr>
        <p><img src="http://ascend.2ndmm.com/images/plane1.jpg" class="img-responsive center-block"></p>
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
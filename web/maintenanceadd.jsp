<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.example.Login"%>

<!DOCTYPE html>

<html>

<head>

    <title>Maintenance Add - Ascend</title>

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
        <h3 class="text-center">Schedule New Maintenance</h3>
        <hr>
<div class="col-sm-4"></div>
        <form action="MaintenanceManagementSubmit" method="POST">
        <div class="col-sm-4">


                <input type="hidden"  name="action" value="login">
                <label for="scid">Service Contract ID:</label><br />
                <input type="text" id="scid" name="scid" title="scid" value=""><br/>
                <input type="hidden" id="email" name="email" title="email" value="">
                <label for="contot">Contract Total:</label><br />
                <input type="text" id="contot" name="contot" title="contot" value=""/><br />
                <label for="constart">Contract Start Date:</label><br />
                <input type="text" id="constart" name="constart" title="constart" value=""/><br />
                <label for="conend">Contract End Date:</label><br />
                <input type="text" id="conend" name="conend" title="conend" value=""/><br />
                 <label for="paymeth">Payment Method:</label><br />
                 <input type="text" id="paymeth" name="paymeth" title="paymeth" value=""/><br />
            <label for="concomms">Contract Comments:</label><br />
            <textarea rows="10" cols="30" id="concomms" name="concomms" value=" " title="concomms"></textarea> <br />



            <input type="submit"  class="btn btn-default btn-sp" value="Schedule New Maintenance" />
        </div>
        </form>

    <div class="col-sm-4">
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




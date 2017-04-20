<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.example.Login"%>

<!DOCTYPE html>

<html>

<head>

    <title>Edit Member - Ascend</title>

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
        <div class="col-sm-2">
        </div>
        <form action="MemberManagementSubmit" method="POST">
        <div class="col-sm-3">
            <h3 class="text-center">Edit Member Basic Info</h3>
            <hr>

                <input type="hidden"  name="action" value="login">
                <input type="hidden" id="memid" name="memid" title="memid" value=${mid}>
                <input type="hidden" id="email" name="email" title="email" value="${em}">
                <label for="fname">First Name:</label><br />
                <input type="text" id="fname" name="fname" title="fname" value="${fn}"/><br />
                <label for="lname">Last Name:</label><br />
                <input type="text" id="lname" name="lname" title="lname" value="${ln}"/> <br />
                <label for="phone1">Phone 1:</label><br />
                <input type="text" id="phone1" name="phone1" title="phone1" value="${ph1}"/><br />
                <label for="phone2">Phone 2:</label><br />
                <input type="text" id="phone2" name="phone2" title="phone2" value="${ph2}"/> <br />
                <label for="en">Emergency Contact Name:</label><br />
                <input type="text" id="en" name="en" title="en" value="${ecn}"/><br />
                <label for="ep">Emergency Contact Phone:</label><br />
                <input type="text" id="ep" name="ep" title="ep" value="${ecp}"/> <br />
                <label for="memcomms">Member Comments:</label><br />
                <textarea rows="10" cols="30" id="memcomms" name="memcomms" value="${memcomms}" title="memcomms"></textarea> <br />


        </div>
        <div class="col-sm-3">
            <h3 class="text-center">Edit Member Account Info</h3>
            <hr>
            <input type="hidden" id="accid" name="accid" title="accid" value=${accid}>
                <label for="accttype">Account Type:</label><br />
                <input type="text" id="accttype" name="accttype" title="accttype" value="${accttype}"/><br />
                <span>I = Individual, F = Family, D = Donor, T = Trial</span><br/>
                <label for="street">Street:</label><br />
                <input type="text" id="street" name="street" title="street" value="${street}"/> <br />
                <label for="city">City:</label><br />
                <input type="text" id="city" name="city" title="city" value="${city}"/><br />
                <label for="state">State:</label><br />
                <input type="text" id="state" name="state" title="state" value="${state}"/> <br />
                <label for="zip">Zip Code:</label><br />
                <input type="text" id="zip" name="zip" title="zip" value="${zip}"/><br />
                <label for="payplan">Payment Plan:</label><br />
                <input type="text" id="payplan" name="payplan" title="payplan" value="${payplan}"/> <br />
                <span>D = DirectDraft, C = CreditCard, K = Check, P = Prepaid </span><br/>

            <label for="totcharges">Total Charges:</label><br />
            <input type="text" id="totcharges" name="totcharges" title="totcharges" value="${totcharges}"/> <br />
            <label for="totpayments">Total Payments:</label><br />
            <input type="text" id="totpayments" name="totpayments" title="totpayments" value="${totpayments}"/> <br />
            <label for="creditreduc">Credits Reductions:</label><br />
            <input type="text" id="creditreduc" name="creditreduc" title="creditreduc" value="${creditreduc}"/> <br />
           <label for="lastinvoicedate">Last Invoice Date:</label><br />
            <input type="text" id="lastinvoicedate" name="lastinvoicedate" title="lastinvoicedate" value="${lastinvoicedate}"/> <br />
            <label for="lastpaymentdate">Last Payment Date:</label><br />
            <input type="text" id="lastpaymentdate" name="lastpaymentdate" title="lastpaymentdate" value="${lastpaymentdate}"/> <br />
            <label for="accountstatus">Account Status:</label><br />
            <input type="text" id="accountstatus" name="accountstatus" title="accountstatus" value="${accountstatus}"/> <br />
            <span>A, B, C = Grades, F = Issues, N = NewAccount </span><br/>
            <label for="acccomms">Account Comments:</label><br />
                <textarea rows="10" cols="30" id="acccomms" name="acccomms" value="${acccomms}" title="acccomms"></textarea> <br />
<br>


        </div>
            <div class="col-sm-3">
                <h3 class="text-center">Edit Member Status</h3>
                <hr>
                <label for="admin">Admin:</label><br />
                <input type="text" id="admin" name="admin" title="admin" value="Yes"/><br />
                <label for="mechanic">Mechanic:</label><br />
                <input type="text" id="mechanic" name="mechanic" title="mechanic" value="No"/><br />
                <label for="instructor">Instructor:</label><br />
                <input type="text" id="instructor" name="instructor" title="instructor" value="No"/><br />
            <input type="submit"  class="btn btn-default btn-sp" value="Update Member/Account Info" />
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




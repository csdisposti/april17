<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Manage Member- Ascend</title>
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
        <h3 class="text-center">Edit Member's info</h3>
        <hr>
        <div class="col-sm-2">
        </div>

        <form action="AdminManagementMemberSubmit" method="POST">
            <input type="hidden"  name="action" value="login">
            <input type="hidden" id="accountid" name="accountid" value="${ai}"/>
            <input type="hidden" id="memberid" name="memberid" value="${mi}"/>
            <input type="hidden" id="username" name="username" value="${username}"/>
            <input type="hidden" id="password" name="password" value="${password}"/>
            <input type="hidden" id="oldemail" name="oldemail" value="${email}"/>
        <div class="col-sm-3">
            <label for="fname">First Name:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="fname" name="fname" title="First Name - Letters/Numbers/Apostrophes Only" value="${fn}" required/> <br />
            <label for="lname">Last Name:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="lname" name="lname" title="Last Name - Letters/Numbers/Apostrophes Only" value="${ln}" required/> <br />
            <label for="phone1">Phone 1:</label><br />
            <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="phone1" name="phone1" title="Phone 1 - Please enter in the following format: 555-555-5555" value="${p1}" required/>
            <span> Example: 555-555-5555</span><br>
            <label for="phone2">Phone 2:</label><br />
            <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="phone2" name="phone2" title="Phone 2 - Please enter in the following format: 555-555-5555" value="${p2}"/>
            <span> Example: 555-555-5555</span><br>
            <label for="street">Street Address:</label><br />
            <input type="text" pattern="^[a-zA-Z0-9-#-.-'\s]{1,24}$" id="street" name="street" title="Street - Letters/Numbers/Apostrophes/Hashtags Only" value="${st}" required/><br />
            <label for="city">City:</label><br />
            <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="city" name="city" title="City - Letters/Numbers/Apostrophes Only" value="${ct}"required/> <br />
            <label for="state">State:</label><br />
            <select id="state" name="state" title="State">
                <option value="NC" ${NC}>North Carolina</option>
                <option value="SC" ${SC}>South Carolina</option>
                <option value="AL" ${AL}>Alabama</option>
                <option value="AK" ${AK}>Alaska</option>
                <option value="AZ" ${AZ}>Arizona</option>
                <option value="AR" ${AR}>Arkansas</option>
                <option value="CA" ${CA}>California</option>
                <option value="CO" ${CO}>Colorado</option>
                <option value="CT" ${CT}>Connecticut</option>
                <option value="DE" ${DE}>Delaware</option>
                <option value="DC" ${DC}>District Of Columbia</option>
                <option value="FL" ${FL}>Florida</option>
                <option value="GA" ${GA}>Georgia</option>
                <option value="HI" ${HI}>Hawaii</option>
                <option value="ID" ${ID}>Idaho</option>
                <option value="IL" ${IL}>Illinois</option>
                <option value="IN" ${IN}>Indiana</option>
                <option value="IA" ${IA}>Iowa</option>
                <option value="KS" ${KS}>Kansas</option>
                <option value="KY" ${KY}>Kentucky</option>
                <option value="LA" ${LA}>Louisiana</option>
                <option value="ME" ${ME}>Maine</option>
                <option value="MD" ${MD}>Maryland</option>
                <option value="MA" ${MA}>Massachusetts</option>
                <option value="MI" ${MI}>Michigan</option>
                <option value="MN" ${MN}>Minnesota</option>
                <option value="MS" ${MS}>Mississippi</option>
                <option value="MO" ${MO}>Missouri</option>
                <option value="MT" ${MT}>Montana</option>
                <option value="NE" ${NE}>Nebraska</option>
                <option value="NV" ${NV}>Nevada</option>
                <option value="NH" ${NH}>New Hampshire</option>
                <option value="NJ" ${NJ}>New Jersey</option>
                <option value="NM" ${NM}>New Mexico</option>
                <option value="NY" ${NY}>New York</option>
                <option value="ND" ${ND}>North Dakota</option>
                <option value="OH" ${OH}>Ohio</option>
                <option value="OK" ${OK}>Oklahoma</option>
                <option value="OR" ${OR}>Oregon</option>
                <option value="PA" ${PA}>Pennsylvania</option>
                <option value="RI" ${RI}>Rhode Island</option>
                <option value="SD" ${SD}>South Dakota</option>
                <option value="TN" ${TN}>Tennessee</option>
                <option value="TX" ${TX}>Texas</option>
                <option value="UT" ${UT}>Utah</option>
                <option value="VT" ${VT}>Vermont</option>
                <option value="VA" ${VA}>Virginia</option>
                <option value="WA" ${WA}>Washington</option>
                <option value="WV" ${WV}>West Virginia</option>
                <option value="WI" ${WI}>Wisconsin</option>
                <option value="WY" ${WY}>Wyoming</option>
            </select><br>
            <label for="zip">Zip Code:</label><br />
            <input type="text" pattern="[0-9]{5}" id="zip" name="zip" title="Zip Code - 5 digits only" value="${zi}" required/> <br />
            <span> Example: 12345</span><br>
        <hr>
        </div>
            <div class="col-sm-3">
                <label for="emerconname">Emergency Contact Name:</label><br />
                <input type="text" pattern="^[a-zA-Z0-9-.-'\s]{1,24}$" id="emerconname" name="emerconname" title="Emergency Contact Name - Letters/Numbers/Apostrophes Only" value="${ec}" /> <br />
                <label for="emerconphone">Emergency Contact Phone:</label><br />
                <input type="tel" pattern="^\d{3}-\d{3}-\d{4}$" id="emerconphone" name="emerconphone" title="Emergency Contact Phone - Please enter in the following format: 555-555-5555" value="${ep}" />
                <span> Example: 555-555-5555</span><br>
            <hr>
                <label>Account Type:</label><br />
                <input type="radio" name="accttype" title="Account Type" value="I" ${I}> Individual
                <input type="radio" name="accttype" title="Account Type" value="F" ${F}> Family
                <input type="radio" name="accttype" title="Account Type" value="D" ${D}> Donor
                <input type="radio" name="accttype" title="Account Type" value="T" ${T}> Trial<br>
                <hr>

            </div>
        <div class="col-sm-3">


            <label>Admin Status:</label><br />
            <input type="radio" name="adminStatus" title="Admin Status" value="asYES" ${asYES}> Admin
            <input type="radio" name="adminStatus" title="Admin Status" value="asNO" ${asNO}> Non-Admin<br>
            <span>Note: If member has ever been an admin, member will always show as an admin. Check below for admin type to see if active or inactive admin.</span>
            <hr>
            <label>Admin Type:</label><br />
            <input type="radio" name="adminType" title="Admin Type" value="A" ${AA}> Admin
            <input type="radio" name="adminType" title="Admin Type" value="I" ${IA}> Instructor
            <input type="radio" name="adminType" title="Admin Type" value="N" ${NA}> Non-Admin/Inactive Admin
            <hr>
            <input type="email" id="email" name="email" title="Signup-Email" value="${email}" /><br />
            <label for="passwordcurrent">Current Password:</label><br />
            <input type="text" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="passwordcurrent" name="passwordcurrent" title="Current Password" value="${passwordcurrent}" required/> <br />
            <label for="passwordnew">New Password:</label><br />
            <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="passwordnew" name="passwordnew" title="Password must be at least 8 charcaters long and must include at least 1 uppercase, 1 lowercase, and 1 number" /> <br />
            <span>Password must be at least 8 characters long</span><br><span>and must include at least 1 uppercase, 1 lowercase, and 1 number</span><br>
            <label for="passwordnewcheck">Re-Enter Password:</label><br />
            <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="passwordnewcheck"
                   name="passwordnewcheck" title="Passwords do not match" /> <br />
            <hr>
            <input type="submit"  class="btn btn-default btn-sp" value="Update Member" />
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




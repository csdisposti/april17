<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>New Member Sign Up - Ascend</title>
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
    <div class="row gray text-center">
        <div class="col-sm-3">
        </div>
        <div class="col-sm-6">
            <h2 class="text-center">New Member - Create Account</h2>
            <form action="SignupTwo" method="POST">
            <input type="hidden"  name="action" value="login">
                <label for="email">Email:</label><br />
                <input type="email" id="email" name="email" title="Signup-Email" required/><br />
            <label for="password">Password:</label><br />
            <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="password" name="password" title="Password must be at least 8 charcaters long and must include at least 1 uppercase, 1 lowercase, and 1 number" required/> <br />
                <span>Password must be at least 8 charcaters long</span><br><span>and must include at least 1 uppercase, 1 lowercase, and 1 number</span><br>
            <input type="submit"  class="btn btn-default btn-sp" value="Create Account" />
        </form>
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
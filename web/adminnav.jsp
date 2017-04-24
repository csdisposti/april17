<div class="row">
    <div class="col-sm-8 text-left">
        <a href="https://sites.google.com/view/flight-club-help-center/video-tutorials" class="btn btn-default" target="_blank">Help Center</a>
    </div>
    <div class="col-sm-2 text-right">
        <h4 class=text-center" >Hi ${fnad}!</h4>
        <hr>
    </div>
    <div class="col-sm-1">
        <form action="AdminPortal" method="post">
            <input type="hidden" id="username" name="username" value="${username}"/>
            <input type="hidden" id="password" name="password" value="${password}"/>
            <input type="submit" class="btn btn-default" value="Admin Portal"/>
        </form>
    </div>
    <div class="col-sm-1">
        <form action="Logout" method="post">
            <input type="submit" class="btn btn-default" value="Log Out"/>
        </form>
    </div>
    <hr>
</div>
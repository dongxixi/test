<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <style>
        body{
            background-color: #f6ffc7;

        }
        #login{
            position: absolute;
            width: 527px;
            height: 307px;
            top: 150px;
            left: 410px;
            background-image: url("../img/login.jpg");
        }
        #login_form{
            position: relative;
            top: 60px;
            left: 300px;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form row" id="login" method="post" action="/RegisterServlet">
        <div class="form-horizontal col-md-offset-3" id="login_form">
            <a href="../index.jsp" style="font-size: 22px">切换到登录</a><br/>
            <div class="col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Confirm Password" id="Confirm" name="password" maxlength="8"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="email" id="email" name="email" maxlength="30"/>
                </div>
                <div class="form-group col-md-offset-9">
                    <button type="submit" class="btn btn-primary pull-right" name="submit">注册</button>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>

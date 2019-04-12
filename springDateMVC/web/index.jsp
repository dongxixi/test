<%--
  Created by IntelliJ IDEA.
  User: yang1
  Date: 2019/4/2
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<%--    <script>--%>
<%--        $(function () {--%>
<%--            $("#put").click(function () {--%>
<%--                $.post("/login.do",--%>
<%--                    {--%>
<%--                        name: $("#name").val(),--%>
<%--                        password: $("#password").val()--%>
<%--                    },--%>
<%--                    function (json) {--%>
<%--                        $("#table").empty();--%>
<%--                        $("#table").append($("<tr><th>年限</th><th>年薪</th></tr>"));--%>
<%--                        $.each(json,function (i, e) {--%>
<%--                            $("#table").append($("<tr><td>" + e.year + "</td><td>" + e.salary + "</td></tr>"));--%>
<%--                        })--%>
<%--                    },--%>
<%--                    "json"--%>
<%--                );--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>
<%--    <script>--%>
<%--        $(function () {--%>
<%--            $("#register").click(function () {--%>
<%--                if ($("#password").val() != $("#repeatPassword").val) {--%>
<%--                    return false;--%>
<%--                } else {--%>
<%--                    return true;--%>
<%--                }--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>
</head>
<body>
<form action="/register.do" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="userName" /><br/><br/>
    <input type="file" name="multipartFile"/><br/><br/>
    密码：<input type="password" name="password" /><br/><br/>
    重复密码：<input type="password" name="repeatPassword" /><br/><br/>
    <input type="submit" name="register" value="注册"/>

</form>

<table id="table">

</table>
</body>
</html>

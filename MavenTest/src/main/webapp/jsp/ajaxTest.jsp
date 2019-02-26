<%--
  Created by IntelliJ IDEA.
  User: yang1
  Date: 2019/2/25
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
    <script>
        $(function () {
            $("#txt").blur(function () {
                <%--var xhr = null;--%>
                <%--if (window.XMLHttpRequest) {--%>
                    <%--xhr = new XMLHttpRequest();--%>
                <%--} else {--%>
                    <%--xhr = new ActiveXObject("Microsoft.XMLHTTP");--%>
                <%--}--%>
                <%--xhr.onreadystatechange = function () {--%>
                    <%--if (xhr.readyState == 4) {--%>
                        <%--if (xhr.status = 200) {--%>
                            <%--var jsonStr = xhr.responseText;--%>
                            <%--eval("var json = " + jsonStr);--%>
                            // if (json.success == true) {
                            //     $("#span").css("color", "green");
                            //     $("#span").text("通过");
                            // } else {
                            //     $("#span").css("color", "red");
                            //     $("#span").text("未通过");
                            // }
                        <%--} else {--%>
                            <%--alert(xhr.status);--%>
                        <%--}--%>
                    <%--}--%>
                <%--}--%>
                <%--xhr.open("get", "${pageContext.request.contextPath}/ajaxServlet?_=" + new Date().getTime()--%>
                    <%--+ "&txt=" + $("#txt").val(), true);--%>

                <%--xhr.send();--%>
                $.get("/ajaxServlet", {txt:$("#txt").val()}, function (data) {
                    eval("var json = " + data);

                    if (json.success == true) {
                        $("#span").css("color", "green");
                        $("#span").text("通过");
                    } else {
                        $("#span").css("color", "red");
                        $("#span").text("未通过");
                    }
                })
            })
        })
    </script>
</head>
<body>
<input type="text" id="txt"/><span id="span" style="color: green"></span>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: yang1
  Date: 2019/2/25
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示用户</title>
    <script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
    <script>
        $(function () {
            $("#showuser").click(function () {
                $.get("/ShowUserServlet", {_:new Date().getTime()}, function (data) {
                    eval("var json = " + data);
                    var list = json.list;
                    var htmlstr = "<tr>" +
                        "        <th>id</thn" +
                        "        <th>名称</th>" +
                        "        <th>班级</th>" +
                        "        <th>性别</th>" +
                        "        <th>年龄</th>" +
                        "        <th>分数</th>" +
                        "    </tr>";
                    for (var i = 0 in list) {
                        htmlstr += "<tr><td>" + list[i].id + "</td>" +
                            "<td>" + list[i].name + "</td>" +
                            "<td>" + list[i].grade + "</td>" +
                            "<td>" + list[i].sex + "</td>" +
                            "<td>" + list[i].age + "</td>" +
                            "<td>" + list[i].score + "</td></tr>";
                    }
                    $("#tbody").html(htmlstr);
                })
            })
        })
    </script>
</head>
<body>
    <input type="button" value="展示" id="showuser"/>
<table id="tbody">
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: yang1
  Date: 2019/2/24
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学生信息查询</title>
    <script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
    <script>
        function showlist(){
            $.getJSON("/StudentServlet", {_:new Date().getTime(), pageno:$("#pageno").text(),
                grade:$("#grade").val(), sex:$("#sex").val(),
                scoremin:$("#scoremin").val(), scoremax:$("#scoremax").val()}, function (json) {
                $("#tbody").empty();
                $("#pagetotal").text(json.pagetotal);
                var list = json.list;
                $.each(list, function (i, e) {
                    $("#tbody").append($("<tr><td>" + e.id + "</td>" +
                        "<td>" + e.name + "</td>" +
                        "<td>" + e.grade + "</td>" +
                        "<td>" + e.score + "</td>" +
                        "<td>" + e.sex + "</td>" +
                        "<td>" + e.age + "</td></tr>"))
                });
            });
        }
        $(function () {
            showlist();
            $("#firstpage").click(function () {
                $("#pageno").text(1);
                showlist();
            });
            $("#prevpage").click(function () {
                if ($("#pageno").text() > 1) {
                    $("#pageno").text($("#pageno").text() - 1);
                }
                showlist();
            });
            $("#nextpage").click(function () {
                if ($("#pageno").text() < $("#pagetotal").text()) {
                    $("#pageno").text(parseInt($("#pageno").text()) + 1);
                }
                showlist();
            });
            $("#lastpage").click(function () {
                $("#pageno").text($("#pagetotal").text());
                showlist();
            });
            $("#select").click(function () {
                $("#pageno").text(1);
                showlist();
            });
        });
    </script>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>班级</th>
        <th>成绩</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
</table>
第<span id="pageno">1</span>页，共<span id="pagetotal"></span>页<br/>
    <input type="button" value="首页" name="Page" id="firstpage"/>
    <input type="button" value="上一页" name="Page" id="prevpage"/>
    <input type="button" value="下一页" name="Page" id="nextpage"/>
    <input type="button" value="末页" name="Page" id="lastpage"/><br/>
    查询条件:<br/>
    班级：<input type="text" id="grade"/><br/>
    性别：<input type="text" id="sex"/><br/>
    成绩段：<input type="text" id="scoremin""/>
    至<input type="text" id="scoremax"/>
    <input type="button" value="查询" id="select"/>
</body>
</html>

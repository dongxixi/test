<%--
  Created by IntelliJ IDEA.
  User: yang1
  Date: 2019/2/25
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市联动</title>
    <script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
    <script>
        $(function () {
            $.get("/PamlServlet", {command: "province"}, function (data) {
                eval("var json = " + data);
                var list = json.list;
                var htmlstr = "<option>--请选择--</option>";
                for (var i = 0 in list) {
                    htmlstr += "<option value='" + list[i].code + "'>" + list[i].name + "</option>";
                }
                $("#province").html(htmlstr)
            })
            $("#province").change(function () {
                $.get("/PamlServlet", {command: "city", provincecode: $("#province").select().val()}, function (data) {
                    eval("var json = " + data);
                    var list = json.list;
                    var htmlstr = "<option>--请选择--</option>";
                    for (var i = 0 in list) {
                        htmlstr += "<option value='" + list[i].code + "'>" + list[i].name + "</option>";
                    }
                    $("#city").html(htmlstr)
                })
            })
            $("#city").change(function () {
                $.get("/PamlServlet", {command: "area", citycode: $("#city").select().val()}, function (data) {
                    eval("var json = " + data);
                    var list = json.list;
                    var htmlstr = "<option>--请选择--</option>";
                    for (var i = 0 in list) {
                        htmlstr += "<option value='" + list[i].code + "'>" + list[i].name + "</option>";
                    }
                    $("#area").html(htmlstr)
                })
            })
            $("#area").change(function () {
                $("#areacode").val($("#area").select().val());
            })
        })
    </script>
</head>
<body>
<label>省份：</label>
<select id="province"></select>
<label>市区：</label>
<select id="city"></select>
<label>地区：</label>
<select id="area"></select>
<label>行政编码：</label>
<input type="text" id="areacode"/>
</body>
</html>

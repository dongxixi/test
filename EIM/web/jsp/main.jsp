<%--
  Created by IntelliJ IDEA.
  User: yang1
  Date: 2019/2/27
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <script>
        function showlist() {
            $.post("/AddressServlet",
                {
                    pageno: $("#pageno").text(),
                    pagesize:$("#pagesize").select().val()
                },
                function (json) {
                    $("#tbody").empty();
                    $("#pagetotal").text(json.pagetotal);
                    var list = json.list;
                    $.each(list, function (i, e) {
                        $("#tbody").append($("<tr>" +
                            "<td>" + e.id + "</td>" +
                            "<td>" + e.name + "</td>" +
                            "<td>" + e.sex + "</td>" +
                            "<td>" + e.mobile + "</td>" +
                            "<td>" + e.email + "</td>" +
                            "<td>" + e.qq + "</td>" +
                            "<td>" + e.company + "</td>" +
                            "<td>" + e.address + "</td>" +
                            "<td>" + e.postcode + "</td>" +
                            "<td>" + "<input type='button' class='btn btn-link btn-sm' data-toggle='modal'" +
                            " data-target='#myModal2' onclick='updata(this)' value='修改'/>" +
                            "<input type='button' class='btn btn-link btn-sm' onclick='del(this)' value='删除'/>" + "</td></tr>"
                        ));
                    });
                    $("#gotopage").val($("#pageno").text());
                }, "json"
            );
        }

        function updata(obj) {
            var id = $(obj).parent().siblings().eq(0).text();
            var name = $(obj).parent().siblings().eq(1).text();
            var sex = $(obj).parent().siblings().eq(2).text();
            var mobile = $(obj).parent().siblings().eq(3).text();
            var email = $(obj).parent().siblings().eq(4).text();
            var qq = $(obj).parent().siblings().eq(5).text();
            var company = $(obj).parent().siblings().eq(6).text();
            var address = $(obj).parent().siblings().eq(7).text();
            var postcode = $(obj).parent().siblings().eq(8).text();
            $("#id").val(id)
            $("#name").val(name)
            $("#sex").val(sex)
            $("#mobile").val(mobile)
            $("#email").val(email)
            $("#qq").val(qq)
            $("#company").val(company)
            $("#address").val(address)
            $("#postcode").val(postcode)
        }

        function del(obj) {
            var id = $(obj).parent().siblings().eq(0).text();
            $.post("/DelAddressServlet",
                {
                    id: id
                },
                function (json) {
                    if (json.success) {
                        $("#prompt").text("删除联系人成功！");
                        $('#myModal3').modal(options);
                    }
                },
                "json"
            );
        }

        $(function () {
            showlist();
            $("#firstpage").click(function () {
                $("#pageno").text(1);
                showlist();
            });
            $("#prevpage").click(function () {
                if (parseInt($("#pageno").text()) > 1) {
                    $("#pageno").text(parseInt($("#pageno").text()) - 1);
                }
                showlist();
            });
            $("#nextpage").click(function () {
                var pageno = parseInt($("#pageno").text());
                var pagetotal = parseInt($("#pagetotal").text());
                if (pageno < pagetotal) {
                    $("#pageno").text(pageno + 1);
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

            $("#add").click(function () {
                $.post("/AddAddressServlet",
                    {
                        name: $("#addname").val(),
                        sex: $("#addsex").val(),
                        mobile: $("#addmobile").val(),
                        email: $("#addemail").val(),
                        qq: $("#addqq").val(),
                        company: $("#addcompany").val(),
                        address: $("#addaddress").val(),
                        postcode: $("#addpostcode").val()
                    },
                    function (json) {
                        if (json.success) {
                            $("#prompt").text("添加联系人成功！");
                            $('#myModal3').modal(options);
                        }
                    }, "json"
                );
            });
            $("#updata").click(function () {
                $.post("/UpdataAddressServlet",
                    {
                        id: $("#id").val(),
                        name: $("#name").val(),
                        sex: $("#sex").val(),
                        mobile: $("#mobile").val(),
                        email: $("#email").val(),
                        qq: $("#qq").val(),
                        company: $("#company").val(),
                        address: $("#address").val(),
                        postcode: $("#postcode").val()
                    },
                    function (json) {
                        if (json.success) {
                            $("#prompt").text("修改联系人成功！");
                            $('#myModal3').modal(options);
                        }
                    }, "json"
                );
            })
            $("#pagesize").change(function () {
                showlist();
            });
            $("#goto").click(function () {
                $("#pageno").text($("#gotopage").val());
                showlist();
            });
        });
    </script>
</head>
<body>
<div onclick="header" style="text-align: center">
    <img src="../img/banner.jpg">
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="page-header" style="margin: 10px;text-align: left">
                <h3>通讯录管理</h3>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>手机</th>
                    <th>邮箱</th>
                    <th>QQ</th>
                    <th>工作单位</th>
                    <th>地址</th>
                    <th>邮编</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            第<span id="pageno">1</span>页，共<span id="pagetotal">5</span>页
        </div>
        <div class="col-sm-4">
            每页记录数
            <select id="pagesize">
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="20">20</option>
            </select><br/>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8">
            <div class="btn-group" role="group" aria-label="Basic example">
                <button type="button" class="btn btn-primary" id="firstpage">首页</button>
                <button type="button" class="btn btn-primary" id="prevpage">上一页</button>
                <button type="button" class="btn btn-primary" id="nextpage">下一页</button>
                <button type="button" class="btn btn-primary" id="lastpage">末页</button>
            </div>
            跳转到：<input type="text" id="gotopage"/>页<button type="button" class="btn btn-primary" id="goto">跳转</button>
        </div>

        <div class="col-sm-2 offset-sm-2">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                添加联系人
            </button>
        </div>
    </div>
</div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">添加联系人</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-2">姓名</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="addname" name="addname"></div>
                    <div class="col-sm-2">性别</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="addsex" name="addsex"></div>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-2">手机</div>
                    <div class="col-sm-4"><input type="number" class="form-control"
                                                 id="addmobile" name="addmobile"></div>
                    <div class="col-sm-2">邮箱</div>
                    <div class="col-sm-4"><input type="email" class="form-control"
                                                 id="addemail" name="addemail"></div>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-2">QQ</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="addqq" name="addqq"></div>
                    <div class="col-sm-2">工作单位</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="addcompany" name="addcompany"></div>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-2">地址</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="addaddress" name="addaddress"></div>
                    <div class="col-sm-2">邮编</div>
                    <div class="col-sm-4"><input type="number" class="form-control"
                                                 id="addpostcode" name="addpostcode"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="add">添加</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabe2">修改联系人</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <input type="hidden" id="id"/>
                <div class="row">
                    <div class="col-sm-2">姓名</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="name" name="name"></div>
                    <div class="col-sm-2">性别</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="sex" name="sex"></div>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-2">手机</div>
                    <div class="col-sm-4"><input type="number" class="form-control"
                                                 id="mobile" name="mobile"></div>
                    <div class="col-sm-2">邮箱</div>
                    <div class="col-sm-4"><input type="email" class="form-control"
                                                 id="email" name="email"></div>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-2">QQ</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="qq" name="qq"></div>
                    <div class="col-sm-2">工作单位</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="company" name="company"></div>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-2">地址</div>
                    <div class="col-sm-4"><input type="text" class="form-control"
                                                 id="address" name="address"></div>
                    <div class="col-sm-2">邮编</div>
                    <div class="col-sm-4"><input type="number" class="form-control"
                                                 id="postcode" name="postcode"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updata">修改</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <span id="prompt">aaaa</span>
        </div>
    </div>
</div>

</body>
</html>

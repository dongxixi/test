$(function () {
    $("#wormpage").click(function () {
        $("#pagetitle").text("虫害一览");
        $("#querydiv").html("<div class=\"col\">\n" +
            "                    <input type=\"text\" class=\"form-control\" placeholder=\"鼠害名称\">\n" +
            "                </div>\n" +
            "                <button type=\"button\" class=\"btn btn-primary\">查询</button>")
        $("#datahead").html("<tr>\n" +
            "                    <th>名称</th>\n" +
            "                    <th>食物</th>\n" +
            "                    <th>主要危害</th>\n" +
            "                    <th>操作</th>\n" +
            "                </tr>");
        $("#databody").html("<tr>\n" +
            "                    <td>中华鼢鼠</td>\n" +
            "                    <td>植物的根、茎等</td>\n" +
            "                    <td>啃食树木根系，水土流失</td>\n" +
            "                    <td>\n" +
            "                        <button type=\"button\" class=\"btn btn-link btn-sm\" data-toggle=\"modal\"\n" +
            "                                data-target=\"#myModa2\">\n" +
            "                            查看详情\n" +
            "                        </button>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td>中华鼢鼠</td>\n" +
            "                    <td>植物的根、茎等</td>\n" +
            "                    <td>啃食树木根系，水土流失</td>\n" +
            "                    <td>\n" +
            "                        <button type=\"button\" class=\"btn btn-link btn-sm\" data-toggle=\"modal\"\n" +
            "                                data-target=\"#myModa2\">\n" +
            "                            查看详情\n" +
            "                        </button>\n" +
            "                    </td>\n" +
            "                </tr>")
        $("#otherbutton").html("<button type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
            "                    添加新鼠害\n" +
            "                </button>")
    });
});
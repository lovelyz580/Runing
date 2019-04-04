<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'test.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script>
        function readTest() {
            var data = {};

            data.pagenumber = -1; // 当前页数(如果不进行分页，该条数据默认为-1)
            // data.pagesize = 2; // 每页的数据量
            data.version = '1.1'; // 版本号
            $.ajax({
                url : "runingapply/selectByRuningApply",
                type : "POST",
                data : JSON.stringify(data),
                contentType : "application/json;charset=UTF-8",
                success : function(result) {
                    var _str = JSON.stringify(result);
                    alert(_str);
                },
                error : function() {
                    alert("error");
                }
            });

        }
    </script>
</head>

<body>
This is my JSP page. <br>
<input type="button" id="s3" value="readTest" onclick="readTest();"/>
</body>
</html>

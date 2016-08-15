<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 12/1/16
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <jsp:include page="common/head.jsp" />

    <jsp:include page="common/css.jsp" />
</head>

<body class="fixed-sidebar full-height-layout gray-bg">
<div id="wrapper">
    <!--左侧导航开始-->
    <jsp:include page="common/sidebar.jsp" />
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <!--顶部导航-->
            <jsp:include page="common/navbar.jsp" />
        </div>
        <div class="row content-tabs">
            <!--标签栏-->
            <jsp:include page="common/navi.jsp" />
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_v1.html"
                    frameborder="0" data-id="index_v1.html" seamless></iframe>
        </div>
        <!--底部-->
        <jsp:include page="common/footer.jsp" />
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <%--<jsp:include page="common/rightSide.jsp" />--%>
    <!--右侧边栏结束-->
    <!--mini聊天窗口开始-->

    <!--mini聊天窗口结束-->
</div>

<!--引入JS-->
<jsp:include page="common/js.jsp" />
</body>

</html>

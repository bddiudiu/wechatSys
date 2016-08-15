<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <jsp:include page="../../common/head.jsp"/>
    <jsp:include page="../../common/css.jsp"/>
</head>

<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInUp">

    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>用户列表</h5>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">

                <div class="col-sm-12">

                    <div class="bootstrap-table">
                        <div class="fixed-table-body">
                            <div class="fixed-table-loading" style="top: 37px; display: none;">
                                正在努力地加载数据中，请稍候……
                            </div>
                            <button id="newServiceConfigure" class="btn btn-primary"
                                    style="padding-top:4px;height: 30px; width: 130px;"
                                    onclick="addUsers()"><i class="fa fa-wrench"></i>&nbsp;新增用户
                            </button>
                            <table id="userListTable" data-mobile-responsive="true"
                                   class="table table-hover">
                            </table>
                        </div>
                        <div class="fixed-table-footer" style="display: none;">
                            <table>
                                <tbody>
                                <tr></tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="fixed-table-pagination" style="display: none;"></div>
                    </div>
                    <div class="clearfix"></div>

                </div>

            </div>
        </div>
    </div>

</div>

<!--引入JS-->
<jsp:include page="../../common/js.jsp"/>

<!--引入页面JS-->
<script src="<%=request.getContextPath()%>/resources/script/backSys/users/userList.js"></script>

</body>

</html>

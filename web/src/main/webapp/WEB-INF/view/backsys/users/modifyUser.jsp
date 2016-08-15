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
            <h5>用户信息</h5>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">

                <div class="col-sm-12">
                    <form method="get" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" id="userName" class="form-control" disabled="" placeholder="${user.userName}" >
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户昵称</label>
                            <div class="col-sm-10">
                                <input type="text" id="nickName" class="form-control" value="${user.nikeName}">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户密码</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" id="password" value="******">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">电子邮箱</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email" value="${user.email}">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">联系电话</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="mobile" value="">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户性别</label>

                            <div class="col-sm-10">
                                <select class="form-control m-b" name="sex">
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户等级</label>

                            <div class="col-sm-10">
                                    <label class="checkbox-inline i-checks">
                                        <input type="checkbox" value="option1">a</label>
                                    <label class="checkbox-inline i-checks">
                                        <input type="checkbox" value="option2">b</label>
                                    <label class="checkbox-inline i-checks">
                                        <input type="checkbox" value="option3">c</label>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存内容</button>
                                <button class="btn btn-white" type="submit">取消</button>
                            </div>
                        </div>
                    </form>

                </div>

            </div>
        </div>
    </div>

</div>

<!--引入JS-->
<jsp:include page="../../common/js.jsp"/>

<!--引入页面JS-->
<script src="<%=request.getContextPath()%>/resources/script/backsys/user/modifyUser.js"></script>

<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
</body>

</html>

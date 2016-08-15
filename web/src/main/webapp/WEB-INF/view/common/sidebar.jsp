<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!--左侧导航开始-->
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <span><img alt="image" class="img-circle" src="<%=request.getContextPath()%>/resources/img/profile_small.jpg" /></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                        </li>
                        <li><a class="J_menuItem" href="profile.html">个人资料</a>
                        </li>
                        <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                        </li>
                        <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html">安全退出</a>
                        </li>
                    </ul>
                </div>
                <div class="logo-element">H+
                </div>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-home"></i>
                    <span class="nav-label">微信管理</span>
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <li>
                        <a class="J_menuItem" href="${basePath}/wechat/setupWechat" data-index="0">公众号设置</a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="${basePath}/wechat/setupWechat">自定义菜单</a>
                    </li>
                    <li>
                        <a href="#">消息管理 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a class="J_menuItem" href="form_webuploader.html">接收消息</a>
                            </li>
                            <li><a class="J_menuItem" href="form_file_upload.html">自定义回复</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="J_menuItem" href="index_v4.html">用户管理</a>
                    </li>
                </ul>

            </li>

            <li>
                <a href="#">
                    <i class="fa fa-cutlery"></i>
                    <span class="nav-label">系统管理 </span>
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <li><a class="J_menuItem" href="${basePath}/user/queryUsersPage">用户管理</a></li>
                    <li><a class="J_menuItem" href="${basePath}/user/queryUsersPage">菜单管理</a></li>
                    <li><a class="J_menuItem" href="${basePath}/user/queryUsersPage">角色管理</a></li>
                    <li><a class="J_menuItem" href="${basePath}/user/queryUsersPage">权限管理</a></li>
                </ul>
            </li>

        </ul>
    </div>
</nav>
<!--左侧导航结束-->
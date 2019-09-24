<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加/修改课程</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<style type="text/css">
    th {
        text-align: center;
    }
</style>
<body>

<nav class="navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <a class="navbar-brand" href="${pageContext.request.contextPath}/video/list">视频管理系统</a>
        </div>

        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/video/list">视频管理</a></li>
                <li><a href="${pageContext.request.contextPath}/speaker/showSpeakerList">主讲人管理</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/course/showCourseList">课程管理</a></li>
            </ul>
            <p class="navbar-text navbar-right">
                <span>${admin.username}</span> <i class="glyphicon glyphicon-log-in"
                                                  aria-hidden="true"></i>&nbsp;&nbsp;<a
                    href="${pageContext.request.contextPath}/admin/exit"
                    class="navbar-link">退出</a>
            </p>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
    <div class="container">
        <h2>添加或修改课程</h2>
        <%--         <c:if test="empty ${video.id}">--%>
        <%--        <c:if test="${not empty video}">--%>
        <%--        <c:if test="${empty speaker.id}">--%>
        <%--            <h2>添加主讲人</h2>--%>
        <%--        </c:if>--%>

        <%--        <c:if test="${not empty speaker.id}">--%>
        <%--            <h2>修改主讲人信息</h2>--%>
        <%--        </c:if>--%>
        <%--        &lt;%&ndash;        </c:if>&ndash;%&gt;--%>
    </div>
</div>
<c:if test="${CourseMessage!=null}">
    <h1>${CourseMessage}</h1>
    <%
        session.removeAttribute("CourseMessage");
    %>
</c:if>

<div class="container" style="margin-top: 20px;">

    <form class="form-horizontal" action="${pageContext.request.contextPath}/course/saveOrUpdateCourse" method="post">


        <c:if test="${not empty course.id}">
            <input type="hidden" name="idCourse" value="${course.id}">
        </c:if>

        <div class="form-group">
            <label  class="col-sm-2 control-label">课程标题</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ctitle" value="${course.course_title}" placeholder="课程标题">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">课程描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="cdesc" value="${course.course_desc}" placeholder="课程描述">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">课程ID</label>
            <div class="col-sm-10">
                <input type="text" name="cid" class="form-control" value="${course.subject_id}" placeholder="课程ID">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>


</div>


</body>
</html>
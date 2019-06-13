<!doctype html>
<html>
<head>
    <title>个人信息_资料分享聚集地</title>
<#include "/part/head.ftl">
    <link href="${sys_ContextPath}/static/css/common.css" rel="stylesheet">
</head>
<body>
<#include "/part/signTop.ftl">
<body>
<div class="card">
    <div class="card-up"></div>
    <div class="card-bottom">
        <div class="photo">
            <img src="/img/HeadP/${user.u_id}.jpg" style="width: 100%;height: 100%">
        </div>
        <div class="content">
            <div class="content-head">
                <h2>${requestScope.user.u_name}</h2>
            </div>
            <span class="content-tips">${user.u_c}</span>
            <div class="content-footer">
                <div class="buttongroup">
                        <button class="btn btn-primary">+关注</button>
                        <button class="btn">私信</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="profile-main">
    <div class="profile-mainColumn">
        <div class="main-header nav nav-tabs nav-pills people-content">
            <li><a href="" class="avtive">动态</a></li>
            <li><a href="">回复</a></li>
            <li><a href="">收藏</a></li>
        </div>
        <div class="panel">
            <div class="panel-heading">
                <h4>回答</h4>
            </div>
            <div class="panel-body">
                    <div class="list-item">
                        <h3><a href="/article.html/${ar.a_id}">${ar.title}</a></h3>
                        <div class="item-status">
                            <span>${ar.release_time}</span>
                            <span>${ar.conllection}收藏</span>
                            <span>${ar.reply_number}回答</span>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <div class="profile-sideColumn">
        <div class="panel people-achieve">
            <div class="panel-heading">
                <h4>个人成就</h4>
            </div>
            <div class="panel-body">
                <span class="item-status glyphicon glyphicon-thumbs-up">获得28次赞</span>
                <br>
                <span class="item-status glyphicon glyphicon-tag">发表篇文章</span>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</html>
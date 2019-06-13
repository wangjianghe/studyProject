<!doctype html>
<html>
<head>
    <title>登录_资料分享聚集地</title>
<#include "/part/head.ftl">
    <link href="${sys_ContextPath}/static/css/login.css" rel="stylesheet">
</head>
<body>
<#include "/part/noSignTop.ftl">
<div class="loginbg">
    <div class="dowebok">
        <form id="loginForm" method="post" action="${sys_ContextPath}/userLogin">
            <div class="bglogo"></div>
            <div class="form-item">
                <input id="email" type="text" name="email" autocomplete="off" placeholder="邮箱">
            </div>
            <div class="form-item">
                <input id="password" type="password" name="password" autocomplete="off" placeholder="登录密码">
            <#if loginError??>
                <p class="tip">邮箱或密码不正确</p>
            </#if>
            </div>
            <div class="form-item"><button id="submit" type="submit">登 录</button></div>
        </form>
        <div class="reg-bar">
            <a class="reg" target="_self" href="${sys_ContextPath}/signUp/">立即注册</a>
            <a class="forget" href="${sys_ContextPath}/forgetPasswordPage" target="_self">忘记密码</a>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
</body>
</html>

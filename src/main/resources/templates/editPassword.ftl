<!doctype html>
<html>
<head>
    <title>登录_资料分享聚集地</title>
<#include "/part/head.ftl">
    <link href="${sys_ContextPath}/static/css/login.css" rel="stylesheet">
<@validationEngine />
</head>
<body>
<#include "/part/noSignTop.ftl">
<div class="loginbg">
    <div class="dowebok">
        <form id="signUpForm" action="${sys_ContextPath}/updatePassword" method="post">
            <div class="bglogo"></div>
            <input type="hidden" name="email" value="${email}">
            <div class="form-item">
                <input id="password" name="password" type="password" autocomplete="off" placeholder="新密码" class="validate[required,minSize[6],maxSize[12],funcCall[CheckPassWord]]">
            </div>
            <div class="form-item">
                <input id="suRepassword" name="suRepassword" type="password" autocomplete="off" placeholder="再次输入密码" class="validate[required,equals[password]]">
            </div>
            <div class="form-item"><button id="submit" type="submit">修改</button></div>
        </form>
    </div>
</div>
<script>
    $(function (){
        $('#signUpForm').validationEngine();
    });
    function CheckPassWord(field,rules,i,options) {//密码必须包含数字和字母
        var str = field.val();
        var reg = new RegExp(/^(?![^a-zA-Z]+$)(?!\D+$)/);
        if (reg.test(str))
            return true;
        else{
            return "* 密码必须包含数字和字母";
        }
    }
</script>
</body>
</html>

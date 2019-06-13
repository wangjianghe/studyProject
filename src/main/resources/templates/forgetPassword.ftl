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
        <form id="signUpForm" action="${sys_ContextPath}/sendEditPassword" method="post">
            <div class="bglogo"></div>
            <div class="form-item">
                <input id="email" name="email" type="text" autocomplete="off" placeholder="登录邮箱" class="validate[required,custom[email],ajax[validateEmail]]">
            </div>
            <div class="form-item"><button id="submit" type="submit">修改</button></div>
        </form>
    </div>
</div>
<script>
    $(function (){
        $.validationEngineLanguage.allRules.validateEmail={
            "url":"/validateEmail",
            "alertTextLoad":"* 正在校验",
        };
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

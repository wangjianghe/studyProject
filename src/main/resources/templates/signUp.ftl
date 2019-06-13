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
            <form id="signUpForm" action="${sys_ContextPath}/signUp/addUser" method="post">
            <div class="bglogo"></div>
            <div class="form-item">
                <input id="username" name="username" type="text" autocomplete="off" placeholder="用户名" class="validate[required,minSize[2],maxSize[12],ajax[validateUsername]]">
            </div>
            <div class="form-item">
                <input id="email" name="email" type="text" autocomplete="off" placeholder="邮箱" class="validate[required,custom[email],ajax[validateEmail]]">
            </div>
            <div class="form-item">
                <input id="password" name="password" type="password" autocomplete="off" placeholder="登录密码" class="validate[required,minSize[6],maxSize[12],funcCall[CheckPassWord]]">
            </div>
            <div class="form-item"><button id="submit">注册</button></div>
            <div class="reg-bar">
                <a class="reg" target="_self" href="${sys_ContextPath}/signIn" target="_blank">登录</a>
                <a class="forget"  href="${sys_ContextPath}/forgetPasswordPage" target="_self">忘记密码</a>
            </div>
            </form>
        </div>
    </div>
<script>
    $(function (){
        $.validationEngineLanguage.allRules.validateUsername={
                "url":"/signUp/validateUsername",
                "alertTextLoad":"* 正在校验",
        };
        $.validationEngineLanguage.allRules.validateEmail={
            "url":"/signUp/validateEmail",
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

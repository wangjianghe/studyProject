<!doctype html>
<html>
<head>
    <title>首页_资料分享聚集地</title>
<#include "/part/head.ftl" >
    <link href="${sys_ContextPath}/static/css/index.css" rel="stylesheet">
</head>
<body>
<#include "/part/signTop.ftl">
<article>
    <main>
        <table class="table table-bordered" width="550">
            <thead>
            <tr>
                <th>用户名</th>
                <th>email</th>
                <th>状态</th>
                <th>操作</th>
                <! -- 这里是不同状态的 可以冻结 重发邮件 解冻功能 -->
            </tr>
            </thead>
            <tbody id="fileUp">
                <#list users as user>
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <#if user.status==0>
                    <td>未激活</td>
                    <td> <form id="deleteA" method="post" action="${sys_ContextPath}/updateUser">
                        <input type="hidden" value="${user.id}" name="userId" >
                        <input type="hidden" name="updateStatus">
                        <input type="hidden" value="${user.email}" name="email">
                        <input type="hidden" value="${user.userName}" name="username">
                        <input type="hidden" value="${user.id}" name="uuid">
                        <button class="btn btn-danger" type="button">发送邮件</button>
                        </form>
                    </td>
                <#elseif user.status==1>
                    <td>已激活</td>
                    <td> <form id="deleteA" method="post" action="${sys_ContextPath}/updateUser">
                        <input type="hidden" value="${user.id}" name="userId" >
                        <input type="hidden" name="updateStatus" value="-1">
                        <button class="btn btn-danger" type="button">冻结</button>
                    </form>
                    </td>
                <#elseif user.status==-1>
                    <td>已冻结</td>
                        <td> <form id="deleteA" method="post" action="${sys_ContextPath}/updateUser">
                            <input type="hidden" value="${user.id}" name="userId" >
                            <input type="hidden" name="updateStatus" value="1">
                            <button class="btn btn-danger" type="button">解除激活</button>
                        </form>
                        </td>
                <#else>
                    <td>error(请检查数据库)</td>
                </#if>
                </tr>
                </#list>
            </tbody>
        </table>
    </main>
<#include "/part/aside.ftl" >
</article>
<a href="#" class="cd-top">Top</a>
<script>
</script>
<script type="text/javascript" src="${sys_ContextPath}/static/js/bootstrap.js"></script>
</body>
</html>

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
                <th>文章标题</th>
                <th>作者</th>
                <th>时间</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody id="fileUp">
                <#list articles as ar>
                <tr>
                    <td>${ar.articleTitle}</td>
                    <td>${ar.userName}</td>
                    <td>${ar.articleTime?string("yyyy-MM-dd")}</td>
                    <td>
                        <form id="${ar.articleId}" method="post" action="${sys_ContextPath}/deleteArticle">
                            <input type="hidden" value="${ar.articleId}" name="articleId" >
                            <input type="hidden" value="${ar.articleType}" name="typeId">
                            <button class="btn btn-danger" onclick="subForm('${ar.articleId}')" type="button">删除</button>
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </main>
<#include "/part/aside.ftl" >
</article>
<a href="#" class="cd-top">Top</a>
<script type="text/javascript" src="${sys_ContextPath}/static/js/bootstrap.js"></script>
<script>
    function subForm(id) {
        if(window.confirm("确定删除么")){
            $("#"+id).submit();
        }
        return false;
    }
</script>
</body>
</html>

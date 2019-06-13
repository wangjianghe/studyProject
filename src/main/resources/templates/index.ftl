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
        <div class="news_box">
            <ul>
                <#list notices as notice>
                    <li>
                        <#if notice.articleImg??>
                            <i><a href="${sys_ContextPath}/showArticle?articleId=${notice.articleId}"><img src="${sys_ContextPath}/showImg?pathName=${notice.articleImg}"></a></i>
                        </#if>
                        <h3><a href="${sys_ContextPath}/showArticle?articleId=${notice.articleId}">${notice.articleShortContext}...</a></h3>
                    </li>
                </#list>
            </ul>
        </div>

        <div class="blogtab">
                <#if (pageInfo.list?size=0)>
                <#else>
                <#list pageInfo.list as item>
                        <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
                            <h3 class="blogtitle"><a style="text-decoration:none" href="${sys_ContextPath}/showArticle?articleId=${item.articleId}" target="_blank">${item.articleTitle}</a></h3>
                            <#if item.articleImg??>
                                <span class="blogpic">
                                <a style="text-decoration:none" href="${sys_ContextPath}/showArticle?articleId=${item.articleId}" title="">
                                <img src="${sys_ContextPath}/showImg?pathName=${item.articleImg}" alt="${item.articleTitle}" style="height: 128px;">
                                </a></span>
                            </#if>
                            <p class="blogtext">${item.articleShortContext}...</p>
                            <div class="bloginfo">
                                <ul>
                                    <li class="author"><a >${item.userName}</a></li>
                                    <li class="lmname"><a >${item.articleTypeName}</a></li>
                                    <li class="timer">${item.articleTime?string("yyyy-MM-dd")}</li>
                                    <li class="view"><span>${item.articleReadNum}</span>已阅读</li>
                                </ul>
                            </div>
                        </div>
                </#list>
                </#if>
        </div>
    </main>
   <#include "/part/aside.ftl" >
</article>
<a href="#" class="cd-top">Top</a>
<script type="text/javascript" src="${sys_ContextPath}/static/js/bootstrap.js"></script>
</body>
</html>

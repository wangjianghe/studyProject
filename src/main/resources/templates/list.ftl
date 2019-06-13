<!doctype html>
<html>
<head>
    <title>资料分享_资料分享聚集地</title>
  <#include "/part/head.ftl">
  <link href="${sys_ContextPath}/static/css/index.css" rel="stylesheet">
</head>
<body>
<#include "/part/signTop.ftl">
<article>
  <main>
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
        <#if pageInfo.total!=0>
            <div class="pagelist">
                <a title="Total record">&nbsp;<b>${pageInfo.total}条</b> </a>&nbsp;&nbsp;&nbsp;
                <#list 1..pageInfo.pages as ix>
                    <#if ix==pageInfo.pageNum>
                        &nbsp;&nbsp;<b>${ix}</b>&nbsp;
                    <#else>
                        <a href="${sys_ContextPath}/list?pageNum=${ix}&articleType=${articleType!}">${ix}</a>&nbsp;
                    </#if>
                </#list>
                <#if pageInfo.pageNum!=pageInfo.pages>
                    <a href="${sys_ContextPath}/list?pageNum=${pageInfo.pageNum+1}&articleType=${articleType!}">下一页</a>&nbsp;
                </#if>
                <a href="${sys_ContextPath}/list?pageNum=${pageInfo.pages}&articleType=${articleType!}">尾页</a>
            </div>
            <#else>
            <div>
                <h2>没有找到你想要的数据</h2>
            </div>
        </#if>
  </main>
<#include "/part/aside.ftl" >
</article>
<a href="#" class="cd-top">Top</a>
<script type="text/javascript" src="${sys_ContextPath}/static/js/bootstrap.js"></script>
</body>
</html>

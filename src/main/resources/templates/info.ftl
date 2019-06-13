<!doctype html>
<html>
<head>
    <title>首页_资料分享聚集地</title>
<#include "/part/head.ftl">
    <link href="${sys_ContextPath}/static/css/index.css" rel="stylesheet">
    <link href="${sys_ContextPath}/static/css/info.css" rel="stylesheet">
</head>
<body>
<#include "/part/signTop.ftl">
<article>
  <main>
  <div class="infosbox">
    <div class="newsview">
      <h3 class="news_title">${article.articleTitle}</h3>
      <div class="bloginfo">
        <ul>
          <li class="author">作者：<a href="/">${article.userName}</a></li>
          <li class="lmname"><a >${article.articleTypeName}</a></li>
          <li class="timer">时间：${article.articleTime?string("yyyy-MM-dd")}</li>
          <li class="view">${article.articleReadNum}人已阅读</li>
        </ul>
      </div>
       <div>
           ${article.articleContext}
       </div>
        <div><p class="bg-primary">附件</p></div>
        <#if files??>
            <#list files as item>
            <div>
                附件${item_index+1}：<a style="color: #87CEFF" target="_blank" href="${sys_ContextPath}/downLoad?fileSrc=${item.url}">${item.name}</a>
            </div>
            </#list>
        </#if>
  </div>
  </main>
<#include "/part/aside.ftl" >
</article>
<a href="#" class="cd-top">Top</a>
</body>
<script type="text/javascript" src="${sys_ContextPath}/static/js/bootstrap.js"></script>
</html>

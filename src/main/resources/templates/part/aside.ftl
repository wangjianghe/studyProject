<aside class="r_box" >
    <div class="about_me">
        <h2 style="margin-top: 0px;">重要通知</h2>
        <ul>
            <p><b>注意</b>联系管理员请发送邮件到1026451892@qq.com</p>
        </ul>
    </div>
    <div class="fenlei">
        <h2 style="margin-top: 0px;">类型分类</h2>
        <ul>
            <#list types as type>
                <li><a href="${sys_ContextPath}/list?articleType=${type.typeId}">${type.typeName}(${(type.typeNum)!"0"})</a></li>
            </#list>
        </ul>
    </div>
    <div class="tuijian">
        <h2 id="tab" style="margin-top: 0px;"><a href="#" class="current" id="notice">通知公告</a><a href="#" id="order">点击排行</a></h2>
        <div id="content">
            <ul id="noticeUl" style="display:block;">
            <#list noticeSide as n>
                <#if n.articleShortContext?length gt 15>
                    <li><a href="${sys_ContextPath}/showArticle?articleId=${n.articleId}">${n.articleShortContext?substring(0,15)}..</a></li>
                <#else>
                    <li><a href="${sys_ContextPath}/showArticle?articleId=${n.articleId}">${n.articleShortContext}..</a></li>
                </#if>
            </#list>
            </ul>
            <ul id="orderUl">
                <#list articleSide as a>
                    <#if a.articleShortContext?length gt 15>
                        <li><a href="${sys_ContextPath}/showArticle?articleId=${a.articleId}">${a.articleShortContext?substring(0,15)}..</a></li>
                    <#else>
                        <li><a href="${sys_ContextPath}/showArticle?articleId=${a.articleId}">${a.articleShortContext}..</a></li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>
</aside>
<script type="text/javascript">
    $("#notice").mouseover(function(){
        $("#notice").addClass("current");
        $("#order").removeClass();
        $("#noticeUl").css("display","block");
        $("#orderUl").css("display","none");
    });
    $("#order").mouseover(function(){
        $("#order").addClass("current");
        $("#notice").removeClass();
        $("#orderUl").css("display","block");
        $("#noticeUl").css("display","none");
    });
</script>
<header class="header-navigation" id="header">
    <nav>
        <div class="logo"><a href="${sys_ContextPath}/index">资料分享网站</a></div>
        <h2 id="mnavh"><span class="navicon"></span></h2>
        <ul id="starlist">
            <li><a href="${sys_ContextPath}/index">首页</a></li>
            <li><a href="${sys_ContextPath}/list">更多分享</a></li>
        </ul>
        <div class="searchbox">
            <div id="search_bar" class="search_bar">
                <form  id="searchform" action="${sys_ContextPath}/list" method="post" name="searchform">
                    <input class="input" placeholder="想搜点什么呢.." type="text" name="keyboard" id="keyboard">

                    <input type="hidden" name="Submit" value="搜索" />
                    <p class="search_ico"> <span></span></p>
                </form>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse2">
            <ul class="login nav navbar-nav" style="margin-left: 100px;">
            <#if user??>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    ${user.userName}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${sys_ContextPath}/upLoad">上传资料</a></li>
                        <#if user.types==0>
                            <li><a href="${sys_ContextPath}/updateUserPage">管理用户</a></li>
                        </#if>
                        <li><a href="${sys_ContextPath}/updateArticlePage">管理文章</a></li>
                        <li><a href="${sys_ContextPath}/userOut">退出</a></li>
                    </ul>
                </li>
            <#else>
                <li><a href="${sys_ContextPath}/signIn">登录</a></li>
                <li><a href="${sys_ContextPath}/signUp/">注册</a></li>
            </#if>
            </ul>
        </div>
    </nav>
</header>


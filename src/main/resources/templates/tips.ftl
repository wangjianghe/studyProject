<!doctype html>
<html>
<head>
    <title>上传资料_资料分享聚集地</title>
<#include "/part/head.ftl">
    <link href="${sys_ContextPath}/static/css/index.css" rel="stylesheet">
</head>
<body>
<#include "/part/signTop.ftl">
<!-- 按钮触发模态框 -->
<button id="btns" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">模态框</button>
<div class="modal fade" style="padding-top: 200px";  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body"><h2>${tips}</h2></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" onclick="sureReturn()" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<script type="text/javascript" src="${sys_ContextPath}/static/js/bootstrap.js"></script>
<script>
    $(function () {
       $("#btns").trigger("click");
    });
    function sureReturn() {
        window.location.href="${sys_ContextPath}/${redirectUrl}"
    }
</script>
</html>
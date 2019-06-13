<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" contect="资料分享网 上传文件">
    <meta name="Description" contect="上传文件">
    <title>上传文件</title>
<#include "/part/sys.ftl">
    <link rel="stylesheet" type="text/css" href="${sys_ContextPath}/static/bootstrap/bootstrap.min.css">
<@validationEngine />
</head>
<body>
<div style="height:80px">
    <p class="bg-primary" style="text-align: center;font-size: 20px">资料上传</p>
</div>
<!-- body container -->
<div class="container">
    <center>
        <div style="max-width:1100px;">
            <!--demo-->
            <div style="text-align:left;">
                <div id="divDemo">
                    <p>欢迎 来到资料分享网</p>
                </div>
            </div><!--demo end-->
        </div>
    </center>
</div>
<form id="upFile" method="post" action="${sys_ContextPath}/saveFile" enctype="multipart/form-data">
    <div>
    <div>
        <p class="bg-primary">标题：</p>
        <input style="width: 300px;" type="text" id="title" name="title" class="validate[required,minSize[1],maxSize[15]]">
    </div>
        <p class="bg-primary">请选择文章类型：</p>
        <div class="form-group">
            <label for="name">选择列表</label>
            <select class="form-control" name="articleType">
                <#list types as type>
                    <option value="${type.typeId}">${type.typeName}</option>
                </#list>
            </select>
        </div>
    <div><p class="bg-primary">上传文章图片(不需要则可不传)</p></div>
    <input type="file" name="articleImage" id="articleImage" accept="image/*"  />
<div>
    <p class="bg-primary">上传附件：</p>
</div>
<div>
        <input type="hidden" name="context" id="context" />
        <input type="hidden" name="shortContext" id="shortContext" />
        <table class="table table-bordered" width="550">
            <thead>
            <tr>
                <th>点击上传</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody id="fileUp">
            </tbody>
        </table>
        <button type="button" class="btn btn-primary" onclick="addFileUpLoad()">增加上传</button>
    <div>
        <button type="button" class="btn btn-info" onclick="saveArticle()">上传资料</button>
        <a type="button" class="btn btn-info" style="margin-left: 100px;" href="${sys_ContextPath}/index" >返回</a>
    </div>
</div>
</form>
<div style="visibility:hidden">
    <table>
        <tr id="trRow">
            <td>
                上传文件： <input type="file" name="files" id="file1"  multiple="multiple"  />
            </td>
            <td><button type="button" class="btn btn-danger" onclick="deleteFileUpLoad(this)">删除</button></td>
        </tr>
    </table>
</div>
<script type="text/javascript" src='${sys_ContextPath}/static/js/jquery.min.js'></script>
<script type="text/javascript" src='${sys_ContextPath}/static/bootstrap/bootstrap.min.js'></script>
<script type="text/javascript" src='${sys_ContextPath}/static/js/wangEditor.min.js'></script>
<script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#divDemo');
        editor.customConfig.uploadImgShowBase64 = true;
        editor.create();
        function saveArticle() {
            if($("#title").val().length>25){
                alert("标题应该在25个字符内");
                return false;
            }
            if(window.confirm("确定提交资料么?")){
                var shortContext=editor.txt.text();
                if(shortContext.length>67){
                    shortContext=shortContext.substring(0,67);
                }
                $("#shortContext").attr("value",shortContext);
                $("#context").attr("value",editor.txt.html());
                $("#upFile").submit();
            }
            return false;
        }
</script>
<script>
    function addFileUpLoad() {
        var file=$("#trRow").clone();
        file.attr('id',"new_trRow");
        $("#fileUp").append(file);
    }
    function deleteFileUpLoad(obj) {
        $(obj).parent().parent().remove();
    }

</script>
</body>
</html>

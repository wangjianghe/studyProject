<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>
</head>
<body>
<h2>首页<h2>
    <button class="a"> click me</button>
<#assign x=request.contextPath />
    <div>${x}</div>
</body>
</html>
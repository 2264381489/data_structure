<%--
  Created by IntelliJ IDEA.
  User: 22643
  Date: 2020/6/3
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="anno/testRequestParam?name=haha">RequestParam</a>
<%--<form action="anno/testRequestBody" method="post">--%>


<%--用户姓名:<input type="text" name="username">--%>
<%--用户年龄:<input type="text" name="age">--%>
<%--&lt;%&ndash;用户生日:<input type="text" name="date">&ndash;%&gt;--%>


<%--<input type="submit" value="提交">--%>
<form action="anno/testModelAttribute" method="post">


    用户姓名:<input type="text" name="username">
    用户年龄:<input type="text" name="age">
    <%--用户生日:<input type="text" name="date">--%>


    <input type="submit" value="提交">
</body>
</html>

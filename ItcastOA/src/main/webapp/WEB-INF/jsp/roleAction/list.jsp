<%--
  Created by IntelliJ IDEA.
  User: lkk
  Date: 2014/11/7
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:iterator value="#roleList">
    <s:property value="name"></s:property>
    <s:property value="description"></s:property>
    <s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
    <s:a action="role_editUI?id=%{id}" >编辑</s:a>
    <br/>
</s:iterator>

<s:a action="role_addUI">添加岗位</s:a>
</body>
</html>

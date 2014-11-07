<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lkk
  Date: 2014/11/7
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:form action="role_edit">
    <s:hidden name="id"></s:hidden>
    <s:textfield name="name" label="名称"></s:textfield>
    <br>
    <s:textarea name="description" label="描述"></s:textarea>
    <br>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>

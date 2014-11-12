<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>导航菜单</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <link type="text/css" rel="stylesheet" href="style/blue/menu.css"/>
    <script>
        function menuClick(menu) {
            $(menu).next().toggle();
        }

    </script>
</head>
<body style="margin: 0">
<div id="Menu">
    <ul id="MenuUl">
        <li class="level1">
            <s:iterator value="#application.topPrivilegeList">
                <s:if test="#session.user.findPrivilegeByName(name)">
                    <div onClick="menuClick(this)" class="level1Style"><img src="style/images/MenuIcon/FUNC20001.gif"
                                                                            class="Icon"/>${name}
                    </div>

                    <ul class="MenuLevel2">
                        <s:iterator value="children">
                            <s:if test="#session.user.findPrivilegeByName(name)">

                                <li class="level2">
                                    <div class="level2Style"><img
                                            src="style/images/MenuIcon/menu_arrow_single.gif"/>
                                        <a target="right"
                                           href="${pageContext.request.contextPath}${url}.action"> ${name}</a>
                                    </div>
                                </li>
                            </s:if>
                        </s:iterator>
                    </ul>
                </s:if>
            </s:iterator>
        </li>
    </ul>
</div>
</body>
</html>

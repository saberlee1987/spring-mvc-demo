<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h3>Hello World @@@@</h3>
<%--@elvariable id="colors" type="java.util.List<java.lang.String>"--%>
<c:if test="${colors != null && fn:length(colors)>0}">
    <table border="2">
        <c:forEach items="${colors}" var="color">
            <tr>
                <td>${color}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${nameTest}">
        <p>Hello ${username}</p>
        <p><a href="<c:url value='/ShoppingList'><c:param name='action' value='logout' /></c:url>">Logout</a></p>
        </c:if>
    </body>
</html>

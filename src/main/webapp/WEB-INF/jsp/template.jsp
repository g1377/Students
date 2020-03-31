<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/styles.css">
    <script type="text/javascript" src="/resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<header id="head">Система управления студентами и их успеваемостью</header>
<c:if test="${current_page ne ('/WEB-INF/jsp/login.jsp')}">
    <a href="/logout">
        <button id="logout">Logout, ${username}</button>
    </a>
</c:if>

<jsp:include page="${current_page}"/>


</html>
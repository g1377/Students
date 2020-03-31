<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/styles.css">
    <title>Menu</title>
</head>
<header id="head" >Система управления студентами и их успеваемостью</header>
<a href="/logout">
    <button id="logout">Logout, ${username}</button>
</a>

<p></p>
<%@ include file="WEB-INF/jsp/home.jsp" %>


</html>
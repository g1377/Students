<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <link rel="stylesheet" href="/resources/css/styles.css">--%>
<%--    <title>DisciplineCreate</title>--%>
<%--</head>--%>


<body>
<title>Create discipline</title>
<p>
    <a id="home" href="/home">
        <button type="button">На главную</button>
    </a>
    <a href="/disciplines">
        <button type="button">Назад</button>
    </a>
</p>
<div class="ml">
    <h2>Для того чтобы создать новую дисциплину заполнити все поля и нажмите "Создать"</h2>
    <form action="/createDiscipline" method="post">
        <div>
            <p><input type="text" style="font-size: 1.2rem" required placeholder="Название дисциплины" name="newDisc">
            </p>
            <button type="submit" id="butdisc" name="submit">Создать</button>
        </div>
    </form>
</div>
</body>
</html>
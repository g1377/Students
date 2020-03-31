<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <link rel="stylesheet" href="/resources/css/styles.css">--%>
<%--    <title>DisciplineModify</title>--%>
<%--</head>--%>


<body>
<title>Modify discipline</title>
<p>
    <a id="home" href="/home" >
        <button type="button" >На главную</button></a>
      <a href="/disciplines">  <button type="button" >Назад</button>
    </a>
</p>

<h2 class="ml">Для модификации дисциплины заполните поле и нажмите "Применить"</h2>

<form action="/modifyDiscipline" method="post">
<div class="input">
    <p ><input type="text" style="font-size: 1.2rem; width: 224px" required placeholder="${discAtr.disciplina}" name="discModify"></p>
    <button type="submit"  id="butdisc" name="submit" >Применить</button>
</div>
</form>

</body>
<html>
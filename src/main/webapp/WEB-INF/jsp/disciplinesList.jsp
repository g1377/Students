<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">


<%--    <link rel="stylesheet" href="/resources/css/styles.css">--%>
    <title>Discipline </title>

    <p>
        <a id="home" href="/home">
            <button type="button">На главную</button>
        </a>
    </p>
<body>
<div class="ml">
    <h2>Список дисциплин </h2>
    <div style="display: ruby">
        <table id="tabledisc" border="1">
            <tr>
                <th style="background-color: lightgrey">Наименование дисциплины</th>
                <c:if test="${role eq 1}">
                    <th style="background-color: lightgrey"></th>
                </c:if>
            </tr>
            <c:forEach items="${disciplines}" var="d" varStatus="i">
                <tr>
                    <td class="tblclr">${d.disciplina}</td>

                    <c:if test="${role eq 1}">
                        <td class="tblclr"><input type="checkbox" value="${d.id}"></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>


    <c:if test="${role eq 1}">
    <table id="tbD">

        <tr>
            <td class="tdd"><a href="/createDiscipline" style="text-decoration:none">
                <button class="bDisc">Создать дисциплину</button>
            </a></td>
        </tr>

        <tr>
            <td class="tdd"><a onclick="modifyDiscpline()" class="ad">
                <button class="bDisc"> Модифицировать выбранную дисциплину</button>
            </a></td>
        </tr>

        <tr>
            <td class="tdd"><a onclick="deleteDisciplines()" class="ad">
                <button class="bDisc"> Удалить выбранные дисциплины</button>
            </a></td>
        </tr>
        </c:if>

    </table>
    <form id="formModifyDisc" method="get" action="/modifyDiscipline">
        <input type="hidden" name="idModifyDisc">
    </form>

    <form id="deletDisc" method="post" action="/disciplines">
        <input type="hidden" name="idsDelete">
    </form>

</div>

<html>
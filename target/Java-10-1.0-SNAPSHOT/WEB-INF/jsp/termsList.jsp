<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<body>

<title>Terms</title>

<p>
    <a id="home" href="/home">
        <button type="button">На главную</button>
    </a>
</p>

<div class="ml">
    <h2>Список дисциплин семестра</h2>

    <form action="/term" method="get">
        <p style="font-size: 1.2rem">Выберите семестр:

            <select style="font-size: 1.2rem" name="termSelect">
                <c:forEach items="${termList}" var="t">
                    <c:choose>
                        <c:when test="${t.id eq selectedTerm.id}">
                            <option selected value="${t.id}"> ${t.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${t.id}"> ${t.name}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                </optgroup>
            </select>

            <button id="butdisc" style="margin-left: 1%;">Применить</button>
    </form>
    </p>
    <p style="font-size: 1.2rem">Длительность семестра: ${selectedTerm.duration}</p>
    <div style="display: ruby">

        <table id="tabledisc" border="1">
            <tr>
                <th style="background-color: lightgrey">Наименование дисциплины</th>

            </tr>
            <c:forEach items="${selectedTerm.disciplinas}" var="d">
                <tr>
                    <td>${d.disciplina}</td>
                </tr>

            </c:forEach>
        </table>

    </div>


    <c:if test="${role eq 1}">
        <table id="tbD">

            <tr>
                <td class="tdd"><a href="/termCreate" style="text-decoration: none">
                    <button class="bDisc"> Создать семестр</button>
                </a></td>
            </tr>
            <tr>
                <td><a href="/modifyTerm" style="text-decoration: none">
                    <button class="bDisc"> Модифицировать выбранный семест</button>
                </a></td>
            </tr>


            <tr>
                <td><a href="/deleteTerm" style="text-decoration: none">
                    <button class="bDisc"> Удалить выбранный семестр</button>
                </a></td>
            </tr>
        </table>
    </c:if>
</div>
</body>

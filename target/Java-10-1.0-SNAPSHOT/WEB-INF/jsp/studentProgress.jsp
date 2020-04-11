<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<body>
<title>Progress student</title>

<p>
    <a class="home" style="margin-left: 1%" href="/home">
        <button type="button">На главную</button>
    </a>
    <a class="home" href="/students">
        <button type="button">Назад</button>
    </a>
</p>
<div class="ml">
    <h2>Отображена успеваемость для следующего студента:</h2>
    <div>
        <table width="80.5%" border="1">
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Группа</th>
                <th>Дата поступления</th>
            </tr>
            <tr style="text-align: center">
                <td>${studentForProgres.lastName}</td>
                <td>${studentForProgres.name}</td>
                <td>${studentForProgres.group}</td>
                <td>${studentForProgres.date}</td>
            </tr>
        </table>
    </div>

    <form method="post" action="/progresStudent">
        <div class="term1" style="margin-top: 1%">
            <select id="select" style="height: 30px" name="selectTerm">
                <c:forEach items="${allTerms}" var="t">
                    <c:choose>
                        <c:when test="${t.id eq selectTermId}">
                            <option selected value="${t.id}">${t.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${t.id}">${t.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <button class="btnsus">Выбрать</button>
        </div>
    </form>

    <div>
        <h4>Средняя оценка ученика : <b>${valueMark}</b> балла</h4>
        <table id="tb2" border="1">
            <tr>
                <th style="width: 70%">Дисциплина</th>
                <th>Оценка</th>
            </tr>
            <c:forEach items="${discMark}" var="t">
                <tr style="text-align: center">
                    <td>${t.key}</td>
                    <td>${t.value}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>


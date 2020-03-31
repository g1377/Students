<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<body>
<title>Students</title>
<p>
    <a style="margin-left: 1%; display: ruby" href="/home">
        <button type="button">На главную</button>
    </a>
</p>

<div>
    <table class="ml" style="width: 55%">
        <tr>
            <td class="tds"><a href="/progresStudent" class="aSt">
                <button class="studbut" <c:if test="${role eq 2}">style="width: 60% "</c:if>>Посмотреть успеваемость
                    выбранного студента
                </button>
            </a></td>
            <c:if test="${role eq 1 || role eq 3}">
                <%--            <c:if test="${role eq 3}">--%>
            <td class="tds"><a href="/createStudent" class="aSt">
                <button class="studbut">Создать студента</button>
            </a></td>
        </tr>
        <tr>

            <td class="tds"><a onclick="modifyStudent()" class="aSt">
                <button class="studbut">Модифицировать выбранного студента</button>
            </a></td>
            <td class="tds"><a onclick="deleteStudents()" class="aSt">
                <button class="studbut">Удалить выбранные студентов</button>
            </a></td>
        </tr>
            <%--        </c:if>--%>
        </c:if>
    </table>

    <form id="studentModify" method="get" action="/modifyStudent">
        <input type="hidden" name="idModifyStudent"></form>

    <form id="studentDelete" method="post" action="/students">
        <input type="hidden" name="idsDeleteStudent"></form>
</div>


<h2 class="ml">Список студентов</h2>
<div class="students">

    <table style="width: 100%" border="1">
        <thead>
        <tr>
            <th style="background-color:lightgrey"></th>
            <th scope="col" style="background-color:lightgrey">Фамилия</th>
            <th scope="col" style="background-color:lightgrey">Имя</th>
            <th scope="col" style="background-color:lightgrey">Группа</th>
            <th scope="col" style="background-color:lightgrey">Дата поступления</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${students}" var="s">
            <tr>
                <th scope="row">
                    <div class="tblclr">
                        <input type="checkbox" id="cbx1" value="${s.id}">
                        <label class="custom-control-label" for="cbx1"></label>
                    </div>
                </th>

                <td class="tblclr">${s.lastName}</td>
                <td class="tblclr">${s.name}</td>
                <td class="tblclr">${s.group}</td>
                <td class="tblclr">${s.date}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>


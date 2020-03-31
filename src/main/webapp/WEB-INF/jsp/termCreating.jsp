<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<body>
<title>Create term</title>
<p>
    <a class="home" href="/home">
        <button type="button">На главную</button>
    </a>
    <a class="home" href="/term">
        <button type="button">Назад</button>
    </a>
</p>
<div class="ml">
    <h2>Для создания семестра заполните все поля и нажмите кнопку "Создать"</h2>

    <div>
        <form method="post" action="/termCreate">
            <p><input type="text" style="font-size: 1.2rem" required placeholder="Название семестра" name="termName">
            </p>
            <p><input type="text" style="font-size: 1.2rem" placeholder="Длительность" required id="duration"
                      name="duration">
            </p>


            <table id="tb1" border="1">
                <tr>
                    <th>Дисциплины в семестре</th>
                    <th></th>
                </tr>
                <c:forEach items="${disciplines}" var="d">
                    <tr>
                        <td>${d.disciplina}</td>
                        <td><input type="checkbox" value="${d.id}"></td>
                    </tr>
                </c:forEach>
            </table>
            <p></p>

            <button id="butdisc" onclick="createTermDisc()" style="margin-left: 13%;">Создать</button>
        </form>
        <form id="createTermDiscBut" method="get" action="/testc">
            <input type="hidden" id="createTerm" name="createTerm">
        </form>
    </div>
</div>
</body>

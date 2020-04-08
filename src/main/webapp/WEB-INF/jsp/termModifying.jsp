<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<body>
<title>Modify term</title>
<p>
    <a class="home" href="/home">
        <button type="button">На главную</button>
    </a>
    <a class="home" href="/term">
        <button type="button">Назад</button>
    </a>
</p>
<form action="/modifyTerm" method="post">
    <div class="ml">
        <h2>Для модификации семестра заполните все поля и нажмите кнопку "Применить"</h2>
        <div>
            <p style="font-size: 1.2rem">${termName}</p>

            <p><input type="text" style="font-size: 1.2rem" placeholder="Длительность" required name="duration"></p>
            <p>Дисциплины в семестре:</p>

            <select multiple name="selectTermDisc" required style="height: 100px">
                <c:forEach items="${disciplines}" var="d">
                    <option value="${d.id}"> ${d.disciplina}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <p>
        <button id="butdisc" style="margin-left: 21%;">Применить</button>
    </p>
</form>
</body>

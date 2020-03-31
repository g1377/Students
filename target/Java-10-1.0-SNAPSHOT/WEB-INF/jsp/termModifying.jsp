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

<div class="ml">
    <h2>Для модификации семестра заполните все поля и нажмите кнопку "Применить"</h2>
    <div>
        <p><input type="text" style="font-size: 1.2rem" placeholder="Длительность"></p>
        <table id="tb1" border="1">
            <tr>
                <th>Дисциплины в семестре</th>
                <th></th>
            </tr>
            <c:forEach items="${disciplines}" var="d">
                <tr>
                    <td>${d.disciplina}</td>
                    <td><input type="checkbox"></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<p>
    <button id="butdisc" style="margin-left: 21%;">Применить</button>
</p>
</body>

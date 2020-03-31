<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<body>
<title>Modify student</title>
<p>
    <a class="home" href="/home">
        <button type="button">На главную</button>
    </a>
    <a class="home" href="/students">
        <button type="button">Назад</button>
    </a>
</p>

<h2 class="ml">Для модификации введите новые значения и нажмите кнопку "Применить"</h2>
<form method="post" action="/modifyStudent">
    <div class="ml" style="display: inline flow-root list-item">
        <p><input type="text" class="pol" required name="lastName" style="margin-top: 0%"
                  placeholder="${studentById.lastName}"></p>
        <p><input type="text" class="pol" required name="name" placeholder="${studentById.name}"></p>
        <p><input type="text" class="pol" required name="group" placeholder="${studentById.group}"></p>
        <p id="date" style="font-size: 1.2rem">Дата<input type="date" required class="data" name="date"></p>
        <p>
            <button id="studmodres">Применить</button>
        </p>
    </div>
</form>

</body>

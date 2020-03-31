<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<body>
<title>Create student</title>
<p>
    <a class="home" href="/home">
        <button type="button">На главную</button>
    </a>
    <a class="home" href="/students">
        <button type="button">Назад</button>
    </a>
</p>

<h2 class="ml">Для создания студента заполните все поля и нажмите кнопку "Создать"</h2>
<form action="/createStudent" method="post">
    <div class="ml" style="display: inline flow-root list-item">
        <p><input type="text" class="pol" required name="lastName" style="margin-top: 0%" placeholder="Фамилия"></p>
        <p><input type="text" class="pol" required name="name" placeholder="Имя"></p>
        <p><input type="text" class="pol" required name="group" placeholder="Группа"></p>
        <p id="date" style="font-size: 1.2rem">Дата<input type="date" required class="data" name="date"></p>
        <p>
            <button id="studmodres" style="margin-left: 52%">Создать</button>
        </p>
    </div>
</form>
</body>
</html>
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
    <div class="term1">
        <select id="select" style="height: 30px">
            <optgroup label="выбрать семестр">
                <option value="r1">семестр 1</option>
                <option value="r2">семестр 2</option>
                <option value="r3">семестр 3</option>
                <option value="r3">семестр 4</option>
            </optgroup>
        </select>
        <a href="#">
            <button type="button" class="btnsus">Выбрать</button>
        </a>

    </div>
    <div c>

        <table id="tb2" border="1">
            <tr>
                <th>Дисциплина</th>
                <th>Оценка</th>
            </tr>
            <tr>
                <td>Информатика</td>
                <td>*</td>
            </tr>
            <tr>
                <td>Системный анализ</td>
                <td>*</td>
            </tr>
            <tr>
                <td>Политология</td>
                <td>*</td>
            </tr>
            <tr>
                <td>Управление проектами</td>
                <td>*</td>
            </tr>
            <tr>
                <td>Основы дискретной математики</td>
                <td>*</td>
            </tr>
        </table>
    </div>
    <h4>Средняя оценка ученика : <b>4</b> балла</h4>
</div>
</body>


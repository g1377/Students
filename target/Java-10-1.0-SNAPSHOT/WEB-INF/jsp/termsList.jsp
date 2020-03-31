<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <p style="font-size: 1.2rem">Выберите семестр:
        <select style="font-size: 1.2rem">
            <option value="1">семестр 1</option>
            <option value="2">семестр 2</option>
            <option value="3">семестр 3</option>
            <option value="3">семестр 4</option>
            </optgroup>
        </select>
    </p>
    <p style="font-size: 1.2rem">Длительность семестра 24 недели</p>
    <div style="display: ruby">

        <table id="tabledisc" border="1">
            <tr>
                <th style="background-color: lightgrey">Наименование дисциплины</th>

            </tr>
            <tr>
                <td>Информатика</td>
            </tr>
            <tr>
                <td>Системный анализ</td>
            </tr>
            <tr>
                <td>Политология</td>
            </tr>
            <tr>
                <td>Управление проектами</td>
            </tr>
            <tr>
                <td>Основы дискретной математики</td>
            </tr>
        </table>

    </div>


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
            <td><a href="#" style="text-decoration: none">
                <button class="bDisc"> Удалить выбранный семестр</button>
            </a></td>
        </tr>
    </table>
</div>
</body>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>


<title>Login</title>
<p1 style="margin-left: 13%;"></p1>
<form action="/login" method="post">
    <div class="ml" style="margin-top: 4%">
        <h2>Введите свои данные</h2>
        <c:if test="${errorMessage == 1}">
            <div style=" font-size:1rem; color:red">Некорректные данные, попробуй снова!</div>
        </c:if>

        <p id="p1"><input type="text" style="font-size: 1.2em" name="log" placeholder="Login"></p>
        <p id="p1"><input type="password" style="font-size: 1.2em" name="pass" placeholder="Password"></p>
        <p>Роль
            <select id="select" name="role">
                <optgroup label="выберите :">
                    <option value="1">Администратор</option>
                    <option value="2">Студент</option>
                    <option value="3">Учитель</option>
                </optgroup>
            </select>
        </p>
        <button type="submit" id="res1" name="submit">Войти</button>
    </div>
</form>


</html>
function modifyDiscpline() {

    var item = $("input[type=checkbox]:checked");
    if (item.length == 0) {
        alert("Выберите дисциплину для модификации!");
        return;
    }

    if (item.length > 1) {
        alert("Нельзя модифицировать больше одной дисциплины!");
        return;
    }

    var id = $(item[0]).attr("value");
    $('#formModifyDisc input').val(id);
    $('#formModifyDisc').submit();
}

function deleteDisciplines() {

    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Пожалуйста, выберите хотя бы одну дисциплину");
        return;
    }

    var result;

    for (var i = 0; i < items.length; i++) {
        if (result == null) {
            result = $(items[i]).attr("value");
        } else {
            result = result + "," + $(items[i]).attr("value");
        }

    }

    $('#deletDisc input').val(result);
    $('#deletDisc').submit();
}

function modifyStudent() {
    var item = $("input[type=checkbox]:checked");
    if (item.length == 0) {
        alert("Выберите студента для модификации!");
        return;
    }

    if (item.length > 1) {
        alert("Выберите одного студента для модиикации!");
        return;
    }
    var id = $(item[0]).attr("value");
    $('#studentModify input').val(id);
    $('#studentModify').submit();
}


function deleteStudents() {

    var items = $("input[type=checkbox]:checked");

    if (items.length == 0) {
        alert("Выберите дисциплины для удаления!")
    }

    var result;

    for (var i = 0; i < items.length; i++) {
        if (result == null) {
            result = $(items[i]).attr("value");
        } else {
            result = result + "," + $(items[i]).attr("value");
        }
    }

    $('#studentDelete input').val(result);
    $('#studentDelete').submit();
}

function progresStudent() {
    var item = $("input[type=checkbox]:checked");
    if (item.length == 0) {
        alert("Выберите студента для просмотра прогресса!");
        return;
    }
    if (item.length > 1) {
        alert("Выберите одного студента для просмотра прогресса!");
        return;
    }
    var id = $(item[0]).attr("value");
    $('#studentProgres input').val(id);
    $('#studentProgres').submit();
}


<!DOCTYPE html>
<html>
<head>
    <title>Kind of income</title>
</head>
<body>
<div>
    <h1>Виды прихода</h1>
    <table border="1">
        <tr>
            <th>id</th>
            <th>вид прихода</th>
            <th>внутренний счёт</th>
            <th>активный</th>
            <th>редактировать</th>
            <th>удаление</th>
        </tr>
<#list kindOfIncomeList as kindOfIncome>

        <tr>
            <td>${kindOfIncome.id?left_pad(10)}</td>
            <td>${kindOfIncome.kind?right_pad(10)}</td>
            <td>
            <#if kindOfIncome.home==true>
                да
                <#else>
                    нет
            </#if>
            </td>
            <td>
            <#if kindOfIncome.active==true>
                да
            <#else>
                нет
            </#if>
            </td>
            <td>
                <a href="/money/kindofincome?id=${kindOfIncome.id}#bottom">edit</a>
            </td>
            <td>
                <a href="/money/kindofincome/delete/${kindOfIncome.id}">delete</a>
            </td>

        </tr>

</#list>
    </table>
</div>
<hr>
<h3>Форма для создания/изменения</h3>
<hr>
<div>
    <#if recordId==-1>
        <form action="/money/kindofincome/create" method="post">
            id: <input type="text" name="id"/><br><br>
            вид прихода: <input type="text" name="kind"/><br><br>
            внутренний счёт: <input type="checkbox" name="home"/><br><br>
            активный: <input type="checkbox" name="active"/><br><br>
            <input type="submit" value="добавить"/>
        </form>
    <#else>
        <form action="/money/kindofincome/create" method="post">
            id: <input type="text" name="id" value="${recordId}"/><br><br>
            вид прихода: <input type="text" name="kind" value="${element.kind}"/><br><br>
            внутренний счёт: <input type="checkbox" name="home"
                    <#if element.home==true>
                        checked="checked"
                    </#if>
            /><br><br>
            активный: <input type="checkbox" name="active"
                    <#if element.active==true>
                        checked="checked"
                    </#if>
            /><br><br>
            <input type="submit" value="сохранить изменения"/>
        </form>
    </#if>
</div>
<p><a name="bottom"></a></p>
</body>
</html>
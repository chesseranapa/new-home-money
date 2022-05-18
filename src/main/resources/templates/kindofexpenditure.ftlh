<!DOCTYPE html>
<html>
<head>
    <title>Kind of expenditure</title>
</head>
<body>
<div>
    <h1>Виды расхода</h1>
    <table border="1">
        <tr>
            <th>id</th>
            <th>вид расхода</th>
            <th>внутренний счёт</th>
            <th>редактировать</th>
            <th>удаление</th>
        </tr>
        <#list kindOfExpenditureList as kindofexpenditure>

            <tr>
                <td>${kindofexpenditure.id?left_pad(10)}</td>
                <td>${kindofexpenditure.kind?right_pad(10)}</td>
                <td>
                    <#if kindofexpenditure.home==true>
                        да
                    <#else>
                        нет
                    </#if>
                </td>
                <td>
                    <a href="/money/kindofexpenditure?id=${kindofexpenditure.id}#bottom">edit</a>
                </td>
                <td>
                    <a href="/money/kindofexpenditure/delete/${kindofexpenditure.id}">delete</a>
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
        <form action="/money/kindofexpenditure/create" method="post">
            id: <input type="text" name="id"/><br><br>
            вид расхода: <input type="text" name="kind"/><br><br>
            внутренний счёт: <input type="checkbox" name="home"/><br><br>
            <input type="submit" value="добавить"/>
        </form>
    <#else>
        <form action="/money/kindofexpenditure/create" method="post">
            id: <input type="text" name="id" value="${recordId}"/><br><br>
            вид расхода: <input type="text" name="kind" value="${element.kind}"/><br><br>
            внутренний счёт: <input type="checkbox" name="home"
                    <#if element.home==true>
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
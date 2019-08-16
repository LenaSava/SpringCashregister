<html>

<body>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Введите товар" />
        <input type="text" name="tag" placeholder="Количество">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список продуктов</div>
<form method="post" action="filter">
    <input type="text" name="filter">
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <button type="submit">Найти</button>
</form>
{{#products}}
<div>
    <b>{{id}}</b>
    <span>{{text}}</span>
    <i>{{tag}}</i>
</div>
{{/products}}
</body>
</html>
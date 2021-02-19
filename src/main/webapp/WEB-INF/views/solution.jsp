<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Solution quadratic equation_2</title>
</head>
<body>
<div>
    <h2>Введите коэффициэнты квадратного уравнения a, b и c:</h2>
    <form:form action="/" method="post">
        <td>A</td>
        <input type="text" name="a" />
        <td>B</td>
        <input type="text" name="b" />
        <td>C</td>
        <input type="text" name="c" />
        <td colspan="2"><input type="submit" value="Расчитать"></td>
    </form:form>
</div>
</body>
</html>
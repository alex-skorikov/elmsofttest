<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Solution quadratic equation</title>
</head>
<body>
<div>
    <h2>Введите коэффициенты квадратного уравнения a, b и c:</h2>
    <form:form action="/" method="post">
        <td>A</td>
        <label>
            <input type="number" step="any" name="a" value="0.0"/>
        </label>
        <td>B</td>
        <label>
            <input type="number" step="any" name="b" value="0.0"/>
        </label>
        <td>C</td>
        <label>
            <input type="number" step="any" name="c" value="0.0"/>
        </label>
        <td colspan="2"><input type="submit" value="Расчитать"></td>
    </form:form>
</div>
</body>
</html>
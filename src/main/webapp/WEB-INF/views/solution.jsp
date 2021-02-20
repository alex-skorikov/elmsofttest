<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Solution quadratic equation</title>
</head>
<body>
<div>
    <h2>Решение квадратного уравнения:</h2>
    <form:form action="/" method="get">
        <table>
            <tr>
                <td>Коэффициент A = </td>
                <td>${coefficientA}</td>
            </tr>
            <tr>
                <td>Коэффициент B = </td>
                <td>${coefficientB}</td>
            </tr>
            <tr>
                <td>Коэффициент C = </td>
                <td>${coefficientC}</td>
            </tr>
            <tr>
                <td>Дискриминант = </td>
                <td>${discriminant}</td>
            </tr>
            <tr>
                <td>Первый корень = </td>
                <td>${rootFirst}</td>
            </tr>
            <tr>
                <td>Второй корень = </td>
                <td>${rootSecond}</td>
            </tr>
        </table>
        <td colspan="2"><input type="submit" value="Назад"></td>
    </form:form>
</div>
</body>
</html>
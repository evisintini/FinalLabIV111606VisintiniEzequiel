<%-- 
    Document   : confirmacion
    Created on : 31 ene. 2021, 10:55:22
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Ordenes" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de ordenes</h1>
        <table>
            <c:forEach var="ordenes" items="${lista}">
                <tr>
                    <td>${ordenes.id}</td>
                    <td>${ordenes.producto.descripcion}</td>
                    <td>${ordenes.cantidad}</td>
                    <td>${ordenes.costoTotal}</td>
                    <td>${ordenes.responsable.nombre}</td>
                    <td>${ordenes.cantidad}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

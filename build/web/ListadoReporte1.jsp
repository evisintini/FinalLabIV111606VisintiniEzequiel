<%-- 
    Document   : ListadoReporte1
    Created on : 18 dic. 2020, 11:14:22
    Author     : Usuario
--%>

<%@page import="Modelo.Reporte1"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <table>
            <th>Descripcion</th>
            <th>precio</th>
            <th>promedio</th>
                      
            <c:forEach var="l" items="${ListadoReporte1}">
                
                <td>${l.getDescripcion()}</td>
                <td>${l.getPrecio()}</td>
                <td>${l.getPromedio()}</td>

            </c:forEach>        
        </table>  
    
        
    </body>
</html>

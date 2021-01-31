<%-- 
    Document   : AltaOrden
    Created on : 18 dic. 2020, 9:49:27
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de orden</title>
    </head>
    <body>
       
           
                <h1>Alta de Orden</h1>
                <form action="/FinalLabIV111606VisintiniEzequiel/AltaOrden" method="POST">
                    <p>
                        <label>Producto: </label>
                        <select name="cmbProducto">
                            <c:forEach items="${Productos}" var="item">
                                <option value="${ item.id }">${ item.descripcion }</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        <label>Cantidad: </label>
                        <input name="txtCantidad" />
                    </p>
                    <p>
                        <label>Costo Total: </label>
                        <input name="txtCostoTotal" />
                    </p>
                    <p>
                        <label>Responsable: </label>
                        <select name="cmbResponsable">
                            <c:forEach items="${ Responsables }" var="item">
                                <option value="${ item.id }">${ item.apellido }</option>
                            </c:forEach>
                        </select>
                    </p>
                    <input type="submit" value="Aceptar" />
                    <a href="">
                </form>
                
      
    </body>
</html>
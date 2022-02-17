<%-- 
    Document   : listarCiudades
    Created on : 1 ene. 2022, 21:57:02
    Author     : josito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="Controlador.Ciudad" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table{
                border:1px;
                float:left;
                max-width:80%;}
            table th,a{
                font-size: 2em;
                background-color: blue;
                color: white;}
            table tr:nth-child(odd){
                background-color: grey;}
            a{
                border-radius:5px;}
            .rightFloat{float:right;
                        max-width:20%;
                        margin-right: 5%}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
           List<Ciudad> ciudades=(List<Ciudad>)request.getAttribute("ListaCiudades");
           pageContext.setAttribute("ciudades",ciudades);
        %>
    </head>
    <body>
        <table border = "1" width = "100%">
         <tr>
            <th>Nombre</th>
            <th>Nombre</th>
            <th>CountryCode</th>
            <th>Distrito</th>
            <th>Poblacion</th>
            <th>Update</th>
         </tr>
         
         <c:forEach var = "ciudad" items = "${ciudades}">
             <c:url var="enlace" value="Controlador">
                 <c:param name="action" value="cargaCiudad"  />
                 <c:param name="IdCiudad" value="${ciudad.getId()}"  />
             </c:url> 
             <c:url var="enlace2" value="Controlador">
                 <c:param name="action" value="borraCiudad"  />
                 <c:param name="IdCiudad" value="${ciudad.getId()}"  />
             </c:url> 
            <tr>
               <td><c:out value = "${ciudad.getId()}"/></td>
               <td><c:out value = "${ciudad.getNombre()}"/></td>
               <td><c:out value = "${ciudad.getCodigoPais()}"/></td>
               <td><c:out value = "${ciudad.getDistrito()}"/></td>
               <td><c:out value = "${ciudad.getPoblacion()}"/></td>
               <td><a href="${enlace}">Actualizar</a>&nbsp;<a href="${enlace2}">Eliminar</a></td>
            </tr>
         </c:forEach>
      </table>
        <div class="rightFloat">
            <a href="altaCiudad.html">Nueva ciudad</a>
        </div>
    </body>
</html>

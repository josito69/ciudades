<%-- 
    Document   : CargaCiudad
    Created on : 5 ene. 2022, 18:30:50
    Author     : josito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.Ciudad" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
           Ciudad city=(Ciudad)request.getAttribute("Ciudad");
        %>
    </head>
    <body>
          <form method="get" action="Controlador">
           <input type="hidden" name="action" value="updateCiudad" />
           <input type="hidden" name="IdCiudad" value="<%=city.getId()%>" />
           Nombre <input type="text" name="nombre"  value="<%=city.getNombre()%>"/><br /><br />
           Código país: <input type="text" name="codigoPais"  value="<%=city.getCodigoPais()%>"/><br /><br />
           Distrito: <input type="text" name="distrito"  value="<%=city.getDistrito()%>"/><br /><br />
           Población: <input type="text" name="poblacion"  value="<%=city.getPoblacion()%>"/><br /><br />
           <input type="reset" name="reset" value="Restablecer" />         
          <input type="submit" name="enviar" value="Enviar"/>          
       </form>
    </body>
</html>

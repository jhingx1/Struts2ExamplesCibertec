<%-- 
    Document   : principal
    Created on : 21/04/2018, 12:37:11 PM
    Author     : JAdv100-VS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="width: 400px">
        Bienvenido<s:property value="#session.usuario"/>
        </p>
        <h3>Opciones</h3>
        <s:url action="inicializarCliente" var="newCliente"/>
        
    <li>
        <ul><s:a href="%{newCliente}">Nuevo Cliente</s:a></ul>
    </li>
    </body>
</html>

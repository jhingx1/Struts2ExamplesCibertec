<%-- 
    Document   : resultado
    Created on : 27/04/2018, 08:03:40 PM
    Author     : JAdv100-VS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib  prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado</h1>
        <p style="width: 400px">
            El cliente <s:property value="cliente.nombre"/> 
            <s:property value="cliente.apellido"/> se registro exitosamente
        </p>
        
        <s:if test="cliente.publicidad == true">
            <p>Se le envió una cuponera a su correo electrónico</p>
        </s:if>
        
        <hr/>
        <s:url action="logout" var="salir"/>
        <s:a href="%{salir}"><s:text name="enlace.logout"/></s:a><%--<s:a href="%{salir}">Salir</s:a>--%>
        
        <s:debug/>
        
    </body>
</html>

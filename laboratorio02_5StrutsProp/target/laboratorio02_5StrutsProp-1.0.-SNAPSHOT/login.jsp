<%-- 
    Document   : login
    Created on : 21/04/2018, 12:35:30 PM
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
        <h1><s:text name="titulo.principal"/></h1><%--<h1>Laboratorio 2_3</h1>--%>
        <s:form action="login">
            <s:textfield label="Usuario" name="usuario.username"/> 
            <s:password label="Contraseña" name="usuario.password"/>
            <s:submit value="Ingresar"/>
        </s:form> 
        
        <s:actionerror/>
    </body>
</html>

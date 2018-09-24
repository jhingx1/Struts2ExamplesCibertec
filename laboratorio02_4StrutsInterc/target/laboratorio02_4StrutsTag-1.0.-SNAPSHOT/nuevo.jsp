<%-- 
    Document   : nuevo
    Created on : 28/04/2018, 09:23:27 AM
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
        <h1>Nuevo Cliente</h1>
        <s:form action="registrarCliente">
            <s:textfield label="Nombre" name="cliente.nombre"/>
            <s:textfield label="Apellido" name="cliente.apellido"/>
            <s:radio label="Genero" name="cliente.genero" 
                     list="#{'M':'Masculino','F':'Femenino'}"/>
            <s:select label="Profesion" name="cliente.profesion" 
                      list="#{'A1':'Arquitectura','D1':'Derecho','M1':'Marketing'}"
                      headerKey=""
                      feaderValue="---Seleccione---"
                      value="'S2'"/>
            <s:textfield label="Numero Movil" name="cliente.numeroMovil"/>
            <s:select label="Operador Movil" name="cliente.operadorMovil" 
                      list="operadores"
                      headerKey=""
                      headerValue="---Seleccione---"/>
            <s:checkbox label="Desea recibir publicidad?" name="cliente.publicidad"/>
            <s:textfield label="Correo Electrónico" name="cliente.correo"/>
            <s:submit value="Registrar"/>
        </s:form>
        
        <p><s:actionmessage/></p>
    </body>
</html>

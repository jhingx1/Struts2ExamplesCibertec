<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <style type="text/css">
            .errorMessage {
                color:red;
            }
        </style>
        <title><s:text name="aplicacion.titulo"/></title>
    </head>
    <body>
        <h1 style="text-align: center"><s:text name="login.titulo"/></h1>
        <s:form action="bienvenido" cssStyle="margin:auto;display:table">
            <s:textfield name="usuario" key="etiqueta.usuario"/>
            <s:password name="password" key="etiqueta.password"/>
            <s:submit key="etiqueta.submit"/>
        </s:form>
    </body>
</html>
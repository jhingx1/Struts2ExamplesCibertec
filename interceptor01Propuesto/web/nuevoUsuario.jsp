<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>
        <s:head /> <!-- CSS y JS -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center">Nuevo Usuario</h1>
        <s:form action="registro" cssStyle="margin: auto;display: table">
            <s:textfield name="username" label="Usuario: "></s:textfield>
            <s:textfield name="password" label="Contraseña: " type="password"></s:textfield>
            <s:submit value="Registrar"></s:submit>
        </s:form>
    </body>
</html>

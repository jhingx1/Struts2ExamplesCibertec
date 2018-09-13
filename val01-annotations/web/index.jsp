<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <s:head /> <!-- CSS y JS -->
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="margin: auto;width: 400px">
            <s:form action="action-data">
                <s:textfield name="alumno" label="Alumno"
                             maxlength="50" size="30" id="alumno"/>
                <s:textfield name="nota" label="Nota"
                             maxlength="10" size="10" id="nota"/>                
                <s:textfield name="correo" label="Correo"
                             maxlength="50" size="30" id="correo"/>
                <s:submit value="Enviar Datos"/>
            </s:form>
        </div>
    </body>
</html>
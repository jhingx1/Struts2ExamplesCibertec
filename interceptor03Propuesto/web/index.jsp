<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validacion de Archivo</title>
        <style type="text/css">
            .errorMessage {
                color:red;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center">Validacion de un Archivo</h1>
        <s:form action="data" method="post" enctype="multipart/form-data"
                cssStyle="margin:auto;display:table">
            <s:file name="archivo" label="Subir Imagen"/>
            <s:submit value="Enviar Imagen"/>
        </s:form>
        <h4 style="color: red;text-align: center">
            <s:actionmessage/>
        </h4>
    </body>
</html>
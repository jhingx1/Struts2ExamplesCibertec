<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
    <head>
        <sx:head />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- El formulario va hacia el action = data -->
        <s:form action="data" cssStyle="margin:auto;display:table">
            <!-- Etiqueta para auto completar-->
            <!-- Pasa al controller struts.xml el select(name) y pasarlo al ActionData-->
            <sx:autocompleter list="lista" name="select"   
                              listValue="gaseosaTexto"
                              listKey="gaseosaId"
                              label="Gaseosa Autocomplete"/>
            <s:submit value="Enviar Datos" align="center"
                      cssStyle="margin-top:20px" />
        </s:form>
    </body>
</html>
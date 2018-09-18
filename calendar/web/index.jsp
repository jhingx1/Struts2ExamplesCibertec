<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<!-- Se usa dojo -->
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
    <head>
        <sx:head /> <!-- Estilos de Dojo -->
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="data" cssStyle="margin:auto;display:table">
            <!-- name=fecha, es lo que se pasa hacia el controllers .xml y luego hacia el model action.-->
            <sx:datetimepicker name="fecha"
                               label="Nacimiento (dd-MMM-yyyy)"
                               displayFormat="dd-MMM-yyyy"
                               value="%{'today'}"/> <!-- Para que coja la fecha de hoy-->
            <s:submit value="Enviar"/>
        </s:form>
    </body>
</html>

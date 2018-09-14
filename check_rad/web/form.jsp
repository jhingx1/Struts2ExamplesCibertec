<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <s:head /> <!-- CSS y JS -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="margin: auto;width: 800px">
            <s:form action="action-data">
                <s:checkboxlist label="Selecciones días" labelposition="top"
                                list="cboDias"
                                listKey="id"
                                listValue="text"
                                name="check" />
                <s:radio label="Seleccione día" labelposition="top"
                         list="cboDias"
                         listKey="id"
                         listValue="text"
                         name="radio" value="3"/><!--sel.-->
                <s:submit value="Enviar Datos"/>
            </s:form>
        </div>
    </body>
</html>
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
        <div style="margin: auto;width: 400px">
            <s:form action="action-data">
                <s:select label="Día de la semana 01"
                          list="#{1:'Rojo',2:'Verde',3:'Azul'}"
                          name="color"/>
                <s:select label="Día de la semana 02"
                          list="cboDias"
                          listKey="id"
                          listValue="text"
                          size="4"
                          value="1"
                          name="dia02"/>
                <s:select label="Día de la semana 03"
                          list="cboDias"
                          listKey="id"
                          listValue="text"
                          size="4"
                          multiple="true"
                          name="dia03"/>
                <s:submit value="Enviar Datos"/>
            </s:form>
        </div>
    </body>
</html>

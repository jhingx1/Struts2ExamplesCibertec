<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <s:head /> <!-- CSS y JS -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Basico</title>
        
    </head>
    <body>
        
        <div style="margin: auto;width: 400px">
            <h1>Formulario Basico</h1>
            <s:form action="action-data">
                <!-- Alumno -->
                <s:textfield name="alumno" label="Alumno"
                             maxlength="50" size="30" id="alumno"/>
                <!-- Curso -->             
                <s:select label="Curso "
                          list="cboCursos"
                          listKey="id"
                          listValue="text"
                          name="curso"/>  

                <!-- Turno -->
                <s:radio label="Turno"
                         list="cboTurno"
                         listKey="id"
                         listValue="text"
                         name="turno" value="3"/>


                <!-- Local -->
                <s:select label="Local "
                          list="cboLocal"
                          listKey="id"
                          listValue="text"
                          name="local"/>

                <!-- Forma de Pago -->
                <s:checkboxlist label="Forma Pago"
                                list="cboFormaPago"
                                listKey="id"
                                listValue="text"
                                name="formaPago" />
                <!-- Total Pago -->
                <s:textfield name="totalPago" label="Total Pago"
                             maxlength="50" size="30" id="totalPago"/>

                <s:submit value="Enviar Datos"/>
            </s:form>
        </div>
    </body>
</html>

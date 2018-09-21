<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cibertec-extencion.com</title>
        <link href="jq/jquery-ui.min.css" type="text/css"rel="stylesheet"/>
        <link href="jq/timepicker/jquery-ui-timepicker-addon.css" type="text/css" rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/table.css" rel="stylesheet" type="text/css"/>
        <link href="parainfo/form.css" rel="stylesheet" type="text/css"/>

        <script src="jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="jq/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
        <script src="jq/i18n/jquery.ui.datepicker-es.js" type="text/javascript"></script>
        <script src="parainfo/table.js" type="text/javascript"></script>
        <script src="parainfo/form.js" type="text/javascript"></script>

        <script src="js/profesores.js" type="text/javascript"></script>
    </head>
    <body>
        <s:form action="profesoresUpd" theme="simple" method="post" 
                cssStyle="margin: auto;display: table" cssClass="parainfo">
            <s:hidden name="profesores.idprofesores"/>

            <fieldset>
                <legend>Actualizar Profesor</legend>

                <table class="tabla">
                    <tr>
                        <td>Nombre Profesor</td>
                        <td>
                            <s:textfield name="profesores.nombreprofesores" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Carrera</td>
                        <td>
                            <s:textfield name="profesores.carrera" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>                        
                    </tr>
                    <tr>
                        <td>Fecha Hora Ingreso</td>
                        <td>
                            <s:textfield name="profesores.fechahoraingreso" cssClass="fechahora"
                                         readonly="readonly"
                                         cssStyle="width:180px;margin-right:4px"/>
                        </td>                        
                    </tr>
                    <tr>
                        <td>Tipo Contrato</td>
                        <td>
                            <s:textfield name="profesores.tipocontrato" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>                        
                    </tr>

                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <s:submit value="Enviar Datos"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </s:form>

        <%-- para errores en UPD --%>
        <div class="msg_error errorMessage ui-state-highlight ui-corner-all">
            ${msg} <%-- para errores por DAO --%>

            <ul> <%-- para errores por validacion --%>
                <s:if test="fieldErrors.get('profesores.autor').size() > 0">
                    <li><s:property value="fieldErrors.get('profesores.autor').get(0)" /></li>
                    </s:if>
            </ul>
        </div>

        <p style="text-align: center">
            <a class="parainfo" href="profesoresQry">Cancelar</a>
        </p>
    </body>
</html>

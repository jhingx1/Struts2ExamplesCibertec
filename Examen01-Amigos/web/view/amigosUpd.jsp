<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/a.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/form.css" type="text/css" rel="stylesheet"/>

        <script src="jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="jq/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
        <script src="jq/i18n/jquery.ui.datepicker-es.js" type="text/javascript"></script>
        <script src="parainfo/form.js" type="text/javascript"></script>
        <script src="js/tiempos.js" type="text/javascript"></script>
        <script src="js/autores.js" type="text/javascript"></script>
    </head>
    <body>
        <s:form action="amigosUpd" theme="simple" method="post" 
                cssStyle="margin: auto;display: table" cssClass="parainfo">
            <s:hidden name="amigos.idamigo"/>
            
            <fieldset>
                <legend>Actualizar Autor</legend>

                <table class="tabla">
                    <tr>
                        <td>Nombre:</td>
                        <td>
                            <s:textfield name="amigos.nombre" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Correo</td>
                        <td>
                            <s:textfield name="amigos.correo" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Nacimiento</td>
                        <td>
                            <s:textfield name="amigos.nacimiento" 
                                         cssClass="fecha" 
                                         readonly="readonly"
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Teléfono</td>
                        <td>
                            <s:textfield name="amigos.telefono" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr> 
                    <tr>
                        <td>Dirección</td>
                        <td>
                            <s:textfield name="amigos.direccion" 
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
                <s:if test="fieldErrors.get('amigos.nombre').size() > 0">
                    <li><s:property value="fieldErrors.get('amigos.nombre').get(0)" /></li>
                </s:if>
                <s:if test="fieldErrors.get('amigos.correo').size() > 0">
                    <li><s:property value="fieldErrors.get('amigos.correo').get(0)" /></li>
                </s:if>
                <s:if test="fieldErrors.get('amigos.telefono').size() > 0">
                    <li><s:property value="fieldErrors.get('amigos.telefono').get(0)" /></li>
                </s:if>
                <s:if test="fieldErrors.get('amigos.direccion').size() > 0">
                    <li><s:property value="fieldErrors.get('amigos.direccion').get(0)" /></li>
                </s:if>
                <s:if test="fieldErrors.get('amigos.nacimiento').size() > 0">
                    <li><s:property value="fieldErrors.get('amigos.nacimiento').get(0)" /></li>
                </s:if>
            </ul>
        </div>

        <p style="text-align: center">
            <a class="parainfo" href="amigosQry">Cancelar</a>
        </p>
    </body>
</html>

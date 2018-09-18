<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
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
        
        <script src="js/tiempos.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 540px">
            <thead>
                <tr>
                    <td>Fecha</td>
                    <td>Hora</td>
                    <td>Fecha y Hora</td>
                    <th class="crud">
                        <!-- Para insertar una nueva fecha-->
                        <!-- Al dar clik, va al js. y busca la clase : .crud .ins-->
                        <a href="#" class="ins"><span></span></a>
                    </th>
                    <th class="crud">
                        <!-- Para borrar una fecha-->
                        <!-- Al dar clik, va al js. y busca la clase: .crud .del-->
                        <a href="#" class="del"><span></span></a>
                    </th>
                    <th class="crud">
                        <!-- Al dar clik, va al js. y busca la clase : .crud .upd-->
                        <a href="#" class="upd"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <!-- t_qry : Se envia desde el action, envia una lista y aqui solo la estamos recorriendo-->
                <c:forEach var="t" items="${t_qry}"><!-- Se agrego jstl-->
                    <tr>
                        <td>
                            <fmt:formatDate pattern="dd/MM/yyyy" 
                                            value="${t.fecha}"/>
                        </td>
                        <td>
                            <fmt:formatDate type="time" pattern="hh:mm:ss a" 
                                            value="${t.hora}"/>
                        </td>
                        <td colspan="2">
                            <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss a" 
                                            value="${t.fechahora}" />
                        </td>
                        <th>
                            <!-- name, para verificar los ckeckbox que estan marcados.-->
                            <!-- Para identificar a la fila timepo para luego eliminarla -->
                            <input type="checkbox" name="_del" 
                                   value="${t.idtiempo}"/> 
                        </th>
                        <!-- name, para verificar los radio que estan marcados.-->
                        <!-- Para identificar a la fila tiempo para luego actualizarla -->
                        <th>                            
                            <input type="radio" name="_upd" 
                                   value="${t.idtiempo}"/> 
                        </th>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>

        <%-- para INS  : oculto, modal de insersion. div:dins--%>
        <div style="display: none">
            <div id="dins" title="Nuevo registro">
                <!-- Tenemos un formulario, que va tiemposIns esta mapeado en struts.xml-->
                <s:form action="tiemposIns" theme="simple" cssClass="parainfo">
                    <table>
                        <tr>
                            <td>Fecha</td>
                            <td>
                                <s:textfield 
                                    name="fecha" cssClass="fecha" 
                                    readonly="readonly"
                                    cssStyle="width:180px;margin-right:4px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Hora</td>
                            <td>
                                <s:textfield 
                                    name="hora" cssClass="hora" 
                                    readonly="readonly"
                                    cssStyle="width:180px;margin-right:4px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Fecha Hora</td>
                            <td>
                                <s:textfield 
                                    name="fechahora" cssClass="fechahora" 
                                    readonly="readonly"
                                    cssStyle="width:180px;margin-right:4px"/>
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
                </s:form>
            </div>
        </div>

        <%-- para UPD : oculto, debe de cargar todos los datos. --%>
        <div style="display: none">
            <div id="dupd" title="Actualizar datos de registro">
                <!--- Este formulario lo vamos a enviar hacia el action = tiemposUpd
                atravez del struts.xml-->
                <s:form action="tiemposUpd" theme="simple" cssClass="parainfo">
                    <!-- Tenemos un campo oculto para identificar al tiempo/model unico-->
                    <s:hidden name="tiempos.idtiempo" id="idtiempo"/>

                    <table>
                        <tr>
                            <td>Fecha</td>
                            <td><!-- Notar que esta con un id -->
                                <s:textfield 
                                    name="fecha" cssClass="fecha" 
                                    readonly="readonly" id="fechax"
                                    cssStyle="width:180px;margin-right:4px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Hora</td>
                            <td>
                                <s:textfield 
                                    name="hora" cssClass="hora" 
                                    readonly="readonly" id="horax"
                                    cssStyle="width:180px;margin-right:4px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Fecha Hora</td>
                            <td>
                                <s:textfield 
                                    name="fechahora" cssClass="fechahora" 
                                    readonly="readonly" id="fechahorax"
                                    cssStyle="width:180px;margin-right:4px"/>
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
                </s:form>
            </div>
        </div>

        <%-- para mensajes  --%>
        <!-- Para mostrar si existe algun error -->
        <div id="error" class="ui-state-error ui-corner-all" 
             style="margin: auto;width: 500px;margin-top: 30px">
            <p style="text-align: center;font-weight: bold">${error}</p>
        </div>
        <!-- -->
        <c:choose>
            <c:when test="${error != null}">
                <script type="text/javascript">
            $("#error").css("display", "block").fadeIn("slow")
                    .delay(3000).fadeOut("slow");            
                </script>
            </c:when>
            <c:otherwise>
                <script type="text/javascript">
                    $("#error").css("display", "none");
                </script>
            </c:otherwise>
        </c:choose>
    </body>
</html>

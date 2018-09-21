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

        <script src="js/cursos.js" type="text/javascript"></script>
    </head>
    <body>
        <s:form action="cursosIns" theme="simple" method="post" 
                cssStyle="margin: auto;display: table" cssClass="parainfo">

            <fieldset>
                <legend>Nuevo Curso</legend>

                <table class="tabla">
                    <tr>
                        <td>Nombre Curso</td>
                        <td>
                        <s:textfield name="cursos.nombrecursos" 
                                     maxlength="200" 
                                     cssStyle="width:300px"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Descripcion</td>
                        <td>
                            <s:textfield name="cursos.descripcion" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Fecha Inicio</td>
                        <td>
                            <s:textfield name="cursos.fechainicio" cssClass="fecha" 
                                         readonly="readonly"
                                         cssStyle="width:180px;margin-right:4px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Fecha Fin</td>
                        <td>
                            <s:textfield name="cursos.fechafin" cssClass="fecha"
                                         readonly="readonly"
                                         cssStyle="width:180px;margin-right:4px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Hora Inicio</td>
                        <td>
                            <s:textfield name="cursos.horaInicio" cssClass="hora"
                                         readonly="readonly"
                                         cssStyle="width:180px;margin-right:4px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo</td>
                        <td>
                            <s:textfield name="cursos.tipo" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Horas</td>
                        <td>
                            <s:textfield name="cursos.horas" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Profesor</td>
                        <td>
                            <s:select name="cursos.idprofesores" list="cboProfesores"
                                      listKey="idprofesores" listValue="nombreprofesores"
                                      cssStyle="width:310px"/>
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

        <%-- para errores en INS --%>
        <div class="msg_error errorMessage ui-state-highlight ui-corner-all">
            ${msg} <%-- para errores por DAO --%>

            <ul> <%-- para errores por validacion --%>
                <s:if test="fieldErrors.get('cursos.nombreprofesores').size() > 0">
                    <li><s:property value="fieldErrors.get('cursos.nombreprofesores').get(0)" /></li>
                    </s:if>
            </ul>
        </div>

        <p style="text-align: center">
            <a class="parainfo" href="cursosQry">Cancelar</a>
        </p>
    </body>
</html>

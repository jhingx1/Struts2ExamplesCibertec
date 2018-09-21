<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cibertec-extencion.com</title>
        <link href="jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/a.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/table.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/message.css" rel="stylesheet" type="text/css"/>

        <script src="jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="parainfo/table.js" type="text/javascript"></script>
        <script src="parainfo/message.js" type="text/javascript"></script>

        <script src="js/profesores.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 300px">
            <thead>
                <tr>
                    <td>Nombre Profesores</td>
                    <td>Carrera</td>
                    <td>Fecha Hora Ingreso</td>
                    <td>Tipo Contrato</td>
                    <th class="crud">
                        <a class="ins" href="#" onclick="profesoresIns();"
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="del" href="#" onclick="profesoresDel();"
                           title="Retirar Registros"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="upd" href="#" onclick="profesoresUpd();"
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list">
                    <tr>
                        <td><s:property value="nombreprofesores"/></td>
                        <td><s:property value="carrera"/></td>
                        <td><s:property value="fechahoraingreso"/></td>
                        <td colspan="2"><s:property value="tipocontrato"/></td>
                        <th>
                            <input type="checkbox" name="idprofesores_del" 
                                   value="${idprofesores}"/>
                        </th>
                        <th>
                            <input type="radio" name="idprofesores_upd" 
                                   value="${idprofesores}"/>
                        </th>
                    </tr>
                </s:iterator>
            </tbody>
        </table>

        <p style="text-align: center">
            <a class="parainfo" href="cursosQry">Home</a>
        </p>

        <%-- mensajes del servidor --%>
        <h3 class="msg_error ui-state-highlight ui-corner-all">${msg}</h3>

        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
    </body>
</html>


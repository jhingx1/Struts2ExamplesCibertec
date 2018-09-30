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
        <link href="parainfo/table.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/message.css" rel="stylesheet" type="text/css"/>

        <script src="jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="parainfo/table.js" type="text/javascript"></script>
        <script src="parainfo/message.js" type="text/javascript"></script>

        <script src="js/autores.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 400px">
            <thead>
                <tr>
                    <td>Alumno</td>
                    <th class="crud">
                        <a class="ins" href="#" onclick="alumnosIns();"
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="del" href="#" onclick="alumnosDel();"
                           title="Retirar Registros"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="upd" href="#" onclick="alumnosUpd();"
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list">
                    <tr>
                        <td colspan="2">
                            <span style="font-weight: bold;" > 
                                <s:property value="nombre"/></span>
                            <div style="padding-left: 8px; font-size: 11px;">
                                - Fecha. Nac: <s:property value="nacimiento"/>
                                <br>
                                - Correo : <s:property value="correo"/>
                                <br>
                                - Correo : <s:property value="direccion"/>
                                <br>
                                - Telefono <s:property value="telefono"/>
                            </div>
                        </td>
                        <th>
                            <input type="checkbox" name="idalumnos_del" 
                                   value="${idamigo}"/>
                            <table style="width: 100%">

                            </table>
                        </th>
                        <th>
                            <input type="radio" name="idalumnos_upd" 
                                   value="${idamigo}"/>
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


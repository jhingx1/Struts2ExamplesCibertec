<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/table.css" rel="stylesheet" type="text/css"/>
        <link href="parainfo/form.css" rel="stylesheet" type="text/css"/>
        <link href="parainfo/message.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>

        <script src="jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="parainfo/table.js" type="text/javascript"></script>
        <script src="parainfo/form.js" type="text/javascript"></script>
        <script src="parainfo/message.js" type="text/javascript"></script>
        
        <script src="js/proveedores.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 540px">
            <thead>
                <tr>
                    <td>Nombre</td>
                    <td>correo</td>
                    <td>Ruc</td>
                    <td>Telefono</td>
                    <th class="crud">
                        <a href="#" class="ins"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="del"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="upd"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list">
                    <tr>
                        <td>
                            <s:property value="nombre"/>
                        </td>
                        <td>
                            <s:property value="correo"/>
                        </td>
                        <td>
                            <s:property value="ruc"/>
                        </td>
                        <td colspan="2">
                           <s:property value="telefono"/>
                       </td>
                        <th>
                            <input type="checkbox" name="_del" 
                                   value="${idproveedor}"/>
                        </th>
                        <th>
                            <input type="radio" name="_upd" 
                                   value="${idproveedor}"/>
                        </th>
                    </tr>
                </s:iterator> 
            </tbody>
        </table>

        <%-- para INS  --%>
        <div style="display: none">
            <div id="dins" title="Nuevo registro Proveedor">
                <s:form action="proveedoresIns" theme="simple" cssClass="parainfo">
                    <table>
                        <tr>
                            <td>Nombre</td>
                            <td>
                                <s:textfield name="proveedores.nombre" 
                                             maxlength="200" 
                                             cssStyle="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Ruc</td>
                            <td>
                                <s:textfield name="proveedores.ruc" 
                                             maxlength="200" 
                                             cssStyle="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>correo</td>
                            <td>
                                <s:textfield 
                                    name="correo" maxlength="200" 
                                    cssStyle="width: 200px;"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Telefono</td>
                            <td>
                                <s:textfield 
                                    name="telefono" maxlength="200" 
                                    cssStyle="width: 200px;text-align:"/>
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

        <%-- para UPD  --%>
        <div style="display: none">
            <div id="dupd" title="Actualizar datos de registro">
                <s:form action="proveedoresUpd" theme="simple" cssClass="parainfo">
                    <s:hidden name="proveedores.idproveedor" id="idproveedor"/>

                    <table>
                        <tr>
                            <td>Nombre</td>
                            <td>
                                <s:textfield name="proveedores.nombre" 
                                             maxlength="200" 
                                             cssStyle="width:200px" id="nombre"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Ruc</td>
                            <td>
                                <s:textfield name="proveedores.ruc" 
                                             maxlength="200" 
                                             cssStyle="width:200px" id="ruc"/>
                            </td>
                        </tr>
                        <tr>
                            <td>correo</td>
                            <td>
                                <s:textfield 
                                    name="correo" maxlength="200" 
                                    cssStyle="width: 200px;" id="correo"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Telefono</td>
                            <td>
                                <s:textfield 
                                    name="telefono" maxlength="200" 
                                    cssStyle="width: 200px;text-align: right" id="telefono"/>
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
        <div id="error" class="ui-state-error ui-corner-all" 
             style="margin: auto;width: 500px;margin-top: 30px">
            <p style="text-align: center;font-weight: bold">${error}</p>
        </div>
        
        <c:choose>
            <c:when test="${error != null}">
                <script type="text/javascript">
                    $("#error").css("display", "block").fadeIn("slow")
                    .delay(3000).fadeOut("slow");;
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

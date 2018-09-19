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
        
        <script src="js/tutoriales.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 540px">
            <thead>
                <tr>
                    <td>Producto</td>
                    <td>Precio</td>
                    <td>Tipo</td>
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
                            <s:property value="titulo"/>
                        </td>
                        <td>
                            <s:property value="precio"/>
                        </td>
                        <td colspan="2">
                            <s:property value="tipo"/>
                        </td>
                        <th>
                            <input type="checkbox" name="_del" 
                                   value="${idtutorial}"/>
                        </th>
                        <th>
                            <input type="radio" name="_upd" 
                                   value="${idtutorial}"/>
                        </th>
                    </tr>
                </s:iterator> 
            </tbody>
        </table>

        <%-- para INS  --%>
        <div style="display: none">
            <div id="dins" title="Nuevo registro">
                <s:form action="tutorialesIns" theme="simple" cssClass="parainfo">
                    <table>
                        <tr>
                            <td>Producto</td>
                            <td>
                                <s:textfield name="tutoriales.titulo" 
                                             maxlength="200" 
                                             cssStyle="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <s:select list="{'Separata','Video'}" 
                                          name="tutoriales.tipo"
                                          cssStyle="width: 205px" />
                            </td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td>
                                <s:textfield 
                                    name="precio" maxlength="10" 
                                    cssStyle="width: 60px;text-align: right"/>
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
                <s:form action="tutorialesUpd" theme="simple" cssClass="parainfo">
                    <s:hidden name="tutoriales.idtutorial" id="idtutorial"/>

                    <table>
                        <tr>
                            <td>Producto</td>
                            <td>
                                <s:textfield name="tutoriales.titulo" 
                                             maxlength="200" id="titulo" 
                                             cssStyle="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <s:select list="{'Separata','Video'}" 
                                          name="tutoriales.tipo" id="tipo"
                                          cssStyle="width: 205px" />
                            </td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td>
                                <s:textfield 
                                    name="precio" id="precio" maxlength="10"
                                    cssStyle="width: 60px;text-align: right"/>
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

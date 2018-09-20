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
        <script src="parainfo/form.js" type="text/javascript"></script>

        <script src="js/frases.js" type="text/javascript"></script>
    </head>
    <body>
        <s:form action="frasesIns" theme="simple" method="post" 
                cssStyle="margin: auto;display: table" cssClass="parainfo">

            <fieldset>
                <legend>Nueva Frase Célebre</legend>

                <table class="tabla">
                    <tr>
                        <td>Autor</td>
                        <td>
                            <s:select name="frases.idautor" list="cboAutores"
                                      listKey="idautor" listValue="autor"
                                      cssStyle="width:310px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Frase</td>
                        <td>
                            <s:textarea name="frases.frase" 
                                        cssStyle="width:300px;height:60px"/>
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
                <s:if test="fieldErrors.get('frases.idautor').size() > 0">
                    <li>
                        <s:property value="fieldErrors.get('frases.idautor').get(0)" />
                    </li>
                </s:if>
                <s:if test="fieldErrors.get('frases.frase').size() > 0">
                    <li>
                        <s:property value="fieldErrors.get('frases.frase').get(0)" />
                    </li>
                </s:if>
            </ul>
        </div>

        <p style="text-align: center">
            <a class="parainfo" href="frasesQry">Cancelar</a>
        </p>
    </body>
</html>

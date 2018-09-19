<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
    <head>
        <sx:head />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- etiqueta : para crear un panel -->
        <sx:tabbedpanel id="miPanel" cssStyle="width: 400px;height: 100px;margin:auto"
                        doLayout="true" selectedTab="one">
            <!-- Crear pestaña 1 -->
            <sx:div id="one" label="Mensaje 1" labelposition="top" >
                <!-- Formulario-->
                <s:form action="data1">
                    <s:submit value="Ver 1" cssStyle="margin:30px"/>
                </s:form>
            </sx:div>
            <!-- Crear pestaña 2 -->
            <sx:div id="two" label="Mensaje 2" labelposition="top" >
                <!-- Formulario-->
                <s:form action="data2">
                    <s:submit value="Ver 2"
                              cssStyle="margin:30px;margin-left:100px"/>
                </s:form>
            </sx:div>
            <!-- Crear pestaña 3 -->
            <sx:div id="three" label="Mensaje 3" labelposition="top" >
                <!-- Formulario-->
                <s:form action="data3">
                    <s:submit value="Ver 3"
                              cssStyle="margin:30px;margin-left:200px"/>
                </s:form>
            </sx:div>
            s
        </sx:tabbedpanel>
    </body>
</html>
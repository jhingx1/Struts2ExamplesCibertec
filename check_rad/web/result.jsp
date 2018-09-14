<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4 style="text-align: center">
            ID de dias seleccionados:
            <s:iterator value="check" var="x">
                <s:property value="#x"/>,
            </s:iterator>
        </h4>
        <h4 style="text-align: center">
            ID de dia seleccionado: ${radio}
        </h4>
        <p style="text-align: center">
            <a href="index.jsp">volver</a>
        </p>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4 style="text-align: center">
            ID de dia01 seleccionado: ${dia01}
        </h4>
        <h4 style="text-align: center">
            ID de dia02 seleccionado: ${dia02}
        </h4>
        <h4 style="text-align: center">
            ID de dia03 seleccionado:
            <s:iterator value="dia03" var="x">
                <s:property value="#x"/>,
            </s:iterator>
        </h4>
        <p style="text-align: center">
            <a href="index.jsp">volver</a>
        </p>
    </body>
</html>
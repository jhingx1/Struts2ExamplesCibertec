<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4 style="text-align: center">
            Nacimiento: <s:property value="fecha"/>
        </h4>
        <p style="text-align: center">
            <s:a href="index.jsp">Volver</s:a>
        </p>
    </body>
</html>
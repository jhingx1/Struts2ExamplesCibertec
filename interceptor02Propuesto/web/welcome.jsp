<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="text-align: center">
            Bienvenido, <s:property value="user"/>
        </h3>
        <p style="text-align: center"><a href="index.jsp">Regresar</a></p>
    </body>
</html>
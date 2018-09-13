<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="text-align: center">
            Bienvenido ${alumno} a Struts<sup>2</sup>
        </h3>
        <h4 style="text-align: center">
            Su nota es ${nota}
        </h4>
        <h4 style="text-align: center">
            Su correo es ${correo}
        </h4>
        <p style="text-align: center">
            <a href="index.jsp">volver</a>
        </p>
    </body>
</html>

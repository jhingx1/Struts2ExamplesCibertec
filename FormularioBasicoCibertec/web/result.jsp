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

        <h3 style="text-align: center">
            Alumno : ${alumno}
        </h3>
        <!-- 
        <h4 style="text-align: center">
            Curso: ${curso}
        </h4>
        -->
        <s:if test="%{curso==1}">
            <h3 style="text-align: center">Lenguaje de Java</h3>
        </s:if>
        <s:if test="%{curso==2}">
            <h3 style="text-align: center">Lenguaje de PHP</h3>
        </s:if>
        <s:if test="%{curso==3}">
            <h3 style="text-align: center">Lenguaje de Python</h3>
        </s:if>

        <h4 style="text-align: center">
            Total de Pago: ${totalPago}
        </h4>

        <h4 style="text-align: center">
            Local: ${local}
        </h4>
        
        <s:if test="%{curso==1}">
            <h3 style="text-align: center">Lenguaje de Java</h3>
        </s:if>
        <s:if test="%{curso==2}">
            <h3 style="text-align: center">Lenguaje de PHP</h3>
        </s:if>
        <s:if test="%{curso==3}">
            <h3 style="text-align: center">Lenguaje de Python</h3>
        </s:if>

        <h4 style="text-align: center">
            Turno: ${turno}
        </h4>

        <h4 style="text-align: center">
            Turno: ${formaPago}
        </h4>       
        <p style="text-align: center">
            <a href="index.jsp">volver</a>
        </p>
    </body>
</html>
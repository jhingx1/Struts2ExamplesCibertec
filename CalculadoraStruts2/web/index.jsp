<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="calcular">
            <div class="form-group">            
                <s:textfield label="Introduce Valor 1" name="n1"/>
            </div>
            <!--
            <div class="form-group">
                
            </div> 
            -->
            <div class="form-group">            
                <s:textfield label="Introduce Valor 2" name="n2"/>
            </div>

        <tr><td colspan="2" style="text-align: center;padding-top: 20px">
                <s:submit value="+" name="operacion" theme="simple"/>
                <s:submit value="-" name="operacion" theme="simple"/>
                <s:submit value="*" name="operacion" theme="simple"/>
                <s:submit value="/" name="operacion" theme="simple"/>
        </td></tr>

    </s:form>
</body>
</html>

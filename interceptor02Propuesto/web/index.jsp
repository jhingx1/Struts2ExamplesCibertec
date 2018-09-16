<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>
        <s:head /> <!-- CSS y JS -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="login" cssStyle="margin:auto;display:table">
            <s:textfield name="user" label="Nombre"></s:textfield>
            <s:submit value="login"></s:submit>
        </s:form>
    </body>
</html>
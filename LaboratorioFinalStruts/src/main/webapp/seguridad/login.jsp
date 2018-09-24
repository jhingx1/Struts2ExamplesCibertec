<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
        <s:head/>
    </head>
    <body id = "body">
        <div class="logo"></div>
        <div class="login-block">
            <s:url var="ingles" includeParams="all" value="">
                <s:param name="request_locale">en</s:param>
            </s:url>	
            <s:url var="espanol" includeParams="all" value="">
                <s:param name="request_locale">es</s:param>
            </s:url>
            <h1><s:text name="titulo.principal"/></h1>
            <s:form action="login">                
                <s:textfield key="formulario.username" name="usuario.username" id="txtUsuario"/>  
                <s:password key="formulario.password" name="usuario.password" id="txtPassword" />
                <s:submit key="formulario.boton"/>
            </s:form>
            <s:a href="%{ingles}">Ingles</s:a>
            <s:a href="%{espanol}">Español</s:a>
            <div style="text-align: center;">
                <s:actionerror /> 
            </div>
        </div>      
    </body>

</html>

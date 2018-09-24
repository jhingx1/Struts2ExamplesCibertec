<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .pad20{
                padding:10px;
            }
        </style>
    </head>
    <body>
        <s:url action="listarProducto" id="listProducto" />
        <div style="text-align: left;">
            <div style="float:left;margin-right:20px;">
                <s:a href="%{listProducto}" class="fa fa-arrow-circle-o-left Fs20 Red"> <s:text name="producto.volver"/></s:a>
            </div>                
        </div>
        <h1>Nuevo Producto</h1>
        <s:form action="modificarProducto">
            <s:textfield class="ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all" type="hidden" name="producto.codigoproducto" />
            <s:textfield class="ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all" label="Nombre" name="producto.nombre"/>
            <s:textfield class="ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all" label="Precio" name="producto.precio"/>
            <s:submit value="Registrar" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only BrownButton pad20"/>
        </s:form>
        <p>
            <s:actionmessage/>
        </p>
    </body>
</html>

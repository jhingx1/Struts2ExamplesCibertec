<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="resources/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
        <script src="resources/jquery/jquery-ui.min.js" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">

        <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>


        <!--
        
        <link href="resources/jquery/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/jquery/smoothness-jquery-ui.css" rel="stylesheet" type="text/css"/>
        <script src="resources/jquery/jquery-1.12.3.js" type="text/javascript"></script>
        <script src="resources/jquery/dataTables.jqueryui.min.js" type="text/javascript"></script>
        <script src="resources/jquery/dataTables.jqueryui.min.js" type="text/javascript"></script>-->

        <style>
            tbody tr:nth-child(odd) {
                background-color: #ccc;
            }
        </style>
        <script>
            
            $(document).ready(function () {
                $('#example').DataTable();
            });
            
        </script>
    </head>
    <body>
        <div style="text-align: left;">
            <div style="float:left;margin-right:20px;">
                <s:a action="irPrincipal" class="fa fa-arrow-circle-o-left Fs20 Red"> <s:text name="producto.volver"/></s:a>
                </div>
                <div>   
                <s:a action="irNuevoProducto" class="fa fa-plus-circle Green Fs20"><s:text name="producto.insertar"/></s:a>
                </div>
            </div>
                    <h2 style="padding-top: 10px;padding-bottom: 15px;"><s:text name="producto.titulo"/></h2>
            <table id="example" class="display" cellspacing="0" width="100%" style="text-align: center">
                <tr style="background-color: #ccc">
                    <th>CODIGO</th>
                    <th>NOMBRE</th>
                    <th>PRECIO</th>
                    <th>ELIMINAR</th>
                    <th>MODIFICAR</th>
                </tr>
            <s:iterator value="%{listaProductos}">
                <tr>
                    <td><s:property value="codigoproducto"/></td>
                    <td><s:property value="nombre"/></td>
                    <td><s:property value="precio"/></td>
                    <td>
                        <s:url var="borrarProd" value="eliminarProducto">
                            <s:param name="id"><s:property value="codigoproducto"/></s:param> 
                        </s:url> 
                        <s:a href="%{borrarProd}"><span class="fa fa-trash-o"></span></s:a>
                        </td>
                        <td>
                        <s:url var="modificarProd" value="irModificarProducto">
                            <s:param name="id"><s:property value="codigoproducto"/></s:param> 
                        </s:url> 
                        <s:a href="%{modificarProd}"><span class="fa fa-pencil"></span></s:a>
                        </td>
                    </tr>
            </s:iterator>

        </table>
    </body>
</html>

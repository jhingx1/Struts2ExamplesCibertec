<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><t:getAsString name="title"/></title>
    </head>
    <body>
        <table cellpadding="0" cellspacing="0" border="1" 
               width="500px" height="400px" style="margin: auto">
            <tr>
                <td bgcolor="red">
                    <!-- Redirigidos desde tiles.xml-->
                    <!-- Aqui estamos mapeado a un ruta:header, y esta no redirige hacia tiles.xml -->
                    <t:insertAttribute name="header"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="aqua">
                    <t:insertAttribute name="menu"/>
                </td>
            </tr>
            <tr>
                <td  height="150px" valign="top">
                    <t:insertAttribute name="body"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="gray">
                    <t:insertAttribute name="footer"/>
                </td>
            </tr>
        </table>
    </body>
</html>
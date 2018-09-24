<%-- 
    Document   : plantilla01
    Created on : 2/05/2012, 10:11:27 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>   
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="resources/primefaces-yourtheme/theme.css" rel="stylesheet" type="text/css"/>
        <link href="resources/primefaces-yourtheme/css/core-layout.css" rel="stylesheet" type="text/css"/>
        <link href="resources/primefaces-yourtheme/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="resources/primefaces-yourtheme/css/bv-font.css" rel="stylesheet" type="text/css"/>
        <link href="resources/primefaces-yourtheme/css/animate.css" rel="stylesheet" type="text/css"/>
        <link href="resources/primefaces-yourtheme/css/bv-layout.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/validatrix.css" rel="stylesheet" type="text/css"/>
        <script src="resources/primefaces-yourtheme/jquery/jquery.js" type="text/javascript"></script>
        <script src="resources/primefaces-yourtheme/jquery/jquery-plugins.js" type="text/javascript"></script>
        <!--
        <script src="resources/primefaces-yourtheme/js/ripple-effect.js" type="text/javascript"></script>
        -->
        <script src="resources/primefaces-yourtheme/js/perfect-scrollbar.js" type="text/javascript"></script>
        <script src="resources/js/validatrix.min.js" type="text/javascript"></script>

    </head>
    <body>
        <tiles:insertAttribute name="cabecera" />
        <div id="wrapper">
            <div id="wrapperIndent">
                <tiles:insertAttribute name="menu" />
                <div id="layout-portlets-cover">
                    <div class="Container100">
                        <div class="ContainerIndent">
                            <div class="Card ShadowEffect TexAlCenter">
                                <!--Aca va el contenido de las paginas-->
                                <tiles:insertAttribute name="cuerpo" />
                            </div>
                        </div>
                    </div>
                    <tiles:insertAttribute name="pie" />
                </div>

            </div>
        </div>
    </body>
</html>

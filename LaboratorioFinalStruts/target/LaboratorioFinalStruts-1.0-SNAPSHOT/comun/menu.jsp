<%@taglib prefix="s" uri="/struts-tags"%>
<s:url action="listarProducto" id="listProducto" />
<s:url action="logout" id="logout" />
<div class="Animated05" id="layout-menu-cover">
    <form>
        <ul class="layout-menu">
            <li>
                <a class="menulink ripplelink">
                    <i class="icon-round58 Fs40"></i>
                    <span class="Fs18"><label>Admin</label><i class="Fright Fs20"></i><br /><span class="Fs12 FontRobotoLight"></span></span>
                </a>
            </li>
        </ul>
    </form>
    <div class="Separator"></div>
    <ul id="j_idt14" class="layout-menu rio-menu">
        <li id="rm_default" role="menuitem">
            <s:a href="%{listProducto}" class="menulink ripplelink"><i class="fa fa-gears"></i> <s:text name="producto.titulo"/></s:a>                            
        </li>
        <li class="Separator"></li>
        <li id="rm_default" role="menuitem">
        <s:a href="%{logout}" class="menulink ripplelink"><i class="fa fa-close"></i> <s:text name="menu.cerrar"/></s:a>
        </li>
    </ul>
</div>

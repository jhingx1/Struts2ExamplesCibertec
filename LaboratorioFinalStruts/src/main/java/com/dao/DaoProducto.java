package com.dao;

import java.util.List;
import com.entity.Producto;

public interface DaoProducto {

    public List<Producto> productosQry();
    
    public int productosIns(Producto productos);
    
    public int productosDel(int ids);
    
    public Producto productosGet(Integer idproducto);
    
    public int productosUpd(Producto productos);
}




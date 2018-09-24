package com.action;

import com.dao.DaoProducto;
import com.dao.implement.PersistenceDaoProducto;
import com.entity.Producto;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class ProductoAction extends ActionSupport {
    private int id;
    private Producto producto = new Producto();;
    private final DaoProducto daoProducto = new PersistenceDaoProducto();
    private List<Producto> listaProductos;

    public ProductoAction() { 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public String listarTodo(){
        listaProductos = daoProducto.productosQry();
        return SUCCESS;
    }
    
    public String irNuevoProducto(){
        return SUCCESS;
    }
    
    public String crearProducto(){
        int resultado = daoProducto.productosIns(producto);
        if(resultado == 1){
            return SUCCESS;
        }else{
             return INPUT;
        }
    }
    
    public String eliminarProducto(){
        int resultado = daoProducto.productosDel(id);
        if(resultado == 1){
            addActionMessage("Se eleimino el registro #"+id);
            return SUCCESS;
        }else{
            addActionMessage("no se pudo eliminar el registro");
            return SUCCESS;
        }
    }
    
    public String irModificarProducto(){
        producto = daoProducto.productosGet(id);
        return SUCCESS;
    }
    
    public String modificarProducto(){
        int resultado = daoProducto.productosUpd(producto);
        if(resultado == 1){
            return SUCCESS;
        }else{
             return INPUT;
        }
    }
    
}

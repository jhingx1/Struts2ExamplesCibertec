/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.implement;

/**
 *
 * @author JAVA_LM
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import com.dao.DaoProducto;
import com.entity.Producto;
import com.util.SqlConecta;

public class PersistenceDaoProducto implements DaoProducto {

    private final SqlConecta conecta;

    public PersistenceDaoProducto() {
        this.conecta = new SqlConecta();
    }

    @Override
    public List<Producto> productosQry() {
        List<Producto> list = null;
        String sql = "select codigoproducto,nombre,precio from productos";

        Connection cn = conecta.connection();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                list = new ArrayList<>();

                while (rs.next()) {
                    Producto p = new Producto();

                    p.setCodigoproducto(rs.getInt(1));
                    p.setNombre(rs.getString(2));
                    p.setPrecio(rs.getDouble(3));

                    list.add(p);
                }

            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return list;
    }

    @Override
    public int productosIns(Producto productos) {
        String result = null;
        int ctos = 0;
        String sql = "INSERT INTO productos(nombre,precio) VALUES(?,?) ";

        Connection cn = conecta.connection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, productos.getNombre());
                ps.setDouble(2, productos.getPrecio());

                ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }

        return ctos;
    }

    @Override
    public int productosDel(int ids) {
        String result = null;
        int ctos = 0;
        String sql = "DELETE FROM productos WHERE codigoproducto=?";

        Connection cn = conecta.connection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, ids);

                ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("Código " + ids + " Incorrecto");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }
        return ctos;
    }

    @Override
    public Producto productosGet(Integer idproducto) {
        Producto productos = null;
        String sql = "SELECT "
                + "codigoproducto, "
                + "nombre, "
                + "precio "
                + "FROM productos "
                + "WHERE codigoproducto=? ";

        Connection cn = conecta.connection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idproducto);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    productos = new Producto();

                    productos.setCodigoproducto(rs.getInt(1));
                    productos.setNombre(rs.getString(2));
                    productos.setPrecio(rs.getDouble(3));
                }

            } catch (SQLException e) {
                System.out.println("");
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return productos;
    }

    @Override
    public int productosUpd(Producto productos) {
        String result = null;
        int ctos = 0;
        String sql = "UPDATE productos SET "
                + "nombre=?, "
                + "precio=? "
                + "WHERE codigoproducto=? ";

        Connection cn = conecta.connection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, productos.getNombre());
                ps.setDouble(2, productos.getPrecio());
                ps.setInt(3, productos.getCodigoproducto());

                ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }

        return ctos;
    }
}

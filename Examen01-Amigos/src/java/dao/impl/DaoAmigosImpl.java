/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import accesobd.ConectaDb;
import dao.DaoAmigos;
import dto.Amigos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author caceijas
 */
public class DaoAmigosImpl implements DaoAmigos{
    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;
    
    public DaoAmigosImpl(){
        this.db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    
    @Override
    public List<Amigos> amigosQry() {
        List<Amigos> list = null;
        sql.append("SELECT ")
                .append("idamigo, ")
                .append("nombre, ")
                .append("correo, ")
                .append("telefono, ")
                .append("direccion, ")
                .append("nacimiento ")                
                .append("FROM amigos");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery()) {

            list = new LinkedList<>();
            while (rs.next()) {
                Amigos a = new Amigos();

                a.setIdamigo(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setCorreo(rs.getString(3));
                a.setTelefono(rs.getString(4));
                a.setDireccion(rs.getString(5));
                a.setNacimiento(rs.getDate(6));               

                list.add(a);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    @Override
    public String amigosIns(Amigos amigos) {
        sql.append("INSERT INTO amigos(")
                .append("nombre, ")
                .append("correo, ")
                .append("telefono, ")
                .append("direccion, ")
                .append("nacimiento ")    
                .append(") VALUES(?,?,?,?,?)");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setString(1, amigos.getNombre());
            ps.setString(2, amigos.getCorreo());
            ps.setString(3, amigos.getTelefono());
            ps.setString(4, amigos.getDireccion());            
            ps.setDate(5,new java.sql.Date(amigos.getNacimiento().getTime()));

            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }
    
    @Override
    public String amigosDel(List<Integer> ids) {
        sql.append("DELETE FROM amigos WHERE idamigo=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            cn.setAutoCommit(false); // desactiva autoCommit
            boolean ok = true;

            for (Integer x : ids) {
                ps.setInt(1, x);

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    message = "ID recibido no existe";
                    break;
                }
            }

            if (ok) {
                cn.commit();
            } else {
                cn.rollback();
            }

            cn.setAutoCommit(true); // activa autoCommit

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Amigos amigosGet(Integer ids) {
        Amigos amigos = null;
        sql.append("SELECT ")
                .append("idamigo, ")
                .append("nombre, ")
                .append("correo, ")
                .append("telefono, ")
                .append("direccion, ")
                .append("nacimiento ")    
                .append("FROM amigos ")
                .append("WHERE idamigo=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, ids);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    amigos = new Amigos();

                    amigos.setIdamigo(rs.getInt(1));
                    amigos.setNombre(rs.getString(2));
                    amigos.setCorreo(rs.getString(3));
                    amigos.setTelefono(rs.getString(4));
                    amigos.setDireccion(rs.getString(5));
                    amigos.setNacimiento(rs.getDate(6));                    
                } else {
                    throw new SQLException("ID: " 
                            + ids + " no existe");
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return amigos;
    }

    @Override
    public String amigosUpd(Amigos amigos) {
        sql.append("UPDATE amigos SET ")
                .append("nombre=?, ")
                .append("correo=?, ")
                .append("telefono=?, ")
                .append("direccion=?, ")  
                .append("nacimiento=? ")   
                .append("WHERE idamigo=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setString(1, amigos.getNombre());
            ps.setString(2, amigos.getCorreo());
            ps.setString(3, amigos.getTelefono());
            ps.setString(4, amigos.getDireccion());
            ps.setDate(5,new java.sql.Date(amigos.getNacimiento().getTime()));
            ps.setInt(6, amigos.getIdamigo());

            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException ex) {
            message = ex.getMessage();
        }

        return message;
    }



    @Override
    public String getMessage() {
        return message;
    }
}

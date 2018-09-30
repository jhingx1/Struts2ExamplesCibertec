/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import accesobd.ConectaDb;
import dao.DaoAlumnos;
import dto.Alumnos;
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
public class DaoAlumnosImpl implements DaoAlumnos{
    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;
    
    public DaoAlumnosImpl(){
        this.db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    
    @Override
    public List<Alumnos> alumnosQry() {
        List<Alumnos> list = null;
        sql.append("SELECT ")
                .append("idalumno, ")
                .append("alumno, ")
                .append("apellido, ")
                .append("fecnacimiento, ")
                .append("sexo, ")
                .append("telefono ")                
                .append("FROM alumnos");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery()) {

            list = new LinkedList<>();
            while (rs.next()) {
                Alumnos a = new Alumnos();

                a.setIdalumno(rs.getInt(1));
                a.setAlumno(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFecnacimiento(rs.getDate(4));
                a.setSexo(rs.getString(5));
                a.setTelefono(rs.getString(6));               

                list.add(a);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    @Override
    public String alumnosIns(Alumnos alumnos) {
        sql.append("INSERT INTO alumnos(")
                .append("alumno, ")
                .append("apellido, ")
                .append("fecnacimiento, ")
                .append("sexo, ")
                .append("telefono ")    
                .append(") VALUES(?,?,?,?,?)");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setString(1, alumnos.getAlumno());
            ps.setString(2, alumnos.getApellido());
            ps.setDate(3,new java.sql.Date(alumnos.getFecnacimiento().getTime()));
            ps.setString(4, alumnos.getSexo());
            ps.setString(5, alumnos.getTelefono());
            

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
    public String alumnosDel(List<Integer> ids) {
        sql.append("DELETE FROM alumnos WHERE idalumno=?");

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
    public Alumnos alumnosGet(Integer ids) {
        Alumnos alumnos = null;
        sql.append("SELECT ")
                .append("idalumno, ")
                .append("alumno, ")
                .append("apellido, ")
                .append("fecnacimiento, ")
                .append("sexo, ")
                .append("telefono ")
                .append("FROM alumnos ")
                .append("WHERE idalumno=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, ids);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    alumnos = new Alumnos();

                    alumnos.setIdalumno(rs.getInt(1));
                    alumnos.setAlumno(rs.getString(2));
                    alumnos.setApellido(rs.getString(3));
                    alumnos.setFecnacimiento(rs.getDate(4));
                    alumnos.setSexo(rs.getString(5));
                    alumnos.setTelefono(rs.getString(6));                    
                } else {
                    throw new SQLException("ID: " 
                            + ids + " no existe");
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return alumnos;
    }

    @Override
    public String alumnosUpd(Alumnos alumnos) {
        sql.append("UPDATE alumnos SET ")
                .append("alumno=?, ")
                .append("apellido=?, ")
                .append("fecnacimiento=?, ")
                .append("sexo=?, ")  
                .append("telefono=? ")   
                .append("WHERE idalumno=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setString(1, alumnos.getAlumno());
            ps.setString(2, alumnos.getApellido());
            ps.setDate(3,new java.sql.Date(alumnos.getFecnacimiento().getTime()));
            ps.setString(4, alumnos.getSexo());
            ps.setString(5, alumnos.getTelefono());
            ps.setInt(6, alumnos.getIdalumno());

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

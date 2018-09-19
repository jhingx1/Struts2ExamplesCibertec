package dao.impl;

import dao.DaoProveedores;
import dto.Proveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import parainfo.sql.ConectaDb;

public class DaoProveedoresImpl implements DaoProveedores {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoProveedoresImpl() {
        this.db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Proveedores> proveedoresQry() {
        List<Proveedores> list = null;
        sql.append("SELECT ")
                .append("idproveedor,")
                .append("nombre,")
                .append("ruc,")
                .append("correo,")
                .append("telefono ")
                .append("FROM proveedores");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery()) {

            list = new LinkedList<>();
            while (rs.next()) {
                Proveedores p = new Proveedores();

                p.setIdproveedor(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setRuc(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setTelefono(rs.getString(5));

                list.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String proveedoresIns(Proveedores proveedores) {
        sql.append("INSERT INTO proveedores(")
                .append("nombre,")
                .append("ruc,")
                .append("correo,")
                .append("telefono")
                .append(") VALUES(?,?,?,?)");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setString(1, proveedores.getNombre());
            ps.setString(2, proveedores.getRuc());
            ps.setString(3, proveedores.getCorreo());
            ps.setString(4,proveedores.getTelefono());

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
    public String proveedoresDel(List<Integer> ids) {
        sql.append("DELETE FROM proveedores WHERE idproveedor=?");

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
    public Proveedores proveedoresGet(Integer idproveedor) {
        Proveedores proveedores = null;
        sql.append("SELECT ")
                .append("idproveedor,")
                .append("nombre,")
                .append("ruc,")
                .append("correo,")
                .append("telefono ")
                .append("FROM proveedores ")
                .append("WHERE idproveedor=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, idproveedor);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proveedores = new Proveedores();

                    proveedores.setIdproveedor(rs.getInt(1));
                    proveedores.setNombre(rs.getString(2));
                    proveedores.setRuc(rs.getString(3));
                    proveedores.setCorreo(rs.getString(4));
                    proveedores.setTelefono(rs.getString(5));

                } else {
                    throw new SQLException("ID: " + 
                            idproveedor + " no existe");
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return proveedores;
    }

    @Override
    public String proveedoresUpd(Proveedores proveedores) {
        sql.append("UPDATE proveedores SET ")
                .append("nombre=?,")
                .append("ruc=?,")
                .append("correo=?,")
                .append("telefono=? ")
                .append("WHERE idproveedor=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setString(1, proveedores.getNombre());
            ps.setString(2, proveedores.getRuc());
            ps.setString(3, proveedores.getCorreo());
            ps.setString(4, proveedores.getTelefono());
            ps.setInt(5, proveedores.getIdproveedor());
            
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


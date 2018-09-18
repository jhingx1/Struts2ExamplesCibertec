package dao.impl;

import dao.DaoTiempos;
import dto.Tiempos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import parainfo.sql.ConectaDb;

public class DaoTiemposImpl implements DaoTiempos {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoTiemposImpl() {
        this.db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Tiempos> tiemposQry() {
        List<Tiempos> list = null;
        sql.append("SELECT ")
                .append("idtiempo,")
                .append("fecha,")
                .append("hora,")
                .append("fechahora ")
                .append("FROM tiempos");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery()) {

            list = new LinkedList<>();
            while (rs.next()) {
                Tiempos t = new Tiempos();

                t.setIdtiempo(rs.getInt(1));
                t.setFecha(rs.getDate(2));
                t.setHora(rs.getTime(3));
                t.setFechahora(rs.getTimestamp(4));

                list.add(t);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    //llamado dese el action
    @Override
    public String tiemposIns(Tiempos tiempos) {
        sql.append("INSERT INTO tiempos(")
                .append("fecha,")
                .append("hora,")
                .append("fechahora")
                .append(") VALUES(?,?,?)");

        try (Connection cn = db.getConnection();
                PreparedStatement ps
                = cn.prepareStatement(sql.toString())) {

            ps.setDate(1, tiempos.getFecha());
            ps.setTime(2, tiempos.getHora());
            ps.setTimestamp(3, tiempos.getFechahora());

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
    public String tiemposDel(List<Integer> ids) {
        sql.append("DELETE FROM tiempos WHERE idtiempo=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps
                = cn.prepareStatement(sql.toString())) {

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
    //obtener un unico elemento.
    @Override
    public Tiempos tiemposGet(Integer idtiempo) {
        Tiempos tiempos = null;
        sql.append("SELECT ")
                .append("idtiempo,")
                .append("fecha,")
                .append("hora,")
                .append("fechahora ")
                .append("FROM tiempos ")
                .append("WHERE idtiempo=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps
                = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, idtiempo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    tiempos = new Tiempos();
                    //asignando los datos a un objeto
                    tiempos.setIdtiempo(rs.getInt(1));
                    tiempos.setFecha(rs.getDate(2));
                    tiempos.setHora(rs.getTime(3));
                    tiempos.setFechahora(rs.getTimestamp(4));

                } else {
                    throw new SQLException("ID: " + idtiempo + " no existe");
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }
        //devolviendo el model/tiempo contiene todos los datos de tiempo.
        return tiempos;
    }

    @Override
    public String tiemposUpd(Tiempos tiempos) {
        sql.append("UPDATE tiempos SET ")
                .append("fecha=?,")
                .append("hora=?,")
                .append("fechahora=? ")
                .append("WHERE idtiempo=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setDate(1, tiempos.getFecha());
            ps.setTime(2, tiempos.getHora());
            ps.setTimestamp(3, tiempos.getFechahora());
            ps.setInt(4, tiempos.getIdtiempo());

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


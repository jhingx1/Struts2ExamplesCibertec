package dao.impl;

import dao.DaoCursos;
import dto.Cursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import parainfo.sql.ConectaDb;

public class DaoCursosImpl implements DaoCursos {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoCursosImpl() {
        this.db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> cursosQry() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("cursos.idfrase,")
                .append("autores.autor,")
                .append("cursos.frase ")
                .append("FROM cursos ")
                .append("INNER JOIN autores ")
                .append("ON cursos.idautor=autores.idautor ")
                .append("ORDER BY autores.autor");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery()) {

            list = new LinkedList<>();
            while (rs.next()) {
                Object[] reg = new Object[3];

                reg[0] = rs.getInt(1); //listar idFrase
                reg[1] = rs.getString(2);//listart autor
                reg[2] = rs.getString(3);//listar frase.

                list.add(reg);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String cursosIns(Cursos cursos) {        
        //Solo inserta codigo
        sql.append("INSERT INTO cursos(")
                .append("idautor,")
                .append("frase")
                .append(") VALUES(?,?)");

        try (
            
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, cursos.getIdautor());
            ps.setString(2, cursos.getFrase());

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
    public String cursosDel(List<Integer> ids) {
        
        sql.append("DELETE FROM cursos WHERE idfrase=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps
                = cn.prepareStatement(sql.toString())) {

            cn.setAutoCommit(false); // desactiva autoCommit
            boolean ok = true;
            //Para la eliminacion multiple
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
    //para actualizar.
    @Override
    public Cursos cursosGet(Integer idfrase) {
        Cursos cursos = null;
        sql.append("SELECT ")
                .append("idfrase,")
                .append("idautor,")
                .append("frase ")
                .append("FROM cursos ")
                .append("WHERE idfrase=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, idfrase);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cursos = new Cursos();

                    cursos.setIdfrase(rs.getInt(1));
                    cursos.setIdautor(rs.getInt(2));
                    cursos.setFrase(rs.getString(3));

                } else {
                    throw new SQLException("ID: " 
                            + idfrase + " no existe");
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return cursos;
    }
    //Para actualizar
    @Override
    public String cursosUpd(Cursos cursos) {
        sql.append("UPDATE cursos SET ")
                .append("idautor=?,")
                .append("frase=? ")
                .append("WHERE idfrase=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, cursos.getIdautor());
            ps.setString(2, cursos.getFrase());
            ps.setInt(3, cursos.getIdfrase());

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


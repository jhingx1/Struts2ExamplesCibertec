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
                .append("c.idcursos,")
                .append("p.nombreprofesores,")
                .append("p.carrera,")
                .append("c.nombrecursos,")
                .append("c.descripcion,")
                .append("c.horaInicio,")
                .append("c.horas,")
                .append("c.fechainicio,")
                .append("c.fechafin ")
                .append("FROM cursos c ")
                .append("INNER JOIN profesores p ")
                .append("ON c.idprofesores = p.idprofesores ")
                .append("ORDER BY c.nombrecursos");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery()) {

            list = new LinkedList<>();
            while (rs.next()) {
                Object[] reg = new Object[9];

                reg[0] = rs.getInt(1); //listar idFrase
                reg[1] = rs.getString(2);//listart autor
                reg[2] = rs.getString(3);//listar cursos.
                reg[3] = rs.getString(4);
                reg[4] = rs.getString(5);
                reg[5] = rs.getTime(6);
                reg[6] = rs.getString(7);
                reg[7] = rs.getDate(8);
                reg[8] = rs.getDate(9);

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
        /*
        sql.append("INSERT INTO cursos(")
                .append("idautor,")
                .append("cursos")
                .append(") VALUES(?,?)");
        
        */
        //,,,,,,,
        sql.append("INSERT INTO cursos(")
                .append("nombrecursos,")
                .append("descripcion,")
                .append("fechainicio,")
                .append("fechafin,")
                .append("horaInicio,")
                .append("tipo,")
                .append("horas,")
                .append("idprofesores")
                .append(") values(?,?,?,?,?,?,?,?)");

        try (
            
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            
            /*
            ps.setInt(1, cursos.getIdautor());
            ps.setString(2, cursos.getFrase());
            ps.setDate(1, tiempos.getFecha());
            ps.setTime(2, tiempos.getHora());
            */
            
            ps.setString(1,cursos.getNombrecursos());
            ps.setString(2,cursos.getDescripcion());
            ps.setDate(3, cursos.getFechainicio());
            ps.setDate(4, cursos.getFechafin());
            ps.setTime(5, cursos.getHoraInicio());
            ps.setString(6, cursos.getTipo());
            ps.setInt(7, cursos.getHoras());
            ps.setInt(8, cursos.getIdprofesor());
            
            

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
        
        sql.append("DELETE FROM cursos WHERE idcursos=?");

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
    public Cursos cursosGet(Integer idcursos) {
        Cursos cursos = null;
        
        sql.append("SELECT ")
                .append("idcursos,")
                .append("nombrecursos,")
                .append("descripcion,")
                .append("fechainicio,")
                .append("fechafin,")
                .append("horaInicio,")
                .append("tipo,")
                .append("horas,")
                .append("idprofesores ")
                .append("FROM cursos ")
                .append("WHERE idcursos=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, idcursos);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cursos = new Cursos();

                    cursos.setIdcursos(rs.getInt(1));
                    cursos.setNombrecursos(rs.getString(2));
                    cursos.setDescripcion(rs.getString(3));
                    cursos.setFechainicio(rs.getDate(4));
                    cursos.setFechainicio(rs.getDate(5));
                    cursos.setHoraInicio(rs.getTime(6));
                    cursos.setTipo(rs.getString(7));
                    cursos.setHoras(rs.getInt(8));
                    cursos.setIdprofesor(rs.getInt(9));
                    
                } else {
                    throw new SQLException("ID: " 
                            + idcursos + " no existe");
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
                .append("nombrecursos=?,")
                .append("descripcion=? ")
                .append("fechainicio=? ")
                .append("fechafin=? ")
                .append("horaInicio=? ")
                .append("tipo=? ")
                .append("horas=? ")
                .append("idprofesores=? ")                
                .append("WHERE idcursos=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setString(1,cursos.getNombrecursos());
            ps.setString(2,cursos.getDescripcion());
            ps.setDate(3, cursos.getFechainicio());
            ps.setDate(4, cursos.getFechafin());
            ps.setTime(5, cursos.getHoraInicio());
            ps.setString(6, cursos.getTipo());
            ps.setInt(7, cursos.getHoras());
            ps.setInt(8, cursos.getIdprofesor());
            ps.setInt(9, cursos.getIdcursos());

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


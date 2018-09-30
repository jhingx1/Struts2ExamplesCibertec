package dao.impl;


import accesobd.ConectaDb;
import dao.DaoCursos;
import dto.Cursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


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
                .append("A.idcurso, ")
                .append("B.alumno, ")                
                .append("B.apellido, ")
                .append("B.fecnacimiento, ")
                .append("B.sexo, ")
                .append("B.telefono, ")
                .append("A.profesor, ")
                .append("A.aula, ")
                .append("A.hora, ")
                .append("A.universidad ")
                
                .append("FROM cursos A ")
                .append("INNER JOIN alumnos B ")
                .append("ON A.idalumno = b.idalumno ")
                .append("ORDER by b.alumno ");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery()) {
            list = new LinkedList<>();
            while (rs.next()) {
                Object[] reg = new Object[10];

                reg[0] = rs.getInt(1); // idcurso
                reg[1] = rs.getString(2); // alumno
                
                reg[2] = rs.getString(3); // apellido
                reg[3] = rs.getDate(4); // fecnacimiento
                reg[4] = rs.getString(5); // sexo
                reg[5] = rs.getString(6); // telefono
                
                reg[6] = rs.getString(7);// profesor
                reg[7] = rs.getString(8);// aula
                reg[8] = rs.getString(9);// hora
                reg[9] = rs.getString(10);// universidad
                

                list.add(reg);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String cursosIns(Cursos cursos) {
        sql.append("INSERT INTO cursos(")
                .append("idalumno, ")
                .append("profesor, ")
                .append("aula, ")
                .append("hora, ")                
                .append("universidad ")
                
                .append(") VALUES(?,?,?,?,?)");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, cursos.getIdalumno());
            ps.setString(2, cursos.getProfesor());
            ps.setString(3, cursos.getAula());
            ps.setString(4, cursos.getHora());
            ps.setString(5, cursos.getUniversidad());            

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
        sql.append("DELETE FROM cursos WHERE idcurso=?");

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

    @Override
    public Cursos cursosGet(Integer ids) {
        Cursos cursos = null;
        sql.append("SELECT ")
                .append("idcurso,")
                .append("idalumno,")
                .append("profesor, ")
                .append("aula, ")
                .append("hora, ")
                .append("universidad ")
                .append("FROM cursos ")
                .append("WHERE idcurso=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, ids);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cursos = new Cursos();

                    cursos.setIdcurso(rs.getInt(1));
                    cursos.setIdalumno(rs.getInt(2));
                    cursos.setProfesor(rs.getString(3));
                    cursos.setAula(rs.getString(4));
                    cursos.setHora(rs.getString(5));
                    cursos.setUniversidad(rs.getString(6));

                } else {
                    throw new SQLException("ID: " 
                            + ids + " no existe");
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return cursos;
    }

    @Override
    public String cursosUpd(Cursos cursos) {
        sql.append("UPDATE cursos SET ")
                .append("idalumno=?,")
                .append("profesor=?, ")
                .append("aula=?, ")
                .append("hora=?, ")
                .append("universidad=? ")
                
                .append("WHERE idcurso=?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = 
                        cn.prepareStatement(sql.toString())) {

            ps.setInt(1, cursos.getIdalumno());
            ps.setString(2, cursos.getProfesor());
            ps.setString(3, cursos.getAula());
            ps.setString(4, cursos.getHora());
            ps.setString(5, cursos.getUniversidad());            
            ps.setInt(6, cursos.getIdcurso());

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


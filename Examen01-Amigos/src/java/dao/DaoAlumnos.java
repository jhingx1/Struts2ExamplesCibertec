/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Alumnos;
import java.util.List;

/**
 *
 * @author caceijas
 */
public interface DaoAlumnos {
    
    public List<Alumnos> alumnosQry() ;
    
    public String alumnosIns(Alumnos alumnos) ;
    
    public String getMessage();
    
    public String alumnosDel(List<Integer> ids);

    public Alumnos alumnosGet(Integer ids);

    public String alumnosUpd(Alumnos alumnos);

    
}

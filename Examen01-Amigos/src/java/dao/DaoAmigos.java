/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Amigos;
import java.util.List;

/**
 *
 * @author caceijas
 */
public interface DaoAmigos {
    
    public List<Amigos> amigosQry() ;
    
    public String amigosIns(Amigos amigos) ;
    
    public String getMessage();
    
    public String amigosDel(List<Integer> ids);

    public Amigos amigosGet(Integer ids);

    public String amigosUpd(Amigos amigos);

    
}

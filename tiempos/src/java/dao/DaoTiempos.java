package dao;

import dto.Tiempos;
import java.util.List;

public interface DaoTiempos {

    public List<Tiempos> tiemposQry();

    public String tiemposIns(Tiempos tiempos);

    public String tiemposDel(List<Integer> ids);

    public Tiempos tiemposGet(Integer idtiempo);

    public String tiemposUpd(Tiempos tiempos);
    
    public String getMessage();
}


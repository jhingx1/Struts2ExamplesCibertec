package dao;

import dto.Tutoriales;
import java.util.List;

public interface DaoTutoriales {

    public List<Tutoriales> tutorialesQry();

    public String tutorialesIns(Tutoriales tutoriales);

    public String tutorialesDel(List<Integer> ids);

    public Tutoriales tutorialesGet(Integer idtutorial);//update

    public String tutorialesUpd(Tutoriales tutoriales);//

    public String getMessage();
}


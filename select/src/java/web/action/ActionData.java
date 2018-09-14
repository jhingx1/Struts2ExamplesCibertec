package web.action;

import com.opensymphony.xwork2.ActionSupport;
import dto.Dias;
import java.util.ArrayList;
import java.util.List;

public class ActionData extends ActionSupport {

    //Hay 3 Select
    private Integer dia01;
    private Integer dia02;
    private List<Integer> dia03;

    //data para los select
    private List<Dias> cboDias;

    public Integer getDia01() {
        return dia01;
    }

    public void setDia01(Integer dia01) {
        this.dia01 = dia01;
    }

    public List<Integer> getDia03() {
        return dia03;
    }

    public void setDia03(List<Integer> dia03) {
        this.dia03 = dia03;
    }

    public List<Dias> getCboDias() {
        cboDias = new ArrayList<>();
        cboDias.add(new Dias(0, "Domingo"));
        cboDias.add(new Dias(1, "Lunes"));
        cboDias.add(new Dias(2, "Martes"));
        cboDias.add(new Dias(3, "Miércoles"));
        cboDias.add(new Dias(4, "Jueves"));
        cboDias.add(new Dias(5, "Viernes"));
        cboDias.add(new Dias(6, "Sábado"));
        return cboDias;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}

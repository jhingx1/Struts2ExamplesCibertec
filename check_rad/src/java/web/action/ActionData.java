package web.action;

import com.opensymphony.xwork2.ActionSupport;
import dto.Dias;
import java.util.ArrayList;
import java.util.List;

public class ActionData extends ActionSupport {

    //Hay 2 Select
    private List<Integer> check;
    private Integer radio;
    
    //data para los select
    private List<Dias> cboDias;

    public List<Integer> getCheck() {
        return check;
    }

    public void setCheck(List<Integer> check) {
        this.check = check;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
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

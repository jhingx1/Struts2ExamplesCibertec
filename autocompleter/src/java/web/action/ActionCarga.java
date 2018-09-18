package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import dto.Gaseosa;
import java.util.ArrayList;
import java.util.List;

public class ActionCarga extends ActionSupport implements Preparable{
    //Para cargar la lista de gaseosas.
    private List<Gaseosa> lista;

    public ActionCarga() {
    }

    public List<Gaseosa> getLista() {
        return lista;
    }

    public void setLista(List<Gaseosa> lista) {
        this.lista = lista;
    }

    public String carga() throws Exception {
        return SUCCESS;
    }
    //Para cargar la lista de gaseosas.
    @Override
    public void prepare() throws Exception {
        lista = new ArrayList<>();
        lista.add(new Gaseosa(1, "Inca Kola"));
        lista.add(new Gaseosa(2, "Pepsi Cola"));
        lista.add(new Gaseosa(3, "Coca Cola"));
        lista.add(new Gaseosa(4, "Concordia"));
        lista.add(new Gaseosa(5, "Crush"));
        lista.add(new Gaseosa(6, "Sprite"));
    }

}

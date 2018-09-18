package dto;

public class Gaseosa {

    private Integer gaseosaId;
    private String gaseosaTexto;

    public Gaseosa() {
    }

    public Gaseosa(Integer gaseosaId, String gaseosaTexto) {
        this.gaseosaId = gaseosaId;
        this.gaseosaTexto = gaseosaTexto;
    }

    public Integer getGaseosaId() {
        return gaseosaId;
    }

    public void setGaseosaId(Integer gaseosaId) {
        this.gaseosaId = gaseosaId;
    }

    public String getGaseosaTexto() {
        return gaseosaTexto;
    }

    public void setGaseosaTexto(String gaseosaTexto) {
        this.gaseosaTexto = gaseosaTexto;
    }

}

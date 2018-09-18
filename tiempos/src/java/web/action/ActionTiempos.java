package web.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dto.Tiempos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoTiempos;
import dao.impl.DaoTiemposImpl;
import org.apache.struts2.ServletActionContext;

public class ActionTiempos extends ActionSupport {

    private Tiempos tiempos;//Se crea un dto: Tiempos.
    private String fecha;
    private String hora;
    private String fechahora;

    public ActionTiempos() {
    }

    // gettter y setter
    public Tiempos getTiempos() {
        return tiempos;
    }

    public void setTiempos(Tiempos tiempos) {
        this.tiempos = tiempos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    // gestiona CRUD, para listar los timepos
    public String tiemposQry() {
        //Enviado desde el Strus.xml
        HttpServletRequest request = ServletActionContext.getRequest();//Parametros que nos manda
        //Instanciamos un objeto de daoTiempos para listar.
        DaoTiempos daoTiempos = new DaoTiemposImpl();
        grilla(request, daoTiempos);

        return SUCCESS;
    }
    
    //Para insertar mas timepos
    public String tiemposIns() {
        HttpServletRequest request = ServletActionContext.getRequest();
        //creamos el objeto tiempo para insertar valores.
        tiempos = new Tiempos();
        //ejecutamos las validaciones.
        String error = valida(request);
        //Crea la instancia de daoTiempos.
        DaoTiempos daoTiempos = new DaoTiemposImpl();
        //verifica que no aya errores
        if (error == null) {
            //insetamos con tiemposIns, pasando parametro tiempos
            //al llamar a este metodo ya hemos insertado.
            error = daoTiempos.tiemposIns(tiempos);
        }
        //nuevamente va a la funcion grilla, para publicar los resultados
        grilla(request, daoTiempos);

        if (error == null) {
            //si paso la validacion sale exito y remueva el atributo error.
            request.getSession().removeAttribute("error");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("error", error);
            return ERROR;
        }
    }

    //Para borrar los tiempos.
    public String tiemposDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        //recibimos el ids, asi : 1,2,3
        String ids = request.getParameter("ids");//almacenado : ids
        //error
        String error = null;
        //El String ids los separamos por la coma.
        String[] id = ids.split(",");
        //Creamos una lista
        List<Integer> list_id = new ArrayList<>();
        //uso de foreach, para recorrer el array id
        for (String ix : id) {
            try {
                //convirtiendo los elementos de array de String a Integer
                Integer idtiempo = Integer.valueOf(ix);
                //y los añadimos a la lista
                list_id.add(idtiempo);

            } catch (NumberFormatException e) {
                error = "Valor errado de idproducto";
            }
        }
        //instanciamos el daoTiempos.
        DaoTiempos daoTiempos = new DaoTiemposImpl();
        if (error == null) {
            //vamos al metodo para borar y le pasamos la lista.
            error = daoTiempos.tiemposDel(list_id);
        }
        //listamos nuevamentes.
        grilla(request, daoTiempos);
        //borramos los erroes.
        //y nos vamos al xml y luego vamos hacia el jsp tiempos.
        if (error == null) {
            request.getSession().removeAttribute("error");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("error", error);
            return ERROR;
        }
    }
    //Para obtener un tiempo por su id, para luego editarlo.
    public void tiemposGet() {
        //request = solicitud         
        HttpServletRequest request = ServletActionContext.getRequest();
        // response = respuesta
        HttpServletResponse response = ServletActionContext.getResponse();
        //obteniendo el id.
        String id = request.getParameter("id");
        //instanciando el daoTiempos
        DaoTiempos daoTiempos = new DaoTiemposImpl();
        //usando el metodo : tiemposGet, se le envie el id para identificar el id.
        Tiempos t = daoTiempos.tiemposGet(Integer.valueOf(id));
        //Ahora para dar formato a la fecha.
        if (t != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //formato fecha
            String fechax = sdf.format(t.getFecha());
            //patters y hora.
            sdf.applyPattern("hh:mm:ss a");            
            String horax = sdf.format(t.getHora());
            //fecha y hora.
            sdf.applyPattern("dd/MM/yyyy hh:mm:ss a");
            String fechahorax = sdf.format(t.getFechahora());
            //contenando el idTiempo,.... se parado por "+++"
            String result = t.getIdtiempo() + "+++"
                    + fechax + "+++"
                    + horax + "+++"
                    + fechahorax;

            try {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.print(result);
                }
            } catch (IOException ex) {
            }
        }
        
        //al terminar este metodo nos vamos al ajax.
    }
    //Para actualizarlo
    //luego de obtener el formulario con los datos de tiempo.
    //lo debemos de actualizar.
    public String tiemposUpd() {
        HttpServletRequest request = ServletActionContext.getRequest();
        //validando
        String error = valida(request);
        //instanciamos daoTiempos.
        DaoTiempos daoTiempos = new DaoTiemposImpl();
        if (error == null) {
            //si no hay error actualizamos el dato.
            error = daoTiempos.tiemposUpd(tiempos);
        }
        //uso del metodo para listar.
        grilla(request, daoTiempos);

        if (error == null) {
            request.getSession().removeAttribute("error");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("error", error);
            return ERROR;
        }
        
        //al final dem 
    }

    // apoyo
    //
    private void grilla(HttpServletRequest request, DaoTiempos daoTiempos) {
        //usa el metodo timeposQry(), para hacer uso de un select.
        List<Tiempos> list = daoTiempos.tiemposQry();
        request.setAttribute("t_qry", list); //t_qry, es el nombre con que se recorre la lista de los resultados.
    }
    
    //para las validaciones de los datos de tiempo
    private String valida(HttpServletRequest request) {
        String error = null;
        String fechax = request.getParameter("fecha");
        String horax = request.getParameter("hora");
        String fechahorax = request.getParameter("fechahora");

        java.sql.Date sfecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            java.util.Date ufecha = sdf.parse(fechax);
            sfecha = new java.sql.Date(ufecha.getTime());
        } catch (ParseException ex) {
            error = "Fecha debe ser: dd/mm/yyyy";
        }

        java.sql.Time shora = null;
        if (error == null) {
            sdf = new SimpleDateFormat("hh:mm:ss a");
            sdf.setLenient(false);
            try {
                java.util.Date uhora = sdf.parse(horax);
                shora = new java.sql.Time(uhora.getTime());
            } catch (ParseException ex) {
                error = "Hora debe ser: hh:mm:ss am/pm";
            }
        }

        java.sql.Timestamp sfechahora = null;
        if (error == null) {
            sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
            sdf.setLenient(false);
            try {
                java.util.Date ufechahora = sdf.parse(fechahorax);
                sfechahora = new java.sql.Timestamp(ufechahora.getTime());
            } catch (ParseException ex) {
                error = "Fecha Hora debe ser: dd/mm/yyyy hh:mm:ss am/pm";
            }
        }

        if (error == null) {
            tiempos.setFecha(sfecha);
            tiempos.setHora(shora);
            tiempos.setFechahora(sfechahora);
        }

        return error;
    }
}
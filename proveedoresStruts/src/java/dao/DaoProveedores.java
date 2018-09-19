package dao;

import dto.Proveedores;
import java.util.List;

public interface DaoProveedores {

    public List<Proveedores> proveedoresQry();

    public String proveedoresIns(Proveedores proveedores);

    public String proveedoresDel(List<Integer> ids);

    public Proveedores proveedoresGet(Integer idproveedor);//update

    public String proveedoresUpd(Proveedores proveedores);//

    public String getMessage();
}


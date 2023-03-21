package com.ec.entidad;

import com.ec.entidad.Tipoambiente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-21T21:43:14")
@StaticMetamodel(HistorialDeclaraciones.class)
public class HistorialDeclaraciones_ { 

    public static volatile SingularAttribute<HistorialDeclaraciones, String> hisPathDeclaracion;
    public static volatile SingularAttribute<HistorialDeclaraciones, String> hisPathPago;
    public static volatile SingularAttribute<HistorialDeclaraciones, Date> hisFecha;
    public static volatile SingularAttribute<HistorialDeclaraciones, String> hisDescripcion;
    public static volatile SingularAttribute<HistorialDeclaraciones, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<HistorialDeclaraciones, Integer> idHistorial;
    public static volatile SingularAttribute<HistorialDeclaraciones, Integer> hisMes;
    public static volatile SingularAttribute<HistorialDeclaraciones, Integer> hisAnio;

}
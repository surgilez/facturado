package com.ec.entidad;

import com.ec.entidad.DetalleKardex;
import com.ec.entidad.Producto;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-22T20:13:27")
@StaticMetamodel(Kardex.class)
public class Kardex_ { 

    public static volatile SingularAttribute<Kardex, Date> karFechaKardex;
    public static volatile SingularAttribute<Kardex, Integer> idKardex;
    public static volatile SingularAttribute<Kardex, Date> karFechaIngreso;
    public static volatile CollectionAttribute<Kardex, DetalleKardex> detalleKardexCollection;
    public static volatile SingularAttribute<Kardex, String> karEstado;
    public static volatile SingularAttribute<Kardex, Producto> idProducto;
    public static volatile SingularAttribute<Kardex, String> karDetalle;
    public static volatile SingularAttribute<Kardex, Boolean> karIsActivo;
    public static volatile SingularAttribute<Kardex, Date> karFecha;
    public static volatile SingularAttribute<Kardex, BigDecimal> karTotal;

}
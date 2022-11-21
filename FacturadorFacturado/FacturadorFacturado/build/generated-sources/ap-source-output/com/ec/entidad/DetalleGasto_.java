package com.ec.entidad;

import com.ec.entidad.Gatos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:00:57")
@StaticMetamodel(DetalleGasto.class)
public class DetalleGasto_ { 

    public static volatile SingularAttribute<DetalleGasto, Gatos> idGasto;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasIva;
    public static volatile SingularAttribute<DetalleGasto, String> dgasDescripcion;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasCatidad;
    public static volatile SingularAttribute<DetalleGasto, Integer> idDetalleGasto;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasTotal;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasSubtotal;

}
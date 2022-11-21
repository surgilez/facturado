package com.ec.entidad;

import com.ec.entidad.DetalleGasto;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:00:57")
@StaticMetamodel(Gatos.class)
public class Gatos_ { 

    public static volatile SingularAttribute<Gatos, Integer> idGasto;
    public static volatile CollectionAttribute<Gatos, DetalleGasto> detalleGastoCollection;
    public static volatile SingularAttribute<Gatos, String> gasRazonSocial;
    public static volatile SingularAttribute<Gatos, BigDecimal> gasIva;
    public static volatile SingularAttribute<Gatos, BigDecimal> gasValorTotal;
    public static volatile SingularAttribute<Gatos, String> gasNumeroComprobante;
    public static volatile SingularAttribute<Gatos, Date> gasFecha;
    public static volatile SingularAttribute<Gatos, BigDecimal> gasSubtotal;

}
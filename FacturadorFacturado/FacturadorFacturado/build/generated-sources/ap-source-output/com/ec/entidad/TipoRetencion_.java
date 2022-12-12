package com.ec.entidad;

import com.ec.entidad.DetalleRetencionCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:01:37")
@StaticMetamodel(TipoRetencion.class)
public class TipoRetencion_ { 

    public static volatile SingularAttribute<TipoRetencion, String> tireCodigo;
    public static volatile CollectionAttribute<TipoRetencion, DetalleRetencionCompra> detalleRetencionCompraCollection;
    public static volatile SingularAttribute<TipoRetencion, String> tireTipo;
    public static volatile SingularAttribute<TipoRetencion, String> tireNombre;
    public static volatile SingularAttribute<TipoRetencion, Double> tirePorcentajeRetencion;

}
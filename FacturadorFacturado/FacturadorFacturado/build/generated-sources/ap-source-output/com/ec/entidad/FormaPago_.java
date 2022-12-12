package com.ec.entidad;

import com.ec.entidad.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-22T20:13:27")
@StaticMetamodel(FormaPago.class)
public class FormaPago_ { 

    public static volatile SingularAttribute<FormaPago, Integer> idFormaPago;
    public static volatile SingularAttribute<FormaPago, String> forNombre;
    public static volatile SingularAttribute<FormaPago, String> plazo;
    public static volatile SingularAttribute<FormaPago, String> unidadTiempo;
    public static volatile SingularAttribute<FormaPago, Boolean> isprincipal;
    public static volatile SingularAttribute<FormaPago, String> forCodigo;
    public static volatile CollectionAttribute<FormaPago, Factura> facturaCollection;

}
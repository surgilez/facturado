package com.ec.entidad;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-11T17:28:00")
@StaticMetamodel(Retencionporcasillero.class)
public class Retencionporcasillero_ { 

    public static volatile SingularAttribute<Retencionporcasillero, Double> valorRetenido;
    public static volatile SingularAttribute<Retencionporcasillero, String> tireCodigo;
    public static volatile SingularAttribute<Retencionporcasillero, String> tipoRetencion;
    public static volatile SingularAttribute<Retencionporcasillero, Date> cabFechaEmision;
    public static volatile SingularAttribute<Retencionporcasillero, BigInteger> numeroComprobante;
    public static volatile SingularAttribute<Retencionporcasillero, BigInteger> id;

}
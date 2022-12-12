package com.ec.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:12:10")
@StaticMetamodel(ComprasSri.class)
public class ComprasSri_ { 

    public static volatile SingularAttribute<ComprasSri, String> csriTipoEmision;
    public static volatile SingularAttribute<ComprasSri, String> csriAutorizacion;
    public static volatile SingularAttribute<ComprasSri, String> csriClaveAcceso;
    public static volatile SingularAttribute<ComprasSri, String> csriComprobante;
    public static volatile SingularAttribute<ComprasSri, BigDecimal> idCompSri;
    public static volatile SingularAttribute<ComprasSri, String> csriSerieComprobante;
    public static volatile SingularAttribute<ComprasSri, Date> csriFechaAutorizacion;
    public static volatile SingularAttribute<ComprasSri, String> csriRazonSocial;
    public static volatile SingularAttribute<ComprasSri, String> csriIdentificacionReceptor;
    public static volatile SingularAttribute<ComprasSri, String> csriRucEmisor;
    public static volatile SingularAttribute<ComprasSri, String> csriVerificado;
    public static volatile SingularAttribute<ComprasSri, String> csriTotal;
    public static volatile SingularAttribute<ComprasSri, Date> csriFechaEmision;

}
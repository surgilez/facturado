package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.DetalleRetencionCompra;
import com.ec.entidad.Tipoambiente;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-11T17:28:01")
@StaticMetamodel(RetencionCompra.class)
public class RetencionCompra_ { 

    public static volatile SingularAttribute<RetencionCompra, String> rcoPuntoEmision;
    public static volatile SingularAttribute<RetencionCompra, String> rcoSerie;
    public static volatile SingularAttribute<RetencionCompra, BigDecimal> rcoValorRetencionIva;
    public static volatile SingularAttribute<RetencionCompra, String> rcoMsmInfoSri;
    public static volatile SingularAttribute<RetencionCompra, String> drcEstadosri;
    public static volatile SingularAttribute<RetencionCompra, String> rcoDetalle;
    public static volatile CollectionAttribute<RetencionCompra, DetalleRetencionCompra> detalleRetencionCompraCollection;
    public static volatile SingularAttribute<RetencionCompra, String> rcoPathRet;
    public static volatile SingularAttribute<RetencionCompra, BigDecimal> rcoBaseGravaIva;
    public static volatile SingularAttribute<RetencionCompra, String> drcMensajesri;
    public static volatile SingularAttribute<RetencionCompra, String> rcoSecuencialText;
    public static volatile SingularAttribute<RetencionCompra, CabeceraCompra> idCabecera;
    public static volatile SingularAttribute<RetencionCompra, Integer> rcoSecuencial;
    public static volatile SingularAttribute<RetencionCompra, Integer> rcoCodigo;
    public static volatile SingularAttribute<RetencionCompra, Date> cabFechaEmision;
    public static volatile SingularAttribute<RetencionCompra, String> rcoAutorizacion;
    public static volatile SingularAttribute<RetencionCompra, Boolean> rcoIva;
    public static volatile SingularAttribute<RetencionCompra, Integer> rcoPorcentajeIva;
    public static volatile SingularAttribute<RetencionCompra, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<RetencionCompra, Date> rcoFecha;
    public static volatile SingularAttribute<RetencionCompra, Date> rcoFechaAutorizacion;

}
package com.ec.entidad;

import com.ec.entidad.RetencionCompra;
import com.ec.entidad.TipoRetencion;
import com.ec.entidad.Tipoivaretencion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:01:37")
@StaticMetamodel(DetalleRetencionCompra.class)
public class DetalleRetencionCompra_ { 

    public static volatile SingularAttribute<DetalleRetencionCompra, BigDecimal> drcPorcentaje;
    public static volatile SingularAttribute<DetalleRetencionCompra, Tipoivaretencion> idTipoivaretencion;
    public static volatile SingularAttribute<DetalleRetencionCompra, Integer> drcCodigo;
    public static volatile SingularAttribute<DetalleRetencionCompra, TipoRetencion> tireCodigo;
    public static volatile SingularAttribute<DetalleRetencionCompra, RetencionCompra> rcoCodigo;
    public static volatile SingularAttribute<DetalleRetencionCompra, BigDecimal> drcValorRetenido;
    public static volatile SingularAttribute<DetalleRetencionCompra, String> drcTipoRegistro;
    public static volatile SingularAttribute<DetalleRetencionCompra, BigDecimal> drcBaseImponible;
    public static volatile SingularAttribute<DetalleRetencionCompra, String> drcDescripcion;
    public static volatile SingularAttribute<DetalleRetencionCompra, String> drcCodImpuestoAsignado;

}
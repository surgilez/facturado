package com.ec.entidad.sri;

import com.ec.entidad.Producto;
import com.ec.entidad.sri.CabeceraCompraSri;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-22T20:13:27")
@StaticMetamodel(DetalleCompraSri.class)
public class DetalleCompraSri_ { 

    public static volatile SingularAttribute<DetalleCompraSri, String> iprodCodigoProvee;
    public static volatile SingularAttribute<DetalleCompraSri, BigDecimal> iprodTotal;
    public static volatile SingularAttribute<DetalleCompraSri, BigDecimal> iprodCantidad;
    public static volatile SingularAttribute<DetalleCompraSri, Integer> idIngresoProdSri;
    public static volatile SingularAttribute<DetalleCompraSri, BigDecimal> iprodSubtotal;
    public static volatile SingularAttribute<DetalleCompraSri, Producto> idProducto;
    public static volatile SingularAttribute<DetalleCompraSri, CabeceraCompraSri> idCabeceraSri;
    public static volatile SingularAttribute<DetalleCompraSri, String> iprodDescripcion;

}
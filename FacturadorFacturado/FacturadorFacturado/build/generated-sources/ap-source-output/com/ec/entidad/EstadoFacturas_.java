package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.Factura;
import com.ec.entidad.OrdenTrabajo;
import com.ec.entidad.sri.CabeceraCompraSri;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:01:37")
@StaticMetamodel(EstadoFacturas.class)
public class EstadoFacturas_ { 

    public static volatile CollectionAttribute<EstadoFacturas, CabeceraCompra> cabeceraCompraCollection;
    public static volatile SingularAttribute<EstadoFacturas, Integer> idEstado;
    public static volatile CollectionAttribute<EstadoFacturas, OrdenTrabajo> ordenTrabajoCollection;
    public static volatile SingularAttribute<EstadoFacturas, String> estCodigo;
    public static volatile CollectionAttribute<EstadoFacturas, CabeceraCompraSri> cabeceraCompraSriCollection;
    public static volatile SingularAttribute<EstadoFacturas, String> estNombre;
    public static volatile SingularAttribute<EstadoFacturas, Boolean> isprincipal;
    public static volatile CollectionAttribute<EstadoFacturas, Factura> facturaCollection;

}
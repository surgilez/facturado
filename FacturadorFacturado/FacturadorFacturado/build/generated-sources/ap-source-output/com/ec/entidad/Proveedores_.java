package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.ProductoProveedor;
import com.ec.entidad.TipoIdentificacionCompra;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.sri.CabeceraCompraSri;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:01:37")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile CollectionAttribute<Proveedores, CabeceraCompra> cabeceraCompraCollection;
    public static volatile SingularAttribute<Proveedores, String> provNumeroCuenta;
    public static volatile SingularAttribute<Proveedores, TipoIdentificacionCompra> idTipoIdentificacionCompra;
    public static volatile SingularAttribute<Proveedores, String> provBanco;
    public static volatile SingularAttribute<Proveedores, String> provTelefono;
    public static volatile SingularAttribute<Proveedores, String> provPagina;
    public static volatile SingularAttribute<Proveedores, String> provTipoCuenta;
    public static volatile CollectionAttribute<Proveedores, CabeceraCompraSri> cabeceraCompraSriCollection;
    public static volatile SingularAttribute<Proveedores, Integer> idProveedor;
    public static volatile SingularAttribute<Proveedores, String> provNombre;
    public static volatile SingularAttribute<Proveedores, String> provMovil;
    public static volatile SingularAttribute<Proveedores, String> provNomComercial;
    public static volatile SingularAttribute<Proveedores, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<Proveedores, String> provDireccion;
    public static volatile CollectionAttribute<Proveedores, ProductoProveedor> productoProveedorCollection;
    public static volatile SingularAttribute<Proveedores, String> provCorreo;
    public static volatile SingularAttribute<Proveedores, String> provCedula;

}
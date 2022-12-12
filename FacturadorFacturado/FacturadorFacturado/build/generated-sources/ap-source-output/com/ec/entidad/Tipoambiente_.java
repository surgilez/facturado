package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.Cliente;
import com.ec.entidad.Factura;
import com.ec.entidad.HistorialDeclaraciones;
import com.ec.entidad.Producto;
import com.ec.entidad.Proveedores;
import com.ec.entidad.Transportista;
import com.ec.entidad.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-22T20:13:27")
@StaticMetamodel(Tipoambiente.class)
public class Tipoambiente_ { 

    public static volatile SingularAttribute<Tipoambiente, String> amDescripcion;
    public static volatile SingularAttribute<Tipoambiente, String> amGenerados;
    public static volatile SingularAttribute<Tipoambiente, Integer> amSecFactura;
    public static volatile SingularAttribute<Tipoambiente, BigDecimal> amValorIce;
    public static volatile SingularAttribute<Tipoambiente, String> amCiudad;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amGrabaIce;
    public static volatile SingularAttribute<Tipoambiente, String> am_DirImgPuntoVenta;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amEstado;
    public static volatile SingularAttribute<Tipoambiente, String> amNombreComercial;
    public static volatile CollectionAttribute<Tipoambiente, Transportista> transportistaCollection;
    public static volatile SingularAttribute<Tipoambiente, String> amDireccionSucursal;
    public static volatile SingularAttribute<Tipoambiente, String> amCodigoIce;
    public static volatile CollectionAttribute<Tipoambiente, Proveedores> proveedorCollection;
    public static volatile SingularAttribute<Tipoambiente, String> amCodigo;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amGeneral;
    public static volatile SingularAttribute<Tipoambiente, String> amUsuarioSmpt;
    public static volatile SingularAttribute<Tipoambiente, String> amAutorizados;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amContrEsp;
    public static volatile SingularAttribute<Tipoambiente, String> amComprobanteImprime;
    public static volatile SingularAttribute<Tipoambiente, String> amFolderFirma;
    public static volatile SingularAttribute<Tipoambiente, String> amPtoemi;
    public static volatile SingularAttribute<Tipoambiente, String> amUsuariosri;
    public static volatile SingularAttribute<Tipoambiente, String> llevarContabilidad;
    public static volatile SingularAttribute<Tipoambiente, String> amProtocol;
    public static volatile SingularAttribute<Tipoambiente, String> amUrlsri;
    public static volatile SingularAttribute<Tipoambiente, String> amClaveAccesoSri;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amMicroEmp;
    public static volatile SingularAttribute<Tipoambiente, Integer> codTipoambiente;
    public static volatile CollectionAttribute<Tipoambiente, Producto> productoCollection;
    public static volatile SingularAttribute<Tipoambiente, String> amPassword;
    public static volatile SingularAttribute<Tipoambiente, String> amRuc;
    public static volatile SingularAttribute<Tipoambiente, String> amEnviocliente;
    public static volatile SingularAttribute<Tipoambiente, String> amDirAts;
    public static volatile SingularAttribute<Tipoambiente, String> amDirReportes;
    public static volatile SingularAttribute<Tipoambiente, String> amTipoEmision;
    public static volatile SingularAttribute<Tipoambiente, Usuario> idUsuario;
    public static volatile SingularAttribute<Tipoambiente, String> amDirXml;
    public static volatile SingularAttribute<Tipoambiente, String> amUnidadDisco;
    public static volatile SingularAttribute<Tipoambiente, BigDecimal> amValorIva;
    public static volatile SingularAttribute<Tipoambiente, Integer> amSecGuia;
    public static volatile CollectionAttribute<Tipoambiente, HistorialDeclaraciones> historialDeclaracionesCollection;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amRimpe;
    public static volatile CollectionAttribute<Tipoambiente, Factura> facturaCollection;
    public static volatile SingularAttribute<Tipoambiente, String> amDireccionMatriz;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amExp;
    public static volatile SingularAttribute<Tipoambiente, String> amHost;
    public static volatile CollectionAttribute<Tipoambiente, CabeceraCompra> cabeceraCompraCollection;
    public static volatile SingularAttribute<Tipoambiente, String> amPort;
    public static volatile SingularAttribute<Tipoambiente, Integer> amSecNotaCredito;
    public static volatile SingularAttribute<Tipoambiente, String> amEstab;
    public static volatile SingularAttribute<Tipoambiente, String> amDirBaseArchivos;
    public static volatile SingularAttribute<Tipoambiente, String> amDirFirma;
    public static volatile SingularAttribute<Tipoambiente, String> amNoAutorizados;
    public static volatile SingularAttribute<Tipoambiente, Boolean> amAgeRet;
    public static volatile SingularAttribute<Tipoambiente, Integer> amIdEmpresa;
    public static volatile SingularAttribute<Tipoambiente, Integer> amSecRetencion;
    public static volatile SingularAttribute<Tipoambiente, String> amNroContribuyente;
    public static volatile SingularAttribute<Tipoambiente, String> amTelefono;
    public static volatile SingularAttribute<Tipoambiente, String> amFirmados;
    public static volatile SingularAttribute<Tipoambiente, String> amDevueltos;
    public static volatile SingularAttribute<Tipoambiente, String> amRazonSocial;
    public static volatile SingularAttribute<Tipoambiente, String> amTrasmitidos;
    public static volatile CollectionAttribute<Tipoambiente, Cliente> clienteCollection;

}
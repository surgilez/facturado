package com.ec.entidad;

import com.ec.entidad.Cliente;
import com.ec.entidad.DetalleFactura;
import com.ec.entidad.DetalleKardex;
import com.ec.entidad.DetallePago;
import com.ec.entidad.EstadoFacturas;
import com.ec.entidad.FormaPago;
import com.ec.entidad.Guiaremision;
import com.ec.entidad.NotaCreditoDebito;
import com.ec.entidad.Referencia;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-21T21:43:14")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> facTipo;
    public static volatile CollectionAttribute<Factura, NotaCreditoDebito> notaCreditoDebitoCollection;
    public static volatile CollectionAttribute<Factura, DetalleKardex> detalleKardexCollection;
    public static volatile SingularAttribute<Factura, Date> facFechaAutorizacion;
    public static volatile SingularAttribute<Factura, Integer> facNumNotaVenta;
    public static volatile SingularAttribute<Factura, String> facNumeroText;
    public static volatile SingularAttribute<Factura, String> facMadre;
    public static volatile SingularAttribute<Factura, BigDecimal> facDescuento;
    public static volatile SingularAttribute<Factura, Integer> facNumero;
    public static volatile CollectionAttribute<Factura, DetallePago> detallePagoCollection;
    public static volatile SingularAttribute<Factura, Date> facFechaCobroPlazo;
    public static volatile SingularAttribute<Factura, BigDecimal> facSaldoAmortizado;
    public static volatile SingularAttribute<Factura, Tipoambiente> cod_tipoambiente;
    public static volatile SingularAttribute<Factura, String> facTipoIdentificadorComprobador;
    public static volatile SingularAttribute<Factura, String> faConSinGuia;
    public static volatile SingularAttribute<Factura, BigDecimal> facAbono;
    public static volatile SingularAttribute<Factura, String> codestablecimiento;
    public static volatile SingularAttribute<Factura, FormaPago> idFormaPago;
    public static volatile SingularAttribute<Factura, BigDecimal> facTotal;
    public static volatile SingularAttribute<Factura, String> facCodIce;
    public static volatile SingularAttribute<Factura, BigDecimal> facValorIce;
    public static volatile SingularAttribute<Factura, String> facMsmInfoSri;
    public static volatile SingularAttribute<Factura, Integer> facNumNotaEntrega;
    public static volatile SingularAttribute<Factura, String> facDestino;
    public static volatile SingularAttribute<Factura, Date> facFechaSustento;
    public static volatile SingularAttribute<Factura, Integer> facNumProforma;
    public static volatile SingularAttribute<Factura, String> facPorcentajeIva;
    public static volatile SingularAttribute<Factura, Date> facFecha;
    public static volatile SingularAttribute<Factura, BigDecimal> facSubsidio;
    public static volatile SingularAttribute<Factura, BigDecimal> facIva;
    public static volatile SingularAttribute<Factura, String> facpath;
    public static volatile SingularAttribute<Factura, Usuario> idUsuario;
    public static volatile SingularAttribute<Factura, String> facDescripcion;
    public static volatile SingularAttribute<Factura, BigDecimal> facPlazo;
    public static volatile SingularAttribute<Factura, Date> facFechaCobro;
    public static volatile SingularAttribute<Factura, String> facNotaEntregaProcess;
    public static volatile SingularAttribute<Factura, String> facClaveAutorizacion;
    public static volatile CollectionAttribute<Factura, DetalleFactura> detalleFacturaCollection;
    public static volatile SingularAttribute<Factura, BigDecimal> facValorSinSubsidio;
    public static volatile SingularAttribute<Factura, Cliente> idCliente;
    public static volatile SingularAttribute<Factura, String> mensajesri;
    public static volatile SingularAttribute<Factura, String> facObservacion;
    public static volatile SingularAttribute<Factura, BigDecimal> facTotalBaseCero;
    public static volatile SingularAttribute<Factura, BigDecimal> facSubtotal;
    public static volatile SingularAttribute<Factura, String> facCodIva;
    public static volatile SingularAttribute<Factura, String> tipodocumento;
    public static volatile SingularAttribute<Factura, String> codigoPorcentaje;
    public static volatile SingularAttribute<Factura, BigDecimal> facSaldo;
    public static volatile CollectionAttribute<Factura, Guiaremision> guiaremisionCollection;
    public static volatile SingularAttribute<Factura, String> facEstado;
    public static volatile SingularAttribute<Factura, String> facMoneda;
    public static volatile SingularAttribute<Factura, String> estadosri;
    public static volatile SingularAttribute<Factura, EstadoFacturas> idEstado;
    public static volatile SingularAttribute<Factura, BigDecimal> facTotalBaseGravaba;
    public static volatile SingularAttribute<Factura, String> tipoDocumentoMod;
    public static volatile SingularAttribute<Factura, String> puntoemision;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile SingularAttribute<Factura, String> facClaveAcceso;
    public static volatile SingularAttribute<Factura, String> facUnidadTiempo;
    public static volatile SingularAttribute<Factura, String> facHija;
    public static volatile SingularAttribute<Factura, BigDecimal> facBaseIce;
    public static volatile SingularAttribute<Factura, Referencia> idReferencia;

}
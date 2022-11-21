package com.ec.entidad;

import com.ec.entidad.Cliente;
import com.ec.entidad.DetalleGuiaremision;
import com.ec.entidad.Factura;
import com.ec.entidad.Transportista;
import com.ec.entidad.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:00:57")
@StaticMetamodel(Guiaremision.class)
public class Guiaremision_ { 

    public static volatile SingularAttribute<Guiaremision, String> facTipo;
    public static volatile SingularAttribute<Guiaremision, String> numplacaguia;
    public static volatile SingularAttribute<Guiaremision, String> tipoGuia;
    public static volatile SingularAttribute<Guiaremision, Date> facFechaAutorizacion;
    public static volatile SingularAttribute<Guiaremision, String> facNumeroText;
    public static volatile SingularAttribute<Guiaremision, Integer> idGuiaremision;
    public static volatile SingularAttribute<Guiaremision, Date> fechafintranspguia;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facDescuento;
    public static volatile SingularAttribute<Guiaremision, String> facPath;
    public static volatile SingularAttribute<Guiaremision, String> llegada;
    public static volatile SingularAttribute<Guiaremision, Integer> facNumero;
    public static volatile SingularAttribute<Guiaremision, String> facTipoIdentificadorComprobador;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facAbono;
    public static volatile SingularAttribute<Guiaremision, String> codestablecimiento;
    public static volatile SingularAttribute<Guiaremision, Integer> idFormaPago;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facTotal;
    public static volatile SingularAttribute<Guiaremision, String> facCodIce;
    public static volatile SingularAttribute<Guiaremision, String> tipodocumentomod;
    public static volatile SingularAttribute<Guiaremision, Date> facFechaSustento;
    public static volatile SingularAttribute<Guiaremision, String> motivoGuia;
    public static volatile SingularAttribute<Guiaremision, Integer> facNumProforma;
    public static volatile SingularAttribute<Guiaremision, String> facPorcentajeIva;
    public static volatile SingularAttribute<Guiaremision, Date> facFecha;
    public static volatile SingularAttribute<Guiaremision, Integer> codTipoambiente;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facIva;
    public static volatile SingularAttribute<Guiaremision, String> facNumeroTextRecibida;
    public static volatile SingularAttribute<Guiaremision, Transportista> idTransportista;
    public static volatile SingularAttribute<Guiaremision, Usuario> idUsuario;
    public static volatile SingularAttribute<Guiaremision, String> facDescripcion;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facPlazo;
    public static volatile CollectionAttribute<Guiaremision, DetalleGuiaremision> detalleGuiaremisionCollection;
    public static volatile SingularAttribute<Guiaremision, String> facClaveAutorizacion;
    public static volatile SingularAttribute<Guiaremision, Cliente> idCliente;
    public static volatile SingularAttribute<Guiaremision, String> mensajesri;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facTotalBaseCero;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facSubtotal;
    public static volatile SingularAttribute<Guiaremision, String> facCodIva;
    public static volatile SingularAttribute<Guiaremision, String> tipodocumento;
    public static volatile SingularAttribute<Guiaremision, String> codigoPorcentaje;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facSaldo;
    public static volatile SingularAttribute<Guiaremision, String> facEstado;
    public static volatile SingularAttribute<Guiaremision, Date> fechainitranspguia;
    public static volatile SingularAttribute<Guiaremision, String> facMoneda;
    public static volatile SingularAttribute<Guiaremision, String> Documentoaduanerounico;
    public static volatile SingularAttribute<Guiaremision, String> partida;
    public static volatile SingularAttribute<Guiaremision, String> estadosri;
    public static volatile SingularAttribute<Guiaremision, BigDecimal> facTotalBaseGravaba;
    public static volatile SingularAttribute<Guiaremision, String> puntoemision;
    public static volatile SingularAttribute<Guiaremision, String> facUnidadTiempo;
    public static volatile SingularAttribute<Guiaremision, String> facClaveAcceso;
    public static volatile SingularAttribute<Guiaremision, Factura> idFactura;
    public static volatile SingularAttribute<Guiaremision, String> numeroGuiaRecibida;

}
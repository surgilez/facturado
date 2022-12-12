package com.ec.entidad;

import com.ec.entidad.Factura;
import com.ec.entidad.Guiaremision;
import com.ec.entidad.OrdenTrabajo;
import com.ec.entidad.Tipoadentificacion;
import com.ec.entidad.Tipoambiente;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-22T20:13:27")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> cliRazonSocial;
    public static volatile SingularAttribute<Cliente, String> cliApellidos;
    public static volatile CollectionAttribute<Cliente, OrdenTrabajo> ordenTrabajoCollection;
    public static volatile SingularAttribute<Cliente, String> cliClave;
    public static volatile SingularAttribute<Cliente, String> cliNombre;
    public static volatile SingularAttribute<Cliente, String> cliMovil;
    public static volatile SingularAttribute<Cliente, Date> clieFechaRegistro;
    public static volatile CollectionAttribute<Cliente, Guiaremision> guiaremisionCollection;
    public static volatile SingularAttribute<Cliente, Tipoadentificacion> idTipoIdentificacion;
    public static volatile SingularAttribute<Cliente, String> cliDireccion;
    public static volatile SingularAttribute<Cliente, BigDecimal> cliMontoAsignado;
    public static volatile CollectionAttribute<Cliente, Factura> facturaCollection;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, String> cliTelefono;
    public static volatile SingularAttribute<Cliente, String> cliNombres;
    public static volatile SingularAttribute<Cliente, String> ciudad;
    public static volatile SingularAttribute<Cliente, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<Cliente, String> cliCorreo;
    public static volatile SingularAttribute<Cliente, Integer> clietipo;
    public static volatile SingularAttribute<Cliente, String> cliCedula;

}
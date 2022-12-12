package com.ec.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-22T20:13:27")
@StaticMetamodel(VistaFacturasPorCobrar.class)
public class VistaFacturasPorCobrar_ { 

    public static volatile SingularAttribute<VistaFacturasPorCobrar, String> cliNombres;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, Integer> idUsuario;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, Integer> dias;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, Date> facFecha;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, Integer> codTipoambiente;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, Long> id;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, BigDecimal> facSaldoAmortizado;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, String> facNumeroText;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, String> cliCedula;
    public static volatile SingularAttribute<VistaFacturasPorCobrar, BigDecimal> fac_total;

}
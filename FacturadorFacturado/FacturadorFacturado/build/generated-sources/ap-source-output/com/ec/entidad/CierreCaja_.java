package com.ec.entidad;

import com.ec.entidad.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:12:11")
@StaticMetamodel(CierreCaja.class)
public class CierreCaja_ { 

    public static volatile SingularAttribute<CierreCaja, BigDecimal> cieValor;
    public static volatile SingularAttribute<CierreCaja, BigDecimal> cieCredito;
    public static volatile SingularAttribute<CierreCaja, BigDecimal> cirRecaudado;
    public static volatile SingularAttribute<CierreCaja, BigDecimal> cieNotaVenta;
    public static volatile SingularAttribute<CierreCaja, Usuario> idUsuario;
    public static volatile SingularAttribute<CierreCaja, BigDecimal> cieDiferencia;
    public static volatile SingularAttribute<CierreCaja, BigDecimal> cieValorInicio;
    public static volatile SingularAttribute<CierreCaja, String> cieEstado;
    public static volatile SingularAttribute<CierreCaja, BigDecimal> cieTotal;
    public static volatile SingularAttribute<CierreCaja, Integer> idCierre;
    public static volatile SingularAttribute<CierreCaja, Boolean> cieCerrada;
    public static volatile SingularAttribute<CierreCaja, Date> cieFecha;
    public static volatile SingularAttribute<CierreCaja, BigDecimal> cieCuadre;
    public static volatile SingularAttribute<CierreCaja, String> cieDescripcion;

}
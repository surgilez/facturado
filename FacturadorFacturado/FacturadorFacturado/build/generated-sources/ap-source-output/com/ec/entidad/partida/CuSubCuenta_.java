package com.ec.entidad.partida;

import com.ec.entidad.partida.CuCuenta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-13T14:57:23")
@StaticMetamodel(CuSubCuenta.class)
public class CuSubCuenta_ { 

    public static volatile SingularAttribute<CuSubCuenta, String> subcNumero;
    public static volatile SingularAttribute<CuSubCuenta, Integer> idSubCuenta;
    public static volatile SingularAttribute<CuSubCuenta, String> subcNombre;
    public static volatile SingularAttribute<CuSubCuenta, BigDecimal> subcOtro;
    public static volatile SingularAttribute<CuSubCuenta, BigDecimal> subcTotal;
    public static volatile SingularAttribute<CuSubCuenta, CuCuenta> idCuenta;
    public static volatile SingularAttribute<CuSubCuenta, BigDecimal> subcSaldo;

}
package com.ec.entidad.partida;

import com.ec.entidad.partida.CuGrupo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T15:42:09")
@StaticMetamodel(CuClase.class)
public class CuClase_ { 

    public static volatile SingularAttribute<CuClase, BigDecimal> clasSaldo;
    public static volatile SingularAttribute<CuClase, String> clasNumero;
    public static volatile SingularAttribute<CuClase, BigDecimal> clasOtro;
    public static volatile SingularAttribute<CuClase, String> clasNombre;
    public static volatile SingularAttribute<CuClase, CuGrupo> cuGrupo;
    public static volatile SingularAttribute<CuClase, Integer> idClase;
    public static volatile SingularAttribute<CuClase, BigDecimal> clasTotal;

}
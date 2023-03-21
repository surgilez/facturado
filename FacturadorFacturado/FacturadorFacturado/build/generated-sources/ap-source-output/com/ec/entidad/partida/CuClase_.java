package com.ec.entidad.partida;

import com.ec.entidad.partida.CuGrupo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-21T21:43:14")
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
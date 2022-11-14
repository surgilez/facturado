package com.ec.entidad;

import com.ec.entidad.Canton;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-11T17:28:01")
@StaticMetamodel(Provincia.class)
public class Provincia_ { 

    public static volatile SingularAttribute<Provincia, Integer> idProvincia;
    public static volatile SingularAttribute<Provincia, String> provNombre;
    public static volatile SingularAttribute<Provincia, Boolean> provEstado;
    public static volatile CollectionAttribute<Provincia, Canton> cantonCollection;
    public static volatile SingularAttribute<Provincia, Integer> provNumero;

}
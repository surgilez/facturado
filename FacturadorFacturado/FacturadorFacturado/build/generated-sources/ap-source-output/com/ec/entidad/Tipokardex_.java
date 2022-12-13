package com.ec.entidad;

import com.ec.entidad.DetalleKardex;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-13T14:57:23")
@StaticMetamodel(Tipokardex.class)
public class Tipokardex_ { 

    public static volatile SingularAttribute<Tipokardex, Boolean> tidEstado;
    public static volatile SingularAttribute<Tipokardex, String> tipkDescripcion;
    public static volatile SingularAttribute<Tipokardex, String> tipkSigla;
    public static volatile CollectionAttribute<Tipokardex, DetalleKardex> detalleKardexCollection;
    public static volatile SingularAttribute<Tipokardex, Integer> idTipokardex;

}
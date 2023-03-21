package com.ec.entidad;

import com.ec.entidad.Parroquia;
import com.ec.entidad.Provincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-21T21:43:14")
@StaticMetamodel(Canton.class)
public class Canton_ { 

    public static volatile SingularAttribute<Canton, Provincia> idProvincia;
    public static volatile SingularAttribute<Canton, Integer> cantNumero;
    public static volatile SingularAttribute<Canton, Integer> idCanton;
    public static volatile SingularAttribute<Canton, Boolean> cantEstado;
    public static volatile CollectionAttribute<Canton, Parroquia> parroquiaCollection;
    public static volatile SingularAttribute<Canton, String> cantNombre;

}
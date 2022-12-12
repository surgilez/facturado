package com.ec.entidad;

import com.ec.entidad.Proveedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:01:37")
@StaticMetamodel(TipoIdentificacionCompra.class)
public class TipoIdentificacionCompra_ { 

    public static volatile SingularAttribute<TipoIdentificacionCompra, String> ticCodigo;
    public static volatile CollectionAttribute<TipoIdentificacionCompra, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<TipoIdentificacionCompra, Integer> idTipoIdentificacionCompra;
    public static volatile SingularAttribute<TipoIdentificacionCompra, String> ticNombre;

}
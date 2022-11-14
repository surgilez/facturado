/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import com.ec.untilitario.ModeloMeses;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "historial_declaraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialDeclaraciones.findAll", query = "SELECT h FROM HistorialDeclaraciones h")
    , @NamedQuery(name = "HistorialDeclaraciones.findByIdHistorial", query = "SELECT h FROM HistorialDeclaraciones h WHERE h.idHistorial = :idHistorial")
    , @NamedQuery(name = "HistorialDeclaraciones.findByHisPathDeclaracion", query = "SELECT h FROM HistorialDeclaraciones h WHERE h.hisPathDeclaracion = :hisPathDeclaracion")
    , @NamedQuery(name = "HistorialDeclaraciones.findByHisPathPago", query = "SELECT h FROM HistorialDeclaraciones h WHERE h.hisPathPago = :hisPathPago")
    , @NamedQuery(name = "HistorialDeclaraciones.findByHisDescripcion", query = "SELECT h FROM HistorialDeclaraciones h WHERE h.hisDescripcion = :hisDescripcion")})
public class HistorialDeclaraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial")
    private Integer idHistorial;
    @Column(name = "his_path_declaracion")
    private String hisPathDeclaracion;
    @Column(name = "his_path_pago")
    private String hisPathPago;
    @Column(name = "his_descripcion")
    private String hisDescripcion;
    @JoinColumn(name = "cod_tipoambiente", referencedColumnName = "cod_tipoambiente")
    @ManyToOne
    private Tipoambiente codTipoambiente;

    @Column(name = "his_fecha")
    @Temporal(TemporalType.DATE)
    private Date hisFecha;
    @Column(name = "his_mes")
    private Integer hisMes;
    @Column(name = "his_anio")
    private Integer hisAnio;
    @Transient
    private static List<ModeloMeses> listaMeses;
    @Transient
    private ModeloMeses mesActual;

    public HistorialDeclaraciones() {
    }

    static {
        listaMeses = new ArrayList<ModeloMeses>();
        listaMeses.add(new ModeloMeses(1, "ENERO"));
        listaMeses.add(new ModeloMeses(2, "FEBRERO"));
        listaMeses.add(new ModeloMeses(3, "MARZO"));
        listaMeses.add(new ModeloMeses(4, "ABRIL"));
        listaMeses.add(new ModeloMeses(5, "MAYO"));
        listaMeses.add(new ModeloMeses(6, "JUNIO"));
        listaMeses.add(new ModeloMeses(7, "JULIO"));
        listaMeses.add(new ModeloMeses(8, "AGOSTO"));
        listaMeses.add(new ModeloMeses(9, "SEPTIEMBRE"));
        listaMeses.add(new ModeloMeses(10, "OCTUBRE"));
        listaMeses.add(new ModeloMeses(11, "NOVIEMBRE"));
        listaMeses.add(new ModeloMeses(12, "DICIEMBRE"));

    }

    public HistorialDeclaraciones(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getHisPathDeclaracion() {
        return hisPathDeclaracion;
    }

    public void setHisPathDeclaracion(String hisPathDeclaracion) {
        this.hisPathDeclaracion = hisPathDeclaracion;
    }

    public String getHisPathPago() {
        return hisPathPago;
    }

    public void setHisPathPago(String hisPathPago) {
        this.hisPathPago = hisPathPago;
    }

    public String getHisDescripcion() {
        return hisDescripcion;
    }

    public void setHisDescripcion(String hisDescripcion) {
        this.hisDescripcion = hisDescripcion;
    }

    public Tipoambiente getCodTipoambiente() {
        return codTipoambiente;
    }

    public void setCodTipoambiente(Tipoambiente codTipoambiente) {
        this.codTipoambiente = codTipoambiente;
    }

    public Date getHisFecha() {
        return hisFecha;
    }

    public void setHisFecha(Date hisFecha) {
        this.hisFecha = hisFecha;
    }

    public Integer getHisMes() {
        return hisMes;
    }

    public void setHisMes(Integer hisMes) {
        this.hisMes = hisMes;
    }

    public Integer getHisAnio() {
        return hisAnio;
    }

    public void setHisAnio(Integer hisAnio) {
        this.hisAnio = hisAnio;
    }

    public ModeloMeses getMesActual() {
        Integer numeroMes = new Date().getMonth() + 1;
        for (ModeloMeses listaMese : listaMeses) {
            if (listaMese.getNumero() == hisMes) {
                mesActual = listaMese;
                return mesActual;
            }
        }
        return mesActual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialDeclaraciones)) {
            return false;
        }
        HistorialDeclaraciones other = (HistorialDeclaraciones) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.HistorialDeclaraciones[ idHistorial=" + idHistorial + " ]";
    }

}

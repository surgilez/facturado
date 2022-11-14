/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Tipoambiente;
import com.ec.untilitario.ResultadoCompraVenta;
import com.ec.untilitario.SumaTotales;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioGeneral {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public ResultadoCompraVenta totalesCompraVenta(Date inicio, Date fin, Tipoambiente tipoambiente) {

        ResultadoCompraVenta compraVenta = new ResultadoCompraVenta(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ZERO);

        try {
            System.out.println("Entra a consultar usuarios");
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT new com.ec.untilitario.SumaTotales(SUM(f.facSubtotal),SUM(f.facTotal))FROM Factura f WHERE f.facFecha BETWEEN :inicio AND :fin AND f.facNumero > 0 AND f.facTipo='FACT' AND f.estadosri<>'ANULADA' AND f.cod_tipoambiente=:tipoambiente ");
            query.setParameter("inicio", inicio);
            query.setParameter("fin", fin);
            query.setParameter("tipoambiente", tipoambiente);
            List<SumaTotales> lstVentas = query.getResultList();
            Query queryCompras = em.createQuery("SELECT new com.ec.untilitario.SumaTotales(SUM(c.cabSubTotal),SUM(c.cabTotal))FROM CabeceraCompra c WHERE c.cabFechaEmision BETWEEN :inicio AND :fin AND c.codTipoambiente=:tipoambiente");
            queryCompras.setParameter("inicio", inicio);
            queryCompras.setParameter("fin", fin);
            queryCompras.setParameter("tipoambiente", tipoambiente);


            List<SumaTotales> lstCompras = queryCompras.getResultList();

            for (SumaTotales lstVenta : lstVentas) {
                compraVenta.setSumaSubtotalVenta(lstVenta.getSumaSubtotal());
                compraVenta.setSumaTotalVenta(lstVenta.getSumaTotal());
            }

            for (SumaTotales lstCompra : lstCompras) {
                compraVenta.setSumaSubtotalCompra(lstCompra.getSumaSubtotal());
                compraVenta.setSumaTotalCompra(lstCompra.getSumaTotal());
            }

            compraVenta.setUtilidadSubtotal(compraVenta.getSumaSubtotalVenta().subtract(compraVenta.getSumaSubtotalCompra()));
            compraVenta.setUtilidadTotal(compraVenta.getSumaTotalVenta().subtract(compraVenta.getSumaTotalCompra()));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta totalesCompraVenta " + e.getMessage());
        } finally {
            em.close();
        }

        return compraVenta;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.HistorialDeclaraciones;
import com.ec.entidad.Tipoambiente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioHistorialDeclaraciones {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(HistorialDeclaraciones historialDeclaraciones) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(historialDeclaraciones);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar historialDeclaraciones " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void eliminar(HistorialDeclaraciones historialDeclaraciones) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(historialDeclaraciones));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error en eliminar historialDeclaraciones " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void modificar(HistorialDeclaraciones historialDeclaraciones) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(historialDeclaraciones);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en modificar historialDeclaraciones " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public List<HistorialDeclaraciones> findByTipoAmbiente(Tipoambiente codTipoambiente) {

        List<HistorialDeclaraciones> listaHistorialDeclaracioness = new ArrayList<HistorialDeclaraciones>();
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM HistorialDeclaraciones a WHERE a.codTipoambiente=:codTipoambiente ORDER BY a.hisAnio,a.hisMes");
            query.setParameter("codTipoambiente", codTipoambiente);
            listaHistorialDeclaracioness = (List<HistorialDeclaraciones>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta codTipoambiente " + e.getMessage());
        } finally {
            em.close();
        }

        return listaHistorialDeclaracioness;
    }

    

}

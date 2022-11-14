/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Proveedores;
import com.ec.entidad.Tipoambiente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioProveedor {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Proveedores proveedores) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(proveedores);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar proveedores "+e.getMessage());
        } finally {
            em.close();
        }

    }

    public void eliminar(Proveedores proveedores) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(proveedores));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error en eliminar  proveedores "+e.getMessage());
        } finally {
            em.close();
        }

    }

    public void modificar(Proveedores proveedores) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(proveedores);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar proveedores "+e.getMessage());
        } finally {
            em.close();
        }

    }

    public List<Proveedores> FindALlProveedores(Tipoambiente codTipoambiente) {

        List<Proveedores> listaProveedoress = new ArrayList<Proveedores>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Proveedores p WHERE p.codTipoambiente=:codTipoambiente");
            query.setParameter("codTipoambiente", codTipoambiente);
            listaProveedoress = (List<Proveedores>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta proveedores");
        } finally {
            em.close();
        }

        return listaProveedoress;
    }

    public List<Proveedores> findLikeProvNombre(String buscar, Tipoambiente codTipoambiente) {

        List<Proveedores> listaProveedoress = new ArrayList<Proveedores>();
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Proveedores p WHERE p.provNombre like :provNombre AND p.codTipoambiente=:codTipoambiente");
            query.setParameter("provNombre", "%" + buscar + "%");
            query.setParameter("codTipoambiente", codTipoambiente);
            query.setMaxResults(100);
            listaProveedoress = (List<Proveedores>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta proveedores");
        } finally {
            em.close();
        }

        return listaProveedoress;
    }

    public Proveedores findProvCedula(String buscar, Tipoambiente codTipoambiente) {
        Proveedores proveedores = new Proveedores();
        List<Proveedores> listaProveedoress = new ArrayList<Proveedores>();
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Proveedores p WHERE p.provCedula = :provCedula AND p.codTipoambiente=:codTipoambiente");
            query.setParameter("provCedula", buscar);
            query.setParameter("codTipoambiente", codTipoambiente);
            query.setMaxResults(100);
            listaProveedoress = (List<Proveedores>) query.getResultList();
            if (listaProveedoress.size() > 0) {
                proveedores = (Proveedores) listaProveedoress.get(0);
            } else {
                proveedores = null;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta proveedores " + e);
        } finally {
            em.close();
        }

        return proveedores;
    }

    public List<Proveedores> findProveedorCedula(String buscar, Tipoambiente codTipoambiente) {

        List<Proveedores> listaProveedoress = new ArrayList<Proveedores>();
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Proveedores p WHERE p.provCedula LIKE :provCedula AND p.codTipoambiente=:codTipoambiente");
            query.setParameter("provCedula", "%" + buscar + "%");
            query.setParameter("codTipoambiente", codTipoambiente);
            query.setMaxResults(100);
            listaProveedoress = (List<Proveedores>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta proveedores " + e);
        } finally {
            em.close();
        }

        return listaProveedoress;
    }
}

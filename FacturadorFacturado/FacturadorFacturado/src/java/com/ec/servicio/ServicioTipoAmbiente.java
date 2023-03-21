/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioTipoAmbiente {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Tipoambiente tipoambiente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(tipoambiente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.out.println("Error en insertar tipoambiente " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void eliminar(Tipoambiente tipoambiente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(tipoambiente));
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.out.println("Error en eliminar  tipoambiente " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void modificar(Tipoambiente tipoambiente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(tipoambiente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.out.println("Error en insertar tipoambiente " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public Tipoambiente findALlTipoambientePorUsuario(Usuario usuario) {

        List<Tipoambiente> listaTipoambientes = new ArrayList<Tipoambiente>();
        Tipoambiente tipoambiente = null;
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Tipoambiente a WHERE a.idUsuario=:idUsuario AND a.amEstado=:amEstado");
            query.setParameter("idUsuario", usuario);
            query.setParameter("amEstado", Boolean.TRUE);
            listaTipoambientes = (List<Tipoambiente>) query.getResultList();
            if (listaTipoambientes.size() > 0) {
                tipoambiente = listaTipoambientes.get(0);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta tipoambiente");
        } finally {
            em.close();
        }

        return tipoambiente;
    }
    
    
    public List<Tipoambiente> findALlTipoambientePorUsuarioAdm(String usuario, String amCodigo) {

        List<Tipoambiente> listaTipoambientes = new ArrayList<Tipoambiente>();
        Tipoambiente tipoambiente = null;
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Tipoambiente a WHERE  UPPER(a.idUsuario.usuNombre) like :usuNombre AND a.amCodigo=:amCodigo AND a.amEstado=:amEstado");
            query.setParameter("usuNombre", "%"+usuario+"%");
            query.setParameter("amEstado", Boolean.TRUE);
            query.setParameter("amCodigo", amCodigo);
            listaTipoambientes = (List<Tipoambiente>) query.getResultList();
          
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("findALlTipoambientePorUsuarioAdm "+e.getMessage() );
        } finally {
            em.close();
        }

        return listaTipoambientes;
    }

    public Tipoambiente findByAmCodigo(String amRuc) {

        List<Tipoambiente> listaTipoambientes = new ArrayList<Tipoambiente>();
        Tipoambiente tipoambiente = null;
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT t FROM Tipoambiente t WHERE  t.amRuc=:amRuc AND t.amEstado =:amEstado");
            query.setParameter("amEstado", Boolean.TRUE);
            query.setParameter("amRuc", amRuc);
            listaTipoambientes = (List<Tipoambiente>) query.getResultList();
            if (listaTipoambientes.size() > 0) {
                tipoambiente = listaTipoambientes.get(0);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta tipoambiente " + e.getMessage());
        } finally {
            em.close();
        }

        return tipoambiente;
    }

    public Tipoambiente findByAmCodigo(Usuario usuario, String amCodigo) {

        List<Tipoambiente> listaTipoambientes = new ArrayList<Tipoambiente>();
        Tipoambiente tipoambiente = null;
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT t FROM Tipoambiente t WHERE  t.idUsuario=:idUsuario AND t.amCodigo =:amCodigo");
//            query.setParameter("amEstado", Boolean.TRUE);
            query.setParameter("idUsuario", usuario);
            query.setParameter("amCodigo", amCodigo);
            listaTipoambientes = (List<Tipoambiente>) query.getResultList();
            if (listaTipoambientes.size() > 0) {
                tipoambiente = listaTipoambientes.get(0);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta tipoambiente " + e.getMessage());
        } finally {
            em.close();
        }

        return tipoambiente;
    }

    public List<Tipoambiente> findEmpresas(String amCodigo, String amDescripcion, String amNombreComercial) {

        List<Tipoambiente> listaTipoambientes = new ArrayList<Tipoambiente>();
        Tipoambiente tipoambiente = null;
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT t FROM Tipoambiente t WHERE t.amCodigo= :amCodigo AND t.amDescripcion =:amDescripcion AND t.amNombreComercial LIKE :amNombreComercial ORDER BY t.amNombreComercial ASC");
            query.setParameter("amCodigo", amCodigo);
            query.setParameter("amDescripcion", amDescripcion);
            query.setParameter("amNombreComercial", "%" + amNombreComercial + "%");
            listaTipoambientes = (List<Tipoambiente>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta tipoambiente");
        } finally {
            em.close();
        }

        return listaTipoambientes;
    }

}

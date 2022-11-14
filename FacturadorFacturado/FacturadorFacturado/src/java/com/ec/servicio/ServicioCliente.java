/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Cliente;
import com.ec.entidad.Tipoambiente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioCliente {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Cliente cliente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar cliente");
        } finally {
            em.close();
        }

    }

    public void eliminar(Cliente cliente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(cliente));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error en eliminar  cliente" + e);
        } finally {
            em.close();
        }

    }

    public void modificar(Cliente cliente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar cliente");
        } finally {
            em.close();
        }

    }

    public List<Cliente> FindALlCliente() {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.findAll", Cliente.class);
//           query.setParameter("codigoUsuario", cliente);
            listaClientes = (List<Cliente>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente");
        } finally {
            em.close();
        }

        return listaClientes;
    }

    public Cliente FindClienteForCedula(String buscar, Tipoambiente codTipoambiente) {

        Cliente cliente = new Cliente();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.cliCedula = :cliCedula AND c.codTipoambiente=:codTipoambiente");
            query.setParameter("cliCedula", buscar);
             query.setParameter("codTipoambiente", codTipoambiente);
            List<Cliente> listaCliente = (List<Cliente>) query.getResultList();
            if (listaCliente.size() > 0) {
                cliente = (Cliente) query.getSingleResult();
            } else {
                return null;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente");
        } finally {
            em.close();
        }

        return cliente;
    }

    public List<Cliente> FindClienteLikeNombre(String buscar, Tipoambiente codTipoambiente) {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE (c.cliNombre like :cliNombre AND c.codTipoambiente=:codTipoambiente) OR c.cliNombres LIKE '%CONSUMIDOR%'");
            query.setParameter("cliNombre", "%" + buscar + "%");
            query.setParameter("codTipoambiente", codTipoambiente);
            query.setMaxResults(200);
            listaClientes = (List<Cliente>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente");
        } finally {
            em.close();
        }

        return listaClientes;
    }

    public List<Cliente> FindClienteLikeRazonSocial(String buscar, Tipoambiente codTipoambiente) {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE (c.cliNombres like :cliRazonSocial OR c.cliApellidos LIKE :cliApellidos AND c.codTipoambiente=:codTipoambiente) OR c.cliNombres LIKE '%CONSUMIDOR%'");
            query.setParameter("cliRazonSocial", "%" + buscar + "%");
            query.setParameter("cliApellidos", "%" + buscar + "%");
            query.setParameter("codTipoambiente", codTipoambiente);
            query.setMaxResults(200);
            listaClientes = (List<Cliente>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente");
        } finally {
            em.close();
        }

        return listaClientes;
    }

    public List<Cliente> FindClienteLikeCedula(String buscar, Tipoambiente codTipoambiente) {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            String SELECT = "SELECT c FROM Cliente c WHERE c.cliCedula like :cliCedula ";
            String WHERE = " ";
            if (!buscar.contains("9999999999999")) {
                WHERE = "AND c.codTipoambiente=:codTipoambiente";
            }
            Query query = em.createQuery(SELECT + WHERE);
            query.setParameter("cliCedula", "%" + buscar + "%");
            if (!buscar.contains("9999999999999")) {
                query.setParameter("codTipoambiente", codTipoambiente);
            }
            query.setMaxResults(200);
            listaClientes = (List<Cliente>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente");
        } finally {
            em.close();
        }

        return listaClientes;
    }

    public Cliente findClienteLikeCedula(String buscar) {
        Cliente cliente = null;
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.findLikeCliCedula", Cliente.class);
            query.setParameter("cliCedula", "%" + buscar + "%");
            listaClientes = (List<Cliente>) query.getResultList();
            if (listaClientes.size() > 0) {
                cliente = listaClientes.get(0);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente " + e.getMessage());
        } finally {
            em.close();
        }

        return cliente;
    }

    public Cliente FindClientFinal(String buscar) {

        Cliente cliente = new Cliente();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.findByCliNombre", Cliente.class);
            query.setParameter("cliNombre", "%" + buscar + "%");
            List<Cliente> listaCliente = (List<Cliente>) query.getResultList();
            if (listaCliente.size() > 0) {
                cliente = (Cliente) query.getResultList().get(0);
            } else {
                return null;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente");
        } finally {
            em.close();
        }

        return cliente;
    }

    public Cliente findByCliCedulaPassword(String buscar, String clave) {

        Cliente cliente = null;
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.findByCliCedulaPassword", Cliente.class);
            query.setParameter("cliCedula", buscar);
            query.setParameter("clave", clave);
            List<Cliente> listaCliente = (List<Cliente>) query.getResultList();
            if (listaCliente.size() > 0) {
                cliente = (Cliente) query.getResultList().get(0);
            } else {
                return null;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta cliente " + e.getMessage());
        } finally {
            em.close();
        }

        return cliente;
    }
}

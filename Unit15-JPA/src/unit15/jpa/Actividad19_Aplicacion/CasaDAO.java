package unit15.jpa.Actividad19_Aplicacion;

import unit15.jpa.Actividad07.exceptions.NonexistentEntityException;
import unit15.jpa.Actividad07.exceptions.PreexistingEntityException;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class CasaDAO implements Serializable {

    public CasaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Casa casa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(casa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCasa(casa.getNumero()) != null) {
                throw new PreexistingEntityException("Casa " + casa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Casa casa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            casa = em.merge(casa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = casa.getNumero();
                if (findCasa(id) == null) {
                    throw new NonexistentEntityException("The casa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Casa casa;
            try {
                casa = em.getReference(Casa.class, id);
                casa.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The casa with id " + id + " no longer exists.", enfe);
            }
            em.remove(casa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Casa> findCasaEntities() {
        return findCasaEntities(true, -1, -1);
    }

    public List<Casa> findCasaEntities(int maxResults, int firstResult) {
        return findCasaEntities(false, maxResults, firstResult);
    }

    private List<Casa> findCasaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Casa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Casa findCasa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Casa.class, id);
        } finally {
            em.close();
        }
    }

    public int getCasaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Casa> rt = cq.from(Casa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

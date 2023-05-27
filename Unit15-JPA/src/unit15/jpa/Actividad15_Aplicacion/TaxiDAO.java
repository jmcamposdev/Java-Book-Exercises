package unit15.jpa.Actividad15_Aplicacion;

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

public class TaxiDAO implements Serializable {

    public TaxiDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Taxi taxi) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(taxi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTaxi(taxi.getMatricula()) != null) {
                throw new PreexistingEntityException("Taxi " + taxi + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Taxi taxi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            taxi = em.merge(taxi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = taxi.getMatricula();
                if (findTaxi(id) == null) {
                    throw new NonexistentEntityException("The taxi with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Taxi taxi;
            try {
                taxi = em.getReference(Taxi.class, id);
                taxi.getMatricula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The taxi with id " + id + " no longer exists.", enfe);
            }
            em.remove(taxi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Taxi> findTaxiEntities() {
        return findTaxiEntities(true, -1, -1);
    }

    public List<Taxi> findTaxiEntities(int maxResults, int firstResult) {
        return findTaxiEntities(false, maxResults, firstResult);
    }

    private List<Taxi> findTaxiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Taxi.class));
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

    public Taxi findTaxi(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Taxi.class, id);
        } finally {
            em.close();
        }
    }

    public int getTaxiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Taxi> rt = cq.from(Taxi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

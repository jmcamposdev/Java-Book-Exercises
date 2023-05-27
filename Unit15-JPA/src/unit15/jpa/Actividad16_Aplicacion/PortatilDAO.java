package unit15.jpa.Actividad16_Aplicacion;

import codigo.exceptions.NonexistentEntityException;
import codigo.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PortatilDAO implements Serializable {

    public PortatilDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Portatil portatil) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno alumno = portatil.getAlumno();
            if (alumno != null) {
                alumno = em.getReference(alumno.getClass(), alumno.getNum());
                portatil.setAlumno(alumno);
            }
            em.persist(portatil);
            if (alumno != null) {
                Portatil oldPortatilOfAlumno = alumno.getPortatil();
                if (oldPortatilOfAlumno != null) {
                    oldPortatilOfAlumno.setAlumno(null);
                    oldPortatilOfAlumno = em.merge(oldPortatilOfAlumno);
                }
                alumno.setPortatil(portatil);
                alumno = em.merge(alumno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPortatil(portatil.getId()) != null) {
                throw new PreexistingEntityException("Portatil " + portatil + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Portatil portatil) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Portatil persistentPortatil = em.find(Portatil.class, portatil.getId());
            Alumno alumnoOld = persistentPortatil.getAlumno();
            Alumno alumnoNew = portatil.getAlumno();
            if (alumnoNew != null) {
                alumnoNew = em.getReference(alumnoNew.getClass(), alumnoNew.getNum());
                portatil.setAlumno(alumnoNew);
            }
            portatil = em.merge(portatil);
            if (alumnoOld != null && !alumnoOld.equals(alumnoNew)) {
                alumnoOld.setPortatil(null);
                alumnoOld = em.merge(alumnoOld);
            }
            if (alumnoNew != null && !alumnoNew.equals(alumnoOld)) {
                Portatil oldPortatilOfAlumno = alumnoNew.getPortatil();
                if (oldPortatilOfAlumno != null) {
                    oldPortatilOfAlumno.setAlumno(null);
                    oldPortatilOfAlumno = em.merge(oldPortatilOfAlumno);
                }
                alumnoNew.setPortatil(portatil);
                alumnoNew = em.merge(alumnoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = portatil.getId();
                if (findPortatil(id) == null) {
                    throw new NonexistentEntityException("The portatil with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Portatil portatil;
            try {
                portatil = em.getReference(Portatil.class, id);
                portatil.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The portatil with id " + id + " no longer exists.", enfe);
            }
            Alumno alumno = portatil.getAlumno();
            if (alumno != null) {
                alumno.setPortatil(null);
                alumno = em.merge(alumno);
            }
            em.remove(portatil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Portatil> findPortatilEntities() {
        return findPortatilEntities(true, -1, -1);
    }

    public List<Portatil> findPortatilEntities(int maxResults, int firstResult) {
        return findPortatilEntities(false, maxResults, firstResult);
    }

    private List<Portatil> findPortatilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Portatil.class));
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

    public Portatil findPortatil(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Portatil.class, id);
        } finally {
            em.close();
        }
    }

    public int getPortatilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Portatil> rt = cq.from(Portatil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

package DAO;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public abstract class AbstractDAO<T> implements Serializable {

    @PersistenceContext(unitName = "E-SaglikPU")
    protected EntityManager entityManager;
    protected Class<T> entityClass;

    public AbstractDAO() {
    }

    public AbstractDAO(Class<T> ec) {
        this.entityClass = ec;
    }

    public void Create(T entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating entity", e);
        }
    }

    public void Update(T entity) {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating entity", e);
        }
    }

    public List<T> GetList() {
        try {
            Query q = entityManager.createQuery("select c from " + entityClass.getSimpleName() + " c order by c.id desc", entityClass);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting list of entities", e);
        }
    }

    public void Delete(T entity) {
        try {
            entityManager.remove(entityManager.merge(entity));
            entityManager.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting entity", e);
        }
    }

    public T GetById(int id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting entity by ID", e);
        }
    }

    public List<T> FindRange(int[] range) {
        try {
            Query q = entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
            q.setMaxResults(range[1] - range[0]);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while finding range of entities", e);
        }
    }

    public int Count() {
        try {
            Query q = entityManager.createQuery("SELECT COUNT(e) FROM " + entityClass.getName() + " e");
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while counting entities", e);
        }
    }
}

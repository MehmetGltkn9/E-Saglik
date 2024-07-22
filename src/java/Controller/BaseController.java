package Controller;

import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;

@Named
public abstract class BaseController<E> {

    protected E entity;
    private List<E> list;
    private final Class<E> entityClass;

    public BaseController(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract void AddEntity();

    public abstract E GetEntityById(int id);

    public abstract List<E> GetEntityList();

    public abstract void UpdateEntity();

    public abstract void DeleteEntity();

    public E getEntity() {
        if (this.entity == null) {
            try {
                this.entity = entityClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

}

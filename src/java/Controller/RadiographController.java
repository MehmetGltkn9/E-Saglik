
package Controller;

import DAO.AbstractDAO;
import DAO.RadiographDAO;
import Entity.Radiograph;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class RadiographController extends BaseController<Radiograph> implements Serializable {

    @EJB
    private RadiographDAO radiographDao;
    private Radiograph entity;
    private List<Radiograph> radiographList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public RadiographController() {
        super(Radiograph.class);
    }

    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(getRadiographDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Radiograph();
    }

    public void updateForm(Radiograph rad) {
        this.entity = rad;
    }


    public RadiographDAO getRadiographDao() {
        if (this.radiographDao == null) {
            this.radiographDao = new RadiographDAO();
        }
        return radiographDao;
    }

    public void setRadiographDao(RadiographDAO radiographDao) {
        this.radiographDao = radiographDao;
    }

    public Radiograph getEntity() {
        if (entity == null) {
            entity = new Radiograph();
        }
        return entity;
    }

    public void setEntity(Radiograph entity) {
        this.entity = entity;
    }

    public List<Radiograph> getRadiographList() {
        this.radiographList = this.getRadiographDao().GetList();
        return radiographList;
    }

    public void setRadiographList(List<Radiograph> radiographList) {
        this.radiographList = radiographList;
    }

    @Override
    public Radiograph GetEntityById(int id) {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.GetById(id);
        return null;
    }

    @Override
    public List<Radiograph> GetEntityList() {
        return getRadiographDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getRadiographDao().Update(entity);
        this.entity = new Radiograph();
    }

    @Override
    public void DeleteEntity() {     
        getRadiographDao().Delete(entity);
        this.entity = new Radiograph();
    }

    @Override
    public void AddEntity() {    
        getRadiographDao().Create(entity);
        this.entity = new Radiograph();
    }

}

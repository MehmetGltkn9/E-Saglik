package Controller;

import DAO.AbstractDAO;
import DAO.TreatmentDAO;
import Entity.Treatment;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TreatmentController extends BaseController<Treatment> implements Serializable {

    @EJB
    private TreatmentDAO treatmentDao;
    private Treatment entity;
    private List<Treatment> treatmentList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    
    public TreatmentController() {
        super(Treatment.class);
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
        this.pageCount = (int) Math.ceil(getTreatmentDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Treatment();
    }

    public void updateForm(Treatment tre) {
        this.entity = tre;
    }
    public AbstractDAO getTreatmentDao() {
        if (this.treatmentDao == null) {
            this.treatmentDao = new TreatmentDAO();
        }
        return treatmentDao;
    }

    public void setTreatmentDao(TreatmentDAO treatmentDao) {
        this.treatmentDao = treatmentDao;
    }

    public Treatment getEntity() {
        if (entity == null) {
            entity = new Treatment();
        }
        return entity;
    }

    public void setEntity(Treatment entity) {
        this.entity = entity;
    }

    public List<Treatment> getTreatmentList() {
        this.treatmentList = this.getTreatmentDao().GetList();
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    @Override
    public Treatment GetEntityById(int id) {
        if (treatmentDao == null) {
            treatmentDao = new TreatmentDAO();
        }
        treatmentDao.GetById(id);
        return null;
    }

    @Override
    public List<Treatment> GetEntityList() {
        return getTreatmentDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getTreatmentDao().Update(this.entity);
        this.entity = new Treatment();
    }

    @Override
    public void DeleteEntity() {
        getTreatmentDao().Delete(this.entity);
        this.entity = new Treatment();
    }

    @Override
    public void AddEntity() {
        getTreatmentDao().Create(this.entity);
        this.entity = new Treatment();
    }

}

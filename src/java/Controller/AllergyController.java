package Controller;

import DAO.AllergyDAO;
import Entity.Allergy;
import Entity.Doctor;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AllergyController extends BaseController<Allergy> implements Serializable {

    @EJB
    private AllergyDAO dao;
    private Allergy entity;
    private List<Allergy> allergyList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    
    public AllergyController() {
        super(Allergy.class);
    }

    public AllergyDAO getDao() {
        if (this.dao == null) {
            this.dao = new AllergyDAO();
        }
        return dao;
    }

    public void setDao(AllergyDAO dao) {
        this.dao = dao;
    }

    public Allergy getEntity() {
        if (entity == null) {
            entity = new Allergy();
        }
        return entity;
    }

    public void setEntity(Allergy entity) {
        this.entity = entity;
    }

    public List<Allergy> getAllergyList() {
        this.allergyList = this.getDao().GetList();
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
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
        this.pageCount = (int) Math.ceil(getDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Allergy();
    }

    public void updateForm(Allergy allergy) {
        this.entity = allergy;
    }

    @Override
    public void AddEntity() {
        getDao().Create(this.entity);
        this.entity = new Allergy();

    }

    @Override
    public Allergy GetEntityById(int id) {
        if (getDao() == null) {
            dao = new AllergyDAO();
        }
        getDao().GetById(id);
        return null;
    }

    @Override
    public List<Allergy> GetEntityList() {
         return getDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getDao().Update(entity);
        this.entity = new Allergy();
    }

    @Override
    public void DeleteEntity() {
             getDao().Delete(entity);
        this.entity = new Allergy();
    }

}

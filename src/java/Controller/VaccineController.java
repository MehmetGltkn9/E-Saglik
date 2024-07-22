package Controller;

import DAO.AbstractDAO;
import DAO.VaccineDAO;
import Entity.Disease;
import Entity.Vaccine;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class VaccineController extends BaseController<Vaccine> implements Serializable {

    @EJB
    private VaccineDAO vaccineDao;
    private Vaccine entity;
    private List<Vaccine> vaccineList;
    
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public VaccineController() {
        super(Vaccine.class);
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
        this.entity = new Vaccine();
    }

    public void updateForm(Vaccine vacc) {
        this.entity = vacc;
    }

    public VaccineDAO getDao() {
        if (this.vaccineDao == null) {
            this.vaccineDao = new VaccineDAO();
        }
        return vaccineDao;
    }

    public void setVaccineDao(VaccineDAO vaccineDao) {
        this.vaccineDao = vaccineDao;
    }

    public Vaccine getEntity() {
                if (entity == null) {
            entity = new Vaccine();
        }
        return entity;
    }

    public void setEntity(Vaccine entity) {
        this.entity = entity;
    }

    public List<Vaccine> getVaccineList() {
        this.vaccineList = this.getDao().GetList();
        return vaccineList;
    }

    public void setVaccineList(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }

    @Override
    public Vaccine GetEntityById(int id) {
        if (vaccineDao == null) {
            vaccineDao = new VaccineDAO();
        }
        vaccineDao.GetById(id);
        return null;
    }

    @Override
    public List<Vaccine> GetEntityList() {
        return getDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getDao().Update(entity);
        this.entity = new Vaccine();
    }

    @Override
    public void DeleteEntity() {
        getDao().Delete(entity);
        this.entity = new Vaccine();
    }

    @Override
    public void AddEntity() {
        getDao().Create(this.entity);
        this.entity = new Vaccine();
    }

}

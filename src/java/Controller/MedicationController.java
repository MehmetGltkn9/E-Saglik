package Controller;

import DAO.AbstractDAO;
import DAO.MedicationDAO;
import Entity.Medication;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MedicationController extends BaseController<Medication> implements Serializable {

    @EJB
    private MedicationDAO medicationDao;
    private Medication entity;
    private List<Medication> medicationList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public MedicationController() {
        super(Medication.class);
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
        this.pageCount = (int) Math.ceil(getMedicationDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Medication();
    }

    public void updateForm(Medication doc) {
        this.entity = doc;
    }

    public MedicationDAO getMedicationDao() {
        return medicationDao;
    }

    public void setMedicationDao(MedicationDAO medicationDao) {
        this.medicationDao = medicationDao;
    }

    public Medication getEntity() {
        if (entity == null) {
            entity = new Medication();
        }
        return entity;
    }

    public void setEntity(Medication entity) {
        this.entity = entity;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    @Override
    public void AddEntity() {
        getMedicationDao().Create(entity);
        entity = new Medication();
    }

    @Override
    public Medication GetEntityById(int id) {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.GetById(id);
        return null;
    }

    @Override
    public List<Medication> GetEntityList() {
        return getMedicationDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getMedicationDao().Update(entity);
        entity = new Medication();
    }

    @Override
    public void DeleteEntity() {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.Delete(entity);
    }

}

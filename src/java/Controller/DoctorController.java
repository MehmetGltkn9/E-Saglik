package Controller;

import DAO.DoctorDAO;
import Entity.Doctor;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DoctorController extends BaseController<Doctor> implements Serializable {

    
    @EJB
    private DoctorDAO dao;
    private Doctor entity;
    private List<Doctor> list;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public DoctorController() {
        super(Doctor.class);
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
        this.entity = new Doctor();
    }

    public void updateForm(Doctor doc) {
        this.entity = doc;
    }

    public DoctorDAO getDao() {
        if (this.dao == null) {
            this.dao = new DoctorDAO();
        }
        return dao;
    }

    public void setDao(DoctorDAO dao) {
        this.dao = dao;
    }

    public List<Doctor> getList() {
        this.list = this.getDao().GetList();
        return list;
    }

    public void setList(List<Doctor> list) {
        this.list = list;
    }

    public Doctor getEntity() {
        if (entity == null) {
            entity = new Doctor();
        }
        return entity;
    }

    public void setEntity(Doctor entity) {
        this.entity = entity;
    }

    @Override
    public void AddEntity() {
        getDao().Create(this.entity);
        this.entity = new Doctor();
    }

    @Override
    public Doctor GetEntityById(int id) {
        if (getDao() == null) {
            dao =  new DoctorDAO();
        }
        getDao().GetById(id);
        return null;
    }

    @Override
    public List<Doctor> GetEntityList() {
        return getDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getDao().Update(entity);
        this.entity = new Doctor();
    }

    @Override
    public void DeleteEntity() {

        getDao().Delete(entity);
        this.entity = new Doctor();
    }

}

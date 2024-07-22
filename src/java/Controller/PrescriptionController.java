package Controller;

import DAO.AbstractDAO;
import DAO.PrescriptionDAO;
import Entity.Prescription;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PrescriptionController extends BaseController<Prescription> implements Serializable {

    @EJB
    private PrescriptionDAO dao;
    private Prescription entity;
    private List<Prescription> list;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public PrescriptionController() {
        super(Prescription.class);
    }

    public PrescriptionDAO getDao() {
        if (this.dao == null) {
            this.dao = new PrescriptionDAO();
        }
        return dao;
    }

    public void setDao(PrescriptionDAO dao) {
        this.dao = dao;
    }

    public Prescription getPrescription() {
        if (entity == null) {
            entity = new Prescription();
        }
        return entity;
    }

    public void setPrescription(Prescription prescription) {
        this.entity = prescription;
    }

    public List<Prescription> getList() {
        this.list = this.getDao().GetList();
        return list;
    }

    public void setList(List<Prescription> list) {
        this.list = list;
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
        this.entity = new Prescription();
    }

    public void updateForm(Prescription pre) {
        this.entity = pre;
    }

    @Override
    public Prescription GetEntityById(int id) {
        if (dao == null) {
            dao = new PrescriptionDAO();
        }
        dao.GetById(id);
        return null;
    }

    @Override
    public List<Prescription> GetEntityList() {
        return getDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getDao().Update(entity);
        entity = new Prescription();
    }

    @Override
    public void DeleteEntity() {
        getDao().Delete(entity);
        entity = new Prescription();
    }

    @Override
    public void AddEntity() {
        getDao().Create(entity);
        entity = new Prescription();
    }

    public Prescription getEntity() {
        if (entity == null) {
            entity = new Prescription();
        }
        return entity;
    }

    public void setEntity(Prescription entity) {
        this.entity = entity;
    }

}

package Controller;

import DAO.AbstractDAO;
import DAO.InsuranceDAO;
import Entity.Insurance;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class InsuranceController extends BaseController<Insurance> implements Serializable{

    @EJB
    private InsuranceDAO ınsuranceDao;
    private Insurance entity;
    private List<Insurance> ınsuranceList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    
    public InsuranceController() {
        super(Insurance.class);
    }

    public InsuranceDAO getInsuranceDao() {
        return ınsuranceDao;
    }

    public void setInsuranceDao(InsuranceDAO ınsuranceDao) {
        this.ınsuranceDao = ınsuranceDao;
    }

    public Insurance getEntity() {
        if (entity == null) {
            entity = new Insurance();
        }
        return entity;
    }

    public void setEntity(Insurance entity) {
        this.entity = entity;
    }

    public List<Insurance> getInsuranceList() {
        return ınsuranceList;
    }

    public void setInsuranceList(List<Insurance> ınsuranceList) {
        this.ınsuranceList = ınsuranceList;
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
        this.pageCount = (int) Math.ceil(getInsuranceDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Insurance();
    }

    public void updateForm(Insurance doc) {
        this.entity = doc;
    }

    @Override
    public void AddEntity() {
        getInsuranceDao().Create(this.entity);
        this.entity = new Insurance();
    }

    @Override
    public Insurance GetEntityById(int id) {
        if (getInsuranceDao() == null) {
            ınsuranceDao =  new InsuranceDAO();
        }
        getInsuranceDao().GetById(id);
        return null;
    }

    @Override
    public List<Insurance> GetEntityList() {
        return getInsuranceDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getInsuranceDao().Update(entity);
        this.entity = new Insurance();
    }

    @Override
    public void DeleteEntity() {

        getInsuranceDao().Delete(entity);
        this.entity = new Insurance();
    }

}

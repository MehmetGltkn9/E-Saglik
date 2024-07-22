package Controller;

import DAO.AdminDAO;
import Entity.Admin;
import Entity.Doctor;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AdminController extends BaseController<Admin> implements Serializable{

    @EJB
    private AdminDAO adminDao;   
    private Admin entity;
    private List<Admin> adminList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    
    public AdminController(Class<Admin> entityClass) {
        super(Admin.class);
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
        this.pageCount = (int) Math.ceil(getAdminDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Admin();
    }

    public void updateForm(Admin adm) {
        this.entity = adm;
    }
    
    public AdminDAO getAdminDao() {
        if (this.adminDao == null) {
            this.adminDao = new AdminDAO();
        }
        return adminDao;
    }

    
    public void setAdminDao(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

    public Admin getEntity() {
        if (entity == null) {
            entity = new Admin();
        }
        return entity;
    }

    public void setEntity(Admin entity) {
        this.entity = entity;
    }

    public List<Admin> getAdminList() {
        this.adminList = this.getAdminDao().GetList();
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @Override
    public void AddEntity() {
        getAdminDao().Create(this.entity);
        this.entity = new Admin();

    }

    @Override
    public Admin GetEntityById(int id) {
        if (adminDao == null) {
            adminDao = new AdminDAO();
        }
        adminDao.GetById(id);
        return null;
    }

    @Override
    public List<Admin> GetEntityList() {
        return getAdminDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getAdminDao().Update(this.entity);
        this.entity = new Admin();
    }

    @Override
    public void DeleteEntity() {
        getAdminDao().Delete(this.entity);
        this.entity = new Admin();
    }

}

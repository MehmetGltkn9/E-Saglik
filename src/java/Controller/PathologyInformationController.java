package Controller;

import DAO.PathologyInformationDAO;
import Entity.PathologyInformation;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PathologyInformationController extends BaseController<PathologyInformation> implements Serializable {

    @EJB
    private PathologyInformationDAO pathologyInformationDao;
    private PathologyInformation entity;
    private List<PathologyInformation> pathologyInformationList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public PathologyInformationController() {
        super(PathologyInformation.class);
    }

    public PathologyInformationDAO getPathologyInformationDao() {
        if (this.pathologyInformationDao == null) {
            this.pathologyInformationDao = new PathologyInformationDAO();
        }
        return pathologyInformationDao;
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
        this.pageCount = (int) Math.ceil(getPathologyInformationDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new PathologyInformation();
    }

    public void updateForm(PathologyInformation doc) {
        this.entity = doc;
    }

    public void setNotificationDao(PathologyInformationDAO pathologyInformationDao) {
        this.pathologyInformationDao = pathologyInformationDao;
    }

    public PathologyInformation getEntity() {
        if (entity == null) {
            entity = new PathologyInformation();
        }
        return entity;
    }

    public void setEntity(PathologyInformation entity) {
        this.entity = entity;
    }

    public List<PathologyInformation> getPathologyInformationList() {
        this.pathologyInformationList = this.getPathologyInformationDao().GetList();
        return pathologyInformationList;
    }

    public void setPathologyInformationList(List<PathologyInformation> pathologyInformationList) {
        this.pathologyInformationList = pathologyInformationList;
    }

    @Override
    public void AddEntity() {
        getPathologyInformationDao().Create(this.entity);
        this.entity = new PathologyInformation();
    }

    @Override
    public PathologyInformation GetEntityById(int id) {
        if (getPathologyInformationDao() == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        getPathologyInformationDao().GetById(id);
        return null;
    }

    @Override
    public List<PathologyInformation> GetEntityList() {
        return getPathologyInformationDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getPathologyInformationDao().Update(entity);
        this.entity = new PathologyInformation();
    }

    @Override
    public void DeleteEntity() {
        getPathologyInformationDao().Delete(entity);
        this.entity = new PathologyInformation();
    }

}

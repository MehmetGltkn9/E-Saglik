package Controller;

import DAO.VaccinationScheduleDAO;
import Entity.VaccinationSchedule;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class VaccinationScheduleController extends BaseController<VaccinationSchedule> implements Serializable {

    @EJB
    private VaccinationScheduleDAO scheduleDao;
    private VaccinationSchedule entity;
    private List<VaccinationSchedule> scheduleList;
    
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public VaccinationScheduleController() {
        super(VaccinationSchedule.class);
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
        this.pageCount = (int) Math.ceil(getScheduleDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new VaccinationSchedule();
    }

    public void updateForm(VaccinationSchedule sch) {
        this.entity = sch;
    }

    public VaccinationScheduleDAO getScheduleDao() {
        if (this.scheduleDao == null) {
            this.scheduleDao = new VaccinationScheduleDAO();
        }
        return scheduleDao;
    }

    public void setScheduleDao(VaccinationScheduleDAO scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public VaccinationSchedule getEntity() {
        if (entity == null) {
            entity = new VaccinationSchedule();
        }
        return entity;
    }

    public void setEntity(VaccinationSchedule entity) {
        this.entity = entity;
    }

    public List<VaccinationSchedule> getScheduleList() {
        this.scheduleList = this.getScheduleDao().GetList();
        return scheduleList;
    }

    public void setScheduleList(List<VaccinationSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public VaccinationSchedule GetEntityById(int id) {
        if (scheduleDao == null) {
            scheduleDao = new VaccinationScheduleDAO();
        }
        scheduleDao.GetById(id);
        return null;
    }

    @Override
    public List<VaccinationSchedule> GetEntityList() {
         return getScheduleDao().GetList();

    }

    @Override
    public void UpdateEntity() {
         getScheduleDao().Update(entity);
        this.entity = new VaccinationSchedule();
    }

    @Override
    public void DeleteEntity() {
        getScheduleDao().Delete(entity);
        this.entity = new VaccinationSchedule();
    }

    @Override
    public void AddEntity() {
        getScheduleDao().Create(this.entity);
        this.entity = new VaccinationSchedule();
    }

}

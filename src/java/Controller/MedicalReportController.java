package Controller;

import DAO.AbstractDAO;
import DAO.MedicalReportDAO;
import Entity.MedicalReport;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MedicalReportController extends BaseController<MedicalReport> implements Serializable{

    @EJB
    private MedicalReportDAO medicalReportDao;
    private MedicalReport entity;
    private List<MedicalReport> medicalReportList;
    
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public MedicalReportController() {
        super(MedicalReport.class);
    }

    public MedicalReportDAO getMedicalReportDao() {
        if (this.medicalReportDao == null) {
            this.medicalReportDao = new MedicalReportDAO();
        }
        return medicalReportDao;
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
        this.pageCount = (int) Math.ceil(getMedicalReportDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new MedicalReport();
    }

    public void updateForm(MedicalReport doc) {
        this.entity = doc;
    }

    public void setMedicalReportDao(MedicalReportDAO medicalReportDao) {
        this.medicalReportDao = medicalReportDao;
    }

    public MedicalReport getEntity() {
        if (entity == null) {
            entity = new MedicalReport();
        }
        return entity;
    }

    public void setEntity(MedicalReport entity) {
        this.entity = entity;
    }

    public List<MedicalReport> getMedicalReportList() {
        this.medicalReportList = this.getMedicalReportDao().GetList();
        return medicalReportList;
    }

    public void setMedicalReportList(List<MedicalReport> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    @Override
    public void AddEntity() {
        getMedicalReportDao().Create(this.entity);
        this.entity = new MedicalReport();

    }

    @Override
    public MedicalReport GetEntityById(int id) {
        if (medicalReportDao == null) {
            medicalReportDao = new MedicalReportDAO();
        }
        medicalReportDao.GetById(id);

        return null;
    }

    @Override
    public List<MedicalReport> GetEntityList() {
        return getMedicalReportDao().GetList();
    }

    @Override
    public void UpdateEntity() {
       getMedicalReportDao().Update(entity);
        this.entity = new MedicalReport();

    }

    @Override
    public void DeleteEntity() {
        medicalReportDao.Delete(entity);
        this.entity = new MedicalReport();

    }

}

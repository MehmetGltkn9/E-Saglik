package Controller;

import DAO.PatientDAO;
import Entity.Patient;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Stateless
public class PatientController extends BaseController<Patient> implements Serializable {

    @EJB
    private PatientDAO patientDao;
    private Patient entity;
    private List<Patient> patientList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public PatientController() {
        super(Patient.class);
    }

    public PatientDAO getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDAO patientDao) {
        this.patientDao = patientDao;
    }

    public Patient getEntity() {
        if (entity == null) {
            entity = new Patient();
        }
        return entity;
    }

    public void setEntity(Patient entity) {
        if (entity == null) {
            entity = new Patient();
        }
        this.entity = entity;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
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
        this.pageCount = (int) Math.ceil(getPatientDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Patient();
    }

    public void updateForm(Patient rad) {
        this.entity = rad;
    }

    public List<String> GetPatientNames() {
        List<Patient> patients = patientDao.GetList();
        List<String> patientNames = new ArrayList<>();

        for (Patient patient : patients) {
            patientNames.add(patient.getName());
        }

        return patientNames;
    }

    @Override
    public Patient GetEntityById(int id) {
        if (getPatientDao() == null) {
            patientDao = new PatientDAO();
        }
        getPatientDao().GetById(id);
        return null;
    }

    @Override
    public List<Patient> GetEntityList() {
        return getPatientDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getPatientDao().Update(entity);
        this.entity = new Patient();
    }

    @Override
    public void DeleteEntity() {
        getPatientDao().Delete(entity);
        this.entity = new Patient();
    }

    @Override
    public void AddEntity() {
        getPatientDao().Create(entity);
        this.entity = new Patient();
    }

}

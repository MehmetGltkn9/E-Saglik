package Controller;

import DAO.AbstractDAO;
import DAO.HospitalDAO;
import Entity.Hospital;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class HospitalController extends BaseController<Hospital> implements Serializable {

    @EJB
    private HospitalDAO hospitalDao;
    private Hospital entity;
    private List<Hospital> hospitalList;

    public HospitalController() {
        super(Hospital.class);
    }

    public AbstractDAO getHospitalDao() {
       if (this.hospitalDao == null) {
            this.hospitalDao = new HospitalDAO();
        }
        return hospitalDao;
    }

    public void setHospitalDao(HospitalDAO hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public Hospital getEntity() {
        if (entity == null) {
            entity = new Hospital();
        }
        return entity;
    }

    public void setEntity(Hospital entity) {
        this.entity = entity;
    }

    public List<Hospital> getHospitalList() {
        this.hospitalList = this.getHospitalDao().GetList();
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    @Override
    public void AddEntity() {
        getHospitalDao().Create(this.entity);
        this.entity = new Hospital();

    }

    @Override
    public Hospital GetEntityById(int id) {
        if (hospitalDao == null) {
            hospitalDao = new HospitalDAO();
        }
        hospitalDao.GetById(id);
        return null;
    }

    @Override
    public List<Hospital> GetEntityList() {
        return getHospitalDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getHospitalDao().Update(entity);
        this.entity = new Hospital();
    }

    @Override
    public void DeleteEntity() {
        hospitalDao.Delete(entity);
        this.entity = new Hospital();
    }

}

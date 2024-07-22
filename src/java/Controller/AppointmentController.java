package Controller;

import DAO.AppointmentDAO;
import Entity.Appointment;
import Entity.Disease;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AppointmentController extends BaseController<Appointment> implements Serializable {

    @EJB
    private AppointmentDAO appointmentDao;   
    private Appointment entity;
    private List<Appointment> appointmentList;

    public AppointmentController() {
        super(Appointment.class);
    }

    public AppointmentDAO getAppointmentDao() {
        if (this.appointmentDao == null) {
            this.appointmentDao = new AppointmentDAO();
        }
        return appointmentDao;
    }

    public void setAppointmentDao(AppointmentDAO appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public Appointment getEntity() {
        if (entity == null) {
            entity = new Appointment();
        }
        return entity;
    }

    public void setEntity(Appointment entity) {
        this.entity = entity;
    }

    public List<Appointment> getAppointmentList() {
        this.appointmentList = this.getAppointmentDao().GetList();
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public void AddEntity() {
         getAppointmentDao().Create(this.entity);
        this.entity = new Appointment();
    }

    @Override
    public Appointment GetEntityById(int id) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO();
        }
        appointmentDao.GetById(id);
        return null;
    }

    @Override
    public List<Appointment> GetEntityList() {
        return getAppointmentDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getAppointmentDao().Update(entity);
        this.entity = new Appointment();
    }

    @Override
    public void DeleteEntity() {
        appointmentDao.Delete(entity);
        this.entity = new Appointment();
    }

}

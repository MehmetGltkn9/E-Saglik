package Controller;

import DAO.AbstractDAO;
import DAO.NotificationDAO;
import Entity.Disease;
import Entity.Notification;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class NotificationController extends BaseController<Notification> implements Serializable{

    @EJB
    private NotificationDAO notificationDao;   
    private Notification entity;
    private List<Notification> notificationList;

    public NotificationController() {
super(Notification.class);
    }

    public AbstractDAO getNotificationDao() {
       if (this.notificationDao == null) {
            this.notificationDao = new NotificationDAO();
        }
        return notificationDao;
    }

    public void setNotificationDao(NotificationDAO notificationDao) {
        this.notificationDao = notificationDao;
    }

    public Notification getEntity() {
        if (entity == null) {
            entity = new Notification();
        }
        return entity;
    }

    public void setEntity(Notification entity) {
        this.entity = entity;
    }

    public List<Notification> getNotificationList() {
        this.notificationList = this.getNotificationDao().GetList();
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public void AddEntity() {
        getNotificationDao().Create(this.entity);
        this.entity = new Notification();

    }

    @Override
    public Notification GetEntityById(int id) {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.GetById(id);
        return null;
    }

    @Override
    public List<Notification> GetEntityList() {
        return getNotificationDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getNotificationDao().Update(entity);
        this.entity = new Notification();
    }

    @Override
    public void DeleteEntity() {
        notificationDao.Delete(entity);
        this.entity = new Notification();
    }

}

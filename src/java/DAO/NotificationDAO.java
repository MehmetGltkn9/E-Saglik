package DAO;

import Entity.Notification;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class NotificationDAO extends AbstractDAO<Notification> implements Serializable {

    public NotificationDAO() {
        super(Notification.class);
    }

}

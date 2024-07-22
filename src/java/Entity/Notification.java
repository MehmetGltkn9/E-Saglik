package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notification")
@NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
public class Notification extends BaseEntity implements Serializable {

    @Column(name = "message")
    private String message;

    @Column(name = "notification_date")
    private Date notificationDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Notification() {

    }

    public Notification(String message, Date notificationDate, Patient patient, int id, String name) {
        super(id, name);
        this.message = message;
        this.notificationDate = notificationDate;
        this.patient = patient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    @Override
    public String toString() {
        return "Notification{"
                + "id=" + getId()
                + ", name='" + getName() + '\''
                + ", message='" + message + '\''
                + ", notificationDate=" + notificationDate
                + '}';
    }
}

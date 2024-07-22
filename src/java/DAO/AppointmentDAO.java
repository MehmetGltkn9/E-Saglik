package DAO;

import Entity.Appointment;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;


@Local
@Stateless
public class AppointmentDAO extends AbstractDAO<Appointment> implements Serializable {

    public AppointmentDAO() {
        super(Appointment.class);
    }

}
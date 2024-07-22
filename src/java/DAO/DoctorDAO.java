package DAO;

import Entity.Doctor;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class DoctorDAO extends AbstractDAO<Doctor> implements Serializable {

    public DoctorDAO() {
        super(Doctor.class);
    }
    
}

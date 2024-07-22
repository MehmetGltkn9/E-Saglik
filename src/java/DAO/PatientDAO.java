package DAO;

import Entity.Patient;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class PatientDAO extends AbstractDAO<Patient> implements Serializable {

    public PatientDAO() {
        super(Patient.class);
    }

}

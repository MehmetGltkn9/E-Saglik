package DAO;

import Entity.Medication;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class MedicationDAO extends AbstractDAO<Medication> implements Serializable {

    public MedicationDAO() {
        super(Medication.class);
    }

}

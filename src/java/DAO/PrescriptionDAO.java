package DAO;

import Entity.Prescription;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class PrescriptionDAO extends AbstractDAO<Prescription> implements Serializable {

    public PrescriptionDAO() {
        super(Prescription.class);
    }
    
}

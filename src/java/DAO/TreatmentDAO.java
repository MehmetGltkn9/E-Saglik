package DAO;

import Entity.Treatment;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class TreatmentDAO extends AbstractDAO<Treatment> implements Serializable {

    public TreatmentDAO() {
        super(Treatment.class);
    }

}
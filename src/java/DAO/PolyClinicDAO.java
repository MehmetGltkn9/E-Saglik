package DAO;

import Entity.PolyClinic;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class PolyClinicDAO extends AbstractDAO<PolyClinic> implements Serializable {

    public PolyClinicDAO() {
        super(PolyClinic.class);
    }

}

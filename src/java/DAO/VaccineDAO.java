package DAO;

import Entity.Vaccine;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class VaccineDAO extends AbstractDAO<Vaccine> implements Serializable {

    public VaccineDAO() {
        super(Vaccine.class);
    }

}

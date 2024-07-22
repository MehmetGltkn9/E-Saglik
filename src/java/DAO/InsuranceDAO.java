package DAO;

import Entity.Insurance;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class InsuranceDAO extends AbstractDAO<Insurance> implements Serializable {

    public InsuranceDAO() {
        super(Insurance.class);
    }

}

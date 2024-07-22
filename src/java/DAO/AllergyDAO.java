package DAO;

import Entity.Allergy;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class AllergyDAO extends AbstractDAO<Allergy> implements Serializable {

    public AllergyDAO() {
        super(Allergy.class);
    }

}

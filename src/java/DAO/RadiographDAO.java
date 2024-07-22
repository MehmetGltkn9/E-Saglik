package DAO;

import Entity.Radiograph;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class RadiographDAO extends AbstractDAO<Radiograph> implements Serializable {

    public RadiographDAO() {
        super(Radiograph.class);
    }

}

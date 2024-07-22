package DAO;

import Entity.PathologyInformation;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;


@Local
@Stateless
public class PathologyInformationDAO extends AbstractDAO<PathologyInformation> implements Serializable {

    public PathologyInformationDAO() {
        super(PathologyInformation.class);
    }

}

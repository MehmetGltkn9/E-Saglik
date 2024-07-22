package DAO;

import Entity.Admin;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class AdminDAO extends AbstractDAO<Admin> implements Serializable {

    public AdminDAO() {
        super(Admin.class);
    }

}

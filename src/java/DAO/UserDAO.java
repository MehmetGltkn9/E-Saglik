package DAO;

import Entity.User;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

import java.io.Serializable;

@Local
@Stateless
public class UserDAO extends AbstractDAO<User> implements Serializable {

    public UserDAO() {
        super(User.class);
    }

}
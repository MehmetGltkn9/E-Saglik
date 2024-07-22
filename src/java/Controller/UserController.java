package Controller;

import DAO.UserDAO;
import Entity.User;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserController extends BaseController<User> implements Serializable {

    @EJB
    private UserDAO userDao;   
    private User entity;
    private List<User> userList;

    public UserController() {
        super(User.class);
    }

    public String login() {
        if (getEntity().getEmail().equals("mrefearic@gmail.com") && getEntity().getPassword().equals("12345678")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.entity);
            return "/index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre"));
            return "/login";
        }
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User getEntity() {
        if (this.entity == null) {
            this.entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

     @Override
    public User GetEntityById(int id) {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.GetById(id);
        return null;
    }

    @Override
    public List<User> GetEntityList() {
        return getUserDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getUserDao().Update(entity);
        this.entity = new User();
    }

    @Override
    public void DeleteEntity() {     
        getUserDao().Delete(entity);
        this.entity = new User();
    }

    @Override
    public void AddEntity() {    
        getUserDao().Create(entity);
        this.entity = new User();
    }
}

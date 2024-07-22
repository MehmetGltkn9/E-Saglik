
package Controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class NavigationController implements Serializable{
    
    public String userPage(String p){
        return "/pages/user/"+p+"?faces-redirect=true";
    }
    
    public String adminPage(String p){
        return "/pages/admin/"+p+"?faces-redirect=true";
    }
    
    public String doctorPage(String p){
        return "/pages/doctor/"+p+"?faces-redirect=true";
    }
    
    public String page(String p){
        return "/"+p+"?faces-redirect=true";
    }
}

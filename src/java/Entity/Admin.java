package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
public class Admin extends BaseEntity implements Serializable {

    @Column(name = "authorization_level")
    private String authorizationLevel;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    public Admin() {
    }

    public Admin(String authorizationLevel, int id, String name, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address) {
        super(id, name);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.authorizationLevel = authorizationLevel;
    }

    public void addDoctor() {
        // Implementasyon
    }

    public void addPatient() {
        // Implementasyon
    }

    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void setAuthorizationLevel(String authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    @Override
    public String toString() {
        return "Admin{" + "authorizationLevel=" + authorizationLevel + ", " + super.toString() + '}';
    }
}

package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Pharmacy")
@NamedQuery(name = "Pharmacy.findAll", query = "SELECT p FROM Pharmacy p")
public class Pharmacy extends BaseEntity implements Serializable {
    @Column(name = "location")
    private String location;

    public Pharmacy() {
        
    }

    public Pharmacy(String location, int id, String name) {
        super(id, name);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

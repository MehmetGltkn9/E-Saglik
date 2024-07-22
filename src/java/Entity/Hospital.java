package Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hospital")
@NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h")
public class Hospital extends BaseEntity implements Serializable {
    @Column(name = "location")
    private String location;

    @Column(name = "capacity")
    private String capacity;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "Hospital_PolyClinic",
        joinColumns = @JoinColumn(name = "hospital_id"),
        inverseJoinColumns = @JoinColumn(name = "polyclinic_id")
    )
    private List<PolyClinic> polyClinics;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "Hospital_Doctor",
        joinColumns = @JoinColumn(name = "hospital_id"),
        inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;

    public Hospital() {
    
    }

    public Hospital(String location, String capacity, List<PolyClinic> polyClinics, List<Doctor> doctors, int id, String name) {
        super(id, name);
        this.location = location;
        this.capacity = capacity;
        this.polyClinics = polyClinics;
        this.doctors = doctors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public List<PolyClinic> getPolyClinics() {
        return polyClinics;
    }

    public void setPolyClinics(List<PolyClinic> polyClinics) {
        this.polyClinics = polyClinics;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", location='" + location + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}

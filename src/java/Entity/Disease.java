package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "disease")
@NamedQuery(name = "Disease.findAll", query = "SELECT d FROM Disease d")
public class Disease extends BaseEntity implements Serializable {

    @Column(name = "description")
    private String description;


    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Disease() {
    }

    public Disease(String description, Patient patient, int id, String name) {
        super(id, name);
        this.description = description;
        this.patient = patient;
    }

    public Disease(String description, Patient patient) {
        this.description = description;
        this.patient = patient;
    }

    public Disease(String description, Patient patient, String name) {
        super(name);
        this.description = description;
        this.patient = patient;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Disease{" + "description=" + description + ", patient=" + patient + '}';
    }
    
    
}

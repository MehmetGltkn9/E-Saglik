package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pathologyinformation")
@NamedQuery(name = "PathologyInformation.findAll", query = "SELECT p FROM PathologyInformation p")
public class PathologyInformation extends BaseEntity implements Serializable {
    
    @Column(name = "informationdate")
    private Date informationDate;

    @Column(name = "information")
    private String information;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    public PathologyInformation() {
    
    }

    public Date getInformationDate() {
        return informationDate;
    }

    public void setInformationDate(Date informationDate) {
        this.informationDate = informationDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Patient getPatient() {
        if(patient == null){
            patient = new Patient();
        }
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    

    @Override
    public String toString() {
        return "PathologyInformation{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", informationDate=" + informationDate +
                ", information='" + information + '\'' +
                '}';
    }
}

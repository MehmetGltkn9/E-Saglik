package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "insurance")
@NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i")
public class Insurance extends BaseEntity implements Serializable{
    
    @Column(name = "provider")
    private String provider;

    @Column(name = "coverage_details")
    private String coverageDetails;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Insurance() {
    
    }

    public Insurance(String provider, String coverageDetails, Patient patient, int id, String name) {
        super(id, name);
        this.provider = provider;
        this.coverageDetails = coverageDetails;
        this.patient = patient;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", provider='" + provider + '\'' +
                ", coverageDetails='" + coverageDetails + '\'' +
                ", patient=" + patient +
                '}';
    }
}

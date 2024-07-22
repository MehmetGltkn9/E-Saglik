package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "treatments")
@NamedQuery(name = "Treatment.findAll", query = "SELECT t FROM Treatment t")
public class Treatment extends BaseEntity implements Serializable {
    
    @NotNull(message = "Start date is mandatory")
    @PastOrPresent(message = "Start date must be in the past or present")
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startdate;

    @NotNull(message = "End date is mandatory")
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description;
    
    @NotNull(message = "Patient is mandatory")
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Treatment() {
    }

    public Treatment(Date startdate, Date endDate, String description, int id, String name) {
        super(id, name);
        this.startdate = startdate;
        this.endDate = endDate;
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        return "Treatment{" + "startdate=" + startdate + ", endDate=" + endDate + ", description=" + description + '}';
    }
}

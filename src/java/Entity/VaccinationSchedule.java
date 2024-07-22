package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vaccinationschedule")
@NamedQuery(name = "VaccinationSchedule.findAll", query = "SELECT t FROM VaccinationSchedule t")
public class VaccinationSchedule extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;

    public VaccinationSchedule() {
    }

    public VaccinationSchedule(Vaccine vaccineName, Date dueDate, int id, String name) {
        super(id, name);
        this.vaccine = vaccineName;
        this.dueDate = dueDate;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "VaccinationSchedule{" + "vaccineName=" + vaccine + ", dueDate=" + dueDate + '}';
    }
}

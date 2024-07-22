package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "appointment_time")
    private LocalTime appointmentTime;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "polyclinic_id")
    private PolyClinic polyClinic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Appointment() {
    }

    public Appointment(Date appointmentDate, LocalTime appointmentTime, String status, PolyClinic polyClinic, Patient patient, int id, String name) {
        super(id, name);
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.polyClinic = polyClinic;
        this.patient = patient;
    }

    public void confirmAppointment() {
        // Implementasyon
    }

    public void rescheduleAppointment() {
        // Implementasyon
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PolyClinic getPolyClinic() {
        return polyClinic;
    }

    public void setPolyClinic(PolyClinic polyClinic) {
        this.polyClinic = polyClinic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "appointmentDate=" + appointmentDate +
            ", appointmentTime=" + appointmentTime +
            ", status='" + status + '\'' +
            ", polyClinic=" + polyClinic +
            ", patient=" + patient +
            '}';
    }
}

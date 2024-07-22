package Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PolyClinic")
@NamedQuery(name = "PolyClinic.findAll", query = "SELECT p FROM PolyClinic p")
public class PolyClinic extends BaseEntity {
    @Column(name = "location")
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "polyClinic")
    private List<Appointment> appointments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "PolyClinic_Doctor",
            joinColumns = @JoinColumn(name = "polyclinic_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;

    public PolyClinic() {
        appointments = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public PolyClinic(int id, String name) {
        super(id, name);
        appointments = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public PolyClinic(String location, List<Appointment> appointments, List<Doctor> doctors, int id, String name) {
        super(id, name);
        this.location = location;
        this.appointments = appointments;
        this.doctors = doctors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        appointment.setPolyClinic(this); // Update the bidirectional relationship
    }

    public void removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
        appointment.setPolyClinic(null); // Update the bidirectional relationship
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Appointment findAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Polyclinic{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", location='" + location + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}

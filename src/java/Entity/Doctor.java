package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "doctor")
@NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
public class Doctor extends BaseEntity implements Serializable {
    
    @Column(name = "specialization")
    private String specialization;

    @Column(name = "hospital")
    private String hospital;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "appointment")
    private String appointment;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientList;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    public Doctor() {
        // Default constructor
    }

    public Doctor(String specialization, String hospital, String prescription, String appointment, int id, String name, String email, String gender, String lastName, String firstName) {        
        super(id,name);
        this.specialization = specialization;
        this.hospital = hospital;
        this.prescription = prescription;
        this.appointment = appointment;
        this.email = email;
        this.gender = gender;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    

    @Override
    public String toString() {
        return "Doctor{" +
                ", specialization='" + specialization + '\'' +
                ", hospital='" + hospital + '\'' +
                ", prescription='" + prescription + '\'' +
                ", appointment='" + appointment + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}

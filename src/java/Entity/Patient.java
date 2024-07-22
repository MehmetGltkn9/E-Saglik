package Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Patient")
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
@NamedQuery(name = "findByID", query = "select c from Patient c where c.id=:id")
public class Patient extends BaseEntity implements Serializable {

    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "bloodtype")
    private String bloodType;

    @Column(name = "appointment")
    private String appointment;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Medication> medicationList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalReport> medicalReportList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<TestResult> testResultList;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Disease> diseaseList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Allergy> allergyList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance")
    private Insurance insurance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaccinationschedule")
    private VaccinationSchedule vaccinationSchedule;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Treatment> treatmentList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Payment> paymentList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Notification> notificationList;

    public Patient() {
    }

    public Patient(Date dateOfBirth, String bloodType, String appointment, List<Medication> medicationList, List<MedicalReport> medicalReportList, List<TestResult> testResultList, Doctor doctor, List<Disease> diseaseList, List<Allergy> allergyList, Insurance insurance, VaccinationSchedule vaccinationSchedule, List<Treatment> treatmentList, List<Payment> paymentList, List<Notification> notificationList) {
        this.dateOfBirth = dateOfBirth;
        this.bloodType = bloodType;
        this.appointment = appointment;
        this.medicationList = medicationList;
        this.medicalReportList = medicalReportList;
        this.testResultList = testResultList;
        this.doctor = doctor;
        this.diseaseList = diseaseList;
        this.allergyList = allergyList;
        this.insurance = insurance;
        this.vaccinationSchedule = vaccinationSchedule;
        this.treatmentList = treatmentList;
        this.paymentList = paymentList;
        this.notificationList = notificationList;
    }

    // Getters and setters

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public List<MedicalReport> getMedicalReportList() {
        return medicalReportList;
    }

    public void setMedicalReportList(List<MedicalReport> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    public List<TestResult> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<TestResult> testResultList) {
        this.testResultList = testResultList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public List<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public VaccinationSchedule getVaccinationSchedule() {
        return vaccinationSchedule;
    }

    public void setVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        this.vaccinationSchedule = vaccinationSchedule;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }
}

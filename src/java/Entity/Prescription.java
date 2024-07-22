package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "prescriptions")
@NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p")
public class Prescription extends BaseEntity implements Serializable {

    @Column(name = "dosage")
    private String dosage;

    @OneToMany(mappedBy = "prescription", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medication> medicationList;

    @Column(name = "instructions")
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
   
    public Prescription() {
    }

    public Prescription(String dosage, List<Medication> medicationList, String instructions, int id, String name) {
        super(id, name);
        this.dosage = dosage;
        this.medicationList = medicationList;
        this.instructions = instructions;
    }

    public Patient getPatient() {
        if (patient == null) {
            patient = new Patient();
        }
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Prescription{" + "dosage=" + dosage + ", medicationList=" + medicationList + ", instructions=" + instructions + '}';
    }
}

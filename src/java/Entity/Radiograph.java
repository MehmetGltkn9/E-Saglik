package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "radiographs")
@NamedQuery(name = "Radiograph.findAll", query = "SELECT r FROM Radiograph r")
public class Radiograph extends BaseEntity implements Serializable {

    @Temporal(TemporalType.DATE)
    @Column(name = "rg_date")
    private Date RGDate;

    @Column(name = "image", insertable = false, updatable = false)
    private File image;
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Radiograph() {
    }

    public Date getRGDate() {
        return RGDate;
    }

    public void setRGDate(Date RGDate) {
        this.RGDate = RGDate;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
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
        return "Radiograph{" + "RGDate=" + RGDate + ", image=" + image + '}';
    }
}

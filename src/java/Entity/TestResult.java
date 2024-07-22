package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "test_results")
@NamedQuery(name = "TestResult.findAll", query = "SELECT r FROM TestResult r")
public class TestResult extends BaseEntity implements Serializable {

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "test_type")
    private String testType;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_normal_value")
    private String testNormalValue;

    @Column(name = "test_value")
    private String testValue;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public TestResult() {
    }

    public TestResult(Date date, String testType, String testName, String testNormalValue, String testValue, int id, String name) {
        super(id, name);
        this.date = date;
        this.testType = testType;
        this.testName = testName;
        this.testNormalValue = testNormalValue;
        this.testValue = testValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestNormalValue() {
        return testNormalValue;
    }

    public void setTestNormalValue(String testNormalValue) {
        this.testNormalValue = testNormalValue;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
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
        return "TestResult{" + "date=" + date + ", testType=" + testType + ", testName=" + testName + ", testNormalValue=" + testNormalValue + ", testValue=" + testValue + '}';
    }
}

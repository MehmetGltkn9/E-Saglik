package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "donation")
@NamedQuery(name = "Donation.findAll", query = "SELECT d FROM Donation d")
public class Donation extends BaseEntity implements Serializable {

    @Column(name = "donation_type")
    private String donationType;
    
    @Column(name = "donor_name")
    private String donorName;
    
    @Column(name = "donation_date")
    private Date donationDate;

    public Donation() {

    }

    public Donation(String donationType, String donorName, Date donationDate, int id, String name) {
        super(id, name);
        this.donationType = donationType;
        this.donorName = donorName;
        this.donationDate = donationDate;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public String toString() {
        return "Donation{"
                + "donationType='" + donationType + '\''
                + ", donorName='" + donorName + '\''
                + ", donationDate=" + donationDate
                + '}';
    }
}

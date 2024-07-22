package DAO;

import Entity.Donation;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class DonationDAO extends AbstractDAO<Donation> implements Serializable {

    public DonationDAO() {
        super(Donation.class);
    }

}

package DAO;

import Entity.Pharmacy;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class PharmacyDAO extends AbstractDAO<Pharmacy> implements Serializable {

    public PharmacyDAO() {
        super(Pharmacy.class);
    }

}
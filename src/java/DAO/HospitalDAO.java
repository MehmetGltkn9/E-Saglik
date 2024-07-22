package DAO;

import Entity.Hospital;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;


@Local
@Stateless
public class HospitalDAO extends AbstractDAO<Hospital> implements Serializable {

    public HospitalDAO() {
        super(Hospital.class);
    }

}
package DAO;

import Entity.VaccinationSchedule;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class VaccinationScheduleDAO extends AbstractDAO<VaccinationSchedule> implements Serializable {

    public VaccinationScheduleDAO() {
        super(VaccinationSchedule.class);
    }

}

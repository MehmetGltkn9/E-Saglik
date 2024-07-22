package DAO;

import Entity.MedicalReport;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;


@Local
@Stateless
public class MedicalReportDAO extends AbstractDAO<MedicalReport> implements Serializable {

    public MedicalReportDAO() {
        super(MedicalReport.class);
    }

}

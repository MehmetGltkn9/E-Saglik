package Converter;

import DAO.PatientDAO;
import Entity.Patient;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
@FacesConverter(value = "patientConverter", managed = true)
public class PatientConverter implements Converter<Patient>, Serializable {

    @EJB
    private PatientDAO dao;

    @Override
    public Patient getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        try {
            int id = Integer.parseInt(string);
            return dao.GetById(id); // Assuming dao.getById(id) retrieves the Patient entity from the database
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format");
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Patient patient) {
        if (patient == null) {
            return null;
        }
        return String.valueOf(patient.getId()); // Assuming Patient has a getId() method returning its unique identifier
    }
}

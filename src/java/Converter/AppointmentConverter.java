package Converter;

import Entity.Appointment;
import Entity.PolyClinic;
import Entity.Patient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppointmentConverter extends BaseConverter<Appointment> {

    public AppointmentConverter() {
        super();
    }

    @Override
    public String ConvertToString(Appointment appointment) {
        return "Appointment{" +
            "id=" + appointment.getId() +
            ", name='" + appointment.getName() + '\'' +
            ", appointmentDate='" + appointment.getAppointmentDate() + '\'' +
            ", appointmentTime='" + appointment.getAppointmentTime() + '\'' +
            ", status='" + appointment.getStatus() + '\'' +
            ", polyClinicLocation='" + appointment.getPolyClinic().getLocation() + '\'' +
            ", polyClinicId='" + appointment.getPolyClinic().getId() + '\'' +
            ", polyClinicName='" + appointment.getPolyClinic().getName() + '\'' +
            '}';
    }

    @Override
    public Appointment ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        Date appointmentDate = null;
        LocalTime appointmentTime = null;
        String status = null;
        PolyClinic polyClinic = null;
        Patient patient = null;

        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            id = Integer.parseInt(matcher.group(1));
        } else {
            System.out.println("ID not found.");
        }

        String polyClinicLocation = null;
        int polyClinicId = 0;
        String polyClinicName = null;

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1].replace("'", "");
                switch (key) {
                    case "name":
                        name = value;
                        break;
                    case "appointmentDate":
                        try {
                            appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        } catch (ParseException ex) {
                            Logger.getLogger(AppointmentConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "appointmentTime":
                        appointmentTime = LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm:ss"));
                        break;
                    case "status":
                        status = value;
                        break;
                    case "polyClinicLocation":
                        polyClinicLocation = value;
                        break;
                    case "polyClinicId":
                        polyClinicId = Integer.parseInt(value);
                        break;
                    case "polyClinicName":
                        polyClinicName = value;
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }

        if (polyClinicLocation != null && polyClinicId != 0) {
            polyClinic = new PolyClinic(polyClinicLocation, new ArrayList<>(), new ArrayList<>(), polyClinicId, polyClinicName);
        }

        return new Appointment(appointmentDate, appointmentTime, status, polyClinic, patient, id, name);
    }
}

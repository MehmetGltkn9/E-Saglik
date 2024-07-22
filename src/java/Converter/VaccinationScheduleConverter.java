package Converter;

import Entity.VaccinationSchedule;
import Entity.Vaccine;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VaccinationScheduleConverter extends BaseConverter<VaccinationSchedule> {

    public VaccinationScheduleConverter() {
        super();
    }

   @Override
    public String ConvertToString(VaccinationSchedule schedule) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "VaccinationSchedule{" +
            "id=" + schedule.getId() +
            ", name='" + schedule.getName() + '\'' +
            ", vaccineName='" + schedule.getVaccine().getName() + '\'' +
            ", dueDate='" + dateFormat.format(schedule.getDueDate()) + '\'' +
            '}';
    }

    @Override
    public VaccinationSchedule ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        Vaccine vaccineName = null;
        Date dueDate = null;

        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            id = Integer.parseInt(matcher.group(1)); 
        } else {
            System.out.println("ID not found.");
        }

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
                    case "vaccineName":
                        
                        break;
                    case "dueDate":
                    {
                        try {
                            dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        } catch (ParseException ex) {
                            Logger.getLogger(VaccinationScheduleConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    default:
                        
                        break;
                }
            }
        }
        return new VaccinationSchedule(vaccineName, dueDate, id, name);
    }

}

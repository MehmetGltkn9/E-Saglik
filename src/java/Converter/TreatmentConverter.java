package Converter;

import Entity.Radiograph;
import Entity.Treatment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreatmentConverter extends BaseConverter<Treatment> {

    public TreatmentConverter() {
        super();
    }

    @Override
    public String ConvertToString(Treatment treatment) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Treatment{" +
            "id=" + treatment.getId() +
            ", name='" + treatment.getName() + '\'' +
            ", startdate='" + dateFormat.format(treatment.getStartdate()) + '\'' +
            ", endDate='" + dateFormat.format(treatment.getEndDate()) + '\'' +
            ", description='" + treatment.getDescription() + '\'' +
            '}';
    }

    @Override
    public Treatment ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        Date startdate = null;
        Date endDate = null;
        String description = null;

        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            id = Integer.parseInt(matcher.group(1)); // Grup 1, parantez içindeki ifadeyi temsil eder
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1].replace("'", ""); // Single quotes'ı kaldır
                switch (key) {
                    case "name":
                        name = value;
                        break;
                    case "startdate":
                    {
                        try {
                            startdate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        } catch (ParseException ex) {
                            Logger.getLogger(TreatmentConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    case "endDate":
                    {
                        try {
                            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        } catch (ParseException ex) {
                            Logger.getLogger(TreatmentConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    case "description":
                        description = value;
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return new Treatment(startdate, endDate, description, id, name);
    }

}

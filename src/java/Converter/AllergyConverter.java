package Converter;

import Entity.Allergy;
import Entity.Doctor;
import Entity.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllergyConverter extends BaseConverter<Allergy> {

    public AllergyConverter() {
        super();
    }

    @Override
    public String ConvertToString(Allergy allergy) {
        return "Allergy{"
                + "id=" + allergy.getId()
                + ", name='" + allergy.getName() + '\''
                + ", type='" + allergy.getType() + '\''
                + ", severity=" + allergy.getSeverity()
                + '}';
    }

    @Override
    public Allergy ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Allergy allergy = new Allergy();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            allergy.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1].replace("'", ""); // Remove single quotes
                switch (key) {
                    case "name":
                        allergy.setName(value);
                        break;
                    case "type":
                        allergy.setType(value);
                        break;
                    case "severity":
                        allergy.setSeverity(Integer.parseInt(value));
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return allergy;
    }

}

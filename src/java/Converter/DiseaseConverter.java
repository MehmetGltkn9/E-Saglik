package Converter;

import Entity.Allergy;
import Entity.Disease;
import Entity.Doctor;
import Entity.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiseaseConverter extends BaseConverter<Disease> {

    public DiseaseConverter() {
        super();
    }

    @Override
     public String ConvertToString(Disease disease) {
        return "Disease{" +
                "id=" + disease.getId() +
                ", name='" + disease.getName() + '\'' +
                ", description='" + disease.getDescription() + '\'' +
                '}';
    }

    @Override
    public Disease ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Disease disease = new Disease();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            disease.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1].replace("'", ""); // Remove single quotes from value
                switch (key) {
                    case "name":
                        disease.setName(value);
                        break;
                    case "description":
                        disease.setDescription(value);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return disease;
    }

}

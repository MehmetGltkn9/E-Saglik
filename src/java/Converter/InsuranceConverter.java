package Converter;

import Entity.Insurance;
import Entity.Patient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsuranceConverter extends BaseConverter<Insurance> {

    public InsuranceConverter() {
        super();
    }
    
    @Override
    public String ConvertToString(Insurance insurance) {
        return "Insurance{" +
            "id=" + insurance.getId() +
            ", name='" + insurance.getName() + '\'' +
            ", provider='" + insurance.getProvider() + '\'' +
            ", coverageDetails='" + insurance.getCoverageDetails() + '\'' +
            '}';
    }

    @Override
    public Insurance ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        String provider = null;
        String coverageDetails = null;
        Patient patient = null; // Added patient variable

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
                    case "provider":
                        provider = value;
                        break;
                    case "coverageDetails":
                        coverageDetails = value;
                        break;
                    default:
                       
                        break;
                }
            }
        }
        return new Insurance(provider, coverageDetails, patient, id, name); // Updated to include patient
    }

}

package Converter;

import Entity.Admin;
import Entity.Hospital;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HospitalConverter extends BaseConverter<Hospital> {

    public HospitalConverter() {
        super();
    }

    @Override
    public String ConvertToString(Hospital hospital) {
        return "Hospital{"
                + "id=" + hospital.getId()
                + ", name='" + hospital.getName() + '\''
                + ", location='" + hospital.getLocation() + '\''
                + ", capacity='" + hospital.getCapacity() + '\''
                + '}';
    }

    @Override
    public Hospital ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Hospital hospital = new Hospital();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1);
            hospital.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1].replaceAll("[{}']", "").trim();
                switch (key) {
                    case "name":
                        hospital.setName(value);
                        break;
                    case "location":
                        hospital.setLocation(value);
                        break;
                    case "capacity":
                        hospital.setCapacity(value);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return hospital;
    }
}

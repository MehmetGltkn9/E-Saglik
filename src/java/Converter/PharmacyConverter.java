package Converter;

import Entity.Admin;
import Entity.Pharmacy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PharmacyConverter extends BaseConverter<Pharmacy> {

    public PharmacyConverter() {
        super();
    }

    @Override
    public String ConvertToString(Pharmacy pharmacy) {
        return "Pharmacy{"
                + "id=" + pharmacy.getId()
                + ", name='" + pharmacy.getName() + '\''
                + ", location='" + pharmacy.getLocation() + '\''
                + '}';
    }

    @Override
    public Pharmacy ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Pharmacy pharmacy = new Pharmacy(null, 0, null);
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1);
            pharmacy.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].replace("'", "").trim();
                switch (key) {
                    case "name":
                        pharmacy.setName(value);
                        break;
                    case "location":
                        pharmacy.setLocation(value);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return pharmacy;
    }

}

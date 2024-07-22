package Converter;

import Entity.Admin;
import Entity.Vaccine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VaccineConverter extends BaseConverter<Vaccine> {

    public VaccineConverter() {
        super();
    }

    @Override
    public String ConvertToString(Vaccine vaccine) {
        return "Vaccine{"
                + "type='" + vaccine.getType() + '\''
                + ", id=" + vaccine.getId()
                + ", name='" + vaccine.getName() + '\''
                + '}';
    }

    @Override
    public Vaccine ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Vaccine vaccine = null;
        String type = null;
        int id = 0;
        String name = null;

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                switch (key) {
                    case "type":
                        type = value;
                        break;
                    case "id":
                        id = Integer.parseInt(value);
                        break;
                    case "name":
                        name = value;
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }

        vaccine = new Vaccine(type, id, name);
        return vaccine;
    }

}

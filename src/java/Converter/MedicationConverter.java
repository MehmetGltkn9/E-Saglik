package Converter;
import Entity.Medication;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicationConverter extends BaseConverter<Medication> {

    public MedicationConverter() {
        super();
    }
    
    @Override
    public String ConvertToString(Medication medication) {
        return "Medication{" +
            "id=" + medication.getId() +
            ", name='" + medication.getName() + '\'' +
            ", dosage='" + medication.getDosage() + '\'' +
            '}';
    }

    @Override
    public Medication ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        String dosage = null;

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
                String value = keyValue[1].replace("'", "");
                switch (key) {
                    case "name":
                        name = value;
                        break;
                    case "dosage":
                        dosage = value;
                        break;
                    default:
                        
                        break;
                }
            }
        }
        return new Medication();
    }
}

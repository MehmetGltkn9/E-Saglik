package Converter;

import Entity.Radiograph;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RadiographConverter extends BaseConverter<Radiograph> {

    public RadiographConverter() {
        super();
    }

    @Override
    public String ConvertToString(Radiograph radiograph) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Radiograph{" +
            "id=" + radiograph.getId() +
            ", name='" + radiograph.getName() + '\'' +
            ", RGDate='" + dateFormat.format(radiograph.getRGDate()) + '\'' +
            ", image='" + radiograph.getImage() + '\'' +
            '}';
    }

    @Override
    public Radiograph ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        Date RGDate = null;
        String image = null;

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
                    case "RGDate":
                    {
                        try {
                            RGDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        } catch (ParseException ex) {
                            Logger.getLogger(RadiographConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    case "image":
                        image = value;
                        break;
                    default:
                        
                        break;
                }
            }
        }
        return new Radiograph();
    }

}

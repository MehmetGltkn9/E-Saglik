package Converter;
import Entity.PathologyInformation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathologyInformationConverter extends BaseConverter<PathologyInformation> {

    public PathologyInformationConverter() {
        super();
    }
    
    @Override
    public String ConvertToString(PathologyInformation pathologyInformation) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "PathologyInformation{" +
            "id=" + pathologyInformation.getId() +
            ", name='" + pathologyInformation.getName() + '\'' +
            ", informationDate='" + dateFormat.format(pathologyInformation.getInformationDate()) + '\'' +
            ", information='" + pathologyInformation.getInformation() + '\'' +
            '}';
    }

    @Override
    public PathologyInformation ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        Date informationDate = null;
        String information = null;

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
                    case "informationDate":
                    {
                        try {
                            informationDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        }
                        catch (ParseException ex) {
                            Logger.getLogger(PathologyInformationConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    case "information":
                        information = value;
                        break;
                    default:
                        
                        break;
                }
            }
        }
        return new PathologyInformation();
    }
}
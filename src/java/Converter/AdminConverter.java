package Converter;
import Entity.Admin; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminConverter extends BaseConverter<Admin> {

    public AdminConverter() {
        super();
    }

    @Override
    public String ConvertToString(Admin admin) {
        return "Admin{" +
            "id=" + admin.getId() +
            ", name='" + admin.getName() + '\'' +
//            ", firstName='" + admin.getFirstName() + '\'' +
//            ", lastName='" + admin.getLastName() + '\'' +
//            ", email='" + admin.getEmail() + '\'' +
//            ", password='" + admin.getPassword() + '\'' +
//            ", gender='" + admin.getGender() + '\'' +
//            ", phoneNumber='" + admin.getPhoneNumber() + '\'' +
//            ", address='" + admin.getAddress() + '\'' +
            ", authorizationLevel='" + admin.getAuthorizationLevel() + '\'' +
            '}';
    }

    @Override
    public Admin ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Admin admin = new Admin();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            admin.setId(Integer.parseInt(idString));
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
                        admin.setName(value);
                        break;
////                    case "firstName":
////                        admin.setFirstName(value);
////                        break;
////                    case "lastName":
////                        admin.setLastName(value);
////                        break;
////                    case "email":
////                        admin.setEmail(value);
////                        break;
////                    case "password":
////                        admin.setPassword(value);
////                        break;
////                    case "gender":
////                        admin.setGender(value);
////                        break;
////                    case "phoneNumber":
////                        admin.setPhoneNumber(value);
////                        break;
////                    case "address":
////                        admin.setAddress(value);
//                        break;
                    case "authorizationLevel":
                        admin.setAuthorizationLevel(value);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return admin;
    }
    
   




}

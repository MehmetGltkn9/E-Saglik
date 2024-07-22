package Converter;

import Entity.Admin;
import Entity.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserConverter extends BaseConverter<User> {

    public UserConverter() {
        super();
    }

    @Override
    public String ConvertToString(User user) {
        return "User{"
                + "id=" + user.getId()
                + ", name='" + user.getName() + '\''
                + ", firstName='" + user.getFirstName() + '\''
                + ", lastName='" + user.getLastName() + '\''
                + ", email='" + user.getEmail() + '\''
                + ", password='" + user.getPassword() + '\''
                + ", gender='" + user.getGender() + '\''
                + ", phoneNumber='" + user.getPhoneNumber() + '\''
                + ", address='" + user.getAddress() + '\''
                + '}';
    }

    @Override
    public User ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        User user = new User();

        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            user.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                switch (key) {
                    case "name":
                        user.setName(value);
                        break;
                    case "firstName":
                        user.setFirstName(value);
                        break;
                    case "lastName":
                        user.setLastName(value);
                        break;
                    case "email":
                        user.setEmail(value);
                        break;
                    case "password":
                        user.setPassword(value);
                        break;
                    case "gender":
                        user.setGender(value);
                        break;
                    case "phoneNumber":
                        user.setPhoneNumber(value);
                        break;
                    case "address":
                        user.setAddress(value);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }

        return user;
    }

}

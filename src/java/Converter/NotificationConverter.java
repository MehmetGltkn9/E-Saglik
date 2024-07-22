package Converter;

import Entity.Notification;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificationConverter extends BaseConverter<Notification> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public NotificationConverter() {
        super();
    }

    @Override
    public String ConvertToString(Notification notification) {
        return "Notification{"
                + "id=" + notification.getId()
                + ", name='" + notification.getName() + '\''
                + ", massage='" + notification.getMessage() + '\''
                + ", notificationDate='" + new SimpleDateFormat("yyyy-MM-dd").format(notification.getNotificationDate()) + '\''
                + '}';
    }

    @Override
    public Notification ConvertToEntity(String string) {
        Notification notification = new Notification();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1);
            notification.setId(Integer.parseInt(idString));
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
                        notification.setName(value);
                        break;
                    case "message":
                        notification.setMessage(value);
                        break;
                    case "notificationDate": {
                        try {
                            notification.setNotificationDate(DATE_FORMAT.parse(value));
                        } catch (ParseException ex) {
                            Logger.getLogger(NotificationConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    default:
                        break;
                }
            }
        }
        return notification;
    }
}

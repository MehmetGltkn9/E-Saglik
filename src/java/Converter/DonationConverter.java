package Converter;
import Entity.Donation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DonationConverter extends BaseConverter<Donation> {

    public DonationConverter() {
        super();
    }
   
    @Override
    public String ConvertToString(Donation donation) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Donation{" +
            "id=" + donation.getId() +
            ", name='" + donation.getName() + '\'' +
            ", donationType='" + donation.getDonationType() + '\'' +
            ", donorName='" + donation.getDonorName() + '\'' +
            ", donationDate='" + dateFormat.format(donation.getDonationDate()) + '\'' +
            '}';
    }

    @Override
    public Donation ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        int id = 0;
        String name = null;
        String donationType = null;
        String donorName = null;
        Date donationDate = null;

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
                    case "donationType":
                        donationType = value;
                        break;
                    case "donorName":
                        donorName = value;
                        break;
                    case "donationDate":
                    {
                        try {
                            donationDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                        } catch (ParseException ex) {
                            Logger.getLogger(DonationConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    default:
                        
                        break;
                }
            }
        }
        return new Donation(donationType, donorName, donationDate, id, name);
    }

}

package Converter;

import Entity.Admin;
import Entity.Payment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentConverter extends BaseConverter<Payment> {

    public PaymentConverter() {
        super();
    }

    @Override
    public String ConvertToString(Payment payment) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return "Payment{"
                + "id=" + payment.getId()
                + ", name='" + payment.getName() + '\''
                + ", paymentAmount=" + payment.getPaymentAmount()
                + ", paymentDate='" + dateFormat.format(payment.getPaymentDate()) + '\''
                + '}';
    }

    @Override
    public Payment ConvertToEntity(String string) throws IllegalAccessException, InstantiationException{
        Payment payment = new Payment();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1);
            payment.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim().replace("'", "");
                switch (key) {
                    case "name":
                        payment.setName(value);
                        break;
                    case "paymentAmount":
                        payment.setPaymentAmount(Double.parseDouble(value));
                        break;
                    case "paymentDate":
                    {
                        try {
                            payment.setPaymentDate(dateFormat.parse(value));
                        } catch (ParseException ex) {
                            Logger.getLogger(PaymentConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return payment;
    }

}

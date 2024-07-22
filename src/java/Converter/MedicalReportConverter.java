package Converter;

import Entity.Admin;
import Entity.Hospital;
import Entity.MedicalReport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicalReportConverter extends BaseConverter<MedicalReport> {

    public MedicalReportConverter() {
        super();
    }

    @Override
    public String ConvertToString(MedicalReport medicalReport) {
        return "MedicalReport{"
                + "id=" + medicalReport.getId()
                + ", name='" + medicalReport.getName() + '\''
                + ", medicalReportDate='" + new SimpleDateFormat("yyyy-MM-dd").format(medicalReport.getMedicalReportDate()) + '\''
                + ", diagnosis='" + medicalReport.getDiagnosis() + '\''
                + ", description='" + medicalReport.getDescription() + '\''
                + '}';
    }

    @Override
    public MedicalReport ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        MedicalReport medicalReport = new MedicalReport();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1);
            medicalReport.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }

        String[] parts = string.split(", ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1].replace("'", ""); // Remove single quotes if any
                switch (key) {
                    case "name":
                        medicalReport.setName(value);
                        break;
                    case "medicalReportDate":

                        Date date;
                        try {
                            date = dateFormat.parse(value);
                            medicalReport.setMedicalReportDate(date);
                        } catch (ParseException ex) {
                            Logger.getLogger(MedicalReportConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    case "diagnosis":
                        medicalReport.setDiagnosis(value);
                        break;
                    case "description":
                        medicalReport.setDescription(value);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }

            }
        }
        return medicalReport;
    }
}

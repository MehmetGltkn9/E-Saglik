package Converter;
import DAO.PatientDAO;
import Entity.Doctor; 
import Entity.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoctorConverter extends BaseConverter<Doctor> {

    public DoctorConverter() {
        super();
    }

    @Override
    public String ConvertToString(Doctor doctor) {
        for (Patient patient : doctor.getPatientList()) {
            System.out.println(patient.getId());
        }
       return "Doctor{" +
            "id=" + doctor.getId() +
            ", name='" + doctor.getName() + '\'' +
            ", firstName='" + doctor.getFirstName() + '\'' +
            ", lastName='" + doctor.getLastName() + '\'' +
            ", email='" + doctor.getEmail() + '\'' +
//            ", password='" + doctor.getPassword() + '\'' +
//            ", gender='" + doctor.getGender() + '\'' +
//            ", phoneNumber='" + doctor.getPhoneNumber() + '\'' +
//            ", address='" + doctor.getAddress() + '\'' +
            ", specialization='" + doctor.getSpecialization() + '\'' +
            ", hospital='" + doctor.getHospital() + '\'' +
            ", prescription='" + doctor.getPrescription() + '\'' +
            ", appointment='" + doctor.getAppointment() + '\'' +
            ", patientList=" + doctor.getPatientList() +
            '}';
    }
    
    @Override
    public Doctor ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Doctor doctor = new Doctor();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            doctor.setId(Integer.parseInt(idString));
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
                        doctor.setName(value);
                        break;
                    case "firstName":
                        doctor.setFirstName(value);
                        break;
                    case "lastName":
                        doctor.setLastName(value);
                        break;
                    case "email":
                        doctor.setEmail(value);
                        break;
////                    case "password":
////                        doctor.setPassword(value);
////                        break;
                    case "gender":
                        doctor.setGender(value);
                        break;
//                    case "phoneNumber":
//                        doctor.setPhoneNumber(value);
//                        break;
//                    case "address":
//                        doctor.setAddress(value);
//                        break;
                    case "specialization":
                        doctor.setSpecialization(value);
                        break;
                    case "hospital":
                        doctor.setHospital(value);
                        break;
                    case "prescription":
                        doctor.setPrescription(value);
                        break;
                    case "appointment":
                        doctor.setAppointment(value);
                        break;                    
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        PatientDAO PD = new PatientDAO();
        doctor.setPatientList(extractPatientList(string,PD));
        return doctor;
    }
    
    

private List<Patient> extractPatientList(String input, PatientDAO patientDAO) {
    List<Patient> patientList = new ArrayList<>();

    // input'un null veya boş olup olmadığını kontrol edelim
    if (input == null || input.isEmpty()) {
        return patientList; // Boş bir liste döndürelim
    }

    // input içerisindeki diziyi alabilmek için köşeli parantezler arasındaki kısmı ayıralım
    String[] parts = input.split("=");
    if (parts.length != 2) {
        return patientList; // Hatalı format için boş bir liste döndürelim
    }

    // Dizi kısmını alıp virgüllerden ayırarak integer listesine dönüştürelim
    String arrayString = parts[1];
    String[] numbers = arrayString.replaceAll("[\\[\\]]", "").split(", ");
    for (String number : numbers) {
        try {
            int id = Integer.parseInt(number);
            Patient patient = patientDAO.GetById(id);
            if (patient != null) {
                patientList.add(patient);
            }
        } catch (NumberFormatException e) {
            // Hatalı sayısal değer için işlem yapma
        }
    }

    return patientList;
}


    
   private List<Integer> parsePatientList(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty.");
        }

        // Köşeli parantezleri ve boşlukları temizleyerek sadece rakamları içeren bir string elde ediyoruz
        String cleanedValue = value.replaceAll("[\\[\\] ]", "");

        System.out.println("value: " + value); // Kontrol amaçlı

        // Temizlenmiş stringi virgüllerden ayırarak integer listesine dönüştürüyoruz
        String[] patientIds = cleanedValue.split(",");
        List<Integer> patientList = new ArrayList<>();

        for (String patientId : patientIds) {
            patientList.add(Integer.parseInt(patientId));
        }

        return patientList;
    }




}

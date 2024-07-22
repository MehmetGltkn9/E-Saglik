
package main;

import Controller.BaseController;
import Controller.DoctorController;
import Controller.UserController;
import Converter.DoctorConverter;
import DAO.DoctorDAO;
import Entity.Doctor;
import Entity.Patient;
import Entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        
//        
//        List<Patient> patientList = new ArrayList<>();
//        patientList.add(new Patient()); // Örnek bir hasta ID'si ekleyelim

        // Doctor nesnesi oluşturma
//        Doctor doctor = new Doctor(
//            "Psikyatri",      // specialization
//            "Hospital",   // hospital
//            "Some prescription", // prescription
//            "08:00 AM",        // appointment
//            patientList,       // patientList
//            "Canan",            // firstName
//            "Aydın",             // lastName
//            "ccc.com", // email
//            "12345",     // password
//            "Female",            // gender
//            "1234567890",      // phoneNumber
//            "432 Main St",     // address
//            1,                 // id
//            "Dr. Canan"     // name
//        );
//        
//        DoctorController dc = new DoctorController();
//        dc.AddEntity(doctor);
//        
//        
//        
//        
//        
//        
//        
//        
//        DoctorConverter DC = new DoctorConverter();
//        String doctorString = "Doctor{" +
//        "id=1" +
//        ", name='John Doe'" +
//        ", firstName='John'" +
//        ", lastName='Doe'" +
//        ", email='johndoe@example.com'" +
//        ", password='mypassword'" +
//        ", gender='Male'" +
//        ", phoneNumber='1234567890'" +
//        ", address='123 Main Street City'" +
//        ", specialization='Cardiology'" +
//        ", hospital='City Hospital'" +
//        ", prescription='Aspirin, 100mg'" +
//        ", appointment='2024-05-11 10:00 AM'" +
//        ", patientList=[101, 102, 103]" +
//        '}';
//
//
//        try {
//            Doctor d = DC.ConvertToEntity(doctorString);
//            String s = DC.ConvertToString(d);
//            System.out.println(s);
//            
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    












}
}

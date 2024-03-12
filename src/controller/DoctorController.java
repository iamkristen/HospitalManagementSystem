package controller;
import classes.Doctor;
import classes.DoctorList;
import utils.EasyScanner;

public class DoctorController {
    public static DoctorList doctorList = new DoctorList();
    static String format = "%-5s %-20s %-30s %n";
    
    // create a method to add doctor
    public static void addDoctor() {
        System.out.println("Enter Doctor's ID: ");
        int id = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Doctor's Name: ");  
        String name = EasyScanner.nextString();
        System.out.println("Enter Doctor's Specialization: ");
        String specialization = EasyScanner.nextString();
        Doctor doctor = new Doctor(id, name, specialization);
        doctorList.addDoctor(doctor);
        System.out.println("Doctor added successfully!");
        System.out.println("===================================");
    }

    // create a method to delete doctor
    public static void deleteDoctor() {
        System.out.println("Enter Doctor's ID to delete: ");
        int id = EasyScanner.nextInt();
        doctorList.deleteDoctor(id);
    }

    // create a method to list doctor
    public static void listDoctor() {
        if(doctorList.isEmpty()){
            System.out.println("No doctor found!");
            return;
        }else{
        System.out.println("========== List of Doctors =========================");
        System.out.println(String.format(format, "ID", "Name", "Specialization"));
        doctorList.listDoctor();
        System.out.println("===================================");
        }
    }
}

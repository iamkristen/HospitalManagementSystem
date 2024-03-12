package controller;
import classes.Patient;
import classes.PatientList;
import utils.EasyScanner;

public class PatientController {
    public static PatientList patientList = new PatientList();
    static String format = "%-5s %-20s %-30s %n";


    // created a method to add patient
    public static void addPatient() {
        try{
            
         System.out.println("Enter Patient's ID: ");
         int id = EasyScanner.nextInt();
         EasyScanner.nextString();
         System.out.println("Enter Patient's Name: ");  
         String name = EasyScanner.nextString();
         System.out.println("Enter Patient's contact number: ");
         String contact = EasyScanner.nextString();
         Patient patient = new Patient(id, name, contact);
         patientList.addPatient(patient);
         System.out.println("Patient added successfully!");
         System.out.println("===================================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // created a method to delete patient
    public static void deletePatient() {
        System.out.println("Enter Patient's ID to delete: ");
        int id = EasyScanner.nextInt();
        patientList.deletePatient(id);
    }

    // created a method to list patient
    public static void listPatient() {
        if(patientList.isEmpty()){
            System.out.println("No patient found!");
            return;
        }else{
            System.out.println("========== List of Patients =========================");
            System.out.println(String.format(format, "ID", "Name", "Specialization"));
            patientList.listPatient();
            System.out.println("=======================================");

        }
    }

    
}

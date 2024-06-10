package CLI;

import java.util.Random;

import classes.Patient;
import controller.PatientController;
import helper.EasyScanner;

public class PatientInterface {
    public static PatientController patientList = new PatientController();
    static String format = "%-5s %-20s %-30s %n";

    // created a method to add patient
    public static void addPatient() {
        try {
            int id = generateUniqueId();
            EasyScanner.nextString();
            System.out.println("Enter Patient's Name: ");
            String name = EasyScanner.nextString();
            System.out.println("Enter Patient's contact number: ");
            String contact = EasyScanner.nextString();
            Patient patient = new Patient(id, name, contact);
            patientList.addPatient(patient);
            System.out.println("\u001B[32m" + "Patient added successfully!" + "\u001B[0m");
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
        if (patientList.isEmpty()) {
            System.out.println("\u001B[31m" + "No patient found!" + "\u001B[0m");
            return;
        } else {
            System.out.println(
                    "\u001B[33m" + "========== List of Patients =========================" + "\u001B[0m");
            System.out.println(String.format(format, "ID", "Name", "Contact Number"));
            patientList.listPatient();
            System.out.println("=======================================");

        }
    }

    // create a method to save the Doctor data to the local file
    public static void saveData() {
        patientList.saveData();
    }

    // create a method to load the Doctor data from the local file
    public static void loadData() {
        patientList.loadData();
    }

    public static int generateUniqueId() {
        Random rand = new Random();
        return rand.nextInt((999 - 1) + 1) + 1;
    }
}

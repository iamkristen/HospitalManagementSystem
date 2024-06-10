package CLI;

import java.util.Random;

import classes.Treatment;
import controller.TreatmentController;
import helper.EasyScanner;

public class TreatmentInterface {
    public static TreatmentController treatmentList = new TreatmentController();
    static String format = "%-5s %-20s %-30s %n";

    // created a method to add treatment
    public static void addTreatment() {
        try {
            int id = generateUniqueId();
            EasyScanner.nextString();
            System.out.println("Enter Patient ID: ");
            int patientId = EasyScanner.nextInt();
            EasyScanner.nextString();
            System.out.println("Enter Treatment: ");
            String treatmentDetails = EasyScanner.nextString();
            Treatment treatment = new Treatment(id, patientId, treatmentDetails);
            treatmentList.addTreatment(treatment);
            System.out.println("\u001B[32m" + "Treatment added successfully!" + "\u001B[0m");
            System.out.println("===================================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // created a method to delete treatment
    public void deleteTreatment() {
        System.out.println("Enter Treatment ID to delete: ");
        int id = EasyScanner.nextInt();
        treatmentList.deleteTreatment(id);
    }

    // created a method to list treatment
    public static void listTreatment() {
        if (treatmentList.isEmpty()) {
            System.out.println("\u001B[31m" + "No treatment found!" + "\u001B[0m");
            return;
        } else {
            System.out.println("========== List of Treaments =========================");
            System.out.println(String.format(format, "ID", "Name", "Specialization"));
            treatmentList.listTreatment();
        }
    }

    // created a method to check treatment by patient id
    public static void checkTreatment() {
        System.out.println("Enter Patient's ID to check treatment: ");
        int patientId = EasyScanner.nextInt();
        if (treatmentList.isEmpty()) {
            System.out.println("\u001B[31m" + "No treatment found!" + "\u001B[0m");
            return;
        } else {
            treatmentList.checkTreatmentByPatientId(patientId);
        }
    }

    // create a method to save the Doctor data to the local file
    public static void saveData() {
        treatmentList.saveData();
    }

    // create a method to load the Doctor data from the local file
    public static void loadData() {
        treatmentList.loadData();
    }

    public static int generateUniqueId() {
        Random rand = new Random();
        return rand.nextInt((999 - 1) + 1) + 1;
    }
}

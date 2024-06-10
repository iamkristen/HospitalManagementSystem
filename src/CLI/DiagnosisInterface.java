package CLI;

import java.util.Random;

import classes.Diagnosis;
import controller.DiagnosisController;
import helper.EasyScanner;

public class DiagnosisInterface {

    public static DiagnosisController diagnosisList = new DiagnosisController();

    // created a method to add diagnosis
    public static void addDiagnosis() {
        try {
            int id = generateUniqueId();
            EasyScanner.nextString();
            System.out.println("Enter Patient ID: ");
            int patientId = EasyScanner.nextInt();
            EasyScanner.nextString();
            System.out.println("Enter Diagnosis: ");
            String diagnosis_detail = EasyScanner.nextString();
            Diagnosis diagnosis = new Diagnosis(id, patientId, diagnosis_detail);
            diagnosisList.addDiagnosis(diagnosis);
            System.out.println("\u001B[32m" + "Diagnosis added successfully!" + "\u001B[0m");
            System.out.println("===================================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // created a method to delete diagnosis
    public void deleteDiagnosis() {
        System.out.println("Enter Diagnosis ID to delete: ");
        int id = EasyScanner.nextInt();
        diagnosisList.deleteDiagnosis(id);
    }

    // created a method to list diagnosis
    public static void listDiagnosis() {
        if (diagnosisList.isEmpty()) {
            System.out.println("\u001B[31m" + "No diagnosis found!" + "\u001B[0m");
            return;
        } else {
            diagnosisList.listDiagnosis();
        }
    }

    // created a method to check diagnosis by patient id
    public static void checkDiagnosis() {
        System.out.println("Enter Patient's ID to check diagnosis: ");
        int patientId = EasyScanner.nextInt();
        if (diagnosisList.isEmpty()) {
            System.out.println("\u001B[31m" + "No diagnosis found!" + "\u001B[0m");
            return;
        } else {
            diagnosisList.checkDiagnosisByPatientId(patientId);
        }
    }

    // create a method to save the Doctor data to the local file
    public static void saveData() {
        diagnosisList.saveData();
    }

    // create a method to load the Doctor data from the local file
    public static void loadData() {
        diagnosisList.loadData();
    }

    public static int generateUniqueId() {
        Random rand = new Random();
        return rand.nextInt((999 - 1) + 1) + 1;
    }
}

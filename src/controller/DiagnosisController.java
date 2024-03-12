package controller;

import classes.Diagnosis;
import classes.DiagnosisList;
import utils.EasyScanner;

public class DiagnosisController {
    
    public static DiagnosisList diagnosisList = new DiagnosisList();

    // created a method to add diagnosis
    public static void addDiagnosis() {
        System.out.println("Enter Diagnosis ID: ");
        int id = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Patient ID: ");
        int patientId = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Diagnosis: ");
        String diagnosis_detail = EasyScanner.nextString();
        Diagnosis diagnosis = new Diagnosis(id, patientId, diagnosis_detail);
        diagnosisList.addDiagnosis(diagnosis);
        System.out.println("Diagnosis added successfully!");
        System.out.println("===================================");
    }

    // created a method to delete diagnosis
    public void deleteDiagnosis() {
        System.out.println("Enter Diagnosis ID to delete: ");
        int id = EasyScanner.nextInt();
        diagnosisList.deleteDiagnosis(id);
    }

    // created a method to list diagnosis
    public void listDiagnosis() {
        if (diagnosisList.isEmpty()) {
            System.out.println("No diagnosis found!");
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
            System.out.println("No diagnosis found!");
            return;
        } else {
            diagnosisList.checkDiagnosisByPatientId(patientId);
        }
    }
}

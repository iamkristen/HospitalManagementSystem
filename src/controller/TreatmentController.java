package controller;

import classes.Treatment;
import classes.TreatmentList;
import utils.EasyScanner;

public class TreatmentController {
    public static TreatmentList treatmentList = new TreatmentList();
    static String format = "%-5s %-20s %-30s %n";

    // created a method to add treatment
    public static void addTreatment() {
        System.out.println("Enter Treatment ID: ");
        int id = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Patient ID: ");
        int patientId = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Treatment: ");
        String treatmentDetails = EasyScanner.nextString();
        Treatment treatment = new Treatment(id, patientId, treatmentDetails);
        treatmentList.addTreatment(treatment);
        System.out.println("Treatment added successfully!");
        System.out.println("===================================");
    }

    // created a method to delete treatment
    public void deleteTreatment() {
        System.out.println("Enter Treatment ID to delete: ");
        int id = EasyScanner.nextInt();
        treatmentList.deleteTreatment(id);
    }

    // created a method to list treatment
    public void listTreatment() {
        if (treatmentList.isEmpty()) {
            System.out.println("No treatment found!");
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
            System.out.println("No treatment found!");
            return;
        } else {
            treatmentList.checkTreatmentByPatientId(patientId);
        }
    }
    
}

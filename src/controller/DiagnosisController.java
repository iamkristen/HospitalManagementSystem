package controller;

import java.util.ArrayList;

import classes.Diagnosis;
import helper.DataHandler;

public class DiagnosisController {
    private static ArrayList<Diagnosis> diagnosisList = new ArrayList<Diagnosis>();
    private static String filename = "diagnosis.dat";

    // to add diagnosis in list of diagnosis
    public static void addDiagnosis(Diagnosis diagnosis) {
        diagnosisList.add(diagnosis);
    }

    // to delete diagnosis from list of diagnosis
    public void deleteDiagnosis(int id) {
        for (Diagnosis diagnosis : diagnosisList) {
            if (diagnosis.getId() == id) {
                diagnosisList.remove(diagnosis);
                System.out.println("\u001B[32m" + "Diagnosis deleted successfully!" + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m" + "Diagnosis not found!" + "\u001B[0m");
    }

    // to list all diagnosis
    public void listDiagnosis() {
        System.out
                .println("\u001B[33m" + "========== List of Diagnosis =========================" + "\u001B[0m");
        System.out.println(String.format("%-5s %-20s %-20s %n", "ID", "Patient ID", "Diagnosis"));
        for (Diagnosis diagnosis : diagnosisList) {
            System.out.println("\u001B[36m" + diagnosis + "\u001B[0m");
        }
        System.out.println("===================================");
    }

    // to check diagnosis by patient id
    public void checkDiagnosisByPatientId(int patientId) {
        for (Diagnosis diagnosis : diagnosisList) {
            if (diagnosis.getPatientId() == patientId) {
                System.out.println(
                        "\u001B[33m" + "========== List of Diagnosis =========================" + "\u001B[0m");
                System.out.println(String.format("%-5s %-20s %-20s %n", "ID", "Name", "Diagnosis details"));
                System.out.println("\u001B[36m" + diagnosis + "\u001B[0m");
                System.out.println("===================================");
                return;
            }
        }
        System.out.println("\u001B[31m" + "Diagnosis not found!" + "\u001B[0m");
        System.out.println("===================================");
    }

    // to get diagnosis from list of diagnosis
    public Diagnosis getDiagnosis(int id) {
        for (Diagnosis diagnosis : diagnosisList) {
            if (diagnosis.getPatientId() == id) {
                return diagnosis;
            }
        }
        throw new IllegalArgumentException("\u001B[31m" + "Diagnosis not found!" + "\u001B[0m");
    }

    // to get list of diagnosis
    public static ArrayList<Diagnosis> getAllDiagnosis() {
        return diagnosisList;
    }

    // to check list of diagnosis is empty or not
    public boolean isEmpty() {
        return diagnosisList.isEmpty();
    }

    // created to save diagnosisList to local file
    public void saveData() {
        DataHandler.saveData(diagnosisList, filename);
    }

    // Created to load data from local file
    public void loadData() {
        diagnosisList = DataHandler.getData(filename);
    }

}

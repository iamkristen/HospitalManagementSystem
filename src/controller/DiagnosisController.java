package controller;

import java.util.ArrayList;

import Data.DataHandler;
import classes.Diagnosis;
import utils.TextColor;

public class DiagnosisController {
    private static ArrayList <Diagnosis> diagnosisList = new ArrayList<Diagnosis>();
    private static String filename = "diagnosis.dat";

    // to add diagnosis in list of diagnosis
    public void addDiagnosis(Diagnosis diagnosis) {
        diagnosisList.add(diagnosis);
    }

    // to delete diagnosis from list of diagnosis  
    public void deleteDiagnosis(int id) {
        for (Diagnosis diagnosis : diagnosisList) {
            if (diagnosis.getDiagnosis_id() == id) {
                diagnosisList.remove(diagnosis);
                System.out.println(TextColor.GREEN+"Diagnosis deleted successfully!"+TextColor.RESET);
                return;
            }
        }
        System.out.println(TextColor.RED+"Diagnosis not found!"+TextColor.RESET);
    }

    // to list all diagnosis
    public void listDiagnosis() {
        for (Diagnosis diagnosis : diagnosisList) {
            System.out.println(TextColor.YELLOW+"========== List of Diagnosis ========================="+TextColor.RESET);
            System.out.println(String.format("%-5s %-20s %-20s %n", "ID", "Patient ID", "Diagnosis"));
            System.out.println(TextColor.CYAN+diagnosis+TextColor.RESET);
            System.out.println("===================================");
        }
    }

    //to check diagnosis by patient id
    public void checkDiagnosisByPatientId(int patientId) {
        for (Diagnosis diagnosis : diagnosisList) {
            if (diagnosis.getPatientId() == patientId) {
                System.out.println(TextColor.YELLOW+"========== List of Diagnosis ========================="+TextColor.RESET);
                System.out.println(String.format("%-5s %-20s %-20s %n", "ID", "Name", "Diagnosis details"));
                System.out.println(diagnosis);
                System.out.println("===================================");
            }
        }
    }

    // to get diagnosis from list of diagnosis
    public Diagnosis getDiagnosis(int id) {
        for (Diagnosis diagnosis : diagnosisList) {
            if (diagnosis.getPatientId()== id) {
                return diagnosis;
            }
        }
        throw new IllegalArgumentException(TextColor.RED+"Diagnosis not found!"+TextColor.RESET);
    }

    // to check list of diagnosis is empty or not
    public boolean isEmpty() {
        return diagnosisList.isEmpty();
    }
    
    //created to save diagnosisList to local file 
    public void saveData(){
        DataHandler.saveData(diagnosisList, filename);
    }

    // Created to load data from local file
    public void loadData(){
        diagnosisList = DataHandler.getData(filename);
    }

}

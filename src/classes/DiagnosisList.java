package classes;

import java.util.ArrayList;

public class DiagnosisList {
    private static ArrayList <Diagnosis> DiagnosisList = new ArrayList<Diagnosis>();

    // to add diagnosis in list of diagnosis
    public void addDiagnosis(Diagnosis diagnosis) {
        DiagnosisList.add(diagnosis);
    }

    // to delete diagnosis from list of diagnosis  
    public void deleteDiagnosis(int id) {
        for (Diagnosis diagnosis : DiagnosisList) {
            if (diagnosis.getDiagnosis_id() == id) {
                DiagnosisList.remove(diagnosis);
                System.out.println("Diagnosis deleted successfully!");
                return;
            }
        }
        System.out.println("Diagnosis not found!");
    }

    // to list all diagnosis
    public void listDiagnosis() {
        for (Diagnosis diagnosis : DiagnosisList) {
            System.out.println("========== List of Diagnosis =========================");
            System.out.println(String.format("%-5s %-20s %-20s %n", "ID", "Patient ID", "Diagnosis"));
            System.out.println(diagnosis);
            System.out.println("===================================");
        }
    }

    //to check diagnosis by patient id
    public void checkDiagnosisByPatientId(int patientId) {
        for (Diagnosis diagnosis : DiagnosisList) {
            if (diagnosis.getPatientId() == patientId) {
                System.out.println("========== List of Diagnosis =========================");
                System.out.println(String.format("%-5s %-20s %-20s %n", "ID", "Patient ID", "Diagnosis"));
                System.out.println(diagnosis);
                System.out.println("===================================");
            }
        }
    }

    // to get diagnosis from list of diagnosis
    public Diagnosis getDiagnosis(int id) {
        for (Diagnosis diagnosis : DiagnosisList) {
            if (diagnosis.patientId == id) {
                return diagnosis;
            }
        }
        throw new IllegalArgumentException("Diagnosis not found!");
    }

    // to check list of diagnosis is empty or not
    public boolean isEmpty() {
        return DiagnosisList.isEmpty();
    }
    
}

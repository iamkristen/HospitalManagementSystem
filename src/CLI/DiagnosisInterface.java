package CLI;

import classes.Diagnosis;
import controller.DiagnosisController;
import utils.EasyScanner;
import utils.TextColor;
import utils.UniqueIdGenerator;

public class DiagnosisInterface {
    
    public static DiagnosisController diagnosisList = new DiagnosisController();

    // created a method to add diagnosis
    public static void addDiagnosis() {
        try{
        int id = UniqueIdGenerator.generateUniqueId();
        EasyScanner.nextString();
        System.out.println("Enter Patient ID: ");
        int patientId = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Diagnosis: ");
        String diagnosis_detail = EasyScanner.nextString();
        Diagnosis diagnosis = new Diagnosis(id, patientId, diagnosis_detail);
        diagnosis.setPatientName(patientId);
        diagnosisList.addDiagnosis(diagnosis);
        System.out.println(TextColor.GREEN+"Diagnosis added successfully!"+TextColor.RESET);
        System.out.println("===================================");
    }catch (Exception e) {
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
    public void listDiagnosis() {
        if (diagnosisList.isEmpty()) {
            System.out.println(TextColor.RED+"No diagnosis found!"+TextColor.RESET);
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
            System.out.println(TextColor.RED+"No diagnosis found!"+TextColor.RESET);
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
}

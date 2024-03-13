package CLI;

import classes.Treatment;
import controller.TreatmentController;
import utils.EasyScanner;
import utils.TextColor;
import utils.UniqueIdGenerator;

public class TreatmentInterface {
    public static TreatmentController treatmentList = new TreatmentController();
    static String format = "%-5s %-20s %-30s %n";

    // created a method to add treatment
    public static void addTreatment() {
        try{
        int id = UniqueIdGenerator.generateUniqueId();
        EasyScanner.nextString();
        System.out.println("Enter Patient ID: ");
        int patientId = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Treatment: ");
        String treatmentDetails = EasyScanner.nextString();
        Treatment treatment = new Treatment(id, patientId, treatmentDetails);
        treatment.setPatientName(patientId);
        treatmentList.addTreatment(treatment);
        System.out.println(TextColor.GREEN+"Treatment added successfully!"+TextColor.RESET);
        System.out.println("===================================");
    }catch (Exception e) {
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
    public void listTreatment() {
        if (treatmentList.isEmpty()) {
            System.out.println(TextColor.RED+"No treatment found!"+TextColor.RESET);
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
            System.out.println(TextColor.RED+"No treatment found!"+TextColor.RESET);
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
    
}

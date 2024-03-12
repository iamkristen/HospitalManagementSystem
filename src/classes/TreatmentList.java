package classes;

import java.util.ArrayList;

public class TreatmentList {
    private static ArrayList <Treatment> TreatmentList = new ArrayList<Treatment>();
    static String format = "%-5s %-20s %-30s %n";


    // to add treatment in list of treatment
    public void addTreatment(Treatment treatment) {
        TreatmentList.add(treatment);
    }

    // to delete treatment from list of treatment   
    public void deleteTreatment(int id) {
        for (Treatment treatment : TreatmentList) {
            if (treatment.getTreatmentid() == id) {
                TreatmentList.remove(treatment);
                System.out.println("Treatment deleted successfully!");
                return;
            }
        }
        System.out.println("Treatment not found!");
    }

    // to list all treatment
    public void listTreatment() {
        for (Treatment treatment : TreatmentList) {
            
            System.out.println(treatment);
        }
    }

    // to get treatment from list of treatment
    public Treatment getTreatment(int id) {
        for (Treatment treatment : TreatmentList) {
            if (treatment.patientid == id) {
                return treatment;
            }
        }
        throw new IllegalArgumentException("Treatment not found!");
    }

    //to check treatment by patient id
    public void checkTreatmentByPatientId(int patientId) {
        for (Treatment treatment : TreatmentList) {
            if (treatment.getPatientid() == patientId) {
                System.out.println("========== List of Doctors =========================");
                System.out.println(String.format(format, "ID", "Name", "Specialization"));
                System.out.println(treatment);
            }
        }
    }

    // to check list of treatment is empty or not
    public boolean isEmpty() {
        return TreatmentList.isEmpty();
    }
    
}

package controller;

import java.util.ArrayList;

import classes.Treatment;
import helper.DataHandler;

public class TreatmentController {
    private static ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
    private static String filename = "treatments.dat";
    static String format = "%-5s %-20s %-30s %n";

    // to add treatment in list of treatment
    public static void addTreatment(Treatment treatment) {
        treatmentList.add(treatment);
    }

    // to delete treatment from list of treatment
    public void deleteTreatment(int id) {
        for (Treatment treatment : treatmentList) {
            if (treatment.getId() == id) {
                treatmentList.remove(treatment);
                System.out.println("\u001B[32m" + "Treatment deleted successfully!" + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m" + "Treatment not found!" + "\u001B[0m");
    }

    // to list all treatment
    public void listTreatment() {
        for (Treatment treatment : treatmentList) {

            System.out.println("\u001B[36m" + treatment + "\u001B[0m");
        }
    }

    // to get treatment from list of treatment
    public Treatment getTreatment(int id) {
        for (Treatment treatment : treatmentList) {
            if (treatment.getPatientid() == id) {
                return treatment;
            }
        }
        throw new IllegalArgumentException("\u001B[31m" + "Treatment not found!" + "\u001B[0m");
    }

    // to get all treatment
    public static ArrayList<Treatment> getAllTreatment() {
        return treatmentList;
    }

    // to check treatment by patient id
    public void checkTreatmentByPatientId(int patientId) {
        for (Treatment treatment : treatmentList) {
            if (treatment.getPatientid() == patientId) {
                System.out.println(
                        "\u001B[33m" + "========== List of Treatments =========================" + "\u001B[0m");
                System.out.println(String.format(format, "ID", "Name", "Treatment Details"));
                System.out.println("\u001B[36m" + treatment + "\u001B[0m");
            }
        }
    }

    // to check list of treatment is empty or not
    public boolean isEmpty() {
        return treatmentList.isEmpty();
    }

    // created to save treatmentList to local file
    public void saveData() {
        DataHandler.saveData(treatmentList, filename);
    }

    // Created to load data from local file
    public void loadData() {
        treatmentList = DataHandler.getData(filename);
    }

}

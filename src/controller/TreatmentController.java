package controller;
import java.util.ArrayList;

import Data.DataHandler;
import classes.Treatment;
import utils.TextColor;

public class TreatmentController {
    private static ArrayList <Treatment> treatmentList = new ArrayList<Treatment>();
    private static String filename = "treatments.dat";
    static String format = "%-5s %-20s %-30s %n";


    // to add treatment in list of treatment
    public void addTreatment(Treatment treatment) {
        treatmentList.add(treatment);
    }

    // to delete treatment from list of treatment   
    public void deleteTreatment(int id) {
        for (Treatment treatment : treatmentList) {
            if (treatment.getTreatmentid() == id) {
                treatmentList.remove(treatment);
                System.out.println(TextColor.GREEN+"Treatment deleted successfully!"+TextColor.RESET);
                return;
            }
        }
        System.out.println(TextColor.RED+"Treatment not found!"+TextColor.RESET);
    }

    // to list all treatment
    public void listTreatment() {
        for (Treatment treatment : treatmentList) {
            
            System.out.println(treatment);
        }
    }

    // to get treatment from list of treatment
    public Treatment getTreatment(int id) {
        for (Treatment treatment : treatmentList) {
            if (treatment.getPatientid() == id) {
                return treatment;
            }
        }
        throw new IllegalArgumentException(TextColor.RED+"Treatment not found!"+TextColor.RESET);
    }

    //to check treatment by patient id
    public void checkTreatmentByPatientId(int patientId) {
        for (Treatment treatment : treatmentList) {
            if (treatment.getPatientid() == patientId) {
                System.out.println(TextColor.YELLOW+"========== List of Treatments ========================="+TextColor.RESET);
                System.out.println(String.format(format, "ID", "Name", "Treatment Details"));
                System.out.println(TextColor.CYAN+treatment+TextColor.RESET);
            }
        }
    }

    // to check list of treatment is empty or not
    public boolean isEmpty() {
        return treatmentList.isEmpty();
    }

    //created to save treatmentList to local file 
    public void saveData(){
        DataHandler.saveData(treatmentList, filename);
    }

    // Created to load data from local file
    public void loadData(){
        treatmentList = DataHandler.getData(filename);
    }

    
}

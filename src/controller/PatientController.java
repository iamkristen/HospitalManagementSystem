package controller;
import java.util.ArrayList;

import javax.xml.soap.Text;

import Data.DataHandler;
import classes.Patient;
import utils.TextColor;

public class PatientController {
    private static ArrayList <Patient> patientList = new ArrayList<Patient>();
    private static String filename = "patients.dat";

    // to add patient in list of patients
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    // to delete patient from list of patients
    public void deletePatient(int id) {
        for (Patient patient : patientList) {
            if (patient.getid() == id) {
                patientList.remove(patient);
                System.out.println(TextColor.GREEN+"Patient deleted successfully!"+TextColor.RESET);
                return;
            }
        }
        System.out.println(TextColor.GREEN+"Patient not found!"+TextColor.RESET);
       }

    // to get patient from list of patients 
    public Patient getPatient(int id) {
        for (Patient patient : patientList) {
            if (patient.getid() == id) {
                return patient;
            }
        }
        throw new IllegalArgumentException(TextColor.GREEN+"Patient not found!"+TextColor.RESET);
    }

    // to list all patients
    public void listPatient() {
        for (Patient patient : patientList) {
            System.out.println(TextColor.CYAN+patient+TextColor.RESET);
        }
    }

    // to check list of patients is empty or not
    public boolean isEmpty() {
        return patientList.isEmpty();
    }

    public String getPatientName(int patientId) {
        for (Patient patient : patientList) {
            if (patient.getid() == patientId) {
                return patient.getname();
            }
        }
        throw new IllegalArgumentException(TextColor.GREEN+"Patient not found!"+TextColor.RESET);
    }

    //created to save patientList to local file 
    public void saveData(){
        DataHandler.saveData(patientList, filename);
    }

    // Created to load data from local file
    public void loadData(){
        patientList = DataHandler.getData(filename);
    }

}

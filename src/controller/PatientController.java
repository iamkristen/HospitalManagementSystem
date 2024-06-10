package controller;

import java.util.ArrayList;
import java.util.Random;

import classes.Patient;
import helper.DataHandler;

public class PatientController {
    private static ArrayList<Patient> patientList = new ArrayList<Patient>();
    private static String filename = "patients.dat";

    // to add patient in list of patients
    public static void addPatient(Patient patient) {
        patientList.add(patient);
    }

    // to get all patient names
    public ArrayList<String> getAllPatientNames() {
        ArrayList<String> patientNames = new ArrayList<>();
        for (Patient patient : patientList) {
            patientNames.add(patient.getName());
        }
        return patientNames;
    }

    // to get patient List
    public static ArrayList<Patient> getPatientList() {
        return patientList;
    }

    // to delete patient from list of patients
    public void deletePatient(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                patientList.remove(patient);
                System.out.println("\u001B[32m" + "Patient deleted successfully!" + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[32m" + "Patient not found!" + "\u001B[0m");
    }

    // to get patient from list of patients
    public Patient getPatient(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        throw new IllegalArgumentException("\u001B[32m" + "Patient not found!" + "\u001B[0m");
    }

    // to get patient by name
    public Patient getPatientByName(String name) {
        for (Patient patient : patientList) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        throw new IllegalArgumentException("\u001B[32m" + "Patient not found!" + "\u001B[0m");
    }

    // to list all patients
    public void listPatient() {
        for (Patient patient : patientList) {
            System.out.println("\u001B[36m" + patient + "\u001B[0m");
        }
    }

    // to check list of patients is empty or not
    public boolean isEmpty() {
        return patientList.isEmpty();
    }

    public String getPatientName(int patientId) {
        for (Patient patient : patientList) {
            if (patient.getId() == patientId) {
                return patient.getName();
            }
        }
        throw new IllegalArgumentException("\u001B[32m" + "Patient not found!" + "\u001B[0m");
    }

    // created to save patientList to local file
    public void saveData() {
        DataHandler.saveData(patientList, filename);
    }

    // Created to load data from local file
    public void loadData() {
        patientList = DataHandler.getData(filename);
    }

    public static int generateUniqueId() {
        Random rand = new Random();
        return rand.nextInt((999 - 1) + 1) + 1;
    }
}

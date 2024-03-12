package classes;
import java.util.ArrayList;

public class PatientList {
    private static ArrayList <Patient> patientList = new ArrayList<Patient>();

    // to add patient in list of patients
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    // to delete patient from list of patients
    public void deletePatient(int id) {
        for (Patient patient : patientList) {
            if (patient.getid() == id) {
                patientList.remove(patient);
                System.out.println("Patient deleted successfully!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    // to get patient from list of patients 
    public Patient getPatient(int id) {
        for (Patient patient : patientList) {
            if (patient.getid() == id) {
                return patient;
            }
        }
        throw new IllegalArgumentException("Patient not found!");
    }

    // to list all patients
    public void listPatient() {
        for (Patient patient : patientList) {
            System.out.println(patient);
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
        throw new IllegalArgumentException("Patient not found!");
    }
}

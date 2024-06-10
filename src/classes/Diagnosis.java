package classes;

import java.io.Serializable;

import CLI.PatientInterface;

public class Diagnosis implements Serializable {
    int diagnosis_id;
    int patientId;
    String patientName;
    String diagnosis;

    public Diagnosis(int diagnosis_id, int patient_id, String diagnosis) {
        this.diagnosis_id = diagnosis_id;
        this.patientId = patient_id;
        this.diagnosis = diagnosis;
        setPatientName(patient_id);
    }

    public int getId() {
        return diagnosis_id;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setPatientName(int id) {
        this.patientName = PatientInterface.patientList.getPatientName(id);
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
    public String toString() {
        return String.format("%-5s  %-20s  %-30s %n", diagnosis_id, patientName, diagnosis);
    }
}

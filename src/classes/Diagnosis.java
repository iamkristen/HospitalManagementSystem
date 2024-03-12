package classes;
public class Diagnosis {
    int diagnosis_id;
    int patientId;
    String diagnosis;
public Diagnosis(int diagnosis_id, int patient_id, String diagnosis) {
        this.diagnosis_id = diagnosis_id;
        this.patientId = patient_id;
        this.diagnosis = diagnosis;
    }

    public int getDiagnosis_id() {
        return diagnosis_id;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }   

    @Override
    public String toString() {
        return String.format("%-5s  %-20s  %-30s %n", diagnosis_id, patientId, diagnosis);
    }
}

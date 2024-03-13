package classes;

import java.io.Serializable;

import CLI.PatientInterface;

public class Treatment implements Serializable{
    int treatmentid;
    int patientid;
    String treatment;
    String patientName;

    public Treatment(int treatmentid, int patientid, String treatment) {
        this.treatmentid = treatmentid;
        this.patientid = patientid;
        this.treatment = treatment;
    }

    public int getTreatmentid() {
        return treatmentid;
    }

    public int getPatientid() {
        return patientid;
    }

    public String getTreatment() {
        return treatment;
    }
    public void setPatientName(int id) {
        this.patientName = PatientInterface.patientList.getPatientName(id);
    }

    @Override
    public String toString() {
        String format = "%-5s  %-20s  %-30s %n";
        return String.format(format, treatmentid, patientName, treatment);
    }
}

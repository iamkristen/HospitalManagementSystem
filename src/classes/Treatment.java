package classes;
public class Treatment {
    int treatmentid;
    int patientid;
    String treatment;

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

    @Override
    public String toString() {
        String format = "%-5s  %-20s  %-30s %n";
        return String.format(format, treatmentid, patientid, treatment);
    }
}

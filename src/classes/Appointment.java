package classes;
import java.io.Serializable;
import CLI.DoctorInterface;
import CLI.PatientInterface;

public class Appointment implements Serializable {
    
    int id;
    String time;
    int doctorId;
    int patientId;
    String doctorName;
    String PatientName;


    //creating consturctor for appointment class
    public Appointment(int id, String time, int doctorid, int patientid) {
        this.id = id;
        this.doctorId = doctorid;
        this.patientId = patientid;
        this.time = time;
    }



    public String getDoctorName() {
        return doctorName;
    }

    public String getPatientName() {
        return PatientName;
    }

    //setting doctor name from doctor id
    public void setDoctorName(String doctorName) {
        
        this.doctorName = DoctorInterface.doctorList.getDoctorName(doctorId);
    }

    //setting patient name from patient id
    public void setPatientName(String PatientName) {
       
        this.PatientName = PatientInterface.patientList.getPatientName(patientId);
    }

    public int getid() {
        return id;
    }

    public int getdoctorId() {
        return doctorId;
    }

    public int getpatientId() {
        return patientId;
    }

    public String gettime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-20s %-20s %n", id, time, doctorName, PatientName);
    }
}

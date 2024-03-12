package classes;
import controller.DoctorController;
import controller.PatientController;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    
    int id;
    static LocalTime localTime;
    int doctorId;
    int patientId;
    String doctorName;
    String PatientName;


    //creating consturctor for appointment class
    public Appointment(int id, String time, int doctorid, int patientid) {
        this.id = id;
        this.doctorId = doctorid;
        this.patientId = patientid;
        setTime(time);
    }


    public String getDoctorName() {
        return doctorName;
    }

    public String getPatientName() {
        return PatientName;
    }

    //setting doctor name from doctor id
    public void setDoctorName(String doctorName) {
        
        this.doctorName = DoctorController.doctorList.getDoctorName(doctorId);
    }

    //setting patient name from patient id
    public void setPatientName(String PatientName) {
       
        this.PatientName = PatientController.patientList.getPatientName(patientId);
    }

    public int getid() {
        return id;
    }

    public LocalTime gettime() {
        return localTime;
    }

    public int getdoctorId() {
        return doctorId;
    }

    public int getpatientId() {
        return patientId;
    }

    public static void setTime(String time){
        try{
            localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid time format (HH:mm)");
        }
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-20s %-20s %n", id, localTime, doctorName, PatientName);
    }
}

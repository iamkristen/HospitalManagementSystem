package classes;
import java.util.ArrayList;

public class AppointmentList {
    private static ArrayList <Appointment> appointmentList = new ArrayList<Appointment>();

    // to add appointment in list of appointments
    public void addAppointment(Appointment appointment) {
        
        appointmentList.add(appointment);
    }

    // to delete appointment from list of appointments
    public void deleteAppointment(int id) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getid() == id) {
                appointmentList.remove(appointment);
                System.out.println("Appointment deleted successfully!");
                return;
            }
        }
        System.out.println("Appointment not found!");
    }

    // to list all appointments
    public void listAppointment() {
        for (Appointment appointment : appointmentList) {

            System.out.println(appointment);
        }
    }

    // to get appointment from list of appointments
    public Appointment getAppointment(int id) {
        for (Appointment appointment : appointmentList) {
            if (appointment.patientId == id) {
                return appointment;
            }
        }
        throw new IllegalArgumentException("Appointment not found!");
    }

    //to check appointment by patient id
    public void checkAppointmentByPatientId(int patientId) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getpatientId() == patientId) {
                System.out.println("========== List of Appointments =========================");
                System.out.println(String.format("%-5s %-20s %-20s %-20s %n", "ID", "Time", "Doctor Name", "Patient Name"));
                System.out.println(appointment);
                System.out.println("===================================");
            }
        }
    }

    // to check list of appointments is empty or not
    public boolean isEmpty() {
        return appointmentList.isEmpty();
    }

}

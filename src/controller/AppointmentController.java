package controller;
import classes.Appointment;
import classes.AppointmentList;
import utils.EasyScanner;

public class AppointmentController {
    public static AppointmentList appointmentList = new AppointmentList();

    // create a method to add appointment
    public static void addAppointment() {
        try{
            System.out.println("Enter Appointment's ID: ");
        int id = EasyScanner.nextInt();
        EasyScanner.nextString();
        System.out.println("Enter Appointment's Time: ");
        String time = EasyScanner.nextString();
        System.out.println("Enter Doctor's ID: ");
        int doctorId = EasyScanner.nextInt();
        System.out.println("Enter Patient's ID: ");
        int patientId = EasyScanner.nextInt();
        Appointment appointment = new Appointment(id, time, doctorId, patientId);
        appointment.setDoctorName(DoctorController.doctorList.getDoctorName(doctorId));
        appointment.setPatientName(PatientController.patientList.getPatientName(patientId));
        appointmentList.addAppointment(appointment);
        System.out.println("Appointment added successfully!");
        System.out.println("===================================");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // create a method to delete appointment
    public static void deleteAppointment() {
        System.out.println("Enter Appointment's ID to delete: ");
        int id = EasyScanner.nextInt();
        appointmentList.deleteAppointment(id);
    }

    // create a method to list appointment
    public static void checkAppointment() {
        System.out.println("Enter Patient's ID to check appointment: ");
        int patientId = EasyScanner.nextInt();
        if (appointmentList.isEmpty()) {
            System.out.println("No appointment found!");
            return;
        } else {
            appointmentList.checkAppointmentByPatientId(patientId);
        }
    }
}

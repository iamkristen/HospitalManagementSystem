package CLI;
import classes.Appointment;
import controller.AppointmentController;
import utils.EasyScanner;
import utils.TextColor;
import utils.UniqueIdGenerator;

public class AppointmentInterfacce {
    public static AppointmentController appointmentList = new AppointmentController();

    // create a method to add appointment
    public static void addAppointment() {
        try{
            int id = UniqueIdGenerator.generateUniqueId();
            EasyScanner.nextString();
            System.out.println("Enter Appointment's Time: ");
            String time = EasyScanner.nextString();
            System.out.println("Enter Doctor's ID: ");
            int doctorId = EasyScanner.nextInt();
            System.out.println("Enter Patient's ID: ");
            int patientId = EasyScanner.nextInt();
            Appointment appointment = new Appointment(id, time, doctorId, patientId);
            appointment.setDoctorName(DoctorInterface.doctorList.getDoctorName(doctorId));
            appointment.setPatientName(PatientInterface.patientList.getPatientName(patientId));
            appointmentList.addAppointment(appointment);
            System.out.println(TextColor.GREEN+"Appointment added successfully!"+TextColor.RESET);
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
            System.out.println(TextColor.RED+"No appointment found!"+TextColor.RESET);
            return;
        } else {
            appointmentList.checkAppointmentByPatientId(patientId);
        }
    }

    // create a method to save the Doctor data to the local file
    public static void saveData() {
        appointmentList.saveData();
    }

    // create a method to load the Doctor data from the local file
    public static void loadData() {
        appointmentList.loadData();
    }
}

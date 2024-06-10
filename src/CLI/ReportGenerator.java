package CLI;

import classes.Appointment;
import classes.Diagnosis;
import classes.Doctor;
import classes.Patient;
import classes.Treatment;
import helper.EasyScanner;

public class ReportGenerator {
    int reportId;
    // constructor for report generator class where we are taking patient id to find
    // the
    // patient details and report id to generate the report

    public ReportGenerator(int reportId, int patientId) {
        this.reportId = reportId;
    }

    public int getreportId() {
        return reportId;
    }

    // Formatting the report in a readable format and printing the report
    public static void generateReport(Appointment appointment, Patient patient, Doctor doctor, Diagnosis diagnosis,
            Treatment treatment) {
        // Print report header
        System.out.println("\u001B[35m" + "-------------- Final Report --------------" + "\u001B[0m");

        // Print appointment details
        System.out.println("\u001B[36m" + "Appointment ID: " + appointment.getId());
        System.out.println("Time: " + appointment.getTime());

        // Print patient details
        System.out.println("\nPatient ID: " + patient.getId());
        System.out.println("Name: " + patient.getName());
        System.out.println("Contact Number: " + patient.getPhone());

        // Print doctor details
        System.out.println("\nDoctor ID: " + doctor.getid());
        System.out.println("Name: " + doctor.getname());
        System.out.println("Specialization: " + doctor.getspecialization());

        // Print diagnosis details
        System.out.println("\nDiagnosis ID: " + diagnosis.getId());
        System.out.println("Diagnosis: " + diagnosis.getDiagnosis());

        // Print treatment details
        System.out.println("\nTreatment ID: " + treatment.getId());
        System.out.println("Treatment: " + treatment.getTreatment() + "\u001B[0m");

        // Print report footer
        System.out.println("\u001B[35m" + "\n-------------- End of Report --------------" + "\u001B[0m");
    }

    public static void getReport() {
        try {
            System.out.println("Enter the patient ID to generate the report: ");
            int patientId = EasyScanner.nextInt();
            Patient patient = PatientInterface.patientList.getPatient(patientId);
            Appointment appointment = AppointmentInterface.appointmentList.getAppointment(patientId);
            Doctor doctor = DoctorInterface.doctorList.getDoctor(appointment.getdoctorId());
            Diagnosis diagnosis = DiagnosisInterface.diagnosisList.getDiagnosis(patientId);
            Treatment treatment = TreatmentInterface.treatmentList.getTreatment(patientId);
            generateReport(appointment, patient, doctor, diagnosis, treatment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // to print all the details of the report in tabluar format
    // @Override
    // public String toString() {
    // return String.format("| %-10s | %-10s |", "Report ID", "Patient ID") +
    // String.format("\n| %-10d | %-10d |", reportId, patientId);
    // }

}

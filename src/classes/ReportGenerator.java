package classes;
import controller.AppointmentController;
import controller.DiagnosisController;
import controller.DoctorController;
import controller.PatientController;
import controller.TreatmentController;
import utils.EasyScanner;

public class ReportGenerator {
    int reportId;
    // constructor for report generator class where we are taking patient id to find the 
    // patient details and report id to generate the report

public ReportGenerator(int reportId, int patientId) {
        this.reportId = reportId;
    }

    public int getreportId() {
        return reportId;
    }

    // Formatting the report in a readable format and printing the report
    public static void generateReport(Appointment appointment, Patient patient, Doctor doctor, Diagnosis diagnosis, Treatment treatment) {
        // Print report header
        System.out.println("-------------- Final Report --------------");
        
        // Print appointment details
        System.out.println("Appointment ID: " + appointment.getid());
        System.out.println("Time: " + appointment.gettime());
        
        // Print patient details
        System.out.println("\nPatient ID: " + patient.getid());
        System.out.println("Name: " + patient.getname());
        System.out.println("Contact Number: " + patient.getPhone());
        
        // Print doctor details
        System.out.println("\nDoctor ID: " + doctor.getid());
        System.out.println("Name: " + doctor.getname());
        System.out.println("Specialization: " + doctor.getspecialization());
        
        // Print diagnosis details
        System.out.println("\nDiagnosis ID: " + diagnosis.getDiagnosis_id());
        System.out.println("Diagnosis: " + diagnosis.getDiagnosis());
        
        // Print treatment details
        System.out.println("\nTreatment ID: " + treatment.getTreatmentid());
        System.out.println("Treatment: " + treatment.getTreatment());
        
        // Print report footer
        System.out.println("\n-------------- End of Report --------------");
    }

    public static void getReport() {
        try{
            System.out.println("Enter the patient ID to generate the report: ");
            int patientId = EasyScanner.nextInt();
            Patient patient = PatientController.patientList.getPatient(patientId); 
            Appointment appointment = AppointmentController.appointmentList.getAppointment(patientId);
            Doctor doctor = DoctorController.doctorList.getDoctor(appointment.getdoctorId());
            Diagnosis diagnosis = DiagnosisController.diagnosisList.getDiagnosis(patientId);
            Treatment treatment = TreatmentController.treatmentList.getTreatment(patientId);
            generateReport(appointment, patient, doctor, diagnosis, treatment);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }

    // to print all the details of the report in tabluar format
    // @Override
    // public String toString() {
    //     return String.format("| %-10s | %-10s |", "Report ID", "Patient ID") + 
    //            String.format("\n| %-10d | %-10d |", reportId, patientId);
    // }

}

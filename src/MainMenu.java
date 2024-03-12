import controller.PatientController;
import controller.TreatmentController;
import classes.ReportGenerator;
import controller.AppointmentController;
import controller.DiagnosisController;
import controller.DoctorController;
import utils.EasyScanner;

public class MainMenu {
    public static void main(String[] args) throws Exception {
        System.out.println("============Welcome to the Hospital Management System============");
        menu();

    }
    // menu method to print the all the options
    public static void menu() {
        System.out.println("Choose the following options [1-14]:");
        System.out.println("1. Add Doctor");
        System.out.println("2. Delete Doctor");
        System.out.println("3. List Doctor");
        System.out.println("4. Add Patient");
        System.out.println("5. Delete Patient");
        System.out.println("6. List Patient");
        System.out.println("7. create Appointment");
        System.out.println("8. Check Appointment");
        System.out.println("9. Create Diagnosis");
        System.out.println("10. Check Diagnosis");
        System.out.println("11. Create Treatment");
        System.out.println("12. Check Treatment");
        System.out.println("13. Generate Report");
        System.out.println("14. Save & Exit");

        // using loops to get the user input until the user enter the exit option
        // using switch case to perform the operations based on the user input
        int choice;
        do {
            System.out.println("Enter your choice [1-14]: ");
            choice = EasyScanner.nextInt();
            switch (choice) {
                case 1:
                    DoctorController.addDoctor();
                    break;
                case 2:
                    DoctorController.deleteDoctor();
                    break;
                case 3:
                    DoctorController.listDoctor();
                    break;
                case 4:
                    PatientController.addPatient();
                    break;
                case 5: 
                    PatientController.deletePatient();
                    break;
                case 6: 
                    PatientController.listPatient();
                    break;
                case 7: 
                    AppointmentController.addAppointment();
                    break;
                case 8:
                    AppointmentController.checkAppointment();
                    break;
                case 9:
                    DiagnosisController.addDiagnosis();
                    break;
                case 10:
                    DiagnosisController.checkDiagnosis();
                    break;
                case 11:    
                    TreatmentController.addTreatment();
                    break;
                case 12:
                    TreatmentController.checkTreatment();
                    break;
                case 13:
                    ReportGenerator.getReport();
                    break;
                case 14:
                    System.out.println("Thank you for using the Hospital Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
            }
        } while (choice != 14);
    }


}

import org.w3c.dom.Text;

import CLI.AppointmentInterfacce;
import CLI.DiagnosisInterface;
import CLI.DoctorInterface;
import CLI.PatientInterface;
import CLI.TreatmentInterface;
import classes.ReportGenerator;
import utils.EasyScanner;
import utils.TextColor;

public class MainMenu {
    public static void main(String[] args) throws Exception {
        System.out.println(TextColor.YELLOW+"============ Welcome to the Hospital Management System ============"+TextColor.RESET);
        loadData();
        menu();

    }
    // menu method to print the all the options
    public static void menu() {
        System.out.println("Choose the following options "+TextColor.BLUE +"[1-14]"+TextColor.RESET+":");
        System.out.println(TextColor.YELLOW+"1. Add Doctor");
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
        System.out.println("13. Generate Report"+TextColor.RESET);
        System.out.println(TextColor.RED+"14. Save & Exit"+TextColor.RESET);

        // using loops to get the user input until the user enter the exit option
        // using switch case to perform the operations based on the user input
        int choice;
        do {
            System.out.println("Enter your choice "+TextColor.BLUE +"[1-14]"+TextColor.RESET+":");
            choice = EasyScanner.nextInt();
            switch (choice) {
                case 1:
                    DoctorInterface.addDoctor();
                    break;
                case 2:
                    DoctorInterface.deleteDoctor();
                    break;
                case 3:
                    DoctorInterface.listDoctor();
                    break;
                case 4:
                    PatientInterface.addPatient();
                    break;
                case 5: 
                    PatientInterface.deletePatient();
                    break;
                case 6: 
                    PatientInterface.listPatient();
                    break;
                case 7: 
                    AppointmentInterfacce.addAppointment();
                    break;
                case 8:
                    AppointmentInterfacce.checkAppointment();
                    break;
                case 9:
                    DiagnosisInterface.addDiagnosis();
                    break;
                case 10:
                    DiagnosisInterface.checkDiagnosis();
                    break;
                case 11:    
                    TreatmentInterface.addTreatment();
                    break;
                case 12:
                    TreatmentInterface.checkTreatment();
                    break;
                case 13:
                    ReportGenerator.getReport();
                    break;
                case 14:
                    saveData();
                    System.out.println(TextColor.YELLOW+"Thank you for using the Hospital Management System!"+TextColor.RESET);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
            }
        } while (choice != 14);
    }

    public static void saveData() {
        DoctorInterface.saveData();
        PatientInterface.saveData();
        AppointmentInterfacce.saveData();
        DiagnosisInterface.saveData();
        TreatmentInterface.saveData();
        System.out.println(TextColor.GREEN+"[#] Data saved successfully."+TextColor.RESET);
    }

    public static void loadData() {
        DoctorInterface.loadData();
        PatientInterface.loadData();
        AppointmentInterfacce.loadData();
        DiagnosisInterface.loadData();
        TreatmentInterface.loadData();
        System.out.println(TextColor.GREEN+"[#] Data load successfully."+TextColor.RESET);
    }

}

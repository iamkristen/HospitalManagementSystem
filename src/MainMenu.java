import CLI.AppointmentInterface;
import CLI.DiagnosisInterface;
import CLI.DoctorInterface;
import CLI.PatientInterface;
import CLI.ReportGenerator;
import CLI.TreatmentInterface;
import helper.EasyScanner;

public class MainMenu {
    public static void main(String[] args) {
        System.out.println("\u001B[33m" + "============ Welcome to the Hospital Management System ============"
                + "\u001B[0m");
        loadData();
        menu();

    }

    // Show doctor menu
    public static void showDoctorList() {

        int choice;
        do {
            System.out.println("Choose the following options " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            System.out.println("\u001B[33m" + "1. Add Doctor");
            System.out.println("2. Delete Doctor");
            System.out.println("3. List Doctor");
            System.out.println("4. Back to Main Menu" + "\u001B[0m");

            System.out.println("Enter your choice " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
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
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }
        } while (choice != 4);
    }

    // show patient menu
    public static void showPatientMenu() {
        int choice;
        do {
            System.out.println("Choose the following options " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            System.out.println("\u001B[33m" + "1. Add Patient");
            System.out.println("2. Delete Patient");
            System.out.println("3. List Patient");
            System.out.println("4. Back to Main Menu" + "\u001B[0m");

            System.out.println("Enter your choice " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            choice = EasyScanner.nextInt();
            switch (choice) {
                case 1:
                    PatientInterface.addPatient();
                    break;
                case 2:
                    PatientInterface.deletePatient();
                    break;
                case 3:
                    PatientInterface.listPatient();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }
        } while (choice != 4);
    }

    // show appointment menu
    public static void showAppointmentMenu() {
        int choice;
        do {
            System.out.println("Choose the following options " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            System.out.println("\u001B[33m" + "1. Create Appointment");
            System.out.println("2. List Appointment");
            System.out.println("3. Check Appointment by Patient");
            System.out.println("4. Back to Main Menu" + "\u001B[0m");

            System.out.println("Enter your choice " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            choice = EasyScanner.nextInt();
            switch (choice) {
                case 1:
                    AppointmentInterface.addAppointment();
                    break;
                case 2:
                    AppointmentInterface.listAppointment();
                    break;
                case 3:
                    AppointmentInterface.checkAppointment();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }
        } while (choice != 4);
    }

    // show diagnosis menu
    public static void showDiagnosisMenu() {
        int choice;
        do {
            System.out.println("Choose the following options " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            System.out.println("\u001B[33m" + "1. Create Diagnosis");
            System.out.println("2. List Diagnosis");
            System.out.println("3. Check Diagnosis by Patient");
            System.out.println("4. Back to Main Menu" + "\u001B[0m");

            System.out.println("Enter your choice " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            choice = EasyScanner.nextInt();
            switch (choice) {
                case 1:
                    DiagnosisInterface.addDiagnosis();
                    break;
                case 2:
                    DiagnosisInterface.listDiagnosis();
                    break;
                case 3:
                    DiagnosisInterface.checkDiagnosis();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }
        } while (choice != 4);
    }

    // show treatment menu
    public static void showTreatmentMenu() {
        int choice;
        do {
            System.out.println("Choose the following options " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            System.out.println("\u001B[33m" + "1. Create Treatment");
            System.out.println("2. List Treatment");
            System.out.println("3. Check Treatment by Patient");
            System.out.println("4. Back to Main Menu" + "\u001B[0m");

            System.out.println("Enter your choice " + "\u001B[34m" + "[1-4]" + "\u001B[0m" + ":");
            choice = EasyScanner.nextInt();
            switch (choice) {
                case 1:
                    TreatmentInterface.addTreatment();
                    break;
                case 2:
                    TreatmentInterface.listTreatment();
                    break;
                case 3:
                    TreatmentInterface.checkTreatment();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }
        } while (choice != 4);
    }

    // menu method to print the all the options
    public static void menu() {
        int choice;
        do {
            System.out.println("Choose the following options " + "\u001B[34m" + "[1-7]" + "\u001B[0m" + ":");
            System.out.println("\u001B[33m" + "1. Doctor");
            System.out.println("2. Patient");
            System.out.println("3. Appointment");
            System.out.println("4. Diagnosis");
            System.out.println("5. Treatment");
            System.out.println("6. Generate Report" + "\u001B[0m");
            System.out.println("\u001B[31m" + "7. Save & Exit" + "\u001B[0m");

            // using loops to get the user input until the user enter the exit option
            // using switch case to perform the operations based on the user input

            System.out.println("Enter your choice " + "\u001B[34m" + "[1-7]" + "\u001B[0m" + ":");
            choice = EasyScanner.nextInt();
            switch (choice) {
                case 1:
                    showDoctorList();
                    break;
                case 2:
                    showPatientMenu();
                    break;
                case 3:
                    showAppointmentMenu();
                    break;
                case 4:
                    showDiagnosisMenu();
                    break;
                case 5:
                    showTreatmentMenu();
                    break;
                case 6:
                    ReportGenerator.getReport();
                    break;
                case 7:
                    saveData();
                    System.out.println(
                            "\u001B[33m" + "Thank you for using the Hospital Management System!" + "\u001B[0m");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
            }
        } while (choice != 7);
    }

    public static void saveData() {
        DoctorInterface.saveData();
        PatientInterface.saveData();
        AppointmentInterface.saveData();
        DiagnosisInterface.saveData();
        TreatmentInterface.saveData();
        System.out.println("\u001B[32m" + "[#] Data saved successfully." + "\u001B[0m");
    }

    public static void loadData() {
        DoctorInterface.loadData();
        PatientInterface.loadData();
        AppointmentInterface.loadData();
        DiagnosisInterface.loadData();
        TreatmentInterface.loadData();
        System.out.println("\u001B[32m" + "[#] Data load successfully." + "\u001B[0m");
    }

}

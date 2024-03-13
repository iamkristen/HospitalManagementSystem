package CLI;
import classes.Patient;
import controller.PatientController;
import utils.EasyScanner;
import utils.TextColor;
import utils.UniqueIdGenerator;

public class PatientInterface {
    public static PatientController patientList = new PatientController();
    static String format = "%-5s %-20s %-30s %n";


    // created a method to add patient
    public static void addPatient() {
        try{
         int id = UniqueIdGenerator.generateUniqueId();
         EasyScanner.nextString();
         System.out.println("Enter Patient's Name: ");  
         String name = EasyScanner.nextString();
         System.out.println("Enter Patient's contact number: ");
         String contact = EasyScanner.nextString();
         Patient patient = new Patient(id, name, contact);
         patientList.addPatient(patient);
         System.out.println(TextColor.GREEN+"Patient added successfully!"+TextColor.RESET);
         System.out.println("===================================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // created a method to delete patient
    public static void deletePatient() {
        System.out.println("Enter Patient's ID to delete: ");
        int id = EasyScanner.nextInt();
        patientList.deletePatient(id);
    }

    // created a method to list patient
    public static void listPatient() {
        if(patientList.isEmpty()){
            System.out.println(TextColor.RED+"No patient found!"+TextColor.RESET);
            return;
        }else{
            System.out.println(TextColor.YELLOW+"========== List of Patients ========================="+TextColor.RESET);
            System.out.println(String.format(format, "ID", "Name", "Contact Number"));
            patientList.listPatient();
            System.out.println("=======================================");

        }
    }

    // create a method to save the Doctor data to the local file
    public static void saveData() {
        patientList.saveData();
    }

    // create a method to load the Doctor data from the local file
    public static void loadData() {
        patientList.loadData();
    }
    
}

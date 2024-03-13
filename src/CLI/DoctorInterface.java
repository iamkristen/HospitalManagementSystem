package CLI;
import classes.Doctor;
import controller.DoctorController;
import utils.EasyScanner;
import utils.TextColor;
import utils.UniqueIdGenerator;

public class DoctorInterface {
    public static DoctorController doctorList = new DoctorController();
    static String format = "%-5s %-20s %-30s %n";
    
    // create a method to add doctor
    public static void addDoctor() {
        int id = UniqueIdGenerator.generateUniqueId();
        EasyScanner.nextString();
        System.out.println("Enter Doctor's Name: ");  
        String name = EasyScanner.nextString();
        System.out.println("Enter Doctor's Specialization: ");
        String specialization = EasyScanner.nextString();
        Doctor doctor = new Doctor(id, name, specialization);
        doctorList.addDoctor(doctor);
        System.out.println(TextColor.GREEN+"Doctor added successfully!"+TextColor.RESET);
        System.out.println("===================================");
    }

    // create a method to delete doctor
    public static void deleteDoctor() {
        System.out.println("Enter Doctor's ID to delete: ");
        int id = EasyScanner.nextInt();
        doctorList.deleteDoctor(id);
    }

    // create a method to list doctor
    public static void listDoctor() {
        if(doctorList.isEmpty()){
            System.out.println(TextColor.RED+"No doctor found!"+TextColor.RESET);
            return;
        }else{
        System.out.println(TextColor.YELLOW+"========== List of Doctors ========================="+TextColor.RESET);
        System.out.println(String.format(format, "ID", "Name", "Specialization"));
        doctorList.listDoctor();
        System.out.println("===================================");
        }
    }

    // create a method to save the Doctor data to the local file
    public static void saveData() {
        doctorList.saveData();
    }

    // create a method to load the Doctor data from the local file
    public static void loadData() {
        doctorList.loadData();
    }
}

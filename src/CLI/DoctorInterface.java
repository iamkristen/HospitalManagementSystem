package CLI;

import java.util.Random;

import classes.Doctor;
import controller.DoctorController;
import helper.EasyScanner;

public class DoctorInterface {
    public static DoctorController doctorList = new DoctorController();
    static String format = "%-5s %-20s %-30s %n";

    // create a method to add doctor
    public static void addDoctor() {
        int id = generateUniqueId();
        EasyScanner.nextString();
        System.out.println("Enter Doctor's Name: ");
        String name = EasyScanner.nextString();
        System.out.println("Enter Doctor's Specialization: ");
        String specialization = EasyScanner.nextString();
        Doctor doctor = new Doctor(id, name, specialization);
        doctorList.addDoctor(doctor);
        System.out.println("\u001B[32m" + "Doctor added successfully!" + "\u001B[0m");
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
        if (doctorList.isEmpty()) {
            System.out.println("\u001B[31m" + "No doctor found!" + "\u001B[0m");
            return;
        } else {
            System.out.println(
                    "\u001B[33m" + "========== List of Doctors =========================" + "\u001B[0m");
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

    public static int generateUniqueId() {
        Random rand = new Random();
        return rand.nextInt((999 - 1) + 1) + 1;
    }
}

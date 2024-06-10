package controller;

import java.util.ArrayList;

import classes.Doctor;
import helper.DataHandler;

public class DoctorController {
    private static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    private static String filename = "doctors.dat";

    // to add doctor in list of doctors
    public static void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }

    public static ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    // to delete doctor from list of doctors
    public void deleteDoctor(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == id) {
                doctorList.remove(doctor);
                System.out.println("\u001B[32m" + "Doctor deleted successfully!" + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m" + "Doctor not found!" + "\u001B[0m");
    }

    // to list all doctors
    public void listDoctor() {
        for (Doctor doctor : doctorList) {
            System.out.println("\u001B[36m" + doctor + "\u001B[0m");
        }
    }

    // to check list of doctors is empty or not
    public boolean isEmpty() {
        return doctorList.isEmpty();
    }

    // to get doctor by id
    public Doctor getDoctor(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == id) {
                return doctor;
            }
        }
        throw new IllegalArgumentException("\u001B[31m" + "Doctor not found!" + "\u001B[0m");
    }

    // get all doctor names
    public ArrayList<String> getAllDoctorNames() {
        ArrayList<String> doctorNames = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            doctorNames.add(doctor.getname());
        }
        return doctorNames;
    }

    // to get doctor name by id
    public String getDoctorName(int doctorId) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == doctorId) {
                return doctor.getname();
            }
        }
        throw new IllegalArgumentException("\u001B[31m" + "Doctor not found!" + "\u001B[0m");
        // return null;
    }

    // to get doctor by name
    public Doctor getDoctorByName(String name) {
        for (Doctor doctor : doctorList) {
            if (doctor.getname().equals(name)) {
                return doctor;
            }
        }
        throw new IllegalArgumentException("\u001B[31m" + "Doctor not found!" + "\u001B[0m");
    }

    // to Save the Doctor data to the local file
    public void saveData() {
        DataHandler.saveData(doctorList, filename);
    }

    // to load Data from local file
    public void loadData() {
        doctorList = DataHandler.getData(filename);

    }
}

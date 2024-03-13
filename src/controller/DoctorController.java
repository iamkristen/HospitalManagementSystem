package controller;

import java.util.ArrayList;
import Data.DataHandler;
import classes.Doctor;
import utils.TextColor;

public class DoctorController {
    private static ArrayList <Doctor> doctorList = new ArrayList<Doctor>();
    private static String filename = "doctors.dat";

    // to add doctor in list of doctors
    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }

    // to delete doctor from list of doctors
    public void deleteDoctor(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == id) {
                doctorList.remove(doctor);
                System.out.println(TextColor.GREEN+"Doctor deleted successfully!"+TextColor.RESET);
                return;
            }
        }
        System.out.println(TextColor.RED+"Doctor not found!"+TextColor.RESET);
    }

    // to list all doctors
    public void listDoctor() {
        for (Doctor doctor : doctorList) {
            System.out.println(TextColor.CYAN+doctor+TextColor.RESET);
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
        throw new IllegalArgumentException(TextColor.RED+"Doctor not found!"+TextColor.RESET);
    }

    // to get doctor name by id
    public String getDoctorName(int doctorId) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == doctorId) {
                return doctor.getname();
            }
        }
        throw new IllegalArgumentException(TextColor.RED+"Doctor not found!"+TextColor.RESET);
        // return null;
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

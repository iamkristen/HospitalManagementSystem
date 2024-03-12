package classes;
import java.util.ArrayList;

public class DoctorList {
    private ArrayList <Doctor> doctorList = new ArrayList<Doctor>();

// to add doctor in list of doctors
    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }

    // to delete doctor from list of doctors
    public void deleteDoctor(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == id) {
                doctorList.remove(doctor);
                System.out.println("Doctor deleted successfully!");
                return;
            }
        }
        System.out.println("Doctor not found!");
    }

    // to list all doctors
    public void listDoctor() {
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    // to check list of doctors is empty or not
    public boolean isEmpty() {
        return doctorList.isEmpty();
    }

    public Doctor getDoctor(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == id) {
                return doctor;
            }
        }
        throw new IllegalArgumentException("Doctor not found!");
    }

    public String getDoctorName(int doctorId) {
        for (Doctor doctor : doctorList) {
            if (doctor.getid() == doctorId) {
                return doctor.getname();
            }
        }
        throw new IllegalArgumentException("Doctor not found!");
        // return null;
    }
}

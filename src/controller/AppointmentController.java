package controller;

import java.util.ArrayList;
import classes.Appointment;
import helper.DataHandler;

public class AppointmentController {
    private static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    private static String filename = "appointments.dat";

    // to add appointment in list of appointments
    public static void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    // to get appointment list
    public static ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    // to delete appointment from list of appointments
    public void deleteAppointment(int id) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getId() == id) {
                appointmentList.remove(appointment);
                System.out.println("\u001B[32m" + "Appointment deleted successfully!" + "\u001B[0m");
                return;
            }
        }
        System.out
                .println("\u001B[31m" + "\u001B[31m" + "Appointment not found!" + "\u001B[0m" + "\u001B[0m");
    }

    // to list all appointments
    public void listAppointment() {
        System.out.println(
                "\u001B[33m" + "========== List of Appointments =========================" + "\u001B[0m");
        System.out.println(String.format("%-5s %-20s %-20s %-20s %n", "ID", "Time", "Doctor Name", "Patient Name"));
        for (Appointment appointment : appointmentList) {
            System.out.println("\u001B[36m" + appointment + "\u001B[0m");
        }
        System.out.println("===================================");
    }

    // to get appointment from list of appointments
    public Appointment getAppointment(int id) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getpatientId() == id) {
                return appointment;
            }
        }
        throw new IllegalArgumentException("\u001B[31m" + "Appointment not found!" + "\u001B[0m");
    }

    // to check appointment by patient id
    public void checkAppointmentByPatientId(int patientId) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getpatientId() == patientId) {
                System.out.println("\u001B[33m" + "========== List of Appointments ========================="
                        + "\u001B[0m");
                System.out.println(
                        String.format("%-5s %-20s %-20s %-20s %n", "ID", "Time", "Doctor Name", "Patient Name"));
                System.out.println("\u001B[36m" + appointment + "\u001B[0m");
                System.out.println("===================================");
                return;
            }
        }
        System.out.println("\u001B[31m" + "No appointment found!" + "\u001B[0m");
        System.out.println("===================================");
    }

    // to check list of appointments is empty or not
    public boolean isEmpty() {
        return appointmentList.isEmpty();
    }

    // created to save appointmentList to local file
    public void saveData() {
        DataHandler.saveData(appointmentList, filename);
    }

    // Created to load data from local file
    public void loadData() {
        appointmentList = DataHandler.getData(filename);
    }

}

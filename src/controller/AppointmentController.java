package controller;
import java.util.ArrayList;

import Data.DataHandler;
import classes.Appointment;
import utils.TextColor;

public class AppointmentController {
    private static ArrayList <Appointment> appointmentList = new ArrayList<Appointment>();
    private static String filename = "appointments.dat";

    // to add appointment in list of appointments
    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    // to delete appointment from list of appointments
    public void deleteAppointment(int id) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getid() == id) {
                appointmentList.remove(appointment);
                System.out.println(TextColor.GREEN+"Appointment deleted successfully!"+TextColor.RESET);
                return;
            }
        }
        System.out.println(TextColor.RED+TextColor.RED+"Appointment not found!"+TextColor.RESET+TextColor.RESET);
    }

    // to list all appointments
    public void listAppointment() {
        for (Appointment appointment : appointmentList) {

            System.out.println(appointment);
        }
    }

    // to get appointment from list of appointments
    public Appointment getAppointment(int id) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getpatientId() == id) {
                return appointment;
            }
        }
        throw new IllegalArgumentException(TextColor.RED+"Appointment not found!"+TextColor.RESET);
    }

    //to check appointment by patient id
    public void checkAppointmentByPatientId(int patientId) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getpatientId() == patientId) {
                System.out.println(TextColor.YELLOW+"========== List of Appointments ========================="+TextColor.RESET);
                System.out.println(String.format("%-5s %-20s %-20s %-20s %n", "ID", "Time", "Doctor Name", "Patient Name"));
                System.out.println(TextColor.CYAN+appointment+TextColor.RESET);
                System.out.println("===================================");
            }else{
                System.out.println(TextColor.RED+"No appointment found!"+TextColor.RESET);
                System.out.println("===================================");
            }
        }
    }

    // to check list of appointments is empty or not
    public boolean isEmpty() {
        return appointmentList.isEmpty();
    }

    //created to save appointmentList to local file 
    public void saveData(){
        DataHandler.saveData(appointmentList, filename);
    }

    // Created to load data from local file
    public void loadData(){
        appointmentList = DataHandler.getData(filename);
    }

}

package components;

import CLI.DoctorInterface;
import CLI.PatientInterface;
import classes.Appointment;
import classes.Doctor;
import classes.Patient;
import controller.AppointmentController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Ansi;
import utils.TextStyle;
import utils.UniqueIdGenerator;

public class AddAppointment {

    public static Stage getPopUpStage(TableView<Appointment> appointmentTable) {

        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Add Appointment");
        popup.initStyle(StageStyle.UTILITY);

        // Creating a button to go back to the home screen and adding it to the navbar
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);

        // Creating a title label and adding it to the navbar
        Label title = new Label("Add Appointment");
        title.setStyle(TextStyle.getTextStyle("#ffffff", "24px", "bold"));

        // Created labels and text fields for Appointment data
        Label timeSlotLabel = new Label("Time Slot:");
        timeSlotLabel.setStyle(TextStyle.getTextStyle("#000000", "14px", "normal"));
        HBox timeSlot = TimePicker.getTimePicker();

        // Creating ComboBox for doctor names
        ComboBox<String> doctorComboBox = new ComboBox<>();
        doctorComboBox.autosize();
        doctorComboBox.setPromptText("Select Doctor");
        doctorComboBox.setItems(FXCollections.observableArrayList(DoctorInterface.doctorList.getAllDoctorNames()));

        // Creating ComboBox for patient names
        ComboBox<String> patientComboBox = new ComboBox<>();
        patientComboBox.autosize();
        patientComboBox.setPromptText("Select Patient");
        patientComboBox.setItems(FXCollections.observableArrayList(PatientInterface.patientList.getAllPatientNames()));

        // Added labels and text fields to the layout
        layout.add(timeSlotLabel, 0, 0);
        layout.add(timeSlot, 1, 0);
        layout.add(doctorComboBox, 1, 1);
        layout.add(patientComboBox, 1, 2);

        // Created a button to add the doctor data
        Button addButton = CustomButton.newButton("Add Appointment", "file:src/assets/add.png");
        addButton.setOnAction(event -> {
            try {
                String time = TimePicker.getTimeFromPicker(timeSlot);
                Doctor doctor = DoctorInterface.doctorList.getDoctorByName(doctorComboBox.getValue());
                Patient patient = PatientInterface.patientList.getPatientByName(patientComboBox.getValue());

                // validating the appointment data
                if (time.isEmpty() || doctorComboBox.getValue() == null || patientComboBox.getValue() == null) {
                    CustomAlert.alertBox("Error", "Please fill all the fields.", "file:src/assets/error.png",
                            Alert.AlertType.ERROR);
                    return;
                }
                Appointment appointment = new Appointment(UniqueIdGenerator.generate(), time, doctor.getid(),
                        patient.getId());
                AppointmentController.addAppointment(appointment);
                appointmentTable.getItems().add(appointment);
                CustomAlert.alertBox("Success", "Appointment added successfully.",
                        "file:src/assets/success.png",
                        Alert.AlertType.INFORMATION);
                popup.close();
            } catch (Exception e) {
                CustomAlert.alertBox("Error", Ansi.remove(e.getMessage()), "file:src/assets/error.png",
                        Alert.AlertType.ERROR);
            }
        });
        layout.add(addButton, 1, 3);

        // Create a scene with the layout
        Scene scene = new Scene(layout, 450, 220);
        popup.setScene(scene);
        popup.showAndWait();
        return popup;
    }
}

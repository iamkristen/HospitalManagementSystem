package components;

import classes.Patient;
import controller.PatientController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Ansi;
import utils.TextStyle;
import utils.UniqueIdGenerator;

public class AddPatient {

    public static Stage getPopUpStage(TableView<Patient> patientTable) {

        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Add Patient");
        popup.initStyle(StageStyle.UTILITY);

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);

        // Labels and text fields for patient data
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle(TextStyle.getTextStyle("#000000", "14px", "normal"));
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Patient Name");
        nameField.setMinWidth(250);

        Label contactNumberLabel = new Label("Contact Number:");
        contactNumberLabel.setStyle(TextStyle.getTextStyle("#000000", "14px", "normal"));
        TextField contactNumberField = new TextField();
        contactNumberField.setPromptText("Contact Number including country code");
        contactNumberField.setMinWidth(250);

        layout.add(nameLabel, 0, 0);
        layout.add(nameField, 1, 0);
        layout.add(contactNumberLabel, 0, 1);
        layout.add(contactNumberField, 1, 1);

        // Button to add the patient data
        Button addButton = CustomButton.newButton("Add Patient", "file:src/assets/add.png");
        addButton.setOnAction(event -> {
            try {
                String name = nameField.getText();
                String contactNumber = contactNumberField.getText();
                if (!validatePatientData(name, contactNumber)) {
                    return;
                }
                Patient patient = new Patient(UniqueIdGenerator.generate(), name, contactNumber);
                PatientController.addPatient(patient);
                patientTable.getItems().add(patient);
                CustomAlert.alertBox("Success", "Patient added successfully.", "file:src/assets/success.png",
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

    private static boolean validatePatientData(String name, String contactNumber) {
        if (name.isEmpty() || contactNumber.isEmpty()) {
            CustomAlert.alertBox("Error", "Please fill all the fields.", "file:src/assets/error.png",
                    AlertType.ERROR);
            return false;
        }
        if (!contactNumber.matches("[0-9]+")) {
            CustomAlert.alertBox("Error", "Contact Number should be a number.", "file:src/assets/error.png",
                    AlertType.ERROR);
            return false;
        }
        if (contactNumber.length() > 11 || contactNumber.length() < 9) {
            CustomAlert.alertBox("Error", "Please enter correct contact number.", "file:src/assets/error.png",
                    AlertType.ERROR);
            return false;
        }
        return true;
    }

}

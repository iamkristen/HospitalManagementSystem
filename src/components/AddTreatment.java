package components;

import CLI.PatientInterface;
import classes.Patient;
import classes.Treatment;
import controller.TreatmentController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Ansi;
import utils.TextStyle;
import utils.UniqueIdGenerator;

public class AddTreatment {

    public static Stage getPopUpStage(TableView<Treatment> treatmentTable) {

        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Add Treatment");
        popup.initStyle(StageStyle.UTILITY);

        // Creating a button to go back to the home screen and adding it to the navbar
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);

        // Creating a title label and adding it to the navbar
        Label title = new Label("Add Treatment");
        title.setStyle(TextStyle.getTextStyle("#ffffff", "24px", "bold"));

        // Created labels and text fields for doctor data
        Label patientLabel = new Label("Patient Name:");
        patientLabel.setStyle(TextStyle.getTextStyle("#000000", "14px", "normal"));

        // Creating ComboBox for Patient names
        ComboBox<String> patientComboBox = new ComboBox<>();
        patientComboBox.autosize();
        patientComboBox.setPromptText("Select Patient");
        patientComboBox.setItems(FXCollections.observableArrayList(PatientInterface.patientList.getAllPatientNames()));

        // Creating TextArea for Treatment details
        TextArea treatmentField = new TextArea();
        treatmentField.setPromptText("Enter Treatment Details");
        treatmentField.setMinWidth(250);
        treatmentField.setMinHeight(100);

        // Added labels and text fields to the layout
        layout.add(patientLabel, 0, 0);
        layout.add(patientComboBox, 1, 0);
        // layout.add(TreatmentField, 0, 1);

        // Created a button to add the doctor data
        Button addButton = CustomButton.newButton("Add Treatment", "file:src/assets/add.png");
        addButton.setOnAction(event -> {
            try {
                Patient patient = PatientInterface.patientList.getPatientByName(patientComboBox.getValue());
                String treatmentDetails = treatmentField.getText();
                if (treatmentDetails.isEmpty() || patient == null) {
                    CustomAlert.alertBox("Error", "Please fill all the fields.", "file:src/assets/error.png",
                            Alert.AlertType.ERROR);
                    return;
                }
                Treatment treatment = new Treatment(UniqueIdGenerator.generate(), patient.getId(), treatmentDetails);
                TreatmentController.addTreatment(treatment);
                treatmentTable.getItems().add(treatment);
                CustomAlert.alertBox("Success", "Treatment added successfully.",
                        "file:src/assets/success.png",
                        Alert.AlertType.INFORMATION);
                popup.close();
            } catch (Exception e) {
                CustomAlert.alertBox("Error", Ansi.remove(e.getMessage()), "file:src/assets/error.png",
                        Alert.AlertType.ERROR);
            }
        });
        // layout.add(addButton, 1, 2);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(layout, treatmentField, addButton);

        // Create a scene with the layout
        Scene scene = new Scene(vBox, 450, 220);
        popup.setScene(scene);
        popup.showAndWait();
        return popup;
    }
}

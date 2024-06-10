package components;

import classes.Doctor;
import controller.DoctorController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.TextStyle;
import utils.UniqueIdGenerator;

public class AddDoctor {

    public static Stage getPopUpStage(TableView<Doctor> doctorTable) {

        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Add Doctor");
        popup.initStyle(StageStyle.UTILITY);

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);

        Label title = new Label("Add Doctor");
        title.setStyle(TextStyle.getTextStyle("#ffffff", "24px", "bold"));

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle(TextStyle.getTextStyle("#000000", "14px", "normal"));
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Doctor Name");
        nameField.setMinWidth(250);
        Label specializationLabel = new Label("Specialization:");
        specializationLabel.setStyle(TextStyle.getTextStyle("#000000", "14px", "normal"));
        TextField specializationField = new TextField();
        specializationField.setPromptText("Enter Doctor Specialization");
        specializationField.setMinWidth(250);

        layout.add(nameLabel, 0, 0);
        layout.add(nameField, 1, 0);
        layout.add(specializationLabel, 0, 1);
        layout.add(specializationField, 1, 1);

        Button addButton = CustomButton.newButton("Add Doctor", "file:src/assets/add.png");
        addButton.setOnAction(event -> {
            String name = nameField.getText().trim();
            String specialization = specializationField.getText().trim();
            if (!validateDoctorData(name, specialization)) {
                return;
            }
            Doctor doctor = new Doctor(UniqueIdGenerator.generate(), name, specialization);
            DoctorController.addDoctor(doctor);
            doctorTable.getItems().add(doctor);
            CustomAlert.alertBox("Success", "Doctor added successfully.", "file:src/assets/success.png",
                    Alert.AlertType.INFORMATION);
            popup.close();
        });
        layout.add(addButton, 1, 2);

        Scene scene = new Scene(layout, 450, 220);
        popup.setScene(scene);
        popup.showAndWait();
        return popup;
    }

    public static boolean validateDoctorData(String name, String specialization) {
        if (name.isEmpty() || specialization.isEmpty()) {
            CustomAlert.alertBox("Error", "Name and Specialization cannot be empty.", "file:src/assets/error.png",
                    Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }
}

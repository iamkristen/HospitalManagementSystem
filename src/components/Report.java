package components;

import CLI.PatientInterface;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import screens.ReportScreen;

public class Report {
    public static void getPopUpStage() {
        // Creating a new modal window to choose the patient
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Report Generator");

        // Creating dropdown menu to choose patient
        ComboBox<String> patientComboBox = new ComboBox<>();
        patientComboBox.setMinWidth(200);
        patientComboBox.setMinHeight(30);
        patientComboBox.setPromptText("Select Patient");
        patientComboBox.setItems(FXCollections.observableArrayList(PatientInterface.patientList.getAllPatientNames()));

        // Create button to generate report
        Button goButton = new Button("");
        Image image = new Image("file:src/assets/go.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(70);
        goButton.setGraphic(imageView);
        goButton.setMinWidth(120);
        goButton.setOnAction(event -> {
            String selectedPatient = patientComboBox.getValue();
            if (selectedPatient != null) {
                ReportScreen.generateReport(PatientInterface.patientList.getPatientByName(selectedPatient).getId());
                stage.close();
            }
        });

        // Arranging components in a VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(patientComboBox, goButton);

        // Setting scene
        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
        stage.showAndWait();
    }
}

package screens;

import CLI.AppointmentInterface;
import CLI.DiagnosisInterface;
import CLI.DoctorInterface;
import CLI.PatientInterface;
import CLI.TreatmentInterface;
import classes.Appointment;
import classes.Diagnosis;
import classes.Doctor;
import classes.Patient;
import classes.Treatment;
import components.CustomAlert;
import components.CustomButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Ansi;

public class ReportScreen {
        public static void generateReport(int patientId) {
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setMaximized(false);
                stage.setResizable(false);
                stage.getIcons().add(new javafx.scene.image.Image("file:src/assets/icon.png"));
                stage.setTitle("Medical Report");

                Image image = new Image("file:src/assets/bg.jpg");
                ImageView imageView = new ImageView(image);
                GaussianBlur blur = new GaussianBlur(12);
                imageView.setEffect(blur);
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);

                try {
                        Patient patient = PatientInterface.patientList.getPatient(patientId);
                        Appointment appointment = AppointmentInterface.appointmentList.getAppointment(patientId);
                        Doctor doctor = DoctorInterface.doctorList.getDoctor(appointment.getdoctorId());
                        Diagnosis diagnosis = DiagnosisInterface.diagnosisList.getDiagnosis(patientId);
                        Treatment treatment = TreatmentInterface.treatmentList.getTreatment(patientId);

                        Label headerLabel = new Label("Medical Report");
                        headerLabel.setStyle(
                                        "-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Algerian'; -fx-text-fill: #023047; -fx-underline: true;");

                        Label patientLabel = new Label("Patient: " + patient.getName());
                        patientLabel.setStyle(
                                        "-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Monotype Corsiva';");
                        Label appointmentLabel = new Label(
                                        "Appointment ID: " + appointment.getId() + ", Time: " + appointment.getTime());
                        appointmentLabel
                                        .setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Monotype Corsiva';");
                        Label doctorLabel = new Label(
                                        "Doctor: " + doctor.getname() + " (" + doctor.getspecialization() + ")");
                        doctorLabel.setStyle(
                                        "-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Monotype Corsiva';");
                        Label diagnosisLabel = new Label("Diagnosis: " + diagnosis.getDiagnosis());
                        diagnosisLabel.setStyle(
                                        "-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Monotype Corsiva';");
                        Label treatmentLabel = new Label("Treatment: " + treatment.getTreatment());
                        treatmentLabel.setStyle(
                                        "-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Monotype Corsiva';");

                        Button closeButton = CustomButton.newButton("Close", "file:src/assets/close.png");
                        closeButton.setOnAction(event -> stage.close());

                        VBox reportDetails = new VBox(10);
                        reportDetails.setAlignment(Pos.CENTER_LEFT);
                        reportDetails.setPadding(new Insets(20));
                        reportDetails.getChildren().addAll(headerLabel, patientLabel, appointmentLabel, doctorLabel,
                                        diagnosisLabel,
                                        treatmentLabel);

                        StackPane layout = new StackPane();
                        layout.setPadding(new Insets(20));
                        layout.getChildren().add(0, imageView);

                        Image modelImage = new Image("file:src/assets/model.png");
                        ImageView modelImageView = new ImageView(modelImage);
                        modelImageView.setFitHeight(300);
                        modelImageView.setFitWidth(220);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setCenter(reportDetails);
                        borderPane.setBottom(closeButton);
                        borderPane.setRight(modelImageView);
                        borderPane.setPadding(new Insets(20));
                        BorderPane.setAlignment(closeButton, Pos.CENTER);

                        layout.getChildren().add(1, borderPane);

                        layout.setBackground(background);

                        Scene scene = new Scene(layout, 700, 450);
                        stage.setScene(scene);
                        stage.showAndWait();
                } catch (Exception e) {
                        CustomAlert.alertBox("Error", Ansi.remove(e.getMessage()), "file:src/assets/error.png",
                                        Alert.AlertType.ERROR);
                }
        }
}

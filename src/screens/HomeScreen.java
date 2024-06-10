package screens;

import components.Report;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.effect.GaussianBlur;
import javafx.stage.Stage;
import utils.AppColors;
import utils.ResponsiveScreen;

public class HomeScreen {

    public static Scene getScene(Stage primaryStage) {
        return homeScene(primaryStage);
    }

    private static Scene homeScene(Stage primaryStage) {
        StackPane layout = new StackPane();
        Image image = new Image("file:src/assets/background.jpg");
        ImageView imageView = new ImageView(image);
        GaussianBlur blur = new GaussianBlur(10);
        imageView.setEffect(blur);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        layout.getChildren().add(0, imageView);
        layout.setBackground(background);

        Label title = new Label("Welcome to Hospital Management System");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: " + AppColors.primaryColor + ";");
        layout.getChildren().add(title);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20, 12, 20, 12));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(30);
        layout.getChildren().add(grid);

        Button doc_button = new Button("Doctor");
        doc_button.setMinWidth(150);
        Image doc_image = new Image("file:src/assets/doctor.png");
        ImageView doc_imageview = new ImageView(doc_image);
        doc_imageview.setFitHeight(50);
        doc_imageview.setFitWidth(50);
        doc_button.setGraphic(doc_imageview);
        doc_button.setOnAction(event -> {
            primaryStage.setScene(DoctorScreen.getScene(primaryStage));
        });
        grid.add(doc_button, 0, 0);

        Button patient_button = new Button("Patient");
        patient_button.setMinWidth(150);
        Image patient_image = new Image("file:src/assets/patient.png");
        ImageView patient_imageview = new ImageView(patient_image);
        patient_imageview.setFitHeight(50);
        patient_imageview.setFitWidth(50);
        patient_button.setGraphic(patient_imageview);
        patient_button.setOnAction(e -> {
            primaryStage.setScene(PatientScreen.getScene(primaryStage));
        });
        grid.add(patient_button, 1, 0);

        Button appnt_btn = new Button("Appointment");
        appnt_btn.setMinWidth(150);
        Image appnt_image = new Image("file:src/assets/appointment.png");
        ImageView appnt_imageview = new ImageView(appnt_image);
        appnt_imageview.setFitHeight(50);
        appnt_imageview.setFitWidth(50);
        appnt_btn.setGraphic(appnt_imageview);
        appnt_btn.setOnAction(e -> {
            primaryStage.setScene(AppointmentScreen.getScene(primaryStage)); // Assuming AppointmentScreen class exists
        });
        grid.add(appnt_btn, 2, 0);

        Button diagnosis_btn = new Button("Diagnosis");
        diagnosis_btn.setMinWidth(150);
        Image diagnosis_image = new Image("file:src/assets/diagnosis.png");
        ImageView diagnosis_imageview = new ImageView(diagnosis_image);
        diagnosis_imageview.setFitHeight(50);
        diagnosis_imageview.setFitWidth(50);
        diagnosis_btn.setGraphic(diagnosis_imageview);
        diagnosis_btn.setOnAction(e -> {
            primaryStage.setScene(DiagnosisScreen.getScene(primaryStage)); // Assuming DiagnosisScreen class exists
        });
        grid.add(diagnosis_btn, 0, 1);

        Button treatment_btn = new Button("Treatment");
        treatment_btn.setMinWidth(150);
        Image treatment_image = new Image("file:src/assets/treatment.png");
        ImageView treatment_imageview = new ImageView(treatment_image);
        treatment_imageview.setFitHeight(50);
        treatment_imageview.setFitWidth(50);
        treatment_btn.setGraphic(treatment_imageview);
        treatment_btn.setOnAction(e -> {
            primaryStage.setScene(TreatmentScreen.getScene(primaryStage)); // Assuming TreatmentScreen class exists
        });
        grid.add(treatment_btn, 1, 1);

        Button reportButton = new Button("Report");
        reportButton.setMinWidth(150);
        Image reportImage = new Image("file:src/assets/report.png");
        ImageView reportImageView = new ImageView(reportImage);
        reportImageView.setFitHeight(50);
        reportImageView.setFitWidth(50);
        reportButton.setGraphic(reportImageView);
        reportButton.setOnAction(e -> {
            Report.getPopUpStage();
        });
        grid.add(reportButton, 2, 1);

        return new Scene(layout, ResponsiveScreen.window_width, ResponsiveScreen.window_height, Color.TRANSPARENT);
    }
}

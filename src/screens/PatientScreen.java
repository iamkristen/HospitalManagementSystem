package screens;

import CLI.PatientInterface;
import classes.Patient;
import components.AddPatient;
import components.CustomAlert;
import components.CustomButton;
import controller.PatientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.AppColors;
import utils.ResponsiveScreen;
import utils.TextStyle;

public class PatientScreen {

    public static Scene getScene(Stage primaryStage) {

        // Creating a Horizontal Box layout for the navbar
        BorderPane navbar = new BorderPane();
        navbar.setMinHeight(30);
        navbar.setMaxHeight(50);
        navbar.setStyle("-fx-background-color: " + AppColors.primaryColor + ";");

        // Creating a button to go back to the home screen and adding it to the navbar
        Button backButton = CustomButton.backButton(primaryStage, HomeScreen.getScene(primaryStage));
        backButton.setOnAction(event -> primaryStage.setScene(HomeScreen.getScene(primaryStage)));

        // Creating a title label and adding it to the navbar
        Label title = new Label("Patient Screen");
        title.setStyle(TextStyle.getTextStyle("#ffffff", "24px", "bold"));

        // Setting the alignment of the navbar elements
        navbar.setLeft(backButton);
        navbar.setCenter(title);

        // Creating a Vertical Box layout
        VBox layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        // Creating a Button to add Patient
        Button addPatientButton = new Button("Add Patient");
        addPatientButton.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        Image image = new Image("file:src/assets/add.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        addPatientButton.setGraphic(imageView);

        // Creating a Vertical Box layout for the content
        VBox contentBox = new VBox();
        contentBox.setPadding(new Insets(12, 12, 12, 12));
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setSpacing(20);
        contentBox.getChildren().add(addPatientButton);

        // Table View for Patient List
        TableView<Patient> patientTable = new TableView<>();

        TableColumn<Patient, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Patient, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Patient, String> contactNumberColumn = new TableColumn<>("Contact Number");

        idColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(200);
        contactNumberColumn.setPrefWidth(200);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // Setting the alignment of the table columns
        idColumn.setStyle("-fx-alignment: CENTER;");
        nameColumn.setStyle("-fx-alignment: CENTER;");
        contactNumberColumn.setStyle("-fx-alignment: CENTER;");

        // Setting CSS style for the TableView
        patientTable.setStyle("-fx-font-size: 16px;");

        // Setting CSS style for the table cells
        patientTable.setRowFactory(row -> {
            TableRow<Patient> tableRow = new TableRow<>();
            tableRow.setStyle("-fx-font-size: 14px;"); // Adjust font size as needed
            return tableRow;
        });

        // Action of Add Patient Button
        addPatientButton.setOnAction(event -> AddPatient.getPopUpStage(patientTable));

        // Created a button to delete Patient
        Button deleteButton = CustomButton.newButton("Delete", "file:src/assets/delete.png");
        deleteButton.setOnAction(event -> {
            boolean confirm = CustomAlert.confirmBox("Delete", "Are you sure you want to delete this patient?");
            if (confirm) {
                Patient patient = patientTable.getSelectionModel().getSelectedItem();
                if (patient != null) {
                    patientTable.getItems().remove(patient);
                    PatientInterface.patientList.deletePatient(patient.getId()); // Ensure this method matches your
                                                                                 // actual method
                    CustomAlert.alertBox("Delete", "Patient Deleted Successfully!", "file:src/assets/delete.png",
                            Alert.AlertType.INFORMATION);
                }
            }
        });

        // Created a button to save Patient
        Button saveButton = CustomButton.newButton("Save", "file:src/assets/save.png");
        saveButton.setOnAction(event -> {
            PatientInterface.saveData();
            CustomAlert.alertBox("Save", "Data Saved Successfully!", "file:src/assets/success.png",
                    Alert.AlertType.INFORMATION);
        });

        patientTable.getColumns().addAll(idColumn, nameColumn, contactNumberColumn);
        ObservableList<Patient> data = FXCollections.observableArrayList(PatientController.getPatientList());
        patientTable.setItems(data);
        contentBox.getChildren().addAll(patientTable, saveButton, deleteButton);

        // Creating a Horizontal Box layout for the footer
        HBox footer = new HBox();
        footer.setPadding(new Insets(12, 12, 25, 12));
        footer.setAlignment(Pos.CENTER);
        footer.setSpacing(50);
        footer.getChildren().addAll(saveButton, deleteButton);

        // Adding the navbar and content to the main layout
        layout.getChildren().addAll(navbar, contentBox, footer);

        return new Scene(layout, ResponsiveScreen.window_width, ResponsiveScreen.window_height);
    }
}

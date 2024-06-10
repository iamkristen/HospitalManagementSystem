package screens;

import CLI.AppointmentInterface;
import classes.Appointment;
import components.AddAppointment;
import components.CustomAlert;
import components.CustomButton;
import controller.AppointmentController;
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

public class AppointmentScreen {

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
        Label title = new Label("Appointment Screen");
        title.setStyle(TextStyle.getTextStyle("#ffffff", "24px", "bold"));

        // Setting the alignment of the navbar elements
        navbar.setLeft(backButton);
        navbar.setCenter(title);

        // Creating a Vertical Box layout
        VBox layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        // Creating a Button to add Appointment
        Button addAppointmentButton = new Button("Add Appointment");
        addAppointmentButton.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        Image image = new Image("file:src/assets/add.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        addAppointmentButton.setGraphic(imageView);

        // Creating a Vertical Box layout for the content
        VBox contentBox = new VBox();
        contentBox.setPadding(new Insets(12, 12, 12, 12));
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setSpacing(20);
        contentBox.getChildren().add(addAppointmentButton);

        // Table View for Appointment List
        TableView<Appointment> appointmentTable = new TableView<>();

        TableColumn<Appointment, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Appointment, String> timeColumn = new TableColumn<>("Time Slot");
        TableColumn<Appointment, String> doctorColumn = new TableColumn<>("Doctor Name");
        TableColumn<Appointment, String> patientColumn = new TableColumn<>("Patient Name");

        idColumn.setPrefWidth(100);
        timeColumn.setPrefWidth(200);
        doctorColumn.setPrefWidth(200);
        patientColumn.setPrefWidth(200);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        patientColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));

        // Setting the alignment of the table columns
        idColumn.setStyle("-fx-alignment: CENTER;");
        timeColumn.setStyle("-fx-alignment: CENTER;");
        doctorColumn.setStyle("-fx-alignment: CENTER;");
        patientColumn.setStyle("-fx-alignment: CENTER;");

        // Setting CSS style for the TableView
        appointmentTable.setStyle("-fx-font-size: 16px;");

        // Setting CSS style for the table cells
        appointmentTable.setRowFactory(row -> {
            TableRow<Appointment> tableRow = new TableRow<>();
            tableRow.setStyle("-fx-font-size: 14px;"); // Adjust font size as needed
            return tableRow;
        });

        // Action of Add Appointment Button
        addAppointmentButton.setOnAction(event -> AddAppointment.getPopUpStage(appointmentTable));

        // Created a button to delete Appointment
        Button deleteButton = CustomButton.newButton("Delete", "file:src/assets/delete.png");
        deleteButton.setOnAction(event -> {
            boolean confirm = CustomAlert.confirmBox("Delete", "Are you sure you want to delete this appointment?");
            if (confirm) {
                Appointment appointment = appointmentTable.getSelectionModel().getSelectedItem();
                if (appointment != null) {
                    appointmentTable.getItems().remove(appointment);
                    AppointmentInterface.appointmentList.deleteAppointment(appointment.getId());
                    CustomAlert.alertBox("Delete", "Appointment Deleted Successfully!",
                            "file:src/assets/delete.png",
                            Alert.AlertType.INFORMATION);
                }
            }
        });

        // Created a button to save Appointment
        Button saveButton = CustomButton.newButton("Save", "file:src/assets/save.png");
        saveButton.setOnAction(event -> {
            AppointmentInterface.saveData();
            CustomAlert.alertBox("Save", "Data Saved Successfully!", "file:src/assets/success.png",
                    Alert.AlertType.INFORMATION);
        });

        appointmentTable.getColumns().addAll(idColumn, timeColumn, doctorColumn, patientColumn);
        ObservableList<Appointment> data = FXCollections
                .observableArrayList(AppointmentController.getAppointmentList());
        appointmentTable.setItems(data);
        contentBox.getChildren().addAll(appointmentTable, saveButton, deleteButton);

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

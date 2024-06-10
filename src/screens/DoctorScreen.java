package screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableRow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.AppColors;
import utils.ResponsiveScreen;
import utils.TextStyle;
import CLI.DoctorInterface;
import classes.Doctor;
import components.AddDoctor;
import components.CustomAlert;
import components.CustomButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;

public class DoctorScreen {
    public static Scene getScene(Stage primaryStage) {
        return doctorScene(primaryStage);
    }

    public static Scene doctorScene(Stage primaryStage) {

        BorderPane navbar = new BorderPane();
        navbar.setMinHeight(30);
        navbar.setMaxHeight(50);
        navbar.setStyle("-fx-background-color: " + AppColors.primaryColor + ";");

        Button backButton = CustomButton.backButton(primaryStage, HomeScreen.getScene(primaryStage));
        backButton.setOnAction(event -> {
            primaryStage.setScene(HomeScreen.getScene(primaryStage));
        });

        Label title = new Label("Doctor Screen");
        title.setStyle(TextStyle.getTextStyle("#ffffff", "24px", "bold"));

        navbar.setLeft(backButton);
        navbar.setCenter(title);

        VBox layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        Button addDoctorButton = new Button("Add Doctor");
        addDoctorButton.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        Image image = new Image("file:src/assets/add.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        addDoctorButton.setGraphic(imageView);

        VBox contentBox = new VBox();
        contentBox.setPadding(new Insets(12, 12, 12, 12));
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setSpacing(20);
        contentBox.getChildren().add(addDoctorButton);

        TableView<Doctor> doctorTable = new TableView<>();

        TableColumn<Doctor, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Doctor, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Doctor, String> specialityColumn = new TableColumn<>("Speciality");

        idColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(200);
        specialityColumn.setPrefWidth(200);

        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getid()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getname()));
        specialityColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getspecialization()));

        idColumn.setStyle("-fx-alignment: CENTER;");
        nameColumn.setStyle("-fx-alignment: CENTER;");
        specialityColumn.setStyle("-fx-alignment: CENTER;");

        doctorTable.setStyle("-fx-font-size: 16px;");

        doctorTable.setRowFactory(row -> {
            TableRow<Doctor> tableRow = new TableRow<>();
            tableRow.setStyle("-fx-font-size: 14px;");
            return tableRow;
        });

        addDoctorButton.setOnAction(event -> {
            AddDoctor.getPopUpStage(doctorTable);
        });

        Button deleteButton = CustomButton.newButton("Delete", "file:src/assets/delete.png");
        deleteButton.setOnAction(event -> {
            boolean confirm = CustomAlert.confirmBox("Delete", "Are you sure you want to delete this doctor?");
            if (confirm) {
                Doctor doctor = doctorTable.getSelectionModel().getSelectedItem();
                if (doctor != null) {
                    doctorTable.getItems().remove(doctor);
                    DoctorInterface.doctorList.deleteDoctor(doctor.getid());
                    CustomAlert.alertBox("Delete", "Doctor Deleted Successfully!", "file:src/assets/delete.png",
                            AlertType.INFORMATION);
                }
            }
        });

        Button saveButton = CustomButton.newButton("Save", "file:src/assets/save.png");
        saveButton.setOnAction(event -> {
            DoctorInterface.saveData();
            CustomAlert.alertBox("Save", "Data Saved Successfully!", "file:src/assets/success.png",
                    AlertType.INFORMATION);
        });

        doctorTable.getColumns().addAll(idColumn, nameColumn, specialityColumn);

        // Populate the data ObservableList with actual data
        ObservableList<Doctor> data = FXCollections.observableArrayList(DoctorInterface.doctorList.getDoctorList());
        doctorTable.setItems(data);

        contentBox.getChildren().addAll(doctorTable, saveButton, deleteButton);

        HBox footer = new HBox();
        footer.setPadding(new Insets(12, 12, 25, 12));
        footer.setAlignment(Pos.CENTER);
        footer.setSpacing(50);
        footer.getChildren().addAll(saveButton, deleteButton);

        layout.getChildren().addAll(navbar, contentBox, footer);

        return new Scene(layout, ResponsiveScreen.window_width, ResponsiveScreen.window_height);
    }
}

package screens;

import CLI.DiagnosisInterface;
import classes.Diagnosis;
import components.AddDiagnosis;
import components.CustomAlert;
import components.CustomButton;
import controller.DiagnosisController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.AppColors;
import utils.ResponsiveScreen;
import utils.TextStyle;

public class DiagnosisScreen {

    public static Scene getScene(Stage primaryStage) {

        // Creating a Horizontal Box layout for the navbar
        BorderPane navbar = new BorderPane();
        navbar.setMinHeight(30);
        navbar.setMaxHeight(50);
        navbar.setStyle("-fx-background-color: " + AppColors.primaryColor + ";");

        // Creating a button to go back to the home screen and adding it to the navbar
        Button backButton = CustomButton.backButton(primaryStage, HomeScreen.getScene(primaryStage));
        backButton.setOnAction(event -> {
            primaryStage.setScene(HomeScreen.getScene(primaryStage));
        });

        // Creating a title label and adding it to the navbar
        Label title = new Label("Diagnosis Screen");
        title.setStyle(TextStyle.getTextStyle("#ffffff", "24px", "bold"));

        // Setting the alignment of the navbar elements
        navbar.setLeft(backButton);
        navbar.setCenter(title);

        // Creating a Vertical Box layout
        VBox layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        // Creating a Button to add Diagnosis
        Button addDiagnosisButton = new Button("Add Diagnosis");
        addDiagnosisButton.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        Image image = new Image("file:src/assets/add.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        addDiagnosisButton.setGraphic(imageView);

        // Creating a Vertical Box layout for the content
        VBox contentBox = new VBox();
        contentBox.setPadding(new Insets(12, 12, 12, 12));
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setSpacing(20);
        contentBox.getChildren().add(addDiagnosisButton);

        // Table View for Diagnosis List
        TableView<Diagnosis> diagnosisTable = new TableView<>();

        TableColumn<Diagnosis, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Diagnosis, String> nameColumn = new TableColumn<>("Patient Name");
        TableColumn<Diagnosis, String> diagnosisColumn = new TableColumn<>("Diagnosis detail");

        idColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(200);
        diagnosisColumn.setPrefWidth(200);

        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPatientName()));
        diagnosisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnosis()));

        // Setting the alignment of the table columns
        idColumn.setStyle("-fx-alignment: CENTER;");
        nameColumn.setStyle("-fx-alignment: CENTER;");
        diagnosisColumn.setStyle("-fx-alignment: CENTER;");

        // Setting CSS style for the TableView
        diagnosisTable.setStyle("-fx-font-size: 16px;");

        // Setting CSS style for the table cells
        diagnosisTable.setRowFactory(row -> {
            TableRow<Diagnosis> tableRow = new TableRow<>();
            tableRow.setStyle("-fx-font-size: 14px;"); // Adjust font size as needed
            return tableRow;
        });

        // Action of Add Diagnosis Button
        addDiagnosisButton.setOnAction(event -> {
            AddDiagnosis.getPopUpStage(diagnosisTable);
        });

        // Created a button to delete Diagnosis
        Button deleteButton = CustomButton.newButton("Delete", "file:src/assets/delete.png");
        deleteButton.setOnAction(event -> {
            Boolean confirm = CustomAlert.confirmBox("Delete", "Are you sure you want to delete this Diagnosis?");
            if (confirm) {
                Diagnosis diagnosisRow = diagnosisTable.getSelectionModel().getSelectedItem();
                if (diagnosisRow != null) {
                    diagnosisTable.getItems().remove(diagnosisRow);
                    DiagnosisInterface.diagnosisList.deleteDiagnosis(diagnosisRow.getId());
                    CustomAlert.alertBox("Delete", "Diagnosis Deleted Successfully!",
                            "file:src/assets/delete.png",
                            Alert.AlertType.INFORMATION);
                }
            }
        });

        // Created a button to save Diagnosis
        Button saveButton = CustomButton.newButton("Save", "file:src/assets/save.png");
        saveButton.setOnAction(event -> {
            DiagnosisInterface.saveData();
            CustomAlert.alertBox("Save", "Data Saved Successfully!", "file:src/assets/success.png",
                    Alert.AlertType.INFORMATION);
        });

        diagnosisTable.getColumns().addAll(idColumn, nameColumn, diagnosisColumn);
        ObservableList<Diagnosis> data = FXCollections.observableArrayList(DiagnosisController.getAllDiagnosis());
        diagnosisTable.setItems(data);
        contentBox.getChildren().addAll(diagnosisTable, saveButton, deleteButton);

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

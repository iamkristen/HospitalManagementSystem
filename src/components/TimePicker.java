package components;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TimePicker {
    private static String[] hours = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
    private static String[] minutes = { "00", "15", "30", "45" };

    public static HBox getTimePicker() {
        return getTimePicker("12", "00", "AM", "-fx-font-size: 14px;");
    }

    public static HBox getTimePicker(String initialHour, String initialMinute, String initialAmPm, String style) {
        ComboBox<String> hourComboBox = new ComboBox<>(FXCollections.observableArrayList(hours));
        ComboBox<String> minuteComboBox = new ComboBox<>(FXCollections.observableArrayList(minutes));
        ComboBox<String> amPmComboBox = new ComboBox<>(FXCollections.observableArrayList("AM", "PM"));

        // Set initial values
        hourComboBox.setValue(initialHour);
        minuteComboBox.setValue(initialMinute);
        amPmComboBox.setValue(initialAmPm);

        // Set styles
        hourComboBox.setStyle(style);
        minuteComboBox.setStyle(style);
        amPmComboBox.setStyle(style);

        // Create the layout
        HBox timePickerLayout = new HBox();
        timePickerLayout.getChildren().addAll(hourComboBox, new Label(":"), minuteComboBox, amPmComboBox);
        timePickerLayout.setAlignment(Pos.CENTER_LEFT);
        timePickerLayout.setSpacing(5);
        timePickerLayout.setPadding(new Insets(5));

        return timePickerLayout;
    }

    public static String getTimeFromPicker(HBox timePicker) {
        ComboBox<String> hourComboBox = (ComboBox<String>) timePicker.getChildren().get(0);
        ComboBox<String> minuteComboBox = (ComboBox<String>) timePicker.getChildren().get(2);
        ComboBox<String> amPmComboBox = (ComboBox<String>) timePicker.getChildren().get(3);
        return hourComboBox.getValue() + ":" + minuteComboBox.getValue() + " " +
                amPmComboBox.getValue();
    }
}

package utils;

public class ButtonStyle {
    // This method returns the default button style
    public static String getButtonStyle() {
        return getButtonStyle("#ffffff", "#023047", "2px", "#023047", "bold", "8px 16px");
    }

    // This is the overridden method to accept parameters and return the button
    // style
    // for the app according to the parameters
    public static String getButtonStyle(String color, String borderColor, String borderWidth, String textColor,
            String fontWeight, String padding) {
        return "-fx-background-color: " + color + "; " +
                "-fx-border-color: " + borderColor + "; " +
                "-fx-border-width: " + borderWidth + "; " +
                "-fx-text-fill: " + textColor + "; " +
                "-fx-font-weight: " + fontWeight + "; " +
                "-fx-padding: " + padding + ";";
    }

}

package utils;

public class TextStyle {
    private static String primaryColor = "#000000"; // Default primary color

    // This method returns the text style for the app as default
    public static String getTextStyle() {
        return getTextStyle(primaryColor, "24px", "bold");
    }

    // This is an overridden method to accept parameters and returns the text style
    // for the app according to the parameters
    public static String getTextStyle(String color, String size, String weight) {
        return "-fx-font-size: " + size + "; -fx-font-weight: " + weight + "; -fx-font-family: 'Arial'; -fx-text-fill: "
                + color + ";";
    }
}

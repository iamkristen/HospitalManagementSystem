package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ansi {
    public static String remove(String str) {
        String regex = "\u001B\\[[;\\d]*m";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        // Replace ANSI escape codes with an empty string
        String filteredText = matcher.replaceAll("");

        return filteredText;
    }
}

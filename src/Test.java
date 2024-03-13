public class Test {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        // Example usage
        System.out.println(RED + "This text is red." + RESET);
        System.out.println(GREEN + "This text is green." + RESET);
        System.out.println(YELLOW + "This text is yellow." + RESET);
        System.out.println(BLUE + "This text is blue." + RESET);
        System.out.println(PURPLE + "This text is purple." + RESET);
        System.out.println(CYAN + "This text is cyan." + RESET);
        System.out.println(WHITE + "This text is white." + RESET);
    }
}

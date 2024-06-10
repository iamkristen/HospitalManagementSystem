package helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EasyScanner {
    static Scanner sc = new Scanner(System.in);

    public static int nextInt() {
        int i;
        try {
            i = sc.nextInt();
            return i;
        } catch (InputMismatchException e) {
            System.out.println("Enter Integer value !");
            sc.next();
            i = nextInt();
            return i;
        }

    }

    public static double nextDouble() {
        double d;
        try {
            d = sc.nextDouble();
            return d;
        } catch (InputMismatchException e) {
            System.out.println("Enter Double value !");
            sc.next();
            d = nextDouble();
            return d;
        }
    }

    public static String nextString() {
        String s;
        try {
            s = sc.nextLine();
            return s;
        } catch (InputMismatchException e) {
            System.out.println("Enter String value !");
            sc.next();
            s = nextString();
            return s;
        }

    }

    public static char nextChar() {
        char c;
        try {
            c = sc.next().charAt(0);
            return c;
        } catch (InputMismatchException e) {
            System.out.println("Enter only Character !");
            sc.next();
            c = nextChar();
            return c;
        }

    }

}

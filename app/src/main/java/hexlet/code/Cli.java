package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private static String username;

    private Cli() {
    }

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        username = name;

        System.out.println("Hello, " + name + "!");
    }

    public static String getUsername() {
        return username;
    }

}

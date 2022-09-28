package hexlet.code;

import hexlet.code.games.EvenGame;

import java.nio.charset.Charset;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        showStartMenu();
        startNumberGame(getNumberGame());
    }

    private static void showStartMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
    }

    private static int getNumberGame() {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice: ");
        try {
            number = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Incorrect value, try again");
        }
        System.out.print("\n");
        return number;
    }

    private static void startNumberGame(int number) {
        switch (number) {
            case 0:
                break;
            case 1:
                Cli.greeting();
                break;
            case 2:
                Cli.greeting();
                EvenGame.start();
                break;
        }
    }

}

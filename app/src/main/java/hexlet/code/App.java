package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.GameMenu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public final class App {

    public static void main(String[] args) {
        showStartMenu();
        int menuItem = getMenuItem();
        if (menuItem == 0) {
            return;
        } else if (menuItem == 1) {
            Cli.greeting();
        } else {
            Optional<Game> result = GameMenu.getGameByNumber(menuItem);
            if (result.isPresent()) {
                Engine engine = new Engine(result.get());
                engine.start();
            }
        }
    }

    private static void showStartMenu() {
        System.out.println("Please enter the game number and press Enter.");
        Arrays.stream(GameMenu.values())
                .sorted(Comparator.comparingInt(GameMenu::getMenuItem))
                .forEach(gameMenu -> System.out.println(gameMenu.getMenuItemDescription()));
    }

    private static int getMenuItem() {
        int menuItem = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice: ");
        try {
            menuItem = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Incorrect value, try again");
        }
        System.out.print("\n");
        return menuItem;
    }
}

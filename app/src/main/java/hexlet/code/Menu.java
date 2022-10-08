package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Game;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public final class Menu {

    public static void show() {

        System.out.println("Please enter the game number and press Enter.");
        Arrays.stream(MenuItem.values()).forEach(item -> System.out.println(item.description));

        System.out.print("Your choice: ");
        int menuItem = selectMenuItem();
        System.out.print("\n");

        if (menuItem == 0) {
            System.exit(0);
        } else if (menuItem == 1) {
            Cli.greeting();
        } else {
            Optional<Supplier<Game>> result = MenuItem.getGame(menuItem);
            if (result.isPresent()) {
                Engine.start(result.get().get());
            }
        }
    }

    private static int selectMenuItem() {
        Scanner sc = new Scanner(System.in);
        int menuItem;
        try {
            menuItem = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Incorrect value, try again");
        }
        if (Arrays.stream(MenuItem.values()).noneMatch(mi -> mi.item == menuItem)) {
            throw new UnsupportedOperationException(menuItem + " is an unsupported menu number");
        }
        return menuItem;
    }

    private enum MenuItem {
        GREET(1, "1 - Greet", Optional.empty()),
        EVEN(2, "2 - Even", Optional.of(Even::new)),
        CALC(3, "3 - Calc", Optional.of(Calc::new)),
        GCD(4, "4 - GCD", Optional.of(GCD::new)),
        PROGRESSION(5, "5 - Progression", Optional.of(Progression::new)),
        PRIME(6, "6 - Prime", Optional.of(Prime::new)),
        EXIT(0, "0 - Exit", Optional.empty());

        private final int item;
        private final String description;
        private final Optional<Supplier<Game>> game;

        MenuItem(int menuItem, String menuDescription, Optional<Supplier<Game>> menuGame) {
            this.item = menuItem;
            this.description = menuDescription;
            this.game = menuGame;
        }

        public static Optional<Supplier<Game>> getGame(int menuItem) {

            Optional<MenuItem> result = Arrays.stream(MenuItem.values())
                    .filter(mi -> mi.item == menuItem)
                    .findFirst();

            if (result.isEmpty()) {
                return Optional.empty();
            }

            return result.get().game;
        }
    }
}

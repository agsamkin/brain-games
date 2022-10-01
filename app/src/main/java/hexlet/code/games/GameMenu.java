package hexlet.code.games;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public enum GameMenu {
    GREET(1, "1 - Greet", Optional.empty()),
    EVEN(2, "2 - Even", Optional.of(EvenGame::new)),
    CALC(3, "3 - Calc", Optional.of(CalcGame::new)),
    GCD(4, "4 - GCD", Optional.of(GCDGame::new)),
    PROGRESSION(5, "5 - Progression", Optional.of(ProgressionGame::new)),
    PRIME(6, "6 - Prime", Optional.of(PrimeGame::new)),
    EXIT(0, "0 - Exit", Optional.empty());

    private final int menuItem;
    private final String menuItemDescription;
    private final Optional<Supplier<Game>> game;

    GameMenu(int menuItem, String menuItemDescription, Optional<Supplier<Game>> game) {
        this.menuItem = menuItem;
        this.menuItemDescription = menuItemDescription;
        this.game = game;
    }

    public int getMenuItem() {
        return menuItem;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public Optional<Game> getGame() {
        if (game.isPresent()) {
            Supplier<Game> result = game.get();
            return Optional.of(result.get());
        } else {
            return Optional.empty();
        }
    }

    public static Optional<Game> getGameByNumber(int menuItem) {
        Optional<GameMenu> result = findGameMenuByItem(menuItem);
        if (result.isPresent()) {
            GameMenu gameMenu = result.get();
            return gameMenu.getGame();
        } else {
            return Optional.empty();
        }
    }

    private static Optional<GameMenu> findGameMenuByItem(int menuItem) {
        return Arrays.stream(GameMenu.values())
                .filter(gameMenu -> gameMenu.getMenuItem() == menuItem)
                .findFirst();
    }
}

package hexlet.code;

import hexlet.code.games.Game;

public class Engine {

    private final Game game;

    public Engine(Game game) {
        this.game = game;
    }

    public void start() {

        Cli.greeting();

        game.hello();

        int countOfCorrectAnswers = 0;
        while (countOfCorrectAnswers < 3) {
            if (game.play()) {
                countOfCorrectAnswers++;
            } else {
                System.out.println("Let's try again, " + Cli.getUsername() + "!");
                break;
            }
        }

        if (countOfCorrectAnswers == 3) {
            System.out.println("Congratulations, " + Cli.getUsername() + "!");
        }
    }

}

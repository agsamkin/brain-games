package hexlet.code;

import hexlet.code.games.Game;

public final class Engine {
    private final Game game;
    private final int numberOfCorrectAnswersToWin = 3;

    public Engine(Game game) {
        this.game = game;
    }

    public void start() {
        Cli.greeting();

        game.hello();

        int countOfCorrectAnswers = 0;
        while (countOfCorrectAnswers < numberOfCorrectAnswersToWin) {
            if (game.play()) {
                countOfCorrectAnswers++;
            } else {
                System.out.println("Let's try again, " + Cli.getUsername() + "!");
                break;
            }
        }

        if (countOfCorrectAnswers == numberOfCorrectAnswersToWin) {
            System.out.println("Congratulations, " + Cli.getUsername() + "!");
        }
    }
}

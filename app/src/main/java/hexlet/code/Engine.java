package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;

public final class Engine {

    private static final int CORRECT_ANSWERS_TO_WIN = 3;

    public static void start(Game game) {

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        System.out.println("Hello, " + username + "!");
        System.out.println(game.getRules());

        int correctAnswers = 0;
        while (correctAnswers < CORRECT_ANSWERS_TO_WIN) {

            Task task = game.getTask();

            System.out.println("Question: " + task.question());
            System.out.print("Your answer: ");
            String userAnswer = sc.next();

            if (userAnswer.equals(task.correctAnswer())) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                String msg = "'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + task.correctAnswer() + "'.";
                System.out.println(msg);
                System.out.println("Let's try again, " + username + "!");
                return;
            }

        }

        System.out.println("Congratulations, " + username + "!");
    }

}

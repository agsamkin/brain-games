package hexlet.code.games;

import java.util.Random;

public final class PrimeGame implements Game {
    private final int maxNumber = 100;

    private int firstPrimeNumber = 2;
    private int secondPrimeNumber = 3;

    @Override
    public void hello() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    public boolean play() {
        Random random = new Random();
        int number = random.nextInt(maxNumber);
        String correctAnswer = isPrime(number) ? "yes" : "no";

        System.out.println("Question: " + number);

        return checkResult(correctAnswer);
    }

    private boolean isPrime(int number) {
        if (number < firstPrimeNumber) {
            return false;
        } else if (number <= secondPrimeNumber) {
            return true;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

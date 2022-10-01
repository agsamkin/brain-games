package hexlet.code.games;

import java.util.Random;

public final class PrimeGame implements Game {
    private final int maxNumber = 100;

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
        if (number < PrimeNumber.FIRST.primeNumber) {
            return false;
        } else if (number <= PrimeNumber.SECOND.primeNumber) {
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

    private enum PrimeNumber {
        FIRST(2),
        SECOND(3);

        private final int primeNumber;

        PrimeNumber(int newPrimeNumber) {
            this.primeNumber = newPrimeNumber;
        }
    }

}

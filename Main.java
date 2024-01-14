import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange, maxRange, score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            System.out.print("Enter the minimum range: ");
            minRange = scanner.nextInt();

            System.out.print("Enter the maximum range: ");
            maxRange = scanner.nextInt();

            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess!");

            while (attempts < 10) { // Fixed number of attempts (10)
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Game Over! Your final score is: " + score);
        if (score > 0) {
            System.out.println("Congratulations! You won " + score + " game(s)!");
        } else {
            System.out.println("Better luck next time! You didn't win any games.");
        }

        scanner.close();
    }
}

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame();
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    public static void playGame() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;

        int guess = 0;
        int attempts = 0;
        int highScore = Integer.MAX_VALUE; // Initialize high score to a large value
        int hints = 3; // Initial number of hints

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Guess a Number from 1 to 10");
       // System.out.println("Secret number: " + numberToGuess);

        do {
            System.out.print("Enter a number: ");
            guess = keyboard.nextInt();
            attempts++;

            if (guess > numberToGuess)
                System.out.println("Too high");
            else if (guess < numberToGuess)
                System.out.println("Too low");

            if (attempts > 1 && attempts < highScore) {
                System.out.println("New high score!");
                highScore = attempts;
            }

            if (guess != numberToGuess && hints > 0) { // Only ask for hint if guess is wrong
                System.out.print("Use a hint? (yes/no): ");
                String hintInput = keyboard.next();
                if (hintInput.equalsIgnoreCase("yes")) {
                    hints--;
                    System.out.println("Hint: The secret number is " + (numberToGuess % 2 == 0 ? "even" : "odd"));
                    highScore++; // Decrease high score for using a hint
                }
            }

        } while (guess != numberToGuess);

        System.out.println("Congratulations, you guessed correctly!");
        System.out.println("Number of attempts: " + attempts);
        System.out.println("Your high score: " + (highScore == Integer.MAX_VALUE ? "N/A" : highScore));
        System.out.println("Hints remaining: " + hints);
    }
}

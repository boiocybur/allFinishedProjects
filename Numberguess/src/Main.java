import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int lengthToCalculate = random.nextInt(10) + 1;

        int guess = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Velkommen til Gæt et tal fra 1 til 10");
        System.out.println("Secret number (not): " + numberToGuess);

        do {
            System.out.print("Længden der skal beregnes:");
            guess = keyboard.nextInt();

            if (guess > numberToGuess)
                System.out.println("For højt");
            else if (guess < numberToGuess)
                System.out.println("For lavt");

        }
        while (guess != numberToGuess);
        System.out.println("Du gættede rigtigt!");
    }
}
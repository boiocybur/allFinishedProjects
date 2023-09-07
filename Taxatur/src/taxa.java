import java.util.Scanner;

public class taxa {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Hvor lang er turen (km)?: ");
        int kilometer = keyboard.nextInt();

        System.out.print("Skal du køre om dagen (06-18) [y/n]: ");
        String dagNatAftenWeekendHelligdag = keyboard.next();

        double samledePris = 0.0;
        double timeRate = 0.0;

        if (dagNatAftenWeekendHelligdag.equals("y")) {
            // Calculate the fare for daytime (06-18)
            samledePris = 39.0 + (kilometer * 10.0) + (kilometer * 6.75);
            timeRate = 6.75;
        } else if (dagNatAftenWeekendHelligdag.equals("n")) {
            // Calculate the fare for evening/weekend/holiday (18-06)
            samledePris = 49.0 + (kilometer * 14.0) + (kilometer * 6.50);
            timeRate = 6.50;
        } else {
            System.out.println("Fejl: Ugyldigt input.");
            return;
        }

        // Output the calculated fare
        System.out.println("Taxa pris: " + samledePris + " kr.");

        // Check if there are more passengers
        System.out.print("Antal passagerer en cykel [y/n]? ");
        String additionalPassenger = keyboard.next();

        if (additionalPassenger.equals("y")) {
            samledePris += 25.0; // Additional charge for a bicycle
        }

        // Output the updated fare
        System.out.println("Samlet pris inkl. eventuel cykel: " + samledePris + " kr.");
    }
}

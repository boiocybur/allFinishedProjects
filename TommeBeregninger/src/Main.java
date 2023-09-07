import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Opretter en Scanner instans for at læse input fra brugeren
        Scanner scanner = new Scanner(System.in);

        // Opretter en variabel 'fortsæt' til at kontrollere gentagelsen af programmet
        char fortsæt = 'j';

        // Starter en while-løkke, der gentages så længe 'fortsæt' er 'j' eller 'J'
        while (fortsæt == 'j' || fortsæt == 'J') {
            // Præsentation
            System.out.println("Temperaturkonverteringsprogrammet!");
            System.out.println("Vælg c for Celsius eller f for Fahrenheit:");

            // Læser brugerens valg af skala
            char skala = scanner.next().charAt(0);

            double temperatur;
            double konverteretTemperatur;

            if (skala == 'c' || skala == 'C') {
                // Bruger valgte Celsius
                System.out.print("Indtast temperatur i Celsius: ");
                temperatur = scanner.nextDouble();
                konverteretTemperatur = celsiusToFahrenheit(temperatur);
                System.out.println("Temperaturen " + temperatur + "°C svarer til " + konverteretTemperatur + "°F.");
            } else if (skala == 'f' || skala == 'F') {
                // Bruger valgte Fahrenheit
                System.out.print("Indtast temperatur i Fahrenheit: ");
                temperatur = scanner.nextDouble();
                konverteretTemperatur = fahrenheitToCelsius(temperatur);
                System.out.println("Temperaturen " + temperatur + "°F svarer til " + konverteretTemperatur + "°C.");
            } else {
                // Hvis brugeren indtaster andet en C eller J
                System.out.println("Ugyldigt valg. Vælg enten 'c' eller 'f'.");
            }

            // Spørger brugeren, om de vil fortsætte
            System.out.print("Vil du fortsætte (j/n)? ");
            fortsæt = scanner.next().charAt(0);
        }

        // Lukker Scanner objektet udenfor while-løkken
        scanner.close();
    }

    // Metode til konvertering fra Celsius til Fahrenheit
    private static double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }

    // Metode til konvertering fra Fahrenheit til Celsius
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }
}
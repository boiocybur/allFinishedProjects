import java.text.DecimalFormat;
import java.util.Scanner;

public class BMIberegning {
    static char userInput;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.#"); // Format for single decimal place

        do {
            System.out.println("Velkommen til BMI beregneren");
            System.out.println("Indtast venligst din vægt (kg): ");
            double weight = scanner.nextDouble();
            System.out.println("Indtast venligst din højde (m): ");
            double height = scanner.nextDouble();

            double BMI = calculateBMI(weight, height);
            String formattedBMI = formatBMI(BMI, decimalFormat);
            System.out.println("Din BMI er: " + formattedBMI);
            printBMIStatus(BMI);

            System.out.println("Vil du fortsætte?: j/n");
            userInput = scanner.next().charAt(0);
        } while (userInput == 'j' || userInput == 'J');
        scanner.close();
    }

    public static double calculateBMI(double weight, double height) {
        double bmi = weight / (height * height);
        return bmi;
    }

    public static String formatBMI(double BMI, DecimalFormat decimalFormat) {
        if (BMI % 1 == 0) {
            return String.valueOf((int) BMI); // Formater til heltal
        } else {
            return decimalFormat.format(BMI); // Format med enkelt decimaltal
        }
    }

    public static void printBMIStatus(double BMI) {
        if (BMI < 18.5) {
            System.out.println("Underweight");
        } else if (BMI >= 18.5 && BMI < 25) {
            System.out.println("Normal Weight");
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
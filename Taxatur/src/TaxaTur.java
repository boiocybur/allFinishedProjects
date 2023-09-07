//TAXI prisberegner
//_______
//Hvor lang er taxa turen (km)? 10
//skal du køre om dagen (06-18) [y/n]? y
//antal passagerer en cykel [y/n]? n
// 25 kr. pr. cykel
// Betalingsbrokrydsning
// Øresundsbroen = 360 kr.
// Storebæltsbroen = 450 kr.
// Taxa pris 231.05 kr
// Taxatur priser almindelige vogne 1-4 personer
// Dagtimer [08-18] start gebyr = 39 kr. + 10 kr pr. km. + 6.75 kr pr. minut.
// Aften/weekend/helligdag [18-06] = 49 kr. + 14 kr. + 6.50 kr.
//Taxatur priser Minibusser 5-8 personer
// Dagtimer [08-18] start gebyr = 69 kr. + 14 kr. + 6.70 kr.
// Aften/weekend/helligdag = 79 kr. + 20 kr. + 7 kr.

//-------------
//lav en ny beregning [y/n]? n

import java.util.Scanner;
public class TaxaTur{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Hvor lang er turen (km)? ");
        int distance = keyboard.nextInt();
        System.out.print("Skal du køre om dagen (06-18) [y/n]? ");
        char dayNightInput = keyboard.next().charAt(0);
        boolean isDaytime = (dayNightInput == 'y' || dayNightInput == 'Y');
        boolean isNightTime = (dayNightInput == 'n' || dayNightInput == 'N');
        if (!isDaytime && !isNightTime)
            System.out.println("Enter y or n");
        System.out.print("Antal passagerer (max 8): ");
        int passengerCount = keyboard.nextInt();
        System.out.print("Antal cykler: ");
        int bikeCount = keyboard.nextInt();
        if (bikeCount > 2) {
            System.out.println("Maximum 2 cykler er tilladt.");
            keyboard.close();
            return;
        }
        double baseFare = 0;
        double distanceRate = 0;
        double timeRate = 0;
        int averageSpeed;
        if (isDaytime)
            averageSpeed = 44;
        else
            averageSpeed = 40;
        if (isDaytime && (passengerCount >= 1 && passengerCount <= 4)) {
            distanceRate = 10;
            timeRate = 6.75;
            baseFare = 39;
        }
        else if (isDaytime && (passengerCount >= 5 && passengerCount <= 8)) {
            distanceRate = 14;
            timeRate = 6.70;
            baseFare = 69;
        }
        else if (!isDaytime && (passengerCount >= 1 && passengerCount <= 4)) {
            distanceRate = 14;
            timeRate = 6.50;
            baseFare = 49;
        }
        else if (!isDaytime && (passengerCount >= 5 && passengerCount <= 8)) {
            distanceRate = 20;
            timeRate = 7;
            baseFare = 79;
        }
        else
        System.out.println("distanceRate error");
        double totalFare = baseFare + (distance * distanceRate) + (((double) distance / averageSpeed * 60) * timeRate);
        if (passengerCount >= 1 && passengerCount <= 4) {
            totalFare += bikeCount * 25.0;
        } else if (passengerCount >= 5 && passengerCount <= 8) {
            totalFare += bikeCount * 25.0;
            totalFare += distance * timeRate;
        }
        System.out.println("Taxa pris: " + totalFare + " kr");
        keyboard.close();
    }
}



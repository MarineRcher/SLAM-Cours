package Exercies;

import java.util.Scanner;
import java.util.Random;

public class Exercice3 {

    public static void main(String[] args) {

        // Generate a random number between 0 and 1000
        Random random = new Random();
        int randomNumber = random.nextInt(1000);

        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer un nombre entre 0 et 1000:");
        int userNumber = scanner.nextInt();
        int i =0 ;
        // Compare the user's number to the random number
        while (userNumber != randomNumber) {
            i++;
            if (userNumber < randomNumber) {
                System.out.println("C'est plus");
                userNumber = scanner.nextInt();
            } else {
                System.out.println("C'est moins");
                userNumber = scanner.nextInt();
            }
        }

        // Print the number of tries
        System.out.println("Nombres d'essais : " + i );

    }

}
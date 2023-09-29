package Exercies;

import java.util.Random;

public class Exercice2 {
    public static void main(String[] args) {

        Random rd = new Random();
        int nbEssais = 0;
        int nb1, nb2, nb3;
        do {
            nb1 = rd.nextInt(1000);
            nb2 = rd.nextInt(1000);
            nb3 = rd.nextInt(1000);
            nbEssais++;
        } while (!(nb1 % 2 == 0 && nb2 % 2 == 0 && nb3 % 2 != 0));

        System.out.println("Nombre d'essais nécessaires : " + nbEssais);
        System.out.println(nb1);
        System.out.println(nb2);
        System.out.println(nb3);

    }
}
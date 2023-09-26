## Exercice 1

Créer un tableau de dix chaînes de caractères puis remplir ce tableau avec des adresses e-mail. Calculer ensuite, à partir des informations présentes dans le tableau, la part de marché de chacun des fournisseurs.

Indice : dans une adresse e-mail, le nom du fournisseur est la partie située après le caractère @.

```java
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    static String[] adressesMails;
    static String[] listeFournisseurs;
    static int nombreTotalClients;
    static String[] getListeFournisseursDiff;

    static int yahoo = 0;
    static int gmail = 0;
    static int hotmail = 0;

    public static void main(String[] args) {

        System.out.println("resultat" + 4.0 / 10.0 * 100.0);

        // Initialisation du tableau des adresses mails
        adressesMails = new String[10];
        adressesMails[0] = "toto@gmail.com";
        adressesMails[1] = "toto@gmail.com";
        adressesMails[2] = "toto@gmail.com";
        adressesMails[3] = "toto@gmail.com";
        adressesMails[4] = "toto@yahoo.com";
        adressesMails[5] = "toto@yahoo.com";
        adressesMails[6] = "toto@hotmail.com";
        adressesMails[7] = "toto@hotmail.com";
        adressesMails[8] = "toto@hotmail.com";
        adressesMails[9] = "toto@hotmail.com";

        // On parcourt le tableau des adresses mails afin de recuperer la liste des fournisseurs
        for (int i = 0; i < adressesMails.length; i++) {
            // split est un tableau qui contiendra par exemple ["toto", "gmail.com"]
            String[] split = adressesMails[i].split("@");
            String fournisseur = split[1];
            System.out.println(fournisseur);

            // On va comparer la veleur de fournisseur avec celle des fournisseurs connus
            // et incrementer le compteur correspondant
            if (fournisseur.equals("gmail.com")) {
                gmail++;
            } else if (fournisseur.equals("yahoo.com")) {
                yahoo++;
            } else if (fournisseur.equals("hotmail.com")) {
                hotmail++;
            }
        }
          //pourcent
    float pourcentageGmail = (float) gmail / adressesMails.length * 100;
     float pourcentageYahoo = (float) yahoo / adressesMails.length * 100;
      float pourcentageHotmail = (float) hotmail / adressesMails.length * 100;

      System.out.println(pourcentageGmail);
    System.out.println(pourcentageYahoo);
     System.out.println(pourcentageHotmail);
    }
}
```

## Exercice 2
Générer trois nombres aléatoires compris entre 0 et 1000, puis vérifier si vous avez deux nombres pairs suivis par un nombre impair. Si ce n’est pas le cas, recommencer jusqu’à ce que vous ayez la combinaison pair, pair, impair. Afficher ensuite le nombre d’essais nécessaires pour obtenir cette combinaison.


```java
 public static void main(String[] args) {
        int nombreTentatives = 0;
        int nb1, nb2, nb3;
        Random random = new Random();

        // nous allons utiliser la boucle do while
        // pour que le code s'execute au moins une fois
        do {
            nb1 = random.nextInt(1000);
            nb2 = random.nextInt(1000);
            nb3 = random.nextInt(1000);

            nombreTentatives++;

            System.out.println("Tentative n°" + nombreTentatives);
            System.out.println("Valeur de nb1: " + nb1);
            System.out.println("Valeur de nb2: " + nb2);
            System.out.println("Valeur de nb3: " + nb3);


            // == et != sont des opérateurs de comparaison
            // on peut combiner les epxressions booléennes avec les opérateurs logiques
            // && (et) || (ou) ! (non)
        } while ( nb1 % 2 != 0 || nb2 % 2 != 0 || nb3 % 2 == 0 );


    }
```

## Excercice 3

Générer un nombre aléatoire compris entre 0 et 1000. Demander ensuite à l’utilisateur de deviner le nombre choisi par l’ordinateur. Il doit saisir un nombre compris entre 0 et 1000 lui aussi. Comparer le nombre saisi avec celui choisi par l’ordinateur et afficher sur la console « c’est plus » ou « c’est moins » selon le cas. Recommencer jusqu’à ce que l’utilisateur trouve le bon nombre. Afficher alors le nombre d’essais nécessaires pour trouver la bonne réponse.

```java
import java.util.Random;
import java.util.Scanner;

public class Exercice3 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int nombreEssais = 0;
        int nombreMystere;
        int nombreEntre = 0;
        Random rd = new Random();

        nombreMystere = rd.nextInt(1000);
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer un nombre entre 0 et 1000");
        do {
            // recuperation de l'entree clavier
            nombreEntre= sc.nextInt();
            // incrementation du nombre d'essais
            nombreEssais++;
            // verification de la valeur entree
            if (nombreEntre < nombreMystere) {
                System.out.println("C'est plus !");
            } else if (nombreEntre > nombreMystere) {
                System.out.println("C'est moins !");
            } else {
                System.out.println("Bravo, vous avez trouve le nombre mystere en " + nombreEssais + " essais !");
            }
        } while (nombreEntre != nombreMystere);
    }
}
```


## Exercice 4

Ajouter au jeu de l’exercice 3 l’affichage du temps mis par l’utilisateur pour obtenir la bonne réponse.

```java
import java.time.*;
import java.util.Scanner;
import java.util.Random;

public class Exercice4 {

    public static void main(String[] args) {

        // Generate a random number between 0 and 1000
        Random random = new Random();
        int randomNumber = random.nextInt(1000);

        // Get user input
        Scanner scanner = new Scanner(System.in);
        OffsetTime offset = OffsetTime.now();
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

        int m = offset.getMinute();

        System.out.println("Durée de : " + m + "secondes");
        // Print the number of tries
        System.out.println("Nombres d'essais : " + i );

    }

}
```

# Programmation Objet 
## Exercice 1

Créer une classe représentant un article d’un magasin de vente par correspondance. Un article est caractérisé par sa référence, sa désignation, son prix. Créer ensuite une méthode main permettant de tester le bon fonctionnement de la classe précédente. 


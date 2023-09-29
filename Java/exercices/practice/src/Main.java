/*
import ProgrammationObjet.*;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ArrayList<Article> articles = new ArrayList<Article>();
        ListeGenerique<Article> listeArticles = new ListeGenerique<Article>();
        Livre LordOfTheRings = new Livre("REF123", "Lord of the Rings", 10.99, "978-2070643028", 256, "J.R.R.Tolkien");
        ListeGenerique.ajout(LordOfTheRings.getPageCount());
        int nombreDeLivres = ListeGenerique.size();
        System.out.println(nombreDeLivres);

        Livre livre = new Livre("REF123", "Harry Potter", 10.99, "978-2070643028", 256, "J.K. Rowling");
        System.out.println(livre.getReference());
        System.out.println(livre.getDesignation());
        System.out.println(Livre.getPrix());
        System.out.println(livre.getIsbn());
        System.out.println(livre.getPageCount());
        System.out.println(livre.getAuthorName());

        Dvd dvd = new Dvd("REF456", "The Matrix", 7.99, 136, "Lana");
        System.out.println(dvd.getReference());
        System.out.println(dvd.getDesignation());
        System.out.println(Article.getPrix());
        System.out.println(dvd.getDuration());
        System.out.println(dvd.getDirectorName());

        Person person = new Person("Doe", "John", LocalDate.of(1990, 1, 1));
        System.out.println(person.getNom());
        System.out.println(person.getPrenom());
        System.out.println(person.getDateNaissance());
    }
}*/

package ProgrammationObjet;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person {
    private String nom;
    private String prenom;

    private LocalDate DatedeNaissance;

    public String getNom(){

        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){

        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }

    public int getDateNaissance( ){
        return DatedeNaissance.until(LocalDate.now()).getYears();
    }

    public void setDatedeNaissance(LocalDate DatedeNaissance){
        this.DatedeNaissance=DatedeNaissance;
    }

    public Person (String nom, String prenom, LocalDate datedeNaissance){
        this.nom=nom;
        this.prenom= prenom;
        this.DatedeNaissance=datedeNaissance;
        ArrayList<Article> articles = new ArrayList<Article>();
    }

}

package ProgrammationObjet;

public class Dvd extends Article {
    private int duration;
    private String directorName;

    public Dvd(String reference, String designation, double prix, int duration, String directorName ) {
        super(reference, designation, prix);
        this.duration = duration;
        this.directorName = directorName;
    }

    public int getDuration() {
        return duration;
    }

    public String getDirectorName() {
        return directorName;
    }
}
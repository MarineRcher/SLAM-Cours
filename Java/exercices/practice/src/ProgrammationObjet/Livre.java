package ProgrammationObjet;

public class Livre extends Article {
    private String isbn;
    private int pageCount;
    private String authorName;

    public Livre(String reference, String designation, double prix, String isbn, int pageCount, String authorName) {
        super(reference, designation, prix);
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }
}

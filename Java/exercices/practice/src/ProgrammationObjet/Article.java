package ProgrammationObjet;


public class Article {
    private String reference;
    private String designation;
    private static double prix;

    public Article(String reference, String designation, double prix) {
        this.reference = reference;
        this.designation = designation;
        Article.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public static double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Article{" +
                "reference='" + reference + '\'' +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                '}';
    }

 /* public static void main(String[] args) {
        Article article1 = new Article("123456", "T-shirt", 19.99);
        Article article2 = new Article("654321", "Jean", 29.99);

        System.out.println(article1);
        System.out.println(article2);}*/

}

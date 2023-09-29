package MariaDB;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Mariadb {
    public static void main(String[] args) {
        // Informations de connexion à la base de données
        String url = "jdbc:mariadb://localhost:3306/practice";
        String utilisateur = "userRoot";
        String motDePasse = "motdepasse";

        // Connexion à la base de données
        try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
            System.out.println("Connected to MariaDB");
            System.out.println((connection.isValid(0)) ? "Valide" : "Invalide");


            // Exécution de la requête SQL
            try (Statement statement = connection.createStatement();) {
                Scanner in = new Scanner(System.in);
                System.out.println("Entrez votre requete SQL :");
                String requete = in.nextLine();
                //String requete = "SELECT * FROM Clients";
                ResultSet resultSet = statement.executeQuery(requete);
                in.close();
                // Ouverture du fichier de sortie
                try (FileWriter writer = new FileWriter("./src/MariaDB/resultat.txt")) {
                    // Écriture des en-têtes de colonnes
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        writer.write(metaData.getColumnName(i));
                        if (i < columnCount) {
                            writer.write("\t");
                        }
                    }
                    writer.write("\n");

                    // Écriture des lignes de données
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            writer.write(resultSet.getString(i));
                            if (i < columnCount) {
                                writer.write("\t");
                            }
                        }
                        writer.write("\n");
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
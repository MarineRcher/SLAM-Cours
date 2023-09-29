package JavaSwing;
import javax.swing.SwingUtilities;
import java.awt.*;


public class Main {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->new Ecran().afficher());

    }


}
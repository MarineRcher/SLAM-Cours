package Erreurs;
import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame fenetre = new JFrame("Ma première fenêtre Java");

        fenetre.setBounds(0,0,300,100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // création des trois boutons
        JButton b1,b2,b3;
        b1=new JButton("Rouge");
        b2=new JButton("Vert");
        b3=new JButton("Bleu");
        // création du conteneur intermédiaire
        JPanel pano;
        pano=new JPanel();
        // ajout des boutons sur le conteneur intermédiaire
        pano.add(b1);
        pano.add(b2);
        pano.add(b3);
        // ajout du conteneur intermédiaire sur le ContentPane
        fenetre.getContentPane().add(pano);
        // affichage de la fenêtre
        fenetre.setVisible(true);
    }
}
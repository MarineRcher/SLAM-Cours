
package JavaSwing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class Ecran extends JFrame

{
    JPanel pano;
    JButton btnRouge,btnVert,btnBleu;
    JMenuItem mnuRouge,mnuVert,mnuBleu;
    public Ecran ()
    {
        setTitle("première fenêtre en JAVA");
        setBounds(100,100,500,250);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // création des trois boutons
        btnRouge=new JButton("Rouge");
        btnVert=new JButton("Vert");
        btnBleu=new JButton("Bleu");


        // création d'un listener
        EcouteurCouleur listener = new EcouteurCouleur();
        // association du listener à chaque bouton
        btnRouge.addActionListener(listener);
        btnVert.addActionListener(listener);
        btnBleu.addActionListener(listener);
        // Création du menu
        JMenuBar barreMenu;
        barreMenu=new JMenuBar();
        JMenu mnuCouleurs;
        mnuCouleurs=new JMenu("Couleurs");
        barreMenu.add(mnuCouleurs);

        mnuRouge=new JMenuItem("Rouge");
        mnuVert=new JMenuItem("Vert");
        mnuBleu=new JMenuItem("Bleu");
        mnuCouleurs.add(mnuRouge);
        mnuCouleurs.add(mnuVert);
        mnuCouleurs.add(mnuBleu);
        // association du listener  à chaque element du menu
        mnuRouge.addActionListener(listener);
        mnuVert.addActionListener(listener);
        mnuBleu.addActionListener(listener);
        // (le même que pour les boutons)


        // ajout du menu sur la fenêtre
        setJMenuBar(barreMenu);
        // création du conteneur intermédiaire
        pano=new JPanel();
        // ajout des boutons sur le conteneur intermédiaire
        pano.add(btnRouge);
        pano.add(btnVert);
        pano.add(btnBleu);
        // ajout du conteneur intermédiaire sur le ContentPane
        getContentPane().add(pano);
        // création d'une instance d'une classe anonyme
        // chargée de gérer les événements

        LayoutManager lm = pano.getLayout();
        if(lm instanceof FlowLayout)
        {
            // si le LayoutManager est un FlowLayout
            // on effectue un transtypage / conversion / cast
            FlowLayout fl = (FlowLayout) lm;
            fl.setAlignment(FlowLayout.LEFT);
            fl.setHgap(50);
            fl.setVgap(20);
        }
        addWindowListener(new WindowAdapter()
                          {
                              public void windowClosing(WindowEvent arg0)
                              {
                                  System.exit(0);
                              }
                          }
        );
    }
    public void afficher()
    {
        this.setVisible(true);
    }


    // creation d'une classe interne qui implémente l'interface ActionListener
    public class EcouteurCouleur implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource()==btnRouge || actionEvent.getSource()==mnuRouge)
            {
                pano.setBackground(Color.RED);
            }
            if (actionEvent.getSource()==btnVert || actionEvent.getSource()==mnuVert)
            {
                pano.setBackground(Color.GREEN);
            }
            if (actionEvent.getSource()==btnBleu || actionEvent.getSource()==mnuBleu)
            {
                pano.setBackground(Color.BLUE);
            }
        }
    }

}
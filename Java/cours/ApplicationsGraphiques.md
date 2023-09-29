# Les Applications graphiques en Java

## Les bibliothèques graphiques 
Le langage Java propose deux bibliothèques dédiées à la conception d’interfaces graphiques. La bibliothèque **AWT** et la bibliothèque **Swing**. Les principes d’utilisation sont quasiment identiques pour ces deux bibliothèques. L’utilisation simultanée de ces deux bibliothèques dans une même application peut provoquer des problèmes de fonctionnement et doit être évitée. 

Il existe une troisième bibliothèque, plus récente, nommée Java FX. Elle ne fait cependant plus partie de la plateforme Java SE standard. Ce chapitre n’abordera donc pas cette bibliothèque.

## La bibliothèque AWT
La bibliothèque AWT (Abstract Window Toolkit) est la première bibliothèque graphique proposée par Java. Elle est disponible depuis la première version du langage. 

Elle est composée de deux packages : java.awt et java.awt.event. Le **package java.awt** contient les classes de base permettant la création d’interfaces graphiques. Le **package java.awt.event** contient les classes permettant la gestion des événements.

## La bibliothèque Swing

ette bibliothèque a été conçue pour pallier les principales insuffisances de la bibliothèque AWT. Cette amélioration a été obtenue en écrivant entièrement cette bibliothèque en Java sans pratiquement faire appel aux services du système d’exploitation. Seuls quelques éléments graphiques (fenêtres et boîtes de dialogue) sont encore en relation avec le système d’exploitation. Pour les autres composants, c’est le code de la bibliothèque Swing qui détermine entièrement leurs aspects et comportements.

La bibliothèque Swing contient donc une quantité impressionnante de classes servant à redéfinir les composants graphiques. Il ne faut cependant pas penser que la bibliothèque Swing rend complètement obsolète la bibliothèque AWT. Beaucoup d’éléments de la bibliothèque AWT sont d’ailleurs repris dans la bibliothèque Swing. Nous utiliserons principalement cette bibliothèque dans le reste de ce chapitre.

#### Les composants graphiques SWING et java

La conception de l’interface graphique d’une application consiste essentiellement à créer des instances des classes représentant les différents éléments nécessaires, modifier les caractéristiques de ces instances de classe, les assembler et prévoir le code de gestion des différents événements pouvant intervenir au cours du fonctionnement de l’application. 
Une application graphique est donc constituée d’une multitude d’éléments superposés ou imbriqués. Parmi ces éléments, l’un d’entre eux joue un rôle prépondérant dans l’application. Il est souvent appelé **conteneur de premier niveau**. C’est lui qui va interagir avec le système d’exploitation et contenir tous les autres éléments. En général ce conteneur de premier niveau ne contient pas directement les composants graphiques mais d’autres conteneurs sur lesquels sont placés les composants graphiques. Pour faciliter la disposition de ces éléments les uns par rapport aux autres, nous pouvons utiliser l’aide d’un gestionnaire de mise en page. Cette superposition d’éléments peut être assimilée à une arborescence au sommet de laquelle nous avons le conteneur de premier niveau et dont les différentes branches sont constituées d’autres conteneurs. Les feuilles de l’arborescence correspondant aux composants graphiques.

Le conteneur de premier niveau étant l’élément indispensable de toute application graphique, nous allons donc commencer par étudier en détail ces caractéristiques et son utilisation puis nous étudierons les principaux composants graphiques.

#### La conception d'une interface graphique

Nous avons vu un petit peu plus haut que toute application graphique est au moins constituée d’un conteneur de premier niveau. La bibliothèque Swing dispose de trois classes permettant de jouer ce rôle :

**JApplet** : représente une fenêtre graphique embarquée à l’intérieur d’une page html pour être prise en charge par un navigateur. Cette classe n’a plus d’utilité depuis la plateforme Java 11 car la technologie des applets y a été abandonnée.

**JWindow** : représente une fenêtre graphique la plus rudimentaire qui soit. Celle-ci ne dispose pas de barre de titre, de menu système, pas de bordure, c’est en fait un simple rectangle sur l’écran. Cette classe est rarement utilisée sauf pour l’affichage d’un écran d’accueil lors du démarrage d’une application (splash screen).

**JFrame** : représente une fenêtre graphique complète et pleinement fonctionnelle. Elle dispose d’une barre de titre, d’un menu système, d’une bordure, elle peut facilement accueillir un menu, c’est bien sûr cet élément que nous allons utiliser dans la très grande majorité des cas.

Voici la hierarchie de classe de la classe JFrame :

CF image-9

Maintenant que nous sommes capables d’afficher une fenêtre, le plus gros de notre travail va consister à ajouter un contenu à la fenêtre. Avant de pouvoir ajouter quelque chose sur une fenêtre, il faut bien comprendre sa structure qui est relativement complexe. Un objet JFrame est composé de plusieurs éléments superposés jouant chacun un rôle bien spécifique dans la gestion de la fenêtre.

CF image-10

L’élément **RootPane** correspond au conteneur des trois autres éléments. 
L’élément **LayeredPane** est lui responsable de la gestion de la position des éléments aussi bien sur les axes X et Y que sur l’axe Z ce qui permet la superposition de différents éléments. 
L’élément **ContentPane** est le conteneur de base de tous les éléments ajoutés sur la fenêtre. C’est bien sûr à lui que nous allons confier les différents composants de l’interface de l’application. 
Par-dessus le ContentPane, se superpose le **GlassPane** comme on le fait avec une vitre placée sur une photo. Il présente d’ailleurs beaucoup de similitudes avec la vitre.

Il est transparent par défaut.

Ce qui est dessiné sur le GlassPane masque les autres éléments.

Il est capable d’intercepter les événements liés à la souris avant que ceux-ci n’atteignent les autres composants.

De tous ces éléments, c’est incontestablement le ContentPane que nous allons le plus utiliser. Celui-ci est accessible par la méthode **getContentPane** de la classe JFrame. Il est techniquement possible de placer des composants directement sur l’objet ContentPane mais c’est une pratique déconseillée par Oracle. Il est préférable d’intercaler un conteneur intermédiaire qui lui va contenir les composants et de placer ce conteneur sur le ContentPane. Le composant JPanel est le plus couramment utilisé dans ce rôle.

Le scénario classique de conception d’une interface graphique consiste donc à créer les différents composants puis à les placer sur un conteneur et enfin à placer ce conteneur sur le ContentPane de la fenêtre. L’exemple suivant met cela en application en créant une interface utilisateur composée de trois boutons.

```java

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
```
**getContentPane**: Récupère le conteneur de la fenêtre
**setDefaultCloseOperation** : Définit le comportement de la fenêtre lors de la fermeture  

## Les threads EDT 

Lorsqu’une application Java sans interface graphique est exécutée, au moins deux threads sont exécutés :

Le **thread principal** (le thread main) dont le rôle est d’exécuter la méthode main du programme. C’est le point d’entrée obligatoire pour l’exécution d’une application Java SE standard. Le thread du ramasse-miettes (garbage collector) pour nettoyer la mémoire lorsque celle-ci est occupée au-delà d’un certain seuil. Un thread est tout simplement une unité d’exécution d’un programme. Un programme peut être composé d’un ou plusieurs threads. L’avantage d’avoir plusieurs threads est de permettre l’exécution de plusieurs tâches en parallèle. Prenons l’exemple d’un navigateur : il est très fréquent d’effectuer une requête vers un site et, en attendant son téléchargement et son affichage, de consulter une autre page, de visionner une vidéo… Tout cela est possible grâce à l’utilisation de différents threads.

Sur une machine multiprocesseur, les différents threads peuvent effectivement s’exécuter en parallèle en exploitant les différents processeurs. Sur une machine monoprocesseur, c’est la fréquence de transition entre les différents threads qui permet à l’utilisateur de penser que les tâches s’exécutent en parallèle. En effet, le processeur partage son temps entre les différents threads. Il n’exécute qu’un seul thread à la fois, mettant en pause les autres threads pendant ce temps. Ainsi, pour exécuter la totalité d’un thread, le processeur peut s’y prendre à plusieurs fois en mettant le thread en pause à plusieurs reprises pour exécuter les autres threads.

Pour exécuter une application Java avec une interface graphique, un troisième thread entre en jeu : c’est le **thread EDT (Event Dispatching Thread)**. Ce thread est responsable de la gestion de l’interface graphique et de la gestion des événements (comme un clic sur un bouton).

Dans l’exemple précédent, l’interface graphique a été créée dans la méthode main et donc par le thread main. C’est donc le thread main qui est « propriétaire » des boutons présents sur l’interface graphique. Si l’utilisateur clique dessus, le thread EDT est sollicité pour réagir à cette action. Pour cela, le thread EDT a souvent besoin d’accéder aux éléments graphiques. Une opération inter-thread est donc nécessaire dans ce cas de figure. Et c’est là que les problèmes peuvent survenir. En effet, les composants graphiques ne sont pas thread safe. Cela signifie qu’un accès à partir d’un autre thread peut éventuellement causer un problème.

Pour éviter ce genre de situation, il est donc nécessaire de faire en sorte que seul le thread EDT manipule l’interface graphique, que ce soit pour la création de l’interface ou pour la gestion des événements. Il faut donc être capable, depuis le thread main qui exécute la méthode main, de demander au thread EDT de construire l’interface graphique de l’application. Ceci est possible par l’utilisation de la méthode invokeLater de la classe SwingUtilities. Cette méthode attend en paramètre un objet de type Runnable qui est une interface fonctionnelle contenant une seule méthode abstraite dont la signature est la suivante : void run(). Cet objet (ou cette expression lambda) définit simplement ce qui doit être exécuté par le thread EDT. Le code suivant apporte donc une modification essentielle à l’exemple précédent pour s’assurer du bon fonctionnement de l’application dans toutes les situations :

```java

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Principale {
     private JFrame fenetre;
     //Constructeur appelé par le thread EDT
     Principale(String[] args) {
         // Construction de l'IHM
         // création de la fenêtre
         this.fenetre=new JFrame();
         this.fenetre.setTitle("première fenêtre en JAVA");
         this.fenetre.setBounds(0,0,300,100);
         this.fenetre.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
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
         this.fenetre.getContentPane().add(pano);
   }

     //Méthode appelée par le thread EDT
   public void show() {
         // Affichage de l'IHM
       this.fenetre.setVisible(true);
   }

   //Point d'entrée exécuté par le thread main
   public static void main(final String[] args) {
         // Programme une tâche pour le thread EDT:
         // Création et affichage de l'interface graphique
         /*SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new Principale(args).afficher();
             }
         });*/
         SwingUtilities.invokeLater(()->
                                 new Principale(args).afficher());
   }
}
```

## Les events

### Introduction

Une interface est une classe abstraite dont toutes les méthodes sont abstraites. Elle ne peut donc pas être instanciée. Elle sert uniquement à définir un contrat entre une classe et ses utilisateurs. Ce contrat définit les méthodes que la classe doit obligatoirement implémenter. Une classe peut implémenter plusieurs interfaces. Dans ce cas, elle doit obligatoirement implémenter toutes les méthodes de toutes les interfaces qu’elle implémente. Une interface peut hériter d’une autre interface. Dans ce cas, la classe implémentant l’interface fille doit obligatoirement implémenter toutes les méthodes de l’interface mère et de l’interface fille.

```java

public interface Interface1 {
    public void methode1();
}

public interface Interface2 {
    public void methode2();
}

public interface Interface3 extends Interface1, Interface2 {
    public void methode3();
}

```


### Les événements

Il existe des types de classe ou interface qui permettent de gerer la detection des evenements, elles se terminent toutes par 'listener'.

```java
    public interface MouseMotionListener extends EventListener
    {
        void mouseDragged(MouseEvent e);
        void mouseMoved(MouseEvent e);
    }
```

Nous avons donc besoin de créer des classes implémentant ces interfaces. De ce point de vue, nous avons une multitude de possibilités :

- Créer une classe "normale" implémentant l’interface.

- Implémenter l’interface dans une classe déjà existante.

- Créer une classe interne implémentant l’interface.

- Créer une classe interne anonyme implémentant l’interface.

- Créer éventuellement une expression lambda si l’interface est une interface fonctionnelle.


# Le positionnement des composants  

## Les gestionnaires de mise en page **FlowLayout**

Ce gestionnaire de mise en page est certainement le plus simple à utiliser. Il est associé par défaut à un composant **JPanel**. Sa stratégie de placement des composants consiste à les placer les uns à la suite des autres sur une ligne jusqu’à ce qu’il n’y ait plus de place sur cette ligne. Après le remplissage de la première ligne, les composants suivants sont placés sur une nouvelle ligne et ainsi de suite. C’est l’ordre d’ajout des composants sur le conteneur qui détermine leurs positions sur les différentes lignes. Chaque composant est séparé horizontalement de son voisin par un espace de cinq pixels par défaut et chaque ligne de composants est séparée de sa voisine par un espace de cinq pixels par défaut également. Lorsque ce gestionnaire place les composants, il les aligne par défaut sur le centre du conteneur. Tous ces paramètres peuvent être modifiés pour chaque gestionnaire de mise en page FlowLayout. Vous pouvez le faire dès la création du FlowLayout en indiquant dans le constructeur les informations correspondantes. Trois constructeurs sont disponibles pour cette classe. Le premier n’attend aucun argument et crée un FlowLayout avec les caractéristiques par défaut décrites ci-dessus. Le deuxième attend comme argument une des constantes suivantes permettant de spécifier le type d’alignement utilisé.

- FlowLayout.CENTER : chaque ligne de composant est centrée dans le conteneur (valeur par défaut).

- FlowLayout.LEFT : chaque ligne de composant est alignée sur la gauche du conteneur.

- FlowLayout.RIGHT : chaque ligne de composant est alignée sur la droite du conteneur.

Le dernier constructeur disponible attend comme arguments deux entiers en plus de la constante indiquant l’alignement. Ces deux entiers indiquent l’espacement horizontal et vertical entre les composants. La ligne de code suivante crée un FlowLayout qui aligne les lignes de composants sur la gauche du conteneur, laisse un espace horizontal de cinquante pixels et un espace vertical de vingt pixels entre les composants.

```java
FlowLayout fl = new FlowLayout(FlowLayout.LEFT,50,20);
```
Si vous ne créez pas vous-même de FlowLayout mais que vous utilisez celui fourni par défaut avec un Jpanel, vous pouvez intervenir sur ces paramètres de fonctionnement avec les méthodes suivantes :

- setAlignment : pour spécifier l’alignement des composants.

- setHgap : pour spécifier l’espacement horizontal entre les composants.

- setVgap : pour spécifier l’espacement vertical entre les composants.

Il est dans ce cas nécessaire d’obtenir une référence sur le FlowLayout associé au JPanel en utilisant la méthode getLayout de celui-ci. Une opération de transtypage est dans ce cas obligatoire pour pouvoir utiliser les méthodes de la classe FlowLayout sur la référence obtenue. En effet, la méthode getLayout retourne une variable de type LayoutManager, le super-type de tous les types de gestionnaire de présentation.

```java
    //Définition des caractéristiques du LayoutManager
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
```


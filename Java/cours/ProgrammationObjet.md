# Java
## Programmation orienté objet

Les classes sont constituées de :
- Champs
- Methodes

3  concepts à comprendre :
- Encapsulation
- Heritage
- Polymorphisme

### Encapsulateur
Caches éléments non nécessaires pour l'utilisation d'un objet. 
-> Garantie que l'objet sera bien utilisé. 

Les éléments visisbles depuis l'interieur de la classe sont appelés l'interface de la classe.

### L'héritage

Permet de créer une classe à partir d'une autre classe. La classe héritée est appelée classe mère, la classe qui hérite est appelée classe fille.

### Le polymorphisme

Permet d'utiliser plusieurs classes différentes de facon interchangeable dans un programme.

Ce concept est souvent accompagné dans 2 autres concepts : **surcharge** et **substitution**.


## En java...

Les classes sont représentées sous forme de diagramme UML (Unified Modeling Language).

https://fr.wikipedia.org/wiki/UML_(informatique)

UML est un langage graphique qui permet de représenter les concepts de la programmation orientée objet. 

### Création d'une classe

La création d'une classe passe par la déclaration de la classe elle-meme et de tous les éléments la constituant.
    
    ```java
        [modificateur] class NomClass [extends NomClassMere] [implements NomInterface...] {
            // Champs
            [modificateur] type nomChamp [= valeur];
            // Methodes
            [modificateur] type nomMethode([parametres]) {
                // Corps de la methode
            }
        }
    ```

La déclaration de classe se fait en utilisant le mot clé **class** suivi du nom de la classe puis d'un bloc de code délimité par les caractères { et } . 

#### Les modificateurs

Ils permettent de modifier la visibilité d'une classe, 4 modificateurs sont possibles :  
- public : indique que la classe peut etre utilisé par ttes les autres classes. Sans ce modificateur, la classe ne peut etre utilisée que par les classes du meme package.

- private : indique que la classe ne peut etre utilisée que par les classes du meme package.

- protected : indique que la classe ne peut etre utilisée que par les classes du meme package et par les classes filles.

#### Les autres modificateurs

- package : indique que la classe ne peut etre utilisée que par les classes du meme package. Ce modificateur est implicite, utilisé par défaut si aucun modificateur n'est spécifié.  

- abstract : indique que la classe est une classe abstraite, ne peut etre instanciée. Ne peut etre utilisé que comme classe de base pour d'autres classes.

- final : indique que la classe ne peut etre utilisée comme classe de base pour d'autres classes.

```java
public class Person {
    ....
}
```


#### Les champs

La création de champs fait une syntaxe particulière :

```java
    [privae | protected | public ] typeVariable nomVariable;
``` 

Il est possible de creer des variables de classes avec le mot 'static' et des constantes avec le mot 'final'.

```java
   public class Person{
    private String name;    
    private String firstName;
    private int age;
    private static int nbPerson = 0;
    private final String pays = "France";
   }
```

Les portees :

- private : la variable est visible uniquement dans la classe
- protected : la variable est visible dans la classe et dans les classes filles, ainsi que dans le package
- public : la variable est visible partout
Si vous oubliez de preciser une portee, la portee par defaut est package.

#### Les methodes
Voici la syntaxe de creation de methodes en Java

```java
    [modificateurs] typeRetour nomMethode ([listeParametres])
                                      [throws listeException]
{

}

```

Les modificateurs sont les memes que pour les champs :
- private : la methode est visible uniquement dans la classe
- protected : la methode est visible dans la classe et dans les classes filles, ainsi que dans le package  
- public : la methode est visible partout

Des modificateurs supplémentaires existent :

- static : la methode est une methode de classe, elle peut etre appelée sans instancier la classe
- abstract : la methode ne possede pas de code, elle doit etre redéfinie avec les classes filles
- final : la methode ne peut pas etre redéfinie dans les classes filles

```java
    public class Person{
        private String name;    
        private String firstName;
        private int age;
        private static int nbPerson = 0;
        private final String pays = "France";
        private LocalDate dateNaissance;

        public Person(String name, String firstName, int age){
            this.name = name;
            this.firstName = firstName;
            this.age = age;
            nbPerson++;
        }

        public String getName(){
            return this.name;
        }

        public String getFirstName(){
            return this.firstName;
        }

        public int getAge(){
            return this.age;
        }

        public static int getNbPerson(){
            return nbPerson;
        }

        public final String getPays(){
            return this.pays;
        }

        public int calculAge(){
            if (dateNaissance != null){
                return dateNaissance.until(LocalDate.now()).getYears(); 
            } else {
                return 0;
            }   
        }
    }
```

#### Création d'accesseur (getter et setter)
La déclaration des attributs avec une visibilité privée est une bonne pratique pour respecter le principe d’encapsulation. Toutefois, cette solution est limitative puisque seul le code de la classe où ils sont déclarés peut y accéder. Pour pallier ce problème, vous devez mettre en place des accesseurs. Ce sont des fonctions ordinaires qui ont simplement pour but de rendre visibles les champs à partir de l’extérieur de la classe. Par convention, les fonctions chargées d’affecter une valeur à un champ sont nommées set suivi du nom du champ, les fonctions chargées de fournir la valeur d’un champ sont nommées get suivi du nom du champ. Si le champ est de type boolean, le préfixe get est remplacé par le préfixe is. Si un champ doit être en lecture seule, l’accesseur set ne doit pas être disponible, si un champ doit être en écriture seule alors c’est la fonction get qui doit être omise. Les accesseurs sont communément appelés getters et setters. Avec cette technique, vous pouvez contrôler l’utilisation qui sera faite des champs d’une classe. Nous pouvons donc modifier la classe Personne en y ajoutant quelques règles de gestion :

Le nom doit être en majuscules.

Le prénom doit être en minuscules.

```java
class Personne
{
    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom.toUpperCase();
    }
}
```

#### Les constructeurs 

```java
package ProgrammationObjet;

public class Person {

    private String nom;
    private String prenom;

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(String prenom){

        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }

    public Person (String nom, String prenom){
        this.nom=nom;
        this.prenom= prenom;
    }

}

```

### Les packages    

Comment créer un package ? 



```java
isitech.fr
fr.isitech

ecole-isitech.fr
fr.ecole_isitech.compta.Client

fr.ecole_isitech.reseau.Client
```
Import class Client dans une autre classe, il faut utiliser l'instruction import

```java
import fr.ecole_isitech.compta.Client;
``` 

## Les génériques

Les classes génériques :

```java
public class ListeGenerique <E>
{
   // pour stocker les éléments de la liste
   private ArrayList<E> liste;
   // pointeur de position dans la liste
   private int position;
   // nombre d'éléments de la liste
   private int nbElements;
   // constructeur avec un paramètre permettant de dimensionner
   // la liste
   public ListeGenerique(int taille)
   {
       liste=new ArrayList<E>(taille);
   }
   public void ajout(E element)
   {
       liste.add(element);
       nbElements = nbElements + 1;
   }
   public void insert(E element,int index)
   {
       // on vérifie si l'index n'est pas supérieur au nombre
       // d'éléments ou si l'index n'est pas inférieur à 0
       if (index >= nbElements || index < 0)
       {
          return;
       }
       liste.add(index,element);
       // on met à jour le nombre d'éléments
       nbElements = nbElements + 1;
   }

   public void remplace(E element,int index)
   {
       // on vérifie si l'index n'est pas supérieur au nombre
       // d'éléments ou si l'index n'est pas inférieur à 0
       if (index >= nbElements || index < 0)
       {
          return;
       }
       liste.set(index,element);
   }
   public void supprime(int index)
   {
       int i;
       // on vérifie si l'index n'est pas supérieur au nombre
       // d'éléments ou si l'index n'est pas inférieur à 0
       if (index >= nbElements || index < 0)
       {
          return;
       }
       liste.remove(index);
       // on met à jour le nombre d'éléments
       nbElements = nbElements - 1;
   }
   public E getElement(int j)
   {
      return liste.get(j);
   }
   public int getNbElements()
   {
       return nbElements;
   }
   public E premier() throws Exception
   {
       if (nbElements == 0)
       {
           throw new Exception("liste vide");
       }
       // on déplace le pointeur sur le premier élément
       position = 0;
       return liste.get(0);
   }
   public E dernier() throws Exception
   {
       if (nbElements == 0)
       {
           throw new Exception("liste vide");
       }
       // on déplace le pointeur sur le dernier élément
       position = nbElements - 1;
       return liste.get(position);
   }
   public E suivant() throws Exception
   {
       if (nbElements == 0)
       {
           throw new Exception("liste vide");
       }
       // on vérifie si on n'est pas à la fin de la liste
       if (position == nbElements - 1)
       {
           throw new Exception("pas d'element suivant");
       }
       // on déplace le pointeur sur l'élément suivant
       position = position + 1;
       return liste.get(position);
   }
   public E precedent() throws Exception
   {
       if (nbElements == 0)
       {
           throw new Exception("liste vide");
       }
       // on vérifie si on n'est pas sur le premier élément
       if (position == 0)
       {
           throw new Exception("pas d'élément précédent");
       }
       // on se déplace sur l'élément précédent
       position = position - 1;
       return liste.get(position);
   }
}
```

Voici un exemple d'utilisation de la classe generique decrite precedemment:
```java
    ListeGenerique<String> liste = new ListeGenerique<String>(10);
```


## Les collections

Les collections sont des classes qui permettent de stocker des objets. Il existe plusieurs types de collections:

Les applications ont très fréquemment besoin de manipuler de grandes quantités d’informations. De nombreuses structures sont disponibles pour faciliter la gestion de ces informations. Elles sont regroupées sous le terme collection. Comme dans la vie courante, il y a différents types de collections et de collectionneurs. Il peut y avoir des personnes qui récupèrent toutes sortes de choses, mais qui n’ont pas d’organisation particulière pour les ranger, d’autres qui sont spécialisées dans la collection de certains types d’objets, les maniaques qui prennent toutes les précautions possibles pour pouvoir retrouver à coup sûr un objet...

Le langage Java propose différentes classes permettant de mettre en place plusieurs modes de gestion.

La première solution pour gérer un ensemble d’éléments est l’utilisation de tableaux. Cette solution a été décrite dans la section Les tableaux du chapitre Bases du langage. Bien que simple à mettre en œuvre, cette solution n’est pas très souple. Son principal défaut tient au caractère fixe de la taille d’un tableau. S’il n’y a plus de place pour stocker des éléments supplémentaires, il faut créer un nouveau tableau plus grand et y transférer le contenu du tableau précédent. Cette solution, lourde à mettre en œuvre, est consommatrice de ressources.

Le langage Java propose une vaste palette d’interfaces et de classes pour gérer facilement des ensembles d’éléments. Les interfaces décrivent les fonctionnalités disponibles alors que les classes implémentent et fournissent réellement ces fonctionnalités. Suivant le mode de gestion des éléments souhaité, on utilisera bien sûr la classe la plus adaptée. Cependant, les mêmes fonctionnalités de base doivent être accessibles, quel que soit le mode de gestion. Pour assurer la présence de ces fonctionnalités indispensables dans toutes les classes, celles-ci ont été regroupées dans l’interface Collection qui est par la suite utilisée comme interface de base. La hiérarchie des interfaces est représentée sur le diagramme ci-dessous.

[!alt ../assets/image-6.png](../assets/image-6.png)   

### Les listes  

#### classe ArrayList

Cette classe est une implémentation de l’interface List. Elle permet la gestion des éléments que l’on y place de manière quasi similaire à celle disponible avec un tableau, avec en plus l’aspect dynamique. Après la création de l’instance de la classe ArrayList, les éléments peuvent y être ajoutés grâce aux méthodes add et addAll. Par défaut, ces deux méthodes ajoutent les éléments à la suite de ceux déjà présents. Une version surchargée de ces deux méthodes permet de choisir l’emplacement où les éléments sont placés. Pour cette version, il faut spécifier la position où doit avoir lieu l’ajout. La première position est à l’index 0. Si des éléments sont déjà présents, ils sont simplement décalés.

L’accès aux éléments de la liste se fait via la méthode get à laquelle on indique simplement l’index de l’élément. À l’inverse, la méthode set permet de placer un élément à la position indiquée. Il n’y a pas dans ce cas d’insertion, mais le remplacement de l’élément se trouvant déjà à cette position.

La suppression d’un élément est effectuée par la méthode remove à laquelle on indique soit l’index, soit l’élément que l’on souhaite supprimer. Dans ces deux cas, les éléments suivants sont décalés d’un cran (il n’y a jamais de "trou" dans une ArrayList). Les trois fonctions indexOf, lastIndexOf et contains effectuent la recherche d’un élément dans l’ArrayList. Les deux premières retournent l’index où l’élément a été trouvé ou -1 si aucun élément n’est trouvé. La fonction indexOf commence la recherche par le premier élément de la liste, la fonction lastIndexOf débute la recherche par la fin de la liste. La fonction contains indique simplement si l’élément est présent dans la liste, sans indication sur sa position s’il existe.

Le parcours des éléments de la liste est possible avec une boucle for ou en utilisant l’objet Iterator fourni par la méthode iterator de la classe ArrayList. Avec ces deux solutions, le parcours se fait uniquement du premier vers le dernier élément de la liste, de plus le contenu de la liste ne doit pas être modifié pendant le parcours. Un objet ListIterator, retourné par la méthode listIterator, permet plus de souplesse puisqu’il autorise les déplacements dans la liste dans les deux sens et accepte également la modification de la liste pendant le parcours. L’exemple de code ci-dessous illustre ces différentes fonctionnalités. 

```java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestArrayList {
   public static void main(String[] args) {
       // Déclaration de deux variables
       // du type de l'interface voulue
       List<Personne> liste1;
       List<Personne> liste2;
       // création des deux instances
       liste1 = new ArrayList<Personne>();
       liste2 = new ArrayList<Personne>();

       // création des personnes pour remplir la liste
       Personne p1, p2, p3, p4, p5;
       p1 = new Personne("Wayne", "John",
                            LocalDate.of(1907, 5, 26));
       p2 = new Personne("McQueen", "Steeve",
                            LocalDate.of(1930, 3, 24));
       p3 = new Personne("Lennon", "John",
                            LocalDate.of(1940, 10, 9));
       p4 = new Personne("Gibson", "Mel",
                            LocalDate.of(1956, 1, 3));
       p5 = new Personne("Willis", "Bruce",
                            LocalDate.of(1955, 3, 19));

       // ajout de quatre personnes à la liste
       liste1.add(p1);
       liste1.add(p3);
       liste1.add(p4);
       liste1.add(p5);

       // insertion d'une personne entre p1 et p3
       // donc à la position 1 de la liste
       liste1.add(1, p2);

       // ajout du contenu d'une liste à une autre liste
       // les deux listes contiennent maintenant les mêmes
       // objets.
       // !!!! ne pas confondre avec liste2=liste1; !!!
       liste2.addAll(liste1);

       // affichage du nombre d'éléments de la liste
       System.out.println("il y a " + liste1.size() +
                             " personne(s) dans la liste");

       System.out.println("Voici les personnes dans la liste 1
                             (foreach):");
       // parcours de la première liste avec la boucle foreach
       for (Personne personne : liste1) {
           System.out.println(personne.getNom());
       }

       System.out.println("Voici les personnes dans la liste 1
                             (for):");
       // parcours de la première liste avec la boucle for
       for (int index = 0; index < liste1.size(); index++) {
           System.out.println(liste1.get(index).getNom());

       }

       System.out.println("Voici les personnes dans la liste 1
                             (Iterator):");
       // parcours de la première liste du début vers la fin
       Iterator<Personne> it;
       it = liste1.iterator();
       Personne p;
       // tant qu'il reste des éléments

       while (it.hasNext()) {
           // récupération de l'élément courant
           p = it.next();
           System.out.println(p.getNom());
       }

       System.out.println("Voici les personnes dans la liste 1
                             (ListIterator):");
       // parcours de la première liste de la fin vers le
       // début
       // récupération d'un ListIterator positionné après
       // le dernier élément (le nombre d'éléments de la
       // liste)

       ListIterator<Personne> lit;
       lit = liste1.listIterator(liste1.size());
       // tant qu'il reste des éléments
       while (lit.hasPrevious()) {
           // récupération de l'élément courant
           // en remontant dans la liste
           p = lit.previous();
           System.out.println(p.getNom());
       }

       // remplacement d'un élément de liste
       liste1.set(2, new Personne("Grant", "Cary",
                        LocalDate.of(1904, 1, 18)));

       // affichage de l'élément à la troisième position de la
       // liste
       System.out.println(liste1.get(2).getNom());

       // recherche d'un élément dans la liste
       int position;
       position = liste1.indexOf(p4);
       if (position == -1)
           System.out.println("non trouvé dans la liste");
       else
           System.out.println(liste1.get(position)
                                         .getNom());

       // recherche d'un élément inexistant dans la liste.
       // John Lennon a été remplacé par Cary Grant
       // La recherche débute à la fin de la liste

       position = liste1.lastIndexOf(p3);
       if (position == -1)
           System.out.println("non trouvé dans la liste");
       else

           System.out.println(liste1.get(position)
                                         .getNom());
   }
}
```






# Introduction Java

Java existe depuis + de 20 ans et appartient à oracle (avt à Sun Microsystems). Standard en entreprise.

## Qu'est ce que JAVA
- Langage **orienté objet**
- platforme de dev : composée d'un ensemble de librairie et specifications (**JSR** : Java specification Request)
qui decrivent les APIs constituant la platforme et les outils qui permettent de **compiler**, **debugger** et **executer** les programmes ecrient en Java.

In reality there are many platforms : JAVA SE, Java EE et Java Embedded

La plateforme de base est nommée Java SE (Java Standard Edition) telle qu’indiqué précédemment. Elle répond à la plupart des besoins.
    La seconde plateforme est la plateforme Java EE. Son objectif est de permettre la création d’applications distribuées et notamment d’applications web. Cette plateforme s’appuie sur la plateforme Java SE, mais aussi sur des logiciels tiers, les serveurs d’applications.
    Depuis septembre 2017 et la version Java EE 8, la plateforme a été cédée à la fondation Eclipse. La plateforme s’appelle désormais Jakarta EE et la version actuellement disponible est Jakarta EE9.
    La dernière plateforme se nomme Java Embedded. Ce n’est pas à proprement parler une seule plateforme, mais plutôt un ensemble de plateformes. Elles permettent de réaliser des applications légères pouvant être exécutées sur des appareils embarqués. Elles sont aussi exploitées dans l’Internet des objets. Il est possible de citer plus particulièrement les plateformes Java TV et Java Card. Ce sont en quelque sorte des adaptations allégées de la plateforme Java SE.


- It's also a **execution environment** (**JRE**: Java runtime Evt). Il permet d'executer des programmes au travers de la JM
ou Java virtual Machine. Installation JRE necessary for execute java program (a dev will have to install **JDK**).

- Java est robuste, interprété, distribuer, Portable et sécurisé


## Goals in JAVA conception

-Obtenir un language et une plateforme simple et performantes dont le but est le deploiement et le dev d'appli


## Caracteristiques Java

- Simple : 3 types primitifs (peut etre manipulé en tant que valeur contrairement à un objet )qui sont les numériques, caracteres et boolean. Les types num sont tous signés.
- Les tableaux et String sont des objets
- Le dev ne s'occupe pas de la memoire. Un systeme de garbage collector est prst pour libérer le memoire.

En java tout est objet, à l'exception des types primitifs.


Les avantages de la programmation objet :
- Une bonne maitrise des codes et projets complexes

## La platerforme Java SE

CF schemaJSE

La plateforme installée sur le poste d’un développeur est le JDK (Java Development Kit). Il propose des API spécifiques, mais surtout des outils d’aide au développement comme le compilateur javac. Le JDK embarque le JRE (Java Runtime Environment).
La plateforme installée sur le poste cible (sur lequel doit s’exécuter le programme) est le JRE. Il propose l’API Java et des outils nécessaires dans l’environnement d’exécution comme l’outil java permettant de lancer l’exécution de programme Java. La JVM (Java Virtual Machine) fait partie intégrante du JRE. Elle permet l’exécution effective du programme Java passé en paramètre de l’outil java.

La machine virtuelle Java s’occupe :

du chargement des classes et du bytecode qu’elles contiennent : quand un programme invoque la création d’objets ou invoque des membres d’une classe, c’est la JVM qui s’occupe du chargement du bytecode qui doit être interprété.

de la gestion de la mémoire : la JVM s’occupe entièrement de la gestion des pointeurs et donc de chaque référence faite à un objet. Ce procédé permet également à la JVM de s’occuper de la libération automatique de la mémoire (ramasse-miettes) dès qu’un objet n’est plus référencé dans le programme, c’est-à-dire quand aucune variable n’y fait référence.

de la sécurité : c’est l’une des opérations les plus complexes effectuées par la JVM. Au chargement du programme, elle vérifie qu’il n’est pas fait appel à de la mémoire non initialisée, que des conversions de types illégales ne sont pas effectuées, que le programme ne manipule pas des pointeurs en mémoire.

de l’interfaçage avec du code natif (par exemple, code écrit en langage C) : la plupart des API de base de Java font appel à du code natif qui est fourni avec le JRE, afin d’interagir avec le système hôte. Vous pouvez également utiliser ce procédé pour des accès à des périphériques ou à des fonctionnalités qui ne sont pas implémentés directement, voire pas du tout en Java.


## Les implémentation de la plateforme JAVA SE

Deux principales :
- Oracle JDK (oracle java se: payant)
- Open JDK

## installation

- Mac :
Install avec homebrew
```bash
brew install openjdk@17
```

- Windows 
Install sur https://jdk.java.net/java-se-ri/17
Aller dans repertoire

```bash
C:\java\jdk-11.0.2
echo 'export PATH="/usr/local/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
export CPPFLAGS="-I/usr/local/opt/openjdk@17/include" 
source .zshrc 
java -version
```

Dans variable d'environnement : 
modifier **PATH** pour ajouter repertoire bin java 
```sh
%JAVA_HOME%/bin
```

## Java doc
https://www.oracle.com/java/technologies/javase-documentation.html

## Introduction 

- tous les modules commencent par java
- L'api est composée de modules

Afin d'etre execute correctement, un programme java doit etre compiler puis executé

### Compilation

La compilation d'un programme Java se fait avec la cmd **javac**. Permet de transformer le code source java en **bytecode** (binaire executable) ou langage intermediaire.

La compilation se fait avec JRE.

```bash
javac nameFichier.java
```

## premier pas 


### Les avariables

Les variables permettent de mémoriser pendant l’exécution d’une application différentes valeurs utiles à son bon fonctionnement. Avant d’utiliser des variables dans un programme, il convient de savoir où les déclarer, quel nom leur donner et quel type leur donner. C’est l’objectif des prochaines sections.

En java on peut declarer une variable a peu pres n'importe ou dans notre programme. Par contre elle doivent etre declarer obligatoirement entre les accolades d'une classe, interface ou enum.

Une variable doit obligatoirement être déclarée avant son utilisation dans le code. En fonction de l’emplacement de sa déclaration, une variable appartiendra à une des catégories suivantes :

Déclarée à l’intérieur d’une classe, la variable est une variable d’instance. Elle n’existera que si une instance de la classe est disponible (autrement dit un objet). Chaque instance de classe aura son propre exemplaire de la variable.
Déclarée à l’intérieur d’une classe avec le modificateur static, un mot-clé du langage, la variable est une variable de classe. Elle est accessible directement par le nom de la classe et n’existe qu’en un seul exemplaire, quel que soit le nombre d’objets créés à partir de cette classe.
Déclarée à l’intérieur d’une méthode, la variable est une variable locale. Elle n’existe que pendant l’exécution de la méthode et n’est accessible que par le code de celle-ci.
Les paramètres des méthodes peuvent être considérés comme des variables locales. La seule différence réside dans l’initialisation de la variable qui est effectuée lors de l’appel de celle-ci. La structure de programme suivante permet de visualiser l’emplacement de ces différentes catégories de variables :

```java

public class MyClasse {
//variable d'instance 
//pour declarer une variable il faut portee + type + nom
private int variableInstance;

//variable de classe
private static int variableClasse;

// methode 
//pour déclarer methode : portee, type retour
//nom, parametres optionnels
    public void maMethode (int parameters){
        int variableLocale = 0;
    }
}
```

nom variables : 

- Doit commencer par lettre ou underscore
- ne contient pas d'espace
- ne contient pas de caractere speciaux
- ne doit pas etre un mot cle du langage (CamelCase ou PascalCase)


Type de variables :

```java
int i = 0;
```

Il existe 2 categories de types de variables :
- types valeurs
- types refs

Les types valeurs, sont 7 catégories et on les organise en 4 catégories :
- Num entiers
- décimaux
- caracteres 
- booleens

La déclaration des variables :

```java
[modificateur] type nomVariable;
```

```java
type variable, variable1, variable2;
```

Exemple décla de variable 

```java
int i;
Date today;
String name, firstName;
```

#### Initialisation variable

```java
int i;
i=0; //initialisation
```

#### L'affectation

```java
nomVariable = nouvelleValeur;
```

## Les types valeurs en java

### Types entiers

4 types entiers :
- byte **8 bits** La valeur min est de -128 et max est 127
- short **16bits**
- int **32bits**
- long **64bits**

Quand vous choisissez un type entier prenez en compte la valeur mini et max que vous pouvez stocker dasn une variable

On peut travailler avec des entiers non signés en utilisant des classes tel que **integer** ou **Long**


### Types de décimaux

- float 32 bits
- double 64 bits

```java
public static void main(String[] args) {
        System.out.println("");
        int popFr=6700000000;
        double prctageFemme = 51.7;
        int b = 153;
        // ajouter F pour specifier
        float f = 10.1F;
        //ajouter L pour indique que c'est long
        int l = 1098403747L;
}
```

### Les types caractères

type char -> 2 octets pour stocker le code unicode du caractère

Suivi d'un autre caractère indiquant la signification de la séquence d'échappement.
Le tableau suivant représente la liste de séquence d'échappement.

```java
\b Retour arrière
\t tab 
\n saut de ligne
\f saut de page
\r retour chariot
\" guillemet
\' Apostrophe
\\ antislash
```

Les caractère unicode sont accessibles au clavier et représenté par des caractères \u suivi de la valeur.

```java
char euro = '\u20AC';
```

## Les types de références en java

Les tableaux, les chaînes de caractères, les variables complexes sont des variables de types références. 
Les tableaux permettent de gérer des ensembles de variables (souvent de même type). Les chaînes de caractères permettent de gérer des ensembles de caractères. Les variables complexes permettent elles aussi de gérer un ensemble de variables. 
Le type des variables complexes est souvent une classe. 
Par exemple, une classe Personne permet de caractériser une personne en regroupant différentes informations dans autant de variables que nécessaire : le nom (de type String), le prénom (de type String), l’âge (de type int).

### Les tableaux

La manipulation d'un tableau est divisé en 3 parties :
- Déclaration
- Création (instanciation, allocation de mémoire)
- stockage de valeurs, manipulations valeurs du tableau

#### Déclaration

```java
int [] tableauEntier;
```

#### Création

```java
tableauEntier = new int[10];
//ou encore
tableauEntier = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
```

Si on tenter d'accéder à un éléments du tableau qui n'existe pas on obtient cette erreur type :
**ArrayIndexOutOfBoundsExceptions**

### Les chaines de caractères 

Chaine de caractere = tab de caracteres

```java
String maVariable;
```

Peut etre initialiser de 2 manières
```java
maVariable = "";
//
maVariable = new String();
```

Java met à disposition des méthode pour manipuler les chaines de caractères

```java
String chaine = "chaine de caracteres";
char c = chaine.charAt(0);
```

### Les dates et les heures

Classes java pour manipuler date et heure "

- **LocalDate** pour manipuler une date
- **LocalDateTime** manipuler date et heure
- **LocalTime** manipule heure
- **offsetDateTime** manipule date et heure par rapport au fuseau horaire UTC
- **Duration** représente une durée en heures, min, sec, ms

```java
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //la classe localDate donne accès à une série de méthodes
        LocalDate noel;
        noel = LocalDate.of( 2023, 12,  25);

        System.out.println("Noel tombe un " + noel.getDayOfWeek());

        LocalDateTime maintenant;
        maintenant = LocalDateTime.now();

        LocalDate aujourdhui;
        aujourdhui = LocalDate.from(maintenant);
        System.out.println("On est le " + aujourdhui.getDayOfWeek());

    }
}
```

### Les conversions de types

Les conversions de type en Java sont automatiques ou explicites. Les conversions automatiques sont réalisées par le compilateur. Les conversions explicites sont réalisées par le programmeur.

```java
// Conversion implicite
float f = 1.44f;
double plusGrand = f;

// Conversion explicite
int jePerdsEnPrecision = (int) f;

```


